package net.ciel.oreology;

import net.ciel.oreology.block.ModBlocks;
import net.ciel.oreology.client.CuriosLayerDefinitions;
import net.ciel.oreology.client.model.GoldenCrownModel;
import net.ciel.oreology.client.renderer.GoldenCrownRenderer;
import net.ciel.oreology.item.ModCreativeModeTabs;
import net.ciel.oreology.item.ModItems;
import net.ciel.oreology.loot.ModLootModifiers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(Oreology.MOD_ID)
public class Oreology {
    public static final String MOD_ID = "oreology";

    public Oreology() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::registerLayerDefinitions);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.NETHER_BRICK_FENCE_GATE);
            event.accept(ModBlocks.RED_NETHER_BRICK_FENCE.get());
            event.accept(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get());
            event.accept(ModBlocks.BLACK_NETHER_BRICKS);
            event.accept(ModBlocks.BLACK_NETHER_BRICK_STAIRS);
            event.accept(ModBlocks.BLACK_NETHER_BRICK_SLAB);
            event.accept(ModBlocks.BLACK_NETHER_BRICK_WALL);
            event.accept(ModBlocks.BLACK_NETHER_BRICK_FENCE.get());
            event.accept(ModBlocks.BLACK_NETHER_BRICK_FENCE_GATE.get());
            event.accept(ModBlocks.TAN_BRICKS);
            event.accept(ModBlocks.TAN_BRICK_STAIRS);
            event.accept(ModBlocks.TAN_BRICK_SLAB);
            event.accept(ModBlocks.TAN_BRICK_WALL);
            event.accept(ModBlocks.BLACK_BRICKS);
            event.accept(ModBlocks.BLACK_BRICK_STAIRS);
            event.accept(ModBlocks.BLACK_BRICK_SLAB);
            event.accept(ModBlocks.BLACK_BRICK_WALL);
            event.accept(ModBlocks.RUBY_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.RUBY_SHOVEL);
            event.accept(ModItems.RUBY_PICKAXE);
            event.accept(ModItems.RUBY_AXE);
            event.accept(ModItems.RUBY_HOE);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.RUBY_SWORD);
            event.accept(ModItems.RUBY_AXE);
            event.accept(ModItems.GOLDEN_CROWN);
            event.accept(ModItems.RUBY_HELMET);
            event.accept(ModItems.RUBY_CHESTPLATE);
            event.accept(ModItems.RUBY_LEGGINGS);
            event.accept(ModItems.RUBY_BOOTS);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RUBY);
            event.accept(ModItems.TAN_BRICK);
            event.accept(ModItems.BLACK_BRICK);
        }
    }

    private void registerLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CuriosLayerDefinitions.GOLDEN_CROWN, GoldenCrownModel::createLayer);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartedEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            CuriosRendererRegistry.register(ModItems.GOLDEN_CROWN.get(), GoldenCrownRenderer::new);
        }
    }
}
