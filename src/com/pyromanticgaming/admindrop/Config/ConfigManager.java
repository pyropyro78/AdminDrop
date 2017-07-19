package com.pyromanticgaming.admindrop.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.pyromanticgaming.admindrop.AdminDrop;
import com.pyromanticgaming.admindrop.JoinToggles;
import com.pyromanticgaming.admindrop.PlayerToggles;

public class ConfigManager {

	public static File mainconfigfile;
	public static FileConfiguration mianconfig;
	public static File playerdatafile;
	public static FileConfiguration playerdataconfig;

	private static AdminDrop plugin;

	public ConfigManager(AdminDrop instance) {
		plugin = instance;
	}

	public static void onServerEnable() {

		try {
			fileGenerator();
		} catch (IOException e) {
			return;
		}

		MainConfig.GetMainValues(); //Get base values from config
		PlayerTogglesConfig.loadToggles(); //Load player settings

		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			JoinToggles.runCheck(p); //This is ran here to check if player was removed from config during a reload.
		}
		
		saveAllConfigs();

	}

	public static void reloadConfigs() {

		plugin.getLogger().info("AdminDrop config reload started.");
		try {
			fileGenerator();
		} catch (IOException e) {
			return;
		}

		MainConfig.GetMainValues(); //Get base values from config
		
		PlayerToggles.clearHashmaps();
		PlayerTogglesConfig.loadToggles(); //Load player settings

		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			JoinToggles.runCheck(p); //This is ran here to check if player was removed from config during a reload.
		}
		
		saveAllConfigs();
		plugin.getLogger().info("AdminDrop reload completed.");

	}

	public static void fileGenerator() throws IOException {
		if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
		playerdatafile = new File(plugin.getDataFolder(), "playerdata.yml");

		if (!playerdatafile.exists()) playerdatafile.createNewFile();

		saveDefaultMainConfig(); //Check & save defaults as needed

		mianconfig = YamlConfiguration.loadConfiguration(mainconfigfile);
		playerdataconfig = YamlConfiguration.loadConfiguration(playerdatafile);

	}

	//Check for config, if it is not there save the default
	public static void saveDefaultMainConfig() {
		if (mainconfigfile == null) {
			mainconfigfile = new File(plugin.getDataFolder(), "config.yml");
		}
		if (!mainconfigfile.exists()) {            
			plugin.saveResource("config.yml", true);
		}
	}

	public static void setValue(FileConfiguration c, String path, Object value) {
		c.set(path, value);
	}

	public static void saveAllConfigs() {
		PlayerTogglesConfig.saveToggles();
	}

	public static void trySave(FileConfiguration c) {
		try {
			c.save(file(c));
		} catch (IOException e) {
			return;
		}
	}
	public static File file(FileConfiguration c) {
		return c.getKeys(false) == YamlConfiguration.loadConfiguration(mainconfigfile) ? mainconfigfile : playerdatafile;
	}
}