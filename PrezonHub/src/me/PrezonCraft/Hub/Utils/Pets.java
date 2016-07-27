package me.PrezonCraft.Hub.Utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftCreature;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.PrezonCraft.Hub.Main;

public class Pets {
	
	public Pets(){
	}
	
	public void createPet(Player player,EntityType type){
	    if(Main.pets.containsKey(player)){
			Main.pets.get(player).remove();
		}
		Entity entity = (Entity)player.getWorld().spawnEntity(player.getLocation(), type);
		entity.setCustomName(ChatColor.translateAlternateColorCodes('&', "hi"));
		entity.setCustomNameVisible(true);
		Main.pets.put(player, entity);
		Location loc = new Location(entity.getWorld(), entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ());
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){
			@Override
			public void run() {
				ParticleEffect.LAVA.display(0, 0, 0, 10, 10, loc, 9999);
			}
		}, 5);
	}
	
	@SuppressWarnings("deprecation")
	public void followPlayer(Creature creature,Player player,double Speed){
		Location location = player.getLocation();
		
		
		Random rnd = new Random();
		int zufall = rnd.nextInt(6);
		switch(zufall){
		case 0:
			location.add(1.5,0,1.5);
			break;
		case 1:
			location.add(0,0,1.5);
			break;
		case 2:
			location.add(1.5,0,0);
			break;
		case 3:
			location.subtract(1.5,0,1.5);
			break;
		case 4:
			location.subtract(0,0,1.5);
			break;
		case 5:
			location.subtract(1.5,0,0);
			break;
		}
		
		
		if(location.distanceSquared(creature.getLocation()) > 100){
			if(!player.isOnGround()){
                 return;
			}
			creature.teleport(location);
		}else{
		((CraftCreature)creature).getHandle().getNavigation().a(location.getX(),location.getY(),location.getZ(),Speed);
		}
	}

}
