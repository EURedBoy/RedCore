package me.red.utils;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class jailUtils {
    static redcore plugin = redcore.getPlugin(redcore.class);
    static HashMap<UUID,Integer> playersTimers = new HashMap<>();
    static HashMap<UUID,Integer> playersTasks = new HashMap<>();

    public static void setJail(Player p){
        try {
            plugin.getConfig().set("jail.x", p.getLocation().getX());
            plugin.getConfig().set("jail.y", p.getLocation().getY());
            plugin.getConfig().set("jail.z", p.getLocation().getZ());
            plugin.getConfig().set("jail.world", p.getLocation().getWorld().getName());
        }catch (Exception e){
            return;
        }
    }

    public static Location getJail(){
        try {
            double x = plugin.getConfig().getDouble("jail.x");
            double y = plugin.getConfig().getDouble("jail.y");
            double z = plugin.getConfig().getDouble("jail.z");
            String world = plugin.getConfig().getString("jail.world");
            Location jailLoc = new Location(Bukkit.getWorld(world), x, y, z);
            return jailLoc;
        }catch (Exception e){
            return null;
        }
    }

    public static void jailTimer(UUID uuid, int timer) {
        playersTimers.put(uuid,timer);
        int taskID = plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
            for (UUID player : playersTimers.keySet()){
                int delay = playersTimers.get(player);
                if (delay > 0){
                    playersTimers.put(player,delay-1);
                }else{
                    int playersTaskID = playersTasks.get(player);
                    playersTimers.remove(player);
                    Bukkit.getScheduler().cancelTask(playersTaskID);
                }
            }
        }, 0L, 20L).getTaskId();
        playersTasks.put(uuid,taskID);
    }

    public static int getTimer(UUID uuid){
        return playersTimers.get(uuid);
    }
}
