package com.dikahdoff.nsl;

import com.dikahdoff.nsl.commands.CommandHandler;
import com.dikahdoff.nsl.events.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class NSL extends JavaPlugin {
    @Override
    public void onEnable() {
        CommandHandler commandHandler = new CommandHandler();
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getCommand("nsl").setExecutor(commandHandler);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "["+getPlugin(this.getClass()).getDescription().getName().toString()+"] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "["+getPlugin(this.getClass()).getDescription().getName().toString()+"] Plugin disabled!");
    }
}
