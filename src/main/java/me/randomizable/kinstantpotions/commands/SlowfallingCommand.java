package me.randomizable.kinstantpotions.commands;


import me.randomizable.kinstantpotions.kPotions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class SlowfallingCommand implements CommandExecutor, Listener {

    private kPotions plugin;

    public SlowfallingCommand(kPotions plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (player.hasPermission("kpotions.slowfall")) {
                if (kPotions.getInstance().getConfig().getBoolean("enable_slowfalling_command")) {
                    if (!player.hasPotionEffect(PotionEffectType.SLOW_FALLING)) {
                        if (kPotions.getInstance().getConfig().getBoolean("require_slowfall_onground")) {
                        /*

                        This fucking require on-ground took me forever to figure out because im dumb.

                         */
                            if (player.isOnGround()) {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("slowfalling_enabled")));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999999, 1));
                            } else if (!player.isOnGround()) {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("require_onground_message")));
                            }
                        } else if (!player.isDead()) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("slowfalling_enabled")));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999999, 1));
                        }
                    } else if (kPotions.getInstance().getConfig().getBoolean("require_slowfall_onground")) {
                        if (player.isOnGround()) {
                            player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("slowfalling_disabled")));
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("require_onground_message")));

                        }
                    } else {
                        player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("slowfalling_disabled")));
                    }

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("commands_disabled_message")));

                }
            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("no_permission")));

            }
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("players_only_message")));

        }
        return true;
    }
}