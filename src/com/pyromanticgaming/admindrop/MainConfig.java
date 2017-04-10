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
	public static boolean enderchestitem, announcechangetoother, brewingitem, dropperitem, hopperitem, dispenseritem, chestitem, pickupmessagetoggle, throwmessagetoggle, chestmessagetoggle, dropmessagetoggle;
	public static String dropmessage, chestmessage, throwmessage, pickupmessage, nothingactiveselfmessage, pickupalwaysactivatedselfmessage, pickupdeactivatedselfmessage, pickupactivatedselfmessage, throwalwaysactivatedselfmessage, throwdeactivatedselfmessage, throwactivatedselfmessage, chestalwaysactivatedselfmessage, chestdeactivatedselfmessage, chestactivatedselfmessage, dropalwaysactivatedselfmessage, dropdeactivatedselfmessage, dropactivatedselfmessage, nothingactiveothermessage, playernotfoundmessage, pickupalwaysactivatedothermessage, throwalwaysactivatedothermessage, chestalwaysactivatedothermessage, dropalwaysactivatedothermessage, pickupactivatedothermessage, pickupdeactivatedothermessage, throwactivatedothermessage, throwdeactivatedothermessage, chestactivatedothermessage, chestdeactivatedothermessage, dropactivatedothermessage, dropdeactivatedothermessage;
	
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
		enderchestitem = plugin.getConfig().getBoolean("EnderChest");
		
		dropmessage = plugin.getConfig().getString("DropMessage");
		chestmessage = plugin.getConfig().getString("ChestMessage");
		throwmessage = plugin.getConfig().getString("ThrowMessage");
		pickupmessage = plugin.getConfig().getString("PickUpMessage");
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
		pickupactivatedothermessage = plugin.getConfig().getString("PickupActivatedOtherMessage");
		pickupdeactivatedothermessage = plugin.getConfig().getString("PickupDeactivatedOtherMessage");
		pickupalwaysactivatedothermessage = plugin.getConfig().getString("DropAlwaysActiveOtherMessage");
		nothingactiveothermessage = plugin.getConfig().getString("NothingIsActveOtherMessage");
		
		dropactivatedselfmessage = plugin.getConfig().getString("DropActivatedSelfMessage");
		dropdeactivatedselfmessage = plugin.getConfig().getString("DropDeactivatedSelfMessage");
		dropalwaysactivatedselfmessage = plugin.getConfig().getString("DropAlwaysActiveSelfMessage");
		chestactivatedselfmessage = plugin.getConfig().getString("ChestActivatedSelfMessage");
		chestdeactivatedselfmessage = plugin.getConfig().getString("ChestDeactivatedSelfMessage");
		chestalwaysactivatedselfmessage = plugin.getConfig().getString("DropAlwaysActiveSelfMessage");
		throwactivatedselfmessage = plugin.getConfig().getString("ThrowActivatedSelfMessage");
		throwdeactivatedselfmessage = plugin.getConfig().getString("ThrowDeactivatedSelfMessage");
		throwalwaysactivatedselfmessage = plugin.getConfig().getString("DropAlwaysActiveSelfMessage");
		pickupactivatedselfmessage = plugin.getConfig().getString("PickupActivatedSelfMessage");
		pickupdeactivatedselfmessage = plugin.getConfig().getString("PickupDeactivatedSelfMessage");
		pickupalwaysactivatedselfmessage = plugin.getConfig().getString("DropAlwaysActiveSelfMessage");
		nothingactiveselfmessage = plugin.getConfig().getString("NothingIsActveSelfMessage");
	}


}