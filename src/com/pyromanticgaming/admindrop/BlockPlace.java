package com.pyromanticgaming.admindrop;


import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pyromanticgaming.admindrop.Config.ConfigManager;
import com.pyromanticgaming.admindrop.Config.MainConfig;

public class BlockPlace {

	public static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn, String[] args) {
		if (args.length == 3) {
			if (args[2].equalsIgnoreCase("ON")) {
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
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.blockplaceactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				}
			} else if (args[2].equalsIgnoreCase("OFF")) {
				if (PlayerToggles.blockplace.get(otherPlayer.getName()) == false) {
					if (!otherPlayer.hasPermission("AdminDrop.alwayson.block.palce")
							|| otherPlayer.hasPermission("AdminDrop.ignore.star.block.place")) {
						sender.sendMessage(ChatColor.ITALIC
								+ otherPlayer.getDisplayName()
								+ " "
								+ MainConfig.blockplacedeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
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
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.blockplacedeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				}
			}
		} else 
			if (PlayerToggles.blockplace.get(otherPlayer.getName()) == false) {
				if (!otherPlayer.hasPermission("AdminDrop.alwayson.block.palce")
						|| otherPlayer.hasPermission("AdminDrop.ignore.star.block.place")) {
					disable(otherPlayer, sender);
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
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
						+ otherPlayer.getDisplayName()
						+ " "
						+ MainConfig.blockplacedeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}

	}

	public static void modifyAll(Boolean valueSetting) {
		for (Map.Entry<String, Boolean> toggleEntry : PlayerToggles.blockplace.entrySet()) {
			toggleEntry.setValue(valueSetting);
		}
		ConfigManager.saveAllConfigs();
	}

	public static void modifySelf(CommandSender sender, String args[]) {
		Player player = (Player) sender;
		if (args[1].equalsIgnoreCase("ON")) {
			disable(player, sender);
			ConfigManager.saveAllConfigs();
			return;
		} else
			if (args[1].equalsIgnoreCase("OFF")) {
				enable(player, sender);
				ConfigManager.saveAllConfigs();
				return;
			}
		if (PlayerToggles.blockplace.get(player.getName()) == false) {
			disable(player, sender);
		} else {
			enable(player, sender);
		}
	}

	private static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.blockplaceactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setBlockPlace(player.getName(), true);
	}

	private static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.blockplacedeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setBlockPlace(player.getName(), false);
	}

}
