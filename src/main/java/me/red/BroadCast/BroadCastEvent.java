package me.red.BroadCast;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

public class BroadCastEvent {

    redcore plugin = redcore.getPlugin(redcore.class);
    int i = 0;
    Set<String> messaggi;
    public void BroadCast(){
            Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
                @Override
                public void run() {
                    if (Bukkit.getOnlinePlayers().size() != 0){
                        messaggi = plugin.getConfig().getConfigurationSection("broadcast-message").getKeys(false);
                        for(Player p : Bukkit.getServer().getOnlinePlayers()){
                            p.sendMessage(plugin.getConfig().getString("header").replaceAll("&","§"));
                            for (String msg : plugin.getConfig().getStringList("broadcast-message." + i))
                                p.sendMessage(msg.replaceAll("&","§"));
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
