package me.PrezonCraft.Hub.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VanityMenu {

	public static void Vanity(Player p){
	Inventory inv = Bukkit.createInventory(null, 9, "&c&lVanity".replace("&", "§"));
	
	ItemStack glass100 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	ItemMeta glass100meta = glass100.getItemMeta();
		glass100meta.setDisplayName("&4&lKledingKast".replace("&", "§"));

	glass100.setItemMeta(glass100meta);
	inv.setItem(1, glass100);
	
	ItemStack glass1000 = new ItemStack(Material.BONE, 1);
	ItemMeta glass1000meta = glass1000.getItemMeta();
		glass1000meta.setDisplayName("&9&lPets".replace("&", "§"));

	glass1000.setItemMeta(glass1000meta);
	//inv.setItem(4, glass1000);
	
	ItemStack glass1002 = new ItemStack(Material.SNOW_BALL, 1);
	ItemMeta glass1002meta = glass1002.getItemMeta();
		glass1002meta.setDisplayName("&4&lTrails".replace("&", "§"));

	glass1002.setItemMeta(glass1002meta);
	inv.setItem(7, glass1002);
	
	p.openInventory(inv);
	
	}
}
