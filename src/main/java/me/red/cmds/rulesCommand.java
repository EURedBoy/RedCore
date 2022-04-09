package me.red.cmds;

import me.red.redcore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class rulesCommand implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            for (String msg : plugin.getConfig().getStringList("rules"))
                p.sendMessage(msg.replaceAll("%player%",p.getName()).replaceAll("&","§"));
        }
        return false;
    }
}
