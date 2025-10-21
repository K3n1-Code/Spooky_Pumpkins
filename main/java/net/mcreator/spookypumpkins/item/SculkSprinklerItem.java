package net.mcreator.spookypumpkins.item;

import net.minecraft.world.level.block.Block;

import net.mcreator.spookypumpkins.init.SpookyPumpkinsModBlocks;
import net.mcreator.spookypumpkins.ElementSprinkler;

public class SculkSprinklerItem extends ElementSprinkler {
	@Override
	public Block getResult() {
		return SpookyPumpkinsModBlocks.ELDRITCH_PUMPKIN.get();
	}

}