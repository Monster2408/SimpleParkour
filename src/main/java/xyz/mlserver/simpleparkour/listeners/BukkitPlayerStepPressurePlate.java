package xyz.mlserver.simpleparkour.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BukkitPlayerStepPressurePlate implements Listener {

    @EventHandler
    public void on(PlayerInteractEvent e) {
        if (e.getAction() != Action.PHYSICAL) return;
        if (e.getClickedBlock() == null) return;
        if (e.getClickedBlock().getType() != Material.IRON_PLATE && e.getClickedBlock().getType() != Material.GOLD_PLATE) return;

        // ここにコードを書く
    }

}
