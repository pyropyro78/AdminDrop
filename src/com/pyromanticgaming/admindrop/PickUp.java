package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pyromanticgaming.admindrop.Config.ConfigManager;
import com.pyromanticgaming.admindrop.Config.MainConfig;

public class PickUp {

	public static void modifyOther(Player otherPlayer, CommandSender sender, Boolean alwaysOn, String[] args) {
		if (args.length == 3) {
			if (args[2].equalsIgnoreCase("ON")) {
				if (PlayerToggles.pickupaccess.get(sender.getName()) == false) {
					if (!otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
							|| otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
						disable(otherPlayer, sender);
						sender.sendMessage(ChatColor.ITALIC
								+ otherPlayer.getDisplayName() + ChatColor.ITALIC
								+ " "
								+ MainConfig.pickupactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						return;
					}
				} else if (alwaysOn) {
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.pickupalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				} else {
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.pickupactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				}
			} else if (args[2].equalsIgnoreCase("OFF")) {
				if (PlayerToggles.pickupaccess.get(sender.getName()) == false) {
					if (!otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
							|| otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
						sender.sendMessage(ChatColor.ITALIC
								+ otherPlayer.getDisplayName()
								+ " "
								+ MainConfig.pickupdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						return;
					}
				} else if (alwaysOn) {
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.pickupalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				} else {
					enable(otherPlayer, sender);
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.pickupdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				}
			}
		} else 
			if (PlayerToggles.pickupaccess.get(sender.getName()) == false) {
				if (!otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
						|| otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
					disable(otherPlayer, sender);
					sender.sendMessage(ChatColor.ITALIC
							+ otherPlayer.getDisplayName()
							+ " "
							+ MainConfig.pickupactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					return;
				}
			} else if (alwaysOn) {
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName()
						+ " "
						+ MainConfig.pickupalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				return;
			} else {
				enable(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName()
						+ " "
						+ MainConfig.pickupdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}

	}

	public static void modifyAll(Boolean valueSetting) {
		for (Map.Entry<String, Boolean> toggleEntry : PlayerToggles.pickupaccess.entrySet()) {
			toggleEntry.setValue(valueSetting);
		}
		ConfigManager.saveAllConfigs();
	}

	public static void modifySelf(CommandSender sender, String args[]) {
		Player player = (Player) sender;
		if (args[1].equalsIgnoreCase("ON")) {
			disable(player, sender);
			ConfigManager.saveAllConfigs();
			return;
		} else
			if (args[1].equalsIgnoreCase("OFF")) {
				enable(player, sender);
				ConfigManager.saveAllConfigs();
				return;
			}
		if (PlayerToggles.pickupaccess.get(player.getName()) == false) {
			disable(player, sender);
		} else {
			enable(player, sender);
		}
	}

	private static void disable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.pickupactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setPickUpAccess(player.getName(), true);
	}

	private static void enable(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
			player.sendMessage(ChatColor.ITALIC + MainConfig.pickupdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setPickUpAccess(player.getName(), false);
	}

}
