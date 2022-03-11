package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpacancel implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player commnad");
        }else{
            Player p = (Player)sender;
            if (tpa.tpa.get(p) != null){
                tpahere.tpahere.remove(p);
                Bukkit.getServer().getScheduler().cancelTask(tpa.taskID);
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("tpa-deny"),p));
            }else if (tpahere.tpahere.get(p) != null) {
                Player e = tpa.tpa.get(p);
                tpahere.tpahere.remove(p);
                Bukkit.getServer().getScheduler().cancelTask(tpahere.taskID1);
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("tpa-deny"),p));
            }else{
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("none-tpa"),p));
            }
        }
        return false;
    }
}
