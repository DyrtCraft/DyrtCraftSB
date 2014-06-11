package pl.dyrtcraft.dyrtcraftsb.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;
import pl.dyrtcraft.dyrtcraftsb.Event;

public class EventCommand implements CommandExecutor {
	
	DyrtCraftSB plugin;
	
	public EventCommand(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("event") || command.getName().equalsIgnoreCase("e")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					sender.sendMessage(ChatColor.RED + "Nie mozesz sie teleportowac na event z poziomu konsoli (logiczne)!");
					return true;
				}
				if(Event.getEvent() == false) {
					sender.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + "Obecnie nie trwa zaden event! :(");
					return true;
				}
				Player player = (Player) sender;
				player.performCommand("warp Event");
				return true;
			}
			if(args.length == 1) {
				if(!sender.isOp()) {
					sender.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + "Brak odpowiednich uprawnien!");
					return true;
				}
				if(args[0].equalsIgnoreCase("false")) {
					if(Event.getEvent() == false) {
						sender.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + "Event juz jest wylaczony!");
						return true;
					}
					Event.setEvent(false, sender);
					return true;
				}
				if(args[0].equalsIgnoreCase("true")) {
					if(Event.getEvent() == true) {
						sender.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + "Event juz jest wlaczony!");
						return true;
					}
					Event.setEvent(true, sender);
					return true;
				} else {
					sender.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + "Argument \"" + args[0] + "\" jest dla mnie niezrozumialy :(, spróbuj jeszcze raz!");
					return true;
				}
			} else {
				sender.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + "Przykro mi, lecz podalas/es zbyt duzo argumentów!");
				return true;
			}
		}
		return false;
	}
	
}
