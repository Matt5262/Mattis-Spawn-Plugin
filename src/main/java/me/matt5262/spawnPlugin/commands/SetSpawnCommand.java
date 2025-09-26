package me.matt5262.spawnPlugin.commands;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.matt5262.spawnPlugin.utils.SpawnPluginUtil.setSpawnMethod;

public class SetSpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;
    public SetSpawnCommand(SpawnPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;

            setSpawnMethod(player, plugin, strings);
            player.closeInventory();

        }else{
            plugin.getLogger().warning("You must be a player to set spawn!");
        }
        return true;
    }
}
