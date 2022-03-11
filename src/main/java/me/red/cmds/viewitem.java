package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class viewitem implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                try{
                    Inventory inv = Bukkit.createInventory(null,9, plugin.getConfig().getString("displayitem-gui").replaceAll("&","§"));
                    inv.setItem(4,displayItem.hashitem.get(args[0]));
                    p.openInventory(inv);
                }catch (Exception e){
                    return false;
                }
            }
        }
        return false;
    }
}
