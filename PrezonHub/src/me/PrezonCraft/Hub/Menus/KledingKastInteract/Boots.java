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

public class Boots implements Listener{
	
	
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
	    	  p.getInventory().setBoots(skullitem(Material.LEATHER_BOOTS, itemname, red, green, blue));
	    	  Main.sql.setVANITY_WARDROBE_ALL(p, "BOOTS");
	    	  Main.sql.setVANITY_WARDROBE(p, 1, "BOOTS", COLOR);
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
	    	  p.getInventory().setBoots(item(Material.LEATHER_BOOTS, itemname));
	    	  Main.sql.setVANITY_WARDROBE_ALL(p, "BOOTS");
	    	  Main.sql.setVANITY_WARDROBE(p, 1, "BOOTS", COLOR);
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
		InvSkullClick(e.getCurrentItem(), "Chicken Boots", "Chicken of hoger", p, "Chicken Boots", 255, 255, 255, "WHITE");
		InvSkullClick(e.getCurrentItem(), "Pig Boots", "Pig of hoger", p, "Pig Boots", 247, 161, 213, "ROSE");
		InvNormalClick(e.getCurrentItem(), "Cow Boots", "Cow of hoger", p, "Cow Boots", "BRUNE");
		InvSkullClick(e.getCurrentItem(), "Rabbit Boots", "Rabbit of hoger", p, "Rabbit Boots", 129, 128, 128, "GRAY");
		InvSkullClick(e.getCurrentItem(), "Bat Boots", "Bat of hoger", p, "Bat Boots", 0, 0, 0, "BLACK");
		InvSkullClick(e.getCurrentItem(), "Villager Boots", "Villager of hoger", p, "Villager Boots", 27, 134, 37, "GREEN");
	  }
	
}