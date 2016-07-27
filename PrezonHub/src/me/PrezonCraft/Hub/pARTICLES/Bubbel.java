package me.PrezonCraft.Hub.pARTICLES;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Utils.ParticleEffect;

public class Bubbel implements Listener{
	
	@EventHandler
	  public void MoveEvent(PlayerMoveEvent e){
		  if(Main.bubbel.contains(e.getPlayer().getUniqueId())){
		  Player p = (Player)e.getPlayer();
		  ParticleEffect.WATER_SPLASH.display(0.1F, 0.1F, 0.1F, 1, 1, p.getLocation(), 1);
		  }
	  }
}
