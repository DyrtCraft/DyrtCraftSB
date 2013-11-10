package pl.dyrtcraft.dyrtcraftsb.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import pl.DyrtCraft.DyrtCraftXP.events.PlayerChangeServerEvent;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

public class SwitchListener implements Listener {
	
	DyrtCraftSB plugin;
	
	public SwitchListener(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@EventHandler
	public void onPlayerChangeServer(PlayerChangeServerEvent e) {
		if(e.getServer().equalsIgnoreCase("SkyBlock")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(DyrtCraftSB.prefix() + "Juz znajdujesz sie na serwerze SkyBlock :)");
		} else {
			Bukkit.broadcastMessage(ChatColor.DARK_RED + "<< " + ChatColor.GRAY + e.getPlayer().getName() + " przeszedl na serwer " + e.getServer() + ChatColor.DARK_RED + " >>");
		}
	}
	
}
