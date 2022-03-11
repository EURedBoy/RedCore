package me.red.Economy;


import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class money implements CommandExecutor {
    private final Plugin plugin = redcore.getPlugin(redcore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("redcore.moneygive")) {
            if (args.length > 1) {
                Player p = Bukkit.getPlayer(args[0]);
                Integer quantita;
                try{
                    quantita = Integer.valueOf(args[1]);
                }catch (Exception e){
                    //sender.sendMessage(plugin.getConfig().getString("wrong-formatting").replaceAll("&", "§").replaceAll("%prefix%",prefix));
                    return false;
                }
                if (quantita != null && p != null) {
                    ItemStack soldi = item.soldi("normali");
                    int i;
                    if (p.getInventory().firstEmpty() != -1) {
                        for (i = 0; i < quantita; ++i) {
                            if (p.getInventory().firstEmpty() != -1) {
                                p.getInventory().addItem(soldi);
                            } else {
                                p.getWorld().dropItemNaturally(p.getLocation(), soldi);
                            }
                        }
                    }else{
                        for (i = 0; i < quantita; ++i)
                            p.getWorld().dropItemNaturally(p.getLocation(), soldi);
                    }
                } else {
                    //sender.sendMessage(plugin.getConfig().getString("wrong-formatting").replaceAll("&", "§").replaceAll("%prefix%",prefix));
                }
            } else {
                //sender.sendMessage(plugin.getConfig().getString("wrong-formatting").replaceAll("&", "§").replaceAll("%prefix%",prefix));
            }
        }else{
            sender.sendMessage("§c[!] Non hai il permesso.");
        }
        return false;
    }
}
