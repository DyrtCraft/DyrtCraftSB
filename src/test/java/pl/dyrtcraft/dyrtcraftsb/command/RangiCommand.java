package pl.dyrtcraft.dyrtcraftsb.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;
import pl.dyrtcraft.dyrtcraftsb.Shop;

public class RangiCommand implements CommandExecutor {
	
	DyrtCraftSB plugin;
	
	public RangiCommand(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String cmd = command.getName();
		if(cmd.equalsIgnoreCase("rangi") || cmd.equalsIgnoreCase("ranks") || cmd.equalsIgnoreCase("vip") || cmd.equalsIgnoreCase("svip") || cmd.equalsIgnoreCase("donate")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Nie otworzyc menu z zakupem rang z poziomu konsoli (logiczne)!");
				return true;
			}
			Player player = (Player) sender;
			player.sendMessage(DyrtCraftSB.prefix() + ChatColor.BLUE + "Otwieranie menu z wyborem rang na serwerze...");
			player.openInventory(Shop.inv);
			return true;
		}
		return false;
	}
	
}
