package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class PlayerTogglesConfig {

	private static FunWithNumbers plugin = PlayerToggles.getPlugin();
	public static void savenumbers() {
		for(String p : PlayerToggles.getJoinsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".Joins", PlayerToggles.getJoinsMap().get(p));
		}
		for(String p : PlayerToggles.getBlockspMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".BlocksPlaced", PlayerToggles.getBlockspMap().get(p));
		}
		for(String p : PlayerToggles.getBlocksbMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".BlocksBroken", PlayerToggles.getBlocksbMap().get(p));
		}
		for(String p : PlayerToggles.getKillsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".Kills", PlayerToggles.getKillsMap().get(p));
		}
		for(String p : PlayerToggles.getPVPDeathsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".PVPDeaths", PlayerToggles.getPVPDeathsMap().get(p));
		}
		for(String p : PlayerToggles.getDeathsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".Deaths", PlayerToggles.getDeathsMap().get(p));
		}
		for(String p : PlayerToggles.getPlayTimeMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".PlayTime", PlayerToggles.getPlayTimeMap().get(p));
		}
		plugin.saveConfig();
	}

	public static void loadnumbers() {
		if(!plugin.getConfig().contains("Players")) {
			return;
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setJoins(s, plugin.getConfig().getInt("Players." + s + ".Joins"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setBlocksBroken(s, plugin.getConfig().getInt("Players." + s + ".BlocksBroken"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setBlocksPlaced(s, plugin.getConfig().getInt("Players." + s + ".BlocksPlaced"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setPVPDeaths(s, plugin.getConfig().getInt("Players." + s + ".PVPDeaths"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setDeaths(s, plugin.getConfig().getInt("Players." + s + ".Deaths"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setTime(s, plugin.getConfig().getInt("Players." + s + ".PlayTime"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			PlayerToggles.setKill(s, plugin.getConfig().getInt("Players." + s + ".Kills"));
		}

	}
}
