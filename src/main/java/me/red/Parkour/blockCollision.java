package me.red.Parkour;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class blockCollision implements Listener {
    @EventHandler
    public void collision (VehicleEntityCollisionEvent e){
        if (!(e.getEntity() instanceof Player)) return;
        if (e.getEntity().getWorld().getName().equals("parkour")){
            e.setCancelled(true);
        }
    }
}
