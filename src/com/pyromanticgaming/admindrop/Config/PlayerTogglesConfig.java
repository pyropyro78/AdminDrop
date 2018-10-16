package com.pyromanticgaming.admindrop.Config;


import com.pyromanticgaming.admindrop.PlayerToggles;

public class PlayerTogglesConfig {

	public static void saveToggles() {

		for(String p : PlayerToggles.getChestAccessMap().keySet()) {
			ConfigManager.setValue(ConfigManager.playerdataconfig, "Players." + p + ".ChestAccess", PlayerToggles.getChestAccessMap().get(p));
		}

		for(String p : PlayerToggles.getDropAccessMap().keySet()) {
			ConfigManager.setValue(ConfigManager.playerdataconfig, "Players." + p + ".DropAccess", PlayerToggles.getDropAccessMap().get(p));
		}

		for(String p : PlayerToggles.getThrowAccessMap().keySet()) {
			ConfigManager.setValue(ConfigManager.playerdataconfig, "Players." + p + ".ThrowAccess", PlayerToggles.getThrowAccessMap().get(p));
		}

		for(String p : PlayerToggles.getPickUpAccessMap().keySet()) {
			ConfigManager.setValue(ConfigManager.playerdataconfig, "Players." + p + ".PickUpAccess", PlayerToggles.getPickUpAccessMap().get(p));
		}

		for(String p : PlayerToggles.getBlockBreakMap().keySet()) {
			ConfigManager.setValue(ConfigManager.playerdataconfig, "Players." + p + ".BlockBreak", PlayerToggles.getBlockBreakMap().get(p));
		}

		for(String p : PlayerToggles.getBlockPlaceMap().keySet()) {
			ConfigManager.setValue(ConfigManager.playerdataconfig, "Players." + p + ".BlockPlace", PlayerToggles.getBlockPlaceMap().get(p));
		}

		ConfigManager.trySave(ConfigManager.playerdataconfig);
	}

	public static void loadToggles() {
		if(!ConfigManager.playerdataconfig.contains("Players")) {
			return;
		}

		for(String s : ConfigManager.playerdataconfig.getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setChestAccess(s, ConfigManager.playerdataconfig.getBoolean("Players." + s + ".ChestAccess"));
		}

		for(String s : ConfigManager.playerdataconfig.getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setDropAccess(s, ConfigManager.playerdataconfig.getBoolean("Players." + s + ".DropAccess"));
		}

		for(String s : ConfigManager.playerdataconfig.getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setPickUpAccess(s, ConfigManager.playerdataconfig.getBoolean("Players." + s + ".PickUpAccess"));
		}

		for(String s : ConfigManager.playerdataconfig.getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setThrowAccess(s, ConfigManager.playerdataconfig.getBoolean("Players." + s + ".ThrowAccess"));
		}

		for(String s : ConfigManager.playerdataconfig.getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setBlockBreak(s, ConfigManager.playerdataconfig.getBoolean("Players." + s + ".BlockBreak"));
		}

		for(String s : ConfigManager.playerdataconfig.getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setBlockPlace(s, ConfigManager.playerdataconfig.getBoolean("Players." + s + ".BlockPlace"));
		}

	}
}
