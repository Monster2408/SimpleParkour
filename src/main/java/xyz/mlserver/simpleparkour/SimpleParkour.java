package xyz.mlserver.simpleparkour;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.simpleparkour.commands.SimpleParkourCmd;
import xyz.mlserver.simpleparkour.listeners.BukkitBlockBreakListener;
import xyz.mlserver.simpleparkour.listeners.BukkitPlayerQuitListener;
import xyz.mlserver.simpleparkour.listeners.BukkitRightClickListener;

public final class SimpleParkour extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("simpleparkour").setExecutor(new SimpleParkourCmd());

        getServer().getPluginManager().registerEvents(new BukkitBlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BukkitPlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new BukkitRightClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
