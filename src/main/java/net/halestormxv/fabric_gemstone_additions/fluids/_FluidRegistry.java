package net.halestormxv.fabric_gemstone_additions.fluids;

import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class _FluidRegistry {
    public static FlowableFluid CESTRIUM_STILL;
    public static FlowableFluid CESTRIUM_FLOWING;

    public static void registerModFluids(){
        CESTRIUM_STILL = Registry.register(Registry.FLUID, new Identifier(FabricGemstoneAdditions.MOD_ID, "cestrium"), new CestriumFluid.Still());
        CESTRIUM_FLOWING = Registry.register(Registry.FLUID, new Identifier(FabricGemstoneAdditions.MOD_ID, "flowing_cestrium"), new CestriumFluid.Flowing());
        System.out.println("Registering Fluids for " + FabricGemstoneAdditions.MOD_ID);
    }

}
