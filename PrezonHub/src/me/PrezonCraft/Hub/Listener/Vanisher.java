package me.PrezonCraft.Hub.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.PrezonCraft.Hub.Main;

public class Vanisher implements Listener {
	
	 @EventHandler
	    public void onPlayerInteract2(PlayerInteractEvent e) {
	            if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
	                    return;
	            }
	           
	            if (e.getItem().getType() != Material.INK_SACK) {
	                    return;
	            }
	           
	            if (
	                            !e.getItem().hasItemMeta() ||
	                            !e.getItem().getItemMeta().hasDisplayName() ||
	                            !e.getItem().getItemMeta().getDisplayName().equals("&2&lSpelers &f&lUIT".replace("&", "§"))) {
	                    return;
	            }
	            
	            Player p3 = (Player) e.getPlayer();
	   		 if (Main.cooldownTime.containsKey(p3)) {
	   			if (Main.cooldownTime.get(p3) == 1) {
	   			 p3.sendMessage("&f[&2&lPrezonCraft&f] Je moet nog &2".replace("&", "§") + Main.cooldownTime.get(p3) + "&f second wachten!".replace("&", "§"));
	   			}else{
	   				p3.sendMessage("&f[&2&lPrezonCraft&f] Je moet nog &2".replace("&", "§") + Main.cooldownTime.get(p3) + "&f seconden wachten!".replace("&", "§"));
	   			}
	                return;
	        }
	           
	          	  
	          	  ItemStack torch = new ItemStack(Material.INK_SACK, 1, (short) 10);
		    	    ItemMeta torchmeta = torch.getItemMeta();
		    	    torchmeta.setDisplayName("&2&lSpelers &f&lAAN".replace("&", "§"));
		    	    torch.setItemMeta(torchmeta);
		    	    Main.sql.setHIDE_ALL(p3, 0);
		    	    
		    	    
		    	    for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
	                    if (p2 != e.getPlayer()) {
	                            e.getPlayer().showPlayer(p2);                                   
	                    }
		    	    }
	                  	        
	                            Player p = (Player) e.getPlayer();
	                            p.getInventory().setItemInMainHand(torch);
	                            p.sendMessage("&f[&2&lPrezonCraft&f] Je ziet iedereen weer!"
	                          		  .replace("&", "§"));
	                            Main.cooldownTime.put(p, 5);
	                            Main.cooldownTask.put(p, new BukkitRunnable() {
		                                public void run() {
		                                	Main.cooldownTime.put(p, Main.cooldownTime.get(p) - 1);
		                                        if (Main.cooldownTime.get(p) == 0) {
		                                        	Main.cooldownTime.remove(p);
		                                        	Main.cooldownTask.remove(p);
		                                                cancel();
		                                        }
		                                }
		                        });
	                            Main.cooldownTask.get(p).runTaskTimer(Main.plugin, 20, 20);
		                }		
	  
	  @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
            if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
                    return;
            }
           
            if (e.getItem().getType() != Material.INK_SACK) {
                    return;
            }
           
            if (
                            !e.getItem().hasItemMeta() ||
                            !e.getItem().getItemMeta().hasDisplayName() ||
                            !e.getItem().getItemMeta().getDisplayName().equals("&2&lSpelers &f&lAAN".replace("&", "§"))) {
                    return;
            }
            
            Player p3 = (Player) e.getPlayer();
            if (Main.cooldownTime.containsKey(p3)) {
	   			if (Main.cooldownTime.get(p3) == 1) {
	   			 p3.sendMessage("&f[&2&lPrezonCraft&f] Je moet nog &2".replace("&", "§") + Main.cooldownTime.get(p3) + "&f second wachten!".replace("&", "§"));
	   			}else{
	   				p3.sendMessage("&f[&2&lPrezonCraft&f] Je moet nog &2".replace("&", "§") + Main.cooldownTime.get(p3) + "&f seconden wachten!".replace("&", "§"));
	   			}
	                return;
	        }
           
          	  
          	  ItemStack torch = new ItemStack(Material.INK_SACK, 1, (short) 8);
	    	    ItemMeta torchmeta = torch.getItemMeta();
	    	    torchmeta.setDisplayName("&2&lSpelers &f&lUIT".replace("&", "§"));
	    	    torch.setItemMeta(torchmeta);
	    	    Main.sql.setHIDE_ALL(p3, 1);
	    	    
	    	    for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
                    if (p2 != e.getPlayer()) {
                            e.getPlayer().hidePlayer(p2);                                   
                    }
	    	    }
	    	    
	    	    Player p = (Player) e.getPlayer();
                p.getInventory().setItemInMainHand(torch);
                p.sendMessage("&f[&2&lPrezonCraft&f] Je ziet niemand meer!"
              		  .replace("&", "§"));
                Main.cooldownTime.put(p, 5);
                Main.cooldownTask.put(p, new BukkitRunnable() {
                        public void run() {
                        	Main.cooldownTime.put(p, Main.cooldownTime.get(p) - 1);
                                if (Main.cooldownTime.get(p) == 0) {
                                	Main.cooldownTime.remove(p);
                                	Main.cooldownTask.remove(p);
                                        cancel();
                                }
                        }
                });
                Main.cooldownTask.get(p).runTaskTimer(Main.plugin, 20, 20);
    }

}