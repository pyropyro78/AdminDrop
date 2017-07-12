All things need limitations, why not item related interactions? This plugin allows the server to impose restrictions on a player to prevent them from throwing/picking up items, opening specific inventories, and placing/breaking blocks.

Utilizing permissions you can force a player or group to always have restrictions or paired with a region plugin for event areas. Great for a multitude of server types ranging from RPG servers (prison servers especially) to hardcore PVP servers and can even come in handy for events.

AdminDrop v3.0.0.0 Tested On:
•	1.7.2 / 1.8 / 1.9 / 1.10 / 1.11 / 1.12

Features:
•	Stops the dropping of items on death for self or target player
•	Stops the ability to throw items for self or target player
•	Stops the ability of picking up items for self or target player
•	Stops the ability of opening chests and storage items for self or target player
•	Stops the ability to break blocks for self or target player
•	Stops the ability to place blocks for self or target player
•	Checks personal status of toggles and that of other players
 
Permissions:
-Self
•	AdminDrop.self.status - Check one's own status of toggles
•	AdminDrop.self.deathdrop - Set one's own drops on death toggle
•	AdminDrop.self.throwaway - Set one's own throwing away toggle
•	AdminDrop.self.pickup - Set one's own picking up of items toggle
•	AdminDrop.self.chestaccess - Set one's own ability to open chests or storage items (single, double, ender, hopper, dropper, minecart chest, brewing stand)
•	AdminDrop.self.block.break - Set one’s own restriction to breaking blocks
•	AdminDrop.self.block.place - Set one’s own restriction to placing blocks
-Other
•	AdminDrop.other.status - Check status of others' toggles.
•	AdminDrop.other.deathdrop - Modify other user's drops on death toggle.
•	AdminDrop.other.throwaway - Set others' throwing away toggle.
•	AdminDrop.other.pickup - Modify other user's drops on death toggle.
•	AdminDrop.other.chestaccess - Set others' ability to open chests or storage items (single, double, ender, hopper, dropper, minecart chest, brewing stand).
•	AdminDrop.other.block.break - Set others' own restriction to breaking blocks
•	AdminDrop.other.block.place - Set others' own restriction to placing blocks
-Overrides
•	AdminDrop.alwayson.deathdrop - Makes toggle for drops on death always on
•	AdminDrop.alwayson.throwaway - Makes throwing away toggle always on
•	AdminDrop.alwayson.pickup - Makes picking up of items toggle always on
•	AdminDrop.alwayson.chestaccess - Makes chest access toggle always on
•	AdminDrop.alwayson.block.break - Makes block breaking toggle always on
•	AdminDrop.alwayson/block.place - Makes block placing toggle always on
-Override Ignore Star
-If you use the '*' permission on a user/group that you wish to have something like AdminDrop.alwayson.pickup you will need to use - -AdminDrop.ignore.star.pickup on the line before the '*' permission to enable it on that a user/group.
•	AdminDrop.ignore.star.deathdrop - Makes toggle for drops on death always on for ‘*’ users
•	AdminDrop.ignore.star.throwaway - Makes throwing away toggle always on for ‘*’ users
•	AdminDrop.ignore.star.pickup - Makes picking up of items toggle always on for ‘*’ users
•	AdminDrop.ignore.star.chestaccess - Makes chest access toggle always on for ‘*’ users
•	AdminDrop.ignore.star.block.break - Makes block breaking toggle always on for ‘*’ users
•	AdminDrop.ignore.star.block.place - Makes block placing toggle always on for ‘*’ users

