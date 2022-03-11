package me.red.Parkour;

import me.red.utils.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class blockParkourMove implements Listener {
    @EventHandler
    public void ParkourMove(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) return;
        if (p.getWorld().getName().equals("parkour") && e.getCurrentItem().equals(parkourJoinWorld.CheckPointItem())){
            if (!(p.hasPermission("redcore.parkour-move-item"))){
                e.setCancelled(true);
            }
        }
    }
}
