package com.tqqn.lobbyhalloween.commands;

import com.tqqn.lobbyhalloween.CustomScare;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScareCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (args.length < 1 || Bukkit.getPlayer(args[0]) == null) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis player is not online!"));
            return false;
        } else {
            CustomScare customScare = new CustomScare(Bukkit.getPlayer(args[0]));
            customScare.scare();
        }
        return true;
    }
}
