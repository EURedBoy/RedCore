package me.red.cmds;

import me.red.redcore;
import me.red.utils.User;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warp implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length == 1 && args[0] != null){
                try{
                    p.teleport(User.getWarp(args[0]));
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("warp"),p));
                }catch (Exception e){
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("warp-error"),p));
                }
            }else if (args.length > 0 && Bukkit.getPlayer(args[1]) != null){
                Player e = Bukkit.getPlayer(args[1]);
                try{
                    e.teleport(User.getWarp(args[0]));
                    e.sendMessage(message.sendMessage(plugin.getConfig().getString("warp"),p));
                    p.sendMessage("§a[!] Hai teletrasportato §b" + e.getName() + " §aal warp");
                }catch (Exception err){
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("warp-error"),p));
                }
            }else{
                p.sendMessage("§bProva con /" + label + " <nomewarp>");
            }
        }
        return false;
    }
}
