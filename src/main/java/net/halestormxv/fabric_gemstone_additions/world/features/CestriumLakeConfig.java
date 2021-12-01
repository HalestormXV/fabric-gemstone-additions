package net.halestormxv.fabric_gemstone_additions.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record CestriumLakeConfig(IntProvider height, BlockStateProvider block) implements FeatureConfig {
    public static final Codec<CestriumLakeConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.VALUE_CODEC.fieldOf("height").forGetter(CestriumLakeConfig::height),
            BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(CestriumLakeConfig::block)
    ).apply(instance, instance.stable(CestriumLakeConfig::new)));
}
