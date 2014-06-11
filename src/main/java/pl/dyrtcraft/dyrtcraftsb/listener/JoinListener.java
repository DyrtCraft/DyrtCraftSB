package pl.dyrtcraft.dyrtcraftsb.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

public class JoinListener implements Listener {

	DyrtCraftSB plugin;
	
	public JoinListener(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.setJoinMessage(ChatColor.DARK_GREEN + ">> " + ChatColor.GRAY + e.getPlayer().getName() + ChatColor.DARK_GREEN + " <<");
		
		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
		
		if(e.getPlayer().isOp()) {
			e.getPlayer().setPlayerListName(ChatColor.RED + e.getPlayer().getDisplayName());
			return;
		}
		if(e.getPlayer().hasPermission("dyrtcraftsb.mod")) {
			e.getPlayer().setPlayerListName(ChatColor.DARK_GREEN + e.getPlayer().getDisplayName());
			return;
		}
		if(e.getPlayer().hasPermission("dyrtcraftsb.vip")) {
			e.getPlayer().setPlayerListName(ChatColor.GOLD + e.getPlayer().getDisplayName());
			return;
		} else {
			e.getPlayer().setPlayerListName(ChatColor.BLUE + e.getPlayer().getDisplayName());
		}
	}
	
}
