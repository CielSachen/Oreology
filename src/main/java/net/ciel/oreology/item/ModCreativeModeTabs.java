package net.ciel.oreology.item;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Oreology.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AUXILIARIES = CREATIVE_MODE_TABS.register("auxiliaries", () -> CreativeModeTab
            .builder()
            .icon(() -> new ItemStack(ModItems.RUBY.get()))
            .title(Component.translatable("itemGroup.auxiliaries"))
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.NETHER_BRICK_FENCE_GATE.get());
                output.accept(ModBlocks.RED_NETHER_BRICK_FENCE.get());
                output.accept(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get());
                output.accept(ModBlocks.BLACK_NETHER_BRICKS.get());
                output.accept(ModBlocks.BLACK_NETHER_BRICK_STAIRS.get());
                output.accept(ModBlocks.BLACK_NETHER_BRICK_SLAB.get());
                output.accept(ModBlocks.BLACK_NETHER_BRICK_WALL.get());
                output.accept(ModBlocks.BLACK_NETHER_BRICK_FENCE.get());
                output.accept(ModBlocks.BLACK_NETHER_BRICK_FENCE_GATE.get());
                output.accept(ModBlocks.TAN_BRICKS.get());
                output.accept(ModBlocks.TAN_BRICK_STAIRS.get());
                output.accept(ModBlocks.TAN_BRICK_SLAB.get());
                output.accept(ModBlocks.TAN_BRICK_WALL.get());
                output.accept(ModBlocks.BLACK_BRICKS.get());
                output.accept(ModBlocks.BLACK_BRICK_STAIRS.get());
                output.accept(ModBlocks.BLACK_BRICK_SLAB.get());
                output.accept(ModBlocks.BLACK_BRICK_WALL.get());
                output.accept(ModBlocks.RUBY_BLOCK.get());
                output.accept(ModBlocks.RUBY_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                output.accept(ModItems.RUBY_SHOVEL.get());
                output.accept(ModItems.RUBY_PICKAXE.get());
                output.accept(ModItems.RUBY_AXE.get());
                output.accept(ModItems.RUBY_HOE.get());
                output.accept(ModItems.RUBY_SWORD.get());
                output.accept(ModItems.GOLDEN_CROWN.get());
                output.accept(ModItems.RUBY_HELMET.get());
                output.accept(ModItems.RUBY_CHESTPLATE.get());
                output.accept(ModItems.RUBY_LEGGINGS.get());
                output.accept(ModItems.RUBY_BOOTS.get());
                output.accept(ModItems.RUBY.get());
                output.accept(ModItems.TAN_BRICK.get());
                output.accept(ModItems.BLACK_BRICK.get());
            })
            .build());;

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
