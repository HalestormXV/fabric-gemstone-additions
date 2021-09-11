package net.halestormxv.fabric_gemstone_additions.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.halestormxv.fabric_gemstone_additions.item.ModItemGroup;
import net.minecraft.block.Block;
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

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(FabricGemstoneAdditions.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(FabricGemstoneAdditions.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));
    }

    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + FabricGemstoneAdditions.MOD_ID);
    }
}
