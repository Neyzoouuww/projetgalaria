
package galaria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import galaria.procedures.EpeeGalariaToolInHandTickProcedure;

import galaria.itemgroup.GalariaItemGroup;

import galaria.GalariaModElements;

@GalariaModElements.ModElement.Tag
public class EpeeGalariaItem extends GalariaModElements.ModElement {
	@ObjectHolder("galaria:epee_galaria")
	public static final Item block = null;
	public EpeeGalariaItem(GalariaModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 10f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -1f, new Item.Properties().group(GalariaItemGroup.tab)) {
			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					EpeeGalariaToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("epee_galaria"));
	}
}
