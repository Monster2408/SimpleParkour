package xyz.mlserver.simpleparkour.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.mlserver.simpleparkour.utils.SimpleParkourAPI;
import xyz.mlserver.simpleparkour.utils.objects.SimpleParkourObject;

import java.util.UUID;

public class SimpleParkourCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage("§6§lSimpleParkour §7- §fVersion: 1.0");
            sender.sendMessage("§7Commands:");
            sender.sendMessage("§7- §f/simpleparkour create <name>");
            sender.sendMessage("§7- §f/simpleparkour delete");
            sender.sendMessage("§7- §f/simpleparkour delete confirm");
            sender.sendMessage("§7- §f/simpleparkour setstart <name>");
            sender.sendMessage("§7- §f/simpleparkour setend <name>");
            sender.sendMessage("§7- §f/simpleparkour setlobby <name>");
        } else {
            SimpleParkourObject object = SimpleParkourAPI.getPlayerEditParkour().get(player.getUniqueId());
            if (object != null) {
                if (args.length == 1) {
                    UUID uuid = player.getUniqueId();
                    if (args[0].equalsIgnoreCase("delete")) {
                        // 確認メッセージ
                        sender.sendMessage("§c§l[SimpleParkour] §7- §fAre you sure you want to delete this parkour?");
                    } else if (args[0].equalsIgnoreCase("setstart")) {
                        if (SimpleParkourAPI.getPlayerEditLocation().containsKey(uuid)) {
                            Location location = SimpleParkourAPI.getPlayerEditLocation().get(uuid);
                            object.setStartLocation(location);
                            sender.sendMessage("§a§l[SimpleParkour] §7- §fStart location set.(X: " + location.getBlockX() + ", Y: " + location.getBlockY() + ", Z: " + location.getBlockZ() + ")");
                        } else {
                            sender.sendMessage("§c§l[SimpleParkour] §7- §fPlease select the location with the tool.");
                        }
                    } else if (args[0].equalsIgnoreCase("setend")) {
                        // Set end location
                    } else if (args[0].equalsIgnoreCase("setlobby")) {
                        // Set lobby location
                    }
                } else if (args.length == 2) {
                    String name = args[1];
                    if (args[0].equalsIgnoreCase("create")) {
                        object = SimpleParkourAPI.newParkourObject(name, sender.getName());
                        SimpleParkourAPI.getPlayerEditParkour().put(player.getUniqueId(), object);
                    } else if (args[0].equalsIgnoreCase("delete")) {
                        if (args[1].equalsIgnoreCase("confirm")) {
                            SimpleParkourAPI.getParkourObjects().remove(object.getId());
                        }
                    }
                }
            } else {
                if (args.length == 2) {
                    String name = args[1];
                    if (args[0].equalsIgnoreCase("create")) {
                        object = SimpleParkourAPI.newParkourObject(name, sender.getName());
                        SimpleParkourAPI.getPlayerEditParkour().put(player.getUniqueId(), object);
                    } else if (args[0].equalsIgnoreCase("delete")) {
                        if (args[1].equalsIgnoreCase("confirm")) {
                            // Delete parkour
                        }
                    }
                }
            }
        }
        return true;
    }
}
