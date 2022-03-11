package me.red.Parkour;

import me.red.utils.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class parkourTeleport implements Listener {
    @EventHandler(priority= EventPriority.HIGH)
    public void Teleport(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if (p.getItemInHand() != null){
            if (p.getWorld().getName().equals("parkour") && p.getItemInHand().equals(parkourJoinWorld.CheckPointItem())){
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                    if (User.getCheckPoint(p) != null){
                        p.teleport(User.getCheckPoint(p));
                        p.sendMessage("§bSei stato §ateletrasportato §bpresso l'ultimo §6§lCheckPoint");
                    }
                }
            }
        }
    }
}
