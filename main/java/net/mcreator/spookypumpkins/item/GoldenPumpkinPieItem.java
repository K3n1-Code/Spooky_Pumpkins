package net.mcreator.spookypumpkins.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class GoldenPumpkinPieItem extends Item {
	public GoldenPumpkinPieItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(14.4f).build()));
	}
}