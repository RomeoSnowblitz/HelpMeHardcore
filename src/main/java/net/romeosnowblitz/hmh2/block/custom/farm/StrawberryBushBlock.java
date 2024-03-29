package net.romeosnowblitz.hmh2.block.custom.farm;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.romeosnowblitz.hmh2.item.ModItems;

import java.util.Random;

public class StrawberryBushBlock extends SweetBerryBushBlock {
    public StrawberryBushBlock(Settings settings) {
            super(settings);
            this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
        }

    private static final float field_31260 = 0.003f;
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape SMALL_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
    private static final VoxelShape LARGE_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);


    @Override
        public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
            return new ItemStack(ModItems.STRAWBERRIES);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            if (state.get(AGE) == 0) {
                return SMALL_SHAPE;
            }
            if (state.get(AGE) < 3) {
                return LARGE_SHAPE;
            }
            return super.getOutlineShape(state, world, pos, context);
        }

        @Override
        public boolean hasRandomTicks(BlockState state) {
            return state.get(AGE) < 3;
        }


        public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            int i = state.get(AGE);
            if (i < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
                world.setBlockState(pos, (BlockState)state.with(AGE, i + 1), Block.NOTIFY_LISTENERS);
            }
        }

        @Override
        public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
            if (!(entity instanceof LivingEntity) || entity.getType() == EntityType.FOX || entity.getType() == EntityType.BEE) {
                return;
            }
            entity.slowMovement(state, new Vec3d(0.8f, 0.75, 0.8f));
            if (!(world.isClient || state.get(AGE) <= 0 || entity.lastRenderX == entity.getX() && entity.lastRenderZ == entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);
                if (d >= (double)0.003f || e >= (double)0.003f) {
                    entity.damage(world.getDamageSources().sweetBerryBush(), 1.0f);
                }
            }
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand
        hand, BlockHitResult hit) {
            boolean bl;
            int i = state.get(AGE);
            boolean bl2 = bl = i == 3;
            if (!bl && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
                return ActionResult.PASS;
            }
            if (i > 1) {
                int j = 1 + world.random.nextInt(2);
                SweetBerryBushBlock.dropStack(world, pos, new ItemStack(ModItems.STRAWBERRIES, j + (bl ? 1 : 0)));
                world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                world.setBlockState(pos, (BlockState)state.with(AGE, 1), Block.NOTIFY_LISTENERS);
                return ActionResult.success(world.isClient);
            }
            return super.onUse(state, world, pos, player, hand, hit);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(AGE);
        }

        @Override
        public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
            return (Integer)state.get(AGE) < 3;
        }

        public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
            return true;
        }

        public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
            int i = Math.min(3, state.get(AGE) + 1);
            world.setBlockState(pos, (BlockState)state.with(AGE, i), Block.NOTIFY_LISTENERS);
        }
}
