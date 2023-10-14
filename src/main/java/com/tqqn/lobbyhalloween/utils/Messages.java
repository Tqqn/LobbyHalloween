package com.tqqn.lobbyhalloween.utils;

public enum Messages {

    NO_PERMISSION("&cYou do not have permission to do that."),
    INVALID_ARGUMENTS("&cWrong arguments!"),
    PLAYER_NOT_ONLINE("&cThis player is not online or the name is wrong."),
    LIGHTNING_TOGGLE_ENABLE("&aYou enabled the lightning spawning."),
    LIGHTNING_TOGGLE_IS_ENABLED("&aLightning spawning is already enabled."),
    LIGHTNING_TOGGLE_DISABLE("&cYou disabled the lightning spawning."),
    LIGHTNING_TOGGLE_IS_DISABLED("&cLightning spawning is already disabled.");

    private final String message;
    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
