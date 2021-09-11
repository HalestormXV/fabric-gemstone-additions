package net.halestormxv.fabric_gemstone_additions;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.halestormxv.fabric_gemstone_additions.block.ModBlocks;
import net.halestormxv.fabric_gemstone_additions.item.ModItems;
import net.halestormxv.fabric_gemstone_additions.util.ModLootInjection;
import net.halestormxv.fabric_gemstone_additions.world.OreGenFeatures;


public class FabricGemstoneAdditions implements ModInitializer {

	public static final String MOD_ID = "fabric_gemstone_additions";



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootInjection.modifyLootTables();
		OreGenFeatures.registerOreGenFeatures();

		System.out.println("Intialized Gemstone Additions by HalestormXV.");
	}
}
