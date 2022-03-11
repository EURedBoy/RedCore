package me.red.cmds;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemodeAdventure implements CommandExecutor {
    redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player) sender;
            if (p.hasPermission("redcore.gamemode.adventure")){
                if (args.length > 0 && Bukkit.getPlayer(args[0]) != null){
                    Player e = Bukkit.getPlayer(args[0]);
                    e.setGameMode(GameMode.ADVENTURE);
                    e.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%", e.getName()).replaceAll("%prefix%", plugin.getConfig().getString("prefix")).replaceAll("%gamemode%", e.getGameMode().name().toLowerCase()).replaceAll("&", "§"));
                    p.sendMessage("§a[!] Hai cambiato la gamemode di: §b" + e.getName());
                }else{
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(plugin.getConfig().getString("change-gamemode").replaceAll("%player%",p.getName()).replaceAll("%prefix%",plugin.getConfig().getString("prefix")).replaceAll("%gamemode%",p.getGameMode().name().toLowerCase()).replaceAll("&","§"));
                }
            }else{
                p.sendMessage("§c[!] Non hai il permesso");
            }
        }
        return false;
    }
}
