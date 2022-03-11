package me.red.cmds;

import me.red.redcore;
import me.red.utils.User;
import me.red.utils.configmanager;
import me.red.utils.message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setHome implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);
    private final configmanager cfm = new configmanager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        cfm.setup();
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length >= 1 && args[0] != null){
                if (User.getHomeAmount(p) >= User.getHomePermissionAmount(p)){
                    p.sendMessage("§c[!] Hai raggiunto il numero massimo di case");
                    return false;
                }

                User.setHome(p.getLocation(),p,args);
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("set-home"),p));
            }else{
                p.sendMessage("§bProva con /" + label + " <nomecasa>");
            }
        }
        return false;
    }
}
