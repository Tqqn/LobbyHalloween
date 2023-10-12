package com.tqqn.lobbyhalloween;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

    public boolean getRangeMode() {
        return plugin.getConfig().getBoolean("range-mode");
    }

    public int getLightningRange() {
        return plugin.getConfig().getInt("range");
    }

    public String getBatName() {
        return plugin.getConfig().getString("bat-name");
    }

    public String getBatColor1() {
        return plugin.getConfig().getString("bat-color1");
    }

    public String getBatColor2() {
        return plugin.getConfig().getString("bat-color2");
    }
}
