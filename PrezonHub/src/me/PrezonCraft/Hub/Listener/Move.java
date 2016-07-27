package me.PrezonCraft.Hub.Listener;

import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Utils.Pets;

public class Move implements Listener{

	
	@EventHandler
	public void onMove(PlayerMoveEvent event){
		Player player = (Player)event.getPlayer();
		if(Main.pets.containsKey(player)){
		new Pets().followPlayer((Creature)Main.pets.get(player), player, 1.6);
		}
	}
}