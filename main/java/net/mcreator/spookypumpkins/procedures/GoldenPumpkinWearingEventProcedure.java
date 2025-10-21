package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class GoldenPumpkinWearingEventProcedure {
	public static void execute(Entity entity, double slot) {
		if (entity == null)
			return;
		if (slot == 103) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getDuration() : 0) < 20) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 0, true, true));
			}
		}
	}
}