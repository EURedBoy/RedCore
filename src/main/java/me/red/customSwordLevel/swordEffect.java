package me.red.customSwordLevel;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class swordEffect {
    static redcore plugin = redcore.getPlugin(redcore.class);
    public static void EffectGive(){
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
                for (Player p : Bukkit.getOnlinePlayers()){
                    if (p.getItemInHand().hasItemMeta()){
                        PersistentDataContainer data = p.getItemInHand().getItemMeta().getPersistentDataContainer();
                        if (data.has(new NamespacedKey(plugin,"speed"), PersistentDataType.INTEGER)){
                            p.sendMessage(String.valueOf(data.get(new NamespacedKey(plugin,"speed"), PersistentDataType.INTEGER)));
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,100,data.get(new NamespacedKey(plugin,"speed"),PersistentDataType.INTEGER),false,false,false));
                        }else if (data.has(new NamespacedKey(plugin,"strenght"), PersistentDataType.INTEGER)){
                            p.addPotionEffect(new PotionEffect(PotionEffectType.HARM,100,data.get(new NamespacedKey(plugin,"strenght"),PersistentDataType.INTEGER),false,false,false));
                        }
                    }
                }
            }, 1L, 45L);
    }
}
