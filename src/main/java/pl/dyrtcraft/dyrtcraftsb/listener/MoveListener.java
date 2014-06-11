package pl.dyrtcraft.dyrtcraftsb.listener;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
	
	/**
	 * @author Deathmarin
	 */
	//@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		/*if(e.getFrom().getY() > e.getTo().getY() && !e.getPlayer().isOnGround() && e.getTo().getBlock().getType() == Material.AIR) {
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
			
			Vector v1 = e.getPlayer().getLocation().getDirection();
			v1.setY(-2);
			e.getPlayer().setVelocity(v1.multiply(0.03));
			e.getPlayer().setFallDistance(0);
			
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
		}*/
		Location loc1 = new Location(e.getTo().getWorld(), e.getTo().getX(), e.getTo().getBlockY() - 1, e.getTo().getZ());
		Location loc2 = new Location(e.getTo().getWorld(), e.getTo().getX(), e.getTo().getBlockY() - 2, e.getTo().getZ());
		
		if(loc1.getBlock().getType() == Material.AIR || loc2.getBlock().getType() == Material.AIR) {
			if(!(e.getPlayer().getGameMode() == GameMode.CREATIVE)) {
				e.getPlayer().teleport(new Location(e.getTo().getWorld(), e.getTo().getX(), e.getTo().getBlockY() - 0.1, e.getTo().getZ()));
			}
		}
	}
	
}
