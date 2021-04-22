
package galaria.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import galaria.block.MineraiGalariaBlock;

import galaria.GalariaModElements;

@GalariaModElements.ModElement.Tag
public class GalariaItemGroup extends GalariaModElements.ModElement {
	public GalariaItemGroup(GalariaModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgalaria") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MineraiGalariaBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
