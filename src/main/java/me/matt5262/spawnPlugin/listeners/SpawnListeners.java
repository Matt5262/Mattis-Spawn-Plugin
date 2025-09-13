package me.matt5262.spawnPlugin.listeners;

import me.matt5262.spawnPlugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final SpawnPlugin plugin;

    public SpawnListeners(SpawnPlugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if (!event.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){
                player.teleport(location);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        Location location = plugin.getConfig().getLocation("spawn");
        if (!event.isBedSpawn()){
            if (location != null){
                event.setRespawnLocation(location);
            }
        }


    }

}
