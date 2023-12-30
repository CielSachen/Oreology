package net.ciel.oreology.datagen;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Oreology.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBY);

        simpleItem(ModItems.TAN_BRICK);
        simpleItem(ModItems.BLACK_BRICK);

        simpleItem(ModItems.GOLDEN_CROWN);

        handHeldItem(ModItems.RUBY_SWORD);
        handHeldItem(ModItems.RUBY_SHOVEL);
        handHeldItem(ModItems.RUBY_PICKAXE);
        handHeldItem(ModItems.RUBY_AXE);
        handHeldItem(ModItems.RUBY_HOE);

        simpleItem(ModItems.RUBY_HELMET);
        simpleItem(ModItems.RUBY_CHESTPLATE);
        simpleItem(ModItems.RUBY_LEGGINGS);
        simpleItem(ModItems.RUBY_BOOTS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(Oreology.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(Oreology.MOD_ID, "item/" + item.getId().getPath()));
    }
}
