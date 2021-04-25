package net.skillcode.simpleguiceplugin;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import net.skillcode.simpleguiceplugin.dependencyinjection.SGBinderModule;
import net.skillcode.simpleguiceplugin.initializers.CommandInitializer;
import net.skillcode.simpleguiceplugin.initializers.ListenerInitializer;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleGuicePlugin extends JavaPlugin {

    @Inject
    private ListenerInitializer listenerInitializer;
    @Inject
    private CommandInitializer commandInitializer;

    @Override
    public void onEnable() {
        final Injector injector = Guice.createInjector(new SGBinderModule(this)); //create the injector
        injector.injectMembers(this); // Inject members of this object

        listenerInitializer.init(injector);
        commandInitializer.init(injector);
    }
}
