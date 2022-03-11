package me.red.cmds;

import me.red.redcore;
import me.red.utils.message;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


public class displayItem implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    public static HashMap<String,ItemStack> hashitem = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.displayitem")){
                if (!(p.getItemInHand().getType().isAir())){
                    ItemStack item = p.getItemInHand();
                    TextComponent display;
                    if (item.getItemMeta().hasDisplayName()){
                        display = new TextComponent(plugin.getConfig().getString("chat-display").replaceAll("%player%",p.getDisplayName()).replaceAll("%item%", StringUtils.capitalize(item.getItemMeta().getDisplayName().toLowerCase().replace("_", " "))).replaceAll("%amount%",String.valueOf(item.getAmount())).replaceAll("&","§"));
                    }else{
                        display = new TextComponent(plugin.getConfig().getString("chat-display").replaceAll("%player%",p.getDisplayName()).replaceAll("%item%", StringUtils.capitalize(String.valueOf(item.getType()).toLowerCase().replace("_", " "))).replaceAll("%amount%",String.valueOf(item.getAmount())).replaceAll("&","§"));
                    }
                    display.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/viewitem " + p.getName()));
                    hashitem.put(p.getName(),item);
                    for (Player pl : Bukkit.getOnlinePlayers()){
                        pl.spigot().sendMessage(display);
                    }
                }else{
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("no-item-inhand"),p));
                }
            }else{
                p.sendMessage(message.sendMessage(plugin.getConfig().getString("no-permission"),p));
            }
        }
        return false;
    }
}
