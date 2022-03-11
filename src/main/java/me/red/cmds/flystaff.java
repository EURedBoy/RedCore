package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class flystaff implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    HashMap<String, Location> staffloc = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only Player Command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.staff_fly")){
                if (p.getAllowFlight()){
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("fly-disable"),p));
                    p.setGameMode(GameMode.SURVIVAL);
                    p.setAllowFlight(false);
                    try{
                        if (plugin.getConfig().getBoolean("reset-fly-location")){
                            p.teleport(staffloc.get(p.getName()));
                            p.sendMessage("Sei stato teletrasportato dove hai attivato la fly");
                        }
                    }catch (Exception e){

                    }
                }else{
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("fly-enable"),p));
                    p.setGameMode(GameMode.ADVENTURE);
                    p.setAllowFlight(true);
                    if (plugin.getConfig().getBoolean("reset-fly-location"))
                        staffloc.put(p.getName(),p.getLocation());
                }
            }else{
                p.sendMessage("§c[!] Non hai il permesso");
            }
        }
        return false;
    }
}
