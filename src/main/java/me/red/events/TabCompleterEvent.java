package me.red.events;

import me.red.redcore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class TabCompleterEvent implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);

    @EventHandler
    public void TabCompleter(PlayerCommandSendEvent e){
        Boolean check;
        String[] array = new String[e.getCommands().size()];
        e.getCommands().toArray(array);
        if (!(e.getPlayer().hasPermission("redcore.tabcompleter")))
            for (String cmds : array){
                check = true;
                for (String command : plugin.getConfig().getStringList("enabled-command"))
                    if (!(cmds.equalsIgnoreCase(command))){
                        check = false;
                    }else{
                        check = true;
                        break;
                    }
                if (!check)
                    e.getCommands().remove(cmds);
            }
    }
}
