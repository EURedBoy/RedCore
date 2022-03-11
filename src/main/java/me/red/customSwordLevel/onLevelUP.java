package me.red.customSwordLevel;

import me.red.redcore;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class onLevelUP {
    static redcore plugin = redcore.getPlugin(redcore.class);
    public static void LevelUP(Player p, Integer lvl){
        double myRandom = Math.random();
        ItemStack is = p.getItemInHand();
        ItemMeta im = is.getItemMeta();
        p.sendMessage("Sono nell'evento");
        PersistentDataContainer data = im.getPersistentDataContainer();
        if (lvl == 100){
            p.sendMessage("Sono nel lvl 100");
            if (myRandom <= 0.7){
                p.sendMessage("speed");
                data.set(new NamespacedKey(plugin,"speed"), PersistentDataType.INTEGER,1);
            }else{
                p.sendMessage("strenght");
                data.set(new NamespacedKey(plugin,"strenght"), PersistentDataType.INTEGER,1);
            }
            if (im.hasDisplayName()){
                p.sendMessage("Ha gia un display name");
                im.setDisplayName(im.getDisplayName() + " §a(§61§a)");
            }else{
                p.sendMessage("Non ha un display name");
                im.setDisplayName(is.getType() + " §a(§61§a)");
                p.sendMessage(String.valueOf(is.getType()));
            }
            p.sendMessage("Imposto un item meta");
            is.setItemMeta(im);
        }
    }
}
