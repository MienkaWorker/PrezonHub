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

public class AchievmentsLobby {
	
	public static void Menu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9*3, "&a&lAchievements".replace("&", "§"));

        ItemStack barrier = new ItemStack(Material.BOOK,1);
        ItemMeta barriermeta = barrier.getItemMeta();
        barriermeta.setDisplayName("&6Eerste keer op PrezonCraft!".replace("&", "§"));
        List<String> lore = new ArrayList<String>();
        lore.add("&fLog de eerste keer in op PrezonCraft!".replace("&", "§"));
        lore.add("&a&l✓ UNLOCKED".replace("&", "§"));
        barriermeta.setLore(lore);
        barrier.setItemMeta(barriermeta);
        
        ItemStack barrier2 = new ItemStack(Material.DRAGON_EGG,1);
        ItemMeta barrier2meta = barrier2.getItemMeta();
        barrier2meta.setDisplayName("&6Vind het ei!".replace("&", "§"));
        List<String> lore2 = new ArrayList<String>();
        lore2.add("&fVind de EnderEgg in de lobby!".replace("&", "§"));
      if(Main.sql.getLOBBY_EGG(p) == 0){
    	  lore2.add("&c&l✗ LOCKED".replace("&", "§"));
      }else{
        lore2.add("&a&l✓ UNLOCKED".replace("&", "§"));
      }
        barrier2meta.setLore(lore2);
        barrier2.setItemMeta(barrier2meta);
        
        ItemStack barrier20 = new ItemStack(Material.DIAMOND_BOOTS,1);
        ItemMeta barrier20meta = barrier20.getItemMeta();
        barrier20meta.setDisplayName("&6Haal het parkour!".replace("&", "§"));
        List<String> lore20 = new ArrayList<String>();
        lore20.add("&fHaal jij het parkour?!".replace("&", "§"));
      if(Main.sql.getLOBBY_PARKOUR(p) == 0){
    	  lore20.add("&c&l✗ LOCKED".replace("&", "§"));
      }else{
        lore20.add("&a&l✓ UNLOCKED".replace("&", "§"));
      }
        barrier20meta.setLore(lore20);
        barrier20.setItemMeta(barrier20meta);
        
        ItemStack barrier200 = new ItemStack(Material.WOOL,1);
        ItemMeta barrier200meta = barrier200.getItemMeta();
        barrier200meta.setDisplayName("&6Haal de dropper!".replace("&", "§"));
        List<String> lore200 = new ArrayList<String>();
        lore200.add("&fKan jij naar beneden vallen zonder iets te raken?".replace("&", "§"));
      if(Main.sql.getLOBBY_DROPPER(p) == 0){
    	  lore200.add("&c&l✗ LOCKED".replace("&", "§"));
      }else{
        lore200.add("&a&l✓ UNLOCKED".replace("&", "§"));
      }
        barrier200meta.setLore(lore200);
        barrier200.setItemMeta(barrier200meta);
        
        ItemStack barrier2000 = new ItemStack(Material.BARRIER,1);
        ItemMeta barrier2000meta = barrier2000.getItemMeta();
        barrier2000meta.setDisplayName("&6Soon!".replace("&", "§"));
        List<String> lore2000 = new ArrayList<String>();
        lore2000.add("&fSoon!".replace("&", "§"));
        lore2000.add("&c&l✗ LOCKED".replace("&", "§"));
        barrier2000meta.setLore(lore2000);
        barrier2000.setItemMeta(barrier2000meta);
       
        inv.setItem(0, barrier);
        inv.setItem(2, barrier2);
        inv.setItem(4, barrier20);
        inv.setItem(6, barrier200);
        inv.setItem(8, barrier2000);
        
        p.openInventory(inv);
    }

}
