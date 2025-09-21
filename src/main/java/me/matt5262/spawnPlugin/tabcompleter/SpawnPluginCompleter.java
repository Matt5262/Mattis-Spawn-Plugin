package me.matt5262.spawnPlugin.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class SpawnPluginCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> suggestions = new ArrayList<>();

        if (strings.length == 1){
            suggestions.add("resetspawn");
            suggestions.add("help");
            suggestions.add("menu");
        }

        return suggestions;
    }
}
