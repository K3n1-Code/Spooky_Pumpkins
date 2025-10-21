package net.mcreator.spookypumpkins.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class GoldenPumpkinBlock extends Block {
	public GoldenPumpkinBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 6f).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}