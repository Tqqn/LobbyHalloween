package com.tqqn.lobbyhalloween.tasks;

import com.tqqn.lobbyhalloween.CustomLightning;
import com.tqqn.lobbyhalloween.LobbyHalloween;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class RandomSpawnTask extends BukkitRunnable {

    private final int standardTime;
    private int time;

    public RandomSpawnTask(int standardTime) {
        this.standardTime = standardTime;
        time = standardTime;
    }

    @Override
    public void run() {
        if (!LobbyHalloween.getInstance().shouldLightningSpawn()) {
            return;
        }
        if (time == 0) {
            CustomLightning customLightning = new CustomLightning();
            customLightning.spawnLightning();
            time = standardTime;
        }
        time--;
    }

}
