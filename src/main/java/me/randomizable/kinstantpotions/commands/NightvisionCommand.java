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


public class NightvisionCommand implements CommandExecutor, Listener {

    private kPotions plugin;

    public NightvisionCommand(kPotions plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (kPotions.getInstance().getConfig().getBoolean("enable_nightvision_command")) {
                if (player.hasPermission("kpotions.nightvision")){
                    if (!player.isDead() && !player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getInstance().getConfig().getString("nightvision_enabled")));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999999, 0));
                    }else{
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', kPotions.getInstance().getConfig().getString("nightvision_disabled")));
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
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
