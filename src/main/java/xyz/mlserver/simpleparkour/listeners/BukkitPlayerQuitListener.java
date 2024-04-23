package xyz.mlserver.simpleparkour.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.mlserver.simpleparkour.utils.SimpleParkourAPI;

public class BukkitPlayerQuitListener implements Listener {

    @EventHandler
    public void on(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        SimpleParkourAPI.getPlayerEditLocation().remove(player.getUniqueId());
    }

}
