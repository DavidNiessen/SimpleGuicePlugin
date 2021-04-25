package net.skillcode.simpleguiceplugin.initializers;

import com.google.inject.Inject;
import com.google.inject.Injector;
import net.skillcode.simpleguiceplugin.commands.BuildCommand;
import net.skillcode.simpleguiceplugin.interfaces.Initializer;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CommandInitializer implements Initializer {

    @Inject
    private JavaPlugin javaPlugin; // An example of field injection

    @Override
    public void init(final @NotNull Injector injector) {
        javaPlugin.getCommand("build").setExecutor(injector.getInstance(BuildCommand.class));
    }
}
