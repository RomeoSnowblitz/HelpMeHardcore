package net.romeosnowblitz.hmh2.block.custom.block;

import com.google.common.collect.Lists;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.romeosnowblitz.hmh2.block.DecorationBlocks;
import net.romeosnowblitz.hmh2.block.ModBlocks;

import java.util.LinkedList;

public class LavaSponge extends Block {
    public static final int field_31250 = 6;
    public static final int field_31251 = 64;

    public LavaSponge(Settings settings) {
        super(settings);
    }
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.isOf(state.getBlock())) {
            return;
        }
        this.update(world, pos);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
    }

    protected void update(World world, BlockPos pos) {
        if (this.absorbLava(world, pos)) {
            world.setBlockState(pos, DecorationBlocks.HOT_PUMICE.getDefaultState(), Block.NOTIFY_LISTENERS);
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(Blocks.WATER.getDefaultState()));
        }
    }

    private boolean absorbLava(World world, BlockPos pos) {
        LinkedList<Pair<BlockPos, Integer>> queue = Lists.newLinkedList();
        queue.add(new Pair<BlockPos, Integer>(pos, 0));
        int i = 0;
        while (!queue.isEmpty()) {
            Pair pair = (Pair)queue.poll();
            BlockPos blockPos = (BlockPos)pair.getLeft();
            int j = (Integer)pair.getRight();
            for (Direction direction : Direction.values()) {
                BlockPos blockPos2 = blockPos.offset(direction);
                BlockState blockState = world.getBlockState(blockPos2);
                FluidState fluidState = world.getFluidState(blockPos2);
                Material material = blockState.getMaterial();
                if (!fluidState.isIn(FluidTags.LAVA)) continue;
                if (blockState.getBlock() instanceof FluidDrainable && !((FluidDrainable)((Object)blockState.getBlock())).tryDrainFluid(world, blockPos2, blockState).isEmpty()) {
                    ++i;
                    if (j >= 6) continue;
                    queue.add(new Pair<BlockPos, Integer>(blockPos2, j + 1));
                    continue;
                }
                if (blockState.getBlock() instanceof FluidBlock) {
                    world.setBlockState(blockPos2, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                    ++i;
                    if (j >= 6) continue;
                    queue.add(new Pair<BlockPos, Integer>(blockPos2, j + 1));
                    continue;
                }
                if (material != Material.UNDERWATER_PLANT && material != Material.REPLACEABLE_UNDERWATER_PLANT) continue;
                BlockEntity blockEntity = blockState.hasBlockEntity() ? world.getBlockEntity(blockPos2) : null;
                SpongeBlock.dropStacks(blockState, world, blockPos2, blockEntity);
                world.setBlockState(blockPos2, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                ++i;
                if (j >= 6) continue;
                queue.add(new Pair<BlockPos, Integer>(blockPos2, j + 1));
            }
            if (i <= 64) continue;
            break;
        }
        return i > 0;
    }
}
