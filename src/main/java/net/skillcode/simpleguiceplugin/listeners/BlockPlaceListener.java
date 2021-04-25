package net.skillcode.simpleguiceplugin.listeners;

import com.google.inject.Inject;
import net.skillcode.simpleguiceplugin.managers.BuildModeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class BlockPlaceListener implements Listener {

    @Inject
    private BuildModeManager buildModeManager; // An example of field injection

    @EventHandler
    public void onPlace(final @NotNull BlockBreakEvent event) {
        final Player player = event.getPlayer();

        if (!buildModeManager.isRegistered(player)) {
            event.setCancelled(true);
        }
    }

}
