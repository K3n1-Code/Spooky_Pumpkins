package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.spookypumpkins.init.SpookyPumpkinsModBlocks;

import java.util.function.Consumer;
import java.util.HashMap;

public class PumpkinSmokerOnTickUpdateProcedure {
	static HashMap<Block, Consumer<Entity>> map = new HashMap<>();
	static HashMap<Block, SimpleParticleType> blockParticle = new HashMap<>();

	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState block = Blocks.AIR.defaultBlockState();
		if (map.size() == 0) {
			map.put(Blocks.JACK_O_LANTERN, (Entity e) -> PumpkinSmokerEventProcedure.execute(e));
			map.put(SpookyPumpkinsModBlocks.JACK_O_FROST.get(), (Entity e) -> FrostedPumpkinSmokerEventProcedure.execute(e));
			map.put(SpookyPumpkinsModBlocks.ROT_O_LANTERN.get(), (Entity e) -> RottenPumpkinSmokerEventProcedure.execute(e));
			map.put(SpookyPumpkinsModBlocks.SCULK_O_LANTERN.get(), (Entity e) -> SculkPumpkinSmokerEventProcedure.execute(e));
			map.put(SpookyPumpkinsModBlocks.JACK_O_GOLDEN.get(), (Entity e) -> GoldenPumpkinSmokerEventProcedure.execute(e));
		}
		if (blockParticle.size() == 0) {
			blockParticle.put(Blocks.JACK_O_LANTERN, ParticleTypes.SMALL_FLAME);
			blockParticle.put(SpookyPumpkinsModBlocks.JACK_O_FROST.get(), ParticleTypes.CLOUD);
			blockParticle.put(SpookyPumpkinsModBlocks.ROT_O_LANTERN.get(), ParticleTypes.ITEM_SLIME);
			blockParticle.put(SpookyPumpkinsModBlocks.SCULK_O_LANTERN.get(), ParticleTypes.SCULK_SOUL);
			blockParticle.put(SpookyPumpkinsModBlocks.JACK_O_GOLDEN.get(), ParticleTypes.HAPPY_VILLAGER);
		}
		double k = 0;
		while (k < 12) {
			block = (world.getBlockState(BlockPos.containing(x, y + k, z)));
			if (block.is(BlockTags.create(ResourceLocation.parse("spooky_pumpkins:lanterns")))) {
				double x0 = (x + 0.5) - (getDirectionFromBlockState(block)).getStepZ() * 0.5;
				double y0 = y + k;
				double z0 = (z + 0.5) - (getDirectionFromBlockState(block)).getStepX() * 0.5;
				double x1 = x + 0.5 + (getDirectionFromBlockState(block)).getStepX() * 12.5 + (getDirectionFromBlockState(block)).getStepZ() * 0.5;
				double y1 = y + k + 1;
				double z1 = z + 0.5 + (getDirectionFromBlockState(block)).getStepZ() * 12.5 + (getDirectionFromBlockState(block)).getStepX() * 0.5;
				for (int index1 = 0; index1 < 4; index1++) {
					if (world instanceof ServerLevel _level)
						if (blockParticle.get(block.getBlock()) != null)
							_level.sendParticles(blockParticle.get(block.getBlock()), (Mth.nextDouble(RandomSource.create(), Math.min(x0, x1), Math.max(x0, x1))), Mth.nextDouble(RandomSource.create(),y0,y1),
									(Mth.nextDouble(RandomSource.create(), Math.min(z0, z1), Math.max(z0, z1))), 1, 0, 0, 0, 0);
				}
				for (Entity entityiterator : world.getEntities(null, new AABB(x0, y0, z0, x1, y1, z1))) {
					if (entityiterator instanceof LivingEntity) {
						if (map.get(block.getBlock()) != null) {
							map.get(block.getBlock()).accept(entityiterator);
						}
					}
				}
			}
			k = k + 1;
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}
}