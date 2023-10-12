package com.tqqn.lobbyhalloween.commands;

import com.tqqn.lobbyhalloween.LobbyHalloween;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningToggleCommand implements CommandExecutor {

    private final LobbyHalloween plugin;

    public LightningToggleCommand(LobbyHalloween plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMissing arguments!"));
            return false;
        } else {
            String message = "";
            if (args[0].equalsIgnoreCase("true")) {
                if (plugin.shouldLightningSpawn()) {
                    message = "&cLightning is already enabled.";
                } else {
                    message = "&cYou enabled the lightning spawning.";
                    plugin.setShouldLightningSpawn(true);
                }
            } else if (args[0].equalsIgnoreCase("false")) {
                if (plugin.shouldLightningSpawn()) {
                    message = "&cYou disabled the lightning spawning.";
                    plugin.setShouldLightningSpawn(false);
                } else {
                    message = "&cLightning is already disabled.";
                }
            }

            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
        return true;
    }

}
