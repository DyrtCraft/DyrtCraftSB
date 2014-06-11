package pl.dyrtcraft.dyrtcraftsb;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import pl.dyrtcraft.dyrtcraftsb.command.AsteroidaCommand;
import pl.dyrtcraft.dyrtcraftsb.command.DcsbCommand;
import pl.dyrtcraft.dyrtcraftsb.command.EventCommand;
import pl.dyrtcraft.dyrtcraftsb.command.SklepCommand;
import pl.dyrtcraft.dyrtcraftsb.listener.Chat;
import pl.dyrtcraft.dyrtcraftsb.listener.JoinListener;
import pl.dyrtcraft.dyrtcraftsb.listener.MobListener;
import pl.dyrtcraft.dyrtcraftsb.listener.MoveListener;
import pl.dyrtcraft.dyrtcraftsb.listener.QuitListener;
import pl.dyrtcraft.dyrtcraftsb.listener.RespawnListener;

/**
 * Gl�wna klasa pluginu
 * @author TheMolkaPL
 */
public class DyrtCraftSB extends JavaPlugin {

	Crafting crafting;
	
	@Override
	public void onEnable() {
		long loadTime = System.currentTimeMillis();
		
		if(getServer().getPluginManager().getPlugin("PermissionsEx") == null) {
			getLogger().log(Level.SEVERE, "Brak pluginu PermissionsEx!");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		if(!(getServer().getPluginManager().getPlugin("VanishNoPacket") == null)) {
			getLogger().log(Level.INFO, "Plugin VanishNoPacket zostal poprawnie wykryty!");
		}
		
		getCommand("asteroida").setExecutor(new AsteroidaCommand(this));
		getCommand("dcsb").setExecutor(new DcsbCommand(this));
		getCommand("event").setExecutor(new EventCommand(this));
		getCommand("sklep").setExecutor(new SklepCommand(this));
		
		getServer().getPluginManager().registerEvents(new Chat(), this);
		getServer().getPluginManager().registerEvents(new MoveListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		getServer().getPluginManager().registerEvents(new MobListener(this), this);
		getServer().getPluginManager().registerEvents(new QuitListener(this), this);
		getServer().getPluginManager().registerEvents(new RespawnListener(this), this);
		
		getServer().addRecipe(Crafting.mossy());
		getServer().addRecipe(Crafting.snieg());
		getServer().addRecipe(Crafting.lod());
		getServer().addRecipe(Crafting.end());
		getServer().addRecipe(Crafting.quartz());
		getServer().addRecipe(Crafting.lampa());
		getServer().addRecipe(Crafting.brick());
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(player.hasPermission("")) {
				player.setPlayerListName(ChatColor.DARK_GREEN + player.getDisplayName());
			}
			if(player.isOp()) {
				player.setPlayerListName(ChatColor.RED + player.getDisplayName());
			} else {
				player.setPlayerListName(ChatColor.BLUE + player.getDisplayName());
			}
		}
		
		Event.setEvent(false);
		
		long finLoadTime = System.currentTimeMillis() - loadTime;
		getLogger().log(Level.INFO, prefix() + "Plugin DyrtCraftSB zostal pomyslnie zaladowany w " + finLoadTime + " ms!");
	}
	
	public static String prefix() {
		return ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "SkyOS 2.0" + ChatColor.DARK_GRAY + "] ";
	}
	
}
