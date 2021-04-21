
package galaria.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import galaria.item.CharbonGalariaItem;

import galaria.GalariaModElements;

@GalariaModElements.ModElement.Tag
public class CharbonGalariaCuirFuel extends GalariaModElements.ModElement {
	public CharbonGalariaCuirFuel(GalariaModElements instance) {
		super(instance, 25);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(CharbonGalariaItem.block, (int) (1)).getItem())
			event.setBurnTime(3000);
	}
}
