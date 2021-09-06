package net.halestormxv.fabric_gemstone_additions.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.halestormxv.fabric_gemstone_additions.FabricGemstoneAdditions;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootInjection {
    private static final Identifier EMERALD_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/emerald_ore");
    private static final Identifier RUBY_ORE_LOOT_TABLE_ID = new Identifier(FabricGemstoneAdditions.MOD_ID, "blocks/ruby_ore");

    public static void modifyLootTables(){
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            //Checks for Emerald Ore Loot Table
            if (EMERALD_ORE_LOOT_TABLE_ID.equals(id)){
                //Add Single Item to Emerald Ore Loot Table
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

                //Add Custom Loot Table
                FabricLootPoolBuilder poolBuilder2 = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(LootTableEntry.builder(RUBY_ORE_LOOT_TABLE_ID));
                supplier.withPool(poolBuilder2.build());
        });
    }
}
