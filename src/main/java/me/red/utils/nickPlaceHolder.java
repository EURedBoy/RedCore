package me.red.utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.red.redcore;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class nickPlaceHolder extends PlaceholderExpansion {
    configmanager cfmg = new configmanager();
    private redcore plugin;
    public nickPlaceHolder(redcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "redcore";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Red";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null)
            return null;

        if (params.equalsIgnoreCase("nick")) {
            cfmg.setup();
            return cfmg.getPlayers().getString("Homes." + player.getUniqueId() + ".nick", player.getName());
        }
        return null;
    }
}
