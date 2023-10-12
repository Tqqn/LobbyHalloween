package com.tqqn.lobbyhalloween;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class PluginConfig {

    private final LobbyHalloween plugin;

    public PluginConfig(LobbyHalloween plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    public List<Location> getLightningSpawnLocations() {
        List<Location> spawnLightningLocations = new ArrayList<>();
        for (String key : plugin.getConfig().getConfigurationSection("lightning").getKeys(false)) {
            spawnLightningLocations.add(new Location(Bukkit.getWorld(plugin.getConfig().getString("lightning." + key + ".world")),
                    plugin.getConfig().getDouble("lightning." + key + ".x"),
                    plugin.getConfig().getDouble("lightning." + key + ".y"),
                    plugin.getConfig().getDouble("lightning." + key + ".z")));
        }
        return spawnLightningLocations;
    }
}