Commands:
•	/ad deathdrop - Toggles Death Drops on/off
•	/ad deathdrop [player] - Toggles other's Death Drops on/off
•	/ad deathdrop [player] [ON/OFF] - Toggles other's Death Drops on/off
•	/ad throwaway - Toggles the ability to throw away items on/off
•	/ad throwaway [player] - Toggles other's throw away items on/off
•	/ad throwaway [player] [ON/OFF] - Toggles other's throw away items on/off
•	/ad pickup - Toggles the ability to pick up items on/off
•	/ad pickup [player] - Toggles other's ability to pick up items on/off
•	/ad pickup [player] [ON/OFF] - Toggles other's ability to pick up items on/off
•	/ad chestaccess - Toggles the ability to open chests on/off
•	/ad chestaccess [player] - Toggles other's ability to open chests on/off
•	/ad chestaccess [player] [ON/OFF] - Toggles other's ability to open chests on/off
•	/ad blockbreak - Toggles the restriction to break blocks on/off
•	/ad blockbreak [player] - Toggles other's restriction to break blocks on/off
•	/ad blockbreak [player] [ON/OFF] - Toggles other's restriction to break blocks on/off
•	/ad blockplace - Toggles the restriction to place blocks on/off
•	/ad blockplace [player] - Toggles other's restriction to place blocks on/off
•	/ad blockplace [player] [ON/OFF] - Toggles other's restriction to place blocks on/off
•	/ad status - Gets current status
•	/ad status [player] - Gets players current status
•	/ad help - Displays commands
•	/ad alt - Shows alternate commands

Alternate Commands:
•	/ad dd - Toggles Death Drops on/off
•	/ad dd [player] - Toggles other's Death Drops on/off
•	/ad dd [player] [ON/OFF] - Toggles other's Death Drops on/off
•	/ad ta - Toggles the ability to throw away items on/off
•	/ad ta [player] - Toggles other's throw away items on/off
•	/ad ta [player] [ON/OFF] - Toggles other's throw away items on/off
•	/ad pu - Toggles the ability to pick up items on/off
•	/ad pu [player] - Toggles other's ability to pick up items on/off
•	/ad pu [player] [ON/OFF] - Toggles other's ability to pick up items on/off
•	/ad ca - Toggles the ability to open chests on/off
•	/ad ca [player] - Toggles other's ability to open chests on/off
•	/ad ca [player] [ON/OFF] - Toggles other's ability to open chests on/off
•	/ad bb - Toggles the restriction to break blocks on/off
•	/ad bb [player] - Toggles other's restriction to break blocks on/off
•	/ad bb [player] [ON/OFF] - Toggles other's restriction to break blocks on/off
•	/ad bp - Toggles the restriction to place blocks on/off
•	/ad bp [player] - Toggles other's restriction to place blocks on/off
•	/ad bp [player] [ON/OFF] - Toggles other's restriction to place blocks on/off
•	/ad status - Gets current status
•	/ad status [player] - Gets players current status
•	/ad help - Displays commands
•	/ad ac - Shows alternate commands

Configs:
-config.yml:
#How often players should save to the config.
#20 = 1 sec
#Default is 400
SaveTimer: 400

#The following options are as follows:
#True: When user has restricted chest access this option will stop them from opening said item.
#False: Allows user to open said chest even with chest access restricted.
#Default is True.
Chest: true
EnderChest: true
Hopper: true 
Dropper: true 
Dispenser: true 
BrewingStand: true

#When true other player will be notified when toggles change.
#The toggle defaults to: true
AnnounceChangeToOther: true

#What is said to a player when this action is prevented and if the message is displayed.
#The toggle defaults to: false
PickUpMessage: You cannot pickup items.
PickUpMessageToggle: false

#Messages sent to a player when settings are changed or checked.
#Includes Player name and a space before the custom text for all 'OtherMesage' statements.
PickUpDeactivatedOtherMessage: can pick up items.
PickUpActivatedOtherMessage: cannot pick up items.
PickUpAlwaysActiveOtherMessage: can never pick up items.
PickUpDeactivatedSelfMessage: You can pick up items.
PickUpActivatedSelfMessage: You cannot pick up items.
PickUpAlwaysActiveSelfMessage: You can never pick up items.

#What is said to a player when this action is prevented and if the message is displayed.
#The toggle defaults to: true
ThrowMessage: You cannot throw items.
ThrowMessageToggle: true

