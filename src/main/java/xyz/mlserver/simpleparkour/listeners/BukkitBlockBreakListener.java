package xyz.mlserver.simpleparkour.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import xyz.mlserver.simpleparkour.utils.SimpleParkourAPI;

public class BukkitBlockBreakListener implements Listener {

    @EventHandler
    public void on(BlockBreakEvent e) {
        if (e.getPlayer() == null) return;
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand() == null) return;
        if (e.getBlock() == null) return;
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        if (!mainHand.isSimilar(SimpleParkourAPI.getMainTool())) return;
        e.setCancelled(true);
        SimpleParkourAPI.getPlayerEditLocation().put(player.getUniqueId(), e.getBlock().getLocation().clone());
    }

}
