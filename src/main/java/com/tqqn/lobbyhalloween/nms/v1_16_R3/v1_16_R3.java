package com.tqqn.lobbyhalloween.nms.v1_16_R3;

import com.tqqn.lobbyhalloween.nms.ReflectionLayer;
import com.tqqn.lobbyhalloween.nms.v1_16_R3.entity.CustomScareEnderman;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class v1_16_R3 implements ReflectionLayer {


    @Override
    public String getVersionString() {
        return "1.16.4";
    }

    @Override
    public void spawnCustomEnderman(Location location, Player player) {
        CustomScareEnderman customScareEnderman = new CustomScareEnderman(location, player);
        sendEntitySpawnPacket(player, customScareEnderman);
        sendEntityMetaDataPacket(player, customScareEnderman.getId(), customScareEnderman.getDataWatcher());
        addSpawnedEntity(player, customScareEnderman.getId());
    }

    @Override
    public void sendEntitySpawnPacket(Player player, Object entity) {
        PacketPlayOutSpawnEntityLiving packetPlayOutSpawnEntityLiving = new PacketPlayOutSpawnEntityLiving((EntityLiving) entity);
        sendPacket(player, packetPlayOutSpawnEntityLiving);
    }

    @Override
    public void sendEntityMetaDataPacket(Player player, int id, Object dataWatcher) {
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(id, (DataWatcher) dataWatcher, true);
        sendPacket(player, packetPlayOutEntityMetadata);
    }

    @Override
    public void sendEntityDestroyPacket(Player player, int id) {
        int[] entityIds = new int[]{id};
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(entityIds);
        sendPacket(player, packetPlayOutEntityDestroy);
        removeSpawnedEntity(player);
    }

    @Override
    public void sendPacket(Player player, Object packet) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet<?>)packet);
    }
}
