package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.fly")){
                if (args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                    Player e = Bukkit.getPlayer(args[0]);
                    if (e.getAllowFlight()){
                        e.sendMessage(message.sendMessage(plugin.getConfig().getString("fly-disable"),p));
                        p.sendMessage("§c[!] Hai disabilitato la fly a: §b" + e.getName());
                        e.setAllowFlight(false);
                    }else{
                        e.sendMessage(message.sendMessage(plugin.getConfig().getString("fly-enable"),p));
                        p.sendMessage("§a[!] Hai abilitato la fly a: §b" + e.getName());
                        e.setAllowFlight(true);
                    }
                }else{
                    if (p.getAllowFlight()){
                        p.sendMessage(message.sendMessage(plugin.getConfig().getString("fly-disable"),p));
                        p.setAllowFlight(false);
                    }else{
                        p.sendMessage(message.sendMessage(plugin.getConfig().getString("fly-enable"),p));
                        p.setAllowFlight(true);
                    }
                }
            }
        }
        return false;
    }
}
