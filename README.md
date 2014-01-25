This revision of this page is for v0.3.0.2

The goal of this plugin is to handle all item actions (Dropping, Throwing, Picking Up, etc.).

Permissions:

THEY CHANGED IN THIS UPDATE!

(Should be last major rework of these as this should be more future proof and less confusing for people).
Self

    AdminDrop.self.status - Check one's own status of toggles.
    AdminDrop.self.deathdrop - Set one's own drops on death toggle.
    AdminDrop.self.throwaway - Set ones's own throwing away toggle.
    AdminDrop.self.pickup - Set one's own picking up of items toggle. 

Other

    AdminDrop.other.list - List all users with toggles on.
    AdminDrop.other.status - Check status of other's toggles.
    AdminDrop.other.deathdrop - Modify other user's drops on death toggle.
    AdminDrop.other.throwaway - Set other's throwing away toggle.
    AdminDrop.other.pickup - Modify other user's drops on death toggle. 

Overrides

    AdminDrop.alwayson.deathdrop - Makes toggle for drops on death always on.
    AdminDrop.alwayson.throwaway - Makes throwing away toggle always on.
    AdminDrop.alwayson.pickup - Makes picking up of items toggle always on. 

Override Ignore Star

If you use the * permission on a user/group that you wish to have something like AdminDrop.alwayson.pickup you will need to use - -AdminDrop.ignore.star.pickup before the * permission to enable it on that a user/group.

    AdminDrop.ignore.star.deathdrop - Makes toggle for drops on death always on.
    AdminDrop.ignore.star.throwaway - Makes throwing away toggle always on.
    AdminDrop.ignore.star.pickup - Makes picking up of items toggle always on. 

Commands:

    /admindrop deathdrop - Toggles Death Drops on/off
    /admindrop deathdrop [player] - Toggles other's Death Drops on/off
    /admindrop list - Lists users with Toggle on
    /admindrop throwaway - Toggles the ability to throw away items on/off
    /admindrop throwaway [player] - Toggles other's throw away items on/off
    /admindrop pickup - Toggles the ability to pick up items on/off
    /admindrop pickup [player] - Toggles other's ability to pick up items on/off
    /admindrop chestaccess - Toggles the ability to open chests on/off
    /admindrop chestaccess [player] - Toggles other's ability to open chests on/off
    /admindrop status - Gets current status
    /admindrop status [player] - Gets players current status
    /admindrop help - Displays commands
    /admindrop altcommands - Shows alternate commands 

Alternate Commands:

    /ad dd - Toggles Death Drops on/off
    /ad dd [player] - Toggles other's Death Drops on/off
    /ad list - Lists users with Toggle on
    /ad ta - Toggles the ability to throw away items on/off
    /ad ta [player] - Toggles other's throw away items on/off
    /ad pu - Toggles the ability to pick up items on/off
    /ad pu [player] - Toggles other's ability to pick up items on/off
    /ad ca - Toggles the ability to open chests on/off
    /ad ca [player] - Toggles other's ability to open chests on/off
    /ad status - Gets current status
    /ad status [player] - Gets players current status
    /ad help - Displays commands
    /ad ac - Shows alternate commands 

Features:

    Stops the dropping of items on death for self or target player.
    Stops the ability to throw items for self or target player.
    Stops the ability of picking up items for self or target player.
    Stops the ability of opening chests for self or target player.
    Lists players with toggles enabled.
    Checks personal status of toggles and that of other players. 

Notes:

    Items currently do not stay in inventory on death if drops are toggled to not drop, they just simply does not drop them. This is a proposed future feature. 

    Users that have anything anabled on them will have it disabled when they logg off, the server restarts, or the plugins are reloaded unless they have the override permission (can be given to regions as well where needed). 

    Chests and Double Chests are the only items currently tied into chest access. 

This plugin was Authored by pyropyro78.

Formally Co-Authored with the help of NitroNumberOne.
