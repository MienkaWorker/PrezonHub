package me.PrezonCraft.Hub.Listener;

import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.data.User;
import org.anjocaido.groupmanager.dataholder.OverloadedWorldHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ChatEvent {
	
	public static User getGMUser(Player player){
        Plugin gm_plugin = Bukkit.getServer().getPluginManager()
                .getPlugin("GroupManager");
        if (gm_plugin instanceof GroupManager) {
            GroupManager gm = (GroupManager) gm_plugin;
            OverloadedWorldHolder world = gm.getWorldsHolder()
                    .getWorldDataByPlayerName(player.getName());
            return world.getUser(player.getName());
        }
        return null; // GroupManager not found
    }

}