#Messages sent to a player when settings are changed or checked.
#Includes Player name and a space before the custom text for all 'OtherMesage' statements.
ThrowDeactivatedOtherMessage: can throw items.
ThrowActivatedOtherMessage: cannot throw items.
ThrowAlwaysActiveOtherMessage: can never throw items.
ThrowDeactivatedSelfMessage: You can throw items.
ThrowActivatedSelfMessage: You cannot throw items.
ThrowAlwaysActiveSelfMessage: You can never throw items.

#What is said to a player when this action is prevented and if the message is displayed.
#The toggle defaults to: true
ChestMessage: You cannot open this.
ChestMessageToggle: true

#Messages sent to a player when settings are changed or checked.
#Includes Player name and a space before the custom text for all 'OtherMesage' statements.
ChestDeactivatedOtherMessage: can access chests.
ChestActivatedOtherMessage: cannot access chests.
ChestAlwaysActiveOtherMessage: can never access chests.
ChestDeactivatedSelfMessage: You can access chests.
ChestActivatedSelfMessage: You cannot access chests.
ChestAlwaysActiveSelfMessage: You can never access chests.

#What is said to a player when this action is prevented and if the message is displayed.
#The toggle defaults to: true
DropMessage: Your items have vanished upon your death.
DropMessageToggle: true

#Messages sent to a player when settings are changed or checked.
#Includes Player name and a space before the custom text for all 'OtherMesage' statements.
DropDeactivatedOtherMessage: can drop items at death.
DropActivatedOtherMessage: is safe from dropping items at death.
DropAlwaysActiveOtherMessage: can never drop items at death.
DropDeactivatedSelfMessage: You drop items at death.
DropActivatedSelfMessage: You are safe from dropping items at death.
DropAlwaysActiveSelfMessage: You can never drop items at death.

#What is said to a player when this action is prevented and if the message is displayed.
#The toggle defaults to: false
BlockBreakMessage: You cannot pickup items.
BlockBreakMessageToggle: false

#Messages sent to a player when settings are changed or checked.
#Includes Player name and a space before the custom text for all 'OtherMesage' statements.
BlockBreakDeactivatedOtherMessage: can break blocks.
BlockBreakActivatedOtherMessage: cannot break blocks.
BlockBreakAlwaysActiveOtherMessage: can never break blocks.
BlockBreakDeactivatedSelfMessage: You can break blocks.
BlockBreakActivatedSelfMessage: You cannot break blocks.
BlockBreakAlwaysActiveSelfMessage: You can never break blocks.

#What is said to a player when this action is prevented and if the message is displayed.
#The toggle defaults to: false
BlockPlaceMessage: You cannot pickup items.
BlockPlaceMessageToggle: false

#Messages sent to a player when settings are changed or checked.
#Includes Player name and a space before the custom text for all 'OtherMesage' statements.
BlockPlaceDeactivatedOtherMessage: can place blocks.
BlockPlaceActivatedOtherMessage: cannot place blocks.
BlockPlaceAlwaysActiveOtherMessage: can never place blocks.
BlockPlaceDeactivatedSelfMessage: You can place blocks.
BlockPlaceActivatedSelfMessage: You cannot place blocks.
BlockPlaceAlwaysActiveSelfMessage: You can never place blocks.

#What is said to a player when a player name is incorrect or not found.
PlayerNotFoundMessage: Player not found or incorrectly spelled.

#What is said to a player when checking the settings of a player/self and has no restrictions.
#Includes Player name and a space before the custom text for all 'OtherMesage' statements.
NothingIsActveOtherMessage: has no restrictions at this time.
NothingIsActveSelfMessage: You have no restrictions at this time.

-player.yml:
Players:
  pyropyro78:
    ChestAccess: false
    DropAccess: false
    ThrowAccess: false
    PickUpAccess: false
    BlockBreak: false
    BlockPlace: false

Notes:
•	Remember, always delete your old config or make the appropriate changes when updating to a newer version as things may have changed.
•	Items do not stay in inventory on death if drops are toggled to not drop, they just simply do not drop them.
This plugin was authored by pyropyro78.
