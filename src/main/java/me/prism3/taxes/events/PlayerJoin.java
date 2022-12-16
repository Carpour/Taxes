package me.prism3.taxes.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerJoin implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();
        final UUID playerUUID = player.getUniqueId();
        final String playerName = player.getName();

        this.playerChecker(playerUUID, playerName);


    }

    private void playerChecker(UUID playerUUID, String playerName) {

        final Map<UUID, String> joinedPlayers = new HashMap<>();

        joinedPlayers.putIfAbsent(playerUUID, playerName);
    }
}
