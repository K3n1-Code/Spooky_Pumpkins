package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.Entity;

public class PumpkinSmokerEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(5);
	}
}