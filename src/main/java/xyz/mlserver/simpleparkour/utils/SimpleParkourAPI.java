package xyz.mlserver.simpleparkour.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.mlserver.simpleparkour.utils.objects.SimpleParkourObject;

import java.util.HashMap;
import java.util.UUID;

public class SimpleParkourAPI {

    private static ItemStack mainTool;

    private static ItemStack exitItem;

    private static ItemStack startItem;

    public static ItemStack getMainTool() {
        if (mainTool == null) {
            mainTool = new ItemStack(Material.GOLD_AXE);
            ItemMeta meta = mainTool.getItemMeta();
            meta.setDisplayName("§6§lSimpleParkour Tool");
            mainTool.setItemMeta(meta);
        }
        return mainTool;
    }

    public static ItemStack getExitItem() {
        if (exitItem == null) {
            exitItem = new ItemStack(Material.REDSTONE);
            ItemMeta meta = exitItem.getItemMeta();
            meta.setDisplayName("§c§lExit");
            exitItem.setItemMeta(meta);
        }
        return exitItem;
    }

    public static ItemStack getStartItem() {
        if (startItem == null) {
            startItem = new ItemStack(Material.EMERALD);
            ItemMeta meta = startItem.getItemMeta();
            meta.setDisplayName("§a§lStart");
            startItem.setItemMeta(meta);
        }
        return startItem;
    }

    private static HashMap<Integer, SimpleParkourObject> parkourObjects;

    public static HashMap<Integer, SimpleParkourObject> getParkourObjects() {
        if (parkourObjects == null) parkourObjects = new HashMap<>();
        return parkourObjects;
    }

    private static HashMap<UUID, SimpleParkourObject> playerEditParkour;

    public static HashMap<UUID, SimpleParkourObject> getPlayerEditParkour() {
        if (playerEditParkour == null) playerEditParkour = new HashMap<>();
        return playerEditParkour;
    }

    public static SimpleParkourObject newParkourObject(String name, Player player) {
        return newParkourObject(name, player.getName());
    }

    public static SimpleParkourObject newParkourObject(String name, String creator) {
        int id = 0;
        while (parkourObjects.containsKey(id)) id++;
        SimpleParkourObject object = new SimpleParkourObject(id, name, creator);
        parkourObjects.put(id, object);
        return object;
    }


}
