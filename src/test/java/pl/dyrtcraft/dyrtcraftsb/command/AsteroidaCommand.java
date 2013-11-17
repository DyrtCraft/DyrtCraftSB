package pl.dyrtcraft.dyrtcraftsb.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.dyrtcraft.dyrtcraftsb.DyrtCraftSB;

/**
 * Komendy do pluginu IslandWorld
 * @author TheMolkaPL
 */
public class AsteroidaCommand implements CommandExecutor {

	DyrtCraftSB plugin;
	String komenda = "island";
	
	public AsteroidaCommand(DyrtCraftSB dyrtCraftSB) {
		plugin = dyrtCraftSB;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(command.getName().equalsIgnoreCase("asteroida") || command.getName().equalsIgnoreCase("as") || command.getName().equalsIgnoreCase("is"))) { return false; }
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tej komendy z poziomu konsoli!");
			return true;
		}
		Player p = (Player) sender;
		
		if(args.length == 0) {
			return erArg(p, "Podano zbyt malo argumentów");
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("?") || args[0].equalsIgnoreCase("pomoc") || args[0].equalsIgnoreCase("help")) {
				return helpArg(p);
			}
			if(args[0].equalsIgnoreCase("stworz") || args[0].equalsIgnoreCase("stwórz") || args[0].equalsIgnoreCase("create")) {
				return createArg(p);
			}
			if(args[0].equalsIgnoreCase("usun") || args[0].equalsIgnoreCase("delete")) {
				return deleteArg(p);
			}
			if(args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("o") || args[0].equalsIgnoreCase("about")) {
				return infoArg(p);
			}
			if(args[0].equalsIgnoreCase("ustawdom") || args[0].equalsIgnoreCase("sethome")) {
				return sethomeArg(p);
			}
			if(args[0].equalsIgnoreCase("usundom") || args[0].equalsIgnoreCase("delhome")) {
				return delhomeArg(p);
			}
			if(args[0].equalsIgnoreCase("dom") || args[0].equalsIgnoreCase("wyspa") || args[0].equalsIgnoreCase("home")) {
				return homeArg(p);
			}
			if(args[0].equalsIgnoreCase("naprawdom") || args[0].equalsIgnoreCase("fixhome")) {
				return fixhomeArg(p);
			}
			if(args[0].equalsIgnoreCase("odwiedz") || args[0].equalsIgnoreCase("invite") || args[0].equalsIgnoreCase("tp")) {
				return erArg(p, "Podano zbyt malo argumentów");
			}
			if(args[0].equalsIgnoreCase("opusc") || args[0].equalsIgnoreCase("leave")) {
				return leaveArg(p);
			}
			if(args[0].equalsIgnoreCase("zabezpiecz") || args[0].equalsIgnoreCase("protect")) {
				return protectArg(p);
			}
			if(args[0].equalsIgnoreCase("odbezpiecz") || args[0].equalsIgnoreCase("unprotect")) {
				return unprotectArg(p);
			}
			if(args[0].equalsIgnoreCase("wyrzuc") || args[0].equalsIgnoreCase("remove")) {
				return removeArg(p, args[1]);
			}
			if(args[0].equalsIgnoreCase("dodaj") || args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("wyrzuc") || args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("odwiedz") || args[0].equalsIgnoreCase("invite") || args[0].equalsIgnoreCase("tp")) {
				return erArg(p, "Podano zbyt malo argumentów");
			} else {
				return erArg(p, "Podano nieprawidlowy argument");
			}
		}
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("stworz") || args[0].equalsIgnoreCase("stwórz") || args[0].equalsIgnoreCase("create")) {
				return createVipArg(p);
			}
			if(args[0].equalsIgnoreCase("dodaj") || args[0].equalsIgnoreCase("add")) {
				return addArg(p, args[1]);
			}
			if(args[0].equalsIgnoreCase("wyrzuc") || args[0].equalsIgnoreCase("remove")) {
				return removeArg(p, args[1]);
			}
			if(args[0].equalsIgnoreCase("odwiedz") || args[0].equalsIgnoreCase("invite") || args[0].equalsIgnoreCase("tp")) {
				return tpArg(p, args[1]);
			} else {
				return erArg(p, "Podano nieprawidlowy argument");
			}
		} else {
			return erArg(p, "Podano zbyt duzo argumentów");
		}
	}
	
	private boolean erArg(Player p, String reason) {
		p.sendMessage(DyrtCraftSB.prefix() + ChatColor.RED + reason + "!");
		p.sendMessage(ChatColor.BLUE + "Aby uzyskac pomoc SkyOS 2.0, uzyj komendy /as pomoc");
		return true;
	}
	
	private boolean helpArg(Player p) {
		p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "	        Zarzadzanie systemem SkyOS 2.0");
		
		if(!p.hasPermission("dyrtcraftsb.vip")) { // Gracz
			p.sendMessage(ChatColor.GRAY + "/as stwórz " + ChatColor.BLUE + "- Tworzy asteroida");
			p.sendMessage(ChatColor.GRAY + "/as usun " + ChatColor.BLUE + "- Usuwa asteroide");
			p.sendMessage(ChatColor.GRAY + "/as info " + ChatColor.BLUE + "- Pokazuje informacje o asteroidzie");
			p.sendMessage(ChatColor.GRAY + "/as ustawdom " + ChatColor.BLUE + "- Ustawia punkt domu");
			p.sendMessage(ChatColor.GRAY + "/as usundom " + ChatColor.BLUE + "- Usuwa punkt domu");
			p.sendMessage(ChatColor.GRAY + "/as dom " + ChatColor.BLUE + "- Teleportuje na asteroidzie");
			p.sendMessage(ChatColor.GRAY + "/as naprawdom " + ChatColor.BLUE + "- Naprawia punkt domu");
			p.sendMessage(ChatColor.GRAY + "/as dodaj <nick> " + ChatColor.BLUE + "- Dodaje kolege do asteroidy");
			p.sendMessage(ChatColor.GRAY + "/as wyrzuc <nick> " + ChatColor.BLUE + "- Wyrzuca kolege z asteroidy");
			p.sendMessage(ChatColor.GRAY + "/as odwiedz <nick> " + ChatColor.BLUE + "- Odwiedza asteroide innego gracza");
			p.sendMessage(ChatColor.GRAY + "/as opusc " + ChatColor.BLUE + "- Opuszcza swoja asteroide");
			p.sendMessage(ChatColor.GRAY + "/as zabezpiecz " + ChatColor.BLUE + "- Zabezpiecza asteroide przed innymi graczami");
			p.sendMessage(ChatColor.GRAY + "/as odbezpiecz " + ChatColor.BLUE + "- Odbezpiecza asteroide od innych graczy");
			return true;
		} else { // VIP/sVIP
			p.sendMessage(ChatColor.GRAY + "/as stwórz " + ChatColor.BLUE + "- Tworzy asteroide");
			p.sendMessage(ChatColor.GRAY + "/as stwórz vip " + ChatColor.BLUE + "- Tworzy asteroide dla VIP'a");
			p.sendMessage(ChatColor.GRAY + "/as usun " + ChatColor.BLUE + "- Usuwa asteroide");
			p.sendMessage(ChatColor.GRAY + "/as info " + ChatColor.BLUE + "- Pokazuje informacje o asteroidzie");
			p.sendMessage(ChatColor.GRAY + "/as ustawdom " + ChatColor.BLUE + "- Ustawia punkt domu");
			p.sendMessage(ChatColor.GRAY + "/as usundom " + ChatColor.BLUE + "- Usuwa punkt domu");
			p.sendMessage(ChatColor.GRAY + "/as dom " + ChatColor.BLUE + "- Teleportuje na asteroidzie");
			p.sendMessage(ChatColor.GRAY + "/as naprawdom " + ChatColor.BLUE + "- Naprawia punkt domu");
			p.sendMessage(ChatColor.GRAY + "/as dodaj <nick> " + ChatColor.BLUE + "- Dodaje kolege do asteroidy");
			p.sendMessage(ChatColor.GRAY + "/as wyrzuc <nick> " + ChatColor.BLUE + "- Wyrzuca kolege z asteroidy");
			p.sendMessage(ChatColor.GRAY + "/as odwiedz <nick> " + ChatColor.BLUE + "- Odwiedza asteroide innego gracza");
			p.sendMessage(ChatColor.GRAY + "/as opusc " + ChatColor.BLUE + "- Opuszcza swoja asteroide");
			p.sendMessage(ChatColor.GRAY + "/as zabezpiecz " + ChatColor.BLUE + "- Zabezpiecza asteroide przed innymi graczami");
			p.sendMessage(ChatColor.GRAY + "/as odbezpiecz " + ChatColor.BLUE + "- Odbezpiecza asteroide od innych graczy");
			return true;
		}
	}
	
	private boolean createArg(Player p) {
		p.chat("/" + komenda + " create");
		p.chat("/kit Podstawowy");
		return true;
	}
	
	private boolean createVipArg(Player p) {
		p.chat("/" + komenda + " create vip");
		p.chat("/kit Podstawowy");
		return true;
	}
	
	private boolean unprotectArg(Player p) {
		p.chat("/" + komenda + " unprotect");
		return true;
	}

	private boolean protectArg(Player p) {
		p.chat("/" + komenda + " protect");
		return true;
	}

	private boolean leaveArg(Player p) {
		p.chat("/" + komenda + " leave");
		return true;
	}

	private boolean fixhomeArg(Player p) {
		p.chat("/" + komenda + " fixhome");
		return true;
	}

	private boolean delhomeArg(Player p) {
		p.chat("/" + komenda + " delhome");
		return true;
	}

	private boolean sethomeArg(Player p) {
		p.chat("/" + komenda + " sethome");
		return true;
	}

	private boolean infoArg(Player p) {
		p.chat("/" + komenda + " info");
		return true;
	}

	private boolean deleteArg(Player p) {
		p.chat("/" + komenda + " delete");
		return true;
	}
	
	private boolean homeArg(Player p) {
		p.chat("/" + komenda + " home");
		return true;
	}
	
	private boolean tpArg(Player p, String arg) {
		p.chat("/" + komenda + " tp " + arg);
		return true;
	}

	private boolean removeArg(Player p, String arg) {
		p.chat("/" + komenda + " remove " + arg);
		return true;
	}

	private boolean addArg(Player p, String arg) {
		p.chat("/" + komenda + " add " + arg);
		return true;
	}
	
}
