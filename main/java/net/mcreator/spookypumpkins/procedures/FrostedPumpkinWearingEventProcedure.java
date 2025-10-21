package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.Entity;

public class FrostedPumpkinWearingEventProcedure {
	public static void execute(Entity entity, double slot) {
		if (entity == null)
			return;
		if (slot == 103) {
			if (entity.getTicksFrozen() < 120) {
				entity.setTicksFrozen(entity.getTicksFrozen() + 5);
			}
		}
	}
}