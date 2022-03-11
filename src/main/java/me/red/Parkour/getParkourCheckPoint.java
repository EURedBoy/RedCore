package me.red.Parkour;

import me.red.redcore;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class getParkourCheckPoint implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.checkpoint")){
                ItemStack item = new ItemStack(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
                ItemMeta itemM = item.getItemMeta();
                itemM.setDisplayName("§6§lCheckPoint");
                item.setItemMeta(itemM);
                p.getInventory().addItem(item);
            }else{
                p.sendMessage(ChatColor.RED + "[!] Non hai il permesso");
            }
        }
        return false;
    }
}
