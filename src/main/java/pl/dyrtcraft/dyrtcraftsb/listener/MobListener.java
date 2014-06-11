package pl.dyrtcraft.dyrtcraftsb.listener;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

public class MobListener implements Listener {
	
	DyrtCraftSB plugin;
	
	public MobListener(DyrtCraftSB plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onCreateSpawnEvent(CreatureSpawnEvent e) {
		e.getEntity().removePotionEffect(PotionEffectType.JUMP);
		e.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
		try {
			e.getEntity().getEquipment().setHelmet(helmKosmonauty());
		} catch(Exception ex) {}
	}
	
	private ItemStack helmKosmonauty() {
		ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Helm kosmonauty");
		itemMeta.setLore(Arrays.asList(ChatColor.DARK_BLUE + "Potrzebny do zycia", ChatColor.DARK_BLUE + "w kosmosie"));
		item.setItemMeta(itemMeta);
		return item;
	}
	
}
