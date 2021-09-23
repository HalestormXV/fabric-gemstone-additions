package net.halestormxv.fabric_gemstone_additions.world.features;

import net.halestormxv.fabric_gemstone_additions.world.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class FGAConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> CESTRIUM_LAKE_FEATURE = WorldGenRegistrationHelper.createConfiguredFeature("cestrium_lake_feature",
                            FGAFeatures.CESTRIUM_LAKE.configure(new SimpleBlockFeatureConfig(new SimpleBlockStateProvider(Blocks.WATER.getDefaultState())))
            .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(100))));
}
