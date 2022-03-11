package me.red.events;

import me.red.redcore;
import me.red.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.HashMap;

public class backEvent implements Listener {
    public static HashMap<Player, Location> back = new HashMap<>();
    redcore plugin = redcore.getPlugin(redcore.class);
    private int i = 0;
    @EventHandler
    public void back(PlayerTeleportEvent e){
        if (e.getFrom().getWorld().getName().equals("parkour"))
            User.resetCheckPoint(e.getPlayer());
        if (i == 0){
            back.put(e.getPlayer(),e.getFrom());
            i++;
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                i = 0;
            }, 20L);
        }
    }
}
