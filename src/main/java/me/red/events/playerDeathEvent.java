package me.red.events;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class playerDeathEvent implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void deathEvent(PlayerDeathEvent e){
        switch (e.getEntity().getLastDamageCause().getCause()){
            case ENTITY_EXPLOSION:
                e.setDeathMessage(message.sendMessage(plugin.getConfig().getString("explosion-message"),e.getEntity()));
                break;
            case VOID:
                e.setDeathMessage(message.sendMessage(plugin.getConfig().getString("void-message"),e.getEntity()));
                break;
        }
    }
}
