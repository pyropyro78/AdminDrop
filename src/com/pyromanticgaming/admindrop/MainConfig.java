package com.pyromanticgaming.admindrop;

/*
 *Copyright (c) <2013-2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class MainConfig {

	private static AdminDrop plugin;

	public MainConfig(AdminDrop instance) {
		plugin = instance;
	}

	public static long SaveTimer = 200;
	public static boolean enderchestitem, announcechangetoother, brewingitem, dropperitem, hopperitem, dispenseritem, chestitem, pickupmessagetoggle, throwmessagetoggle, chestmessagetoggle, dropmessagetoggle, blockplacemessagetoggle, blockbreakmessagetoggle;
	public static String dropmessage = "AdminDrop Error - MCSL20", chestmessage = "AdminDrop Error - MCSL20", throwmessage = "AdminDrop Error - MCSL20", pickupmessage = "AdminDrop Error - MCSL20", nothingactiveselfmessage = "AdminDrop Error - MCSL20", pickupalwaysactivatedselfmessage = "AdminDrop Error - MCSL20", pickupdeactivatedselfmessage = "AdminDrop Error - MCSL20", pickupactivatedselfmessage = "AdminDrop Error - MCSL20", throwalwaysactivatedselfmessage = "AdminDrop Error - MCSL20", throwdeactivatedselfmessage = "AdminDrop Error - MCSL20", throwactivatedselfmessage = "AdminDrop Error - MCSL20", chestalwaysactivatedselfmessage = "AdminDrop Error - MCSL20", chestdeactivatedselfmessage = "AdminDrop Error - MCSL20", chestactivatedselfmessage = "AdminDrop Error - MCSL20", dropalwaysactivatedselfmessage = "AdminDrop Error - MCSL20", dropdeactivatedselfmessage = "AdminDrop Error - MCSL20", dropactivatedselfmessage = "AdminDrop Error - MCSL20", nothingactiveothermessage = "AdminDrop Error - MCSL20", playernotfoundmessage = "AdminDrop Error - MCSL20", pickupalwaysactivatedothermessage = "AdminDrop Error - MCSL20", throwalwaysactivatedothermessage = "AdminDrop Error - MCSL20", chestalwaysactivatedothermessage = "AdminDrop Error - MCSL20", dropalwaysactivatedothermessage = "AdminDrop Error - MCSL20", pickupactivatedothermessage = "AdminDrop Error - MCSL20", pickupdeactivatedothermessage = "AdminDrop Error - MCSL20", throwactivatedothermessage = "AdminDrop Error - MCSL20", throwdeactivatedothermessage = "AdminDrop Error - MCSL20", chestactivatedothermessage = "AdminDrop Error - MCSL20", chestdeactivatedothermessage = "AdminDrop Error - MCSL20", dropactivatedothermessage = "AdminDrop Error - MCSL20", dropdeactivatedothermessage = "AdminDrop Error - MCSL20", blockbreakactivatedothermessage = "AdminDrop Error - MCSL20", blockbreakdeactivatedothermessage = "AdminDrop Error - MCSL20", blockbreakalwaysactivatedothermessage = "AdminDrop Error - MCSL20", blockplaceactivatedothermessage = "AdminDrop Error - MCSL20", blockplacedeactivatedothermessage = "AdminDrop Error - MCSL20", blockplacealwaysactivatedothermessage = "AdminDrop Error - MCSL20", blockbreakactivatedselfmessage = "AdminDrop Error - MCSL20", blockbreakdeactivatedselfmessage = "AdminDrop Error - MCSL20", blockbreakalwaysactivatedselfmessage = "AdminDrop Error - MCSL20", blockplaceactivatedselfmessage = "AdminDrop Error - MCSL20", blockplacedeactivatedselfmessage = "AdminDrop Error - MCSL20", blockplacealwaysactivatedselfmessage = "AdminDrop Error - MCSL20", blockplacemessage = "AdminDrop Error - MCSL20", blockbreakmessage = "AdminDrop Error - MCSL20";

	public static void GetMainValues() {

		SaveTimer = plugin.getConfig().getLong("SaveTimer");
		chestitem = plugin.getConfig().getBoolean("Chest");
		brewingitem = plugin.getConfig().getBoolean("BrewingStand");
		dropperitem = plugin.getConfig().getBoolean("Dropper");
		hopperitem = plugin.getConfig().getBoolean("Hopper");
		dispenseritem = plugin.getConfig().getBoolean("Dispenser");
		announcechangetoother = plugin.getConfig().getBoolean("AnnounceChangeToOther");
		pickupmessagetoggle = plugin.getConfig().getBoolean("PickUpMessageToggle");
		throwmessagetoggle = plugin.getConfig().getBoolean("ThrowMessageToggle");
		chestmessagetoggle = plugin.getConfig().getBoolean("ChestMessageToggle");
		dropmessagetoggle = plugin.getConfig().getBoolean("DropMessageToggle");
		blockbreakmessagetoggle = plugin.getConfig().getBoolean("BlockBreakMessageToggle");
		blockplacemessagetoggle = plugin.getConfig().getBoolean("BlockPlacMessageToggle");
		enderchestitem = plugin.getConfig().getBoolean("EnderChest");



		dropmessage = plugin.getConfig().getString("DropMessage");
		chestmessage = plugin.getConfig().getString("ChestMessage");
		throwmessage = plugin.getConfig().getString("ThrowMessage");
		pickupmessage = plugin.getConfig().getString("PickUpMessage");
		blockbreakmessage = plugin.getConfig().getString("BlockBreakMessage");
		blockplacemessage = plugin.getConfig().getString("BlockPlaceMessage");
		playernotfoundmessage = plugin.getConfig().getString("PlayerNotFoundMessage");



		dropactivatedothermessage = plugin.getConfig().getString("DropActivatedOtherMessage");
		dropdeactivatedothermessage = plugin.getConfig().getString("DropDeactivatedOtherMessage");
		dropalwaysactivatedothermessage = plugin.getConfig().getString("DropAlwaysActiveOtherMessage");

		chestactivatedothermessage = plugin.getConfig().getString("ChestActivatedOtherMessage");
		chestdeactivatedothermessage = plugin.getConfig().getString("ChestDeactivatedOtherMessage");
		chestalwaysactivatedothermessage = plugin.getConfig().getString("DropAlwaysActiveOtherMessage");

		throwactivatedothermessage = plugin.getConfig().getString("ThrowActivatedOtherMessage");
		throwdeactivatedothermessage = plugin.getConfig().getString("ThrowDeactivatedOtherMessage");
		throwalwaysactivatedothermessage = plugin.getConfig().getString("DropAlwaysActiveOtherMessage");

		pickupactivatedothermessage = plugin.getConfig().getString("PickUpActivatedOtherMessage");
		pickupdeactivatedothermessage = plugin.getConfig().getString("PickUpDeactivatedOtherMessage");
		pickupalwaysactivatedothermessage = plugin.getConfig().getString("PickUpAlwaysActiveOtherMessage");

		nothingactiveothermessage = plugin.getConfig().getString("NothingIsActveOtherMessage");

		blockbreakactivatedothermessage = plugin.getConfig().getString("BlockBreakActivatedOtherMessage");
		blockbreakdeactivatedothermessage = plugin.getConfig().getString("BlockBreakDeactivatedOtherMessage");
		blockbreakalwaysactivatedothermessage = plugin.getConfig().getString("BlockBreakAlwaysActiveOtherMessage");

		blockplaceactivatedothermessage = plugin.getConfig().getString("BlockPlaceActivatedOtherMessage");
		blockplacedeactivatedothermessage = plugin.getConfig().getString("BlockPlaceDeactivatedOtherMessage");
		blockplacealwaysactivatedothermessage = plugin.getConfig().getString("BlockPlaceAlwaysActiveOtherMessage");



		dropactivatedselfmessage = plugin.getConfig().getString("DropActivatedSelfMessage");
		dropdeactivatedselfmessage = plugin.getConfig().getString("DropDeactivatedSelfMessage");
		dropalwaysactivatedselfmessage = plugin.getConfig().getString("DropAlwaysActiveSelfMessage");

		chestactivatedselfmessage = plugin.getConfig().getString("ChestActivatedSelfMessage");
		chestdeactivatedselfmessage = plugin.getConfig().getString("ChestDeactivatedSelfMessage");
		chestalwaysactivatedselfmessage = plugin.getConfig().getString("DropAlwaysActiveSelfMessage");

		throwactivatedselfmessage = plugin.getConfig().getString("ThrowActivatedSelfMessage");
		throwdeactivatedselfmessage = plugin.getConfig().getString("ThrowDeactivatedSelfMessage");
		throwalwaysactivatedselfmessage = plugin.getConfig().getString("DropAlwaysActiveSelfMessage");

		pickupactivatedselfmessage = plugin.getConfig().getString("PickUpActivatedSelfMessage");
		pickupdeactivatedselfmessage = plugin.getConfig().getString("PickUpDeactivatedSelfMessage");
		pickupalwaysactivatedselfmessage = plugin.getConfig().getString("PickUpAlwaysActiveSelfMessage");

		blockbreakactivatedselfmessage = plugin.getConfig().getString("BlockBreakActivatedSelfMessage");
		blockbreakdeactivatedselfmessage = plugin.getConfig().getString("BlockBreakDeactivatedSelfMessage");
		blockbreakalwaysactivatedselfmessage = plugin.getConfig().getString("BlockBreakAlwaysActiveSelfMessage");

		blockplaceactivatedselfmessage = plugin.getConfig().getString("BlockPlaceActivatedSelfMessage");
		blockplacedeactivatedselfmessage = plugin.getConfig().getString("BlockPlaceDeactivatedSelfMessage");
		blockplacealwaysactivatedselfmessage = plugin.getConfig().getString("BlockPlaceAlwaysActiveSelfMessage");

		nothingactiveselfmessage = plugin.getConfig().getString("NothingIsActveSelfMessage");
	}


}