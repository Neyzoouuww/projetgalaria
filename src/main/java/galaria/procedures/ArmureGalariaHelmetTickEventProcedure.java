package galaria.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import galaria.GalariaModElements;

import galaria.GalariaMod;

@GalariaModElements.ModElement.Tag
public class ArmureGalariaHelmetTickEventProcedure extends GalariaModElements.ModElement {
	public ArmureGalariaHelmetTickEventProcedure(GalariaModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GalariaMod.LOGGER.warn("Failed to load dependency entity for procedure ArmureGalariaHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 60, (int) 1, (false), (false)));
	}
}
