# 📖 What is this plugin?
This is a highly configurable spawn plugin that allowes you to set a spawn that you can tp to with the simple command: _**/spawn**_.
# ✅ Features
- Set spawn at player position with **_/setspawn_**.
- Set spawn at specific cordinates with **_/setspawn x y z_**.
- Go to spawn with **_/spawn_**.
- Set the join method: tp on first join only, always tp to spawn. etc.
- Set the respawn method: respawn at bed? Respawn at spawnpoint? etc.
- Reset spawn with **_/msp resetspawn_**.
- Quickly use all of the above features with the new simple menu opened with **_/msp menu_**.
# 🤖 Commands
- **_setspawn_** (The set spawn command)
- **_spawn_** (The command to go to spawn)
- **_msp_** (To access commands like: **_help_**, **_menu_** and **_resetspawn_**)
# 🚨 Permissions
- **spawnplugin.msp**
- **spawnplugin.setspawn**
- **spawnplugin.spawn**
# 💾 Config

```
#Config:
#Set this to false if you do not like my wonderful startup message
sigma-startup-message: true
#Use a timer? Like 10 or 30 seconds before you can run /spawn again
timer: 30
#Message to display for the timer
timer-message: '&ePlease wait %time-remaining% seconds!'
#The message showed when you use /setspawn incorrectly
invalid-numbers-message: '&cInvalid numbers! Use: /setspawn <x> <y> <z>'
#The message showed when you update spawn
spawn-updated-message: '&aSpawn updated! (%new-spawn-cords%)'
#The message displayed when you succesfully teleported to spawn
teleported-spawn-message: '&aTeleported to spawn!'
#The message displayed when there is no spawn and the player can set it
no-spawn-perm-message: '&cThere is no spawn set. Use /setspawn to set it!'
#The message displayed when there is no spawn
no-spawn-message: '&cThere is no spawn set.'
#How do you want to handle players that join?
# 1 - Teleport to spawn on first join.
# 2 - Always teleport to spawn on join.
# 3 - Do not teleport to spawn on join at all.
teleport-join-method: 1
#Respawn method?
# 1 - Prioritize players bed.
# 2 - Always respawn at spawn and ignore bed.
# 3 - Do not respawn at spawn.
respawn_method: 1
```
