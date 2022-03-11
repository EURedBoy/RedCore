package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reply implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 0) {
                if (msg.msg.get(p) != null && msg.msg.get(p).isOnline()){
                    Player e = msg.msg.get(p);
                    String message = "";
                    for(int i = 0; i < args.length; i++) {
                        message += args[i] + " ";
                    }
                    p.sendMessage(plugin.getConfig().getString("msg-sender-message").replaceAll("%player%",e.getName()).replaceAll("%message%",message).replaceAll("&","§"));
                    e.sendMessage(plugin.getConfig().getString("msg-sender-message").replaceAll("%player%",p.getName()).replaceAll("%message%",message).replaceAll("&","§"));
                    e.playSound(e.getLocation(), Sound.ENTITY_SILVERFISH_AMBIENT,30,10);
                }else{
                    p.sendMessage(ChatColor.RED + "[!] Non hai nessuno a cui rispondere");
                }
            }else{
                p.sendMessage(ChatColor.RED + "[!] Devi scrivere almeno una parola");
            }
        }
        return false;
    }
}
