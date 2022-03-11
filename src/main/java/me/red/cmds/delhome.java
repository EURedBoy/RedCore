package me.red.cmds;

import me.red.redcore;
import me.red.utils.configmanager;
import me.red.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class delhome implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);  //Inserire il mess in config
    private final configmanager cfm = new configmanager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only a player command");
        }else{
            Player p = (Player)sender;
            Set<String> keys;
            cfm.setup();
            String homeset = "";
            if (args.length > 1 && Bukkit.getPlayer(args[0]) != null && p.hasPermission("redcore.otherhome")){
                Player e = Bukkit.getPlayer(args[0]);
                homeset = "Homes." + e.getUniqueId().toString() + ".home." + args[1].toLowerCase();
            }else if (args.length == 1){
                homeset = "Homes." + p.getUniqueId().toString() + ".home." + args[0].toLowerCase();
            }else{
                p.sendMessage("§b/" + label + "§b [nomecasa]");
                return false;
            }
            if (cfm.getPlayers().getString(homeset) == null){
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("home-error"),p));
            }else{
                cfm.getPlayers().set(homeset, null);
                p.sendMessage(ChatColor.RED + "Casa eliminata con successo");
                cfm.savePlayers();
            }
        }
        return false;
    }
}
