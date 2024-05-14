package com.mod.melting.block;

import com.mod.melting.block.entity.MelterBlockEntity;
import com.mod.melting.registry.BlockEntityRegister;
import com.mod.melting.registry.StatsRegister;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MelterBlock extends AbstractFurnaceBlock {
	public MelterBlock(AbstractBlock.Settings settings) { super(settings); }

	@Override
	public void openScreen(World world, BlockPos pos, PlayerEntity player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof MelterBlockEntity) {
			player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
			player.incrementStat(StatsRegister.INTERACT_WITH_MELTER);
		}
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new MelterBlockEntity(pos, state);
	}

	@Override
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return MelterBlock.checkType(world, type, BlockEntityRegister.MELTER);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		if (!state.get(LIT)) return;

		double d = (double)pos.getX() + 0.5;
		double e = pos.getY();
		double f = (double)pos.getZ() + 0.5;

		if (random.nextDouble() < 0.1)
			world.playSound(d, e, f, SoundEvents.BLOCK_BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);

		Direction direction = state.get(FACING);
		Direction.Axis axis = direction.getAxis();

		double h = random.nextDouble() * 0.6 - 0.3;
		double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : h;
		double j = random.nextDouble() * 9.0 / 16.0;
		double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : h;

		world.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
	}
}
