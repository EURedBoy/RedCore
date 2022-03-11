package me.red.events;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPlayerLeft implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void onLeft(PlayerQuitEvent e){
        e.setQuitMessage(message.sendMessage(plugin.getConfig().getString("quit-message"),e.getPlayer()));
    }
}
