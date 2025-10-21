package net.mcreator.spookypumpkins.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.spookypumpkins.init.SpookyPumpkinsModEntities;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlacePumpkinOnBoneProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		Entity e = null;
		if (blockstate.getBlock() == Blocks.CARVED_PUMPKIN && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BONE_BLOCK) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
			e = world instanceof ServerLevel _level6 ? SpookyPumpkinsModEntities.PUMP_KIN.get().spawn(_level6, BlockPos.containing(x, y - 1, z), MobSpawnType.MOB_SUMMONED) : null;
			{
				Entity _ent = e;
				_ent.setYRot(entity.getYRot() + 180);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			e.getPersistentData().putString("owner", (entity.getStringUUID()));
		}
	}
}