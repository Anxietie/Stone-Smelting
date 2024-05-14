package com.mod.melting.screen;

import com.chocohead.mm.api.ClassTinkerers;
import com.mod.melting.registry.RecipeTypeRegister;
import com.mod.melting.registry.ScreenHandlerTypeRegister;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class MelterScreenHandler extends AbstractFurnaceScreenHandler {
	public MelterScreenHandler(int syncId, PlayerInventory playerInventory) {
		super(ScreenHandlerTypeRegister.MELTER, RecipeTypeRegister.MELTING, ClassTinkerers.getEnum(RecipeBookCategory.class, "MELTER"), syncId, playerInventory);
	}

	public MelterScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(ScreenHandlerTypeRegister.MELTER, RecipeTypeRegister.MELTING, ClassTinkerers.getEnum(RecipeBookCategory.class, "MELTER"), syncId, playerInventory, inventory, propertyDelegate);
	}
}
