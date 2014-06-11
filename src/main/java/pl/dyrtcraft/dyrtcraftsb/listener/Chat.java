package pl.dyrtcraft.dyrtcraftsb.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import org.kitteh.vanish.staticaccess.VanishNoPacket;
import org.kitteh.vanish.staticaccess.VanishNotLoadedException;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Chat implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		if(!(Bukkit.getPluginManager().getPlugin("VanishNoPacket") == null)) {
			// Vanish chat
			try {
				if(VanishNoPacket.isVanished(e.getPlayer().getName())) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						if(player.hasPermission("vanish.see") || player.hasPermission("vanish.vanish") || player.isOp()) {
							player.sendMessage(ChatColor.AQUA + "[VNP] " + e.getPlayer().getName() + ": " + e.getMessage());
						}
					}
				}
			} catch(VanishNotLoadedException ex) {}
		}
		
		// Default chat
		String prefix = PermissionsEx.getUser(e.getPlayer()).getPrefix();
		prefix = prefix.replace("&", "§");
		e.setFormat(prefix + ChatColor.GRAY + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
	}
	
}
