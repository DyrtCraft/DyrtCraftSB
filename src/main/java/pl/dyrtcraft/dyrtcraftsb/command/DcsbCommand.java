package pl.dyrtcraft.dyrtcraftsb.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

/**
 * Komendy do pluginu
 * @author TheMolkaPL
 */
public class DcsbCommand implements CommandExecutor {

	DyrtCraftSB plugin;
	
	public DcsbCommand(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(args.length == 1)) {
			return erArg(sender, "Nieprawidlowa ilosc argument�w");
		}
		
		if(args[0].equalsIgnoreCase("about") || args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("version")) {
			return aboutArg(sender);
		} else {
			return erArg(sender, "Podano nieprawidlowy argument");
		}
	}
	
	private boolean erArg(CommandSender sender, String reason) {
		sender.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + "Blad! " + reason + "!");
		sender.sendMessage(ChatColor.RED + "Uzycie: " + plugin.getCommand("dcsb").getUsage());
		return true;
	}
	
	private boolean aboutArg(CommandSender sender) {
		sender.sendMessage(ChatColor.BLUE + " =============== DyrtCraftSB =============== ");
		sender.sendMessage(ChatColor.BLUE + "Wersja: " + ChatColor.GRAY + plugin.getDescription().getVersion());
		sender.sendMessage(ChatColor.BLUE + "Autorzy: " + ChatColor.GRAY + plugin.getDescription().getAuthors());
		sender.sendMessage(ChatColor.BLUE + "GitHub: " + ChatColor.GRAY + "https://github.com/DyrtCraft/DyrtCraftSB");
		return true;
	}
	
}
