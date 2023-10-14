package com.tqqn.lobbyhalloween.nms.v1_20_R2;

import com.tqqn.lobbyhalloween.nms.ReflectionLayer;
import com.tqqn.lobbyhalloween.nms.v1_20_R2.entities.CustomScareEnderman;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class v1_20_R2 implements ReflectionLayer {


    @Override
    public String getVersionString() {
        return "1.20.2";
    }

    @Override
    public void spawnCustomEnderman(Location location, Player player) {
        CustomScareEnderman customScareEnderman = new CustomScareEnderman(location, player);
        sendEntitySpawnPacket(player, customScareEnderman);
        sendEntityMetaDataPacket(player, customScareEnderman.getId(), customScareEnderman.getEntityData());
        addSpawnedEntity(player, customScareEnderman.getId());
    }

    @Override
    public void sendEntitySpawnPacket(Player player, Object entity) {
        ClientboundAddEntityPacket clientboundAddEntityPacket = new ClientboundAddEntityPacket((Entity) entity);
        sendPacket(player, clientboundAddEntityPacket);
    }

    @Override
    public void sendEntityMetaDataPacket(Player player, int id, Object dataWatcher) {
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(id, ((SynchedEntityData) dataWatcher).packDirty());
        sendPacket(player, clientboundSetEntityDataPacket);
    }

    @Override
    public void sendEntityDestroyPacket(Player player, int id) {
        int[] entityIds = new int[]{id};
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(entityIds);
        sendPacket(player, clientboundRemoveEntitiesPacket);
        removeSpawnedEntity(player);
    }

    @Override
    public void sendPacket(Player player, Object o) {
        Packet packet = (Packet) o;
        ((CraftPlayer)player).getHandle().connection.send(packet);
    }
}
