package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.Entity;

public class FrozenPumpkinPiePlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setTicksFrozen(40);
	}
}