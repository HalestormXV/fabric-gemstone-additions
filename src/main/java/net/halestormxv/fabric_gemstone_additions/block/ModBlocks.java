package net.halestormxv.fabric_gemstone_additions.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.halestormxv.fabric_gemstone_additions.fluids._FluidRegistry;
import net.halestormxv.fabric_gemstone_additions.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(4.0f)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()));
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(4.0f)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()));
    public static final Block JASPER_ORE = registerBlock("jasper_ore", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(4.0f)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()));
    public static final Block CITRINE_ORE = registerBlock("citrine_ore", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(4.0f)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()));
    public static final Block TURQUOISE_ORE = registerBlock("turquoise_ore", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(4.0f)
            .luminance(10)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()));
    public static final Block MOONSTONE_ORE = registerBlock("moonstone_ore", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(4.0f)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()));
    public static final Block BLOODSTONE_ORE = registerBlock("bloodstone_ore", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(4.0f)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()));
    //----------------------------------------------------------------------------------------------------------------------------------\\
    public static final Block COAL_ORE_END = registerBlock("end_coal_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block IRON_ORE_END = registerBlock("end_iron_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block GOLD_ORE_END = registerBlock("end_gold_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block REDSTONE_ORE_END = registerBlock("end_redstone_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block LAPIS_ORE_END = registerBlock("end_lapis_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block DIAMOND_ORE_END = registerBlock("end_diamond_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(6.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block EMERALD_ORE_END = registerBlock("end_emerald_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(6.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block MEMORIA_ORE_END = registerBlock("end_memoria_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(7.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));

    //FLUID BLOCKS\\
    public static final Block CESTRIUM_FLUID_BLOCK = registerFluidBlock("cestrium_fluid_block", new FluidBlock(_FluidRegistry.CESTRIUM_STILL, FabricBlockSettings.copy(Blocks.WATER)){});




    //REGISTRY METHODS
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(FabricGemstoneAdditions.MOD_ID, name), block);
    }

    private static Block registerFluidBlock(String name, Block fluidBlock){
        registerBlockItem(name, fluidBlock);
        return Registry.register(Registry.BLOCK, new Identifier(FabricGemstoneAdditions.MOD_ID, name), fluidBlock);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(FabricGemstoneAdditions.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));
    }

    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + FabricGemstoneAdditions.MOD_ID);
    }
}
