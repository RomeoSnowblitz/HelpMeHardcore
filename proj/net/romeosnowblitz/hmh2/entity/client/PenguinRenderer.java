/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.romeosnowblitz.hmh2.entity.client;

import javax.annotation.Nullable;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.romeosnowblitz.hmh2.entity.client.PenguinModel;
import net.romeosnowblitz.hmh2.entity.mob.PenguinEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PenguinRenderer
extends GeoEntityRenderer<PenguinEntity> {
    public PenguinRenderer(class_5617.class_5618 ctx) {
        super(ctx, (GeoModel)new PenguinModel());
    }

    public class_2960 getTextureLocation(PenguinEntity instance) {
        return new class_2960("hmh2", "textures/entity/penguin/penguin.png");
    }

    public class_1921 getRenderType(PenguinEntity animatable, class_2960 texture, @Nullable class_4597 bufferSource, float partialTick) {
        return super.getRenderType((GeoAnimatable)animatable, texture, bufferSource, partialTick);
    }
}
