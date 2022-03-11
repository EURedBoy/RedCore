package me.red.cmds;

import me.red.redcore;
import me.red.utils.User;
import me.red.utils.configmanager;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class home implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);
    private final configmanager cfm = new configmanager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            Location loc;
            if (args.length > 1 && Bukkit.getPlayer(args[0]) != null && p.hasPermission("redcore.otherhome")){
                Player e = Bukkit.getPlayer(args[0]);
                try{
                    loc = User.getHome(args[1],e);
                }catch (Exception err){
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("home-error"),e));
                    return false;
                }
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("tpother-home"),p));
            }else if (args.length == 1){
                try{
                    loc = User.getHome(args[0],p);
                }catch (Exception err){
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("home-error"),p));
                    return false;
                }
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("tp-home"),p));
            }else{
                p.sendMessage("§b/" + label + "§b [nomecasa]");
                return false;
            }
            p.teleport(loc);
        }
        return false;
    }
}
