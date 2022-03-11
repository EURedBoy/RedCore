package me.red.cmds;

import me.red.events.backEvent;
import me.red.redcore;
import me.red.utils.User;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class back implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.back.other") && args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                Player e = Bukkit.getPlayer(args[0]);
                try{
                   //e.teleport(User.getBack(e));
                    e.teleport(backEvent.back.get(e));
                }catch (Exception ex){
                    p.sendMessage(ChatColor.RED + "[!] " + e.getName() + " Non ha nessuna posizione precedente impostata");
                    return false;
                }
                p.sendMessage(ChatColor.RED + "[!] Hai riportato " + e.getName() + " alla sua posizione precedente");
                e.sendMessage(message.sendMessage(plugin.getConfig().getString("back-message"),e));
            }else{
                try{
                    //p.teleport(User.getBack(p));
                    p.teleport(backEvent.back.get(p));
                }catch (Exception ex){
                    p.sendMessage(ChatColor.RED + "[!] Non hai nessuna posizione precedente impostata");
                    return false;
                }
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("back-message"),p));
            }
        }
        return false;
    }
}
