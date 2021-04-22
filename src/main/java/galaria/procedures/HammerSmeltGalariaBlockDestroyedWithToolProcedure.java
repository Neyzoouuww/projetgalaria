package galaria.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import java.util.Map;

import galaria.item.HammerSmeltGalariaItem;

import galaria.GalariaModElements;

import galaria.GalariaMod;

@GalariaModElements.ModElement.Tag
public class HammerSmeltGalariaBlockDestroyedWithToolProcedure extends GalariaModElements.ModElement {
	public HammerSmeltGalariaBlockDestroyedWithToolProcedure(GalariaModElements instance) {
		super(instance, 57);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GalariaMod.LOGGER.warn("Failed to load dependency entity for procedure HammerSmeltGalariaBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GalariaMod.LOGGER.warn("Failed to load dependency x for procedure HammerSmeltGalariaBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GalariaMod.LOGGER.warn("Failed to load dependency y for procedure HammerSmeltGalariaBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GalariaMod.LOGGER.warn("Failed to load dependency z for procedure HammerSmeltGalariaBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GalariaMod.LOGGER.warn("Failed to load dependency world for procedure HammerSmeltGalariaBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean removeBlock = false;
		if ((((entity.rotationPitch) > 40) || ((entity.rotationPitch) < (-40)))) {
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
						}
					}
				}
			}
		} else if ((((entity.getHorizontalFacing()) == Direction.NORTH) || ((entity.getHorizontalFacing()) == Direction.SOUTH))) {
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) z), false);
						}
					}
				}
			}
		} else if ((((entity.getHorizontalFacing()) == Direction.WEST) || ((entity.getHorizontalFacing()) == Direction.EAST))) {
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))))
					.getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
						}
					}
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)
					&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
							.getBlock())))) {
				if (((new ItemStack(HammerSmeltGalariaItem.block, (int) (1)).getItem()
						.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
					if ((!(((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
									((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world)).isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						removeBlock = (boolean) (true);
					} else {
						removeBlock = (boolean) (false);
					}
					if (((removeBlock) == (true))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					} else {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) z), false);
						}
					}
				}
			}
		}
	}
}
