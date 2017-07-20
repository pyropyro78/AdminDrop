package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78 / Bradley Van Dyne>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.bukkit.entity.Player;

import com.pyromanticgaming.admindrop.Config.ConfigManager;
import com.pyromanticgaming.admindrop.Config.MainConfig;

public class JoinToggles {

	public static void runCheck(Player playerjoined) {
		String p = playerjoined.getName();
		Boolean newToggle = false;
		if (!PlayerToggles.listedDropAccess(p)) {
			newToggle = true;
			if (playerjoined.hasPermission("AdminDrop.alwayson.deathdrop") && !playerjoined.hasPermission("AdminDrop.ignore.star.deathdrop")) {

				PlayerToggles.dropaccess.put(p, true);

			} else {

				PlayerToggles.dropaccess.put(p, MainConfig.defaultdeathdrop);

			}
		}
		if (!PlayerToggles.listedThrowAccess(p)) {
			newToggle = true;
			if (playerjoined.hasPermission("AdminDrop.alwayson.throwaway") && !playerjoined.hasPermission("AdminDrop.ignore.star.throwaway")) {

				PlayerToggles.throwaccess.put(p, true);

			} else {

				PlayerToggles.throwaccess.put(p, MainConfig.defaultthrowaway);

			}

		}
		if (!PlayerToggles.listedPickUpAccess(p)) {
			newToggle = true;
			if (playerjoined.hasPermission("AdminDrop.alwayson.pickup") && !playerjoined.hasPermission("AdminDrop.ignore.star.pickup")) {

				PlayerToggles.pickupaccess.put(p, true);

			} else {

				PlayerToggles.pickupaccess.put(p, MainConfig.defaultpickup);

			}

		}
		if (!PlayerToggles.listedChestAccess(p)) {
			newToggle = true;
			if (playerjoined.hasPermission("AdminDrop.alwayson.chestaccess") && !playerjoined.hasPermission("AdminDrop.ignore.star.chestaccess")) {

				PlayerToggles.chestaccess.put(p, true);

			} else {

				PlayerToggles.chestaccess.put(p, MainConfig.defaultchestaccess);

			}

		}
		if (!PlayerToggles.listedBlockBreak(p)) {
			newToggle = true;
			if (playerjoined.hasPermission("AdminDrop.alwayson.block.break") && !playerjoined.hasPermission("AdminDrop.ignore.star.block.break")) {

				PlayerToggles.blockbreak.put(p, true);

			} else {

				PlayerToggles.blockbreak.put(p, MainConfig.defaultblockbreak);

			}

		}
		if (!PlayerToggles.listedBlockPlace(p)) {
			newToggle = true;
			if (playerjoined.hasPermission("AdminDrop.alwayson.block.place") && !playerjoined.hasPermission("AdminDrop.ignore.star.block.place")) {

				PlayerToggles.blockplace.put(p, true);

			} else {

				PlayerToggles.blockplace.put(p, MainConfig.defaultblockplace);

			}

		}
		if (newToggle) {
			ConfigManager.saveAllConfigs();
			newToggle = false;
		}
	}

}