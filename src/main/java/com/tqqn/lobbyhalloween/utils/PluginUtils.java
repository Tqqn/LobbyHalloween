package com.tqqn.lobbyhalloween.utils;

import org.bukkit.ChatColor;
import org.bukkit.util.Vector;

public class PluginUtils {

    public static String translateColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
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
