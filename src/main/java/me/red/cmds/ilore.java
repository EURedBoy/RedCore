package me.red.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ilore implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.ilore")){
                if (p.getItemInHand().getType().isAir()){
                    p.sendMessage(ChatColor.RED + "[!] Non puoi rinominare l'aria");
                }else{
                    if (args.length > 0){
                        ItemStack is = p.getItemInHand();
                        ItemMeta im = is.getItemMeta();
                        List<String> lore;
                        if (im.hasLore()){
                            lore = im.getLore();
                        }else{
                            lore = new ArrayList<>();
                        }
                        String message = "";
                        switch (args[0]){
                            case "add":
                                if (args.length > 1){
                                    for(int i = 1; i < args.length; i++) {
                                        message += args[i] + " ";
                                    }
                                        lore.add(message.replaceAll("&","§"));
                                }
                                p.sendMessage(ChatColor.GREEN + "[!] Lore aggiunta");
                                break;
                            case "remove":
                                lore.remove(Integer.parseInt(args[1]));
                                p.sendMessage(ChatColor.GREEN + "[!] Lore rimossa alla posizione " + args[1]);
                                break;
                            case "set":
                                if (args.length > 2){
                                    for(int i = 2; i < args.length; i++) {
                                        message += args[i] + " ";
                                    }
                                    lore.set(Integer.parseInt(args[1]),message.replaceAll("&","§"));
                                    p.sendMessage(ChatColor.GREEN + "[!] Lore impostata alla posizione " + args[1]);
                                }
                                break;
                            case "clear":
                                lore.clear();
                                p.sendMessage(ChatColor.GREEN + "[!] Lore pulita");
                                break;
                            default:
                                p.sendMessage(ChatColor.AQUA + "Prova con " + label + " [add/remove/set/clear]");
                                break;
                        }
                        im.setLore(lore);
                        is.setItemMeta(im);
                    }else{
                        p.sendMessage(ChatColor.AQUA + "Prova con " + label + " [add/remove/set/clear]");
                    }
                }
            }

        }
        return false;
    }
}
