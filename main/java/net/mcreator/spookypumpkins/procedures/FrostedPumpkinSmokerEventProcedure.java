package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.Entity;

public class FrostedPumpkinSmokerEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setTicksFrozen((int) Math.min(340, entity.getTicksFrozen() + 3));
	}
}