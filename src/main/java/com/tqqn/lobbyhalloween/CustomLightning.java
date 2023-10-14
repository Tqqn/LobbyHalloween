package com.tqqn.lobbyhalloween;

import com.tqqn.lobbyhalloween.tasks.CustomBatsTask;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CustomLightning {

    private final Location location;

    public CustomLightning(Location location) {
        this.location = location;
    }

    /**
     * Spawns lightning, plays a enderman scream in a radius of 20 blocks and spawns 4 bats that will roam around for some seconds before disappearing.
     */
    public void spawnLightning() {
        location.getWorld().strikeLightningEffect(location);

        for (Entity entity : location.getWorld().getNearbyEntities(location, 20, 20, 20)) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, (float) 1, (float) 0.1);
            }
        }

        Map<Entity, Boolean> bats = new HashMap<>();

        location.add(0, 1, 0);

        for (int i = 0; i < 4; i++) {
            Bat bat = (Bat) location.getWorld().spawnEntity(location, EntityType.BAT);
            bat.setCustomNameVisible(true);
            bat.setInvulnerable(true);
            bat.setGlowing(true);
            bats.put(bat, false);
        }

        CustomBatsTask customBatsTask = new CustomBatsTask(bats);
        customBatsTask.runTaskTimer(LobbyHalloween.getInstance(), 0, 10L);
    }
}
