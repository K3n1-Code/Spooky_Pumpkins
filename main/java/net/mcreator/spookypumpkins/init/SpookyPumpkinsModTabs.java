/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spookypumpkins.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.spookypumpkins.SpookyPumpkinsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SpookyPumpkinsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SpookyPumpkinsMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SPOOKY_PUMPKINS = REGISTRY.register("spooky_pumpkins",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.spooky_pumpkins.spooky_pumpkins")).icon(() -> new ItemStack(Blocks.CARVED_PUMPKIN)).displayItems((parameters, tabData) -> {
				tabData.accept(SpookyPumpkinsModBlocks.PUMPKIN_SMOKER.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.PUMPKIN_BEACON.get().asItem());
				tabData.accept(SpookyPumpkinsModItems.SPRINKLER.get());
				tabData.accept(SpookyPumpkinsModItems.SNOW_SPRINKLER.get());
				tabData.accept(SpookyPumpkinsModItems.SPORE_SPRINKLER.get());
				tabData.accept(SpookyPumpkinsModItems.SCULK_SPRINKLER.get());
				tabData.accept(SpookyPumpkinsModBlocks.FROSTED_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.CARVED_FROSTED_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.JACK_O_FROST.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.ROTTEN_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.CARVED_ROTTEN_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.ROT_O_LANTERN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.ELDRITCH_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.CARVED_ELDRITCH_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.SCULK_O_LANTERN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.GOLDEN_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.CARVED_GOLDEN_PUMPKIN.get().asItem());
				tabData.accept(SpookyPumpkinsModBlocks.JACK_O_GOLDEN.get().asItem());
				tabData.accept(SpookyPumpkinsModItems.FROZEN_PUMPKIN_PIE.get());
				tabData.accept(SpookyPumpkinsModItems.ROTTEN_PUMPKIN_PIE.get());
				tabData.accept(SpookyPumpkinsModItems.ELDERICH_PUMPKIN_PIE.get());
				tabData.accept(SpookyPumpkinsModItems.GOLDEN_PUMPKIN_PIE.get());
				tabData.accept(SpookyPumpkinsModItems.PUMPKIN_JUICE.get());
				tabData.accept(SpookyPumpkinsModItems.FROZEN_PUMPKIN_JUICE.get());
				tabData.accept(SpookyPumpkinsModItems.ROTTEN_PUMPKIN_JUICE.get());
				tabData.accept(SpookyPumpkinsModItems.SCULK_PUMPKIN_JUICE.get());
				tabData.accept(SpookyPumpkinsModItems.GOLDEN_PUMPKIN_JUICE.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(SpookyPumpkinsModItems.PUMP_KIN_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(SpookyPumpkinsModItems.PUMPKIN_JUICE.get());
		}
	}
}