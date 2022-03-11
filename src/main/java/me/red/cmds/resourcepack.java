package me.red.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class resourcepack implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
                p.setResourcePack("https://www.dropbox.com/sh/c4g51j08dltmf9z/AAAvxbMXnco_cu07C5ukSq-1a?dl=1");
                p.sendMessage(ChatColor.GREEN + "[!] ResourcePack Caricata in caso negativo hai i pacchetti disattivati");
        }
        return false;
    }
}
