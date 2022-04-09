package me.red.cmds;

import me.red.utils.configmanager;
import me.red.utils.message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class nickCommand implements CommandExecutor {
    private configmanager cfmg = new configmanager();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (p.hasPermission("redcore.nick")){
                if (args.length > 0){
                    //Implement nick with PAPI
                    cfmg.setup();
                    cfmg.getPlayers().set("Homes." + p.getUniqueId() + ".nick", message.messageColor(args[0]));
                    cfmg.savePlayers();
                }else{
                    p.sendMessage("§bProva con /" + label + " <nick>");
                }
            }else{
                p.sendMessage(ChatColor.RED + "[!] Non hai il permesso");
            }
        }
        return false;
    }
}
