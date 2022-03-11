package me.red.cmds;

import dev.dejvokep.boostedyaml.YamlDocument;
import me.red.redcore;
import me.red.utils.message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class redCore implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            Player p = (Player)sender;
            if (args.length > 0){
                switch (args[0]){
                    case "reload":
                        try {
                            redcore.config.reload();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        p.sendMessage(message.sendMessage(plugin.getConfig().getString("reload-message"),p));
                        break;
                    case "info":
                        p.sendMessage("        §c§lRed§6§lCore");
                        p.sendMessage("§aCreato da ➽ §bRedBoy§e(§bJwZy§e)");
                        p.sendMessage("§aVersione ➽ §b" + plugin.getDescription().getVersion());
                        p.sendMessage("§bCreato per §9§lM§b§lK il §e24/02/2022");
                }
            }else{
                p.sendMessage("§b/" + label + "§b [args]");
            }
        }
        return false;
    }
}
