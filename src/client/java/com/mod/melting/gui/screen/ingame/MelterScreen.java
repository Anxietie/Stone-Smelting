package com.mod.melting.gui.screen.ingame;

import com.mod.melting.gui.screen.recipebook.MelterRecipeBookScreen;
import com.mod.melting.screen.MelterScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MelterScreen extends AbstractFurnaceScreen<MelterScreenHandler> {
	private static final Identifier TEXTURE = new Identifier("textures/gui/container/furnace.png");

	public MelterScreen(MelterScreenHandler container, PlayerInventory inventory, Text title) {
		super(container, new MelterRecipeBookScreen(), inventory, title, TEXTURE);
	}
}
