package me.matt5262.spawnPlugin;

import me.matt5262.spawnPlugin.commands.*;
import me.matt5262.spawnPlugin.holders.MainMenuHolder;
import me.matt5262.spawnPlugin.listeners.MainMenuListener;
import me.matt5262.spawnPlugin.listeners.SpawnListeners;
import me.matt5262.spawnPlugin.tabcompleter.SpawnPluginCompleter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("msp").setExecutor(new SpawnPluginArgCommands(this));
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
        getCommand("msp").setTabCompleter(new SpawnPluginCompleter());
        getServer().getPluginManager().registerEvents(new MainMenuListener(this), this);

        getLogger().info("SpawnPlugin by MATTI (Matt_5262) has started!");

        if (getConfig().getBoolean("sigma-startup-message")){
            getLogger().info("He is very sigma btw!!!");
        }

    }

    public void openMainMenu(Player player) {
        ItemStack resetSpawnItem = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta resetSpawnItemMeta = (ItemMeta) resetSpawnItem.getItemMeta();
        if (resetSpawnItemMeta != null) {
            resetSpawnItemMeta.setDisplayName(ChatColor.RESET + "Reset spawn location");
            resetSpawnItemMeta.setLore(List.of("Click me to reset the spawn to the original world spawn."));
            resetSpawnItem.setItemMeta(resetSpawnItemMeta);
        }

        ItemStack setSpawnItem = new ItemStack(Material.DIRT_PATH);
        ItemMeta setSpawnItemMeta = (ItemMeta) resetSpawnItem.getItemMeta();
        if (setSpawnItemMeta != null) {
            setSpawnItemMeta.setDisplayName(ChatColor.RESET + "Set spawn here");
            setSpawnItemMeta.setLore(List.of("Click me to set spawn to your location."));
            setSpawnItem.setItemMeta(setSpawnItemMeta);
        }

        Inventory mainMenu = Bukkit.createInventory(new MainMenuHolder(), 27, "MSP Quick Menu");
        mainMenu.setItem(9, resetSpawnItem);
        mainMenu.setItem(10, setSpawnItem);
        player.openInventory(mainMenu);
    }   // When openMainMenu is called then make a menu and then open it


}
