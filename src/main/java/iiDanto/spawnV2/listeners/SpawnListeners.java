package iiDanto.spawnV2.listeners;

import iiDanto.spawnV2.SpawnV2;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.net.http.WebSocket;

public class SpawnListeners implements Listener {

    private final SpawnV2 plugin;

    public SpawnListeners(SpawnV2 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if (!e.getPlayer().hasPlayedBefore()){

            Player p = e.getPlayer();
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){
                p.teleport(location);
                p.sendActionBar(ChatColor.GREEN + "You have been teleported to spawn!");
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
            }else{
                p.sendActionBar(ChatColor.RED + "There is no spawn point set!");
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Location location = plugin.getConfig().getLocation("spawn");
        Player p = e.getPlayer();
        if (location != null) {
            e.setRespawnLocation(location);

        }else{
            p.sendActionBar("There is no spawn point set.");
            p.playSound(p.getLocation(),Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
        }
    }
}
