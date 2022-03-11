package me.red.utils;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Set;


public class User {
    private static Location loc;
    private static redcore plugin = redcore.getPlugin(redcore.class);
    private static configmanager cfm = new configmanager();
    private static HashMap<Player,Location> checkpoint = new HashMap<>();

    public static void setSpawn() {
        try {
            double x = plugin.getConfig().getDouble("spawn.x");
            double y = plugin.getConfig().getDouble("spawn.y");
            double z = plugin.getConfig().getDouble("spawn.z");
            double yaw = plugin.getConfig().getDouble("spawn.yaw");
            double pitch = plugin.getConfig().getDouble("spawn.pitch");
            String world = plugin.getConfig().getString("spawn.world");
            loc = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);
        } catch (Exception e) {
            Bukkit.getServer().getConsoleSender().sendMessage("No spawn founded");
        }
    }

    public static Location getSpawn() {
        return loc;
    }

    public static void setHome(Location loc, Player p, String[] args) {
        cfm.setup();
        String homeset = "Homes." + p.getUniqueId().toString() + ".home." + args[0].toLowerCase();
        cfm.getPlayers().set(homeset, p.getLocation().getWorld().getName() + ";" + p.getLocation().getX() + ";" + p.getLocation().getY() + ";" + p.getLocation().getZ());
        cfm.savePlayers();
    }

    public static Location getHome(String home, Player p) {
        cfm.setup();
        String homeset = "Homes." + p.getUniqueId().toString() + ".home." + home.toLowerCase();
        String[] split = cfm.getPlayers().getString(homeset).split(";");
        Location loc;
        loc = new Location(Bukkit.getWorld(split[0]), Double.valueOf(split[1]), Double.valueOf(split[2]), Double.valueOf(split[3]));
        return loc;
    }

    public static int getHomeAmount(Player p) {
        cfm.setup();
        Set<String> keys;
        try{
            keys = cfm.getPlayers().getConfigurationSection("Homes." + p.getUniqueId().toString() + ".home").getKeys(false);
        }catch (Exception e){
            cfm.getPlayers().set("Homes." + p.getUniqueId().toString() + ".home.",null);
            cfm.savePlayers();
            return 0;
        }
        return keys.size();
    }

    public static int getHomePermissionAmount(Player p) {
        for (int i = 100; i > 0; --i) {
            if (p.hasPermission("redcore.home." + i)){
                return i;
            }
        }
            return 0;
    }

    public static void setCheckPoint(Player p){
        checkpoint.put(p,p.getLocation());
    }

    public static Location getCheckPoint(Player p){
            return checkpoint.get(p);
    }

    public static void resetCheckPoint(Player p){
        checkpoint.remove(p);
    }

    public static void setWarp (Location loc, Player p, String[]args){
            cfm.setup();
            String warpset = "Warps." + args[0];
            cfm.getWarpsFile().set(warpset, p.getLocation().getWorld().getName() + ";" + p.getLocation().getX() + ";" + p.getLocation().getY() + ";" + p.getLocation().getZ() + ";" + p.getLocation().getYaw() + ";" + p.getLocation().getPitch());
            cfm.saveWarpsFile();
    }

    public static Location getWarp (String warp){
            cfm.setup();
            String warpset = "Warps." + warp;
            String[] split = cfm.getWarpsFile().getString(warpset).split(";");
            Location loc = new Location(Bukkit.getWorld(split[0]), Double.valueOf(split[1]), Double.valueOf(split[2]), Double.valueOf(split[3]), Float.valueOf(split[4]), Float.valueOf(split[5]));
            return loc;
    }
}