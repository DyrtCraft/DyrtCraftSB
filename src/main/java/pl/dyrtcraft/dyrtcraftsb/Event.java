package pl.dyrtcraft.dyrtcraftsb;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Event {
	
	private static boolean event;
	
	public static boolean getEvent() {
		return event;
	}
	
	public static void setEvent(boolean value) {
		Event.event = value;
	}
	
	public static void setEvent(boolean value, CommandSender setter) {
		Event.event = value;
		
		for(Player online : Bukkit.getOnlinePlayers()) {
			if(online.isOp()) {
				online.sendMessage(ChatColor.RED + "[-] " + ChatColor.YELLOW + setter.getName() + " ustawil event na " + value);
			}
		}
	}
	
}
