package com.pyromanticgaming.admindrop;


import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pyromanticgaming.admindrop.Config.MainConfig;

public class Status {
	
	public static void selfCommand(CommandSender sender) {
		
		Boolean alwaysDD = (sender.hasPermission("AdminDrop.alwayson.deathdrop") && !sender.hasPermission("AdminDrop.ignore.star.deathdrop"));
		Boolean alwaysCA = (sender.hasPermission("AdminDrop.alwayson.chestaccess") && !sender.hasPermission("AdminDrop.ignore.star.chestaccess"));
		Boolean alwaysTA = (sender.hasPermission("AdminDrop.alwayson.throwaway") && !sender.hasPermission("AdminDrop.ignore.star.throwaway"));
		Boolean alwaysPU = (sender.hasPermission("AdminDrop.alwayson.pickup") && !sender.hasPermission("AdminDrop.ignore.star.pickup"));
		Boolean alwaysBP = (sender.hasPermission("AdminDrop.alwayson.block.place") && !sender.hasPermission("AdminDrop.ignore.star.block.place"));
		Boolean alwaysBB = (sender.hasPermission("AdminDrop.alwayson.block.break") && !sender.hasPermission("AdminDrop.ignore.star.block.break"));

		
		boolean protectme = false;
		if (PlayerToggles.dropaccess.get(sender.getName()) == false
				&& !alwaysDD) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.dropdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (PlayerToggles.dropaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.dropactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (alwaysDD) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.dropalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.throwactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(sender.getName()) == false
				&& !alwaysTA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.throwdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysTA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.throwalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.chestactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(sender.getName()) == false
				&& !alwaysCA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.chestdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysCA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.chestalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.pickupactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(sender.getName()) == false
				&& !alwaysPU) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.pickupdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysPU) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.pickupalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.blockbreak.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.blockbreakactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.blockbreak.get(sender.getName()) == false
				&& !alwaysBB) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.blockbreakdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysBB) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.blockbreakalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.blockplace.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.blockplaceactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.blockbreak.get(sender.getName()) == false
				&& !alwaysBP) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.blockplacedeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysBP) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.blockplacealwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}
		if (!protectme) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.nothingactiveselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}

	public static void otherCommand(Player otherPlayer, CommandSender sender, String[] args) {
		
		Boolean alwaysDD = (otherPlayer.hasPermission("AdminDrop.alwayson.deathdrop") && !otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrop"));
		Boolean alwaysCA = (otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess") && !otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess"));
		Boolean alwaysTA = (otherPlayer.hasPermission("AdminDrop.alwayson.throwaway") && !otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway"));
		Boolean alwaysPU = (otherPlayer.hasPermission("AdminDrop.alwayson.pickup") && !otherPlayer.hasPermission("AdminDrop.ignore.star.pickup"));
		Boolean alwaysBP = (otherPlayer.hasPermission("AdminDrop.alwayson.block.place") && !otherPlayer.hasPermission("AdminDrop.ignore.star.block.place"));
		Boolean alwaysBB = (otherPlayer.hasPermission("AdminDrop.alwayson.block.break") && !otherPlayer.hasPermission("AdminDrop.ignore.star.block.break"));

		
		boolean protectme = false;
		String message = String.format("%s%s", ChatColor.ITALIC,
				otherPlayer.getDisplayName());
		message = message + " ";
		if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == false
				&& !alwaysDD) {
			sender.sendMessage(message + MainConfig.dropdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.dropactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (alwaysDD) {
			sender.sendMessage(message + MainConfig.dropalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.throwactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(otherPlayer.getName()) == false
				&& !alwaysTA) {
			sender.sendMessage(message + MainConfig.throwdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysTA) {
			sender.sendMessage(message + MainConfig.throwalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.chestactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(otherPlayer.getName()) == false
				&& !alwaysCA) {
			sender.sendMessage(message + MainConfig.chestdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysCA) {
			sender.sendMessage(message + MainConfig.chestalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.pickupactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(otherPlayer.getName()) == false 
				&& !alwaysPU) {
			sender.sendMessage(message + MainConfig.pickupdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysPU) {
			sender.sendMessage(message + MainConfig.pickupalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.blockbreak.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.blockbreakactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (alwaysBB) {
			sender.sendMessage(message + MainConfig.blockbreakalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.blockplace.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.blockplaceactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (alwaysBP) {
			sender.sendMessage(message + MainConfig.blockplacealwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}
		if (!protectme) {
			sender.sendMessage(message + MainConfig.nothingactiveothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}
	
}
