package net.halestormxv.fabric_gemstone_additions;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.halestormxv.fabric_gemstone_additions.block.ModBlocks;
import net.halestormxv.fabric_gemstone_additions.fluids._FluidRegistry;
import net.halestormxv.fabric_gemstone_additions.item.ModItems;
import net.halestormxv.fabric_gemstone_additions.util.ModLootInjection;
import net.halestormxv.fabric_gemstone_additions.world.OreGenEndFeatures;
import net.halestormxv.fabric_gemstone_additions.world.OreGenOverworldFeatures;
import net.halestormxv.fabric_gemstone_additions.world.features.FGADefaultBiomeFeatures;
import net.halestormxv.fabric_gemstone_additions.world.features.FGAFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

@Deprecated
public class FabricGemstoneAdditions implements ModInitializer {
	public static final String MOD_ID = "fabric_gemstone_additions";

	private final static ConfiguredSurfaceBuilder<TernarySurfaceConfig> CUSTOM_SURFACE_BUILDER_0 = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
			Blocks.BASALT.getDefaultState(),
			Blocks.GRAY_TERRACOTTA.getDefaultState(),
			Blocks.GRAVEL.getDefaultState()));

	private static final Biome CUSTOMLAND = createCustomLand();

	private static Biome createCustomLand(){
		SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addMonsters(spawnSettings, 85, 5, 100);
		DefaultBiomeFeatures.addFarmAnimals(spawnSettings);

		GenerationSettings.Builder generatorSettings = new GenerationSettings.Builder();
		generatorSettings.surfaceBuilder(CUSTOM_SURFACE_BUILDER_0);
		DefaultBiomeFeatures.addDungeons(generatorSettings);
		DefaultBiomeFeatures.addMineables(generatorSettings);
		DefaultBiomeFeatures.addLandCarvers(generatorSettings);
		DefaultBiomeFeatures.addDefaultUndergroundStructures(generatorSettings);
		FGADefaultBiomeFeatures.addLargeLake(generatorSettings);

		return (new Biome.Builder())
				.precipitation(Biome.Precipitation.RAIN)
				.category(Biome.Category.NONE)
				.depth(0.125f)
				.scale(0.05f)
				.temperature(0.8f)
				.downfall(0.4f)
				.effects((new BiomeEffects.Builder())
						.waterColor(0xb434cb)
						.waterFogColor(0x050533)
						.fogColor(0xffc0c0)
						.skyColor(0xffa977)
						.build())
				.spawnSettings(spawnSettings.build())
				.generationSettings(generatorSettings.build())
				.build();
	}

	public static final RegistryKey<Biome> CUSTOMLAND_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "custombiome"));

	@Override
	public void onInitialize() {
		Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(MOD_ID, "basalt"), CUSTOM_SURFACE_BUILDER_0);
		Registry.register(BuiltinRegistries.BIOME, CUSTOMLAND_KEY.getValue(), CUSTOMLAND);
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.TEMPERATE, 2D);
		OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.COOL, 2D);
		_FluidRegistry.registerModFluids();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootInjection.modifyLootTables();
		OreGenOverworldFeatures.registerOreGenFeatures();
		OreGenEndFeatures.registerOreGenEndFeatures();

		//Wide Cestrium Lake\\
		FGAWorldGenRegistries.registerFeatures();
		RegistryKey<ConfiguredFeature<?, ?>> cestriumLakeFeature = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "cestrium_lake_feature"));
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.RAW_GENERATION, cestriumLakeFeature);

		//BIOME FILTER METHOD TO AVOID USING MIXINS????
		/*BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(context -> { Biome biome = context.getBiome();
			return biome.getCategory() == Biome.Category.SWAMP;}), GenerationStep.Feature.LAKES,  cestriumLakeFeature);*/



		System.out.println("Intialized Gemstone Additions by HalestormXV.");
	}

	public static class FGAWorldGenRegistries{
		public static void registerFeatures(){
			FGAFeatures.init();
		}
	}
}
