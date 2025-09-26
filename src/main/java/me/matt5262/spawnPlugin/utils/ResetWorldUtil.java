package me.matt5262.spawnPlugin.utils;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ResetWorldUtil {

    public static void resetWorldMethod(Player player, SpawnPlugin plugin) {
        Location worldspawn = player.getWorld().getSpawnLocation();
        plugin.getConfig().set("spawn", worldspawn);
        plugin.saveConfig();
        int xInt = (int) worldspawn.getX();
        int yInt = (int) worldspawn.getY();
        int zInt = (int) worldspawn.getZ();
        player.sendMessage(ChatColor.GREEN + "Reset spawn to original world spawn! (" + xInt + " " + yInt + " " + zInt + ")");
    }
}

