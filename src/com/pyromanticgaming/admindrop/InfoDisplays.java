package com.pyromanticgaming.admindrop;

import org.bukkit.command.CommandSender;

import com.pyromanticgaming.admindrop.Config.MainConfig;

public class InfoDisplays {

	public static void commadInfo(CommandSender sender) {
		sender.sendMessage("/ad deathdrop - Toggles Death Drops on/off");
		sender.sendMessage("/ad deathdrop [player/online] - Toggles other's Death Drops on/off");
		sender.sendMessage("/ad deathdrop [player/online/all] [ON/OFF] - Toggles other's Death Drops on/off");
		sender.sendMessage("/ad throwaway - Toggles throwing items");
		sender.sendMessage("/ad throwaway [player/online] - Toggles other's throw away items on/off");
		sender.sendMessage("/ad throwaway [player/online/all] [ON/OFF] - Toggles other's throw away items on/off");
		sender.sendMessage("/ad pickup - Toggles the ability to pick up items on/off");
		sender.sendMessage("/ad pickup [player/online] - Toggles other's ability to pick up items on/off");
		sender.sendMessage("/ad pickup [player/online/all] [ON/OFF] - Toggles other's ability to pick up items on/off");
		sender.sendMessage("/ad chestaccess - Toggles the ability to open chests on/off");
		sender.sendMessage("/ad chestaccess [player/online] - Toggles other's ability to open chests on/off");
		sender.sendMessage("/ad chestaccess [player/online/all] [ON/OFF] - Toggles other's ability to open chests on/off");
		sender.sendMessage("/ad blockbreak - Toggles the restriction to break blocks on/off");
		sender.sendMessage("/ad blockbreak [player/online] - Toggles other's restriction to break blocks on/off");
		sender.sendMessage("/ad blockbreak [player/online/all] [ON/OFF] - Toggles other's restriction to break blocks on/off");
		sender.sendMessage("/ad blockplace - Toggles the restriction to place blocks on/off");
		sender.sendMessage("/ad blockplace [player/online] - Toggles other's restriction to place blocks on/off");
		sender.sendMessage("/ad blockplace [player/online/all] [ON/OFF] - Toggles other's restriction to place blocks on/off");
		sender.sendMessage("/ad status - Gets current status");
		sender.sendMessage("/ad help - Displays commands");
		sender.sendMessage("/ad status [player] - Gets players current status");
		sender.sendMessage("/ad alt - Shows alternate commands");
	}

	public static void altCommandInfo(CommandSender sender) {
		sender.sendMessage("/ad dd - Toggles Death Drops on/off");
		sender.sendMessage("/ad dd [player/online] - Toggles other's Death Drops on/off");
		sender.sendMessage("/ad dd [player/online/all] [ON/OFF] - Toggles other's Death Drops on/off");
		sender.sendMessage("/ad ta - Toggles throwing items");
		sender.sendMessage("/ad ta [player/online] - Toggles other's throw away items on/off");
		sender.sendMessage("/ad ta [player/online/all] [ON/OFF] - Toggles other's throw away items on/off");
		sender.sendMessage("/ad pu - Toggles the ability to pick up items on/off");
		sender.sendMessage("/ad pu [player/online] - Toggles other's ability to pick up items on/off");
		sender.sendMessage("/ad pu [player/online/all] [ON/OFF] - Toggles other's ability to pick up items on/off");
		sender.sendMessage("/ad ca - Toggles the ability to open chests on/off");
		sender.sendMessage("/ad ca [player/online] - Toggles other's ability to open chests on/off");
		sender.sendMessage("/ad ca [player/online/all] [ON/OFF] - Toggles other's ability to open chests on/off");
		sender.sendMessage("/ad bb - Toggles the restriction to break blocks on/off");
		sender.sendMessage("/ad bb [player/online] - Toggles other's restriction to break blocks on/off");
		sender.sendMessage("/ad bb [player/online/all] [ON/OFF] - Toggles other's restriction to break blocks on/off");
		sender.sendMessage("/ad bp - Toggles the restriction to place blocks on/off");
		sender.sendMessage("/ad bp [player/online] - Toggles other's restriction to place blocks on/off");
		sender.sendMessage("/ad bp [player/online/all] [ON/OFF] - Toggles other's restriction to place blocks on/off");
		sender.sendMessage("/ad status - Gets current status");
		sender.sendMessage("/ad help - Displays commands");
		sender.sendMessage("/ad status [player] - Gets players current status");
		sender.sendMessage("/ad ac - Shows alternate commands");
	}

	public static void playerNotFoundInfo(CommandSender sender) {
		sender.sendMessage(MainConfig.playernotfoundmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	}
	
}
