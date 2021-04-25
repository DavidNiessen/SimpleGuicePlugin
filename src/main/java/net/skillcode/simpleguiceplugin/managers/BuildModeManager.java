package net.skillcode.simpleguiceplugin.managers;

import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import net.skillcode.simpleguiceplugin.annotations.PostConstruct;
import net.skillcode.simpleguiceplugin.interfaces.Registrable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Singleton
public class BuildModeManager implements Registrable {

    private List<Player> buildMode;

    /**
     * Will be called on instantiation
     *
     * @see net.skillcode.simpleguiceplugin.dependencyinjection.SGBinderModule#hear
     */
    @PostConstruct
    public void init() {
        buildMode = new CopyOnWriteArrayList<>();
    }

    @Override
    public void register(final @NotNull Player player) {
        buildMode.add(player);
    }

    @Override
    public void unregister(final @NotNull Player player) {
        buildMode.remove(player);
    }

    /**
     * Checks if the player is in build mode
     *
     * @param player the player
     * @return whether the player is in build mode or not
     */
    @Override
    public boolean isRegistered(final @NotNull Player player) {
        return buildMode.contains(player);
    }

}
