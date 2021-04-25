package net.skillcode.simpleguiceplugin.commands;

import com.google.inject.Inject;
import net.skillcode.simpleguiceplugin.managers.BuildModeManager;
import net.skillcode.simpleguiceplugin.utils.Constants;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    @Inject
    private BuildModeManager buildModeManager; // An example of field injection

    @Override
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        if (!(commandSender instanceof Player)) {
            return true;
        }
        final Player player = (Player) commandSender;

        if (buildModeManager.isRegistered(player)) {
            buildModeManager.unregister(player);
            player.sendMessage(Constants.BUILD_MODE_OFF);
            player.setGameMode(GameMode.SURVIVAL);
        } else {
            buildModeManager.register(player);
            player.sendMessage(Constants.BUILD_MODE_ON);
            player.setGameMode(GameMode.CREATIVE);
        }
        return false;
    }
}
