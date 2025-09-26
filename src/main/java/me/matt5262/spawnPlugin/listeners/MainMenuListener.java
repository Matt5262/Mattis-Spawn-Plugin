package me.matt5262.spawnPlugin.listeners;

import me.matt5262.spawnPlugin.SpawnPlugin;
import me.matt5262.spawnPlugin.holders.MainMenuHolder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static me.matt5262.spawnPlugin.utils.ResetWorldUtil.resetWorldMethod;

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

                if (event.getClickedInventory() != event.getInventory()) {
                    return;
                }


                if (event.getSlot() == 9) {
                    resetWorldMethod(player, plugin);
                    player.closeInventory();
                }

            }
        }


    }


}
