package de.tehmanu.funplugin.listener;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class StickListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null && event.getItem().getType() == Material.STICK) {
            player.launchProjectile(Fireball.class);
        }
    }
}
