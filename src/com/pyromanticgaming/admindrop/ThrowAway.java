package com.pyromanticgaming.admindrop;


import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pyromanticgaming.admindrop.Config.ConfigManager;
import com.pyromanticgaming.admindrop.Config.MainConfig;

public class ThrowAway {

	public static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn, String[] args) {
		if (args.length == 3) {
			if (args[2].equalsIgnoreCase("ON")) {
				if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
					if (!otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
							|| otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
						disable(otherPlayer, sender);
						sender.sendMessage(ChatColor.ITALIC
								+ otherPlayer.getDisplayName()
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
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.throwactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				}
			} else if (args[2].equalsIgnoreCase("OFF")) {
				if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
					if (!otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
							|| otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
						sender.sendMessage(ChatColor.ITALIC
								+ otherPlayer.getDisplayName()
								+ " "
								+ MainConfig.throwdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
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
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.throwdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				}
			}
		} else 
			if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
				if (!otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
						|| otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
					disable(otherPlayer, sender);
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
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
						+ otherPlayer.getDisplayName()
						+ " "
						+ MainConfig.throwdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}

	}

	public static void modifyAll(Boolean valueSetting) {
		for (Map.Entry<String, Boolean> toggleEntry : PlayerToggles.throwaccess.entrySet()) {
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
		if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
			disable(player, sender);
		} else {
			enable(player, sender);
		}

	}

	private static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.throwactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setThrowAccess(player.getName(), true);
	}

	private static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.throwdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setThrowAccess(player.getName(), false);
	}

}
