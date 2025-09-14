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

            String timerMessage = plugin.getConfig().getString("timer-message");
            long timer = plugin.getConfig().getLong("timer")*1000;
            Location location = plugin.getConfig().getLocation("spawn");

            if (!cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) > timer) {
                cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                if (location != null){
                    player.teleport(location);
                    player.sendMessage(ChatColor.GREEN + "Teleported to spawn!");
                }else{
                    if (player.hasPermission("spawnplugin.setspawn")){
                        player.sendMessage(ChatColor.RED + "There is no spawn set. Use /setspawn to set it!");
                    }else {
                        player.sendMessage(ChatColor.RED + "There is no spawn set.");
                    }
                }
            }else{
                long timeLeftMs = timer - (System.currentTimeMillis() - cooldown.get(player.getUniqueId()));
                long timeLeftSeconds = timeLeftMs / 1000;
                if (timerMessage != null) {
                    timerMessage = timerMessage.replace("%time-remaining%", String.valueOf(timeLeftSeconds));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', timerMessage));
                }

            }

        }


        return true;
    }
}
