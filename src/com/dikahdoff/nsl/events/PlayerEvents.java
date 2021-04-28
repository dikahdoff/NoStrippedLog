package com.dikahdoff.nsl.events;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Locale;

public class PlayerEvents implements Listener {
    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent event) {
        // Handler for PlayerInteract event
        Player player = event.getPlayer();
        if(!player.hasPermission("nsl.bypass")) {
            if (event.getClickedBlock() != null && event.getItem().getType() != null) {
                BlockData block = event.getClickedBlock().getBlockData();
                if(block.getMaterial().name().toString().toLowerCase(Locale.ROOT).endsWith("_log") || block.getMaterial() == Material.CRIMSON_STEM || block.getMaterial() == Material.WARPED_STEM) {
                    if (event.getItem().getType().name().toLowerCase(Locale.ROOT).endsWith("_axe") && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        // Block is a log, item in hand is an axe and the right click on block interaction should be canceled.
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
