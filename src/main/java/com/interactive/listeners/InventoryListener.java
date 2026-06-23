package com.interactive.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import com.interactive.utils.ItemDisplay;

public class InventoryListener implements Listener {

    private JavaPlugin plugin;
    private static final String EC_PREFIX = "§b";
    private static final String INV_PREFIX = "§b";

    public InventoryListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        // Handle inventory open events if needed
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getInventory();
        
        // Prevent modifications in view-only inventories
        String title = inv.getName();
        if (title.contains("Enderchest") || title.contains("Inventory") || title.contains("Shulker")) {
            event.setCancelled(true);
        }
    }
}