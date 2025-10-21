package net.mcreator.spookypumpkins.procedures;

import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EntityTypeTags;

import net.mcreator.spookypumpkins.init.SpookyPumpkinsModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class UndeadDontAgroRottenPumpkinProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		boolean flag =execute(event, event.getOriginalAboutToBeSetTarget(), event.getEntity());
		event.setCanceled(flag);
		if(flag)event.setNewAboutToBeSetTarget(null);
	}

	public static boolean execute(Entity entity, Entity sourceentity) {
		return execute(null, entity, sourceentity);
	}

	private static boolean execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == SpookyPumpkinsModBlocks.CARVED_ROTTEN_PUMPKIN.get().asItem()) {
			if (sourceentity.getType().is(EntityTypeTags.UNDEAD)) {
				return true;
			}
		}
		return false;
	}
}