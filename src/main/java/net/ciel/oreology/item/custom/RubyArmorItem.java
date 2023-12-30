package net.ciel.oreology.item.custom;

import net.ciel.oreology.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RubyArmorItem extends ArmorItem {
    public RubyArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.RUBY_HELMET.get()
        && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.RUBY_CHESTPLATE.get()
        && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.RUBY_LEGGINGS.get()
        && player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.RUBY_BOOTS.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 300, 1, false, false, true));
        }
    }
}
