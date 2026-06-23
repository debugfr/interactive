package com.interactive.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ItemDisplay {

    public static void showPlayerInventory(Player viewer, Player target) {
        Inventory inv = Bukkit.createInventory(viewer, 54, "§b" + target.getName() + "'s Inventory");
        
        // Copy main inventory
        for (int i = 0; i < 36; i++) {
            if (i < target.getInventory().getSize()) {
                inv.setItem(i, target.getInventory().getItem(i));
            }
        }
        
        // Copy armor
        inv.setItem(36, target.getInventory().getHelmet());
        inv.setItem(37, target.getInventory().getChestplate());
        inv.setItem(38, target.getInventory().getLeggings());
        inv.setItem(39, target.getInventory().getBoots());
        
        // Copy hand item
        inv.setItem(40, target.getItemInHand());
        
        viewer.openInventory(inv);
    }

    public static void showPlayerEnderchest(Player viewer, Player target) {
        Inventory ec = Bukkit.createInventory(viewer, 27, "§b" + target.getName() + "'s Enderchest");
        
        // Copy enderchest
        for (int i = 0; i < target.getEnderChest().getSize(); i++) {
            ec.setItem(i, target.getEnderChest().getItem(i));
        }
        
        viewer.openInventory(ec);
    }

    public static void showPlayerItem(Player viewer, Player target) {
        if (target.getItemInHand() == null || target.getItemInHand().getType().toString().equals("AIR")) {
            viewer.sendMessage("§c" + target.getName() + " is not holding anything!");
        } else {
            viewer.sendMessage("§b" + target.getName() + " is holding: §f" + target.getItemInHand().getType().toString());
        }
    }
}