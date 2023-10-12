package com.tqqn.lobbyhalloween.commands;

import com.tqqn.lobbyhalloween.CustomScare;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScareCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        CustomScare customScare = new CustomScare(player);
        customScare.scare();

        return true;
    }
}
