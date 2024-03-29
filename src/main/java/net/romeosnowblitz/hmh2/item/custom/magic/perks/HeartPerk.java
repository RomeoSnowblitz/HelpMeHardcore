/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1738
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1741
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 */
package net.romeosnowblitz.hmh2.item.custom.magic.perks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.romeosnowblitz.hmh2.effect.CustomEffects;
import net.romeosnowblitz.hmh2.item.WarfareItems;

public class HeartPerk
extends ArmorItem {
    public HeartPerk(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (ServerPlayerEntity)entity;
            ItemStack headPiece = player.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chestPiece = player.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack legPiece = player.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack footPiece = player.getEquippedStack(EquipmentSlot.FEET);
            if (headPiece.isOf(WarfareItems.FUR_HELMET) || chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) || legPiece.isOf(WarfareItems.FUR_LEGGINGS) || footPiece.isOf(WarfareItems.FUR_BOOTS)) {
                player.addStatusEffect(new StatusEffectInstance(CustomEffects.LUNAR_WOLF_PERCEPTION, 60, 0, false, false, true));
            }
            if (headPiece.isOf(WarfareItems.FUR_HELMET) && chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) || headPiece.isOf(WarfareItems.FUR_HELMET) && legPiece.isOf(WarfareItems.FUR_LEGGINGS) || headPiece.isOf(WarfareItems.FUR_HELMET) && footPiece.isOf(WarfareItems.FUR_BOOTS) || chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) && legPiece.isOf(WarfareItems.FUR_LEGGINGS) || chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) && footPiece.isOf(WarfareItems.FUR_BOOTS) || legPiece.isOf(WarfareItems.FUR_LEGGINGS) && footPiece.isOf(WarfareItems.FUR_BOOTS)) {
                player.addStatusEffect(new StatusEffectInstance(CustomEffects.LUNAR_WOLF_PERCEPTION, 60, 1, false, false, true));
            }
            if (chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) && legPiece.isOf(WarfareItems.FUR_LEGGINGS) && footPiece.isOf(WarfareItems.FUR_BOOTS) || headPiece.isOf(WarfareItems.FUR_HELMET) && legPiece.isOf(WarfareItems.FUR_LEGGINGS) && footPiece.isOf(WarfareItems.FUR_BOOTS) || headPiece.isOf(WarfareItems.FUR_HELMET) && chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) && footPiece.isOf(WarfareItems.FUR_BOOTS) || headPiece.isOf(WarfareItems.FUR_HELMET) && chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) && legPiece.isOf(WarfareItems.FUR_LEGGINGS)) {
                player.addStatusEffect(new StatusEffectInstance(CustomEffects.LUNAR_WOLF_PERCEPTION, 60, 2, false, false, true));
            }
            if (headPiece.isOf(WarfareItems.FUR_HELMET) && chestPiece.isOf(WarfareItems.FUR_CHESTPLATE) && legPiece.isOf(WarfareItems.FUR_LEGGINGS) && footPiece.isOf(WarfareItems.FUR_BOOTS)) {
                player.addStatusEffect(new StatusEffectInstance(CustomEffects.LUNAR_WOLF_PERCEPTION, 60, 3, false, false, true));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}

