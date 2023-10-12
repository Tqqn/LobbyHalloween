package com.tqqn.lobbyhalloween.scare;

import com.tqqn.lobbyhalloween.Utils;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.util.Vector;

public class CustomScareEnderman extends EntityEnderman {

    public CustomScareEnderman(EntityTypes<? extends EntityEnderman> entitytypes, World world, Location location, Player player) {
        super(entitytypes, world);
        this.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), 40);
        this.setHeadRotation(Utils.getAngle(new Vector(location.getX(), 0, location.getZ()), player.getLocation().toVector()));

        CraftPlayer craftPlayer = (CraftPlayer) player;

        this.setGoalTarget(craftPlayer.getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        this.a_(craftPlayer.getHandle());
    }
}
