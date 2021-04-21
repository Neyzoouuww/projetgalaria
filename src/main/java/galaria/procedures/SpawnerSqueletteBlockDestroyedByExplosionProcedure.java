package galaria.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.item.ExperienceOrbEntity;

import java.util.Map;

import galaria.GalariaModElements;

import galaria.GalariaMod;

@GalariaModElements.ModElement.Tag
public class SpawnerSqueletteBlockDestroyedByExplosionProcedure extends GalariaModElements.ModElement {
	public SpawnerSqueletteBlockDestroyedByExplosionProcedure(GalariaModElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GalariaMod.LOGGER.warn("Failed to load dependency x for procedure SpawnerSqueletteBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GalariaMod.LOGGER.warn("Failed to load dependency y for procedure SpawnerSqueletteBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GalariaMod.LOGGER.warn("Failed to load dependency z for procedure SpawnerSqueletteBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GalariaMod.LOGGER.warn("Failed to load dependency world for procedure SpawnerSqueletteBlockDestroyedByExplosion!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() >= 0.5)) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 15));
			}
		} else {
			if ((Math.random() >= 0.5)) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 20));
				}
			} else {
				if ((Math.random() >= 0.5)) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 25));
					}
				} else {
					if ((Math.random() >= 0.5)) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 30));
						}
					} else {
						if ((Math.random() >= 0.5)) {
							if (world instanceof World && !world.isRemote()) {
								((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 35));
							}
						} else {
							if (world instanceof World && !world.isRemote()) {
								((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 43));
							}
						}
					}
				}
			}
		}
	}
}
