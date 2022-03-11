package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tphere implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.tphere")){
                if (args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                    Player e = Bukkit.getPlayer(args[0]);
                    e.teleport(p.getLocation());
                    p.sendMessage(plugin.getConfig().getString("tphere-message").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%teleported%", e.getName()).replaceAll("&","§"));
                }else{
                    p.sendMessage("§bProva con /" + label + " <player>");
                }
            }else{
                p.sendMessage("§c[!] Non hai il permesso");
            }
        }
        return false;
    }
}
