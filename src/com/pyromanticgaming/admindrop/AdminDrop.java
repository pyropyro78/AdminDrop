package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.pyromanticgaming.admindrop.MainConfig;
import com.pyromanticgaming.admindrop.PlayerToggles;

public final class AdminDrop extends JavaPlugin implements Listener {


	@Override
	public void onEnable() {
		
		this.saveDefaultConfig();
		new MainConfig(this);
		MainConfig.GetMainValues();
		new PlayerToggles(this);
		PlayerTogglesConfig.loadnumbers();
		
		getServer().getPluginManager().registerEvents(this, this);

		getCommand("ad").setExecutor(new AdminDropCommandExecutor(this));
		
		getLogger().info("AdminDrop has been enabled.");
	}

	@Override
	public void onDisable() {

		PlayerTogglesConfig.savenumbers();
		
		getLogger().info("AdminDrop has been disabled.");
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		String p = e.getPlayer().getName();


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
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath(PlayerDeathEvent event) {
		Entity e = event.getEntity();
		if (PlayerToggles.dropaccess.get(e.getName())) {
			event.getDrops().clear();
			
			if (MainConfig.dropmessagetoggle) {
				
				e.sendMessage(MainConfig.dropmessage);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDropItemEvent(PlayerDropItemEvent e) {
		if (PlayerToggles.throwaccess.get(e.getPlayer().getName())) {
			e.setCancelled(true);
			
			if (MainConfig.throwmessagetoggle) {
				
				e.getPlayer().sendMessage(MainConfig.throwmessage); 
			}
		}
	}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Left off with line 163
 * make messages able to handle color codes
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryOpenEvent(InventoryOpenEvent e){
        e.getInventory().getType();
		if ((e.getInventory().getType() == InventoryType.CHEST && MainConfig.chestitem) || (e.getInventory().getType() == InventoryType.ENDER_CHEST && MainConfig.enderchestitem)){
        	HumanEntity p = e.getPlayer();
    		if (AdminDropCommandExecutor.chestaccess.contains(p.getName())) {
    			e.setCancelled(true);
    			
    			if (MainConfig.chestmessagetoggle) {
    				
    				p.sendMessage(MainConfig.chestmessage);
    			}
    		}
        }
    }
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (AdminDropCommandExecutor.pickupless.contains(p.getName())) {
			e.setCancelled(true);
			
			if (MainConfig.pickupmessagetoggle) {
				
				p.sendMessage(MainConfig.chestmessage);
			}
		}
	}

}
