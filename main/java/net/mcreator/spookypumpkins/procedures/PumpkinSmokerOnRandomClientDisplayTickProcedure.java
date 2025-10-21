package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PumpkinSmokerOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.25) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 3); index0++) {
				world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + Mth.nextDouble(RandomSource.create(), 0.3, 0.7)), (y + Mth.nextDouble(RandomSource.create(), 0.4, 0.6)), (z + Mth.nextDouble(RandomSource.create(), 0.3, 0.7)), 0, 0.05, 0);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.campfire.crackle")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.campfire.crackle")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}