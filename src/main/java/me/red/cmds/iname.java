package me.red.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class iname implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.iname")){
                if (p.getItemInHand().getType().isAir()){
                    p.sendMessage(ChatColor.RED + "[!] Non puoi rinominare l'aria");
                }else{
                    if (!(args.length > 0)) return false;
                    ItemStack is = p.getItemInHand();
                    ItemMeta im = is.getItemMeta();
                    String message = "";
                    for(int i = 0; i < args.length; i++) {
                        message += args[i] + " ";
                    }
                    im.setDisplayName(message.replaceAll("&","§"));
                    is.setItemMeta(im);
                    p.sendMessage(ChatColor.GREEN + "[!] Item rinominato");
                }
            }else{
                p.sendMessage(ChatColor.RED + "[!] Non hai il permesso");
            }
        }
        return false;
    }
}
