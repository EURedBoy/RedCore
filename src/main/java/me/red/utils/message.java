package me.red.utils;

import me.red.redcore;
import org.bukkit.entity.Player;

public class message {
    private static redcore plugin = redcore.getPlugin(redcore.class);

    public static String sendMessage(String message, Player p){
        message = (message.replaceAll("&","§").replaceAll("%player%",p.getName())
                .replaceAll("%prefix%",plugin.getConfig().getString("prefix").replaceAll("&","§")));
        return message;
    }

    public static String messageColor(String message){
        return message.replaceAll("&","§");
    }
}
