package com.mod.melting.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableMap;
import com.mod.melting.registry.RecipeTypeRegister;
import com.mojang.datafixers.util.Pair;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookOptions;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(RecipeBookOptions.class)
public class RecipeBookOptionsMixin {
	@Shadow
	@Mutable
	private static @Final Map<RecipeBookCategory, Pair<String, String>> CATEGORY_OPTION_NAMES;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void clinit(CallbackInfo ci) {
		Map<RecipeBookCategory, Pair<String, String>> copy = new HashMap<>(Map.copyOf(CATEGORY_OPTION_NAMES));
		copy.put(ClassTinkerers.getEnum(RecipeBookCategory.class, "MELTER"), Pair.of("isMelterGuiOpen", "isMelterFilteringCraftable"));
		CATEGORY_OPTION_NAMES = ImmutableMap.copyOf(copy);
	}
}
