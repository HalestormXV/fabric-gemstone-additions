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
import net.halestormxv.fabric_gemstone_additions.world.features.CestriumLakeConfig;
import net.halestormxv.fabric_gemstone_additions.world.features.CestriumLakeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

@SuppressWarnings("deprecated")
public class FabricGemstoneAdditions implements ModInitializer {
	public static final String MOD_ID = "fabric_gemstone_additions";

	// STRUCTURES \\
	private static final Feature<CestriumLakeConfig> CESTRIUM_LAKE = new CestriumLakeFeature(CestriumLakeConfig.CODEC);
	public static final ConfiguredFeature<?, ?> CESTRIUM_LAKE_FEATURE = CESTRIUM_LAKE.configure(new CestriumLakeConfig(ConstantIntProvider.create(3), new SimpleBlockStateProvider(Blocks.STONE.getDefaultState())))
			.decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
			.spreadHorizontally()
			.applyChance(85);


	// BIOMES SECTION \\
	private final static ConfiguredSurfaceBuilder<TernarySurfaceConfig> CUSTOM_SURFACE_BUILDER_0 = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
			Blocks.MYCELIUM.getDefaultState(),
			Blocks.STONE.getDefaultState(),
			Blocks.TERRACOTTA.getDefaultState()));

	private static final Biome CUSTOMLAND = createCustomLand();

	private static Biome createCustomLand(){
		SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addMonsters(spawnSettings, 85, 5, 100);
		DefaultBiomeFeatures.addFarmAnimals(spawnSettings);

		GenerationSettings.Builder generatorSettings = new GenerationSettings.Builder();
		generatorSettings.surfaceBuilder(CUSTOM_SURFACE_BUILDER_0);
		DefaultBiomeFeatures.addInfestedStone(generatorSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(generatorSettings);
		DefaultBiomeFeatures.addMushroomFieldsFeatures(generatorSettings);
		DefaultBiomeFeatures.addDesertLakes(generatorSettings);
		DefaultBiomeFeatures.addDungeons(generatorSettings);
		DefaultBiomeFeatures.addMineables(generatorSettings);
		DefaultBiomeFeatures.addLandCarvers(generatorSettings);
		DefaultBiomeFeatures.addDefaultUndergroundStructures(generatorSettings);

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
		//Biomes Registration
		Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(MOD_ID, "basalt"), CUSTOM_SURFACE_BUILDER_0);
		Registry.register(BuiltinRegistries.BIOME, CUSTOMLAND_KEY.getValue(), CUSTOMLAND);
		OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.TEMPERATE, 2D);
		OverworldBiomes.addContinentalBiome(CUSTOMLAND_KEY, OverworldClimate.COOL, 2D);
		//Mod Stuffs Registration
		_FluidRegistry.registerModFluids();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootInjection.modifyLootTables();
		OreGenOverworldFeatures.registerOreGenFeatures();
		OreGenEndFeatures.registerOreGenEndFeatures();
		Registry.register(Registry.FEATURE, new Identifier(MOD_ID, "cestrium_lake"), CESTRIUM_LAKE);

		RegistryKey<ConfiguredFeature<?, ?>> cestriumLake = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, "cestrium_lake_feature"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cestriumLake.getValue(),CESTRIUM_LAKE_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.SURFACE_STRUCTURES, cestriumLake);
		System.out.println("Intialized Gemstone Additions by HalestormXV.");
	}
}

//BIOME FILTER METHOD TO AVOID USING MIXINS????
		/*BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(context -> { Biome biome = context.getBiome();
			return biome.getCategory() == Biome.Category.SWAMP;}), GenerationStep.Feature.LAKES,  cestriumLakeFeature);*/
