package net.halestormxv.fabric_gemstone_additions.world.features;

import net.halestormxv.fabric_gemstone_additions.world.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;

import java.util.ArrayList;
import java.util.List;

public class FGAFeatures {

    public static List<Feature<?>> features = new ArrayList<>();

    //Cestrium Lake
    public static final Feature<SimpleBlockFeatureConfig> CESTRIUM_LAKE = WorldGenRegistrationHelper.createFeature("cestrium_lake_feature", new CestriumLake(SimpleBlockFeatureConfig.CODEC.stable()));

    public static void init(){

    }
}
