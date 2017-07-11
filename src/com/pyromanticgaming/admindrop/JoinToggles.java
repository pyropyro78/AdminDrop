package com.pyromanticgaming.admindrop;

public class JoinToggles {

private static AdminDrop plugin;

	public MainConfig(AdminDrop instance) {
		plugin = instance;
	}

public void main(String p) {
if (!PlayerToggles.listedDropAccess(p)) {

			if (e.getPlayer().hasPermission("AdminDrop.alwayson.deathdrop") && !e.getPlayer().hasPermission("AdminDrop.ignore.star.deathdrop")) {

				PlayerToggles.dropaccess.put(p, true);

			} else {

				PlayerToggles.dropaccess.put(p, false);

			}
		}
		if (!PlayerToggles.listedThrowAccess(p)) {

			if (e.getPlayer().hasPermission("AdminDrop.alwayson.throwaway") && !e.getPlayer().hasPermission("AdminDrop.ignore.star.throwaway")) {

				PlayerToggles.throwaccess.put(p, true);

			} else {

				PlayerToggles.throwaccess.put(p, false);

			}

		}
		if (!PlayerToggles.listedPickUpAccess(p)) {

			if (e.getPlayer().hasPermission("AdminDrop.alwayson.pickup") && !e.getPlayer().hasPermission("AdminDrop.ignore.star.pickup")) {

				PlayerToggles.pickupaccess.put(p, true);

			} else {

				PlayerToggles.pickupaccess.put(p, false);

			}

		}
		if (!PlayerToggles.listedChestAccess(p)) {

			if (e.getPlayer().hasPermission("AdminDrop.alwayson.chestaccess") && !e.getPlayer().hasPermission("AdminDrop.ignore.star.chestaccess")) {

				PlayerToggles.chestaccess.put(p, true);

			} else {

				PlayerToggles.chestaccess.put(p, false);

			}

		}
		if (!PlayerToggles.listedBlockBreak(p)) {

			if (e.getPlayer().hasPermission("AdminDrop.alwayson.block.break") && !e.getPlayer().hasPermission("AdminDrop.ignore.star.block.break")) {

				PlayerToggles.blockbreak.put(p, true);

			} else {

				PlayerToggles.blockbreak.put(p, false);

			}

		}
		if (!PlayerToggles.listedBlockPlace(p)) {

			if (e.getPlayer().hasPermission("AdminDrop.alwayson.block.place") && !e.getPlayer().hasPermission("AdminDrop.ignore.star.block.place")) {

				PlayerToggles.blockplace.put(p, true);

			} else {

				PlayerToggles.blockplace.put(p, false);

			}

		}
}

}