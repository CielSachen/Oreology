package net.ciel.oreology.item;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.item.custom.GoldenCrownArmorItem;
import net.ciel.oreology.item.custom.RubyArmorItem;
import net.ciel.oreology.item.custom.RubyAxeItem;
import net.ciel.oreology.item.custom.RubyHoeItem;
import net.ciel.oreology.item.custom.RubyPickaxeItem;
import net.ciel.oreology.item.custom.RubyShovelItem;
import net.ciel.oreology.item.custom.RubySwordItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Oreology.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TAN_BRICK = ITEMS.register("tan_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_BRICK = ITEMS.register("black_brick", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_CROWN = ITEMS.register("golden_crown", () -> new GoldenCrownArmorItem(ModArmorMaterials.GOLDEN_CROWN, RubyArmorItem.Type.HELMET, (new Item.Properties())));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new RubySwordItem(ModTiers.RUBY, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new RubyShovelItem(ModTiers.RUBY, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new RubyPickaxeItem(ModTiers.RUBY, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new RubyAxeItem(ModTiers.RUBY, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new RubyHoeItem(ModTiers.RUBY, -3, 0.0F, new Item.Properties()));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new RubyArmorItem(ModArmorMaterials.RUBY, RubyArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new RubyArmorItem(ModArmorMaterials.RUBY, RubyArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new RubyArmorItem(ModArmorMaterials.RUBY, RubyArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new RubyArmorItem(ModArmorMaterials.RUBY, RubyArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
