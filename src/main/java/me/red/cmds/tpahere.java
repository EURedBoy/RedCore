package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class tpahere implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    public static HashMap<Player,Player> tpahere = new HashMap<>();
    public static int taskID1;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                Player e = Bukkit.getPlayer(args[0]);
                tpahere.put(e,p);
                p.sendMessage(plugin.getConfig().getString("tpa-here-sendmessage").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%tpa-target%", e.getName()).replaceAll("&","§"));
                e.sendMessage(plugin.getConfig().getString("tpa-here-comingmessage").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%tpa-sender%", p.getName()).replaceAll("&","§"));
                taskID1 = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                    if (tpahere.get(e) == p)
                        tpahere.remove(e);
                }, plugin.getConfig().getInt("tpa-delay")*20L);
            }else{
                p.sendMessage("§b/" + label + "§b [player]");
            }
        }
        return false;
    }
}
