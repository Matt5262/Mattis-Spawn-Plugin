package me.matt5262.spawnPlugin.utils;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpawnPluginUtil {

    public static void resetWorldMethod(Player player, SpawnPlugin plugin) {
        Location worldspawn = player.getWorld().getSpawnLocation();
        plugin.getConfig().set("spawn", worldspawn);
        plugin.saveConfig();
        int xInt = (int) worldspawn.getX();
        int yInt = (int) worldspawn.getY();
        int zInt = (int) worldspawn.getZ();
        player.sendMessage(ChatColor.GREEN + "Reset spawn to original world spawn! (" + xInt + " " + yInt + " " + zInt + ")");
    }

    public static void setSpawnMethod(Player player, SpawnPlugin plugin, String[] strings) {
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
    }
}

