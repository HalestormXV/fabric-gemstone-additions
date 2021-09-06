package net.halestormxv.fabric_gemstone_additions.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup GS_ADDITIONS = FabricItemGroupBuilder.build(new Identifier(FabricGemstoneAdditions.MOD_ID, "gemstones"),
            () -> new ItemStack(ModItems.RUBY));
}
