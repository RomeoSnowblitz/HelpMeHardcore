package net.romeosnowblitz.hmh2.item.custom.test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.romeosnowblitz.hmh2.block.ModBlocks;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Disc_Fragment extends Item {

    protected static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS = Maps.newHashMap(ImmutableMap.of(
            Blocks.SOUL_SAND, Pair.of(Disc_Fragment::canTillFarmland, Disc_Fragment.createTillAction(ModBlocks.SAND_SCULK.getDefaultState()))));

    public Disc_Fragment(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos;
        World world = context.getWorld();
        Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = TILLING_ACTIONS.get(world.getBlockState(blockPos = context.getBlockPos()).getBlock());
        if (pair == null) {
            return ActionResult.PASS;
        }
        Predicate<ItemUsageContext> predicate = pair.getFirst();
        Consumer<ItemUsageContext> consumer = pair.getSecond();
        if (predicate.test(context)) {
            PlayerEntity playerEntity = context.getPlayer();
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!world.isClient) {
                consumer.accept(context);
                if (playerEntity != null) {
                    context.getPlayer().playSound(SoundEvents.ENTITY_EVOKER_FANGS_ATTACK, 1.0f, 1.0f);
                    ItemStack itemStack2 = ItemUsage.exchangeStack(context.getStack(), context.getPlayer(), Items.DISC_FRAGMENT_5.getDefaultStack());
                    context.getPlayer().setStackInHand(context.getHand(), itemStack2);
                }
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }

    /**
     * {@return a tilling action that sets a block state}
     *
     * @param result the tilled block state
     */
    public static Consumer<ItemUsageContext> createTillAction(BlockState result) {
        return context -> {
            context.getWorld().setBlockState(context.getBlockPos(), result, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            context.getWorld().emitGameEvent(GameEvent.BLOCK_CHANGE, context.getBlockPos(), GameEvent.Emitter.of(context.getPlayer(), result));
        };
    }

    /**
     * {@return a tilling action that sets a block state and drops an item}
     *
     * @param droppedItem the item to drop
     * @param result the tilled block state
     */
    public static Consumer<ItemUsageContext> createTillAndDropAction(BlockState result, ItemConvertible droppedItem) {
        return context -> {
            context.getWorld().setBlockState(context.getBlockPos(), result, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            context.getWorld().emitGameEvent(GameEvent.BLOCK_CHANGE, context.getBlockPos(), GameEvent.Emitter.of(context.getPlayer(), result));
            Block.dropStack(context.getWorld(), context.getBlockPos(), context.getSide(), new ItemStack(droppedItem));
        };
    }

    /**
     * {@return whether the used block can be tilled into farmland}
     * This method is used as the tilling predicate for most vanilla blocks except rooted dirt.
     */
    public static boolean canTillFarmland(ItemUsageContext context) {
        return context.getSide() != Direction.DOWN && context.getWorld().getBlockState(context.getBlockPos().up()).isAir();
    }
}
