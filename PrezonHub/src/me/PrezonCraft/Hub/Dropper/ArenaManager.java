package me.PrezonCraft.Hub.Dropper;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.API.ScoreboardAPI;
import me.PrezonCraft.Hub.API.WorldGaurd;
import me.PrezonCraft.Hub.Managers.ConfigManager;

public class ArenaManager {
public static List<String> inDropper = new ArrayList<String>();
	
static ConfigManager settings = ConfigManager.getInstance();

	public static boolean DropperTP(String regionname, Player p) {
		
				if (regionname == null) {
					return true;
				}
				RegionManager mgr = WorldGaurd.getWorldGuard().getRegionManager(p.getWorld());
				ApplicableRegionSet set = mgr.getApplicableRegions(p.getLocation());
				if (set == null) {
					
					return false;
				}
				for (ProtectedRegion r : set) {
					if (r.getId().equalsIgnoreCase("DropperTp")) {
						p.sendMessage("&c&lDropper&f >> Je word naar de dropper gestuurd!".replace("&", "§"));
						String stringYaw = settings.getConfig().getString("Dropper.yaw");
					      String stringPitch = settings.getConfig().getString("Dropper.pitch");
					      
					      String stringX = settings.getConfig().getString("Dropper.x");
					      String stringY = settings.getConfig().getString("Dropper.y");
					      String stringZ = settings.getConfig().getString("Dropper.z");
					      
					      float yaw = Float.parseFloat(stringYaw);
					      float pitch = Float.parseFloat(stringPitch);
					      
					      double X = Double.parseDouble(stringX);
					      double Y = Double.parseDouble(stringY);
					      double Z = Double.parseDouble(stringZ);
					      
					      String world = settings.getConfig().getString("Dropper.world");
					      
					      Location spawn = new Location(Bukkit.getWorld(world), X, Y, Z, yaw, pitch);
					      p.teleport(spawn);
					      
					      ItemStack Compass = new ItemStack(Material.BARRIER);
				     	    ItemMeta compassmeta = Compass.getItemMeta();
				     	    compassmeta.setDisplayName("&c&lVerlaat de dropper".replace("&", "§"));
				     	    Compass.setItemMeta(compassmeta);
				     	    p.getInventory().setItem(4, Compass);
				     	    
				     	   inDropper.add(p.getName());
					      
					}
				}
				return false;
			}
	
public static boolean FinDropper(String regionname, Player p) {
		
		if (regionname == null) {
			return true;
		}
		RegionManager mgr = WorldGaurd.getWorldGuard().getRegionManager(p.getWorld());
		ApplicableRegionSet set = mgr.getApplicableRegions(p.getLocation());
		if (set == null) {
			return false;
		}
		for (ProtectedRegion r : set) {
			if (r.getId().equalsIgnoreCase("FinDropper")) {
				inDropper.remove(p.getName());
				
				 ItemStack Compass = new ItemStack(Material.BARRIER);
		     	    ItemMeta compassmeta = Compass.getItemMeta();
		     	    compassmeta.setDisplayName("&c&lVerlaat de dropper".replace("&", "§"));
		     	    Compass.setItemMeta(compassmeta);

			  	      p.getInventory().remove(Compass);
				
				
				if(Main.sql.getLOBBY_DROPPER(p) == 0){
					String stringYaw = settings.getConfig().getString("Disco.yaw");
				      String stringPitch = settings.getConfig().getString("Disco.pitch");
				      
				      String stringX = settings.getConfig().getString("Disco.x");
				      String stringY = settings.getConfig().getString("Disco.y");
				      String stringZ = settings.getConfig().getString("Disco.z");
				      
				      float yaw = Float.parseFloat(stringYaw);
				      float pitch = Float.parseFloat(stringPitch);
				      
				      double X = Double.parseDouble(stringX);
				      double Y = Double.parseDouble(stringY);
				      double Z = Double.parseDouble(stringZ);
				      
				      String world = settings.getConfig().getString("Disco.world");
				      
				      Location spawn = new Location(Bukkit.getWorld(world), X, Y, Z, yaw, pitch);
				      p.teleport(spawn);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lDropper &f>> &aJe hebt de dropper gehaalt!"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAchievements &f>> &aJe hebt de dropper gehaalt! Als beloning krijg je 20 punten!"));
					Main.sql.setLOBBY_DROPPER(p, 1);
					Main.sql.setTOTAAL_ACHIEVEMENTS(p, Main.sql.getTOTAAL_ACHIEVEMENTS(p) + 1);
					Main.sql.setPUNTEN(p, Main.sql.getPUNTEN(p) + 20);
					ScoreboardAPI.Scoreboard(p);
				}else{
					String stringYaw = settings.getConfig().getString("Disco.yaw");
				      String stringPitch = settings.getConfig().getString("Disco.pitch");
				      
				      String stringX = settings.getConfig().getString("Disco.x");
				      String stringY = settings.getConfig().getString("Disco.y");
				      String stringZ = settings.getConfig().getString("Disco.z");
				      
				      float yaw = Float.parseFloat(stringYaw);
				      float pitch = Float.parseFloat(stringPitch);
				      
				      double X = Double.parseDouble(stringX);
				      double Y = Double.parseDouble(stringY);
				      double Z = Double.parseDouble(stringZ);
				      
				      String world = settings.getConfig().getString("Disco.world");
				      
				      Location spawn = new Location(Bukkit.getWorld(world), X, Y, Z, yaw, pitch);
				      p.teleport(spawn);
				      
				      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lDropper &f>> &aJe hebt de dropper gehaalt!"));
				      
				}
				
			}
		}
		return false;
	}
	
	public static boolean EnterDropper(String regionname, Player p) {
		
		if (regionname == null) {
			return true;
		}
		RegionManager mgr = WorldGaurd.getWorldGuard().getRegionManager(p.getWorld());
		ApplicableRegionSet set = mgr.getApplicableRegions(p.getLocation());
		if (set == null) {
			return false;
		}
		for (ProtectedRegion r : set) {
			if (r.getId().equalsIgnoreCase("EnterDropper")) {
		    inDropper.add(p.getName());
			}
		}
		return false;
	}
         }