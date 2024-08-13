package iiDanto.spawnV2.commands;

import iiDanto.spawnV2.SpawnV2;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    private final SpawnV2 plugin;

    public SetSpawnCommand(SpawnV2 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            Location location = p.getLocation();

            plugin.getConfig().set("spawn", location);

            plugin.saveConfig();
            p.sendMessage(ChatColor.GREEN + "The spawn has successfully been set to your location.");
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING,1.0f, 2.0f);

        }

        return true;
    }
}
