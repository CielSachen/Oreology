package net.ciel.oreology.block;

import java.util.function.Supplier;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Oreology.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties
        .of()
        .mapColor(MapColor.STONE)
        .instrument(NoteBlockInstrument.BASEDRUM)
        .requiresCorrectToolForDrops()
        .strength(3.0F, 3.0F), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties
        .copy(RUBY_ORE.get())
        .mapColor(MapColor.DEEPSLATE)
        .strength(4.5F, 3.0F)
        .sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));;

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties
        .of()
        .mapColor(MapColor.COLOR_RED)
        .instrument(NoteBlockInstrument.BIT)
        .requiresCorrectToolForDrops()
        .strength(5.0F, 6.0F)
        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> NETHER_BRICK_FENCE_GATE = registerBlock("nether_brick_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS), SoundEvents.NETHER_BRICKS_PLACE, SoundEvents.NETHER_BRICKS_BREAK));

    public static final RegistryObject<Block> RED_NETHER_BRICK_FENCE = registerBlock("red_nether_brick_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS)));
    public static final RegistryObject<Block> RED_NETHER_BRICK_FENCE_GATE = registerBlock("red_nether_brick_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS), SoundEvents.NETHER_BRICKS_PLACE, SoundEvents.NETHER_BRICKS_BREAK));

    public static final RegistryObject<Block> BLACK_NETHER_BRICKS = registerBlock("black_nether_bricks", () -> new Block(BlockBehaviour.Properties
        .of()
        .mapColor(MapColor.NETHER)
        .instrument(NoteBlockInstrument.BASEDRUM)
        .requiresCorrectToolForDrops()
        .strength(2.0F, 6.0F)
        .sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_STAIRS = registerBlock("black_nether_brick_stairs", () -> new StairBlock(() -> BLACK_NETHER_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLACK_NETHER_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_SLAB = registerBlock("black_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BLACK_NETHER_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_WALL = registerBlock("black_nether_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(BLACK_NETHER_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_FENCE = registerBlock("black_nether_brick_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(BLACK_NETHER_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_NETHER_BRICK_FENCE_GATE = registerBlock("black_nether_brick_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(BLACK_NETHER_BRICKS.get()), SoundEvents.NETHER_BRICKS_PLACE, SoundEvents.NETHER_BRICKS_BREAK));

    public static final RegistryObject<Block> TAN_BRICKS = registerBlock("tan_bricks", () -> new Block(BlockBehaviour.Properties
        .of()
        .mapColor(MapColor.COLOR_BROWN)
        .instrument(NoteBlockInstrument.BASEDRUM)
        .requiresCorrectToolForDrops()
        .strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> TAN_BRICK_STAIRS = registerBlock("tan_brick_stairs", () -> new StairBlock(() -> TAN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(TAN_BRICKS.get())));
    public static final RegistryObject<Block> TAN_BRICK_SLAB = registerBlock("tan_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TAN_BRICKS.get())));
    public static final RegistryObject<Block> TAN_BRICK_WALL = registerBlock("tan_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TAN_BRICKS.get())));

    public static final RegistryObject<Block> BLACK_BRICKS = registerBlock("black_bricks", () -> new Block(BlockBehaviour.Properties
        .of()
        .mapColor(MapColor.COLOR_BLACK)
        .instrument(NoteBlockInstrument.BASEDRUM)
        .requiresCorrectToolForDrops()
        .strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> BLACK_BRICK_STAIRS = registerBlock("black_brick_stairs", () -> new StairBlock(() -> BLACK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLACK_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_BRICK_SLAB = registerBlock("black_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BLACK_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_BRICK_WALL = registerBlock("black_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(BLACK_BRICKS.get())));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
    
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
