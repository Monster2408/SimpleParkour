package xyz.mlserver.simpleparkour.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BukkitRightClickListener implements Listener {

    @EventHandler
    public void on(PlayerInteractEvent e) {
        if (e.getPlayer() == null) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;

    }

}
