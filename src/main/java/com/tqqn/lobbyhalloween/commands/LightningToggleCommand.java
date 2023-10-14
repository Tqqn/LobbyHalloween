package com.tqqn.lobbyhalloween.commands;

import com.tqqn.lobbyhalloween.LobbyHalloween;
import com.tqqn.lobbyhalloween.utils.Messages;
import com.tqqn.lobbyhalloween.utils.PluginUtils;
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
            player.sendMessage(PluginUtils.translateColor(Messages.INVALID_ARGUMENTS.getMessage()));
            return false;
        } else {
            String message = "";
            if (args[0].equalsIgnoreCase("true")) {
                if (plugin.shouldLightningSpawn()) {
                    message = Messages.LIGHTNING_TOGGLE_IS_ENABLED.getMessage();
                } else {
                    message = Messages.LIGHTNING_TOGGLE_ENABLE.getMessage();
                    plugin.setShouldLightningSpawn(true);
                }
            } else if (args[0].equalsIgnoreCase("false")) {
                if (plugin.shouldLightningSpawn()) {
                    message = Messages.LIGHTNING_TOGGLE_DISABLE.getMessage();
                    plugin.setShouldLightningSpawn(false);
                } else {
                    message = Messages.LIGHTNING_TOGGLE_IS_DISABLED.getMessage();
                }
            }

            player.sendMessage(PluginUtils.translateColor(message));
        }
        return true;
    }

}
