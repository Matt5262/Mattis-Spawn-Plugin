package me.matt5262.spawnPlugin;

import me.matt5262.spawnPlugin.commands.*;
import me.matt5262.spawnPlugin.holders.MainMenuHolder;
import me.matt5262.spawnPlugin.listeners.MainMenuListener;
import me.matt5262.spawnPlugin.listeners.SpawnListeners;
import me.matt5262.spawnPlugin.tabcompleter.SpawnPluginCompleter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("msp").setExecutor(new SpawnPluginArgumentCommands(this));
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
        getCommand("msp").setTabCompleter(new SpawnPluginCompleter());
        getServer().getPluginManager().registerEvents(new MainMenuListener(this), this);

        getLogger().info("SpawnPlugin by MATTI (Matt_5262) has started!");

        if (getConfig().getBoolean("sigma-startup-message")){
            getLogger().info("He is very sigma btw!!!");
        }

    }

    public void openMainMenu(Player player) {
        ItemStack resetspawnitem = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta meta = (ItemMeta) resetspawnitem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("Reset Spawn");
            meta.setLore(List.of("Press me to reset the spawn to the original world spawn."));
            resetspawnitem.setItemMeta(meta);
        }
        Inventory mainMenu = Bukkit.createInventory(new MainMenuHolder(), 27, "Main Menu");
        mainMenu.setItem(9, resetspawnitem);
        player.openInventory(mainMenu);
    }   // When openMainMenu is called then make a menu and then open it


}
