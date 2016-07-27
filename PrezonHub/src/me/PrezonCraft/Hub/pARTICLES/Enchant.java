package me.PrezonCraft.Hub.pARTICLES;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Utils.ParticleEffect;

public class Enchant implements Listener{
	
	@EventHandler
	  public void MoveEvent(PlayerMoveEvent e){
		  if(Main.enchant.contains(e.getPlayer().getUniqueId())){
		  Player p = (Player)e.getPlayer();
		  ParticleEffect.ENCHANTMENT_TABLE.display(0.1F, 0.2F, 0.1F, 1, 1, p.getLocation(), 1);
		  }
	  }
	
}
