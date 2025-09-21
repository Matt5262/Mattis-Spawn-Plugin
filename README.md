# 📖 What is this plugin?
This is a highly configurable spawn plugin that allowes you to set a spawn that you can tp to with the simple command: **/spawn**
# ✅ Features
1. Set spawn at player position
2. Set spawn at specific cordinates
2. Go to spawn
3. Set the join method, tp at first spawn? etc
4. Set the respawn method, respawn at bed? etc
5. Reset spawn
# 🤖 Commands
- **setspawn** (The set spawn command)
- **spawn** (The command to go to spawn)
- **spawnplugin** (To access the help and resetspawn command)
# 🚨 Permissions
- **spawnplugin.spawnplugin**
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
https://modrinth.com/plugin/mattisspawnplugin
## Thank you for using my plugin!
