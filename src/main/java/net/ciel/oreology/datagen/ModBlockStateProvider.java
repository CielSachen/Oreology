package net.ciel.oreology.datagen;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Oreology.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        this.blockWithItem(ModBlocks.RUBY_ORE);

        this.blockWithItem(ModBlocks.RUBY_BLOCK);

        this.fenceGateWithItem(ModBlocks.NETHER_BRICK_FENCE_GATE, Blocks.NETHER_BRICKS);

        this.fenceWithItem(ModBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);
        this.fenceGateWithItem(ModBlocks.RED_NETHER_BRICK_FENCE_GATE, Blocks.RED_NETHER_BRICKS);

        this.blockWithItem(ModBlocks.BLACK_NETHER_BRICKS);
        this.slabWithItem(ModBlocks.BLACK_NETHER_BRICK_SLAB, ModBlocks.BLACK_NETHER_BRICKS.get());
        this.stairsWithItem(ModBlocks.BLACK_NETHER_BRICK_STAIRS, ModBlocks.BLACK_NETHER_BRICKS.get());
        this.wallWithItem(ModBlocks.BLACK_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICKS.get());
        this.fenceWithItem(ModBlocks.BLACK_NETHER_BRICK_FENCE, ModBlocks.BLACK_NETHER_BRICKS.get());
        this.fenceGateWithItem(ModBlocks.BLACK_NETHER_BRICK_FENCE_GATE, ModBlocks.BLACK_NETHER_BRICKS.get());

        this.blockWithItem(ModBlocks.TAN_BRICKS);
        this.slabWithItem(ModBlocks.TAN_BRICK_SLAB, ModBlocks.TAN_BRICKS.get());
        this.stairsWithItem(ModBlocks.TAN_BRICK_STAIRS, ModBlocks.TAN_BRICKS.get());
        this.wallWithItem(ModBlocks.TAN_BRICK_WALL, ModBlocks.TAN_BRICKS.get());

        this.blockWithItem(ModBlocks.BLACK_BRICKS);
        this.slabWithItem(ModBlocks.BLACK_BRICK_SLAB, ModBlocks.BLACK_BRICKS.get());
        this.stairsWithItem(ModBlocks.BLACK_BRICK_STAIRS, ModBlocks.BLACK_BRICKS.get());
        this.wallWithItem(ModBlocks.BLACK_BRICK_WALL, ModBlocks.BLACK_BRICKS.get());
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void slabWithItem(RegistryObject<Block> slabBlock, Block mainBlock) {
        slabBlock((SlabBlock) slabBlock.get(), blockTexture((mainBlock)), blockTexture((mainBlock)));
        simpleBlockItem(slabBlock.get(), models().slab(slabBlock.getId().getPath(), blockTexture((mainBlock)), blockTexture((mainBlock)), blockTexture((mainBlock))));
    }

    private void stairsWithItem(RegistryObject<Block> stairBlock, Block mainBlock) {
        stairsBlock((StairBlock) stairBlock.get(), blockTexture(mainBlock));
        simpleBlockItem(stairBlock.get(), models().stairs(stairBlock.getId().getPath(), blockTexture((mainBlock)), blockTexture((mainBlock)), blockTexture((mainBlock))));
    }

    private void wallWithItem(RegistryObject<Block> wallBlock, Block mainBlock) {
        wallBlock((WallBlock) wallBlock.get(), blockTexture(mainBlock));
        simpleBlockItem(wallBlock.get(), models().wallInventory(wallBlock.getId().getPath() + "_inventory", blockTexture((mainBlock))));
    }

    private void fenceWithItem(RegistryObject<Block> fenceBlock, Block mainBlock) {
        fenceBlock((FenceBlock) fenceBlock.get(), blockTexture(mainBlock));
        simpleBlockItem(fenceBlock.get(), models().fenceInventory(fenceBlock.getId().getPath() + "_inventory", blockTexture((mainBlock))));
    }

    private void fenceGateWithItem(RegistryObject<Block> fenceGateBlock, Block mainBlock) {
        fenceGateBlock((FenceGateBlock) fenceGateBlock.get(), blockTexture(mainBlock));
        simpleBlockItem(fenceGateBlock.get(), models().fenceGate(fenceGateBlock.getId().getPath(), blockTexture((mainBlock))));
    }
}
