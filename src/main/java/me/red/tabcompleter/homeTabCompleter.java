package me.red.tabcompleter;

import me.red.utils.configmanager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class homeTabCompleter implements TabCompleter {
    private final configmanager cfm = new configmanager();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> argument = new ArrayList<>();
        Player p = (Player)sender;
        cfm.setup();
        if (p.hasPermission("redcore.otherhomes") && Bukkit.getPlayer(args[0]) != null && args.length == 2){
            Player e = Bukkit.getPlayer(args[0]);
            try{
                Set<String> keys = cfm.getPlayers().getConfigurationSection("Homes." + e.getUniqueId().toString() + ".home").getKeys(false);
                for (String key : keys)
                    argument.add(key);
            }catch (Exception err){
                return argument;
            }
        }else if (args.length == 1 ){
            if (p.hasPermission("redcore.otherhome")){
                for (Player pl : Bukkit.getOnlinePlayers())
                    argument.add(pl.getName());
            }
            try{
                Set<String> keys = cfm.getPlayers().getConfigurationSection("Homes." + p.getUniqueId().toString() + ".home").getKeys(false);
                for (String key : keys)
                    argument.add(key);
            }catch (Exception err){
                return argument;
            }
        }
        return argument;
    }
}
