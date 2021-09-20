package net.halestormxv.fabric_gemstone_additions.mixin;

import net.halestormxv.fabric_gemstone_additions.world.features.FGAConfiguredFeatures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class BiomeFeaturesMixin {
    @Inject(method = "addPlainsFeatures(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at =@At("TAIL"))
    private static void addPlainsFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.RAW_GENERATION, FGAConfiguredFeatures.CESTRIUM_LAKE_FEATURE);
    }
}
