package pl.dyrtcraft.dyrtcraftsb;

import org.bukkit.command.CommandSender;

import pl.DyrtCraft.DyrtCraftXP.api.DyrtCraftPlugin;

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
		
		DyrtCraftPlugin.sendMsgToOp(setter.getName() + " ustawil event na " + value, 0);
	}
	
}
