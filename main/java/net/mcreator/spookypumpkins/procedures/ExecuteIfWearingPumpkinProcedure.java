package net.mcreator.spookypumpkins.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.spookypumpkins.init.SpookyPumpkinsModBlocks;

import javax.annotation.Nullable;

import java.util.function.BiConsumer;
import java.util.HashMap;

@EventBusSubscriber
public class ExecuteIfWearingPumpkinProcedure {
	static HashMap<Block, BiConsumer<Entity, Double>> map = new HashMap<>();

	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (map.size() == 0) {
			map.put(SpookyPumpkinsModBlocks.CARVED_FROSTED_PUMPKIN.get(), (Entity e, Double slot) -> FrostedPumpkinWearingEventProcedure.execute(e, slot));
			map.put(SpookyPumpkinsModBlocks.CARVED_ROTTEN_PUMPKIN.get(), (Entity e, Double slot) -> RottenPumpkinWearingEventProcedure.execute(e, slot));
			map.put(SpookyPumpkinsModBlocks.CARVED_ELDRITCH_PUMPKIN.get(), (Entity e, Double slot) -> SculkPumpkinWearingEventProcedure.execute(e, slot));
			map.put(SpookyPumpkinsModBlocks.CARVED_GOLDEN_PUMPKIN.get(), (Entity e, Double slot) -> GoldenPumpkinWearingEventProcedure.execute(e, slot));
		}
		ItemStack stack = ItemStack.EMPTY;
		BlockState block = Blocks.AIR.defaultBlockState();
		stack = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy();
		block = (stack.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState());
		if (block.getBlock() instanceof EquipableCarvedPumpkinBlock helmet) {
			BiConsumer<Entity, Double> runnable = map.get(block.getBlock());
			if (runnable != null) {
				runnable.accept(entity, 103.0);
			}
		}
	}
}