package net.ciel.oreology.datagen;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.block.ModBlocks;
import net.ciel.oreology.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(ModBlocks.RUBY_ORE.get()), RecipeCategory.MISC, ModItems.RUBY.get(), 1f, 200, "ruby");
        oreBlasting(consumer, List.of(ModBlocks.RUBY_ORE.get()), RecipeCategory.MISC, ModItems.RUBY.get(), 1f, 100, "ruby");
        oreSmelting(consumer, List.of(ModBlocks.DEEPSLATE_RUBY_ORE.get()), RecipeCategory.MISC, ModItems.RUBY.get(), 1f, 200, "ruby");
        oreBlasting(consumer, List.of(ModBlocks.DEEPSLATE_RUBY_ORE.get()), RecipeCategory.MISC, ModItems.RUBY.get(), 1f, 100, "ruby");

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.RUBY.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK.get());

        fenceGate(consumer, ModBlocks.NETHER_BRICK_FENCE_GATE.get(), Blocks.NETHER_BRICKS, Items.NETHER_BRICK);

        fence(consumer, ModBlocks.RED_NETHER_BRICK_FENCE.get(), Blocks.RED_NETHER_BRICKS, Items.NETHER_BRICK);
        fenceGate(consumer, ModBlocks.RED_NETHER_BRICK_FENCE_GATE.get(), Blocks.RED_NETHER_BRICKS, Items.NETHER_BRICK);

        ShapedRecipeBuilder
            .shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_NETHER_BRICKS.get())
            .define('#', Blocks.BASALT)
            .define('N', Items.NETHER_BRICK)
            .pattern("#N")
            .pattern("N#")
            .unlockedBy("has_basalt", inventoryTrigger(ItemPredicate.Builder.item().of(Blocks.BASALT).build()))
            .save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_NETHER_BRICK_SLAB.get(), ModBlocks.BLACK_NETHER_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_NETHER_BRICK_SLAB.get(), ModBlocks.BLACK_NETHER_BRICKS.get(), 2);
        stair(consumer, ModBlocks.BLACK_NETHER_BRICK_STAIRS.get(), ModBlocks.BLACK_NETHER_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_NETHER_BRICK_STAIRS.get(), ModBlocks.BLACK_NETHER_BRICKS.get());
        wall(consumer, RecipeCategory.DECORATIONS, ModBlocks.BLACK_NETHER_BRICK_WALL.get(), ModBlocks.BLACK_NETHER_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, ModBlocks.BLACK_NETHER_BRICK_WALL.get(), ModBlocks.BLACK_NETHER_BRICKS.get());
        fence(consumer, ModBlocks.BLACK_NETHER_BRICK_FENCE.get(), ModBlocks.BLACK_NETHER_BRICKS.get(), Items.NETHER_BRICK);
        fenceGate(consumer, ModBlocks.BLACK_NETHER_BRICK_FENCE_GATE.get(), ModBlocks.BLACK_NETHER_BRICKS.get(), Items.NETHER_BRICK);

        oreSmelting(consumer, List.of(Items.BRICK), RecipeCategory.MISC, ModItems.TAN_BRICK.get(), 0.3f, 150, "tan_brick");
        twoByTwoPacker(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TAN_BRICKS.get(), ModItems.TAN_BRICK.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TAN_BRICK_SLAB.get(), ModBlocks.TAN_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TAN_BRICK_SLAB.get(), ModBlocks.TAN_BRICKS.get(), 2);
        stair(consumer, ModBlocks.TAN_BRICK_STAIRS.get(), ModBlocks.TAN_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TAN_BRICK_STAIRS.get(), ModBlocks.TAN_BRICKS.get());
        wall(consumer, RecipeCategory.DECORATIONS, ModBlocks.TAN_BRICK_WALL.get(), ModBlocks.TAN_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, ModBlocks.TAN_BRICK_WALL.get(), ModBlocks.TAN_BRICKS.get());

        oreSmelting(consumer, List.of(ModItems.TAN_BRICK.get()), RecipeCategory.MISC, ModItems.BLACK_BRICK.get(), 0.3f, 150, "black_brick");
        twoByTwoPacker(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_BRICKS.get(), ModItems.BLACK_BRICK.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_BRICK_SLAB.get(), ModBlocks.BLACK_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_BRICK_SLAB.get(), ModBlocks.BLACK_BRICKS.get(), 2);
        stair(consumer, ModBlocks.BLACK_BRICK_STAIRS.get(), ModBlocks.BLACK_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_BRICK_STAIRS.get(), ModBlocks.BLACK_BRICKS.get());
        wall(consumer, RecipeCategory.DECORATIONS, ModBlocks.BLACK_BRICK_WALL.get(), ModBlocks.BLACK_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, ModBlocks.BLACK_BRICK_WALL.get(), ModBlocks.BLACK_BRICKS.get());
    
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.GOLDEN_CROWN.get())
            .define('#', Items.GOLD_INGOT)
            .pattern("###")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.GOLD_INGOT).build()))
            .save(consumer);

        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD.get())
            .define('#', ModItems.RUBY.get())
            .define('/', Items.BLAZE_ROD)
            .pattern("#")
            .pattern("#")
            .pattern("/")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_SHOVEL.get())
            .define('#', ModItems.RUBY.get())
            .define('/', Items.BLAZE_ROD)
            .pattern("#")
            .pattern("/")
            .pattern("/")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_PICKAXE.get())
            .define('#', ModItems.RUBY.get())
            .define('/', Items.BLAZE_ROD)
            .pattern("###")
            .pattern(" / ")
            .pattern(" / ")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_AXE.get())
            .define('#', ModItems.RUBY.get())
            .define('/', Items.BLAZE_ROD)
            .pattern("##")
            .pattern("#/")
            .pattern(" /")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_HOE.get())
            .define('#', ModItems.RUBY.get())
            .define('/', Items.BLAZE_ROD)
            .pattern("##")
            .pattern(" /")
            .pattern(" /")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);

        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_HELMET.get())
            .define('#', ModItems.RUBY.get())
            .pattern("###")
            .pattern("# #")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE.get())
            .define('#', ModItems.RUBY.get())
            .pattern("# #")
            .pattern("###")
            .pattern("###")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS.get())
            .define('#', ModItems.RUBY.get())
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
        ShapedRecipeBuilder
            .shaped(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS.get())
            .define('#', ModItems.RUBY.get())
            .pattern("# #")
            .pattern("# #")
            .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY.get()).build()))
            .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> input, RecipeCategory recipeCategory, ItemLike output, float experience, int tickDuration, String name) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, input, recipeCategory, output, experience, tickDuration, name, "_from_smelting");
    }
  
    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> input, RecipeCategory recipeCategory, ItemLike output, float experience, int tickDuration, String name) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, input, recipeCategory, output, experience, tickDuration, name, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> recipeSerializer, List<ItemLike> input, RecipeCategory recipeCategory, ItemLike output, float experience, int tickDuration, String name, String nameSuffix) {
        for(ItemLike itemlike : input) {
            SimpleCookingRecipeBuilder
                .generic(Ingredient.of(itemlike), recipeCategory, output, experience, tickDuration, recipeSerializer)
                .group(name)
                .unlockedBy(getHasName(itemlike), has(itemlike)).save(consumer, new ResourceLocation(Oreology.MOD_ID, getItemName(output)) + nameSuffix + "_" + getItemName(itemlike));
        }
    }

    protected static void fence(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material, ItemLike stickMaterial) {
        ShapedRecipeBuilder
            .shaped(RecipeCategory.DECORATIONS, result, 6)
            .define('W', material)
            .define('#', stickMaterial)
            .pattern("W#W")
            .pattern("W#W")
            .unlockedBy(getHasName(material), has(material))
            .save(consumer);
    }

    protected static void fenceGate(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material, ItemLike stickMaterial) {
        ShapedRecipeBuilder
            .shaped(RecipeCategory.REDSTONE, result)
            .define('W', material)
            .define('#', stickMaterial)
            .pattern("#W#")
            .pattern("#W#")
            .unlockedBy(getHasName(material), has(material))
            .save(consumer);
    }

    protected static void stair(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike material) {
        stairBuilder(result, Ingredient.of(material))
            .unlockedBy(getHasName(material), has(material))
            .save(consumer);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, RecipeCategory recipeCategory, ItemLike result, ItemLike material) {
        stonecutterResultFromBase(consumer, recipeCategory, result, material, 1);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, RecipeCategory recipeCategory, ItemLike result, ItemLike material, int resultAmount) {
        SingleItemRecipeBuilder
            .stonecutting(Ingredient.of(material), recipeCategory, result, resultAmount)
            .unlockedBy(getHasName(material), has(material)).save(consumer, new ResourceLocation(Oreology.MOD_ID, getConversionRecipeName(result, material)) + "_stonecutting");
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory materialRecipeCategory, ItemLike material, RecipeCategory blockRecipeCategory, ItemLike block) {
        nineBlockStorageRecipes(consumer, materialRecipeCategory, material, blockRecipeCategory, block, getSimpleRecipeName(block), (String)null, getSimpleRecipeName(material), (String)null);
  } 

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory materialRecipeCategory, ItemLike material, RecipeCategory blockRecipeCategory, ItemLike block, String blockSimpleRecipeName, @Nullable String blockName, String materialSimpleRecipeName, @Nullable String materialName) {
        ShapelessRecipeBuilder
            .shapeless(materialRecipeCategory, material, 9)
            .requires(block).group(materialName)
            .unlockedBy(getHasName(block), has(block))
            .save(consumer, new ResourceLocation(Oreology.MOD_ID, materialSimpleRecipeName));
        ShapedRecipeBuilder
            .shaped(blockRecipeCategory, block)
            .define('#', material)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .group(blockName)
            .unlockedBy(getHasName(material), has(material))
            .save(consumer, new ResourceLocation(Oreology.MOD_ID, blockSimpleRecipeName));
    }
}
