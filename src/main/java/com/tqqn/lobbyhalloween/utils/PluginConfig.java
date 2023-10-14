package com.tqqn.lobbyhalloween.utils;

import com.tqqn.lobbyhalloween.LobbyHalloween;
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

    /**
     * Returns a List with the lightning spawn locations from the config.
     * @return List<Locations> list
     */
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

    /**
     * Returns a boolean from the allow-lightning field from the config.
     * @return boolean
     */
    public boolean getAllowLightningOption() {
        return plugin.getConfig().getBoolean("allow-lightning");
    }

    /**
     * Returns a boolean from the range-mode field from the config.
     * @return boolean
     */
    public boolean getRangeMode() {
        return plugin.getConfig().getBoolean("range-mode");
    }

    /**
     * Returns a boolean from the range field from the config.
     * @return boolean
     */
    public int getLightningRange() {
        return plugin.getConfig().getInt("range");
    }

    /**
     * Returns a boolean from the bat-name field from the config.
     * @return boolean
     */
    public String getBatName() {
        return plugin.getConfig().getString("bat-name");
    }

    /**
     * Returns a boolean from the bat-color1 field from the config.
     * @return boolean
     */
    public String getBatColor1() {
        return plugin.getConfig().getString("bat-color1");
    }

    /**
     * Returns a boolean from the bat-color2 field from the config.
     * @return boolean
     */
    public String getBatColor2() {
        return plugin.getConfig().getString("bat-color2");
    }
}
