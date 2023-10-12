package com.tqqn.lobbyhalloween.tasks;

import com.tqqn.lobbyhalloween.CustomLightning;
import com.tqqn.lobbyhalloween.LobbyHalloween;
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
        if (!LobbyHalloween.getInstance().shouldLightningSpawn()) {
            return;
        }
        if (time == 0) {
            Random random = new Random();
            Location randomLocation = lightningLocations.get(random.nextInt(lightningLocations.size()));
                if (LobbyHalloween.getInstance().getPluginConfig().getRangeMode()) {
                    Location randomL = randomLocation.clone();
                    int range = LobbyHalloween.getInstance().getPluginConfig().getLightningRange();

                    randomL.add((random.nextBoolean() ? 1 : -1) * random.nextInt(range),
                            (random.nextBoolean() ? 1 : -1) * random.nextInt(range),
                            (random.nextBoolean() ? 1 : -1) * random.nextInt(range));
                    randomL.setY(randomL.getWorld().getHighestBlockYAt(randomL));
                    randomLocation = randomL;
                }
                CustomLightning customLightning = new CustomLightning(randomLocation);
                customLightning.spawnLightning();
            time = 20;
        }
        time--;
    }

}
