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

public class warpListTabCompleter implements TabCompleter {
    private final configmanager cfm = new configmanager();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> argument = new ArrayList<>();
        cfm.setup();
        if (args.length <= 1){
            try {
                Set<String> keys = cfm.getWarpsFile().getConfigurationSection("Warps").getKeys(false);
                for (String key : keys)
                    argument.add(key);
            } catch (Exception err) {
                return null;
            }
        }else{
            for (Player p : Bukkit.getOnlinePlayers())
                argument.add(p.getName());
        }
        return argument;
    }
}
