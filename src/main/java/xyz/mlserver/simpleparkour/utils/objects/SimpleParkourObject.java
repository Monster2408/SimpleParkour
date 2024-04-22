package xyz.mlserver.simpleparkour.utils.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import xyz.mlserver.simpleparkour.utils.bukkit.LocationParser;

public class SimpleParkourObject {

    private final Integer id;
    private String name;
    private String creator;
    private String startLocation;
    private String endLocation;

    public SimpleParkourObject(Integer id, String name, Player player) {
        this(id, name, player.getName());
    }

    public SimpleParkourObject(Integer id, String name, String creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.startLocation = null;
        this.endLocation = null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public Location getStartLocation() {
        if (startLocation == null) return null;
        return LocationParser.parseLocation(startLocation);
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = LocationParser.parseJson(startLocation);
    }

    public Location getEndLocation() {
        if (endLocation == null) return null;
        return LocationParser.parseLocation(endLocation);
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = LocationParser.parseJson(endLocation);
    }
}
