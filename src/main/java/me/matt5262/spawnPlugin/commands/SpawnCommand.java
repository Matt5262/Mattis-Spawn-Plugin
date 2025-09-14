package me.matt5262.spawnPlugin.commands;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class SpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    private final HashMap<UUID, Long> cooldown;

    public SpawnCommand(SpawnPlugin plugin) {
        this.cooldown = new HashMap<>();
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            String timerMsg = plugin.getConfig().getString("timer-message");
            String teleportSpawnMsg = plugin.getConfig().getString("teleported-spawn-message");
            String noSpawnMsgY = plugin.getConfig().getString("no-spawn-perm-message");
            String noSpawnMsgN = plugin.getConfig().getString("no-spawn-message");
            long timer = plugin.getConfig().getLong("timer")*1000;
            Location location = plugin.getConfig().getLocation("spawn");

            if (!cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) > timer) {
                if (location != null){
                    player.teleport(location);
                    if (teleportSpawnMsg != null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', teleportSpawnMsg));
                    }
                    cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                }else{
                    if (player.hasPermission("spawnplugin.setspawn")){
                        if (noSpawnMsgY != null) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', noSpawnMsgY));
                        }
                    }else {
                        if (noSpawnMsgN != null) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', noSpawnMsgN));
                        }
                    }
                }
            }else{
                long timeLeftMs = timer - (System.currentTimeMillis() - cooldown.get(player.getUniqueId()));
                long timeLeftSeconds = timeLeftMs / 1000;
                if (timerMsg != null) {
                    timerMsg = timerMsg.replace("%time-remaining%", String.valueOf(timeLeftSeconds));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', timerMsg));
                }

            }

        }


        return true;
    }
}
