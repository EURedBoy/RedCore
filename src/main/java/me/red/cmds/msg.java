package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class msg implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    public static HashMap<Player,Player> msg = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                Player e = Bukkit.getPlayer(args[0]);
                String message = "";
                msg.put(p,e);
                msg.put(e,p);
                for(int i = 1; i < args.length; i++) {
                    message += args[i] + " ";
                }
                p.sendMessage(plugin.getConfig().getString("msg-sender-message").replaceAll("%player%",e.getName()).replaceAll("%message%",message).replaceAll("&","§"));
                e.sendMessage(plugin.getConfig().getString("msg-sender-message").replaceAll("%player%",p.getName()).replaceAll("%message%",message).replaceAll("&","§"));
                e.playSound(e.getLocation(), Sound.ENTITY_SILVERFISH_AMBIENT,30,10);
            }else if (args.length > 0 && Bukkit.getPlayer(args[0]) == null){
                p.sendMessage("§c[!] Il player è offline");
            }else{
                p.sendMessage("§b/" + label + "§b [player] [messaggio]");
            }
        }
        return false;
    }
}
