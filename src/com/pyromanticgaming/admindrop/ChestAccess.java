package com.pyromanticgaming.admindrop;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChestAccess {

	static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn) {
		if (PlayerToggles.chestaccess.get(sender.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess")) {
				disable(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.chestactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				return;
			}
		} else if (alwaysOn) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.chestalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			return;
		} else {
			enable(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.chestdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
	}
	
	static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.chestactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setChestAccess(player.getName(), true);
	}

	static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.chestdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setChestAccess(player.getName(), false);
	}

	static void command(CommandSender sender) {
		Player player = (Player) sender;
		if (PlayerToggles.chestaccess.get(sender.getName()) == false) {
			disable(player, sender);
		} else {
			enable(player, sender);
		}

	}
		
}
