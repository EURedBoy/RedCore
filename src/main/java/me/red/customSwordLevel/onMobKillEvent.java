package me.red.customSwordLevel;

import me.red.redcore;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class onMobKillEvent implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void onMobKill(EntityDeathEvent e){
        if (e.getEntity().getKiller() instanceof Player) {
            Player p = e.getEntity().getKiller();
            ItemStack is = p.getItemInHand();
            ItemMeta im = is.getItemMeta();
            if (im.hasLore()){
                List<String> lore = im.hasLore() ? im.getLore() : new ArrayList<String>();
                PersistentDataContainer data = im.getPersistentDataContainer();
                for (int i = 0; i < lore.size(); i++){
                    if (lore.get(i).contains("§dMob Uccisi:")) {
                        if (data.has(new NamespacedKey(plugin,"mob-kill"),PersistentDataType.INTEGER)){
                            Integer mobkill = data.get(new NamespacedKey(plugin, "mob-kill"), PersistentDataType.INTEGER);
                            lore.set(lore.size()-1, "§dMob Uccisi: §b" + (mobkill+1));
                            data.set(new NamespacedKey(plugin, "mob-kill"), PersistentDataType.INTEGER,mobkill+1);
                            if (mobkill+1 == 100){
                                onLevelUP.LevelUP(p,mobkill+1);
                            }else if(mobkill+1 == 200){
                                onLevelUP.LevelUP(p,mobkill+1);
                            }else if(mobkill+1 == 300){
                                onLevelUP.LevelUP(p,mobkill+1);
                            }
                        }else{
                            lore.set(lore.size()-1, "§dMob Uccisi: §b1");
                            data.set(new NamespacedKey(plugin,"mob-kill"),PersistentDataType.INTEGER, 1);
                        }
                        im.setLore(lore);
                        is.setItemMeta(im);
                    }
                }
            }
        }
    }
}
