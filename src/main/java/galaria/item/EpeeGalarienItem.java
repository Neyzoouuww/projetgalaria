
package galaria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Map;
import java.util.HashMap;

import galaria.procedures.EpeeGalarienRightClickedInAirProcedure;

import galaria.itemgroup.GalariaItemGroup;

import galaria.GalariaModElements;

@GalariaModElements.ModElement.Tag
public class EpeeGalarienItem extends GalariaModElements.ModElement {
	@ObjectHolder("galaria:epee_galarien")
	public static final Item block = null;
	public EpeeGalarienItem(GalariaModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 14f;
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
		}, 3, 1f, new Item.Properties().group(GalariaItemGroup.tab)) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					EpeeGalarienRightClickedInAirProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("epee_galarien"));
	}
}
