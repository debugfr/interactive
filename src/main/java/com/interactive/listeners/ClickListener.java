package com.interactive.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import com.interactive.utils.ShulkerUtils;

public class ClickListener implements Listener {

    private JavaPlugin plugin;

    public ClickListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        // Check if right-clicking air with shulker box
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = player.getItemInHand();
            
            if (item != null && ShulkerUtils.isShulkerBox(item)) {
                event.setCancelled(true);
                openShulkerPreview(player, item);
            }
        }
    }

    private void openShulkerPreview(Player player, ItemStack shulker) {
        Inventory preview = Bukkit.createInventory(player, 27, "§b§nShulker Contents");
        
        // Get shulker block entity data
        ItemStack[] contents = ShulkerUtils.getShulkerContents(shulker);
        if (contents != null) {
            for (int i = 0; i < contents.length && i < 27; i++) {
                if (contents[i] != null) {
                    preview.setItem(i, contents[i]);
                }
            }
        }
        
        player.openInventory(preview);
        player.sendMessage("§3§nShulker Preview Opened!");
    }
}