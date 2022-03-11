package me.red.BroadCast;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;

public class BroadCastEvent {

    redcore plugin = redcore.getPlugin(redcore.class);
    int i = 0;
    List<String> messaggi;
    public void BroadCast(){
            Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
                @Override
                public void run() {
                    if (Bukkit.getOnlinePlayers().size() != 0){
                        for(Player p : Bukkit.getServer().getOnlinePlayers()){
                            messaggi = plugin.getConfig().getStringList("broadcast-message");
                            p.sendMessage(plugin.getConfig().getString("header").replaceAll("&","§"));
                            p.sendMessage(messaggi.get(i).replaceAll("&", "§").replaceAll("%prefix%",plugin.getConfig().getString("prefix").replaceAll("&","§")));
                            p.sendMessage(plugin.getConfig().getString("foother").replaceAll("&","§"));
                        }
                        if (i < messaggi.size()-1){
                            i++;
                        }else{
                            i = 0;
                        }
                    }else{
                        return;
                    }
                }
            }, 20L, plugin.getConfig().getInt("autobroadcast-delay")*20L);
    }
}
