package com.spacelampsix.monsters.extrahardmonsters;

import org.bukkit.plugin.java.JavaPlugin;

public final class ExtraHardMonsters extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
