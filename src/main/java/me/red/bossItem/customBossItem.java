package me.red.bossItem;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class customBossItem {
    redcore plugin = redcore.getPlugin(redcore.class);
    public void BossEffect(){
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()){
                if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getItemMeta() != null){
                    if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§8| §c§lTesta di Cerbero §8|"))
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,100,1,false,false,false));
                }
            }
        }, 1L, 45L);

    }
}
