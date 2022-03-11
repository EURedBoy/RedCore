package me.red.cmds;

import me.red.redcore;
import me.red.utils.jailUtils;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class jailPlayer implements CommandExecutor {
    public static List<Player> jail = new ArrayList<>();
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length < 2){
                p.sendMessage("§bProva con /" + label + " <nomeplayer> <durata>");
            }else if (Bukkit.getPlayer(args[0]) != null){
                Player e = Bukkit.getPlayer(args[0]);
                if (jail.contains(e)){
                    p.sendMessage(plugin.getConfig().getString("already-jail").replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%player%",e.getName()).replaceAll("%tempo%", String.valueOf(jailUtils.getTimer(e.getUniqueId()))).replaceAll("&","§"));
                }else{
                    try {
                        e.teleport(jailUtils.getJail());
                        jail.add(e);
                        jailUtils.jailTimer(e.getUniqueId(),Integer.valueOf(args[1]));
                        e.sendMessage(plugin.getConfig().getString("injail-message").replaceAll("%prefix%",plugin.getConfig().getString("prefix"))
                                .replaceAll("%player%",p.getName()).replaceAll("%tempo%", String.valueOf(jailUtils.getTimer(e.getUniqueId())))
                                .replaceAll("&","§"));
                        p.sendMessage(plugin.getConfig().getString("jail-message").replaceAll("%prefix%",plugin.getConfig().getString("prefix"))
                                .replaceAll("%player%",e.getName()).replaceAll("%tempo%", String.valueOf(jailUtils.getTimer(e.getUniqueId())))
                                .replaceAll("&","§"));
                    }catch (Exception err){
                        p.sendMessage("§c[!] Nessuna jail impostata");
                    }
                }
            }
        }
        return false;
    }
}
