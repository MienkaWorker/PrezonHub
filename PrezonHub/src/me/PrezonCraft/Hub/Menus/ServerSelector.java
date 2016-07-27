package me.PrezonCraft.Hub.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Utils.Public_Utils;

public class ServerSelector {
	
	public static void Selector(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9*5, "&9&lServer Selector".replace("&", "§"));

        ItemStack barrier = new ItemStack(Material.TNT,1);
        ItemMeta barriermeta = barrier.getItemMeta();
        barriermeta.setDisplayName("&f&l➸ &c&lFactions".replace("&", "§"));
     
        barrier.setItemMeta(barriermeta);
        
        ItemStack barrier2 = new ItemStack(Material.BOW,1);
        ItemMeta barrier2meta = barrier2.getItemMeta();
        barrier2meta.setDisplayName("&f&l➸ &9&lSkywars".replace("&", "§"));
     
        barrier2.setItemMeta(barrier2meta);
        
        ItemStack barrier20 = new ItemStack(Material.BOOK,1);
        ItemMeta barrier20meta = barrier20.getItemMeta();
        barrier20meta.setDisplayName("&9Sluit menu".replace("&", "§"));
     
        barrier20.setItemMeta(barrier20meta);
        
        ItemStack barrier200 = new ItemStack(Material.EXP_BOTTLE,1);
        ItemMeta barrier200meta = barrier200.getItemMeta();
        barrier200meta.setDisplayName("&".replace("&", "§6Boosters"));
     
        barrier200.setItemMeta(barrier200meta);
        
        ItemStack barrier2000 = new ItemStack(Material.PAPER,1);
        ItemMeta barrier2000meta = barrier2000.getItemMeta();
        barrier2000meta.setDisplayName("&".replace("&", "§6Settings"));
     
        barrier2000.setItemMeta(barrier2000meta);
       
        inv.setItem(20, barrier);
        inv.setItem(24, barrier2);
        inv.setItem(44, barrier200);
        inv.setItem(36, barrier2000);
        List<String> lore = new ArrayList<String>();
        lore.add("&9Punten&8: &7".replace("&", "§") + Main.sql.getPUNTEN(player));
        lore.add("&9Level&8: &7".replace("&", "§") + Main.sql.getLEVEL(player));
        lore.add("&9Exp&8: &7".replace("&", "§") + Main.sql.getEXP(player) + "/1000");
        inv.setItem(39, Public_Utils.skullitem("&6SpelerInfo: &2" + player.getName(), player.getName(), lore));
        inv.setItem(40, barrier20);
        List<String> lore2 = new ArrayList<String>();
        inv.setItem(41, Public_Utils.skullitem("&6Shop: &2(link)", "PrezonCraft", lore2));
        
        player.openInventory(inv);
    }
}
