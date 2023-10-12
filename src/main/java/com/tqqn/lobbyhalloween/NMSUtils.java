package com.tqqn.lobbyhalloween;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class NMSUtils {

    public static void sendPacket(Player player, Packet packet) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
    }

    public static void sendEntitySpawnPacket(Player player, EntityLiving entity) {
        PacketPlayOutSpawnEntityLiving packetPlayOutSpawnEntityLiving = new PacketPlayOutSpawnEntityLiving(entity);
        sendPacket(player, packetPlayOutSpawnEntityLiving);
    }

    public static void sendEntityMetaDataPacket(Player player, int id, DataWatcher dataWatcher) {
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(id, dataWatcher, true);
        sendPacket(player, packetPlayOutEntityMetadata);
    }

    public static void sendEntityDestroyPacket(Player player, int id) {
        int[] entityIds = new int[]{id};
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(entityIds);
        sendPacket(player, packetPlayOutEntityDestroy);
    }

    public static void sendEntityHeadRotationPacket(Player player, int id) {
        PacketPlayOutEntityHeadRotation packetPlayOutEntityHeadRotation = new PacketPlayOutEntityHeadRotation();
    }

    public static float getAngle(Vector point1, Vector point2) {
        double dx = point2.getX() - point1.getX();
        double dz = point2.getZ() - point1.getZ();
        float angle = (float) Math.toDegrees(Math.atan2(dz, dx)) - 90;
        if (angle < 0) {
            angle += 360.0F;
        }
        return angle;
    }
}
