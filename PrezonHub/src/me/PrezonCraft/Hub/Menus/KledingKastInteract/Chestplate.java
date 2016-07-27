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

public class Chestplate implements Listener{
	
	
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
	
	
	public static void InvSkullClick(ItemStack item, String name, String rank, Player p, String itemname, int red, int green, int blue, String TYPE, String COLOR){
		if (item.getItemMeta().getDisplayName()
				.equalsIgnoreCase("&a".replace("&", "§") + name))
	      {
	    	  p.getInventory().setChestplate(skullitem(Material.LEATHER_CHESTPLATE, itemname, red, green, blue));
	    	  Main.sql.setVANITY_WARDROBE_ALL(p, "CHESTPLATE");
	    	  Main.sql.setVANITY_WARDROBE(p, 1, TYPE, COLOR);
	      }
		
		if (item.getItemMeta().getDisplayName()
	    		  .equalsIgnoreCase("&c".replace("&", "§") + name))
	      {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[&4&lKledingKast&f] Je hebt de rank &c" + rank + " &fnodig om dit te kunnen!"));
	      }
	}
	
	public static void InvNormalClick(ItemStack item, String name, String rank, Player p, String itemname, String TYPE, String COLOR){
		if (item.getItemMeta().getDisplayName()
				.equalsIgnoreCase("&a".replace("&", "§") + name))
	      {
	    	  p.getInventory().setChestplate(item(Material.LEATHER_CHESTPLATE, itemname));
	    	  Main.sql.setVANITY_WARDROBE_ALL(p, "CHESTPLATE");
	    	  Main.sql.setVANITY_WARDROBE(p, 1, TYPE, COLOR);
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
		InvSkullClick(e.getCurrentItem(), "Chicken Chestplate", "Chicken of hoger", p, "Chicken Chestplate", 255, 255, 255, "CHESTPLATE", "WHITE");
		InvSkullClick(e.getCurrentItem(), "Pig Chestplate", "Pig of hoger", p, "Pig Chestplate", 247, 161, 213, "CHESTPLATE", "ROSE");
		InvNormalClick(e.getCurrentItem(), "Cow Chestplate", "Cow of hoger", p, "Cow Chestplate", "CHESTPLATE", "BRUNE");
		InvSkullClick(e.getCurrentItem(), "Rabbit Chestplate", "Rabbit of hoger", p, "Rabbit Chestplate", 129, 128, 128, "CHESTPLATE", "GRAY");
		InvSkullClick(e.getCurrentItem(), "Bat Chestplate", "Bat of hoger", p, "Bat Chestplate", 0, 0, 0, "CHESTPLATE", "BLACK");
		InvSkullClick(e.getCurrentItem(), "Villager Chestplate", "Villager of hoger", p, "Villager Chestplate", 27, 134, 37, "CHESTPLATE", "GREEN");
	  }
	
}