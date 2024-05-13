package com.mod.melting.block.entity;

import com.mod.melting.registry.BlockEntityRegister;
import com.mod.melting.registry.RecipeTypeRegister;
import com.mod.melting.screen.MelterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.Collection;
import java.util.Collections;

public class MelterBlockEntity extends AbstractFurnaceBlockEntity {
	public MelterBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegister.MELTER, pos, state, RecipeTypeRegister.MELTING);
	}

	protected Text getContainerName() {
		return Text.translatable("container.melter");
	}

	protected int getFuelTime(ItemStack fuel) {
		return super.getFuelTime(fuel) / 2;
	}

	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new MelterScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
}
