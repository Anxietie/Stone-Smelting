package com.mod.melting.recipe;

import com.mod.melting.registry.BlockRegister;
import com.mod.melting.registry.RecipeTypeRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;

public class MeltingRecipe extends AbstractCookingRecipe {
	public MeltingRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
		super(RecipeTypeRegister.MELTING, id, group, category, input, output, experience, cookTime);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(BlockRegister.MELTER);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return RecipeTypeRegister.MELTING_SERIALIZER;
	}
}
