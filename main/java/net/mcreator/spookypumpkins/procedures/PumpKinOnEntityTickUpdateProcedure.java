package net.mcreator.spookypumpkins.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class PumpKinOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String scanner = "";
		double x_ = 0;
		double y_ = 0;
		double z_ = 0;
		double pointer = 0;
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getDouble("resting") == 0) {
				for (int index0 = 0; index0 < 32; index0++) {
					x_ = Mth.nextInt(RandomSource.create(), -5, 5);
					z_ = Mth.nextInt(RandomSource.create(), -5, 5);
					y_ = -2;
					while (y_ <= 2) {
						if ((world.getBlockState(BlockPos.containing(x + x_, y + y_, z + z_))).getBlock() == Blocks.PUMPKIN) {
							entity.getPersistentData().putBoolean("working", true);
							entity.getPersistentData().putDouble("resting", (20 * 18));
							entity.getPersistentData().putString("harvest", ("x:" + (x + x_) + ",y:" + (y + y_) + ",z:" + (z + z_)));
							if (entity instanceof Mob _entity)
								_entity.getNavigation().moveTo((x + x_), (y + y_), (z + z_), 1);
							break;
						}
						y_ = y_ + 1;
					}
				}
				entity.getPersistentData().putDouble("resting", (20 * Mth.nextInt(RandomSource.create(), 14, 18)));
			} else {
				entity.getPersistentData().putDouble("resting", (entity.getPersistentData().getDouble("resting") - 1));
				if (entity.getPersistentData().getBoolean("working")) {
					scanner = entity.getPersistentData().getString("harvest");
					pointer = scanner.indexOf("x:", 0) + 2;
					x_ = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(scanner.substring((int) pointer, scanner.indexOf(",", (int) pointer)));
					pointer = scanner.indexOf("y:", 0) + 2;
					y_ = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(scanner.substring((int) pointer, scanner.indexOf(",", (int) pointer)));
					pointer = scanner.indexOf("z:", 0) + 2;
					z_ = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(scanner.substring((int) pointer));
					if (Math.hypot(x - x_, z - z_) >= 2.5) {
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo(x_, y_, z_, 1);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						{
							BlockPos _pos = BlockPos.containing(x_, y_, z_);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x_ + 0.5, y_ + 0.5, z_ + 0.5), null);
							world.destroyBlock(_pos, false);
						}
						entity.getPersistentData().putDouble("resting", (20 * Mth.nextInt(RandomSource.create(), 2, 4)));
						entity.getPersistentData().putBoolean("working", false);
					}
				}
			}
		}
	}
}