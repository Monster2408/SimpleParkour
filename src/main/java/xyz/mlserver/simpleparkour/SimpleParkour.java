package xyz.mlserver.simpleparkour;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.simpleparkour.commands.SimpleParkourCmd;

public final class SimpleParkour extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("simpleparkour").setExecutor(new SimpleParkourCmd());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
