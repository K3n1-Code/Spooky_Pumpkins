/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spookypumpkins.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.spookypumpkins.item.SprinklerItem;
import net.mcreator.spookypumpkins.item.SporeSprinklerItem;
import net.mcreator.spookypumpkins.item.SnowSprinklerItem;
import net.mcreator.spookypumpkins.item.SculkSprinklerItem;
import net.mcreator.spookypumpkins.item.SculkPumpkinJuiceItem;
import net.mcreator.spookypumpkins.item.RottenPumpkinPieItem;
import net.mcreator.spookypumpkins.item.RottenPumpkinJuiceItem;
import net.mcreator.spookypumpkins.item.PumpkinJuiceItem;
import net.mcreator.spookypumpkins.item.GoldenPumpkinPieItem;
import net.mcreator.spookypumpkins.item.GoldenPumpkinJuiceItem;
import net.mcreator.spookypumpkins.item.FrozenPumpkinPieItem;
import net.mcreator.spookypumpkins.item.FrozenPumpkinJuiceItem;
import net.mcreator.spookypumpkins.item.ElderichPumpkinPieItem;
import net.mcreator.spookypumpkins.SpookyPumpkinsMod;

public class SpookyPumpkinsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SpookyPumpkinsMod.MODID);
	public static final DeferredItem<Item> FROSTED_PUMPKIN = block(SpookyPumpkinsModBlocks.FROSTED_PUMPKIN);
	public static final DeferredItem<Item> CARVED_FROSTED_PUMPKIN = block(SpookyPumpkinsModBlocks.CARVED_FROSTED_PUMPKIN);
	public static final DeferredItem<Item> JACK_O_FROST = block(SpookyPumpkinsModBlocks.JACK_O_FROST);
	public static final DeferredItem<Item> ROTTEN_PUMPKIN = block(SpookyPumpkinsModBlocks.ROTTEN_PUMPKIN);
	public static final DeferredItem<Item> CARVED_ROTTEN_PUMPKIN = block(SpookyPumpkinsModBlocks.CARVED_ROTTEN_PUMPKIN);
	public static final DeferredItem<Item> ROT_O_LANTERN = block(SpookyPumpkinsModBlocks.ROT_O_LANTERN);
	public static final DeferredItem<Item> ELDRITCH_PUMPKIN = block(SpookyPumpkinsModBlocks.ELDRITCH_PUMPKIN);
	public static final DeferredItem<Item> CARVED_ELDRITCH_PUMPKIN = block(SpookyPumpkinsModBlocks.CARVED_ELDRITCH_PUMPKIN);
	public static final DeferredItem<Item> SCULK_O_LANTERN = block(SpookyPumpkinsModBlocks.SCULK_O_LANTERN);
	public static final DeferredItem<Item> PUMP_KIN_SPAWN_EGG = REGISTRY.register("pump_kin_spawn_egg", () -> new DeferredSpawnEggItem(SpookyPumpkinsModEntities.PUMP_KIN, -13421773, -26368, new Item.Properties()));
	public static final DeferredItem<Item> GOLDEN_PUMPKIN = block(SpookyPumpkinsModBlocks.GOLDEN_PUMPKIN);
	public static final DeferredItem<Item> CARVED_GOLDEN_PUMPKIN = block(SpookyPumpkinsModBlocks.CARVED_GOLDEN_PUMPKIN);
	public static final DeferredItem<Item> JACK_O_GOLDEN = block(SpookyPumpkinsModBlocks.JACK_O_GOLDEN);
	public static final DeferredItem<Item> PUMPKIN_SMOKER = block(SpookyPumpkinsModBlocks.PUMPKIN_SMOKER);
	public static final DeferredItem<Item> PUMPKIN_BEACON = block(SpookyPumpkinsModBlocks.PUMPKIN_BEACON);
	public static final DeferredItem<Item> SPRINKLER = REGISTRY.register("sprinkler", SprinklerItem::new);
	public static final DeferredItem<Item> SNOW_SPRINKLER = REGISTRY.register("snow_sprinkler", SnowSprinklerItem::new);
	public static final DeferredItem<Item> SCULK_SPRINKLER = REGISTRY.register("sculk_sprinkler", SculkSprinklerItem::new);
	public static final DeferredItem<Item> SPORE_SPRINKLER = REGISTRY.register("spore_sprinkler", SporeSprinklerItem::new);
	public static final DeferredItem<Item> ELDERICH_PUMPKIN_PIE = REGISTRY.register("elderich_pumpkin_pie", ElderichPumpkinPieItem::new);
	public static final DeferredItem<Item> FROZEN_PUMPKIN_PIE = REGISTRY.register("frozen_pumpkin_pie", FrozenPumpkinPieItem::new);
	public static final DeferredItem<Item> ROTTEN_PUMPKIN_PIE = REGISTRY.register("rotten_pumpkin_pie", RottenPumpkinPieItem::new);
	public static final DeferredItem<Item> GOLDEN_PUMPKIN_PIE = REGISTRY.register("golden_pumpkin_pie", GoldenPumpkinPieItem::new);
	public static final DeferredItem<Item> PUMPKIN_JUICE = REGISTRY.register("pumpkin_juice", PumpkinJuiceItem::new);
	public static final DeferredItem<Item> FROZEN_PUMPKIN_JUICE = REGISTRY.register("frozen_pumpkin_juice", FrozenPumpkinJuiceItem::new);
	public static final DeferredItem<Item> ROTTEN_PUMPKIN_JUICE = REGISTRY.register("rotten_pumpkin_juice", RottenPumpkinJuiceItem::new);
	public static final DeferredItem<Item> GOLDEN_PUMPKIN_JUICE = REGISTRY.register("golden_pumpkin_juice", GoldenPumpkinJuiceItem::new);
	public static final DeferredItem<Item> SCULK_PUMPKIN_JUICE = REGISTRY.register("sculk_pumpkin_juice", SculkPumpkinJuiceItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}