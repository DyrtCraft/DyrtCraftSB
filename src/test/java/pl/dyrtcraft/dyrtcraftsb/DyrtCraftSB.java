package pl.dyrtcraft.dyrtcraftsb;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import pl.DyrtCraft.DyrtCraftXP.api.XP;

import pl.dyrtcraft.dyrtcraftsb.command.AsteroidaCommand;
import pl.dyrtcraft.dyrtcraftsb.command.DcsbCommand;
import pl.dyrtcraft.dyrtcraftsb.listener.JoinListener;
import pl.dyrtcraft.dyrtcraftsb.listener.QuitListener;
import pl.dyrtcraft.dyrtcraftsb.listener.SwitchListener;

/**
 * Glówna klasa pluginu
 * @author TheMolkaPL
 */
public class DyrtCraftSB extends JavaPlugin {

	Crafting crafting;
	
	@Override
	public void onEnable() {
		getCommand("asteroida").setExecutor(new AsteroidaCommand(this));
		getCommand("dcsb").setExecutor(new DcsbCommand(this));
		
		getServer().getPluginManager().registerEvents(new Shop(this), this);
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		getServer().getPluginManager().registerEvents(new QuitListener(this), this);
		getServer().getPluginManager().registerEvents(new SwitchListener(this), this);
		
		getServer().addRecipe(Crafting.mossy());
		getServer().addRecipe(Crafting.snieg());
		getServer().addRecipe(Crafting.lod());
		getServer().addRecipe(Crafting.end());
		getServer().addRecipe(Crafting.quartz());
		getServer().addRecipe(Crafting.lampa());
		getServer().addRecipe(Crafting.brick());
	}
	
	public static String prefix() {
		return ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "SkyOS 2.0" + ChatColor.DARK_GRAY + "] ";
	}
	
	public static int getXP(Player player) {
		try {
			int xp = XP.getXp(player.getName());
			return xp;
		} catch(Exception ex) {
			return -1;
		}
	}
	
	public static void buyVIP(Player player) {
		if(XP.delXp(player, 1000, "Zakup rangi VIP na serwerze SkyBlock")) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "azrank " + player.getName() + " VIP 30d");
			Bukkit.broadcastMessage(prefix() + ChatColor.DARK_GRAY + player.getName() + " wlasnie zakupil range VIP!");
			player.sendMessage(prefix() + ChatColor.GOLD + "Dziekujemy Ci, " + player.getName() + " za dotacje serwerowi DyrtCraft Network!");
		} else {
			player.sendMessage(prefix() + ChatColor.RED + "Nie posiadasz wystarczajacej ilosci XP! :(");
		}
	}
	
	public static void buySVIP(Player player) {
		if(XP.delXp(player, 1500, "Zakup rangi sVIP na serwerze SkyBlock")) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "azrank " + player.getName() + " sVIP 30d");
			Bukkit.broadcastMessage(prefix() + ChatColor.DARK_GRAY + player.getName() + " wlasnie zakupil range sVIP!");
			player.sendMessage(prefix() + ChatColor.GOLD + "Dziekujemy Ci, " + player.getName() + " za dotacje serwerowi DyrtCraft Netwprk!");
		} else {
			player.sendMessage(prefix() + ChatColor.RED + "Nie posiadasz wystarczajacej ilosci XP! :(");
		}
	}
	
}
