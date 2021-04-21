package galaria.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

import galaria.GalariaModElements;

import galaria.GalariaMod;

@GalariaModElements.ModElement.Tag
public class BlockDeVision2OnBlockRightClickedProcedure extends GalariaModElements.ModElement {
	public BlockDeVision2OnBlockRightClickedProcedure(GalariaModElements instance) {
		super(instance, 46);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GalariaMod.LOGGER.warn("Failed to load dependency x for procedure BlockDeVision2OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GalariaMod.LOGGER.warn("Failed to load dependency y for procedure BlockDeVision2OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GalariaMod.LOGGER.warn("Failed to load dependency z for procedure BlockDeVision2OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GalariaMod.LOGGER.warn("Failed to load dependency world for procedure BlockDeVision2OnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
	}
}
