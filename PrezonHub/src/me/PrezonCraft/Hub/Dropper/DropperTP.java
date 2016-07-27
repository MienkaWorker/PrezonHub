package me.PrezonCraft.Hub.Dropper;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class DropperTP implements Listener{
	
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		ArenaManager.DropperTP("DropperTp", e.getPlayer());
		ArenaManager.EnterDropper("EnterDropper", e.getPlayer());
		ArenaManager.FinDropper("FinDropper", e.getPlayer());
	}

}
