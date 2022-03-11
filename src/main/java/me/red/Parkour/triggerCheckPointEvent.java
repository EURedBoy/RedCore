package me.red.Parkour;

import me.red.redcore;
import me.red.utils.User;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class triggerCheckPointEvent implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);

    @EventHandler
    public void trigger(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.PHYSICAL) && e.getPlayer().getWorld().getName().equals("parkour")) {
            if (e.getClickedBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)){
                try{
                    User.setCheckPoint(e.getPlayer());
                }catch (Exception err){
                    e.getPlayer().sendMessage("§c[!] Non hai nessun checkpoint");
                }
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§eCheckPoint §aAttivato"));
            }
        }
    }
}
