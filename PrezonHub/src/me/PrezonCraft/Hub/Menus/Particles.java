package me.PrezonCraft.Hub.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Particles {
	
	private static ItemStack item(Material mat, String rank, String perm, String name, Player p, int data){
		
		ItemStack i = new ItemStack(mat, 1, (short) data);
		ItemMeta glass14fmeta = i.getItemMeta();
		if(p.hasPermission(perm)){
			glass14fmeta.setDisplayName("&a".replace("&", "§") + name);
			List<String> Flamelre = new ArrayList<String>();
			Flamelre.add("&a&l✓ UNLOCKED".replace("&", "§"));
			Flamelre.add("&a&l✓ ".replace("&", "§") + rank);
			glass14fmeta.setLore(Flamelre);
		}else{
	    List<String> Flamelre = new ArrayList<String>();
    	glass14fmeta.setDisplayName("&c".replace("&", "§") + name);
    	Flamelre.add("&c&l✗LOCKED".replace("&", "§"));
    	Flamelre.add("&c&l✗ ".replace("&", "§") + rank);
    	glass14fmeta.setLore(Flamelre);
	}
		i.setItemMeta(glass14fmeta);
		
		return i;
	}

	public static void openKledingkast(Player p){
		Inventory inv = Bukkit.createInventory(null, 9*3, "&4&lTrails".replace("&", "§"));
		
		inv.setItem(20, item(Material.COAL, "Villager of hoger", "prezon.hub.smoke", "Smoke Trail", p, 0));
		inv.setItem(18, item(Material.SNOW_BALL, "Bat of hoger", "prezon.hub.snow", "Snow Trail", p, 0));
		inv.setItem(0, item(Material.INK_SACK, "Chicken of hoger", "prezon.hub.witch", "Witch Trail", p, 5));
		inv.setItem(2, item(Material.SLIME_BALL, "Chicken of hoger", "prezon.hub.slime", "Slime Trail", p, 0));
		inv.setItem(4, item(Material.ENCHANTMENT_TABLE, "Pig of hoger", "prezon.hub.enchant", "Enchanting Trail", p, 0));
		inv.setItem(8, item(Material.BLAZE_POWDER, "Cow of hoger", "prezon.hub.flame", "Flame Trail", p, 0));
		inv.setItem(24, item(Material.INK_SACK, "Villager of hoger", "prezon.hub.rainbow", "Rainbow Trail", p, 12));
		inv.setItem(6, item(Material.REDSTONE, "Pig of hoger", "prezon.hub.redstone", "Redstone Trail", p, 0));
		inv.setItem(22, item(Material.RED_ROSE, "Villager of hoger", "prezon.hub.heart", "Heart Trail", p, 0));
		inv.setItem(10, item(Material.INK_SACK, "Cow of hoger", "prezon.hub.cloud", "Cloud Trail", p, 15));
		inv.setItem(16, item(Material.EMERALD, "Bat of hoger", "prezon.hub.happy", "Happy Trail", p, 0));
		inv.setItem(12, item(Material.WATER_BUCKET, "Rabbit of hoger", "prezon.hub.bubbel", "Splash Trail", p, 0));
		inv.setItem(14, item(Material.NOTE_BLOCK, "Rabbit of hoger", "prezon.hub.note", "Note Trail", p, 0));
		
		
		ItemStack i = new ItemStack(Material.BARRIER, 1);
		ItemMeta glass14fmeta = i.getItemMeta();
			glass14fmeta.setDisplayName("&aTrail uitzetten!".replace("&", "§"));
		i.setItemMeta(glass14fmeta);
		inv.setItem(26, i);
		
		p.openInventory(inv);
	}
	
}
