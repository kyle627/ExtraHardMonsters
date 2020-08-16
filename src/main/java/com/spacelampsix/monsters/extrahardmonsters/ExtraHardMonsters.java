package com.spacelampsix.monsters.extrahardmonsters;

import org.bukkit.plugin.java.JavaPlugin;

public final class ExtraHardMonsters extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OverworldMonsterListeners(), this);
        getServer().getPluginManager().registerEvents(new NetherMonsterListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
