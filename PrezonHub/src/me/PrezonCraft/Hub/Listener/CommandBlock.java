package me.PrezonCraft.Hub.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.PrezonCraft.Hub.Main;

public class CommandBlock implements Listener{
	
	@EventHandler
	public void Command(PlayerCommandPreprocessEvent e){
	for(String word : Main.plugin.getConfig().getStringList("DisabledCommands")){
      if(e.getMessage().equalsIgnoreCase(word) && !(e.getPlayer().isOp())){
			sendNon(e.getPlayer());
			e.setCancelled(true);
		}
	}	
}
	
	public void sendNon(Player p){
		p.sendMessage("§c§lJe hebt geen toegang tot dit commando!");
	}

}
