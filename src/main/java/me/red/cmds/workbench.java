package me.red.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class workbench implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.workbench")){
                Inventory inv = Bukkit.createInventory(null, InventoryType.WORKBENCH);
                p.openInventory(inv);
                p.sendMessage(ChatColor.GREEN + "[!] Hai aperto l'workbench");
            }else{
                p.sendMessage(ChatColor.RED + "[!] Non hai il permesso");
            }
        }
        return false;
    }
}
