package com.pyromanticgaming.admindrop;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockPlace {

	static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn) {
		if (PlayerToggles.blockplace.get(otherPlayer.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.block.palce")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.block.place")) {
				disable(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.blockplaceactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				return;
			}
		} else if (alwaysOn) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.blockplacealwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			return;
		} else {
			enable(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.blockplacedeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}

	static void modifySelf(CommandSender sender) {
		// Reason for the conversion here is to use Player in a later function
		// instead of CommandSender
		Player player = (Player) sender;
		// If the players name is not in the hashmap it
		// will stop drops on death
		if (PlayerToggles.blockplace.get(player.getName()) == false) {
			disable(player, sender);
		} else {
			// Otherwise it will run this function to allow drops to take
			// place again on death
			enable(player, sender);
		}
	}
	
	static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.blockplaceactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setBlockPlace(player.getName(), true);
	}

	static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.blockplacedeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setBlockPlace(player.getName(), false);
	}

}
