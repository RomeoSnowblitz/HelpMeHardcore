package net.romeosnowblitz.hmh2.world.feature.jewels;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.romeosnowblitz.hmh2.block.MagicBlocks;
import net.romeosnowblitz.hmh2.block.MagicBlocks;
import net.romeosnowblitz.hmh2.world.feature.ModConfiguredFeatures;

import java.util.List;

public class ModJewelsConfiguredFeatures extends ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_AMBER = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.AMBER_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_AMBER_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> AMBER =
            ConfiguredFeatures.register("amber", Feature.ORE, new OreFeatureConfig(OVERWORLD_AMBER, 4));

    public static final List<OreFeatureConfig.Target> OVERWORLD_ANDALUSITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.ANDALUSITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_ANDALUSITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ANDALUSITE =
            ConfiguredFeatures.register("andalusite", Feature.ORE, new OreFeatureConfig(OVERWORLD_ANDALUSITE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_AQUAMARINE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.AQUAMARINE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_AQUAMARINE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> AQUAMARINE =
            ConfiguredFeatures.register("aquamarine", Feature.ORE, new OreFeatureConfig(OVERWORLD_AQUAMARINE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_CHARCOAL = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.CHARCOAL_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_CHARCOAL_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CHARCOAL =
            ConfiguredFeatures.register("charcoal", Feature.ORE, new OreFeatureConfig(OVERWORLD_CHARCOAL, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_CITRINE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.CITRINE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_CITRINE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CITRINE =
            ConfiguredFeatures.register("citrine", Feature.ORE, new OreFeatureConfig(OVERWORLD_CITRINE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_DIOPSIDE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.DIOPSIDE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_DIOPSIDE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DIOPSIDE =
            ConfiguredFeatures.register("diopside", Feature.ORE, new OreFeatureConfig(OVERWORLD_DIOPSIDE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_GARNET = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.GARNET_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_GARNET_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> GARNET =
            ConfiguredFeatures.register("garnet", Feature.ORE, new OreFeatureConfig(OVERWORLD_GARNET, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_HESSONITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.HESSONITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_HESSONITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> HESSONITE =
            ConfiguredFeatures.register("hessonite", Feature.ORE, new OreFeatureConfig(OVERWORLD_HESSONITE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_MALICHITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.MALICHITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_MALICHITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MALICHITE =
            ConfiguredFeatures.register("malichite", Feature.ORE, new OreFeatureConfig(OVERWORLD_MALICHITE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_MOONSTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.MOONSTONE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_MOONSTONE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MOONSTONE =
            ConfiguredFeatures.register("moonstone", Feature.ORE, new OreFeatureConfig(OVERWORLD_MOONSTONE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_OPAL = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.OPAL_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_OPAL_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> OPAL =
            ConfiguredFeatures.register("opal", Feature.ORE, new OreFeatureConfig(OVERWORLD_OPAL, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_PERIDOT = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.PERIDOT_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_PERIDOT_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PERIDOT =
            ConfiguredFeatures.register("peridot", Feature.ORE, new OreFeatureConfig(OVERWORLD_PERIDOT, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_PREHNITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.PREHNITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_PREHNITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PREHNITE =
            ConfiguredFeatures.register("prehnite", Feature.ORE, new OreFeatureConfig(OVERWORLD_PREHNITE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_RUBY = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.RUBY_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> RUBY =
            ConfiguredFeatures.register("ruby", Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SAPPHIRE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.SAPPHIRE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SAPPHIRE =
            ConfiguredFeatures.register("sapphire", Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SMOKY_QUARTZ = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.SMOKY_QUARTZ_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_SMOKY_QUARTZ_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SMOKY_QUARTZ =
            ConfiguredFeatures.register("smoky_quartz", Feature.ORE, new OreFeatureConfig(OVERWORLD_SMOKY_QUARTZ, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SPESSARITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.SPESSARITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_SPESSARITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SPESSARITE =
            ConfiguredFeatures.register("spessarite", Feature.ORE, new OreFeatureConfig(OVERWORLD_SPESSARITE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SPHENE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.SPHENE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_SPHENE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SPHENE =
            ConfiguredFeatures.register("sphene", Feature.ORE, new OreFeatureConfig(OVERWORLD_SPHENE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SPINEL = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.SPHENE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_SPINEL_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SPINEL =
            ConfiguredFeatures.register("spinel", Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_TANZANITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.TANZANITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_TANZANITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TANZANITE =
            ConfiguredFeatures.register("tanzanite", Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_TOPAZ = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.TOPAZ_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_TOPAZ_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TOPAZ =
            ConfiguredFeatures.register("topaz", Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_TORMALINE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.TORMALINE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_TORMALINE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TORMALINE =
            ConfiguredFeatures.register("", Feature.ORE, new OreFeatureConfig(OVERWORLD_TORMALINE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_TSAVORITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.TSAVORITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_TSAVORITE_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TSAVORITE =
            ConfiguredFeatures.register("tsavorite", Feature.ORE, new OreFeatureConfig(OVERWORLD_TSAVORITE, 3));

    public static final List<OreFeatureConfig.Target> OVERWORLD_ZIRCON = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MagicBlocks.ZIRCON_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MagicBlocks.DEEPSLATE_ZIRCON_ORE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ZIRCON =
            ConfiguredFeatures.register("zircon", Feature.ORE, new OreFeatureConfig(OVERWORLD_ZIRCON, 3));
}
