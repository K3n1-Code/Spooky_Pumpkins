package net.mcreator.spookypumpkins.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.EntityTypeTags;

public class RottenPumpkinSmokerEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getType().is(EntityTypeTags.UNDEAD)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getDuration() : 0) < 100) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0, true, true));
			}
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 10) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getDuration() : 0) < 100) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, true, false));
				}
			}
		} else {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION) ? _livEnt.getEffect(MobEffects.REGENERATION).getDuration() : 0) < 100) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, true, true));
			}
		}
	}
}