package net.halestormxv.fabric_gemstone_additions.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item SAPPHIRE = registerItem("sapphire",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item JASPER = registerItem("jasper",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item CITRINE = registerItem("citrine",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item TURQUOISE = registerItem("turquoise",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item MOONSTONE = registerItem("moonstone",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item BLOODSTONE = registerItem("bloodstone",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item MEMORIA_INGOT = registerItem("memoria_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item DIAMOND_PASTE = registerItem("diamond_paste",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item UNCURED_GRINDING_BOWEL = registerItem("uncured_grinding_bowl",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item CURED_GRINDING_BOWEL = registerItem("cured_grinding_bowl",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item EMERALD_TEAR = registerItem("emerald_tear",
            new Item(new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FabricGemstoneAdditions.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("Registering Mod Items for " + FabricGemstoneAdditions.MOD_ID);
    }
}
