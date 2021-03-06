package com.pyromanticgaming.admindrop.Config;


import com.pyromanticgaming.admindrop.AdminDrop;

public class MainConfig {

	@SuppressWarnings("unused")
	private static AdminDrop plugin;

	public MainConfig(AdminDrop instance) {
		plugin = instance;
	}


	public static boolean enderchestitem, defaultblockplace, defaultblockbreak, defaultdeathdrop, defaultchestaccess, defaultpickup, defaultthrowaway, announcechangetoother, brewingitem, dropperitem, hopperitem, dispenseritem, chestitem, pickupmessagetoggle, throwmessagetoggle, chestmessagetoggle, dropmessagetoggle, blockplacemessagetoggle, blockbreakmessagetoggle;
	public static String dropmessage, configreloadmessage, allchangedmessage, chestmessage, throwmessage, pickupmessage, nothingactiveselfmessage, pickupalwaysactivatedselfmessage, pickupdeactivatedselfmessage, pickupactivatedselfmessage, throwalwaysactivatedselfmessage, throwdeactivatedselfmessage, throwactivatedselfmessage, chestalwaysactivatedselfmessage, chestdeactivatedselfmessage, chestactivatedselfmessage, dropalwaysactivatedselfmessage, dropdeactivatedselfmessage, dropactivatedselfmessage, nothingactiveothermessage, playernotfoundmessage, pickupalwaysactivatedothermessage, throwalwaysactivatedothermessage, chestalwaysactivatedothermessage, dropalwaysactivatedothermessage, pickupactivatedothermessage, pickupdeactivatedothermessage, throwactivatedothermessage, throwdeactivatedothermessage, chestactivatedothermessage, chestdeactivatedothermessage, dropactivatedothermessage, dropdeactivatedothermessage, blockbreakactivatedothermessage, blockbreakdeactivatedothermessage, blockbreakalwaysactivatedothermessage, blockplaceactivatedothermessage, blockplacedeactivatedothermessage, blockplacealwaysactivatedothermessage, blockbreakactivatedselfmessage, blockbreakdeactivatedselfmessage, blockbreakalwaysactivatedselfmessage, blockplaceactivatedselfmessage, blockplacedeactivatedselfmessage, blockplacealwaysactivatedselfmessage, blockplacemessage, blockbreakmessage;

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

		defaultthrowaway = ConfigManager.mianconfig.getBoolean("DefaultThrowAway");
		defaultpickup = ConfigManager.mianconfig.getBoolean("DefaultPickUp");
		defaultchestaccess = ConfigManager.mianconfig.getBoolean("DefaultChestAccess");
		defaultdeathdrop = ConfigManager.mianconfig.getBoolean("DefaultDeathDrop");
		defaultblockbreak = ConfigManager.mianconfig.getBoolean("DefaultBlockBreak");
		defaultblockplace = ConfigManager.mianconfig.getBoolean("DefaultBlockPlace");



		allchangedmessage = ConfigManager.mianconfig.getString("AllChangedMessage");

		configreloadmessage = ConfigManager.mianconfig.getString("ConfigReloadMessage");

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