package com.dikahdoff.nsl.commands;

import com.dikahdoff.nsl.NSL;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        // Handle /nsl
        if (cmd.getName().equalsIgnoreCase("nsl") || cmd.getName().equalsIgnoreCase("nostrippedlog") || cmd.getName().equalsIgnoreCase("nostrippedlogs")) {
            if (args.length != 0) {
                player.sendMessage(ChatColor.GREEN + "> " + ChatColor.GRAY + NSL.getPlugin(NSL.class).getDescription().getName() + " | Version: " + NSL.getPlugin(NSL.class).getDescription().getVersion().toString());
            } else {
                player.sendMessage(ChatColor.GOLD + "> " + ChatColor.GRAY + "This server is using " + NSL.getPlugin(NSL.class).getDescription().getName() + " by dikahdoff (Version: " + NSL.getPlugin(NSL.class).getDescription().getVersion().toString() + ")");
                player.sendMessage(ChatColor.GOLD + "> " + ChatColor.GRAY + "Download here: https://github.com/dikahdoff/NoStrippedLog");
            }
        }
        return true;
    }
}
