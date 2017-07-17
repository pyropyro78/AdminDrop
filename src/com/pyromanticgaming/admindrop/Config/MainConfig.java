package com.pyromanticgaming.admindrop.Config;

import com.pyromanticgaming.admindrop.AdminDrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class MainConfig {

	@SuppressWarnings("unused")
	private static AdminDrop plugin;

	public MainConfig(AdminDrop instance) {
		plugin = instance;
	}
	
	
	public static boolean enderchestitem, announcechangetoother, brewingitem, dropperitem, hopperitem, dispenseritem, chestitem, pickupmessagetoggle, throwmessagetoggle, chestmessagetoggle, dropmessagetoggle, blockplacemessagetoggle, blockbreakmessagetoggle;
	public static String dropmessage, chestmessage, throwmessage, pickupmessage, nothingactiveselfmessage, pickupalwaysactivatedselfmessage, pickupdeactivatedselfmessage, pickupactivatedselfmessage, throwalwaysactivatedselfmessage, throwdeactivatedselfmessage, throwactivatedselfmessage, chestalwaysactivatedselfmessage, chestdeactivatedselfmessage, chestactivatedselfmessage, dropalwaysactivatedselfmessage, dropdeactivatedselfmessage, dropactivatedselfmessage, nothingactiveothermessage, playernotfoundmessage, pickupalwaysactivatedothermessage, throwalwaysactivatedothermessage, chestalwaysactivatedothermessage, dropalwaysactivatedothermessage, pickupactivatedothermessage, pickupdeactivatedothermessage, throwactivatedothermessage, throwdeactivatedothermessage, chestactivatedothermessage, chestdeactivatedothermessage, dropactivatedothermessage, dropdeactivatedothermessage, blockbreakactivatedothermessage, blockbreakdeactivatedothermessage, blockbreakalwaysactivatedothermessage, blockplaceactivatedothermessage, blockplacedeactivatedothermessage, blockplacealwaysactivatedothermessage, blockbreakactivatedselfmessage, blockbreakdeactivatedselfmessage, blockbreakalwaysactivatedselfmessage, blockplaceactivatedselfmessage, blockplacedeactivatedselfmessage, blockplacealwaysactivatedselfmessage, blockplacemessage, blockbreakmessage;

	public static void GetMainValues() {

		chestitem = ConfigManager.mianconfig.getBoolean("Chest");
		brewingitem = ConfigManager.mianconfig.getBoolean("BrewingStand");
		dropperitem = ConfigManager.mianconfig.getBoolean("Dropper");
		hopperitem = ConfigManager.mianconfig.getBoolean("Hopper");
		dispenseritem = ConfigManager.mianconfig.getBoolean("Dispenser");
		announcechangetoother = ConfigManager.mianconfig.getBoolean("AnnounceChangeToOther");
		pickupmessagetoggle = ConfigManager.mianconfig.getBoolean("PickUpMessageToggle");
		throwmessagetoggle = ConfigManager.mianconfig.getBoolean("ThrowMessageToggle");
		chestmessagetoggle = ConfigManager.mianconfig.getBoolean("ChestMessageToggle");
		dropmessagetoggle = ConfigManager.mianconfig.getBoolean("DropMessageToggle");
		blockbreakmessagetoggle = ConfigManager.mianconfig.getBoolean("BlockBreakMessageToggle");
		blockplacemessagetoggle = ConfigManager.mianconfig.getBoolean("BlockPlacMessageToggle");
		enderchestitem = ConfigManager.mianconfig.getBoolean("EnderChest");



		dropmessage = ConfigManager.mianconfig.getString("DropMessage");
		chestmessage = ConfigManager.mianconfig.getString("ChestMessage");
		throwmessage = ConfigManager.mianconfig.getString("ThrowMessage");
		pickupmessage = ConfigManager.mianconfig.getString("PickUpMessage");
		blockbreakmessage = ConfigManager.mianconfig.getString("BlockBreakMessage");
		blockplacemessage = ConfigManager.mianconfig.getString("BlockPlaceMessage");
		playernotfoundmessage = ConfigManager.mianconfig.getString("PlayerNotFoundMessage");



		dropactivatedothermessage = ConfigManager.mianconfig.getString("DropActivatedOtherMessage");
		dropdeactivatedothermessage = ConfigManager.mianconfig.getString("DropDeactivatedOtherMessage");
		dropalwaysactivatedothermessage = ConfigManager.mianconfig.getString("DropAlwaysActiveOtherMessage");

		chestactivatedothermessage = ConfigManager.mianconfig.getString("ChestActivatedOtherMessage");
		chestdeactivatedothermessage = ConfigManager.mianconfig.getString("ChestDeactivatedOtherMessage");
		chestalwaysactivatedothermessage = ConfigManager.mianconfig.getString("DropAlwaysActiveOtherMessage");

		throwactivatedothermessage = ConfigManager.mianconfig.getString("ThrowActivatedOtherMessage");
		throwdeactivatedothermessage = ConfigManager.mianconfig.getString("ThrowDeactivatedOtherMessage");
		throwalwaysactivatedothermessage = ConfigManager.mianconfig.getString("DropAlwaysActiveOtherMessage");

		pickupactivatedothermessage = ConfigManager.mianconfig.getString("PickUpActivatedOtherMessage");
		pickupdeactivatedothermessage = ConfigManager.mianconfig.getString("PickUpDeactivatedOtherMessage");
		pickupalwaysactivatedothermessage = ConfigManager.mianconfig.getString("PickUpAlwaysActiveOtherMessage");

		nothingactiveothermessage = ConfigManager.mianconfig.getString("NothingIsActveOtherMessage");

		blockbreakactivatedothermessage = ConfigManager.mianconfig.getString("BlockBreakActivatedOtherMessage");
		blockbreakdeactivatedothermessage = ConfigManager.mianconfig.getString("BlockBreakDeactivatedOtherMessage");
		blockbreakalwaysactivatedothermessage = ConfigManager.mianconfig.getString("BlockBreakAlwaysActiveOtherMessage");

		blockplaceactivatedothermessage = ConfigManager.mianconfig.getString("BlockPlaceActivatedOtherMessage");
		blockplacedeactivatedothermessage = ConfigManager.mianconfig.getString("BlockPlaceDeactivatedOtherMessage");
		blockplacealwaysactivatedothermessage = ConfigManager.mianconfig.getString("BlockPlaceAlwaysActiveOtherMessage");



		dropactivatedselfmessage = ConfigManager.mianconfig.getString("DropActivatedSelfMessage");
		dropdeactivatedselfmessage = ConfigManager.mianconfig.getString("DropDeactivatedSelfMessage");
		dropalwaysactivatedselfmessage = ConfigManager.mianconfig.getString("DropAlwaysActiveSelfMessage");

		chestactivatedselfmessage = ConfigManager.mianconfig.getString("ChestActivatedSelfMessage");
		chestdeactivatedselfmessage = ConfigManager.mianconfig.getString("ChestDeactivatedSelfMessage");
		chestalwaysactivatedselfmessage = ConfigManager.mianconfig.getString("DropAlwaysActiveSelfMessage");

		throwactivatedselfmessage = ConfigManager.mianconfig.getString("ThrowActivatedSelfMessage");
		throwdeactivatedselfmessage = ConfigManager.mianconfig.getString("ThrowDeactivatedSelfMessage");
		throwalwaysactivatedselfmessage = ConfigManager.mianconfig.getString("DropAlwaysActiveSelfMessage");

		pickupactivatedselfmessage = ConfigManager.mianconfig.getString("PickUpActivatedSelfMessage");
		pickupdeactivatedselfmessage = ConfigManager.mianconfig.getString("PickUpDeactivatedSelfMessage");
		pickupalwaysactivatedselfmessage = ConfigManager.mianconfig.getString("PickUpAlwaysActiveSelfMessage");

		blockbreakactivatedselfmessage = ConfigManager.mianconfig.getString("BlockBreakActivatedSelfMessage");
		blockbreakdeactivatedselfmessage = ConfigManager.mianconfig.getString("BlockBreakDeactivatedSelfMessage");
		blockbreakalwaysactivatedselfmessage = ConfigManager.mianconfig.getString("BlockBreakAlwaysActiveSelfMessage");

		blockplaceactivatedselfmessage = ConfigManager.mianconfig.getString("BlockPlaceActivatedSelfMessage");
		blockplacedeactivatedselfmessage = ConfigManager.mianconfig.getString("BlockPlaceDeactivatedSelfMessage");
		blockplacealwaysactivatedselfmessage = ConfigManager.mianconfig.getString("BlockPlaceAlwaysActiveSelfMessage");

		nothingactiveselfmessage = ConfigManager.mianconfig.getString("NothingIsActveSelfMessage");
	}


}