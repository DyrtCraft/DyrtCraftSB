package pl.dyrtcraft.dyrtcraftsb;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Zakup rang przez DyrtCraftXP
 * @author TheMolkaPL
 */
public class Shop implements Listener {

	DyrtCraftSB plugin;
	
	public static Inventory inv;
	private static ItemStack vip, svip;
	
	public Shop(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
		
		inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN+""+ChatColor.BOLD+"DyrtCraft "+ChatColor.RESET+ChatColor.DARK_AQUA+"Sklep SkyBlock");
		
		vip = create(Material.GOLD_BLOCK, "Ranga VIP", 1000);
		svip = create(Material.DIAMOND_BLOCK, "Ranga sVIP", 1500);
		
		inv.setItem(2, vip);
		inv.setItem(6, svip);
	}
	
	private ItemStack create(Material material, String name, int cena) {
		ItemStack i = new ItemStack(material, 1);
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + name);
		iMeta.setLore(Arrays.asList(ChatColor.DARK_GRAY + "Cena XP: " + ChatColor.BLUE + cena));
		i.setItemMeta(iMeta);
		return i;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		try {
			Player player = (Player) e.getWhoClicked();
			String _ = e.getCurrentItem().getItemMeta().getDisplayName();
			
			if(!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
			e.setCancelled(true);
			
			if(e.getSlot() == 2 && _.equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "Ranga VIP")) {
				DyrtCraftSB.buyVIP(player);
				player.closeInventory();
			}
			if(e.getSlot() == 6 && _.equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "Ranga sVIP")) {
				DyrtCraftSB.buySVIP(player);
				player.closeInventory();
			}
		} catch(NullPointerException ex) {}
	}
	
}
