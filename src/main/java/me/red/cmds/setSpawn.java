package me.red.cmds;

import me.red.redcore;
import me.red.utils.User;
import me.red.utils.message;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class setSpawn implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    User user = new User();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only Player Command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.setspawn")){
                redcore.config.set("spawn.x",p.getLocation().getX());
                redcore.config.set("spawn.y",p.getLocation().getY());
                redcore.config.set("spawn.z",p.getLocation().getZ());
                redcore.config.set("spawn.yaw",p.getLocation().getYaw());
                redcore.config.set("spawn.pitch",p.getLocation().getPitch());
                redcore.config.set("spawn.world",p.getLocation().getWorld().getName());
                try {
                    redcore.config.save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("set-spawn"),p));
                Location loc = new Location(p.getLocation().getWorld(),p.getLocation().getX(),p.getLocation().getY()-1,p.getLocation().getZ());
                user.setSpawn();
                if (loc.getBlock().getType() == Material.AIR)
                    p.sendMessage("§c[!] §cAttenzione hai impostato lo spawn su un blocco volante, questo potrebbe creare problemi!");
            }
        }
        return false;
    }
}
