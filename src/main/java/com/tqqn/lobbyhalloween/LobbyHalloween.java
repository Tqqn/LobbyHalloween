package com.tqqn.lobbyhalloween;

import com.tqqn.lobbyhalloween.commands.LightningSpawnCommand;
import com.tqqn.lobbyhalloween.tasks.RandomSpawnTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyHalloween extends JavaPlugin {

    private static LobbyHalloween instance;
    private PluginConfig pluginConfig;
    private RandomSpawnTask randomSpawnTask;

    @Override
    public void onEnable() {
        instance = this;
        pluginConfig = new PluginConfig(this);
        this.getCommand("spawnlightning").setExecutor(new LightningSpawnCommand());

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
}
