package net.halestormxv.fabric_gemstone_additions.world.structures;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
/*
public class Structure1 extends StructureFeature<DefaultFeatureConfig> {

    public Structure1(Codec<DefaultFeatureConfig> codec){
        super(codec);
    }

    public StructureFeature.StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory(){
        return Start::new;
    }

    public static class Start extends StructureStart<DefaultFeatureConfig>{
        public Start(StructureFeature<DefaultFeatureConfig> feature, ChunkPos pos, int references, long seed) {
            super(feature, pos, references, seed);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, DefaultFeatureConfig config, HeightLimitView world) {
            int x = pos.getCenterX() * 16;
            int z = pos.getCenterZ() * 16;
            int y = chunkGenerator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG, world);
            BlockPos blockPos = new BlockPos(x, y, z);
            BlockRotation rotation = BlockRotation.random(this.random);
            MyGenerator.addPieces(manager, blockPos, rotation, this.children);
            this.setBoundingBoxFromChildren();
        }
    }
}
*/