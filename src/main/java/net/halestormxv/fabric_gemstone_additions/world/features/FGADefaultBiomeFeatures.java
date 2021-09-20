package net.halestormxv.fabric_gemstone_additions.world.features;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;

public class FGADefaultBiomeFeatures {

    public static void addLargeLake(GenerationSettings.Builder gen){
        gen.feature(GenerationStep.Feature.RAW_GENERATION, FGAConfiguredFeatures.CESTRIUM_LAKE_FEATURE);

    }
}
