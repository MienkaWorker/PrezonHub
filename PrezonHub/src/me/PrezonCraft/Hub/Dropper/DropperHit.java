package me.PrezonCraft.Hub.Dropper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.PrezonCraft.Hub.API.WorldGaurd;
import me.PrezonCraft.Hub.Managers.ConfigManager;

public class DropperHit implements Listener{
	
	static ConfigManager settings = ConfigManager.getInstance();
	
	@EventHandler
	public void onFall(PlayerMoveEvent e){
		
		RegionManager mgr = WorldGaurd.getWorldGuard().getRegionManager(e.getPlayer().getWorld());
		ApplicableRegionSet set = mgr.getApplicableRegions(e.getPlayer().getLocation());
		
		for (ProtectedRegion r : set) {
			if (!(r.getId().equalsIgnoreCase("FinDropper"))) {
				if(ArenaManager.inDropper.contains(e.getPlayer().getName())){
					double X = e.getPlayer().getLocation().getBlockX();
					double Y = e.getPlayer().getLocation().getBlockY() - 1;
					double Z = e.getPlayer().getLocation().getBlockZ();
					
					Location loc = new Location(e.getPlayer().getWorld(), X, Y, Z);
					
					if(loc.getBlock().getType() != Material.AIR){
						String stringYaw = settings.getConfig().getString("Dropper.yaw");
					      String stringPitch = settings.getConfig().getString("Dropper.pitch");
					      
					      String stringX = settings.getConfig().getString("Dropper.x");
					      String stringY = settings.getConfig().getString("Dropper.y");
					      String stringZ = settings.getConfig().getString("Dropper.z");
					      
					      float yaw = Float.parseFloat(stringYaw);
					      float pitch = Float.parseFloat(stringPitch);
					      
					      double X2 = Double.parseDouble(stringX);
					      double Y2 = Double.parseDouble(stringY);
					      double Z2 = Double.parseDouble(stringZ);
					      
					      String world = settings.getConfig().getString("Dropper.world");
					      
					      Location spawn = new Location(Bukkit.getWorld(world), X2, Y2, Z2, yaw, pitch);
					      e.getPlayer().teleport(spawn);
					      
					      ArenaManager.inDropper.remove(e.getPlayer().getName());
					      
					}
					
				}
			}
		}
	}
	

}
