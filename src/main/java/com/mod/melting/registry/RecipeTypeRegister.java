package com.mod.melting.registry;

import com.mod.melting.recipe.MeltingRecipe;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mod.melting.StoneSmelting.MODID;

public class RecipeTypeRegister {
	public static final RecipeType<MeltingRecipe> MELTING = new RecipeType<>() {
		@Override
		public String toString() {
			return "melting";
		}
	};

	public static final RecipeSerializer<MeltingRecipe> MELTING_SERIALIZER = new CookingRecipeSerializer<>(MeltingRecipe::new, 100);

	public static void registerRecipeTypes() {
		register(MELTING);
		registerSerializers();
	}

	public static void registerSerializers() {
		register("melting", MELTING_SERIALIZER);
	}

	private static <T extends Recipe<?>> RecipeType<T> register(RecipeType<T> recipeType) {
		return Registry.register(Registries.RECIPE_TYPE, Identifier.of(MODID, recipeType.toString()), recipeType);
	}

	public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
		return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MODID, id), serializer);
	}
}
