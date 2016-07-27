package me.PrezonCraft.Hub.Parkour;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Managers.ConfigManager;

public class Start implements Listener{
	
	ConfigManager settings = ConfigManager.getInstance();
	
	
	
	@EventHandler
	  public void onPlayerMove1(PlayerMoveEvent event)
	    {
	        Player p = event.getPlayer();
	        Location loc = p.getLocation();
	        Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() - 1.0D, loc.getZ());
	        if ((loc.getBlock().getType() == Material.GOLD_PLATE) && 
	          (loc1.getBlock().getType() == Material.GOLD_BLOCK))
	        {
	         if(!Main.parkour.contains(p)){
	        	 p.sendMessage("&6&lParkour &f>> &aJe bent het parkour gestart!".replace("&", "§"));
	        	 Main.parkour.add(p);
	        	ItemStack Compass = new ItemStack(Material.BARRIER);
	     	    ItemMeta compassmeta = Compass.getItemMeta();
	     	    compassmeta.setDisplayName("&c&lVerlaat het parkour".replace("&", "§"));
	     	    Compass.setItemMeta(compassmeta);
	     	    p.getInventory().setItem(4, Compass);
	        }
	    }
	}
}
