package me.PrezonCraft.Hub.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Managers.ConfigManager;
import me.PrezonCraft.Hub.Menus.KledingKast;
import me.PrezonCraft.Hub.Menus.Particles;

public class AntiShit implements Listener{
	
	static ConfigManager settings = ConfigManager.getInstance();
	
	@EventHandler
	public void onBreek(BlockBreakEvent e){
		if(!Main.build.contains(e.getPlayer().getUniqueId())){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void onPlaats(BlockPlaceEvent e){
		if(!Main.build.contains(e.getPlayer().getUniqueId())){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void wereld(PlayerChangedWorldEvent e){
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase("world_the_end")){
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
		      e.getPlayer().teleport(spawn);
		}
	}
	
	@EventHandler
	  public void onDeath(PlayerDeathEvent event)
	  {
	    event.setKeepInventory(true);
	    event.getDrops().clear();
	  }
	
	@EventHandler
	  public void onClick2(InventoryClickEvent e)
	  {
      Player p = (Player) e.getWhoClicked();			
     
	      if (e.getCurrentItem().getItemMeta().getDisplayName()
	    		  .equalsIgnoreCase("&4&lKledingKast"
	    		  .replace("&", "§")))
	      {
              KledingKast.openKledingkast(p);
	      }
	    }
	
	@EventHandler
	  public void onClick2f(InventoryClickEvent e)
	  {
    Player p = (Player) e.getWhoClicked();			
   
	      if (e.getCurrentItem().getItemMeta().getDisplayName()
	    		  .equalsIgnoreCase("&4&lTrails"
	    		  .replace("&", "§")))
	      {
            Particles.openKledingkast(p);
	      }
	    }
	
	@EventHandler
	  public void onInventoryInteracth(InventoryInteractEvent e)
	  {
    if(e.getInventory().getName().equalsIgnoreCase("&c&lVanity".replace("&", "§"))){
	      e.setCancelled(true);
  }   
}
	
	@EventHandler
	  public void onInventoryInteracthk(InventoryInteractEvent e)
	  {
  if(e.getInventory().getName().equalsIgnoreCase("&9&lServer Selector".replace("&", "§"))){
	      e.setCancelled(true);
}   
}
	
	@EventHandler
	  public void onInventoryClickhk(InventoryClickEvent e)
	  {
		  if(e.getInventory().getName().equalsIgnoreCase("&9&lServer Selector".replace("&", "§"))){
		      e.setCancelled(true);
	}
}
	  
	  @EventHandler
	  public void onInventoryClickh(InventoryClickEvent e)
	  {
		  if(e.getInventory().getName().equalsIgnoreCase("&c&lVanity".replace("&", "§"))){
		      e.setCancelled(true);
	}
}
	  
	  @EventHandler
	  public void onInventoryInteracthh(InventoryInteractEvent e)
	  {
    if(e.getInventory().getName().equalsIgnoreCase("&4&lTrails".replace("&", "§"))){
	      e.setCancelled(true);
  }   
}
	  
	  @EventHandler
	  public void onInventoryClickhh(InventoryClickEvent e)
	  {
		  if(e.getInventory().getName().equalsIgnoreCase("&4&lTrails".replace("&", "§"))){
		      e.setCancelled(true);
	}
}
	  
	  @EventHandler
	  public void onInventoryInteracthv(InventoryInteractEvent e)
	  {
    if(e.getInventory().getName().equalsIgnoreCase("&4&lKledingKast".replace("&", "§"))){
	      e.setCancelled(true);
  }   
}
	  
	  @EventHandler
	  public void onInventoryClickhv(InventoryClickEvent e)
	  {
		  if(e.getInventory().getName().equalsIgnoreCase("&4&lKledingKast".replace("&", "§"))){
		      e.setCancelled(true);
	}
}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
			if (e.getCause().equals(DamageCause.FALL)) {
				e.setCancelled(true);
			}
			if (e.getCause().equals(DamageCause.FIRE)) {
				e.setCancelled(true);
			}
			if (e.getCause().equals(DamageCause.DROWNING)) {
				e.setCancelled(true);
			}
			if (e.getCause().equals(DamageCause.FLY_INTO_WALL)) {
				e.setCancelled(true);
			}
			if (e.getCause().equals(DamageCause.SUFFOCATION)) {
				e.setCancelled(true);
			}
	}
	
	@EventHandler
	public void onPlayerInteractEntityEvent(EntityDamageByEntityEvent e) {
	    e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerLoseHunger(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	  @EventHandler
	  public void onDropEvent(PlayerDropItemEvent event)
	  {
	    if (!event.getPlayer().isOp()) {
	      event.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onInventoryInteract(InventoryInteractEvent event)
	  {
		  
	    if (!event.getWhoClicked().isOp() || !event.getWhoClicked().hasPermission("prezon.hub.invmove")) {
	      event.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onInventoryClick(InventoryClickEvent event)
	  {
		  if (!event.getWhoClicked().isOp() || !event.getWhoClicked().hasPermission("prezon.hub.invmove")) {
	      event.setCancelled(true);
	    }
	  }
  }