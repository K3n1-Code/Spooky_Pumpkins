/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spookypumpkins.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.spookypumpkins.block.SculkOLanternBlock;
import net.mcreator.spookypumpkins.block.RottenPumpkinBlock;
import net.mcreator.spookypumpkins.block.RotOLanternBlock;
import net.mcreator.spookypumpkins.block.PumpkinSmokerBlock;
import net.mcreator.spookypumpkins.block.PumpkinBeaconBlock;
import net.mcreator.spookypumpkins.block.JackOGoldenBlock;
import net.mcreator.spookypumpkins.block.JackOFrostBlock;
import net.mcreator.spookypumpkins.block.GoldenPumpkinBlock;
import net.mcreator.spookypumpkins.block.FrostedPumpkinBlock;
import net.mcreator.spookypumpkins.block.EldritchPumpkinBlock;
import net.mcreator.spookypumpkins.block.CarvedRottenPumpkinBlock;
import net.mcreator.spookypumpkins.block.CarvedGoldenPumpkinBlock;
import net.mcreator.spookypumpkins.block.CarvedFrostedPumpkinBlock;
import net.mcreator.spookypumpkins.block.CarvedEldritchPumpkinBlock;
import net.mcreator.spookypumpkins.SpookyPumpkinsMod;

public class SpookyPumpkinsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SpookyPumpkinsMod.MODID);
	public static final DeferredBlock<Block> FROSTED_PUMPKIN = REGISTRY.register("frosted_pumpkin", FrostedPumpkinBlock::new);
	public static final DeferredBlock<Block> CARVED_FROSTED_PUMPKIN = REGISTRY.register("carved_frosted_pumpkin", CarvedFrostedPumpkinBlock::new);
	public static final DeferredBlock<Block> JACK_O_FROST = REGISTRY.register("jack_o_frost", JackOFrostBlock::new);
	public static final DeferredBlock<Block> ROTTEN_PUMPKIN = REGISTRY.register("rotten_pumpkin", RottenPumpkinBlock::new);
	public static final DeferredBlock<Block> CARVED_ROTTEN_PUMPKIN = REGISTRY.register("carved_rotten_pumpkin", CarvedRottenPumpkinBlock::new);
	public static final DeferredBlock<Block> ROT_O_LANTERN = REGISTRY.register("rot_o_lantern", RotOLanternBlock::new);
	public static final DeferredBlock<Block> ELDRITCH_PUMPKIN = REGISTRY.register("eldritch_pumpkin", EldritchPumpkinBlock::new);
	public static final DeferredBlock<Block> CARVED_ELDRITCH_PUMPKIN = REGISTRY.register("carved_eldritch_pumpkin", CarvedEldritchPumpkinBlock::new);
	public static final DeferredBlock<Block> SCULK_O_LANTERN = REGISTRY.register("sculk_o_lantern", SculkOLanternBlock::new);
	public static final DeferredBlock<Block> GOLDEN_PUMPKIN = REGISTRY.register("golden_pumpkin", GoldenPumpkinBlock::new);
	public static final DeferredBlock<Block> CARVED_GOLDEN_PUMPKIN = REGISTRY.register("carved_golden_pumpkin", CarvedGoldenPumpkinBlock::new);
	public static final DeferredBlock<Block> JACK_O_GOLDEN = REGISTRY.register("jack_o_golden", JackOGoldenBlock::new);
	public static final DeferredBlock<Block> PUMPKIN_SMOKER = REGISTRY.register("pumpkin_smoker", PumpkinSmokerBlock::new);
	public static final DeferredBlock<Block> PUMPKIN_BEACON = REGISTRY.register("pumpkin_beacon", PumpkinBeaconBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}