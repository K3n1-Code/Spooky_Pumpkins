package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.Entity;

public class NotWorkingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !entity.getPersistentData().getBoolean("working");
	}
}