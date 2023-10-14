package com.tqqn.lobbyhalloween.utils;

public enum Permissions {

    SCARE_IMMUM("lobbyhalloween.scare.immum");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
