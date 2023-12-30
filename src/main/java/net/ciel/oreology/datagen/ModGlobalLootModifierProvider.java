package net.ciel.oreology.datagen;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.item.ModItems;
import net.ciel.oreology.loot.custom.RubyToolSmeltingModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, Oreology.MOD_ID);
    }

    @Override
    protected void start() {
        add("ruby_tools_smelting", new RubyToolSmeltingModifier(new LootItemCondition[]{MatchTool.toolMatches(ItemPredicate.Builder.item().of(
            ModItems.RUBY_SHOVEL.get(),
            ModItems.RUBY_PICKAXE.get(),
            ModItems.RUBY_AXE.get(),
            ModItems.RUBY_HOE.get()
        )).build()}));
    }
}
