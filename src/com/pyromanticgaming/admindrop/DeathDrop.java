package com.pyromanticgaming.admindrop;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathDrop {
	
	static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn) {
		if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrops")) {
				disable(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.dropactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				return;
			}
		} else if (alwaysOn) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.dropalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			return;
		} else {
			DeathDrop.enable(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.dropdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}
	
	static void command(CommandSender sender) {
		// Reason for the conversion here is to use Player in a later function
		// instead of CommandSender
		Player player = (Player) sender;
		// If the players name is not in the hashmap it
		// will stop drops on death
		if (PlayerToggles.dropaccess.get(player.getName()) == false) {
			disable(player, sender);
		} else {
			// Otherwise it will run this function to allow drops to take
			// place again on death
			enable(player, sender);
		}
	}
	
	static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.dropactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setDropAccess(player.getName(), true);

	}
	
	static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.dropdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setDropAccess(player.getName(), false);
	}
}
