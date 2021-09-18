package net.halestormxv.fabric_gemstone_additions.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.halestormxv.fabric_gemstone_additions.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

@SuppressWarnings("FieldMayBeFinal")
public class OreGenEndFeatures {

    private static ConfiguredFeature<?, ?> END_COAL_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.COAL_ORE_END.getDefaultState(), 14))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(20);

    private static ConfiguredFeature<?, ?> END_IRON_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.IRON_ORE_END.getDefaultState(), 10))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(20);

    private static ConfiguredFeature<?, ?> END_GOLD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.GOLD_ORE_END.getDefaultState(), 9))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(2);

    private static ConfiguredFeature<?, ?> END_REDSTONE_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.REDSTONE_ORE_END.getDefaultState(), 8))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(8);

    private static ConfiguredFeature<?, ?> END_LAPIS_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.LAPIS_ORE_END.getDefaultState(), 8))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(4);

    private static ConfiguredFeature<?, ?> END_DIAMOND_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.DIAMOND_ORE_END.getDefaultState(), 4))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(1);

    private static ConfiguredFeature<?, ?> END_EMERALD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.EMERALD_ORE_END.getDefaultState(), 2))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(11);

    private static ConfiguredFeature<?, ?> END_MEMORIA_ORE = Feature.ORE
            .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.MEMORIA_ORE_END.getDefaultState(), 3))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64)))).spreadHorizontally()
            .repeat(2);

    @SuppressWarnings("deprecation")
    public static void registerOreGenEndFeatures(){
        RegistryKey<ConfiguredFeature<?, ?>> endCoalOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID,"end_coal_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endCoalOre.getValue(), END_COAL_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endCoalOre);

        RegistryKey<ConfiguredFeature<?, ?>> endIronOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "end_iron_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endIronOre.getValue(), END_IRON_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endIronOre);

        RegistryKey<ConfiguredFeature<?, ?>> endGoldOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "end_gold_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endGoldOre.getValue(), END_GOLD_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endGoldOre);

        RegistryKey<ConfiguredFeature<?, ?>> endRedstoneOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "end_redstone_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endRedstoneOre.getValue(), END_REDSTONE_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endRedstoneOre);

        RegistryKey<ConfiguredFeature<?, ?>> endLapisOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "end_lapis_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endLapisOre.getValue(), END_LAPIS_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endLapisOre);

        RegistryKey<ConfiguredFeature<?, ?>> endDiamondOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "end_diamond_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endDiamondOre.getValue(), END_DIAMOND_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endDiamondOre);

        RegistryKey<ConfiguredFeature<?, ?>> endEmeraldOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID, "end_emerald_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endEmeraldOre.getValue(), END_EMERALD_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endEmeraldOre);

        RegistryKey<ConfiguredFeature<?, ?>> endMemoriaOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(FabricGemstoneAdditions.MOD_ID,"end_memoria_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endMemoriaOre.getValue(), END_MEMORIA_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endMemoriaOre);
    }
}
