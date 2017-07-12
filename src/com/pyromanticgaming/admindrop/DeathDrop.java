package com.pyromanticgaming.admindrop;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pyromanticgaming.admindrop.Config.MainConfig;

public class DeathDrop {

	public static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn, String[] args) {
		if (args.length == 3) {
			if (args[2].equalsIgnoreCase("ON")) {
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
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.dropactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				}
			} else if (args[2].equalsIgnoreCase("OFF")) {
				if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == false) {
					if (!otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")
							|| otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrops")) {
						sender.sendMessage(ChatColor.ITALIC
								+ otherPlayer.getDisplayName()
								+ " "
								+ MainConfig.dropdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						return;
					}
				} else if (alwaysOn) {
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.dropalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				} else {
					enable(otherPlayer, sender);
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.dropdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				}
			}
		} else
			if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == false) {
				if (!otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")
						|| otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrops")) {
					disable(otherPlayer, sender);
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
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
						+ otherPlayer.getDisplayName()
						+ " "
						+ MainConfig.dropdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}

	}

	public static void modifySelf(CommandSender sender) {
		Player player = (Player) sender;
		if (PlayerToggles.dropaccess.get(player.getName()) == false) {
			disable(player, sender);
		} else {
			enable(player, sender);
		}
	}

	private static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.dropactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setDropAccess(player.getName(), true);

	}

	private static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.dropdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setDropAccess(player.getName(), false);
	}
}
