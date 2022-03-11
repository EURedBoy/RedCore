package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class announce implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.broadcast")){
                if (args.length > 0){
                    String message = "";
                    for(int i = 0; i < args.length; i++)
                        message += args[i] + " ";
                    Bukkit.broadcastMessage(plugin.getConfig().getString("announce-prefix").replaceAll("&","§") + " " + message.replaceAll("&","§"));
                }else{
                    p.sendMessage("§bProva con §a/" + label + "§b [messaggio]");
                }
            }else{
                p.sendMessage("§c[!] Non hai il permesso");
            }
        }
        return false;
    }
}
