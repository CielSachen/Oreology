package net.ciel.oreology.datagen.loot;

import java.util.Set;

import net.ciel.oreology.block.ModBlocks;
import net.ciel.oreology.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {
  	public ModBlockLootTables() {
    	super(Set.of(), FeatureFlags.REGISTRY.allFlags());
  	}

  	@Override
  	protected void generate() {
    	add(ModBlocks.DEEPSLATE_RUBY_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));
    	add(ModBlocks.RUBY_ORE.get(), (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));

		dropSelf(ModBlocks.RUBY_BLOCK.get());

		dropSelf(ModBlocks.NETHER_BRICK_FENCE_GATE.get());

		dropSelf(ModBlocks.RED_NETHER_BRICK_FENCE.get());
		dropSelf(ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get());

		dropSelf(ModBlocks.BLACK_NETHER_BRICKS.get());
    	dropSelf(ModBlocks.BLACK_NETHER_BRICK_SLAB.get());
    	dropSelf(ModBlocks.BLACK_NETHER_BRICK_STAIRS.get());
    	dropSelf(ModBlocks.BLACK_NETHER_BRICK_WALL.get());
		dropSelf(ModBlocks.BLACK_NETHER_BRICK_FENCE.get());
		dropSelf(ModBlocks.BLACK_NETHER_BRICK_FENCE_GATE.get());

    	dropSelf(ModBlocks.TAN_BRICKS.get());
    	dropSelf(ModBlocks.TAN_BRICK_SLAB.get());
    	dropSelf(ModBlocks.TAN_BRICK_STAIRS.get());
    	dropSelf(ModBlocks.TAN_BRICK_WALL.get());

		dropSelf(ModBlocks.BLACK_BRICKS.get());
    	dropSelf(ModBlocks.BLACK_BRICK_SLAB.get());
    	dropSelf(ModBlocks.BLACK_BRICK_STAIRS.get());
    	dropSelf(ModBlocks.BLACK_BRICK_WALL.get());
  	}
  
  	@Override
  	protected Iterable<Block> getKnownBlocks() {
    	return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
  	}
}
