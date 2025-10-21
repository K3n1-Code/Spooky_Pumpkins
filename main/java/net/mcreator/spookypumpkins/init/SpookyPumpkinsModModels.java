/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spookypumpkins.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.spookypumpkins.client.model.Modelskeleton;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SpookyPumpkinsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelskeleton.LAYER_LOCATION, Modelskeleton::createBodyLayer);
	}
}