package net.skillcode.simpleguiceplugin.listeners;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.skillcode.simpleguiceplugin.managers.BuildModeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

@Singleton
public class PlayerQuitListener implements Listener {

    @Inject
    private BuildModeManager buildModeManager; // An example of field injection

    @EventHandler
    public void onQuit(final @NotNull PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        if (buildModeManager.isRegistered(player)) {
            buildModeManager.unregister(player);
        }
    }

}
