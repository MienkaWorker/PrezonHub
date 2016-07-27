package me.PrezonCraft.Hub.Utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Utils_Wardrobe {
	
public static ItemStack skullitem(Material mat, String name, String owner){
		
		ItemStack i = new ItemStack(mat, 1, (short) 3);
		SkullMeta glass14fmeta = (SkullMeta) i.getItemMeta();
		glass14fmeta.setOwner(owner);
			glass14fmeta.setDisplayName("&f[&c".replace("&", "§") + name + "&f]".replace("&", "§"));
		i.setItemMeta(glass14fmeta);
		return i;
	}

public static ItemStack ColorArmoritem(Material mat, String name, int red, int green, int blue){
	
	ItemStack i = new ItemStack(mat, 1, (short) 3);
	LeatherArmorMeta glass14fmeta = (LeatherArmorMeta) i.getItemMeta();
		glass14fmeta.setDisplayName("&f[&c".replace("&", "§") + name + "&f]".replace("&", "§"));
		glass14fmeta.setColor(Color.fromRGB(red, green, blue));
		glass14fmeta.spigot().setUnbreakable(true);
		glass14fmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	i.setItemMeta(glass14fmeta);
	return i;
}

public static ItemStack NormalArmorItem(Material mat, String name){
	
	ItemStack i = new ItemStack(mat, 1, (short) 3);
	ItemMeta glass14fmeta = i.getItemMeta();
		glass14fmeta.setDisplayName("&f[&c".replace("&", "§") + name + "&f]".replace("&", "§"));
		glass14fmeta.spigot().setUnbreakable(true);
		glass14fmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	i.setItemMeta(glass14fmeta);
	return i;
}

}
