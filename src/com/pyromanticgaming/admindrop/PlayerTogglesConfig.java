package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */		

public class PlayerTogglesConfig {

	private static AdminDrop plugin = PlayerToggles.getPlugin();
	public static void savetoggles() {

		for(String p : PlayerToggles.getChestAccessMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".ChestAccess", PlayerToggles.getChestAccessMap().get(p));
		}

		for(String p : PlayerToggles.getDropAccessMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".DropAccess", PlayerToggles.getDropAccessMap().get(p));
		}

		for(String p : PlayerToggles.getThrowAccessMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".ThrowAccess", PlayerToggles.getThrowAccessMap().get(p));
		}

		for(String p : PlayerToggles.getPickUpAccessMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".PickUpAccess", PlayerToggles.getPickUpAccessMap().get(p));
		}

		for(String p : PlayerToggles.getBlockBreakMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".BlockBreak", PlayerToggles.getBlockBreakMap().get(p));
		}

		for(String p : PlayerToggles.getBlockPlaceMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".BlockPlace", PlayerToggles.getBlockPlaceMap().get(p));
		}

		plugin.saveConfig();
	}

	public static void loadtoggles() {
		if(!plugin.getConfig().contains("Players")) {
			return;
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setChestAccess(s, plugin.getConfig().getBoolean("Players." + s + ".ChestAccess"));
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setDropAccess(s, plugin.getConfig().getBoolean("Players." + s + ".DropAccess"));
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setPickUpAccess(s, plugin.getConfig().getBoolean("Players." + s + ".PickUpAccess"));
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setThrowAccess(s, plugin.getConfig().getBoolean("Players." + s + ".ThrowAccess"));
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setBlockBreak(s, plugin.getConfig().getBoolean("Players." + s + ".BlockBreak"));
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setBlockPlace(s, plugin.getConfig().getBoolean("Players." + s + ".BlockPlace"));
		}

	}
}
