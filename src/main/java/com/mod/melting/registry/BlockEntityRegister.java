package com.mod.melting.registry;

import com.mod.melting.block.entity.MelterBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mod.melting.StoneSmelting.MODID;

public class BlockEntityRegister {
	public static final BlockEntityType<MelterBlockEntity> MELTER = FabricBlockEntityTypeBuilder.create(MelterBlockEntity::new, BlockRegister.MELTER).build();

	public static void registerBlockEntities() {
		register("melter", MELTER);
	}

	private static BlockEntityType<? extends BlockEntity> register(String id, BlockEntityType<? extends BlockEntity> blockEntityType) {
		return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MODID, id), blockEntityType);
	}
}
