package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminDropCommandExecutor implements CommandExecutor {



	private AdminDrop admindrop;

	public AdminDropCommandExecutor(AdminDrop admindrop) {
		this.admindrop = admindrop;
	}

	boolean alwaysDD, alwaysPU, alwaysTA, alwaysCA;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("ad") || cmd.getName().equalsIgnoreCase("admindrop")) {

			// Declared here to allow use later
			// in the nested if statements
			Player otherPlayer;

			/*boolean canList = sender.hasPermission("AdminDrop.other.list")
						|| sender.isOp(); */
			boolean canMoCA = sender.hasPermission("AdminDrop.other.chestaccess")
					|| sender.isOp();
			boolean canCA = sender.hasPermission("AdminDrop.self.chestaccess")
					|| sender.isOp();
			boolean canMoDD = sender.hasPermission("AdminDrop.other.deathdrop")
					|| sender.isOp();
			boolean canTa = sender.hasPermission("AdminDrop.self.throwaway")
					|| sender.isOp();
			boolean canS = sender.hasPermission("AdminDrop.self.status")
					|| sender.isOp();
			boolean canSo = sender.hasPermission("AdminDrop.other.status")
					|| sender.isOp();
			boolean canDD = sender.hasPermission("AdminDrop.self.deathdrop")
					|| sender.isOp();
			boolean canMoTA = sender.hasPermission("AdminDrop.other.throwaway")
					|| sender.isOp();
			boolean canMoPU = sender.hasPermission("AdminDrop.other.pickup")
					|| sender.isOp();
			boolean canPU = sender.hasPermission("AdminDrop.self.pickup")
					|| sender.isOp();
			alwaysDD = (sender.hasPermission("AdminDrop.alwayson.deathdrop") && !sender.hasPermission("AdminDrop.ignore.star.deathdrop"));
			alwaysCA = (sender.hasPermission("AdminDrop.alwayson.chestaccess") && !sender.hasPermission("AdminDrop.ignore.star.chestaccess"));
			alwaysTA = (sender.hasPermission("AdminDrop.alwayson.throwaway") && !sender.hasPermission("AdminDrop.ignore.star.throwaway"));
			alwaysPU = (sender.hasPermission("AdminDrop.alwayson.pickup") && !sender.hasPermission("AdminDrop.ignore.star.pickup"));



			if (args.length == 1) {
				/*	if (args[0].equalsIgnoreCase("list") && canList) {
						ListCommand(sender);
						return true;
					} else */
				if (sender instanceof Player) {
					if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canDD) {
						DDropCommand(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && canTa) {
						NoThrowCommand(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && canPU) {
						NoPickUpCommand(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && canCA) {
						CACommand(sender);
						return true;
					} else if (args[0].equalsIgnoreCase("status")
							&& canS) {
						StatusCommand(sender);
						return true;
					}
				} 
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage("AdminDrop Help Information.");
					InfoArea(sender);
					return true;
				} else if ((args[0].equalsIgnoreCase("alt") ||args[0].equalsIgnoreCase("ac"))) {
					sender.sendMessage("AdminDrop Alternate Help Information.");
					AlternateInfoArea(sender);
					return true;
				}
			} else if (args.length == 2) {
				if (Bukkit.getPlayer(args[1]) instanceof Player) {
					otherPlayer = Bukkit.getPlayer(args[1]);
					alwaysDD = (otherPlayer.hasPermission("AdminDrop.alwayson.deathdrop") && !otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrop"));
					alwaysCA = (otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess") && !otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess"));
					alwaysTA = (otherPlayer.hasPermission("AdminDrop.alwayson.throwaway") && !otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway"));
					alwaysPU = (otherPlayer.hasPermission("AdminDrop.alwayson.pickup") && !otherPlayer.hasPermission("AdminDrop.ignore.star.pickup"));
				}
				if (args[0].equalsIgnoreCase("status") && canSo) {
					if (Bukkit.getPlayer(args[1]) instanceof Player) {
						otherPlayer = Bukkit.getPlayer(args[1]);
						StatusOtherCommand(otherPlayer, sender);
						return true;
					}
					playerNotFound(sender);
					return true;
				} else if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && canMoTA) {
					if (Bukkit.getPlayer(args[1]) instanceof Player) {
						otherPlayer = Bukkit.getPlayer(args[1]);
						ModifyOtherTA(otherPlayer, sender);
						return true;
					}
					playerNotFound(sender);
					return true;
				} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && canMoPU) {
					if (Bukkit.getPlayer(args[1]) instanceof Player) {
						otherPlayer = Bukkit.getPlayer(args[1]);
						ModifyOtherPU(otherPlayer, sender);
						return true;
					}
					playerNotFound(sender);
					return true;
				} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && canMoCA) {
					if (Bukkit.getPlayer(args[1]) instanceof Player) {
						otherPlayer = Bukkit.getPlayer(args[1]);
						ModifyOtherCA(otherPlayer, sender);
						return true;
					}
					playerNotFound(sender);
					return true;
				} else if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canMoDD) {
					if (Bukkit.getPlayer(args[1]) instanceof Player) {
						otherPlayer = Bukkit.getPlayer(args[1]);
						ModifyOtherDD(otherPlayer, sender);
						return true;
					}
					playerNotFound(sender);
					return true;
				}
			} else if (args.length > 2) {
				sender.sendMessage("AdminDrop - Too many arguments!");
				InfoArea(sender);
				return true;
			}

		}
		return false;
	}


	/**
	 * Checks the status of the target player
	 * 
	 * @param otherPlayer
	 * @param sender
	 */
	private void StatusOtherCommand(Player otherPlayer, CommandSender sender) {
		boolean protectme = false;
		String message = String.format("%s%s", ChatColor.ITALIC,
				otherPlayer.getDisplayName());
		message = message + " ";
		if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == false
				&& !alwaysDD) {
			sender.sendMessage(message + MainConfig.dropdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.dropactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (alwaysDD) {
			sender.sendMessage(message + MainConfig.dropalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.throwactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(otherPlayer.getName()) == false
				&& !alwaysTA) {
			sender.sendMessage(message + MainConfig.throwdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysTA) {
			sender.sendMessage(message + MainConfig.throwalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.chestactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(otherPlayer.getName()) == false
				&& !alwaysCA) {
			sender.sendMessage(message + MainConfig.chestdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysCA) {
			sender.sendMessage(message + MainConfig.chestalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(otherPlayer.getName()) == true) {
			sender.sendMessage(message + MainConfig.pickupactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(otherPlayer.getName()) == false 
				&& !alwaysPU) {
			sender.sendMessage(message + MainConfig.pickupdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysPU) {
			sender.sendMessage(message + MainConfig.pickupalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}
		if (!protectme) {
			sender.sendMessage(message + MainConfig.nothingactiveothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}

	/**
	 * Stores the informational data on command syntax to send to the user
	 * 
	 * @param sender
	 */
	private void InfoArea(CommandSender sender) {
		sender.sendMessage("/ad deathdrop - Toggles Death Drops on/off");
		sender.sendMessage("/ad deathdrop [player] - Toggles other's Death Drops on/off");
		sender.sendMessage("/ad throwaway - Toggles throwing items");
		sender.sendMessage("/ad throwaway [player] - Toggles other's throw away items on/off");
		sender.sendMessage("/ad pickup - Toggles the ability to pick up items on/off");
		sender.sendMessage("/ad pickup [player] - Toggles other's ability to pick up items on/off");
		sender.sendMessage("/ad chestaccess - Toggles the ability to open chests on/off");
		sender.sendMessage("/ad chestaccess [player] - Toggles other's ability to open chests on/off");
		sender.sendMessage("/ad status - Gets current status");
		sender.sendMessage("/ad help - Displays commands");
		sender.sendMessage("/ad status [player] - Gets players current status");
		sender.sendMessage("/ad alt - Shows alternate commands");
	}

	private void AlternateInfoArea(CommandSender sender) {
		sender.sendMessage("/ad dd - Toggles Death Drops on/off");
		sender.sendMessage("/ad dd [player] - Toggles other's Death Drops on/off");
		sender.sendMessage("/ad ta - Toggles throwing items");
		sender.sendMessage("/ad ta [player] - Toggles other's throw away items on/off");
		sender.sendMessage("/ad pu - Toggles the ability to pick up items on/off");
		sender.sendMessage("/ad pu [player] - Toggles other's ability to pick up items on/off");
		sender.sendMessage("/ad ca - Toggles the ability to open chests on/off");
		sender.sendMessage("/ad ca [player] - Toggles other's ability to open chests on/off");
		sender.sendMessage("/ad status - Gets current status");
		sender.sendMessage("/ad help - Displays commands");
		sender.sendMessage("/ad status [player] - Gets players current status");
		sender.sendMessage("/ad ac - Shows alternate commands");
	}

	/**
	 * Checks status of the player send the command
	 * 
	 * @param sender
	 */
	private void StatusCommand(CommandSender sender) {
		boolean protectme = false;
		if (PlayerToggles.dropaccess.get(sender.getName()) == false
				&& !alwaysDD) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.dropdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (PlayerToggles.dropaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.dropactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (alwaysDD) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.dropalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.throwactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.throwaccess.get(sender.getName()) == false
				&& !alwaysTA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.throwdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysTA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.throwalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.chestactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.chestaccess.get(sender.getName()) == false
				&& !alwaysCA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.chestdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysCA) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.chestalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(sender.getName()) == true) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.pickupactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}

		if (PlayerToggles.pickupaccess.get(sender.getName()) == false
				&& !alwaysPU) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.pickupdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

		if (alwaysPU) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.pickupalwaysactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			protectme = true;
		}
		if (!protectme) {
			sender.sendMessage(ChatColor.ITALIC + MainConfig.nothingactiveselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}



	/**
	 * Function to check target's name and send it to be toggled
	 * 
	 * @param otherPlayer
	 * @param sender
	 */
	private void ModifyOtherDD(Player otherPlayer, CommandSender sender) {
		if (PlayerToggles.dropaccess.get(otherPlayer.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrops")) {
				DisableDDrops(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.dropactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		} else if (alwaysDD) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.dropalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		} else {
			EnableDDrops(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.dropdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}

	private void ModifyOtherPU(Player otherPlayer, CommandSender sender) {
		if (PlayerToggles.pickupaccess.get(sender.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
				DisablePUs(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.pickupactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		} else if (alwaysPU) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.pickupalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		} else {
			EnablePUs(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ "'s can pick up items.");
		}

	}

	private void ModifyOtherTA(Player otherPlayer, CommandSender sender) {
		if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
				DisableThrows(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.throwactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		} else if (alwaysTA) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.throwalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		} else {
			EnableThrows(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.throwdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}

	private void ModifyOtherCA(Player otherPlayer, CommandSender sender) {
		if (PlayerToggles.chestaccess.get(sender.getName()) == false) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess")) {
				DisableChestAccess(otherPlayer, sender);
				sender.sendMessage(ChatColor.ITALIC
						+ otherPlayer.getDisplayName() + ChatColor.ITALIC
						+ " "
						+ MainConfig.chestactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
			}
		} else if (alwaysCA) {
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName()
					+ " "
					+ MainConfig.chestalwaysactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		} else {
			EnableChestAccess(otherPlayer, sender);
			sender.sendMessage(ChatColor.ITALIC
					+ otherPlayer.getDisplayName() + ChatColor.ITALIC
					+ " "
					+ MainConfig.chestdeactivatedothermessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}

	}

	private void NoThrowCommand(CommandSender sender) {
		Player player = (Player) sender;
		if (PlayerToggles.throwaccess.get(sender.getName()) == false) {
			DisableThrows(player, sender);
		} else {
			EnableThrows(player, sender);
		}

	}

	private void DisableChestAccess(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.chestactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setChestAccess(player.getName(), true);
	}

	private void EnableChestAccess(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.chestdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setChestAccess(player.getName(), false);
	}

	private void CACommand(CommandSender sender) {
		Player player = (Player) sender;
		if (PlayerToggles.chestaccess.get(sender.getName()) == false) {
			DisableChestAccess(player, sender);
		} else {
			EnableChestAccess(player, sender);
		}

	}

	private void DisableThrows(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.throwactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setThrowAccess(player.getName(), true);
	}

	private void EnableThrows(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.throwdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setThrowAccess(player.getName(), false);
	}

	private void DDropCommand(CommandSender sender) {
		// Reason for the conversion here is to use Player in a later function
		// instead of CommandSender
		Player player = (Player) sender;
		// If the players name is not in the hashmap it
		// will stop drops on death
		if (PlayerToggles.dropaccess.get(player.getName()) == false) {
			DisableDDrops(player, sender);
		} else {
			// Otherwise it will run this function to allow drops to take
			// place again on death
			EnableDDrops(player, sender);
		}
	}

	/**
	 * Stops drops on death by adding the players name to a hashmap
	 * 
	 * @param player
	 */
	private void DisableDDrops(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.dropactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setDropAccess(player.getName(), true);

	}

	/**
	 * Enables drops on death by removing the players name from the hashmap
	 * 
	 * @param player
	 */
	private void EnableDDrops(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.dropdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setDropAccess(player.getName(), false);
	}

	private void NoPickUpCommand(CommandSender sender) {
		Player player = (Player) sender;
		if (PlayerToggles.pickupaccess.get(player.getName()) == false) {
			DisablePUs(player, sender);
		} else {
			EnablePUs(player, sender);
		}

	}

	private void DisablePUs(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.pickupactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setPickUpAccess(player.getName(), true);

	}

	private void EnablePUs(Player player, CommandSender sender) {
		if (MainConfig.announcechangetoother || player.getName() == sender.getName()) {
		player.sendMessage(ChatColor.ITALIC + MainConfig.pickupdeactivatedselfmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}
		PlayerToggles.setPickUpAccess(player.getName(), false);
	}

	private void playerNotFound(CommandSender sender) {
		sender.sendMessage(MainConfig.playernotfoundmessage.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	}
	
}
