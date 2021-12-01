package net.halestormxv.fabric_gemstone_additions.world.features;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.halestormxv.fabric_gemstone_additions.block.ModBlocks;
import net.halestormxv.fabric_gemstone_additions.fluids._FluidRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.noise.OctaveSimplexNoiseSampler;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Set;

public class CestriumLakeFeature extends Feature<CestriumLakeConfig> {
    public CestriumLakeFeature(Codec<CestriumLakeConfig> configCodec){
        super(configCodec);
    }

    protected static final Set<Material> unacceptableSolidMaterials = ImmutableSet.of(
            Material.BAMBOO,
            Material.LEAVES,
            Material.COBWEB,
            Material.CACTUS,
            Material.REPAIR_STATION,
            Material.GOURD,
            Material.CAKE,
            Material.EGG,
            Material.BARRIER
    );

    protected long noiseSeed;
    protected OctaveSimplexNoiseSampler noiseGen;

    public void setNoiseSeed(long seed){
        ChunkRandom sharedRandomSeed = new ChunkRandom(seed);
        if (this.noiseSeed != seed | this.noiseGen == null){
            this.noiseGen = new OctaveSimplexNoiseSampler(sharedRandomSeed, ImmutableList.of(0));
        }
        this.noiseSeed = seed;
    }

    @Override
    public boolean generate(FeatureContext<CestriumLakeConfig> context) {
        StructureWorldAccess worldAccess = context.getWorld();
        setNoiseSeed(worldAccess.getSeed());
        BlockPos topPos = context.getWorld().getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
        Direction offset = Direction.NORTH;
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(topPos.down(2)); //Goes Down 2 Blocks
        //Create the Lakes
        boolean containedFlag;
        Material material;
        BlockState blockState;
        for (int x = -2; x < 18; ++x){
            for (int z = -2; z < 18; ++z){
                int xTemp = x - 10;
                int zTemp = z - 10;
                //Circle Shape
                if (xTemp * xTemp + zTemp * zTemp < 64) {
                    double samplePerlin1 = (this.noiseGen.sample(
                            topPos.getX() + x * 0.05D,
                            topPos.getZ() + z * 0.05D,
                            true) + 1) * 3.0D;
                    for (int y = 0; y > -samplePerlin1; --y) {

                        mutable.set(topPos).move(x, y, z);

                        //Check if the Spot is Solid Around, Nothing Solid Above
                        containedFlag = checkIfValidSpot(worldAccess, mutable, samplePerlin1);

                        //Check if the Spot within the mask and contained
                        if (containedFlag) {

                            //check below
                            //set the fluid block
                            BlockState configState = context.getWorld().getBlockState(topPos);
                            worldAccess.setBlockState(mutable, configState, 3);
                            if (configState == Blocks.WATER.getDefaultState())
                                worldAccess.getFluidTickScheduler().schedule(mutable, Fluids.WATER, 0);
                            else if (configState == Blocks.LAVA.getDefaultState())
                                worldAccess.getFluidTickScheduler().schedule(mutable, Fluids.LAVA, 0);

                            //Remove Floating Plants
                            //Check above
                            blockState = worldAccess.getBlockState(mutable.move(Direction.UP));
                            material = blockState.getMaterial();

                            if (material == Material.PLANT && blockState.getBlock() != Blocks.LILY_PAD){
                                worldAccess.setBlockState(mutable, Blocks.AIR.getDefaultState(), 2);

                                //Recursively Move Up and Break Floating Sugar Cane
                                while (mutable.getY() < worldAccess.getHeight() && worldAccess.getBlockState(mutable.move(Direction.UP)) == Blocks.SUGAR_CANE.getDefaultState()) {
                                    worldAccess.setBlockState(mutable, Blocks.AIR.getDefaultState(), 2);
                                }
                            }
                            if (material == Material.REPLACEABLE_PLANT && blockState.getBlock() != Blocks.VINE){
                                worldAccess.setBlockState(mutable, Blocks.AIR.getDefaultState(), 2);
                                worldAccess.setBlockState(mutable.up(), Blocks.AIR.getDefaultState(), 2);
                            }
                            //Recursively Move Down and Replace Water with Cestrium
                            //while (mutable.getY() < worldAccess.getHeight() && worldAccess.getBlockState(mutable.move(Direction.DOWN)) == Blocks.LAVA.getDefaultState()) {
                            while (mutable.getY() < worldAccess.getHeight() && worldAccess.getBlockState(mutable.move(Direction.DOWN)) == Blocks.WATER.getDefaultState()) {
                                worldAccess.setBlockState(mutable, ModBlocks.CESTRIUM_FLUID_BLOCK.getDefaultState(), 2);
                                worldAccess.getFluidTickScheduler().schedule(mutable, _FluidRegistry.CESTRIUM_STILL, 0);
                            }
                            //while (mutable.getY() < worldAccess.getHeight() && worldAccess.getBlockState(mutable.move(Direction.DOWN)) == Blocks.LAVA.getDefaultState()) {
                            //worldAccess.setBlockState(mutable, ModBlocks.CESTRIUM_FLUID_BLOCK.getDefaultState(), 2);
                            //worldAccess.getFluidTickScheduler().schedule(mutable, _FluidRegistry.CESTRIUM_STILL, 0);
                            //}
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean checkIfValidSpot(StructureWorldAccess worldAccess, BlockPos.Mutable blockpos$Mutable, double noise) {
        Material material;
        BlockState blockState;
        // Cannot Be Under Ledge
        BlockPos.Mutable temp = new BlockPos.Mutable().set(blockpos$Mutable);
        blockState = worldAccess.getBlockState(temp.up());
        while (!blockState.getFluidState().isEmpty() && temp.getY() < 255){
            temp.move(Direction.UP);
        }
        if (!blockState.isAir() && blockState.getFluidState().isEmpty())
            return false;

        //Must be Solid Below and will return false is unacceptable solid material found
        blockState = worldAccess.getBlockState(blockpos$Mutable.down());
        material = blockState.getMaterial();
        if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) ||
                BlockTags.PLANKS.contains(blockState.getBlock())) &&
                blockState.getFluidState().isEmpty() &&
                blockState.getFluidState() != Fluids.WATER.getStill(false)){
            //blockState.getFluidState() != Fluids.LAVA.getStill(false)){
            return false;
        }
        //place water on tip
        if ((noise < 2D && worldAccess.getBlockState(blockpos$Mutable.up()).isAir())){
            int open = 0;
            for (Direction direction : Direction.Type.HORIZONTAL){
                Material material1 = worldAccess.getBlockState(blockpos$Mutable.offset(direction)).getMaterial();
                if (unacceptableSolidMaterials.contains(material1)) return false;
                if (worldAccess.getBlockState(blockpos$Mutable.offset(direction)).isAir()) open++;
            }
            if (open == 1) return true;
        }
        //Must be solid all around and will retunr false if unacceptable solid material
        for (int x2 = -1; x2 < 2; x2++) {
            for (int z2 = -1; z2 < 2; z2++) {
                blockState = worldAccess.getBlockState(blockpos$Mutable.add(x2, 0, z2));
                material = blockState.getMaterial();
                if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) ||
                        BlockTags.PLANKS.contains(blockState.getBlock())) &&
                        blockState.getFluidState().isEmpty() &&
                        blockState.getFluidState() != Fluids.WATER.getStill(false)){
                    //blockState.getFluidState() != Fluids.LAVA.getStill(false)) {
                    return false;
                }
            }
        }
        return true;
    }
}

