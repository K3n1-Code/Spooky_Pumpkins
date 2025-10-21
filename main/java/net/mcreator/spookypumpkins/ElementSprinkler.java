/*
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.spookypumpkins as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.spookypumpkins;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.spookypumpkins.procedures.SprinklerRightclickedOnBlockProcedure;
import net.mcreator.spookypumpkins.init.SpookyPumpkinsModItems;

public abstract class ElementSprinkler extends Item {
	public ElementSprinkler() {
		super(new Item.Properties());
	}

	public abstract Block getResult();

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		return SprinklerRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getLevel().getBlockState(context.getClickedPos()),
				getResult().defaultBlockState(), context.getPlayer(), context.getItemInHand());
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(SpookyPumpkinsModItems.SPRINKLER.get());
	}
}