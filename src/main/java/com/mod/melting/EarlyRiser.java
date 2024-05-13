package com.mod.melting;

import com.chocohead.mm.api.ClassTinkerers;

public class EarlyRiser implements Runnable {
	@Override
	public void run() {
		ClassTinkerers.enumBuilder("net.minecraft.recipe.book.RecipeBookCategory").addEnum("MELTING").build();
	}
}
