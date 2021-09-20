package net.halestormxv.fabric_gemstone_additions.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.halestormxv.fabric_gemstone_additions.fluids._FluidRegistry;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.*;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

public class ModItems{

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

    public static final Item OBSIDIAN_STICK = registerItem("obsidian_stick",
            new Item (new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS)));

    public static final Item MORTAR_AND_PESTLE = registerItem("mortar_and_pestle",
            new Item (new FabricItemSettings().group(ModItemGroup.GS_ADDITIONS).maxDamage(3122)));

    //Gemstone Dusts
    public static final Item RUBY_DUST = registerItem("ruby_dust",
            new Item(new FabricItemSettings().recipeRemainder(MORTAR_AND_PESTLE).group(ModItemGroup.GS_ADDITIONS)));

    public static final Item SAPPHIRE_DUST = registerItem("sapphire_dust",
            new Item(new FabricItemSettings().recipeRemainder(MORTAR_AND_PESTLE).group(ModItemGroup.GS_ADDITIONS)));

    public static final Item JASPER_DUST = registerItem("jasper_dust",
            new Item(new FabricItemSettings().recipeRemainder(MORTAR_AND_PESTLE).group(ModItemGroup.GS_ADDITIONS)));

    public static final Item CITRINE_DUST = registerItem("citrine_dust",
            new Item(new FabricItemSettings().recipeRemainder(MORTAR_AND_PESTLE).group(ModItemGroup.GS_ADDITIONS)));

    public static final Item TURQUOISE_DUST = registerItem("turquoise_dust",
            new Item(new FabricItemSettings().recipeRemainder(MORTAR_AND_PESTLE).group(ModItemGroup.GS_ADDITIONS)));

    public static final Item MOONSTONE_DUST = registerItem("moonstone_dust",
            new Item(new FabricItemSettings().recipeRemainder(MORTAR_AND_PESTLE).group(ModItemGroup.GS_ADDITIONS)));

    public static final Item BLOODSTONE_DUST = registerItem("bloodstone_dust",
            new Item(new FabricItemSettings().recipeRemainder(MORTAR_AND_PESTLE).group(ModItemGroup.GS_ADDITIONS)));

    //Fluid Bucket Items
    public static final Item CESTRIUM_BUCKET = registerFluidItem("cestrium_bucket",
            new BucketItem(_FluidRegistry.CESTRIUM_STILL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FabricGemstoneAdditions.MOD_ID, name), item);
    }

    private static Item registerFluidItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FabricGemstoneAdditions.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("Registering Mod Items for " + FabricGemstoneAdditions.MOD_ID);
    }
}
