package com.mod.melting.mixin.client;

import com.chocohead.mm.api.ClassTinkerers;
import com.mod.melting.registry.RecipeTypeRegister;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.recipebook.RecipeBookGroup;
import net.minecraft.recipe.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientRecipeBook.class)
public abstract class ClientRecipeBookMixin {
	@Inject(method = "getGroupForRecipe", at = @At("HEAD"), cancellable = true)
	private static void getGroupForRecipe(Recipe<?> recipe, CallbackInfoReturnable<RecipeBookGroup> cir) {
		if (recipe.getType() == RecipeTypeRegister.MELTING) cir.setReturnValue(ClassTinkerers.getEnum(RecipeBookGroup.class, "MELTER_BLOCKS"));
	}
}
