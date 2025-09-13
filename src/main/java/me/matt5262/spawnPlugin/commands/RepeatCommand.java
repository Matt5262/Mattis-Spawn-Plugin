package me.matt5262.spawnPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {

    // /repeat bob is really cool

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            if (strings.length == 0){
                player.sendMessage(ChatColor.RED + "You did not provide anything to repeat!\nPlease try again with /repeat <text>");
            }else{
                StringBuilder builder = new StringBuilder();
                for(int i = 0; i < strings.length; i++){
                    builder.append(strings[i]);
                    builder.append(" ");
                }
                String finalMessage = builder.toString();
                finalMessage = finalMessage.stripTrailing();

                player.sendMessage(finalMessage);
            }

        }

        return true;
    }
}
