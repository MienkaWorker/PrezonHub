package me.PrezonCraft.Hub.Menus.KledingKastInteract;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.PrezonCraft.Hub.Main;


public class Heads implements Listener{
	
	
	public static ItemStack skullitem(Material mat, String name, String owner){
		
		ItemStack i = new ItemStack(mat, 1, (short) 3);
		SkullMeta glass14fmeta = (SkullMeta) i.getItemMeta();
		glass14fmeta.setOwner(owner);
			glass14fmeta.setDisplayName("&f[&c".replace("&", "§") + name + "&f]".replace("&", "§"));
		i.setItemMeta(glass14fmeta);
		return i;
	}
	
	
	public static void InvSkullClick(ItemStack item, String name, String rank, Player p, String itemname, String skullowner, String HAT){
		if (item.getItemMeta().getDisplayName()
				.equalsIgnoreCase("&a".replace("&", "§") + name))
	      {
	    	  p.getInventory().setHelmet(skullitem(Material.SKULL_ITEM, itemname, skullowner));
	          
	    	  Main.sql.setVANITY_HAT_ALL(p);
	    	  Main.sql.setVANITY_HAT(p, 1, HAT);
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
		InvSkullClick(e.getCurrentItem(), "Chicken Skull", "Chicken of hoger", p, "Chicken Skull", "MHF_Chicken", "CHICKEN");
		InvSkullClick(e.getCurrentItem(), "Pig Skull", "Pig of hoger", p, "Pig Skull", "MHF_Pig", "PIG");
		InvSkullClick(e.getCurrentItem(), "Cow Skull", "Cow of hoger", p, "Cow Skull", "MHF_Cow", "COW");
		InvSkullClick(e.getCurrentItem(), "Rabbit Skull", "Rabbit of hoger", p, "Rabbit Skull", "MHF_Rabbit", "RABBIT");
		InvSkullClick(e.getCurrentItem(), "Bat Skull", "Bat of hoger", p, "Bat Skull", "KaarsRecht", "BAT");
		InvSkullClick(e.getCurrentItem(), "Villager Skull", "Villager of hoger", p, "Villager Skull", "MHF_Villager", "VILLAGER");
	  }
	
}
