package me.red.events;

import me.red.cmds.freeze;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerMoveEvent implements Listener {
    @EventHandler
    public void MoveEvent(PlayerMoveEvent e){
        if (freeze.freeze.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
