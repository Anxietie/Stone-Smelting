package com.mod.melting.datagen;

import com.google.common.collect.ImmutableMap;
import com.mod.melting.registry.RecipeTypeRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.mod.melting.StoneSmelting.MODID;

public class ModRecipeGenerator extends FabricRecipeProvider {
	private final Map<List<ItemConvertible>, ItemConvertible> RECIPES;

	public ModRecipeGenerator(FabricDataOutput generator) {
		super(generator);
		ImmutableMap.Builder<List<ItemConvertible>, ItemConvertible> builder = new ImmutableMap.Builder<>();
		builder.put(List.of(Items.COBBLESTONE), Items.STONE);
		builder.put(List.of(Items.STONE), Items.SMOOTH_STONE);
		builder.put(List.of(Items.STONE_BRICKS), Items.CRACKED_STONE_BRICKS);
		builder.put(List.of(Items.COBBLED_DEEPSLATE), Items.DEEPSLATE);
		builder.put(List.of(Items.DEEPSLATE_BRICKS), Items.CRACKED_DEEPSLATE_BRICKS);
		builder.put(List.of(Items.DEEPSLATE_TILES), Items.CRACKED_DEEPSLATE_TILES);
		builder.put(List.of(Items.SANDSTONE), Items.SMOOTH_SANDSTONE);
		builder.put(List.of(Items.RED_SANDSTONE), Items.SMOOTH_RED_SANDSTONE);
		builder.put(List.of(Items.NETHER_BRICKS), Items.CRACKED_NETHER_BRICKS);
		builder.put(List.of(Items.BASALT), Items.SMOOTH_BASALT);
		builder.put(List.of(Items.POLISHED_BLACKSTONE_BRICKS), Items.CRACKED_POLISHED_BLACKSTONE_BRICKS);
		builder.put(List.of(Items.QUARTZ_BLOCK), Items.SMOOTH_QUARTZ);
		builder.put(List.of(Items.CLAY), Items.TERRACOTTA);
		builder.put(List.of(Items.SAND, Items.RED_SAND), Items.GLASS);
		RECIPES = builder.build();
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		for (Map.Entry<List<ItemConvertible>, ItemConvertible> entry : RECIPES.entrySet())
			offerMelting(exporter, entry.getKey(), RecipeCategory.BUILDING_BLOCKS, entry.getValue(), 0.1f, 100, Registries.ITEM.getId(entry.getValue().asItem()).getPath());
		generateTerracottaMeltingRecipes(exporter);
	}

	public static void generateTerracottaMeltingRecipes(Consumer<RecipeJsonProvider> exporter) {
		List<CookingRecipeJsonBuilder> builders = List.of(
                createMelting(Ingredient.ofItems(Blocks.BLUE_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.BLUE_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_blue_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.BLUE_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.BROWN_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.BROWN_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_brown_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.BROWN_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.CYAN_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.CYAN_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_cyan_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.CYAN_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.GRAY_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.GRAY_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_gray_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.GRAY_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.GREEN_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.GREEN_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_green_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.GREEN_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.LIGHT_BLUE_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_light_blue_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.LIGHT_BLUE_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.LIGHT_GRAY_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_light_gray_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.LIGHT_GRAY_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.LIME_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.LIME_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_lime_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.LIME_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.MAGENTA_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.MAGENTA_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_magenta_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.MAGENTA_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.ORANGE_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.ORANGE_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_orange_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.ORANGE_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.PINK_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.PINK_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_pink_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.PINK_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.PURPLE_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.PURPLE_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_purple_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.PURPLE_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.RED_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.RED_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_red_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.RED_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.WHITE_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.WHITE_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_white_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.WHITE_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.YELLOW_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.YELLOW_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_yellow_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.YELLOW_TERRACOTTA)),
                createMelting(Ingredient.ofItems(Blocks.BLACK_TERRACOTTA), RecipeCategory.DECORATIONS, Blocks.BLACK_GLAZED_TERRACOTTA.asItem(), 0.1f, 100).criterion("has_black_terracotta", VanillaRecipeProvider.conditionsFromItem(Blocks.BLACK_TERRACOTTA))
		);

        builders.forEach((builder) -> builder.offerTo(exporter, Identifier.of(MODID, CraftingRecipeJsonBuilder.getItemId(builder.getOutputItem()).getPath())));
	}

	public static void offerMelting(Consumer<RecipeJsonProvider> exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
		offerMultipleOptions(exporter, RecipeTypeRegister.MELTING_SERIALIZER, inputs, category, output, experience, cookingTime, group, "_from_melting");
	}

	public static void offerMultipleOptions(Consumer<RecipeJsonProvider> exporter, RecipeSerializer<? extends AbstractCookingRecipe> serializer, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group, String method) {
		for (ItemConvertible itemConvertible : inputs) {
			CookingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), category, output, experience, cookingTime, serializer).group(group).criterion(RecipeProvider.hasItem(itemConvertible), RecipeProvider.conditionsFromItem(itemConvertible)).offerTo(exporter, Identifier.of(MODID, RecipeProvider.getItemPath(output) + method + "_" + RecipeProvider.getItemPath(itemConvertible)));
		}
	}

	public static CookingRecipeJsonBuilder createMelting(Ingredient input, RecipeCategory category, ItemConvertible output, float experience, int cookingTime) {
		return new CookingRecipeJsonBuilder(category, CookingRecipeCategory.BLOCKS, output, input, experience, cookingTime, RecipeTypeRegister.MELTING_SERIALIZER);
	}
}
