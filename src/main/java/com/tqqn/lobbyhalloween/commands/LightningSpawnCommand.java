package com.tqqn.lobbyhalloween.commands;

import com.tqqn.lobbyhalloween.CustomLightning;
import com.tqqn.lobbyhalloween.utils.Messages;
import com.tqqn.lobbyhalloween.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        CustomLightning customLightning = new CustomLightning();
        customLightning.spawnLightning();
        return true;
    }
}
