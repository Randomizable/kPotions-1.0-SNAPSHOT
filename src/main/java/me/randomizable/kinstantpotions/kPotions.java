package me.randomizable.kinstantpotions;

import me.randomizable.kinstantpotions.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;



public final class kPotions extends JavaPlugin {

    private static kPotions instance;


    public static kPotions getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getCommand("speed").setExecutor(new SpeedCommand(this));
        getCommand("strength").setExecutor(new StrengthCommand(this));
        getCommand("invisibility").setExecutor(new InvisCommand(this));
        getCommand("fireresistance").setExecutor(new FireresCommand(this));
        getCommand("nightvision").setExecutor(new NightvisionCommand(this));
        getCommand("waterbreathing").setExecutor(new WaterbreathingCommand(this));
        getCommand("jumpboost").setExecutor(new JumpboostCommand(this));
        getCommand("slowfalling").setExecutor(new SlowfallingCommand(this));
        getCommand("haste").setExecutor(new HasteCommand(this));
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + ChatColor.STRIKETHROUGH + "-----------------------------------");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "                                ");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "                                ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA.toString() + "------ x kPotions Injected x ------");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "                                ");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "                                ");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "------- Welcome To kPotions -------");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "------x--By Randomizable--x---------");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "                                ");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + "                                ");
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE.toString() + ChatColor.STRIKETHROUGH + "-----------------------------------");
        loadConfig();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}