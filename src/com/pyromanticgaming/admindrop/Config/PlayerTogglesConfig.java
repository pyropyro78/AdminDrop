package com.pyromanticgaming.admindrop.Config;

import com.pyromanticgaming.admindrop.PlayerToggles;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */		

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
