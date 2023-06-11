package de.tehmanu.funplugin.listener;

import de.tehmanu.funplugin.FunPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CowListener implements Listener {

    private final PotionEffect potionEffect;

    public CowListener() {
        potionEffect = new PotionEffect(PotionEffectType.JUMP, PotionEffect.INFINITE_DURATION, 100);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = ((Player) event.getDamager()).getPlayer();
            if (event.getEntity().getType() == EntityType.COW) {
                Cow cow = (Cow) event.getEntity();
                cow.addPotionEffect(potionEffect);
                Bukkit.getScheduler().scheduleSyncDelayedTask(FunPlugin.getPlugin(), () -> {
                    Bukkit.getWorlds().get(0).createExplosion(cow.getLocation(), 10);
                }, 20 * 10);
            }
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity().getType() == EntityType.COW) {
            Cow cow = (Cow) event.getEntity();
            Creeper creeper = (Creeper) Bukkit.getWorlds().get(0).spawnEntity(cow.getLocation(), EntityType.CREEPER);
            cow.addPassenger(creeper);
        }
    }
}
