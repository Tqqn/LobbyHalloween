package com.tqqn.lobbyhalloween.tasks;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class CustomBatsTask extends BukkitRunnable {

    private int ticks = 10;

    private final Map<Entity, Boolean> entities;

    public CustomBatsTask(Map<Entity, Boolean> entities) {
        this.entities = entities;
    }

    @Override
    public void run() {

        for (Map.Entry<Entity, Boolean> entryEntitie : entities.entrySet()) {
            entryEntitie.getKey().getLocation().getWorld().spawnParticle(Particle.SMOKE_LARGE, entryEntitie.getKey().getLocation(), 2);
            if (entryEntitie.getValue()) {
                entryEntitie.getKey().setCustomName(ChatColor.translateAlternateColorCodes('&', "&6Eng!"));
                entryEntitie.setValue(false);
            } else {
                entryEntitie.getKey().setCustomName(ChatColor.translateAlternateColorCodes('&', "&cEng!"));
                entryEntitie.setValue(true);
            }

        }

        if (ticks == 0) {
            cancel();
            for (Entity entity : entities.keySet()) {
                entity.getLocation().getWorld().spawnParticle(Particle.SPELL_WITCH, entity.getLocation(), 2);
                entity.remove();
            }
        }
        ticks--;
    }
}
