package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemode implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length == 1){
                switch (args[0]){
                    case "0":
                    case "survival":
                        if (p.hasPermission("redcore.gamemode.survival")){
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", p.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", p.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                    case "1":
                    case "creative":
                        if (p.hasPermission("redcore.gamemode.creative")){
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", p.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", p.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                    case "2":
                    case "adventure":
                        if (p.hasPermission("redcore.gamemode.adventure")){
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", p.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", p.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                    case "3":
                    case "spectator":
                        if (p.hasPermission("redcore.gamemode.spectator")){
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", p.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", p.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                }
            }else if (args.length > 1 && Bukkit.getPlayer(args[1]) != null){
                Player e = Bukkit.getPlayer(args[1]);
                switch (args[0]){
                    case "0":
                    case "survival":
                        if (p.hasPermission("redcore.gamemode.survival")){
                            e.setGameMode(GameMode.SURVIVAL);
                            e.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", e.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", e.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                            p.sendMessage("§a[!] Hai cambiato la gamemode di: §b" + e.getName());
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                    case "1":
                    case "creative":
                        if (p.hasPermission("redcore.gamemode.creative")){
                            e.setGameMode(GameMode.CREATIVE);
                            e.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", e.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", e.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                            p.sendMessage("§a[!] Hai cambiato la gamemode di: §b" + e.getName());
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                    case "2":
                    case "adventure":
                        if (p.hasPermission("redcore.gamemode.adventure")){
                            e.setGameMode(GameMode.ADVENTURE);
                            e.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", e.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", e.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                            p.sendMessage("§a[!] Hai cambiato la gamemode di: §b" + e.getName());
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                    case "3":
                    case "spectator":
                        if (p.hasPermission("redcore.gamemode.spectator")){
                            e.setGameMode(GameMode.SPECTATOR);
                            e.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", e.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", e.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                            p.sendMessage("§a[!] Hai cambiato la gamemode di: §b" + e.getName());
                        }else{
                            p.sendMessage("§c[!] Non hai il permesso");
                        }
                        break;
                }
            }else{
                p.sendMessage("§b/" + label + "§b [gamemode] [player]");
            }
        }
        return false;
    }
}
