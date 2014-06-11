package pl.dyrtcraft.dyrtcraftsb.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

public class RespawnListener implements Listener {
	
	DyrtCraftSB plugin;
	
	public RespawnListener(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
	}
	
}
