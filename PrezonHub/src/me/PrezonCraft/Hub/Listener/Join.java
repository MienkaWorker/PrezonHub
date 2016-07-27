package me.PrezonCraft.Hub.Listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.API.ScoreboardAPI;
import me.PrezonCraft.Hub.Utils.PacketUtils;

public class Join implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1, 1);
		p.performCommand("spawn");
		Main.sql.createAccount(p);	
  }
	
	@EventHandler
	  public void onJoin1(PlayerJoinEvent e)
	  {
	    Player p = e.getPlayer();
	    PacketUtils.sendTabHF(p, "     &2&lPrezonCraft     ".replace("&", "§"), "     &f&lplay.prezoncraft.nl     ".replace("&", "§"));
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Member")){
	    	p.setPlayerListName("§8" + p.getName());
	    }
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Owner")){
	    	p.setPlayerListName("§4§l" + p.getName());
	    }
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Helper")){
	    	p.setPlayerListName("§a" + p.getName());
	    }
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Moderator")){
	    	p.setPlayerListName("§3" + p.getName());
	    }
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Builder")){
	    	p.setPlayerListName("§6" + p.getName());
	    }
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Admin")){
	    	p.setPlayerListName("§c" + p.getName());
	    }
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Developer")){
	    	p.setPlayerListName("§9" + p.getName());
	    }
	    if(ChatEvent.getGMUser(p).getGroup().getName().equalsIgnoreCase("Twitch")){
	    	p.setPlayerListName("§5" + p.getName());
	    }
	  }
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		ScoreboardAPI.Scoreboard(e.getPlayer());
		Main.parkour.remove(e.getPlayer());
		e.setJoinMessage("");
	}
	
	@EventHandler
	public void onJoin2(PlayerQuitEvent e){
		Main.parkour.remove(e.getPlayer());
		e.setQuitMessage("");
	}
	
}
