package me.matt5262.spawnPlugin.commands;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            Location location = plugin.getConfig().getLocation("spawn");

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
        }


        return true;
    }
}
