package me.red.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class hat implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.hat")){
                if (p.getItemInHand().getType().isAir()){
                    p.sendMessage(ChatColor.RED + "[!] Non hai nulla in mano");
                }else{
                    if (p.getInventory().getHelmet() != null){
                        p.sendMessage(ChatColor.RED + "[!] Hai gia' qualcosa in testa");
                    }else{
                        p.getInventory().setHelmet(p.getItemInHand());
                        p.setItemInHand(null);
                        p.sendMessage(ChatColor.GREEN + "[!] Hai indossato questo item");
                    }
                }
            }else{
                p.sendMessage(ChatColor.RED + "[!] Non hai il permesso");
            }
        }
        return false;
    }
}
