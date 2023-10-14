package com.tqqn.lobbyhalloween.nms;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public interface ReflectionLayer {

    Map<Player, Integer> spawnedCustomEndermans = new HashMap<>();

    default void addSpawnedEntity(Player player, int id) {
        spawnedCustomEndermans.put(player, id);
    }

    default int getSpawnEntityId(Player player) {
        return spawnedCustomEndermans.get(player);
    }

    default void removeSpawnedEntity(Player player) {
        spawnedCustomEndermans.remove(player);
    }

    String getVersionString();

    void spawnCustomEnderman(Location location, Player player);

    void sendEntitySpawnPacket(Player player, Object packet);

    void sendEntityMetaDataPacket(Player player, int id, Object packet);

    void sendEntityDestroyPacket(Player player, int id);

    void sendPacket(Player player, Object packet);

}
