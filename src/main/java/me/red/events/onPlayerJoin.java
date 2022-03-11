package me.red.events;

import me.red.bossItem.customItemBlockPlace;
import me.red.redcore;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        customItemBlockPlace.ability.put(e.getPlayer(),true);
        e.setJoinMessage(message.sendMessage(plugin.getConfig().getString("join-message"),e.getPlayer()));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            for (String string : plugin.getConfig().getStringList("joinplayer-message"))
                e.getPlayer().sendMessage(message.sendMessage(string,e.getPlayer()));
        }, 20L);
        if (!(e.getPlayer().hasPlayedBefore())){
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                for (Player p : Bukkit.getOnlinePlayers())
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("first-join-message"),e.getPlayer()));
            }, 20L);
        }
    }
}
