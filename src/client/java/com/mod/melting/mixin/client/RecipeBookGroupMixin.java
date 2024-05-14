package com.mod.melting.mixin.client;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.recipebook.RecipeBookGroup;
import net.minecraft.recipe.book.RecipeBookCategory;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(RecipeBookGroup.class)
public abstract class RecipeBookGroupMixin {
	@Unique
	private static final RecipeBookGroup MELTER_SEARCH = ClassTinkerers.getEnum(RecipeBookGroup.class, "MELTER_SEARCH");
	@Unique
	private static final RecipeBookGroup MELTER_BLOCKS = ClassTinkerers.getEnum(RecipeBookGroup.class, "MELTER_BLOCKS");
	@Unique
	private static final List<RecipeBookGroup> MELTER = ImmutableList.of(
			MELTER_SEARCH,
			MELTER_BLOCKS
	);

	@Shadow
	@Mutable
	public static @Final Map<RecipeBookGroup, List<RecipeBookGroup>> SEARCH_MAP;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void clinit(CallbackInfo ci) {
		Map<RecipeBookGroup, List<RecipeBookGroup>> copy = new HashMap<>(Map.copyOf(SEARCH_MAP));
		copy.put(MELTER_SEARCH, ImmutableList.of(MELTER_BLOCKS));
		SEARCH_MAP = ImmutableMap.copyOf(copy);
	}

	@Inject(method = "getGroups", at = @At("HEAD"), cancellable = true)
	private static void getGroups(RecipeBookCategory category, CallbackInfoReturnable<List<RecipeBookGroup>> cir) {
		if (category == ClassTinkerers.getEnum(RecipeBookCategory.class, "MELTER"))
			cir.setReturnValue(MELTER);
	}
}
