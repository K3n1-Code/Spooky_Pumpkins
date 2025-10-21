package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class SculkPumpkinWearingEventProcedure {
	public static void execute(Entity entity, double slot) {
		if (entity == null)
			return;
		if (slot == 103) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DARKNESS) ? _livEnt.getEffect(MobEffects.DARKNESS).getDuration() : 0) < 100) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 0, true, true));
			}
		}
	}
}