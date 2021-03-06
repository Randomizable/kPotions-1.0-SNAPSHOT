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


public class FireresCommand implements CommandExecutor, Listener {

    private kPotions plugin;

    public FireresCommand(kPotions plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (kPotions.getInstance().getConfig().getBoolean("enable_fireres_command")) {
                if (player.hasPermission("kpotions.fireres")){
                    if (!player.isDead() && !player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("fireres_enabled")));

                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999, 1));
                    }else{
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("fireres_disabled")));
                        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("no_permission_message")));
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("commands_disabled_message")));
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("players_only_message")));
        }
        return true;
    }
}
