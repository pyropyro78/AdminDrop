package com.pyromanticgaming.admindrop;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ThrowAway {

	static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn) {
		if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
				disable(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.throwactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				return;
			}
		} else if (alwaysOn) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.throwalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			return;
		} else {
			enable(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.throwdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}
	
	static void command(CommandSender sender) {
		Player player = (Player) sender;
		if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
			disable(player, sender);
		} else {
			enable(player, sender);
		}

	}
	
	static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.throwactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setThrowAccess(player.getName(), true);
	}

	static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.throwdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setThrowAccess(player.getName(), false);
	}
	
}
