package me.red.Parkour;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class parkourJoinWorld implements Listener {
    @EventHandler
    public void joinWorld(PlayerChangedWorldEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals("parkour")){
            Inventory inv = p.getInventory();
            inv.setItem(4,CheckPointItem());
        }
    }

    public static ItemStack CheckPointItem(){
        ItemStack item = new ItemStack(Material.DARK_OAK_DOOR);
        ItemMeta itemM = item.getItemMeta();
        itemM.setDisplayName("§aRitorna §7al §6CheckPoint");
        item.setItemMeta(itemM);
        return item;
    }
}
