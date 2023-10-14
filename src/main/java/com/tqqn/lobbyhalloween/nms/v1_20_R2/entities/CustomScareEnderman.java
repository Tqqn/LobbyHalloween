package com.tqqn.lobbyhalloween.nms.v1_20_R2.entities;

import com.tqqn.lobbyhalloween.utils.PluginUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.util.Vector;

public class CustomScareEnderman extends EnderMan {

    public CustomScareEnderman(Location location, Player player) {
        super(EntityType.ENDERMAN, ((CraftWorld)player.getWorld()).getHandle());

        this.setPos(new Vec3(location.getX(), location.getY(), location.getZ()));
        // setHeadRotation
        this.setYHeadRot(PluginUtils.getAngle(new Vector(location.getX(), 0, location.getZ()), player.getLocation().toVector()));

        CraftPlayer craftPlayer = (CraftPlayer) player;

        this.setTarget(craftPlayer.getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        this.isAngryAt(craftPlayer.getHandle());
    }

}
