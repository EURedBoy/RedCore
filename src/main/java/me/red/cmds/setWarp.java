package me.red.cmds;

import me.red.redcore;
import me.red.utils.User;
import me.red.utils.message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setWarp implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.setwarp")){
                if (args.length > 0 && args[0] != null){
                    User.setWarp(p.getLocation(),p,args);
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("set-warp"),p));
                }else{
                    p.sendMessage("§bProva con /" + label + " <nomewarp>");
                }
            }else{
                p.sendMessage("§c[!] Non hai il permesso");
            }
        }
        return false;
    }
}
