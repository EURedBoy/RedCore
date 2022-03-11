package me.red.events;

import me.red.cmds.commandSpyToggle;
import me.red.cmds.jailPlayer;
import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class commandspy implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void PlayerCommand(PlayerCommandPreprocessEvent e){
        if (jailPlayer.jail.contains(e.getPlayer())){
            e.setCancelled(true);
            return;
        }
        for (Player p : Bukkit.getOnlinePlayers()){
            if (e.getPlayer() != p && p.hasPermission("redcore.commandspy") && commandSpyToggle.commandspy.contains(p)){
                p.sendMessage(plugin.getConfig().getString("commandspy-message").replaceAll("%player%",e.getPlayer().getName()).replaceAll("%comando%",e.getMessage()).replaceAll("&","§"));
            }
        }
    }
}
