package me.matt5262.spawnPlugin.commands;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnPluginArgumentCommands implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SpawnPluginArgumentCommands(SpawnPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (strings.length > 0 && strings[0].equalsIgnoreCase("resetspawn")){
                Location worldspawn = player.getWorld().getSpawnLocation();
                plugin.getConfig().set("spawn", worldspawn);
                plugin.saveConfig();
                int xInt = (int) worldspawn.getX();
                int yInt = (int) worldspawn.getY();
                int zInt = (int) worldspawn.getZ();
                player.sendMessage(ChatColor.GREEN + "Reset spawn to original world spawn! (" + xInt + " " + yInt + " " + zInt + ")");
            }else if (strings.length > 0 && strings[0].equalsIgnoreCase("help")){
                player.sendMessage(ChatColor.YELLOW + "It really isn't that hard..\nHere are the commands, you should be able to figure out what they do:\n- /msp\n- /spawn\n- /spawnplugin");
            }else if (strings.length > 0 && strings[0].equalsIgnoreCase("menu")) {
                plugin.openMainMenu(player);
            }else{
                player.sendMessage(ChatColor.RED + "Invalid use!");
            }
        }else {
            plugin.getLogger().warning("You must be a player to run this command!");
        }



        return true;
    }
}
