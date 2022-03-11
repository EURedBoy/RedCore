package me.red.utils;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class configmanager {
    private redcore plugin = redcore.getPlugin(redcore.class);

    // Files & File Configs Here
    public FileConfiguration playerscfg;
    public FileConfiguration warpscfg;
    public File playersfile;
    public File warpsfile;
    // --------------------------

    public void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        playersfile = new File(plugin.getDataFolder(), "players.yml");
        warpsfile = new File(plugin.getDataFolder(), "warps.yml");

        if (!playersfile.exists()) {
            try {
                playersfile.createNewFile();
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The players.yml file has been created");
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender()
                        .sendMessage(ChatColor.RED + "Could not create the players.yml file");
            }
        }
        if (!warpsfile.exists()){
            try {
                warpsfile.createNewFile();
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "warps.yml file e' stato creato");
            } catch (IOException e){
                Bukkit.getServer().getConsoleSender()
                        .sendMessage(ChatColor.RED + "Non e' stato possibile creare il file warps.yml");
            }
        }
        warpscfg = YamlConfiguration.loadConfiguration(warpsfile);
        playerscfg = YamlConfiguration.loadConfiguration(playersfile);
    }

    public FileConfiguration getPlayers() {
        return playerscfg;
    }

    public FileConfiguration getWarpsFile(){
        return warpscfg;
    }

    public void savePlayers() {
        try {
            playerscfg.save(playersfile);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the players.yml file");
        }
    }

    public void saveWarpsFile() {
        try {
            warpscfg.save(warpsfile);
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "The warps.yml file has been saved");

        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the warps.yml file");
        }
    }

    public void reloadPlayers() {
        playerscfg = YamlConfiguration.loadConfiguration(playersfile);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "The players.yml file has been reload");
    }

    public void reloadWarpsFile() {
        warpscfg = YamlConfiguration.loadConfiguration(warpsfile);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "The warps.yml file has been reload");
    }
}
