package me.red.Economy;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class item {

    public static ItemStack soldi(String tipologia){
        ItemStack item = new ItemStack(Material.COPPER_INGOT);
        ItemMeta itemmeta = item.getItemMeta();
        if (tipologia == "normali"){
            itemmeta.setDisplayName("§8| §6Moneta Di Bronzo §8|");
        }else{
            itemmeta.setDisplayName("§8| §6Moneta Di Bronzo Compattata §8|");
            itemmeta.addEnchant(Enchantment.WATER_WORKER,1,false);
            itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(itemmeta);
        return item;
    }
    public static ItemStack lightingtool(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8| §bMartello di Zeus §8|");
        meta.addEnchant(Enchantment.WATER_WORKER,1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
}
