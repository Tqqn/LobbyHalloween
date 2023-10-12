package com.tqqn.lobbyhalloween;

import com.tqqn.lobbyhalloween.scare.CustomScareEnderman;
import com.tqqn.lobbyhalloween.scare.ScareTask;
import net.minecraft.server.v1_16_R3.EntityTypes;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomScare {

    private final Player player;

    public CustomScare(Player player) {
        this.player = player;
    }

    public void scare() {
        Location endermanLocation = player.getLocation().add(player.getLocation().getDirection().multiply(1));

        CustomScareEnderman customScareEnderman = new CustomScareEnderman(EntityTypes.ENDERMAN, ((CraftWorld)player.getWorld()).getHandle(), endermanLocation, player);
        Utils.sendEntitySpawnPacket(player, customScareEnderman);
        Utils.sendEntityMetaDataPacket(player, customScareEnderman.getId(), customScareEnderman.getDataWatcher());

        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 4));

        ScareTask scareTask = new ScareTask(player, customScareEnderman.getId());
        scareTask.runTaskTimer(LobbyHalloween.getInstance(), 0, 5L);
    }
}
