# AdminDrop
#### Bukkit / Spigot / Minecraft / Server Plugin
#

##### Officially back on GitHub! This comes with a change to the MIT license in honor of Hacktober.

All things need limitations, why not item related interactions? This plugin allows the server to impose restrictions on a player to prevent them from throwing/picking up items, opening specific inventories, and placing/breaking blocks.

Utilizing permissions you can force a player or group to always have restrictions or paired with a region plugin for event areas. Great for a multitude of server types ranging from RPG servers (prison servers especially) to hardcore PVP servers and can even come in handy for events.


#### AdminDrop v3.0.0.0 Tested On:
• 1.7.2 / 1.8 / 1.9 / 1.10 / 1.11 / 1.12

#### AdminDrop v4.0.0.0rxx-SNAPSHOT Not Always Tested.
Use Builds on Jenkins with that in mind. 
Jenkins is currently only open to some, that will change with time.
    
#### Features:

• Stops the dropping of items on death for self, target or all offline/online players

• Stops the ability to throw items for self, target or all offline/online players

• Stops the ability of picking up items for self, target or all offline/online players

• Stops in the name of love; for self, target or all offline/online players

• Stops the ability of opening chests and storage items for self, target or all offline/online players

• Stops the ability to break blocks for self, target or all offline/online players

• Stops the ability to place blocks for self, target or all offline/online players

• Checks personal status of toggles and that of other players
    
 
Want to reach out or follow me? Find me on Twitter @pyropyro78
 

#### Permissions:
##### Self

• AdminDrop.self.status - Check one's own status of toggles

• AdminDrop.self.deathdrop - Set one's own drops on death toggle

• AdminDrop.self.throwaway - Set one's own throwing away toggle

• AdminDrop.self.pickup - Set one's own picking up of items toggle

• AdminDrop.self.chestaccess - Set one's own ability to open chests or storage items (single, double, ender, hopper, dropper, minecart chest, brewing stand)

• AdminDrop.self.block.break - Set one’s own restriction to breaking blocks

• AdminDrop.self.block.place - Set one’s own restriction to placing blocks


##### Other

• AdminDrop.other.status - Check status of others' toggles.

• AdminDrop.other.deathdrop - Modify other user's drops on death toggle.

• AdminDrop.other.throwaway - Set others' throwing away toggle.

• AdminDrop.other.pickup - Modify other user's drops on death toggle.

• AdminDrop.other.chestaccess - Set others' ability to open chests or storage items (single, double, ender, hopper, dropper, minecart chest, brewing stand).

• AdminDrop.other.block.break - Set others' own restriction to breaking blocks

• AdminDrop.other.block.place - Set others' own restriction to placing blocks



##### Overrides


• AdminDrop.alwayson.deathdrop - Makes toggle for drops on death always on

• AdminDrop.alwayson.throwaway - Makes throwing away toggle always on

• AdminDrop.alwayson.pickup - Makes picking up of items toggle always on

• AdminDrop.alwayson.chestaccess - Makes chest access toggle always on

• AdminDrop.alwayson.block.break - Makes block breaking toggle always on

• AdminDrop.alwayson/block.place - Makes block placing toggle always on



##### Override Ignore Star
If you use the '*' permission on a user/group that you wish to have something like AdminDrop.alwayson.pickup you will need to use - -AdminDrop.ignore.star.pickup on the line before the '*' permission to enable it on that a user/group.

• AdminDrop.ignore.star.deathdrop - Makes toggle for drops on death always on for ‘*’ users

• AdminDrop.ignore.star.throwaway - Makes throwing away toggle always on for ‘*’ users

• AdminDrop.ignore.star.pickup - Makes picking up of items toggle always on for ‘*’ users

• AdminDrop.ignore.star.chestaccess - Makes chest access toggle always on for ‘*’ users

• AdminDrop.ignore.star.block.break - Makes block breaking toggle always on for ‘*’ users

• AdminDrop.ignore.star.block.place - Makes block placing toggle always on for ‘*’ users



##### Restricted

• AdminDrop.restricted.reload – Allows user to reload config files if changes are made to the files while server is running

#### Commands:

• /ad deathdrop - Toggles Death Drops [ON/OFF]

• /ad deathdrop [player/online/all] - Toggles other's Death Drops on/off

• /ad deathdrop [player/online/all] [ON/OFF] - Toggles other's Death Drops on/off

• /ad throwaway - Toggles the ability to throw away items on/off

• /ad throwaway [player/online/all] - Toggles other's throw away items on/off

• /ad throwaway [player/online/all] [ON/OFF] - Toggles other's throw away items on/off

• /ad pickup - Toggles the ability to pick up items on/off

• /ad pickup [player/online/all] - Toggles other's ability to pick up items on/off

• /ad pickup [player/online/all] [ON/OFF] - Toggles other's ability to pick up items on/off

• /ad chestaccess - Toggles the ability to open chests on/off

• /ad chestaccess [player/online/all] - Toggles other's ability to open chests on/off

• /ad chestaccess [player/online/all] [ON/OFF] - Toggles other's ability to open chests on/off

• /ad blockbreak - Toggles the restriction to break blocks on/off

• /ad blockbreak [player/online/all] - Toggles other's restriction to break blocks on/off

• /ad blockbreak [player/online/all] [ON/OFF] - Toggles other's restriction to break blocks on/off

• /ad blockplace - Toggles the restriction to place blocks on/off

• /ad blockplace [player/online/all/all] - Toggles other's restriction to place blocks on/off

• /ad blockplace [player/online/all] [ON/OFF] - Toggles other's restriction to place blocks on/off

• /ad reload – Reloads config files

• /ad status - Gets current status

• /ad status [player] - Gets players current status

• /ad help - Displays commands

• /ad alt - Shows alternate commands



#### Alternate Commands:



• /ad dd - Toggles Death Drops on/off

• /ad dd [player/online/all] - Toggles other's Death Drops on/off

• /ad dd [player/online/all] [ON/OFF] - Toggles other's Death Drops on/off

• /ad ta - Toggles the ability to throw away items on/off

• /ad ta [player/online/all] - Toggles other's throw away items on/off

• /ad ta [player/online/all] [ON/OFF] - Toggles other's throw away items on/off

• /ad pu - Toggles the ability to pick up items on/off

• /ad pu [player/online/all] - Toggles other's ability to pick up items on/off

• /ad pu [player/online/all] [ON/OFF] - Toggles other's ability to pick up items on/off

• /ad ca - Toggles the ability to open chests on/off

• /ad ca [player/online/all] - Toggles other's ability to open chests on/off

• /ad ca [player/online/all] [ON/OFF] - Toggles other's ability to open chests on/off

• /ad bb - Toggles the restriction to break blocks on/off

• /ad bb [player/online/all] - Toggles other's restriction to break blocks on/off

• /ad bb [player/online/all] [ON/OFF] - Toggles other's restriction to break blocks on/off

• /ad bp - Toggles the restriction to place blocks on/off

• /ad bp [player/online/all] - Toggles other's restriction to place blocks on/off

• /ad bp [player/online/all] [ON/OFF] - Toggles other's restriction to place blocks on/off

• /ad reload – Reloads config files

• /ad status - Gets current status

• /ad status [player] - Gets players current status

• /ad help - Displays commands

• /ad ac - Shows alternate commands



#### Notes:


• Remember, always delete your old config or make the appropriate changes when updating to a newer version as things may have changed.

• Items do not stay in inventory on death if drops are toggled to not drop, they just simply do not drop them.



##### This plugin was authored by pyropyro78.
