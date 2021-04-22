package galaria.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import galaria.GalariaModElements;

import galaria.GalariaMod;

@GalariaModElements.ModElement.Tag
public class PiocheGalarienRightClickedInAirProcedure extends GalariaModElements.ModElement {
	public PiocheGalarienRightClickedInAirProcedure(GalariaModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GalariaMod.LOGGER.warn("Failed to load dependency entity for procedure PiocheGalarienRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 60, (int) 1, (false), (false)));
	}
}
