package com.pyromanticgaming.admindrop;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ConfigManager {

	public static File mainconfigfile;
	public static FileConfiguration mianconfig;
	public static File playerfile;
	public static FileConfiguration playerconfig;

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

	}

	public static void fileGenerator() throws IOException {
		if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
		playerfile = new File(plugin.getDataFolder(), "players.yml");

		if (!playerfile.exists()) playerfile.createNewFile();

		saveDefaultMainConfig();
		
		mianconfig = YamlConfiguration.loadConfiguration(mainconfigfile);
		playerconfig = YamlConfiguration.loadConfiguration(playerfile);

	}
	
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
		return c.getKeys(false) == YamlConfiguration.loadConfiguration(mainconfigfile) ? mainconfigfile : playerfile;
	}
}