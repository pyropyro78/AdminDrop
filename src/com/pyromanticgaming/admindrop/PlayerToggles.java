package com.pyromanticgaming.admindrop;


import java.util.HashMap;

public class PlayerToggles {

	private static AdminDrop plugin;

	public PlayerToggles(AdminDrop instance) {
		plugin = instance;
	}

	public static HashMap<String, Boolean> dropaccess = new HashMap<>();
	public static HashMap<String, Boolean> pickupaccess = new HashMap<>();
	public static HashMap<String, Boolean> throwaccess = new HashMap<>();
	public static HashMap<String, Boolean> chestaccess = new HashMap<>();
	public static HashMap<String, Boolean> blockbreak = new HashMap<>();
	public static HashMap<String, Boolean> blockplace = new HashMap<>();




	public static void setDropAccess(String player, boolean toggle) {
		dropaccess.put(player,  toggle);
	}

	public static void setPickUpAccess(String player, boolean toggle) {
		pickupaccess.put(player,  toggle);
	}

	public static void setThrowAccess(String player, boolean toggle) {
		throwaccess.put(player,  toggle);
	}

	public static void setChestAccess(String player, boolean toggle) {
		chestaccess.put(player,  toggle);
	}

	public static void setBlockBreak(String player, boolean toggle) {
		blockbreak.put(player,  toggle);
	}

	public static void setBlockPlace(String player, boolean toggle) {
		blockplace.put(player,  toggle);
	}



	public static void clearHashmaps() {
		PlayerToggles.blockbreak.clear();
		PlayerToggles.blockplace.clear();
		PlayerToggles.chestaccess.clear();
		PlayerToggles.dropaccess.clear();
		PlayerToggles.throwaccess.clear();
		PlayerToggles.pickupaccess.clear();
	}



	public static boolean listedChestAccess(String player) {

		return chestaccess.containsKey(player);
	}

	public static boolean listedThrowAccess(String player) {

		return throwaccess.containsKey(player);
	}

	public static boolean listedPickUpAccess(String player) {

		return pickupaccess.containsKey(player);
	}

	public static boolean listedDropAccess(String player) {

		return dropaccess.containsKey(player);
	}

	public static boolean listedBlockBreak(String player) {

		return blockbreak.containsKey(player);
	}

	public static boolean listedBlockPlace(String player) {

		return blockplace.containsKey(player);
	}



	public static HashMap<String, Boolean> getChestAccessMap() {

		return chestaccess;
	}

	public static HashMap<String, Boolean> getDropAccessMap() {

		return dropaccess;
	}

	public static HashMap<String, Boolean> getThrowAccessMap() {

		return throwaccess;
	}

	public static HashMap<String, Boolean> getPickUpAccessMap() {

		return pickupaccess;
	}

	public static HashMap<String, Boolean> getBlockBreakMap() {

		return blockbreak;
	}

	public static HashMap<String, Boolean> getBlockPlaceMap() {

		return blockplace;
	}



	public static AdminDrop getPlugin() {

		return plugin;
	}

}
