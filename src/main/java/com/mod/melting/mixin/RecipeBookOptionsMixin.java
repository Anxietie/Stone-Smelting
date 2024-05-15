package com.mod.melting.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(RecipeBookOptions.class)
public class RecipeBookOptionsMixin {
	@Shadow
	@Mutable
	private static @Final Map<RecipeBookCategory, Pair<String, String>> CATEGORY_OPTION_NAMES;

	static {
		CATEGORY_OPTION_NAMES = ImmutableMap.<RecipeBookCategory, Pair<String, String>>builder().putAll(CATEGORY_OPTION_NAMES).put(ClassTinkerers.getEnum(RecipeBookCategory.class, "MELTER"), Pair.of("isMelterGuiOpen", "isMelterFilteringCraftable")).build();
	}
}
