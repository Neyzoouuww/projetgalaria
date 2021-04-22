
package galaria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import galaria.procedures.HacheGalariaToolInHandTickProcedure;

import galaria.itemgroup.GalariaItemGroup;

import galaria.GalariaModElements;

@GalariaModElements.ModElement.Tag
public class HacheGalariaItem extends GalariaModElements.ModElement {
	@ObjectHolder("galaria:hache_galaria")
	public static final Item block = null;
	public HacheGalariaItem(GalariaModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3500;
			}

			public float getEfficiency() {
				return 18f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(GalariaItemGroup.tab)) {
			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					HacheGalariaToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("hache_galaria"));
	}
}
