package me.red.events;

import me.red.cmds.commandSpyToggle;
import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;

public class commandspy implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void PlayerCommand(PlayerCommandPreprocessEvent e){
        for (Player p : Bukkit.getOnlinePlayers()){
            String ciao = new String("ciao");
            String ciao1 = new String("ciao");
            HashMap<Integer,Player> hash = new HashMap<>();
            if (ciao == ciao1)
            if (e.getPlayer() != p && p.hasPermission("redcore.commandspy") && commandSpyToggle.commandspy.contains(p)){
                p.sendMessage(plugin.getConfig().getString("commandspy-message").replaceAll("%player%",e.getPlayer().getName()).replaceAll("%comando%",e.getMessage()).replaceAll("&","§"));
            }
        }
    }
}
