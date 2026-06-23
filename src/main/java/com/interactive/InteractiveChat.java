package com.interactive;

import org.bukkit.plugin.java.JavaPlugin;
import com.interactive.listeners.ChatListener;
import com.interactive.listeners.ClickListener;
import com.interactive.listeners.InventoryListener;

public class InteractiveChat extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("§b[InteractiveChat] §fPlugin enabled!");
        
        // Register listeners
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getServer().getPluginManager().registerEvents(new ClickListener(this), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("§b[InteractiveChat] §fPlugin disabled!");
    }
}