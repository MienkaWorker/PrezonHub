package me.PrezonCraft.Hub.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Utils.MySQL_Global_Class;

public class JoinItems implements Listener{
	
	public static void GiveCom(Player p){
		ItemStack Compass = new ItemStack(Material.COMPASS);
	    ItemMeta compassmeta = Compass.getItemMeta();
	    compassmeta.setDisplayName("&9&lServer Selector".replace("&", "§"));
	    Compass.setItemMeta(compassmeta);
	    p.getInventory().setItem(0, Compass);
	    p.updateInventory();
	}  
	public static void GiveVan(Player p){
	    ItemStack torch = new ItemStack(Material.CHEST);
	    ItemMeta torchmeta = torch.getItemMeta();
	    torchmeta.setDisplayName("&c&lVanity".replace("&", "§"));
	    torch.setItemMeta(torchmeta);
	    p.getInventory().setItem(7, torch);
	    p.updateInventory();
	}
	public static void GiveAc(Player p){
	    ItemStack Ch = new ItemStack(Material.EMERALD);
	    ItemMeta chmeta = Ch.getItemMeta();
	    chmeta.setDisplayName("&a&lAchievements".replace("&", "§"));
	    Ch.setItemMeta(chmeta);
	    p.getInventory().setItem(1, Ch);
	    p.updateInventory();
	}
	    public static void GiveSp(Player p){
	  if(Main.sql.getHIDE_ALL(p) == 0){
	    ItemStack torch2 = new ItemStack(Material.INK_SACK, 1, (short) 10);
	    ItemMeta torch2meta = torch2.getItemMeta();
	    torch2meta.setDisplayName("&2&lSpelers &f&lAAN".replace("&", "§"));
	    torch2.setItemMeta(torch2meta);
	    p.getInventory().setItem(8, torch2);
	    p.updateInventory();
	  }else{
		  ItemStack torch2 = new ItemStack(Material.INK_SACK, 1, (short) 8);
		    ItemMeta torch2meta = torch2.getItemMeta();
		    torch2meta.setDisplayName("&2&lSpelers &f&lUIT".replace("&", "§"));
		    torch2.setItemMeta(torch2meta);
		    p.getInventory().setItem(8, torch2);
		    p.updateInventory(); 
	  }
	 }
	
		@EventHandler
		  public void onPlayerJoin(PlayerJoinEvent e){
		    Player p = e.getPlayer();
			    p.setHealth(20);
			    p.setFoodLevel(20);
		        
			    p.getInventory().clear();
			    
			    MySQL_Global_Class.VanityWardrobeHats(p);
			    MySQL_Global_Class.VanityWardrobeChestplate(p);
			    MySQL_Global_Class.VanityWardrobeLeggings(p);
			    MySQL_Global_Class.VanityWardrobeBoots(p);
			    MySQL_Global_Class.VanityParticles(p);
			    MySQL_Global_Class.Hide_All(p);
			    
			    ItemStack Compass = new ItemStack(Material.COMPASS);
			    ItemMeta compassmeta = Compass.getItemMeta();
			    compassmeta.setDisplayName("&9&lServer Selector".replace("&", "§"));
			    Compass.setItemMeta(compassmeta);

			    if(!p.getInventory().contains(Compass)){
			    	GiveCom(p);
			    }
			    ItemStack torch = new ItemStack(Material.CHEST);
			    ItemMeta torchmeta = torch.getItemMeta();
			    torchmeta.setDisplayName("&c&lVanity".replace("&", "§"));
			    torch.setItemMeta(torchmeta);
			    
			    if(!p.getInventory().contains(torch)){
			    	GiveVan(p);
			    }
			    
			    ItemStack Ch = new ItemStack(Material.EMERALD);
			    ItemMeta chmeta = Ch.getItemMeta();
			    chmeta.setDisplayName("&a&lAchievements".replace("&", "§"));
			    Ch.setItemMeta(chmeta);
			    
			    if(!p.getInventory().contains(Ch)){
			    	GiveAc(p);
			    }
			    
			    ItemStack torch2 = new ItemStack(Material.INK_SACK, 1, (short) 10);
			    ItemMeta torch2meta = torch2.getItemMeta();
			    torch2meta.setDisplayName("&2&lSpelers &f&lAAN".replace("&", "§"));
			    torch2.setItemMeta(torch2meta);
			    
			    if(!p.getInventory().contains(torch2)){
			    	GiveSp(p);
			    }
		  }
    }
