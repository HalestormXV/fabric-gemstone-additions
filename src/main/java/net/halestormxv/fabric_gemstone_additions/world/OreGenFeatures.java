package net.halestormxv.fabric_gemstone_additions.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.halestormxv.fabric_gemstone_additions.block.ModBlocks;

@SuppressWarnings("FieldMayBeFinal")
public class OreGenFeatures {
    //Ruby Ore Generation Features
    private static ConfiguredFeature<?, ?> ORE_RUBY_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.RUBY_ORE.getDefaultState(),
                    6)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(14)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(20); // Number of veins per chunk

    //Citrine Ore Generation Features
    private static ConfiguredFeature<?, ?> ORE_CITRINE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.CITRINE_ORE.getDefaultState(),
                    8)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(18), YOffset.fixed(42)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(18); // Number of veins per chunk

    //Jasper Ore Generation Features
    private static ConfiguredFeature<?, ?> ORE_JASPER_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.JASPER_ORE.getDefaultState(),
                    9)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(20); // Number of veins per chunk

    //Sapphire Ore Generation Features
    private static ConfiguredFeature<?, ?> ORE_SAPPHIRE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.SAPPHIRE_ORE.getDefaultState(),
                    7)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(24), YOffset.fixed(128)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(16); // Number of veins per chunk

    //Turquoise Ore Generation Features
    private static ConfiguredFeature<?, ?> ORE_TURQUOISE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.TURQUOISE_ORE.getDefaultState(),
                    12)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(58)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(18); // Number of veins per chunk

    //Bloodstone Ore Generation Features
    private static ConfiguredFeature<?, ?> ORE_BLOODSTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.BLOODSTONE_ORE.getDefaultState(),
                    5)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(12)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(8); // Number of veins per chunk

    //Moonstone Ore Generation Features
    private static ConfiguredFeature<?, ?> ORE_MOONSTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.MOONSTONE_ORE.getDefaultState(),
                    5)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(72), YOffset.fixed(116)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(8); // Number of veins per chunk


    public static void registerOreGenFeatures(){
        //Ruby World Gen
        RegistryKey<ConfiguredFeature<?, ?>> oreRubyOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "ore_ruby_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreRubyOverworld.getValue(), ORE_RUBY_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreRubyOverworld);

        //Citrine World Gen
        RegistryKey<ConfiguredFeature<?, ?>> oreCitrineOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "ore_citrine_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCitrineOverworld.getValue(), ORE_CITRINE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreCitrineOverworld);

        //Jasper World Gen
        RegistryKey<ConfiguredFeature<?, ?>> oreJasperOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "ore_jasper_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreJasperOverworld.getValue(), ORE_JASPER_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreJasperOverworld);

        //Sapphire World Gen
        RegistryKey<ConfiguredFeature<?, ?>> oreSapphireOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "ore_sapphire_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSapphireOverworld.getValue(), ORE_SAPPHIRE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreSapphireOverworld);

        //Turquoise World Gen
        RegistryKey<ConfiguredFeature<?, ?>> oreTurquoiseOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "ore_turquoise_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreTurquoiseOverworld.getValue(), ORE_TURQUOISE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(context -> { Biome biome = context.getBiome();
            return biome.getCategory() == Biome.Category.OCEAN;}), GenerationStep.Feature.UNDERGROUND_ORES, oreTurquoiseOverworld);

        //Bloodstone World Gen
        RegistryKey<ConfiguredFeature<?, ?>> oreBloodstoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "ore_bloodstone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreBloodstoneOverworld.getValue(), ORE_BLOODSTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreBloodstoneOverworld);

        //Moonstone World Gen
        RegistryKey<ConfiguredFeature<?, ?>> oreMoonstoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "ore_moonstone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreMoonstoneOverworld.getValue(), ORE_MOONSTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreMoonstoneOverworld);
    }
}
