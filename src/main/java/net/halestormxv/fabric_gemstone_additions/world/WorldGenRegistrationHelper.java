package net.halestormxv.fabric_gemstone_additions.world;

import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.halestormxv.fabric_gemstone_additions.world.features.FGAFeatures;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class WorldGenRegistrationHelper {

    public static <C extends FeatureConfig, F extends Feature<C>> F createFeature(String id, F feature){
        Identifier fgaID = new Identifier(FabricGemstoneAdditions.MOD_ID, id);
        if(Registry.FEATURE.getIds().contains(fgaID))
            throw new IllegalStateException("Feature ID: \"" + fgaID.toString() + "\" already exists in registry.");

        Registry.register(Registry.FEATURE, fgaID, feature);
        FGAFeatures.features.add(feature);
        return feature;
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature){
        Identifier fgaID = new Identifier(FabricGemstoneAdditions.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(fgaID))
            throw new IllegalStateException("Configured Feature ID: \"" + fgaID.toString() + "\" already exists in registry.");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, fgaID, configuredFeature);
        return configuredFeature;
    }
}
