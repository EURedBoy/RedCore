package me.red.bossItem;

import me.red.redcore;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class customItemBlockPlace implements Listener {
    redcore plugin = redcore.getPlugin(redcore.class);
    public static HashMap<Player,Boolean> ability = new HashMap<>();
    public static List<Player> medusa = new ArrayList<>();
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(e.getItemInHand().getItemMeta() == null) return;
        ItemMeta itemM = e.getItemInHand().getItemMeta();
        if (itemM.getDisplayName().equals("§8| §6Blocco di Monete §8|") || itemM.getDisplayName().equals("§8| §6Blocco Di Bronzo Compattato §8|")
                || itemM.getDisplayName().equals("§8| §bPezzo Degli Stivali Della Velocita' §8|") || itemM.getDisplayName().equals("§8| §7Blocco Di Gomma §8|")
                || itemM.getDisplayName().equals("§8| §cCaldaia §7(Treno) §8|") || itemM.getDisplayName().equals("§8| §cCiminiera §7(Treno) §8|")
                || itemM.getDisplayName().equals("§8| §6Copper Rinforzato §8|") || itemM.getDisplayName().equals("§8| §eCore Giallo §7(Macchina) §8|")
                || itemM.getDisplayName().equals("§8| §7Core Lento §7(Treno) §8|") || itemM.getDisplayName().equals("§8| §5Core Magenta §7(Macchina) §8|")
                || itemM.getDisplayName().equals("§8| §7Core Nero §7(Macchina) §8|") || itemM.getDisplayName().equals("§8| §c§lTesta di Cerbero §8|")){
            e.setCancelled(true);
        }
        if (itemM.hasCustomModelData()){
            if (itemM.getCustomModelData() == 1 || itemM.getCustomModelData() == 2 || itemM.getCustomModelData() == 3){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onClickEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
            if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.isSneaking()){
                if(p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getItemMeta() != null) {
                    if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§8| §6§lTesta di Magnus §8|")){
                        if (!(ability.get(p))){
                            p.sendMessage("§c[!] Devi aspettare ancora prima di riusare l'abilità");
                            return;
                        }
                        for (Player player : Bukkit.getOnlinePlayers()){
                            if (player.getWorld().equals(p.getWorld())){
                                if (player.getLocation().distance(p.getLocation()) <= 10)
                                    player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL,100,0.5f);
                            }
                        }
                        p.sendTitle("§a§lHai usato l'abilita","§6§ldel Magnus");
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL,100,0.5f);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,120,5,false,false,false));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,120,1,false,false,false));
                        ability.put(p,false);
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                            ability.put(p,true);
                        }, 600L);
                    }else if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§8| §3§lTesta di Medusa §8|")){
                        if (!(ability.get(p))){
                            p.sendMessage("§c[!] Devi aspettare ancora prima di riusare l'abilità");
                            return;
                        }
                        for (Player player : Bukkit.getOnlinePlayers()){
                            if (player.getWorld().equals(p.getWorld())){
                                if (player.getLocation().distance(p.getLocation()) <= 6){
                                    if (player != p){
                                        player.sendTitle("§c§lSei stato bloccato","§3§lda Medusa");
                                        medusa.add(player);
                                        player.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK,100,1f);
                                    }
                                }
                            }
                        }
                        p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK,100,1f);
                        p.sendMessage("§3Hai §cbloccato §3per §a7 §3secondi tutti i giocatori nel raggio di §a6 §3blocchi");
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                            medusa.clear();
                        }, 140L);
                        ability.put(p,false);
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                            ability.put(p,true);
                        }, 600L);
                    }
                }
            }
        }
    }
