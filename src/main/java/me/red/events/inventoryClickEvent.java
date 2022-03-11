package me.red.events;

import me.red.redcore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class inventoryClickEvent implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void inventoryClick(InventoryClickEvent e){
        if (e.getView().getTitle().equals(Objects.requireNonNull(plugin.getConfig().getString("displayitem-gui")).replaceAll("&","§")))
            e.setCancelled(true);
    }
}
