
package galaria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import galaria.procedures.PiocheGalarienRightClickedInAirProcedure;
import galaria.procedures.PiocheGalarienBlockDestroyedWithToolProcedure;

import galaria.itemgroup.GalariaItemGroup;

import galaria.GalariaModElements;

@GalariaModElements.ModElement.Tag
public class PiocheGalarienItem extends GalariaModElements.ModElement {
	@ObjectHolder("galaria:pioche_galarien")
	public static final Item block = null;
	public PiocheGalarienItem(GalariaModElements instance) {
		super(instance, 60);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4500;
			}

			public float getEfficiency() {
				return 24f;
			}

			public float getAttackDamage() {
				return 6f;
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
		}, 1, -3f, new Item.Properties().group(GalariaItemGroup.tab)) {
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
					PiocheGalarienRightClickedInAirProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState bl, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					PiocheGalarienBlockDestroyedWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("pioche_galarien"));
	}
}
