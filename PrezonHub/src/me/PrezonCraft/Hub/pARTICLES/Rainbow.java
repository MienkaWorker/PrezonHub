package me.PrezonCraft.Hub.pARTICLES;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.PrezonCraft.Hub.Main;

public class Rainbow implements Listener{
	
	@EventHandler
	  public void MoveEvent00(PlayerMoveEvent e){
		  if(Main.rainbow.contains(e.getPlayer().getUniqueId())){
		  Player p = (Player)e.getPlayer();
		  
		 
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.COLOURED_DUST, 1);
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.COLOURED_DUST, 1);
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.COLOURED_DUST, 1);
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.COLOURED_DUST, 1);
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.COLOURED_DUST, 1);
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.POTION_SWIRL, 1);
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.POTION_SWIRL, 1);
		   p.getWorld().playEffect(p.getLocation().add(0, 0, 0), Effect.POTION_SWIRL, 1);
		  
		  }
	  }

}
