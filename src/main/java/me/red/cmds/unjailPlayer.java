package me.red.cmds;

import me.red.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class unjailPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 1 && Bukkit.getPlayer(args[0]) != null){
                Player e = Bukkit.getPlayer(args[0]);
                if (jailPlayer.jail.contains(e)){
                    p.sendMessage("§c[!] Hai scarcerato §8" + e.getName());
                    jailPlayer.jail.remove(e);
                    e.teleport(User.getSpawn());
                    e.sendMessage("§c[!] Sei stato scarcerato");
                }else{
                    p.sendMessage("§c[!] Questo player non è incarcerato");
                }
            }else{
                p.sendMessage("§bProva con /" + label + " <nomeplayer>");
            }
        }
        return false;
    }
}
