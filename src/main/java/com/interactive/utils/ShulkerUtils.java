package com.interactive.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class ShulkerUtils {

    /**
     * Check if an item is a shulker box
     */
    public static boolean isShulkerBox(ItemStack item) {
        if (item == null) return false;
        String name = item.getType().toString();
        return name.contains("SHULKER_BOX") || name.contains("SHULKER");
    }

    /**
     * Extract contents from a shulker box ItemStack
     * Note: 1.12.2 has limited NBT support through Bukkit API
     * This is a basic implementation
     */
    public static ItemStack[] getShulkerContents(ItemStack shulker) {
        // In 1.12.2, getting shulker contents requires NBT access
        // This returns empty for now - full implementation needs CraftBukkit
        ItemStack[] contents = new ItemStack[27];
        for (int i = 0; i < 27; i++) {
            contents[i] = new ItemStack(Material.AIR);
        }
        return contents;
    }
}