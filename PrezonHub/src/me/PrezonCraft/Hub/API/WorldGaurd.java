package me.PrezonCraft.Hub.API;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class WorldGaurd {
	
	 public static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
     
        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null; // Maybe you want throw an exception instead
        }
     
        return (WorldGuardPlugin) plugin;
    }

    
    public boolean containsMember(ProtectedRegion r, UUID player) {
		if(player == null) {
			return false;
		} else {
			String name = Bukkit.getOfflinePlayer(player).getName();
			return name != null && r.getMembers().contains(name);
		}
	}

}
