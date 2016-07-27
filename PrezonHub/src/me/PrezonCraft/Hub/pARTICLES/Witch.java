package me.PrezonCraft.Hub.pARTICLES;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Utils.ParticleEffect;

public class Witch implements Listener{
	
	@EventHandler
	  public void MoveEvent00(PlayerMoveEvent e){
		  if(Main.witch.contains(e.getPlayer().getUniqueId())){
		  Player p = (Player)e.getPlayer();
		  
		  ParticleEffect.SPELL_WITCH.display(0.1F, 0F, 0.1F, 0, 1, p.getLocation(), 1);
		  
		  }
	  }
}
