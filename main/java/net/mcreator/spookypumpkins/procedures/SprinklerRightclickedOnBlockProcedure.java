package net.mcreator.spookypumpkins.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.spookypumpkins.init.SpookyPumpkinsModItems;

public class SprinklerRightclickedOnBlockProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, BlockState targetBlock, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return InteractionResult.PASS;
		if (blockstate.getBlock() == Blocks.PUMPKIN) {
			if (!world.isClientSide()) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.5), (z + 0.5), 7, 1, 1, 1, 0);
				world.setBlock(BlockPos.containing(x, y, z), targetBlock, 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bone_meal.use")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				itemstack.shrink(1);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SpookyPumpkinsModItems.SPRINKLER.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}