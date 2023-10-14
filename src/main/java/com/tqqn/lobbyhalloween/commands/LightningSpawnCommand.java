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
        Player player = (Player) sender;

        if (args.length < 1 || Bukkit.getPlayer(args[0]) == null) {
            player.sendMessage(PluginUtils.translateColor(Messages.PLAYER_NOT_ONLINE.getMessage()));
            return false;
        } else {
            player.sendMessage(PluginUtils.translateColor("&cYou spawned lightning at &l" + Bukkit.getPlayer(args[0]).getName() + "'s &r&clocation!"));
            Location location = Bukkit.getPlayer(args[0]).getLocation();

            CustomLightning customLightning = new CustomLightning(location);
            customLightning.spawnLightning();
        }
        return true;
    }
}
