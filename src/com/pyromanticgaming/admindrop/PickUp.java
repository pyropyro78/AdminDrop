package com.pyromanticgaming.admindrop;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PickUp {

	static void ModifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn) {
		if (PlayerToggles.pickupaccess.get(sender.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
				Disable(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.pickupactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				return;
			}
		} else if (alwaysOn) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.pickupalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			return;
		} else {
			Enable(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.pickupdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}
	
	static void Command(CommandSender sender) {
		Player player = (Player) sender;
		if (PlayerToggles.pickupaccess.get(player.getName()) == false) {
			Disable(player, sender);
		} else {
			Enable(player, sender);
		}
	}

	static void Disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.pickupactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setPickUpAccess(player.getName(), true);
	}

	static void Enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.pickupdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setPickUpAccess(player.getName(), false);
	}
	
}
