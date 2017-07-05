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
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
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
			boolean canBP = sender.hasPermission("AdminDrop.self.block.place")
					|| sender.isOp();
			boolean canBB = sender.hasPermission("AdminDrop.self.block.break")
					|| sender.isOp();
			boolean canMoBP = sender.hasPermission("AdminDrop.other.block.place")
					|| sender.isOp();
			boolean canMoBB = sender.hasPermission("AdminDrop.other.block.break")
					|| sender.isOp();
			alwaysDD = (sender.hasPermission("AdminDrop.alwayson.deathdrop") && !sender.hasPermission("AdminDrop.ignore.star.deathdrop"));
			alwaysCA = (sender.hasPermission("AdminDrop.alwayson.chestaccess") && !sender.hasPermission("AdminDrop.ignore.star.chestaccess"));
			alwaysTA = (sender.hasPermission("AdminDrop.alwayson.throwaway") && !sender.hasPermission("AdminDrop.ignore.star.throwaway"));
			alwaysPU = (sender.hasPermission("AdminDrop.alwayson.pickup") && !sender.hasPermission("AdminDrop.ignore.star.pickup"));
			alwaysBP = (sender.hasPermission("AdminDrop.alwayson.block.place") && !sender.hasPermission("AdminDrop.ignore.star.block.place"));
			alwaysBB = (sender.hasPermission("AdminDrop.alwayson.block.break") && !sender.hasPermission("AdminDrop.ignore.star.block.break"));



			if (args.length == 1) {
				if (sender instanceof Player) {
					if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canDD) {
						DeathDrop.Command(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && canTa) {
						ThrowAway.Command(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && canPU) {
						PickUp.Command(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && canCA) {
						ChestAccess.Command(sender);
						return true;
					}  else if ((args[0].equalsIgnoreCase("bp") || args[0].equalsIgnoreCase("blockplace")) && canBP) {
						BlockPlace.Command(sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("bb") || args[0].equalsIgnoreCase("blockbreak")) && canBB) {
						BlockBreak.Command(sender);
						return true;
					} else if (args[0].equalsIgnoreCase("status")
							&& canS) {
						Status.SelfCommand(sender);
						return true;
					}
				} 
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage("AdminDrop Help Information.");
					InfoDisplays.CommadInfo(sender);
					return true;
				} else if (args[0].equalsIgnoreCase("alt") ||args[0].equalsIgnoreCase("ac")) {
					sender.sendMessage("AdminDrop Alternate Help Information.");
					InfoDisplays.AltCommandInfo(sender);
					return true;
				}
			} else if (args.length == 2) {
				if (Bukkit.getPlayer(args[1]) instanceof Player) {
					otherPlayer = Bukkit.getPlayer(args[1]);
					alwaysDD = (otherPlayer.hasPermission("AdminDrop.alwayson.deathdrop") && !otherPlayer.hasPermission("AdminDrop.ignore.star.deathdrop"));
					alwaysCA = (otherPlayer.hasPermission("AdminDrop.alwayson.chestaccess") && !otherPlayer.hasPermission("AdminDrop.ignore.star.chestaccess"));
					alwaysTA = (otherPlayer.hasPermission("AdminDrop.alwayson.throwaway") && !otherPlayer.hasPermission("AdminDrop.ignore.star.throwaway"));
					alwaysPU = (otherPlayer.hasPermission("AdminDrop.alwayson.pickup") && !otherPlayer.hasPermission("AdminDrop.ignore.star.pickup"));
					alwaysBP = (otherPlayer.hasPermission("AdminDrop.alwayson.block.place") && !sender.hasPermission("AdminDrop.ignore.star.block.place"));
					alwaysBB = (otherPlayer.hasPermission("AdminDrop.alwayson.block.break") && !sender.hasPermission("AdminDrop.ignore.star.block.break"));

					if (args[0].equalsIgnoreCase("status") && canSo) {
						Status.OtherCommand(otherPlayer, sender);
						return true;
					} else if ((args[0].equalsIgnoreCase("ta") || args[0].equalsIgnoreCase("throwaway")) && canMoTA) {
						ThrowAway.ModifyOther(otherPlayer, sender, alwaysTA);
						return true;
					} else if ((args[0].equalsIgnoreCase("pu") || args[0].equalsIgnoreCase("pickup")) && canMoPU) {
						PickUp.ModifyOther(otherPlayer, sender, alwaysPU);
						return true;
					} else if ((args[0].equalsIgnoreCase("ca") || args[0].equalsIgnoreCase("chestaccess")) && canMoCA) {
						ChestAccess.ModifyOther(otherPlayer, sender, alwaysCA);
						return true;
					} else if ((args[0].equalsIgnoreCase("dd") || args[0].equalsIgnoreCase("deathdrop")) && canMoDD) {
						DeathDrop.ModifyOther(otherPlayer, sender, alwaysDD);
						return true;
					} else if ((args[0].equalsIgnoreCase("bb") || args[0].equalsIgnoreCase("blockbreak")) && canMoBB) {
						BlockBreak.ModifyOther(otherPlayer, sender, alwaysBB);
						return true;
					} else if ((args[0].equalsIgnoreCase("bp") || args[0].equalsIgnoreCase("blockplace")) && canMoBP) {
						BlockPlace.ModifyOther(otherPlayer, sender, alwaysBP);
						return true;
					} else {
						InfoDisplays.PlayerNotFound(sender);
						return true;
					}
				}

			} else if (args.length > 2) {
				sender.sendMessage("AdminDrop - Too many arguments!");
				InfoDisplays.CommadInfo(sender);
				return true;
			}
		}
		return false;
	}


}

