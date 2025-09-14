package me.matt5262.spawnPlugin.commands;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;
    public SetSpawnCommand(SpawnPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;

            String invalidNumbersMsg = plugin.getConfig().getString("invalid-numbers-message");
            String spawnUpdatedMsg = plugin.getConfig().getString("spawn-updated-message");

            Location location = player.getLocation();

            if (strings.length == 0){ //Set spawn to player location
                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();
                Location spawnConfig = plugin.getConfig().getLocation("spawn");

                if (spawnConfig != null){
                    int xInt = (int) spawnConfig.getX();
                    int yInt = (int) spawnConfig.getY();
                    int zInt = (int) spawnConfig.getZ();
                    if (spawnUpdatedMsg != null) {
                        spawnUpdatedMsg = spawnUpdatedMsg.replace("%new-spawn-cords%", xInt + " " + yInt + " " + zInt);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', spawnUpdatedMsg));
                    }
                }
            } else if (strings.length == 3) { //Custom Set spawn with custom cords
                try {
                    double x = Double.parseDouble(strings[0]);
                    double y = Double.parseDouble(strings[1]);
                    double z = Double.parseDouble(strings[2]);

                    Location locationFromArgs = new Location(player.getWorld(), x, y, z);

                    plugin.getConfig().set("spawn", locationFromArgs);
                    plugin.saveConfig();

                    int xInt = (int) locationFromArgs.getX();
                    int yInt = (int) locationFromArgs.getY();
                    int zInt = (int) locationFromArgs.getZ();
                    if (spawnUpdatedMsg != null) {
                        spawnUpdatedMsg = spawnUpdatedMsg.replace("%new-spawn-cords%", xInt + " " + yInt + " " + zInt);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', spawnUpdatedMsg));
                    }
                } catch (NumberFormatException e) {
                    if (invalidNumbersMsg != null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', invalidNumbersMsg));
                    }
                }
            }else{
                if (invalidNumbersMsg != null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', invalidNumbersMsg));
                }
            }
        }else{
            plugin.getLogger().warning("You must be a player to set spawn!");
        }
        return true;
    }
}
