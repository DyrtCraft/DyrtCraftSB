package pl.dyrtcraft.dyrtcraftsb.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

public class QuitListener implements Listener {

	DyrtCraftSB plugin;
	
	public QuitListener(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		e.setQuitMessage(ChatColor.DARK_RED + "<< " + ChatColor.GRAY + e.getPlayer().getName() + ChatColor.DARK_RED + " >>");
	}
	
}
