package me.PrezonCraft.Hub.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Dropper.ArenaManager;
import me.PrezonCraft.Hub.Managers.ConfigManager;
import me.PrezonCraft.Hub.Menus.Achievements;
import me.PrezonCraft.Hub.Menus.ServerSelector;
import me.PrezonCraft.Hub.Menus.VanityMenu;

public class UseJoinItems implements Listener{
	
	ConfigManager settings = ConfigManager.getInstance();
	
	@EventHandler
	  public void onItemUse(PlayerInteractEvent event)
	  {
	    if ((event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) && (
	  	      (event.getAction() == Action.RIGHT_CLICK_AIR) || 
	  	      (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	  	      (event.getAction() == Action.LEFT_CLICK_AIR) || 
	  	      (event.getAction() == Action.LEFT_CLICK_BLOCK)))
	  	    {
	  	      Player p = event.getPlayer();
	  	      ServerSelector.Selector(p);
	  	      p.updateInventory();
	  	    }
	    
	    if ((event.getPlayer().getInventory().getItemInMainHand().getType() == Material.CHEST) && (
		  	      (event.getAction() == Action.RIGHT_CLICK_AIR) || 
		  	      (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
		  	      (event.getAction() == Action.LEFT_CLICK_AIR) || 
		  	      (event.getAction() == Action.LEFT_CLICK_BLOCK)))
		  	    {
		  	      Player p = event.getPlayer();
		  	      VanityMenu.Vanity(p);
		  	      p.updateInventory();
		  	    }
	    
	    if(Main.parkour.contains(event.getPlayer())){
	    	if ((event.getPlayer().getInventory().getItemInMainHand().getType() == Material.BARRIER) && (
			  	      (event.getAction() == Action.RIGHT_CLICK_AIR) || 
			  	      (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
			  	      (event.getAction() == Action.LEFT_CLICK_AIR) || 
			  	      (event.getAction() == Action.LEFT_CLICK_BLOCK)))
			  	    {
			  	      Player p = event.getPlayer();
			  	      Main.parkour.remove(p);
			  	      p.sendMessage("&cJe hebt het parkour verlaten!".replace("&", "§"));
			  	      
			  	    ItemStack Compass = new ItemStack(Material.BARRIER);
		     	    ItemMeta compassmeta = Compass.getItemMeta();
		     	    compassmeta.setDisplayName("&c&lVerlaat het parkour".replace("&", "§"));
		     	    Compass.setItemMeta(compassmeta);
			  	      
		     	   String stringYaw = settings.getConfig().getString("ParkourSpawn.Spawn.yaw");
				      String stringPitch = settings.getConfig().getString("ParkourSpawn.Spawn.pitch");
				      
				      String stringX = settings.getConfig().getString("ParkourSpawn.Spawn.x");
				      String stringY = settings.getConfig().getString("ParkourSpawn.Spawn.y");
				      String stringZ = settings.getConfig().getString("ParkourSpawn.Spawn.z");
				      
				      float yaw = Float.parseFloat(stringYaw);
				      float pitch = Float.parseFloat(stringPitch);
				      
				      double X = Double.parseDouble(stringX);
				      double Y = Double.parseDouble(stringY);
				      double Z = Double.parseDouble(stringZ);
				      
				      String world = settings.getConfig().getString("ParkourSpawn.Spawn.world");
				      
				      Location spawn = new Location(Bukkit.getWorld(world), X, Y, Z, yaw, pitch);
				      p.teleport(spawn);
		     	    
			  	      p.getInventory().remove(Compass);
			  	      p.updateInventory();
			  	    }
	    }
	    
	    ItemStack Compass = new ItemStack(Material.BARRIER);
 	    ItemMeta compassmeta = Compass.getItemMeta();
 	    compassmeta.setDisplayName("&c&lVerlaat de dropper".replace("&", "§"));
 	    Compass.setItemMeta(compassmeta);
	    
	    if(event.getPlayer().getInventory().contains(Compass)){
	    	if ((event.getPlayer().getInventory().getItemInMainHand().getType() == Material.BARRIER) && (
			  	      (event.getAction() == Action.RIGHT_CLICK_AIR) || 
			  	      (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
			  	      (event.getAction() == Action.LEFT_CLICK_AIR) || 
			  	      (event.getAction() == Action.LEFT_CLICK_BLOCK)))
			  	    {
			  	      Player p = event.getPlayer();
			  	      ArenaManager.inDropper.remove(p.getName());
			  	      p.sendMessage("&cJe hebt de dropper verlaten!".replace("&", "§"));

		     	      p.performCommand("spawn");
			  	      p.getInventory().remove(Compass);
			  	      p.updateInventory();
			  	    }
	  }
	    if ((event.getPlayer().getInventory().getItemInMainHand().getType() == Material.EMERALD) && (
		  	      (event.getAction() == Action.RIGHT_CLICK_AIR) || 
		  	      (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
		  	      (event.getAction() == Action.LEFT_CLICK_AIR) || 
		  	      (event.getAction() == Action.LEFT_CLICK_BLOCK)))
		  	    {
		  	      Player p = event.getPlayer();
		  	      Achievements.Menu(p);
		  	      p.updateInventory();
		  	    }
	  }

}
