package me.PrezonCraft.Hub.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class KledingKast {
	
public static ItemStack armoritem(Material mat, String rank, String perm, String name, Player p, int red, int green, int blue){
		
		ItemStack i = new ItemStack(mat, 1);
		LeatherArmorMeta glass14fmeta = (LeatherArmorMeta) i.getItemMeta();
		if(p.hasPermission(perm)){
			glass14fmeta.setDisplayName("&a".replace("&", "§") + name);
			List<String> Flamelre = new ArrayList<String>();
			Flamelre.add("&a&l✓ UNLOCKED".replace("&", "§"));
			Flamelre.add("&a&l✓ ".replace("&", "§") + rank);
			glass14fmeta.setLore(Flamelre);
		}else{
	    List<String> Flamelre = new ArrayList<String>();
    	glass14fmeta.setDisplayName("&c".replace("&", "§") + name);
    	Flamelre.add("&c&✗ lLOCKED".replace("&", "§"));
    	Flamelre.add("&c&l✗ ".replace("&", "§") + rank);
    	glass14fmeta.setLore(Flamelre);
	}
		glass14fmeta.setColor(Color.fromRGB(red, green, blue));
		i.setItemMeta(glass14fmeta);
		
		return i;
	}

public static ItemStack item(Material mat, String rank, String perm, String name, Player p){
	
	ItemStack i = new ItemStack(mat, 1);
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
	Flamelre.add("&c&✗ lLOCKED".replace("&", "§"));
	Flamelre.add("&c&l✗ ".replace("&", "§") + rank);
	glass14fmeta.setLore(Flamelre);
}
	i.setItemMeta(glass14fmeta);
	
	return i;
}

public static ItemStack skullitem(Material mat, String rank, String perm, String name, Player p, String owner){
	
	ItemStack i = new ItemStack(mat, 1, (short) 3);
	SkullMeta glass14fmeta = (SkullMeta) i.getItemMeta();
	glass14fmeta.setOwner(owner);
	if(p.hasPermission(perm)){
		glass14fmeta.setDisplayName("&a".replace("&", "§") + name);
		List<String> Flamelre = new ArrayList<String>();
		Flamelre.add("&a&l✓ UNLOCKED".replace("&", "§"));
		Flamelre.add("&a&l✓ ".replace("&", "§") + rank);
		glass14fmeta.setLore(Flamelre);
	}else{
    List<String> Flamelre = new ArrayList<String>();
	glass14fmeta.setDisplayName("&c".replace("&", "§") + name);
	Flamelre.add("&c&✗ lLOCKED".replace("&", "§"));
	Flamelre.add("&c&l✗ ".replace("&", "§") + rank);
	glass14fmeta.setLore(Flamelre);
}
	i.setItemMeta(glass14fmeta);
	
	return i;
}
	
	public static void openKledingkast(Player p){
		Inventory inv = Bukkit.createInventory(null, 36, "&4&lKledingKast".replace("&", "§"));
		
		inv.setItem(1, skullitem(Material.SKULL_ITEM, "Chicken of hoger", "prezon.lobby.chicken", "Chicken Skull", p, "MHF_Chicken"));
		inv.setItem(2, skullitem(Material.SKULL_ITEM, "Pig of hoger", "prezon.lobby.pig", "Pig Skull", p, "MHF_Pig"));
		inv.setItem(3, skullitem(Material.SKULL_ITEM, "Cow of hoger", "prezon.lobby.cow", "Cow Skull", p, "MHF_Cow"));
		inv.setItem(4, skullitem(Material.SKULL_ITEM, "Rabbit of hoger", "prezon.lobby.rabbit", "Rabbit Skull", p, "MHF_Rabbit"));
		inv.setItem(5, skullitem(Material.SKULL_ITEM, "Bat of hoger", "prezon.lobby.bat", "Bat Skull", p, "KaarsRecht"));
		inv.setItem(6, skullitem(Material.SKULL_ITEM, "Villager of hoger", "prezon.lobby.villager", "Villager Skull", p, "MHF_Villager"));
		
		inv.setItem(10, armoritem(Material.LEATHER_CHESTPLATE, "Chicken of hoger", "prezon.lobby.chicken", "Chicken Chestplate", p, 255, 255, 255));
		inv.setItem(11, armoritem(Material.LEATHER_CHESTPLATE, "Pig of hoger", "prezon.lobby.pig", "Pig Chestplate", p, 247, 161, 213));
		inv.setItem(12, item(Material.LEATHER_CHESTPLATE, "Cow of hoger", "prezon.lobby.cow", "Cow Chestplate", p));
		inv.setItem(13, armoritem(Material.LEATHER_CHESTPLATE, "Rabbit of hoger", "prezon.lobby.rabbit", "Rabbit Chestplate", p, 129, 128, 128));
		inv.setItem(14, armoritem(Material.LEATHER_CHESTPLATE, "Bat of hoger", "prezon.lobby.bat", "Bat Chestplate", p, 0, 0, 0));
		inv.setItem(15, armoritem(Material.LEATHER_CHESTPLATE, "Villager of hoger", "prezon.lobby.villager", "Villager Chestplate", p, 27, 134, 37));
		
		inv.setItem(19, armoritem(Material.LEATHER_LEGGINGS, "Chicken of hoger", "prezon.lobby.chicken", "Chicken Leggings", p, 255, 255, 255));
		inv.setItem(20, armoritem(Material.LEATHER_LEGGINGS, "Pig of hoger", "prezon.lobby.pig", "Pig Leggings", p, 247, 161, 213));
		inv.setItem(21, item(Material.LEATHER_LEGGINGS, "Cow of hoger", "prezon.lobby.cow", "Cow Leggings", p));
		inv.setItem(22, armoritem(Material.LEATHER_LEGGINGS, "Rabbit of hoger", "prezon.lobby.rabbit", "Rabbit Leggings", p, 129, 128, 128));
		inv.setItem(23, armoritem(Material.LEATHER_LEGGINGS, "Bat of hoger", "prezon.lobby.bat", "Bat Leggings", p, 0, 0, 0));
		inv.setItem(24, armoritem(Material.LEATHER_LEGGINGS, "Villager of hoger", "prezon.lobby.villager", "Villager Leggings", p, 27, 134, 37));
		
		inv.setItem(28, armoritem(Material.LEATHER_BOOTS, "Chicken of hoger", "prezon.lobby.chicken", "Chicken Boots", p, 255, 255, 255));
		inv.setItem(29, armoritem(Material.LEATHER_BOOTS, "Pig of hoger", "prezon.lobby.pig", "Pig Boots", p, 247, 161, 213));
		inv.setItem(30, item(Material.LEATHER_BOOTS, "Cow of hoger", "prezon.lobby.cow", "Cow Boots", p));
		inv.setItem(31, armoritem(Material.LEATHER_BOOTS, "Rabbit of hoger", "prezon.lobby.rabbit", "Rabbit Boots", p, 129, 128, 128));
		inv.setItem(32, armoritem(Material.LEATHER_BOOTS, "Bat of hoger", "prezon.lobby.bat", "Bat Boots", p, 0, 0, 0));
		inv.setItem(33, armoritem(Material.LEATHER_BOOTS, "Villager of hoger", "prezon.lobby.villager", "Villager Boots", p, 27, 134, 37));

		p.openInventory(inv);
	}

}
