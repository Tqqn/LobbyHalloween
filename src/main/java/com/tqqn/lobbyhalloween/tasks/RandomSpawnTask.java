package com.tqqn.lobbyhalloween.tasks;

import com.tqqn.lobbyhalloween.CustomLightning;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class RandomSpawnTask extends BukkitRunnable {

    private int time = 20;
    private final List<Location> lightningLocations;

    public RandomSpawnTask(List<Location> lightningLocations) {
        this.lightningLocations = lightningLocations;
    }

    @Override
    public void run() {
        if (time == 0) {
            Random random = new Random();
            Location randomLocation = lightningLocations.get(random.nextInt(lightningLocations.size()));
            if (randomLocation.getChunk().isLoaded()) {
                CustomLightning customLightning = new CustomLightning(randomLocation);
                customLightning.spawnLightning();
                System.out.println("spawned");
            } else {
                System.out.println("denied");
            }
            time = 20;
        }
        time--;
    }

}
