/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_1309
 *  net.minecraft.class_4081
 */
package net.romeosnowblitz.hmh2.effect;

import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_4081;
import net.romeosnowblitz.hmh2.effect.CustomEffects;

public class InsusceptibilityEffect
extends class_1291 {
    public InsusceptibilityEffect(class_4081 statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public void method_5572(class_1309 entity, int amplifier) {
        if (this == CustomEffects.INSUSCEPTIBILITY && entity.method_6059(class_1294.field_5916)) {
            entity.method_6016(class_1294.field_5916);
        }
    }

    public boolean method_5552(int duration, int amplifier) {
        return this == CustomEffects.INSUSCEPTIBILITY;
    }
}

