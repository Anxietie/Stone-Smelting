package com.mod.melting.mixin;

import com.mod.melting.registry.RecipeTypeRegister;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CookingRecipeJsonBuilder.class)
public abstract class CookingRecipeJsonBuilderMixin {
	@Inject(method = "getCookingRecipeCategory", at = @At("HEAD"), cancellable = true)
	private static void getCookingRecipeCategory(RecipeSerializer<? extends AbstractCookingRecipe> serializer, ItemConvertible output, CallbackInfoReturnable<CookingRecipeCategory> cir) {
		if (serializer == RecipeTypeRegister.MELTING_SERIALIZER) cir.setReturnValue(CookingRecipeCategory.BLOCKS);
	}
}
