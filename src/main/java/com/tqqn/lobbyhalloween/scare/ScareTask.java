package com.tqqn.lobbyhalloween.scare;

import com.tqqn.lobbyhalloween.LobbyHalloween;
import com.tqqn.lobbyhalloween.utils.PluginUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class ScareTask extends BukkitRunnable {

    private int time = 10;

    private final Player player;
    private final int id;
    private final Location location;

    private final ItemStack helmet;
    private final ItemStack pumpkin = new ItemStack(Material.CARVED_PUMPKIN);

    public ScareTask(Player player, int id) {
        this.player = player;
        this.id = id;
        this.location = player.getLocation();
        this.helmet = player.getInventory().getHelmet();
    }

    @Override
    public void run() {

        if (time == 9) {
            location.setPitch(23);
            player.teleport(location);
            playScareSound(player);
            addPumpkin(player);
            addBlindness(player);
        }

        if (time == 7) {
            removePumpkin(player);
            removeBlindness(player);
        }

        if (time == 5) {
            location.setPitch(-10);
            player.teleport(location);
            playScareSound(player);
            addPumpkin(player);
            addBlindness(player);
        }

        if (time == 3) {
            removePumpkin(player);
            removeBlindness(player);
        }

        if (time == 2) {
            location.setPitch(-37);
            player.teleport(location);
            playScareSound(player);
            addPumpkin(player);
            addBlindness(player);
        }

        if (time == 0) {
            cancel();
            removePumpkin(player);
            removeBlindness(player);
            if (helmet != null) {
                player.getInventory().setHelmet(helmet);
            }
            LobbyHalloween.getReflectionLayer().sendEntityDestroyPacket(player, id);
            return;
        }
        time--;
    }

    private void playScareSound(Player player) {
        player.playSound(location, Sound.ENTITY_ENDERMAN_SCREAM, 1F, 0.1F);
        player.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1F, 0.1F);
    }

    private void addPumpkin(Player player) {
        player.getInventory().setHelmet(pumpkin);
    }
    private void removePumpkin(Player player) {
        player.getInventory().setHelmet(new ItemStack(Material.AIR));
    }

    private void addBlindness(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 4));
    }
    private void removeBlindness(Player player) {
        player.removePotionEffect(PotionEffectType.BLINDNESS);
    }



}
