package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class freeze implements CommandExecutor {
    public static List<Player> freeze = new ArrayList<>();
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player) sender;
            if (p.hasPermission("redcore.freeze")){
                if (args.length > 0){
                    if (Bukkit.getPlayer(args[0]) != null){
                        Player e = Bukkit.getPlayer(args[0]);
                        if (!(freeze.contains(e))){
                            freeze.add(e);
                            e.sendMessage(message.sendMessage(plugin.getConfig().getString("freeze-message"),p));
                            p.sendMessage(message.sendMessage(plugin.getConfig().getString("freeze-player"),e));
                        }else{
                            freeze.remove(e);
                            e.sendMessage(message.sendMessage(plugin.getConfig().getString("unfreeze-message"),p));
                            p.sendMessage(message.sendMessage(plugin.getConfig().getString("unfreeze-player"),e));
                        }
                    }else{
                        p.sendMessage("§c[!] Player non esistente o offline");
                    }
                }else{
                    p.sendMessage("§b/" + label + "§b [player]");
                }
            }else{
                p.sendMessage("§c[!] Non hai il permesso");
            }
        }
        return false;
    }
}
