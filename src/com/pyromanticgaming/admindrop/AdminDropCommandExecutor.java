package com.pyromanticgaming.admindrop;

/*
*Copyright (c) <2013-2014>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
*
*    Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
*    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminDropCommandExecutor implements CommandExecutor {

	public static Set<String> dropless = new HashSet<String>();
	public static Set<String> throwless = new HashSet<String>();
	public static Set<String> pickupless = new HashSet<String>();
	public static Set<String> playerList = new HashSet<String>();
	public static Set<String> chestaccess = new HashSet<String>();
	public static Set<String> protectPlayerListCA = new HashSet<String>();
	public static Set<String> protectPlayerListDD = new HashSet<String>();
	public static Set<String> protectPlayerListTA = new HashSet<String>();
	public static Set<String> protectPlayerListPU = new HashSet<String>();

	private AdminDrop admindrop;

	public AdminDropCommandExecutor(AdminDrop admindrop) {
		this.admindrop = admindrop;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("ad") || cmd.getName().equalsIgnoreCase("admindrop")) {
			if (sender instanceof Player) {
				// Declared here to allow use later
				// in the nested if statements
				Player otherPlayer;

				boolean canList = sender.hasPermission("AdminDrop.other.list")
						|| sender.isOp();
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
				boolean canStar = sender.hasPermission("AdminDrop.*")
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

				// End unauthorized use immediately
				if (!canStar && !sender.isOp()) {
					sender.sendMessage("AdminDrop - You do not have permission for that.");
					return true;
				} else {
					if (args.length > 0) {
						// To ensure that it is the most
						// up to date list of online players
						playerList.clear();
						for (Player player1 : admindrop.getServer()
								.getOnlinePlayers()) {
							// Add online users to the playerList HashMap
							playerList.add(player1.getName());
						}
						if (args.length == 1) {
							if (args[0].equalsIgnoreCase("list") && canList) {
								ListCommand(sender);
								return true;
							} else if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canDD) {
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
							} else if (args[0].equalsIgnoreCase("help")
									&& canStar) {
								sender.sendMessage("AdminDrop Help Information.");
								InfoArea(sender);
								return true;
							} else if ((args[0].equalsIgnoreCase("altcommands") ||args[0].equalsIgnoreCase("ac"))
									&& canStar) {
								sender.sendMessage("AdminDrop Alternate Help Information.");
								AlternateInfoArea(sender);
								return true;
							}
						} else if (args.length == 2) {
							if (args[0].equalsIgnoreCase("status")
									&& playerList.contains(args[1]) && canSo) {
								otherPlayer = Bukkit.getPlayer(args[1]);
								StatusOtherCommand(otherPlayer, sender);
								return true;
							} else if (args[0].equalsIgnoreCase("status")
									&& !playerList.contains(args[1]) && canSo) {
								sender.sendMessage(ChatColor.DARK_BLUE
										+ args[1]
												+ " is either not logged in or name was typed incorrectly.");
								return true;
							} else if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && playerList.contains(args[1]) && canMoTA) {
								otherPlayer = Bukkit.getPlayer(args[1]);
								ModifyOtherTA(otherPlayer, sender);
								return true;
							} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && playerList.contains(args[1]) && canMoPU) {
								otherPlayer = Bukkit.getPlayer(args[1]);
								ModifyOtherPU(otherPlayer, sender);
								return true;
							} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && playerList.contains(args[1]) && canMoCA) {
								otherPlayer = Bukkit.getPlayer(args[1]);
								ModifyOtherCA(otherPlayer, sender);
								return true;
							} else if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && playerList.contains(args[1]) && canMoDD) {
								// Fetches the target Player object
								otherPlayer = Bukkit.getPlayer(args[1]);
								ModifyOtherDD(otherPlayer, sender);
								return true;
							}
						} else if (args.length > 2) {
							sender.sendMessage("AdminDrop - Too many arguments!");
							InfoArea(sender);
							return true;
						}
					} else {
						sender.sendMessage(ChatColor.DARK_BLUE
								+ "That is not a proper command.");
						InfoArea(sender);
						return true;
					}
				}
			}else {
				sender.sendMessage("AdminDrop - Command must be entered by a player.");
				return false;
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
		String message = String.format("%s%s", ChatColor.DARK_BLUE,
				otherPlayer.getDisplayName());
		if (!dropless.contains(otherPlayer.getName())
				&& !otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")) {
			sender.sendMessage(message + "'s Death Drops are not safe.");
		}

		if (dropless.contains(otherPlayer.getName())) {
			sender.sendMessage(message + "'s Death Drops are safe.");
		}

		if (otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrops")) {
			sender.sendMessage(message + "'s Death Drops are always safe.");
		}

		if (throwless.contains(otherPlayer.getName())) {
			sender.sendMessage(message + "'s throws are safe.");
		}

		if (!throwless.contains(otherPlayer.getName())
				&& !otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")) {
			sender.sendMessage(message + "'s throws are not safe.");
		}

		if (otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
			sender.sendMessage(message + "'s throws are always safe.");
		}
		
		if (chestaccess.contains(otherPlayer.getName())) {
			sender.sendMessage(message + " cannot access chests.");
		}

		if (!chestaccess.contains(otherPlayer.getName())
				&& !otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess")) {
			sender.sendMessage(message + " can access chests.");
		}

		if (otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess")) {
			sender.sendMessage(message + " cannot ever access chests.");
		}

		if (pickupless.contains(otherPlayer.getName())) {
			sender.sendMessage(message + "'s cannot pick up items.");
		}

		if (!pickupless.contains(otherPlayer.getName())
				&& !otherPlayer.hasPermission("AdminDrop.alwayson.pickup")) {
			sender.sendMessage(message + "'s can pick up items.");
		}

		if (otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
			sender.sendMessage(message + "'s can never pick up items.");
		} else {
			sender.sendMessage(message + "'s actions are not protected.");
		}

	}

	/**
	 * Stores the informational data on command syntax to send to the user
	 * 
	 * @param sender
	 */
	private void InfoArea(CommandSender sender) {
		sender.sendMessage("/admindrop deathdrop - Toggles Death Drops on/off");
		sender.sendMessage("/admindrop deathdrop [player] - Toggles other's Death Drops on/off");
		sender.sendMessage("/admindrop list - Lists users with Toggle on");
		sender.sendMessage("/admindrop throwaway - Toggles throwing items");
		sender.sendMessage("/admindrop throwaway [player] - Toggles other's throw away items on/off");
		sender.sendMessage("/admindrop pickup - Toggles the ability to pick up items on/off");
		sender.sendMessage("/admindrop pickup [player] - Toggles other's ability to pick up items on/off");
		sender.sendMessage("/admindrop chestaccess - Toggles the ability to open chests on/off");
		sender.sendMessage("/admindrop chestaccess [player] - Toggles other's ability to open chests on/off");
		sender.sendMessage("/admindrop status - Gets current status");
		sender.sendMessage("/admindrop help - Displays commands");
		sender.sendMessage("/admindrop status [player] - Gets players current status");
		sender.sendMessage("/admindrop altcommands - Shows alternate commands");
	}
	
	private void AlternateInfoArea(CommandSender sender) {
		sender.sendMessage("/ad dd - Toggles Death Drops on/off");
		sender.sendMessage("/ad dd [player] - Toggles other's Death Drops on/off");
		sender.sendMessage("/ad list - Lists users with Toggle on");
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
		if (!dropless.contains(sender.getName())
				&& !sender.hasPermission("AdminDrop.alwayson.deathdrop")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "Your Death Drops are not safe.");
		}

		if (dropless.contains(sender.getName())) {
			sender.sendMessage(ChatColor.DARK_BLUE + "Your Death Drops are safe.");
		}

		if (sender.hasPermission("AdminDrop.alwayson.deathdrop")
				&& !sender.hasPermission("AdminDrop.ignore.star.deathdrop")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "Your Death Drops are always safe.");
		}

		if (throwless.contains(sender.getName())) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You throws are safe.");
		}

		if (!throwless.contains(sender.getName())
				&& !sender.hasPermission("AdminDrop.throwaway")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You throws are not safe.");
		}

		if (sender.hasPermission("AdminDrop.alwayson.throwaway")
				&& !sender.hasPermission("AdminDrop.ignore.star.throwaway")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "Your throws are always safe.");
		}
		
		if (chestaccess.contains(sender.getName())) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You cannot access chests.");
		}

		if (!chestaccess.contains(sender.getName())
				&& !sender.hasPermission("AdminDrop.alwayson.chestaccess")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You can access chests.");
		}

		if (sender.hasPermission("AdminDrop.alwayson.chestaccess")
				&& !sender.hasPermission("AdminDrop.ignore.star.chestaccess")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You cannot ever access chests.");
		}

		if (pickupless.contains(sender.getName())) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You cannot pick up items.");
		}

		if (!pickupless.contains(sender.getName())
				&& !sender.hasPermission("AdminDrop.alwayson.pickup")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You can pick up items.");
		}

		if (sender.hasPermission("AdminDrop.alwayson.pickup")
				&& !sender.hasPermission("AdminDrop.ignore.star.pickup")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "You can never pick up items.");
		} else {
			sender.sendMessage(ChatColor.DARK_BLUE + "Your actions are not protected.");
		}

	}

	private void ListCommand(CommandSender sender) {
		for (Player onlineplayer : admindrop.getServer().getOnlinePlayers()) {
			if (onlineplayer.hasPermission("AdminDrop.alwayson.deathdrop") && !onlineplayer.hasPermission("AdminDrop.ignore.star.deathdrop")) {
				protectPlayerListDD.add(onlineplayer.getName());
				dropless.addAll(protectPlayerListDD);
			} if (onlineplayer.hasPermission("AdminDrop.alwayson.throwaway") && !onlineplayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
				protectPlayerListTA.add(onlineplayer.getName());
				throwless.addAll(protectPlayerListTA);
			} if (onlineplayer.hasPermission("AdminDrop.alwayson.pickup") && !onlineplayer.hasPermission("AdminDrop.ignore.star.pickup")) {
				protectPlayerListPU.add(onlineplayer.getName());
				pickupless.addAll(protectPlayerListPU);
			} if (onlineplayer.hasPermission("AdminDrop.alwayson.chestaccess") && !onlineplayer.hasPermission("AdminDrop.ignore.star.chestaccess")) {
				protectPlayerListCA.add(onlineplayer.getName());
				pickupless.addAll(protectPlayerListCA);
			}
		}
		// If the hashmap dropless is not empty it
		// will display the players on the list
		if (dropless.isEmpty() && throwless.isEmpty() && pickupless.isEmpty()) {
			sender.sendMessage(ChatColor.DARK_BLUE + "Not one person is safe.");
		} if (!dropless.isEmpty()) {
			// hashmaps and Strings do not mix without this
			String listdropless = dropless.toString();
			sender.sendMessage(ChatColor.DARK_BLUE + "Have Death Drops protected:");
			sender.sendMessage(ChatColor.DARK_BLUE + listdropless);
			dropless.removeAll(protectPlayerListDD);
			protectPlayerListDD.clear();
		} if (!throwless.isEmpty()) {
			String listthrowless = throwless.toString();
			sender.sendMessage(ChatColor.DARK_BLUE + "Have throwing of items protected:");
			sender.sendMessage(ChatColor.DARK_BLUE + listthrowless);
			throwless.removeAll(protectPlayerListTA);
			protectPlayerListTA.clear();
		} if (!pickupless.isEmpty()) {
			String listpickupless = pickupless.toString();
			sender.sendMessage(ChatColor.DARK_BLUE + "Have picking up of items protected:");
			sender.sendMessage(ChatColor.DARK_BLUE + listpickupless);
			pickupless.removeAll(protectPlayerListPU);
			protectPlayerListPU.clear();
		} if (!chestaccess.isEmpty()) {
			String listchestaccess = chestaccess.toString();
			sender.sendMessage(ChatColor.DARK_BLUE + "Cannot access chests:");
			sender.sendMessage(ChatColor.DARK_BLUE + listchestaccess);
			chestaccess.removeAll(protectPlayerListCA);
			protectPlayerListCA.clear();
		}

	}

	/**
	 * Function to check target's name and send it to be toggled
	 * 
	 * @param otherPlayer
	 * @param sender
	 */
	private void ModifyOtherDD(Player otherPlayer, CommandSender sender) {
		if (!dropless.contains(otherPlayer.getName())) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrops")) {
				DisableDDrops(otherPlayer);
				sender.sendMessage(ChatColor.DARK_BLUE
						+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
						+ "'s Death Drops are safe.");
				if (AdminDrop.DDLogLevel == 3) {
					admindrop.getLogger().info(
							sender.getName() + " Has protected Death Drops for "
									+ otherPlayer.getName() + "!");
				}
			}
		} else if (otherPlayer.hasPermission("AdminDrop.alwayson.deathdrops")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrops")) {
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName()
					+ " always has protected Death Drops.");
		} else {
			EnableDDrops(otherPlayer);
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
					+ "'s Death Drops are not safe.");
			if (AdminDrop.DDLogLevel == 3) {
				admindrop.getLogger().info(
						sender.getName() + " Has removed protection of Death Drops for "
								+ otherPlayer.getName() + "!");
			}
		}

	}

	private void ModifyOtherPU(Player otherPlayer, CommandSender sender) {
		if (!pickupless.contains(otherPlayer.getName())) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
				DisableDDrops(otherPlayer);
				sender.sendMessage(ChatColor.DARK_BLUE
						+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
						+ "'s cannot pick up items.");
				if (AdminDrop.PULogLevel == 2) {
					admindrop.getLogger().info(
							sender.getName() + " Has disabled item pickups for "
									+ otherPlayer.getName() + "!");
				}
			}
		} else if (otherPlayer.hasPermission("AdminDrop.alwayson.pickup")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.pickup")) {
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName()
					+ " can never pick up items.");
		} else {
			EnableDDrops(otherPlayer);
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
					+ "'s can pick up items.");
			if (AdminDrop.PULogLevel == 2) {
				admindrop.getLogger().info(
						sender.getName() + " Has enabled item pickups for "
								+ otherPlayer.getName() + "!");
			}
		}

	}

	private void ModifyOtherTA(Player otherPlayer, CommandSender sender) {
		if (!throwless.contains(otherPlayer.getName())) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
				DisableThrows(otherPlayer);
				sender.sendMessage(ChatColor.DARK_BLUE
						+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
						+ "'s throws are safe.");
				if (AdminDrop.TALogLevel == 2) {
					admindrop.getLogger().info(
							sender.getName() + " Has disabled ability to throw away items for "
									+ otherPlayer.getName() + "!");
				}
			}
		} else if (otherPlayer.hasPermission("AdminDrop.alwayson.throwaway")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway")) {
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName()
					+ " can never throw away items.");
		} else {
			EnableThrows(otherPlayer);
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
					+ "'s throws are not safe.");
			if (AdminDrop.TALogLevel == 2) {
				admindrop.getLogger().info(
						sender.getName() + " Has enabled ability to throw away items for "
								+ otherPlayer.getName() + "!");
			}
		}

	}
	
	private void ModifyOtherCA(Player otherPlayer, CommandSender sender) {
		if (!chestaccess.contains(otherPlayer.getName())) {
			if (!otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess")
					|| otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess")) {
				DisableChestAccess(otherPlayer);
				sender.sendMessage(ChatColor.DARK_BLUE
						+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
						+ " cannot access chests");
				if (AdminDrop.CALogLevel == 2) {
					admindrop.getLogger().info(
							sender.getName() + " Has disabled ability to open chests for "
									+ otherPlayer.getName() + "!");
				}
			}
		} else if (otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess")
				&& !otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess")) {
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName()
					+ " can never open chests.");
		} else {
			EnableChestAccess(otherPlayer);
			sender.sendMessage(ChatColor.DARK_BLUE
					+ otherPlayer.getDisplayName() + ChatColor.DARK_BLUE
					+ " can open chests");
			if (AdminDrop.CALogLevel == 2) {
				admindrop.getLogger().info(
						sender.getName() + " Has enabled ability to open chests for "
								+ otherPlayer.getName() + "!");
			}
		}

	}

	private void NoThrowCommand(CommandSender sender) {
		Player player = (Player) sender;
		if (!throwless.contains(player.getName())) {
			DisableThrows(player);
			if (AdminDrop.TALogLevel == 1 || AdminDrop.TALogLevel == 2) {
				admindrop.getLogger().info(
						player.getName() + " Has disabled throwing abilities!");
			}
		} else {
			EnableThrows(player);
			if (AdminDrop.TALogLevel == 1 || AdminDrop.TALogLevel == 2) {
				admindrop.getLogger().info(
						player.getName() + " Has enable throwing abilities!");
			}
		}

	}

	private void DisableChestAccess(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "Accessing chests has been disabled.");
		chestaccess.add(player.getName());
	}

	private void EnableChestAccess(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "Accessing chests has been enabled.");
		chestaccess.remove(player.getName());
	}
	
	private void CACommand(CommandSender sender) {
		Player player = (Player) sender;
		if (!chestaccess.contains(player.getName())) {
			DisableChestAccess(player);
			if (AdminDrop.CALogLevel == 1 || AdminDrop.CALogLevel == 2) {
				admindrop.getLogger().info(
						player.getName() + " Has disabled chest opening abilities!");
			}
		} else {
			EnableChestAccess(player);
			if (AdminDrop.CALogLevel == 1 || AdminDrop.CALogLevel == 2) {
				admindrop.getLogger().info(
						player.getName() + " Has enable chest opening abilities!");
			}
		}

	}

	private void DisableThrows(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "Throwing away your items has been disabled.");
		throwless.add(player.getName());
	}

	private void EnableThrows(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "Throwing away your items has been enabled.");
		throwless.remove(player.getName());
	}

	private void DDropCommand(CommandSender sender) {
		// Reason for the conversion here is to use Player in a later function
		// instead of CommandSender
		Player player = (Player) sender;
		// If the players name is not in the hashmap it
		// will stop drops on death
		if (!dropless.contains(player.getName())) {
			DisableDDrops(player);
			if (AdminDrop.DDLogLevel == 2 || AdminDrop.DDLogLevel == 3) {
				admindrop.getLogger().info(
						player.getName() + " Has enabled Death Drops!");
			}
		} else {
			// Otherwise it will run this function to allow drops to take
			// place again on death
			EnableDDrops(player);
			if (AdminDrop.DDLogLevel == 2 || AdminDrop.DDLogLevel == 3) {
				admindrop.getLogger().info(
						player.getName() + " Has disabled Death Drops!");
			}
		}
	}

	/**
	 * Stops drops on death by adding the players name to a hashmap
	 * 
	 * @param player
	 */
	private void DisableDDrops(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "Your Death Drops are safe.");
		dropless.add(player.getName());

	}

	/**
	 * Enables drops on death by removing the players name from the hashmap
	 * 
	 * @param player
	 */
	private void EnableDDrops(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "Your Death Drops are not safe.");
		dropless.remove(player.getName());
	}

	private void NoPickUpCommand(CommandSender sender) {
		Player player = (Player) sender;
		if (!pickupless.contains(player.getName())) {
			DisablePUs(player);
			if (AdminDrop.PULogLevel == 1 || AdminDrop.PULogLevel == 2) {
				admindrop.getLogger().info(
						player.getName() + " Has disabled picking up item abilities!");
			}
		} else {
			EnablePUs(player);
			if (AdminDrop.PULogLevel == 1 || AdminDrop.PULogLevel == 2) {
				admindrop.getLogger().info(
						player.getName() + " Has enable picking up item abilities!");
			}
		}

	}

	private void DisablePUs(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "You wont pick up items.");
		pickupless.add(player.getName());

	}

	private void EnablePUs(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "You can now pick up items.");
		pickupless.remove(player.getName());
	}
}
