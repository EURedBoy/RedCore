package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class commandSpyToggle implements CommandExecutor {
    public static List<Player> commandspy = new ArrayList<>();
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (!(commandspy.contains(p))){
                commandspy.add(p);
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("commandspy-on"),p));
            }else{
                commandspy.remove(p);
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("commandspy-off"),p));
            }
        }
        return false;
    }
}
