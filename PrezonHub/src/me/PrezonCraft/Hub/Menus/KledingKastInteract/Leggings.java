package me.PrezonCraft.Hub.Menus.KledingKastInteract;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.PrezonCraft.Hub.Main;

public class Leggings implements Listener{
	
	
	public static ItemStack skullitem(Material mat, String name, int red, int green, int blue){
		
		ItemStack i = new ItemStack(mat, 1, (short) 3);
		LeatherArmorMeta glass14fmeta = (LeatherArmorMeta) i.getItemMeta();
			glass14fmeta.setDisplayName("&f[&c".replace("&", "§") + name + "&f]".replace("&", "§"));
			glass14fmeta.setColor(Color.fromRGB(red, green, blue));
			glass14fmeta.spigot().setUnbreakable(true);
			glass14fmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		i.setItemMeta(glass14fmeta);
		return i;
	}
	
public static ItemStack item(Material mat, String name){
		
		ItemStack i = new ItemStack(mat, 1, (short) 3);
		ItemMeta glass14fmeta = i.getItemMeta();
			glass14fmeta.setDisplayName("&f[&c".replace("&", "§") + name + "&f]".replace("&", "§"));
			glass14fmeta.spigot().setUnbreakable(true);
			glass14fmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		i.setItemMeta(glass14fmeta);
		return i;
	}
	
	
	public static void InvSkullClick(ItemStack item, String name, String rank, Player p, String itemname, int red, int green, int blue, String COLOR){
		if (item.getItemMeta().getDisplayName()
				.equalsIgnoreCase("&a".replace("&", "§") + name))
	      {
	    	  p.getInventory().setLeggings(skullitem(Material.LEATHER_LEGGINGS, itemname, red, green, blue));
	    	  Main.sql.setVANITY_WARDROBE_ALL(p, "LEGGINGS");
	    	  Main.sql.setVANITY_WARDROBE(p, 1, "LEGGINGS", COLOR);
	      }
		
		if (item.getItemMeta().getDisplayName()
	    		  .equalsIgnoreCase("&c".replace("&", "§") + name))
	      {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[&4&lKledingKast&f] Je hebt de rank &c" + rank + " &fnodig om dit te kunnen!"));
	      }
	}
	
	public static void InvNormalClick(ItemStack item, String name, String rank, Player p, String itemname, String COLOR){
		if (item.getItemMeta().getDisplayName()
				.equalsIgnoreCase("&a".replace("&", "§") + name))
	      {
	    	  p.getInventory().setLeggings(item(Material.LEATHER_LEGGINGS, itemname));
	    	  Main.sql.setVANITY_WARDROBE_ALL(p, "LEGGINGS");
	    	  Main.sql.setVANITY_WARDROBE(p, 1, "LEGGINGS", COLOR);
	      }
		
		if (item.getItemMeta().getDisplayName()
	    		  .equalsIgnoreCase("&c".replace("&", "§") + name))
	      {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[&4&lKledingKast&f] Je hebt de rank &c" + rank + " &fnodig om dit te kunnen!"));
	      }
		
		
	}
	
	@EventHandler
	  public void onClick2f(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		InvSkullClick(e.getCurrentItem(), "Chicken Leggings", "Chicken of hoger", p, "Chicken Leggings", 255, 255, 255, "WHITE");
		InvSkullClick(e.getCurrentItem(), "Pig Leggings", "Pig of hoger", p, "Pig Leggings", 247, 161, 213, "ROSE");
		InvNormalClick(e.getCurrentItem(), "Cow Leggings", "Cow of hoger", p, "Cow Leggings", "BRUNE");
		InvSkullClick(e.getCurrentItem(), "Rabbit Leggings", "Rabbit of hoger", p, "Rabbit Leggings", 129, 128, 128, "GRAY");
		InvSkullClick(e.getCurrentItem(), "Bat Leggings", "Bat of hoger", p, "Bat Leggings", 0, 0, 0, "BLACK");
		InvSkullClick(e.getCurrentItem(), "Villager Leggings", "Villager of hoger", p, "Villager Leggings", 27, 134, 37, "GREEN");
	  }
	
}