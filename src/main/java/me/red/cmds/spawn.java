package me.red.cmds;

import me.red.redcore;
import me.red.utils.User;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    User user = new User();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only Player Command");
        }else{
            Player p = (Player)sender;
                if (args.length > 0 && p.hasPermission("redcore.otherspawn") && Bukkit.getPlayer(args[0]) != null){
                    Player e = Bukkit.getPlayer(args[0]);
                    try{
                        e.teleport(user.getSpawn());
                    }catch (Exception err){
                        p.sendMessage(message.sendMessage(plugin.getConfig().getString("spawn-error"),p));
                        return false;
                    }
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("spawn-message"),e));
                    p.sendMessage("§a[!] Hai teletrasportato §b" + e.getName() + " §aallo spawn");
                }else{
                    try{
                        p.teleport(user.getSpawn());
                    }catch (Exception err){
                        p.sendMessage(message.sendMessage(plugin.getConfig().getString("spawn-error"),p));
                        return false;
                    }
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("spawn-message"),p));
                }
        }
        return false;
    }
}
