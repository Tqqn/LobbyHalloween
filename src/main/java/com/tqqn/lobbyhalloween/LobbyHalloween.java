package com.tqqn.lobbyhalloween;

import com.tqqn.lobbyhalloween.commands.LightningSpawnCommand;
import com.tqqn.lobbyhalloween.commands.LightningToggleCommand;
import com.tqqn.lobbyhalloween.commands.ScareCommand;
import com.tqqn.lobbyhalloween.nms.ReflectionLayer;
import com.tqqn.lobbyhalloween.tasks.RandomSpawnTask;
import com.tqqn.lobbyhalloween.utils.PluginConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyHalloween extends JavaPlugin {

    private static LobbyHalloween instance;
    private static ReflectionLayer reflectionLayer;
    private PluginConfig pluginConfig;
    private RandomSpawnTask randomSpawnTask;
    private boolean shouldLightningSpawn;

    @Override
    public void onEnable() {
        instance = this;
        findReflectionLayer();
        pluginConfig = new PluginConfig(this);
        shouldLightningSpawn = pluginConfig.getAllowLightningOption();
        this.getCommand("spawnlightning").setExecutor(new LightningSpawnCommand());
        this.getCommand("scare").setExecutor(new ScareCommand());
        this.getCommand("lightning").setExecutor(new LightningToggleCommand(this));

        randomSpawnTask = new RandomSpawnTask(pluginConfig.getLightningCooldown());
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

    public void findReflectionLayer() {
        String bukkitVersion = Bukkit.getServer().getClass().getPackage().getName();
        String version = bukkitVersion.substring(bukkitVersion.lastIndexOf('.') + 1);
        try {
            Class<?> nmsClass = Class.forName("com.tqqn.lobbyhalloween.nms." + version + "." + version);
            Bukkit.getLogger().info("Using reflection layer for version " + version);
            reflectionLayer = (ReflectionLayer) nmsClass.getConstructors()[0].newInstance();
        } catch (Exception ignored) {
            Bukkit.getLogger().info("This version is not supported - " + version);
            Bukkit.getServer().shutdown();
        }
    }

    public static ReflectionLayer getReflectionLayer() {
        return reflectionLayer;
    }
}
