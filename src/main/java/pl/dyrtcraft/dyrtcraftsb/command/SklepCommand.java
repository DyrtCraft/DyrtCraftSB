package pl.dyrtcraft.dyrtcraftsb.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

public class SklepCommand implements CommandExecutor {
	
	DyrtCraftSB plugin;
	
	public SklepCommand(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("sklep") || command.getName().equalsIgnoreCase("shop")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Nie mozesz sie teleportowac do sklepu z poziomu konsoli (logiczne)!");
				return true;
			}
			Player player = (Player) sender;
			player.performCommand("warp Sklep");
			return true;
		}
		return false;
	}
	
}
