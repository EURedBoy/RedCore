package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class tpa implements CommandExecutor {
    public static HashMap<Player,Player> tpa = new HashMap<>();
    redcore plugin = redcore.getPlugin(redcore.class);
    public static int taskID;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                Player e = Bukkit.getPlayer(args[0]);
                if (tpa.get(e) == null){
                    tpa.put(e,p);
                    p.sendMessage(plugin.getConfig().getString("tpa-sendmessage").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%tpa-target%", e.getName()).replaceAll("&","§"));
                    e.sendMessage(plugin.getConfig().getString("tpa-comingmessage").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%tpa-sender%", p.getName()).replaceAll("&","§"));
                    taskID = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        if (tpa.get(e) == p)
                            tpa.remove(e);
                    }, plugin.getConfig().getInt("tpa-delay")*20L);
                }else{
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("tpa-null"),p));
                    return false;
                }
            }else{
                p.sendMessage("§b/" + label + "§b [player]");
            }
        }
        return false;
    }
}
