package net.ciel.oreology.loot;

import com.mojang.serialization.Codec;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.loot.custom.RubyToolSmeltingModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Oreology.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> RUBY_TOOLS_SMELTING = GLOBAL_LOOT_MODIFIER.register("ruby_tools_smelting", RubyToolSmeltingModifier.CODEC);

    public static void register(IEventBus bus) {
        GLOBAL_LOOT_MODIFIER.register(bus);
    }
}
