package com.tqqn.lobbyhalloween.scare;

import com.tqqn.lobbyhalloween.NMSUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class ScareTask extends BukkitRunnable {

    private int time = 10;

    private final Player player;
    private final int id;
    private final Location location;

    public ScareTask(Player player, int id) {
        this.player = player;
        this.id = id;
        this.location = player.getLocation();
    }

    @Override
    public void run() {

        if (time == 9) {
            location.setPitch(23);
            player.teleport(location);
            playScareSound(player);
        }

        if (time == 5) {
            location.setPitch(-10);
            player.teleport(location);
            playScareSound(player);
        }

        if (time == 2) {
            location.setPitch(-37);
            player.teleport(location);
            playScareSound(player);
        }

        if (time == 0) {
            cancel();
            player.removePotionEffect(PotionEffectType.BLINDNESS);
            NMSUtils.sendEntityDestroyPacket(player, id);
            return;
        }
        time--;
    }

    private void playScareSound(Player player) {
        player.playSound(location, Sound.ENTITY_ENDERMAN_SCREAM, 1F, 0.1F);
        player.playSound(location, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1F, 0.1F);
    }
}
