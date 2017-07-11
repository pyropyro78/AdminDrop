package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.pyromanticgaming.admindrop.MainConfig;
import com.pyromanticgaming.admindrop.PlayerToggles;

public final class AdminDrop extends JavaPlugin implements Listener {


	@Override
	public void onEnable() {

		//Save Default Configs
		this.saveDefaultConfig();
		new MainConfig(this);
		MainConfig.GetMainValues(); //Get base values from config
		new PlayerToggles(this);
		PlayerTogglesConfig.loadToggles(); //Load player settings

		
		//Save player settings at set ticks from main config
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				PlayerTogglesConfig.saveToggles();

			}
		}, MainConfig.SaveTimer, MainConfig.SaveTimer);

		
		getServer().getPluginManager().registerEvents(this, this);

		getCommand("ad").setExecutor(new CommandHandler(this));

		getLogger().info("AdminDrop has been enabled.");
	}

	@Override
	public void onDisable() {

		PlayerTogglesConfig.saveToggles();

		getLogger().info("AdminDrop has been disabled.");

	}

	//If plays is not listed for any of the toggles this adds them to the list
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		String p = e.getPlayer().getName();
JoinToggles.main(p);

		
	}

	
	//DeathDrop
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (PlayerToggles.dropaccess.get(event.getEntity().getName())) {
			event.getDrops().clear();

			if (MainConfig.dropmessagetoggle) {

				event.getEntity().sendMessage(MainConfig.dropmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		}
	}

	
	//ThrowAway
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDropItemEvent(PlayerDropItemEvent e) {
		if (PlayerToggles.throwaccess.get(e.getPlayer().getName())) {
			e.setCancelled(true);

			if (MainConfig.throwmessagetoggle) {

				e.getPlayer().sendMessage(MainConfig.throwmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2")); 
			}
		}
	}

	
	//ChestAccess
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryOpenEvent(InventoryOpenEvent e){
		e.getInventory().getType();
		if ((e.getInventory().getType() == InventoryType.CHEST && MainConfig.chestitem) || (e.getInventory().getType() == InventoryType.ENDER_CHEST && MainConfig.enderchestitem) || (e.getInventory().getType() == InventoryType.HOPPER && MainConfig.hopperitem) || (e.getInventory().getType() == InventoryType.DROPPER && MainConfig.dropperitem) || (e.getInventory().getType() == InventoryType.DISPENSER && MainConfig.dispenseritem) || (e.getInventory().getType() == InventoryType.BREWING && MainConfig.brewingitem)){
			Player player = (Player) e.getPlayer();
			if (PlayerToggles.chestaccess.get(e.getPlayer().getName())) {
				e.setCancelled(true);

				if (MainConfig.chestmessagetoggle) {
					player.sendMessage(MainConfig.chestmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				}
			}
		}
	}

	
	//PickUp
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (PlayerToggles.pickupaccess.get(p.getName())) {
			e.setCancelled(true);

			if (MainConfig.pickupmessagetoggle) {

				p.sendMessage(MainConfig.pickupmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		}
	}

	
	//BlockBreak
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (PlayerToggles.blockbreak.get(p.getName())) {
			e.setCancelled(true);

			if (MainConfig.blockbreakmessagetoggle) {

				p.sendMessage(MainConfig.blockbreakmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		}
	}

	
	//BlockPlace
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (PlayerToggles.blockplace.get(p.getName())) {
			e.setCancelled(true);

			if (MainConfig.blockplacemessagetoggle) {

				p.sendMessage(MainConfig.blockplacemessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		}
	}

}
