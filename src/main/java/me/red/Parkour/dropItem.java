package me.red.Parkour;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class dropItem implements Listener {
    @EventHandler
    public void DropItem(PlayerDropItemEvent e){
        if (e.getPlayer().getWorld().getName().equals("parkour") && !(e.getPlayer().hasPermission("redcore.parkour-drop-item"))){
            e.setCancelled(true);
        }
    }
}
