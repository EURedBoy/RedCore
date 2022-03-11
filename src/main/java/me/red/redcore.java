package me.red;

import dev.dejvokep.boostedyaml.YamlDocument;
import me.red.BroadCast.BroadCastEvent;
import me.red.Economy.compactmoney;
import me.red.Economy.money;
import me.red.Parkour.*;
import me.red.bossItem.customBossItem;
import me.red.bossItem.customItemBlockPlace;
import me.red.cmds.*;
import me.red.events.*;
import me.red.tabcompleter.homeTabCompleter;
import me.red.tabcompleter.warpListTabCompleter;
import me.red.utils.User;
import me.red.utils.configmanager;
import me.red.utils.jailUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class redcore extends JavaPlugin {

    private configmanager cfgm;
    public static YamlDocument config;
    @Override
    public void onEnable() {
        loadConfigManager();
        getServer().getPluginCommand("setspawn").setExecutor(new setSpawn());
        getServer().getPluginCommand("spawn").setExecutor(new spawn());
        getServer().getPluginCommand("sethome").setExecutor(new setHome());
        getServer().getPluginCommand("home").setExecutor(new home());
        getServer().getPluginCommand("home").setTabCompleter(new homeTabCompleter());
        getServer().getPluginCommand("displayitem").setExecutor(new displayItem());
        getServer().getPluginCommand("viewitem").setExecutor(new viewitem());
        getServer().getPluginCommand("fly").setExecutor(new fly());
        getServer().getPluginCommand("gamemode").setExecutor(new gamemode());
        getServer().getPluginCommand("gms").setExecutor(new gamemodeSurvival());
        getServer().getPluginCommand("gmc").setExecutor(new gamemodeCreative());
        getServer().getPluginCommand("gma").setExecutor(new gamemodeAdventure());
        getServer().getPluginCommand("gmsp").setExecutor(new gamemodeSpectator());
        getServer().getPluginCommand("flystaff").setExecutor(new flystaff());
        getServer().getPluginCommand("delhome").setExecutor(new delhome());
        getServer().getPluginCommand("delhome").setTabCompleter(new homeTabCompleter());
        getServer().getPluginCommand("setwarp").setExecutor(new setWarp());
        getServer().getPluginCommand("warp").setExecutor(new warp());
        getServer().getPluginCommand("delwarp").setExecutor(new delWarp());
        getServer().getPluginCommand("warp").setTabCompleter(new warpListTabCompleter());
        getServer().getPluginCommand("tp").setExecutor(new tp());
        getServer().getPluginCommand("tphere").setExecutor(new tphere());
        getServer().getPluginCommand("tpa").setExecutor(new tpa());
        getServer().getPluginCommand("tpaccept").setExecutor(new tpaccept());
        getServer().getPluginCommand("tpacancel").setExecutor(new tpacancel());
        getServer().getPluginCommand("tpahere").setExecutor(new tpahere());
        getServer().getPluginCommand("commandspy").setExecutor(new commandSpyToggle());
        getServer().getPluginCommand("msg").setExecutor(new msg());
        getServer().getPluginCommand("freeze").setExecutor(new freeze());
        getServer().getPluginCommand("announce").setExecutor(new announce());
        getServer().getPluginCommand("redcore").setExecutor(new redCore());
        getServer().getPluginCommand("uuid").setExecutor(new UUID());
        getServer().getPluginCommand("resoucepack").setExecutor(new resourcepack());
        getServer().getPluginCommand("reply").setExecutor(new reply());
        getServer().getPluginCommand("soldi").setExecutor(new money());
        getServer().getPluginCommand("soldicompatti").setExecutor(new compactmoney());
        getServer().getPluginCommand("checkpoint").setExecutor(new getParkourCheckPoint());
        getServer().getPluginCommand("back").setExecutor(new back());
        getServer().getPluginCommand("jail").setExecutor(new jailPlayer());
        getServer().getPluginCommand("setjail").setExecutor(new setJail());
        getServer().getPluginCommand("unjail").setExecutor(new unjailPlayer());
        getServer().getPluginManager().registerEvents(new backEvent(),this);
        getServer().getPluginManager().registerEvents(new dropItem(),this);
        getServer().getPluginManager().registerEvents(new blockCollision(),this);
        getServer().getPluginManager().registerEvents(new parkourTeleport(),this);
        getServer().getPluginManager().registerEvents(new blockParkourMove(),this);
        getServer().getPluginManager().registerEvents(new parkourJoinWorld(),this);
        getServer().getPluginManager().registerEvents(new triggerCheckPointEvent(),this);
        getServer().getPluginManager().registerEvents(new customItemBlockPlace(), this);
        getServer().getPluginManager().registerEvents(new mentions(),this);
        getServer().getPluginManager().registerEvents(new playerMoveEvent(),this);
        getServer().getPluginManager().registerEvents(new commandspy(),this);
        getServer().getPluginManager().registerEvents(new onPlayerJoin(),this);
        getServer().getPluginManager().registerEvents(new onPlayerLeft(),this);
        getServer().getPluginManager().registerEvents(new inventoryClickEvent(),this);
        getServer().getPluginManager().registerEvents(new playerDeathEvent(),this);
        getLogger().info("§bRedCore abilitato §acon Successo");
        getLogger().info("§a| §3Creato da: §eJwZy       §a|");
        getLogger().info("§a| §3Per: §9§lM§b§lK§r               §a|");
        new customBossItem().BossEffect();
        new BroadCastEvent().BroadCast();
        User.setSpawn();
        try {
            config = YamlDocument.create(new File(getDataFolder(), "config.yml"), getResource("config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //loadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadConfigManager(){
        cfgm = new configmanager();
        cfgm.setup();
        cfgm.savePlayers();
        cfgm.saveWarpsFile();
        cfgm.reloadPlayers();
        cfgm.reloadWarpsFile();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
