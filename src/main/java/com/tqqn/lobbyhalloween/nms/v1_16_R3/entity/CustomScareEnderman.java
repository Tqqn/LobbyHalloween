package com.tqqn.lobbyhalloween.nms.v1_16_R3.entity;

import com.tqqn.lobbyhalloween.utils.PluginUtils;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.util.Vector;

public class CustomScareEnderman extends EntityEnderman {

    /**
     * Spawns a custom enderman entity that will have no ai, will direct its head to the players location
     */
    public CustomScareEnderman(Location location, Player player) {
        super(EntityTypes.ENDERMAN, ((CraftWorld)player.getWorld()).getHandle());
        this.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), 54);
        this.setHeadRotation(PluginUtils.getAngle(new Vector(location.getX(), 0, location.getZ()), player.getLocation().toVector()));

        CraftPlayer craftPlayer = (CraftPlayer) player;

        this.setGoalTarget(craftPlayer.getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        this.a_(craftPlayer.getHandle());
    }
}
