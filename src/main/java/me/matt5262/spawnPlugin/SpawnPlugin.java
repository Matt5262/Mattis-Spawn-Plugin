package me.matt5262.spawnPlugin;

import me.matt5262.spawnPlugin.commands.*;
import me.matt5262.spawnPlugin.listeners.SpawnListeners;
import me.matt5262.spawnPlugin.tabcompleter.SpawnPluginCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("spawnplugin").setExecutor(new SpawnPluginArgumentCommands(this));
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
        getCommand("spawnplugin").setTabCompleter(new SpawnPluginCompleter());


        //test
        getCommand("repeat").setExecutor(new RepeatCommand());
        //test


        getLogger().info("SpawnPlugin by MATTI (Matt_5262) has started!");

        if (getConfig().getBoolean("sigma-startup-message")){
            getLogger().info("He is very sigma btw!!!");
        }

    }
}
