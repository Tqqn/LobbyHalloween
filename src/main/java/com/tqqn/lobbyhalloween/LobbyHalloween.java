package com.tqqn.lobbyhalloween;

import com.tqqn.lobbyhalloween.commands.LightningSpawnCommand;
import com.tqqn.lobbyhalloween.commands.LightningToggleCommand;
import com.tqqn.lobbyhalloween.commands.ScareCommand;
import com.tqqn.lobbyhalloween.tasks.RandomSpawnTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyHalloween extends JavaPlugin {

    private static LobbyHalloween instance;
    private PluginConfig pluginConfig;
    private RandomSpawnTask randomSpawnTask;
    private boolean shouldLightningSpawn = true;

    @Override
    public void onEnable() {
        instance = this;
        pluginConfig = new PluginConfig(this);
        this.getCommand("spawnlightning").setExecutor(new LightningSpawnCommand());
        this.getCommand("scare").setExecutor(new ScareCommand());
        this.getCommand("lightning").setExecutor(new LightningToggleCommand(this));

        randomSpawnTask = new RandomSpawnTask(pluginConfig.getLightningSpawnLocations());
        randomSpawnTask.runTaskTimer(this, 0, 20L);
    }

    @Override
    public void onDisable() {
        instance = null;
        pluginConfig = null;
        randomSpawnTask.cancel();
        randomSpawnTask = null;
    }

    public static LobbyHalloween getInstance() {
        return instance;
    }

    public PluginConfig getPluginConfig() {
        return pluginConfig;
    }

    public void setShouldLightningSpawn(boolean shouldSpawn) {
        this.shouldLightningSpawn = shouldSpawn;
    }

    public boolean shouldLightningSpawn() {
        return shouldLightningSpawn;
    }
}
