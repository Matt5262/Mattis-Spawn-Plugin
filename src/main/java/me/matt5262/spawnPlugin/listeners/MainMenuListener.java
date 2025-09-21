package me.matt5262.spawnPlugin.listeners;

import me.matt5262.spawnPlugin.SpawnPlugin;
import me.matt5262.spawnPlugin.holders.MainMenuHolder;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MainMenuListener implements Listener {

    private final SpawnPlugin plugin;

    public MainMenuListener(SpawnPlugin plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void onInventoryPress(InventoryClickEvent event){

        if (event.getWhoClicked() instanceof Player player) {
            // If the person who clicked is a player then continue script and also assign the person to a variable called player

            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }// makes sure you click on something and not an empty slot in the menu or else it would send errors

            if (event.getInventory().getHolder() instanceof MainMenuHolder) {
                // if the owner of the menu is MainMenuHolder then...

                event.setCancelled(true);
                // Cancels the item move

                if (event.isRightClick()) return;
                // If right click then stop script (it will run again on new click)

                if (event.getClickedInventory() == null
                        || !(event.getClickedInventory().getHolder() instanceof MainMenuHolder)) {
                    return;
                }

                if (event.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                    Location worldspawn = player.getWorld().getSpawnLocation();
                    plugin.getConfig().set("spawn", worldspawn);
                    plugin.saveConfig();
                    int xInt = (int) worldspawn.getX();
                    int yInt = (int) worldspawn.getY();
                    int zInt = (int) worldspawn.getZ();
                    player.sendMessage(ChatColor.GREEN + "Reset spawn to original world spawn! (" + xInt + " " + yInt + " " + zInt + ")");
                    player.closeInventory();
                }

            }
        }


    }


}
