package com.tqqn.lobbyhalloween;

import com.tqqn.lobbyhalloween.tasks.CustomBatsTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CustomLightning {

    /**
     * Spawns lightning at a random players location, plays a enderman scream in a radius of 10 blocks and spawns 4 bats that will roam around for some seconds before disappearing.
     */
    public void spawnLightning() {

        if (Bukkit.getOnlinePlayers().isEmpty()) return;

        Random random = new Random();
        Player player = (Player) Bukkit.getOnlinePlayers().toArray()[random.nextInt(Bukkit.getOnlinePlayers().size())];

        Location randomL = player.getLocation();

        randomL.add((random.nextBoolean() ? 1 : -1) * random.nextInt(10),
                (random.nextBoolean() ? 1 : -1) * random.nextInt(10),
                (random.nextBoolean() ? 1 : -1) * random.nextInt(10));
        randomL.setY(randomL.getWorld().getHighestBlockYAt(randomL));

        randomL.getWorld().strikeLightningEffect(randomL);

        for (Entity entity : randomL.getWorld().getNearbyEntities(randomL, 10, 10, 10)) {
            if (entity instanceof Player) {
                Player player2 = (Player) entity;
                player2.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, (float) 1, (float) 0.1);
            }
        }

        Map<Entity, Boolean> bats = new HashMap<>();

        randomL.add(0, 1, 0);

        for (int i = 0; i < 4; i++) {
            Bat bat = (Bat) randomL.getWorld().spawnEntity(randomL, EntityType.BAT);
            bat.setCustomNameVisible(true);
            bat.setInvulnerable(true);
            bat.setGlowing(true);
            bats.put(bat, false);
        }

        CustomBatsTask customBatsTask = new CustomBatsTask(bats);
        customBatsTask.runTaskTimer(LobbyHalloween.getInstance(), 0, 10L);
    }
}
