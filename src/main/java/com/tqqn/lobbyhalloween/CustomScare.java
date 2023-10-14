package com.tqqn.lobbyhalloween;

import com.tqqn.lobbyhalloween.scare.ScareTask;
import com.tqqn.lobbyhalloween.utils.Permissions;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomScare {

    private final Player player;

    public CustomScare(Player player) {
        this.player = player;
    }

    public void scare() {
        if (player.hasPermission(Permissions.SCARE_IMMUM.getPermission())) return;

        Location endermanLocation = player.getLocation().add(player.getLocation().getDirection().multiply(1));
        endermanLocation.setY(endermanLocation.getY()-0.5);

        LobbyHalloween.getReflectionLayer().spawnCustomEnderman(endermanLocation, player);

        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 4));

        ScareTask scareTask = new ScareTask(player, LobbyHalloween.getReflectionLayer().getSpawnEntityId(player));
        scareTask.runTaskTimer(LobbyHalloween.getInstance(), 0, 5L);
    }
}
