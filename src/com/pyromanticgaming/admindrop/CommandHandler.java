package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {



	public CommandHandler(AdminDrop admindrop) {
	}

	// DD = Death Drop, PU = PickUp, TA = ThrowAway, BP = Block Placement, BB = Block Break
	boolean alwaysDD, alwaysPU, alwaysTA, alwaysCA, alwaysBP, alwaysBB;

	@Override
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ad") || cmd.getName().equalsIgnoreCase("admindrop")) {

			//Declared now for use in later sections
			Player otherPlayer;

			//Checking permissions
			boolean canMoCA = sender.hasPermission("AdminDrop.other.chestaccess")
					|| sender.isOp();
			boolean canCA = sender.hasPermission("AdminDrop.self.chestaccess")
					|| sender.isOp();
			boolean canMoDD = sender.hasPermission("AdminDrop.other.deathdrop")
					|| sender.isOp();
			boolean canTA = sender.hasPermission("AdminDrop.self.throwaway")
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
			boolean canBP = sender.hasPermission("AdminDrop.self.block.place")
					|| sender.isOp();
			boolean canBB = sender.hasPermission("AdminDrop.self.block.break")
					|| sender.isOp();
			boolean canMoBP = sender.hasPermission("AdminDrop.other.block.place")
					|| sender.isOp();
			boolean canMoBB = sender.hasPermission("AdminDrop.other.block.break")
					|| sender.isOp();
			boolean canMaDD = sender.hasPermission("AdminDrop.all.deathdrop")
					|| sender.isOp();
			boolean canMaTA = sender.hasPermission("AdminDrop.all.throwaway")
					|| sender.isOp();
			boolean canMaCA = sender.hasPermission("AdminDrop.all.chestaccess")
					|| sender.isOp();
			boolean canMaPU = sender.hasPermission("AdminDrop.all.pickup")
					|| sender.isOp();
			boolean canMaBB = sender.hasPermission("AdminDrop.all.block.break")
					|| sender.isOp();
			boolean canMaBP = sender.hasPermission("AdminDrop.all.block.place")
					|| sender.isOp();
			alwaysDD = (sender.hasPermission("AdminDrop.alwayson.deathdrop") && !sender.hasPermission("AdminDrop.ignore.star.deathdrop"));
			alwaysCA = (sender.hasPermission("AdminDrop.alwayson.chestaccess") && !sender.hasPermission("AdminDrop.ignore.star.chestaccess"));
			alwaysTA = (sender.hasPermission("AdminDrop.alwayson.throwaway") && !sender.hasPermission("AdminDrop.ignore.star.throwaway"));
			alwaysPU = (sender.hasPermission("AdminDrop.alwayson.pickup") && !sender.hasPermission("AdminDrop.ignore.star.pickup"));
			alwaysBP = (sender.hasPermission("AdminDrop.alwayson.block.place") && !sender.hasPermission("AdminDrop.ignore.star.block.place"));
			alwaysBB = (sender.hasPermission("AdminDrop.alwayson.block.break") && !sender.hasPermission("AdminDrop.ignore.star.block.break"));


			//Main command filter
			if (args.length == 1) {
				if (sender instanceof Player) {
					if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canDD) {
						DeathDrop.modifySelf(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && canTA) {
						ThrowAway.modifySelf(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && canPU) {
						PickUp.modifySelf(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && canCA) {
						ChestAccess.modifySelf(sender);
						return true;
					}  else if ((args[0].equalsIgnoreCase("bp") || args[0].equalsIgnoreCase("blockplace")) && canBP) {
						BlockPlace.modifySelf(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("bb") || args[0].equalsIgnoreCase("blockbreak")) && canBB) {
						BlockBreak.modifySelf(sender);
						return true;
					} else if (args[0].equalsIgnoreCase("status")
							&& canS) {
						Status.selfCommand(sender);
						return true;
					}
				} 
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage("AdminDrop Help Information.");
					InfoDisplays.commadInfo(sender);
					return true;
				} else if (args[0].equalsIgnoreCase("alt") ||args[0].equalsIgnoreCase("ac")) {
					sender.sendMessage("AdminDrop Alternate Help Information.");
					InfoDisplays.altCommandInfo(sender);
					return true;
				}
			} else if (args.length == 2 || args.length == 3) {
				if (Bukkit.getPlayer(args[1]) instanceof Player) {
					otherPlayer = Bukkit.getPlayer(args[1]);
					alwaysDD = (otherPlayer.hasPermission("AdminDrop.alwayson.deathdrop") && !otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrop"));
					alwaysCA = (otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess") && !otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess"));
					alwaysTA = (otherPlayer.hasPermission("AdminDrop.alwayson.throwaway") && !otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway"));
					alwaysPU = (otherPlayer.hasPermission("AdminDrop.alwayson.pickup") && !otherPlayer.hasPermission("AdminDrop.ignore.star.pickup"));
					alwaysBP = (otherPlayer.hasPermission("AdminDrop.alwayson.block.place") && !sender.hasPermission("AdminDrop.ignore.star.block.place"));
					alwaysBB = (otherPlayer.hasPermission("AdminDrop.alwayson.block.break") && !sender.hasPermission("AdminDrop.ignore.star.block.break"));

					if (args[0].equalsIgnoreCase("status") && canSo) {
						Status.otherCommand(otherPlayer, sender, args);
						return true;
					} else if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && canMoTA) {
						ThrowAway.modifyOther(otherPlayer, sender, alwaysTA, args);
						return true;
					} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && canMoPU) {
						PickUp.modifyOther(otherPlayer, sender, alwaysPU, args);
						return true;
					} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && canMoCA) {
						ChestAccess.modifyOther(otherPlayer, sender, alwaysCA, args);
						return true;
					} else if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canMoDD) {
						DeathDrop.modifyOther(otherPlayer, sender, alwaysDD, args);
						return true;
					} else if ((args[0].equalsIgnoreCase("bb") || args[0].equalsIgnoreCase("blockbreak")) && canMoBB) {
						BlockBreak.modifyOther(otherPlayer, sender, alwaysBB, args);
						return true;
					} else if ((args[0].equalsIgnoreCase("bp") || args[0].equalsIgnoreCase("blockplace")) && canMoBP) {
						BlockPlace.modifyOther(otherPlayer, sender, alwaysBP, args);
						return true;
					} else {
						InfoDisplays.playerNotFoundInfo(sender);
						return true;
					}
				} else
					if (args[1].equalsIgnoreCase("ALL")) {
						for (Player AllPlayers : Bukkit.getServer().getOnlinePlayers()) {
							alwaysDD = (AllPlayers.hasPermission("AdminDrop.alwayson.deathdrop") && !AllPlayers.hasPermission("AdminDrop.ignore.star.deathdrop"));
							alwaysCA = (AllPlayers.hasPermission("AdminDrop.alwayson.chestaccess") && !AllPlayers.hasPermission("AdminDrop.ignore.star.chestaccess"));
							alwaysTA = (AllPlayers.hasPermission("AdminDrop.alwayson.throwaway") && !AllPlayers.hasPermission("AdminDrop.ignore.star.throwaway"));
							alwaysPU = (AllPlayers.hasPermission("AdminDrop.alwayson.pickup") && !AllPlayers.hasPermission("AdminDrop.ignore.star.pickup"));
							alwaysBP = (AllPlayers.hasPermission("AdminDrop.alwayson.block.place") && !sender.hasPermission("AdminDrop.ignore.star.block.place"));
							alwaysBB = (AllPlayers.hasPermission("AdminDrop.alwayson.block.break") && !sender.hasPermission("AdminDrop.ignore.star.block.break"));

							if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && canMaTA) {
								ThrowAway.modifyOther(AllPlayers, sender, alwaysTA, args);
								return true;
							} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && canMaPU) {
								PickUp.modifyOther(AllPlayers, sender, alwaysPU, args);
								return true;
							} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && canMaCA) {
								ChestAccess.modifyOther(AllPlayers, sender, alwaysCA, args);
								return true;
							} else if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canMaDD) {
								DeathDrop.modifyOther(AllPlayers, sender, alwaysDD, args);
								return true;
							} else if ((args[0].equalsIgnoreCase("bb") || args[0].equalsIgnoreCase("blockbreak")) && canMaBB) {
								BlockBreak.modifyOther(AllPlayers, sender, alwaysBB, args);
								return true;
							} else if ((args[0].equalsIgnoreCase("bp") || args[0].equalsIgnoreCase("blockplace")) && canMaBP) {
								BlockPlace.modifyOther(AllPlayers, sender, alwaysBP, args);
								return true;
							} else {
								return true;
							}
						}

					} else
						if (args.length > 3) {
							sender.sendMessage("AdminDrop - Too many arguments!");
							InfoDisplays.commadInfo(sender);
							return true;
						}
			}
		}
		return false;
	}

}

