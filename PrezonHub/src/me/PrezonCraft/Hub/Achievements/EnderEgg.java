package me.PrezonCraft.Hub.Achievements;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.API.ScoreboardAPI;
import me.PrezonCraft.Hub.Managers.ConfigManager;

public class EnderEgg implements Listener{

	static ConfigManager settings = ConfigManager.getInstance();
	
	
	@EventHandler
	  public void onInventoryInteract(InventoryInteractEvent e)
	  {
      if(e.getInventory().getName().equalsIgnoreCase("&a&lAchievements".replace("&", "§"))){
	      e.setCancelled(true);
    }   
}
	  
	  @EventHandler
	  public void onInventoryClick(InventoryClickEvent e)
	  {
		  if(e.getInventory().getName().equalsIgnoreCase("&a&lAchievements".replace("&", "§"))){
		      e.setCancelled(true);
	}
	  }
	
	@EventHandler
	public void onSlaHetEi(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType().equals(Material.DRAGON_EGG)){
				Block block = e.getClickedBlock();
				Player p = e.getPlayer();
				block.getType().equals(Material.DRAGON_EGG);
				e.setCancelled(true);
		if(Main.sql.getLOBBY_EGG(p) == 0){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAchievements &f>> &aJe hebt de EnderEgg gevonden! Als beloning krijg je 20 punten!"));
			Main.sql.setLOBBY_EGG(p, 1);
			Main.sql.setTOTAAL_ACHIEVEMENTS(p, Main.sql.getTOTAAL_ACHIEVEMENTS(p) + 1);
			Main.sql.setPUNTEN(p, Main.sql.getPUNTEN(p) + 20);
			ScoreboardAPI.Scoreboard(p);
		}else{
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAchievements &f>> &cJe hebt deze achievement al behaalt!!"));
		}
	}
}
}
}
