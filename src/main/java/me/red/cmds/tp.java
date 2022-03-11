package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tp implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 1 && Bukkit.getPlayer(args[0]) != null && Bukkit.getPlayer(args[1]) != null && p.hasPermission("redcore.teleport.other")){
                Player arg0 = Bukkit.getPlayer(args[0]);
                Player arg1 = Bukkit.getPlayer(args[1]);
                arg0.teleport(arg1.getLocation());
                p.sendMessage(plugin.getConfig().getString("otherteleport-message").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%teleported%", arg0.getName()).replaceAll("%toteleport",arg1.getName()).replaceAll("&","§"));
            }else if (args.length > 0 && Bukkit.getPlayer(args[0]) != null && p.hasPermission("redcore.teleport")){
                Player e = Bukkit.getPlayer(args[0]);
                p.teleport(e.getLocation());
                p.sendMessage(plugin.getConfig().getString("teleport-message").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%teleported%", e.getName()).replaceAll("&","§"));
            }else{
                p.sendMessage("§bProva con /" + label + " <player> o <player> <player>");
            }
        }
        return false;
    }
}
