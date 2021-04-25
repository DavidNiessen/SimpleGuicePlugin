package net.skillcode.simpleguiceplugin.initializers;

import com.google.inject.Inject;
import com.google.inject.Injector;
import net.skillcode.simpleguiceplugin.interfaces.Initializer;
import net.skillcode.simpleguiceplugin.listeners.BlockBreakListener;
import net.skillcode.simpleguiceplugin.listeners.BlockPlaceListener;
import net.skillcode.simpleguiceplugin.listeners.PlayerQuitListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ListenerInitializer implements Initializer {

    private final JavaPlugin plugin;
    private final PluginManager pluginManager;

    /**
     * This is an example of constructor injection
     * <p>
     * The plugin manager will be automatically injected by guice {@link #pluginManager}
     *
     * @param pluginManager the plugin manager
     */
    @Inject
    public ListenerInitializer(final JavaPlugin plugin, final PluginManager pluginManager) {
        this.plugin = plugin;
        this.pluginManager = pluginManager;
    }

    @Override
    public void init(final @NotNull Injector injector) {
        pluginManager.registerEvents(injector.getInstance(PlayerQuitListener.class), plugin);
        pluginManager.registerEvents(injector.getInstance(BlockPlaceListener.class), plugin);
        pluginManager.registerEvents(injector.getInstance(BlockBreakListener.class), plugin);
    }
}
