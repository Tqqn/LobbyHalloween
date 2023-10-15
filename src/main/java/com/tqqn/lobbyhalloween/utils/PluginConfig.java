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
     * Returns a boolean from the allow-lightning field from the config.
     * @return boolean
     */
    public boolean getAllowLightningOption() {
        return plugin.getConfig().getBoolean("allow-lightning");
    }

    public int getLightningCooldown() {
        return plugin.getConfig().getInt("lightning-cooldown");
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
