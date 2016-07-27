package me.PrezonCraft.Hub.Parkour;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.API.ScoreboardAPI;
import me.PrezonCraft.Hub.Listener.JoinItems;
import me.PrezonCraft.Hub.Managers.ConfigManager;

public class END implements Listener {
	
	ConfigManager settings = ConfigManager.getInstance();
	
	@EventHandler
	  public void onPlayerMove1(PlayerMoveEvent event)
	    {
	        Player p = event.getPlayer();
	        Location loc = p.getLocation();
	        Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() - 1.0D, loc.getZ());
	        if ((loc.getBlock().getType() == Material.IRON_PLATE) && 
	          (loc1.getBlock().getType() == Material.IRON_BLOCK))
	        {
	         if(Main.parkour.contains(p)){
	        	 
	        	 if(Main.sql.getLOBBY_PARKOUR(p) == 0){
	        		
	        		Main.sql.setLOBBY_PARKOUR(p, 1);
	     			Main.sql.setTOTAAL_ACHIEVEMENTS(p, Main.sql.getTOTAAL_ACHIEVEMENTS(p) + 1);
	     			Main.sql.setPUNTEN(p, Main.sql.getPUNTEN(p) + 20);
	     			
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
	     			
		        	 p.sendMessage("&6&lParkour &f>> &aJe hebt het parkour gehaalt!".replace("&", "§"));
		        	 p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAchievements &f>> &aJe hebt het parkour gehaalt! als beloning ontvang je 20 punten!"));
		        	 Main.parkour.remove(p);
		        	 JoinItems.GiveAc(p);
		        	 JoinItems.GiveCom(p);
		        	 JoinItems.GiveSp(p);
		        	 JoinItems.GiveVan(p);
		        	 
		        	 ItemStack Compass = new ItemStack(Material.BARRIER);
			     	    ItemMeta compassmeta = Compass.getItemMeta();
			     	    compassmeta.setDisplayName("&c&lVerlaat het parkour".replace("&", "§"));
			     	    Compass.setItemMeta(compassmeta);
		        	 
		        	 p.getInventory().remove(Compass);
		        	 
	     			ScoreboardAPI.Scoreboard(p);
	        	 }else{
	        		 
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
				      
				      ItemStack Compass = new ItemStack(Material.BARRIER);
			     	    ItemMeta compassmeta = Compass.getItemMeta();
			     	    compassmeta.setDisplayName("&c&lVerlaat het parkour".replace("&", "§"));
			     	    Compass.setItemMeta(compassmeta);
		        	 
		        	 p.getInventory().remove(Compass);
				      
				      String world = settings.getConfig().getString("ParkourSpawn.Spawn.world");
				      
				      Location spawn = new Location(Bukkit.getWorld(world), X, Y, Z, yaw, pitch);
				      p.teleport(spawn);
				      p.getInventory().remove(Compass);
	        		  p.sendMessage("&6&lParkour &f>> &aJe hebt het parkour gehaalt!".replace("&", "§"));
	            } 
	        }
	    }
	}
}
