package iiDanto.spawnV2;

import iiDanto.spawnV2.commands.SetSpawnCommand;
import iiDanto.spawnV2.commands.SpawnCommand;
import iiDanto.spawnV2.listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnV2 extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("SpawnV2 Has started successfully.");
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);

    }

    @Override
    public void onDisable() {
        System.out.println("SpawnV2 Has stopped successfully.");
    }
}
