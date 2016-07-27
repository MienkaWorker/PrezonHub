package me.PrezonCraft.Hub.Utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

public class Public_Utils {
	
        public static ItemStack skullitem(String name, String owner, List<String> lore){
		ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta glass14fmeta = (SkullMeta) i.getItemMeta();
		glass14fmeta.setOwner(owner);
		glass14fmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		glass14fmeta.setLore(lore);
		
		i.setItemMeta(glass14fmeta);
		return i;
	    }
        
        public static ItemStack glasspain(String name, String owner, List<String> lore, int MetaData){
    		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
    		ItemMeta glass14fmeta = i.getItemMeta();
    		glass14fmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    		glass14fmeta.setLore(lore);
    		
    		i.setItemMeta(glass14fmeta);
    		return i;
    	    }

}
