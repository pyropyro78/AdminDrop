package com.pyromanticgaming.admindrop;

import org.bukkit.ChatColor;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdminDrop extends JavaPlugin implements Listener {

	public static int DDLogLevel = 0, TALogLevel = 0, PULogLevel = 0, CALogLevel = 0;
	//	public static String thrownitems;

	@Override
	public void onEnable() {
		getLogger().info("AdminDrop has been enabled.");

		getServer().getPluginManager().registerEvents(this, this);

		this.saveDefaultConfig();
		DDLogLevel = this.getConfig().getInt("DeathDropLogLevel");
		TALogLevel = this.getConfig().getInt("ThrowAwayLogLevel");
		PULogLevel = this.getConfig().getInt("PickUpLogLevel");
		CALogLevel = this.getConfig().getInt("ChestAccessLogLevel");
		//		thrownitems = this.getConfig().getString("thrownitems");

		getCommand("ad").setExecutor(new AdminDropCommandExecutor(this));
	}

	@Override
	public void onDisable() {
		for (Player player : getServer().getOnlinePlayers()) {
			if (AdminDropCommandExecutor.dropless.contains(player.getName())) {
				player.sendMessage(ChatColor.DARK_BLUE
						+ "Your items are not safe.");
				player.sendMessage("AdminDrop is reloading.");
			}
		}

		getLogger().info("AdminDrop has been disabled.");
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		AdminDropCommandExecutor.dropless.remove(player.getName());
		AdminDropCommandExecutor.throwless.remove(player.getName());
		AdminDropCommandExecutor.pickupless.remove(player.getName());
		AdminDropCommandExecutor.chestaccess.remove(player.getName());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath(PlayerDeathEvent event) {
		Entity e = event.getEntity();
		Player p = (Player) e;
		if ((e instanceof Player)
				&& AdminDropCommandExecutor.dropless.contains(p.getName())) {
			event.getDrops().clear();
			p.sendMessage("Your Death Drops were protected.");
			if (DDLogLevel >= 1 && DDLogLevel <= 3) {
				getLogger().info(
						p.getName() + " Has died with Death Drops enabled!");
			}
		} else if ((e instanceof Player) && p.hasPermission("AdminDrop.alwayson.deathdrop") && !p.hasPermission("AdminDrop.ignore.alwayson.deathdrop")) {
			event.getDrops().clear();
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		if ((p instanceof Player)
				&& AdminDropCommandExecutor.throwless.contains(p.getName())) {
			event.setCancelled(true);
			p.sendMessage("Throwing away your items is disabled."); 

			/*			String thrownitemstring = event.getItemDrop().toString();
			if (thrownitems.contains(thrownitemstring) && !thrownitems.isEmpty()) {
				event.setCancelled(true);
				p.sendMessage("Throwing of that item was disabled.");
			} else if (thrownitems.isEmpty()) {
				event.setCancelled(true);
				p.sendMessage("Throwing away your items is disabled."); 
			}*/

		} else if ((p instanceof Player) && p.hasPermission("AdminDrop.alwayson.throwaway") && !p.hasPermission("AdminDrop.ignore.alwayson.throwaway")) {
			event.setCancelled(true);
			p.sendMessage("Throwing away your items is disabled."); 
		}

	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryOpenEvent(InventoryOpenEvent event){
        if (event.getInventory().getHolder() instanceof Chest || event.getInventory().getHolder() instanceof DoubleChest){
        	HumanEntity p = event.getPlayer();
    		if (AdminDropCommandExecutor.chestaccess.contains(p.getName())) {
    			event.setCancelled(true);
    		} else if (p.hasPermission("AdminDrop.alwayson.chestaccess") && !p.hasPermission("AdminDrop.ignore.alwayson.chestaccess")) {
    			event.setCancelled(true);
    		}
        }
    }
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent event) {
		Player p = event.getPlayer();
		if ((p instanceof Player)
				&& AdminDropCommandExecutor.pickupless.contains(p.getName())) {
			event.setCancelled(true);
		} else if ((p instanceof Player) && p.hasPermission("AdminDrop.alwayson.pickup") && !p.hasPermission("AdminDrop.ignore.alwayson.pickup")) {
			event.setCancelled(true);
		}
	}

}
