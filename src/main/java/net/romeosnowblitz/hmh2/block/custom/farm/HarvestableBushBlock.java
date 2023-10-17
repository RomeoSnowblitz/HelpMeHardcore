package net.romeosnowblitz.hmh2.block.custom.farm;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.romeosnowblitz.hmh2.block.ModBlocks;
import net.romeosnowblitz.hmh2.item.SustenanceItems;

public class HarvestableBushBlock extends PlantBlock implements Fertilizable {
    public static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape SMALL_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape LARGE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public HarvestableBushBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        if(this == ModBlocks.BLUEBERRY_BUSH){return new ItemStack(SustenanceItems.BLUEBERRIES);}
        if(this == ModBlocks.STRAWBERRY_BUSH){return new ItemStack(SustenanceItems.STRAWBERRIES);}
        return new ItemStack(Items.SWEET_BERRIES);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(AGE) == 0) {return SMALL_SHAPE;} else {return state.get(AGE) < 3 ? LARGE_SHAPE : super.getOutlineShape(state, world, pos, context);}
    }

    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(AGE) < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1), 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state.with(AGE, state.get(AGE) + 1)));
        }
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.slowMovement(state, new Vec3d(0.8f, 0.75f, 0.8f));
            if (!world.isClient && state.get(AGE) > 0 && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                if (Math.abs(entity.getX() - entity.lastRenderX) >= 0.003f || Math.abs(entity.getZ() - entity.lastRenderZ) >= 0.003f) {
                    entity.damage(world.getDamageSources().sweetBerryBush(), 1.0F);
                }
            }

        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(AGE) != 3 && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (state.get(AGE) > 1) {
            if(this == ModBlocks.BLUEBERRY_BUSH){dropStack(world, pos, new ItemStack(SustenanceItems.BLUEBERRIES, 1 + world.random.nextInt(2) + (state.get(AGE) == 3 ? 1 : 0)));}
            if(this == ModBlocks.STRAWBERRY_BUSH){dropStack(world, pos, new ItemStack(SustenanceItems.STRAWBERRIES, 1 + world.random.nextInt(2) + (state.get(AGE) == 3 ? 1 : 0)));}
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES,
                    SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 1), 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state.with(AGE, 1)));
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 3;
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(AGE, Math.min(3, state.get(AGE) + 1)), 2);
    }
}