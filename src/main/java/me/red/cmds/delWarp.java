package me.red.cmds;

import me.red.redcore;
import me.red.utils.configmanager;
import me.red.utils.message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class delWarp implements CommandExecutor {
    private final redcore plugin = redcore.getPlugin(redcore.class);
    private final configmanager cfm = new configmanager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only player command");
        }else{
            cfm.setup();
            Player p = (Player)sender;
            if (args.length > 0 && args[0] != null){
                if (cfm.getWarpsFile().getString("Warps." + args[0]) != null){
                    cfm.getWarpsFile().set("Warps." + args[0],null);
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("del-warp"),p));
                    cfm.saveWarpsFile();
                }else{
                    p.sendMessage(message.sendMessage(plugin.getConfig().getString("warp-error"),p));
                }
            }else{
                p.sendMessage("§bProva con /" + label + " <nomewarp>");
            }
        }
        return false;
    }
}
