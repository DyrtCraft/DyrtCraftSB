package pl.dyrtcraft.dyrtcraftsb;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Crafting itemów
 * @author BlackCreep - zmodernizowane przez TheMolkaPL
 */
public class Crafting {

	DyrtCraftSB plugin;
	
	public Crafting(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	public static ShapedRecipe mossy() {
		ShapedRecipe mossy = new ShapedRecipe(new ItemStack(Material.MOSSY_COBBLESTONE, 4)).shape(new String[] { "101", "010", "101" })
			.setIngredient('1', Material.VINE)
			.setIngredient('0', Material.COBBLESTONE);
		return mossy;
	}
	public static ShapedRecipe snieg() {
	    ShapedRecipe snieg = new ShapedRecipe(new ItemStack(Material.SNOW_BLOCK, 4)).shape(new String[] { "111", "101", "111" })
    		.setIngredient('1', Material.QUARTZ_BLOCK)
	        .setIngredient('0', Material.WOOL);
	    return snieg;
	}
	public static ShapedRecipe lod() {
	    ShapedRecipe lod = new ShapedRecipe(new ItemStack(Material.ICE, 4)).shape(new String[] { "111", "101", "111" })
	      .setIngredient('1', Material.GLASS)
	      .setIngredient('0', Material.SNOW_BLOCK);
	    return lod;
	}
	public static ShapedRecipe end() {
		ShapedRecipe end = new ShapedRecipe(new ItemStack(Material.ENDER_STONE, 4)).shape(new String[] { "010", "111", "010" })
	      .setIngredient('1', Material.STONE)
	      .setIngredient('0', Material.SANDSTONE);
		return end;
	}
	public static ShapedRecipe quartz() {
		ShapedRecipe quartz = new ShapedRecipe(new ItemStack(Material.QUARTZ_BLOCK, 4)).shape(new String[] { " 1 ", "101", " 1 " })
	      .setIngredient('1', Material.STONE)
	      .setIngredient('0', Material.BONE);
		return quartz;
	}
	public static ShapedRecipe lampa() {
		ShapedRecipe lampa = new ShapedRecipe(new ItemStack(Material.REDSTONE_LAMP_OFF, 4)).shape(new String[] { " 1 ", "101", " 1 " })
	      .setIngredient('1', Material.GLASS)
	      .setIngredient('0', Material.REDSTONE_TORCH_ON);
		return lampa;
	}
	public static ShapedRecipe brick() {
		ShapedRecipe brick = new ShapedRecipe(new ItemStack(Material.NETHER_BRICK, 4)).shape(new String[] { "111", "101", "111" })
	      .setIngredient('1', Material.SMOOTH_BRICK)
	      .setIngredient('0', Material.REDSTONE);
		return brick;
	}
	
}
