package com.pyromanticgaming.admindrop;

import org.bukkit.entity.Player;

public class JoinToggles {

	@SuppressWarnings("unused")
	private static AdminDrop plugin;

	public JoinToggles(AdminDrop instance) {
		plugin = instance;
	}

	public static void runCheck(Player playerjoined) {
		String p = playerjoined.getName();
		if (!PlayerToggles.listedDropAccess(p)) {

			if (playerjoined.hasPermission("AdminDrop.alwayson.deathdrop") && !playerjoined.hasPermission("AdminDrop.ignore.star.deathdrop")) {

				PlayerToggles.dropaccess.put(p, true);

			} else {

				PlayerToggles.dropaccess.put(p, false);

			}
		}
		if (!PlayerToggles.listedThrowAccess(p)) {

			if (playerjoined.hasPermission("AdminDrop.alwayson.throwaway") && !playerjoined.hasPermission("AdminDrop.ignore.star.throwaway")) {

				PlayerToggles.throwaccess.put(p, true);

			} else {

				PlayerToggles.throwaccess.put(p, false);

			}

		}
		if (!PlayerToggles.listedPickUpAccess(p)) {

			if (playerjoined.hasPermission("AdminDrop.alwayson.pickup") && !playerjoined.hasPermission("AdminDrop.ignore.star.pickup")) {

				PlayerToggles.pickupaccess.put(p, true);

			} else {

				PlayerToggles.pickupaccess.put(p, false);

			}

		}
		if (!PlayerToggles.listedChestAccess(p)) {

			if (playerjoined.hasPermission("AdminDrop.alwayson.chestaccess") && !playerjoined.hasPermission("AdminDrop.ignore.star.chestaccess")) {

				PlayerToggles.chestaccess.put(p, true);

			} else {

				PlayerToggles.chestaccess.put(p, false);

			}

		}
		if (!PlayerToggles.listedBlockBreak(p)) {

			if (playerjoined.hasPermission("AdminDrop.alwayson.block.break") && !playerjoined.hasPermission("AdminDrop.ignore.star.block.break")) {

				PlayerToggles.blockbreak.put(p, true);

			} else {

				PlayerToggles.blockbreak.put(p, false);

			}

		}
		if (!PlayerToggles.listedBlockPlace(p)) {

			if (playerjoined.hasPermission("AdminDrop.alwayson.block.place") && !playerjoined.hasPermission("AdminDrop.ignore.star.block.place")) {

				PlayerToggles.blockplace.put(p, true);

			} else {

				PlayerToggles.blockplace.put(p, false);

			}

		}
	}

}