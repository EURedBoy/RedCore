package me.red.events;

import me.red.redcore;
import me.red.utils.message;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class mentions implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        String messages = e.getMessage();
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (messages.contains(p.getName())){
                    messages = messages.replaceAll(redcore.config.getString("mention-tag") + p.getName(),redcore.config.getString("mention-color").replaceAll("&","§") + redcore.config.getString("mention-tag") + p.getName() + "§f");
                    e.setMessage(messages);
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5f, 1f);
                    if (redcore.config.getBoolean("mentions-message-bool"))
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.sendMessage(redcore.config.getString("mention-message"),p)));
                    }
                }
            }
        }
