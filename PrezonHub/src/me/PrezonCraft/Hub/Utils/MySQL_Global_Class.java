package me.PrezonCraft.Hub.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.PrezonCraft.Hub.Main;

public class MySQL_Global_Class {
	
	public static void VanityWardrobeHats(Player p){
		      if(Main.sql.getVANITY_HAT(p, "CHICKEN") == 1){
			   p.getInventory().setHelmet(Utils_Wardrobe.skullitem(Material.SKULL_ITEM, "Chicken Skull", "MHF_Chicken"));
			    }
			    if(Main.sql.getVANITY_HAT(p, "PIG") == 1){
			   p.getInventory().setHelmet(Utils_Wardrobe.skullitem(Material.SKULL_ITEM, "Pig Skull", "MHF_Pig"));
				}
			    if(Main.sql.getVANITY_HAT(p, "COW") == 1){
			   p.getInventory().setHelmet(Utils_Wardrobe.skullitem(Material.SKULL_ITEM, "Cow Skull", "MHF_Cow"));
				}
			    if(Main.sql.getVANITY_HAT(p, "RABBIT") == 1){
			  p.getInventory().setHelmet(Utils_Wardrobe.skullitem(Material.SKULL_ITEM, "Rabbit Skull", "MHF_Rabbit"));
				}
			    if(Main.sql.getVANITY_HAT(p, "BAT") == 1){
		      p.getInventory().setHelmet(Utils_Wardrobe.skullitem(Material.SKULL_ITEM, "Bat Skull", "KaarsRecht"));
				}
			    if(Main.sql.getVANITY_HAT(p, "VILLAGER") == 1){
			  p.getInventory().setHelmet(Utils_Wardrobe.skullitem(Material.SKULL_ITEM, "Villager Skull", "MHF_Villager"));
				}
	}
	
	public static void VanityWardrobeChestplate(Player p){
		        if(Main.sql.getVANITY_WARDROBE(p, "CHESTPLATE", "WHITE") == 1){
			   p.getInventory().setChestplate(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_CHESTPLATE, "Chicken Chestplate", 255, 255, 255));
			    }
		        if(Main.sql.getVANITY_WARDROBE(p, "CHESTPLATE", "ROSE") == 1){
			   p.getInventory().setChestplate(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_CHESTPLATE, "Pig Chestplate", 247, 161, 213));
				}
		        if(Main.sql.getVANITY_WARDROBE(p, "CHESTPLATE", "BRUNE") == 1){
			   p.getInventory().setChestplate(Utils_Wardrobe.NormalArmorItem(Material.LEATHER_CHESTPLATE, "Cow Chestplate"));
				}
		        if(Main.sql.getVANITY_WARDROBE(p, "CHESTPLATE", "GRAY") == 1){
			   p.getInventory().setChestplate(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_CHESTPLATE, "Rabbit Chestplate", 129, 128, 128));
				}
		        if(Main.sql.getVANITY_WARDROBE(p, "CHESTPLATE", "BLACK") == 1){
			   p.getInventory().setChestplate(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_CHESTPLATE, "Black Chestplate", 0, 0, 0));
				}
		        if(Main.sql.getVANITY_WARDROBE(p, "CHESTPLATE", "GREEN") == 1){
			   p.getInventory().setChestplate(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_CHESTPLATE, "Green Chestplate", 27, 134, 37));
				}
	}
	
	public static void VanityWardrobeLeggings(Player p){
        if(Main.sql.getVANITY_WARDROBE(p, "LEGGINGS", "WHITE") == 1){
	   p.getInventory().setLeggings(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_LEGGINGS, "Chicken Leggings", 255, 255, 255));
	    }
        if(Main.sql.getVANITY_WARDROBE(p, "LEGGINGS", "ROSE") == 1){
	   p.getInventory().setLeggings(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_LEGGINGS, "Pig Leggings", 247, 161, 213));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "LEGGINGS", "BRUNE") == 1){
	   p.getInventory().setLeggings(Utils_Wardrobe.NormalArmorItem(Material.LEATHER_LEGGINGS, "Cow Leggings"));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "LEGGINGS", "GRAY") == 1){
	   p.getInventory().setLeggings(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_LEGGINGS, "Rabbit Leggings", 129, 128, 128));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "LEGGINGS", "BLACK") == 1){
	   p.getInventory().setLeggings(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_LEGGINGS, "Black Leggings", 0, 0, 0));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "LEGGINGS", "GREEN") == 1){
	   p.getInventory().setLeggings(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_LEGGINGS, "Green Leggings", 27, 134, 37));
        }
}
	
	public static void VanityWardrobeBoots(Player p){
        if(Main.sql.getVANITY_WARDROBE(p, "BOOTS", "WHITE") == 1){
	   p.getInventory().setBoots(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_BOOTS, "Chicken Boots", 255, 255, 255));
	    }
        if(Main.sql.getVANITY_WARDROBE(p, "BOOTS", "ROSE") == 1){
	   p.getInventory().setBoots(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_BOOTS, "Pig Boots", 247, 161, 213));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "BOOTS", "BRUNE") == 1){
	   p.getInventory().setBoots(Utils_Wardrobe.NormalArmorItem(Material.LEATHER_BOOTS, "Cow Boots"));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "BOOTS", "GRAY") == 1){
	   p.getInventory().setBoots(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_BOOTS, "Rabbit Boots", 129, 128, 128));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "BOOTS", "BLACK") == 1){
	   p.getInventory().setBoots(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_BOOTS, "Black Boots", 0, 0, 0));
		}
        if(Main.sql.getVANITY_WARDROBE(p, "BOOTS", "GREEN") == 1){
	   p.getInventory().setBoots(Utils_Wardrobe.ColorArmoritem(Material.LEATHER_BOOTS, "Green Boots", 27, 134, 37));
        }
}
	
	private static void removeAllParticles(Player p){
		Main.flame.remove(p.getUniqueId());
        Main.snow.remove(p.getUniqueId());
        Main.note.remove(p.getUniqueId());
        Main.happy.remove(p.getUniqueId());
        Main.rainbow.remove(p.getUniqueId());
        Main.smoke.remove(p.getUniqueId());
        Main.redstone.remove(p.getUniqueId());
        Main.bubbel.remove(p.getUniqueId());
        Main.cloud.remove(p.getUniqueId());
        Main.heart.remove(p.getUniqueId());
        Main.witch.remove(p.getUniqueId());
        Main.slime.remove(p.getUniqueId());
        Main.enchant.remove(p.getUniqueId());
	}
	
	public static void Hide_All(Player p){
		if(Main.sql.getHIDE_ALL(p) == 0){
			for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
                if (p2 != p) {
                        p.showPlayer(p2);                                   
                }
    	    }
		}else{
			for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
                if (p2 != p) {
                        p.hidePlayer(p2);                                   
                }
    	    }
		}
	}
	
	public static void VanityParticles(Player p){
		if(Main.sql.getVANITY_PARTICLES(p, "WITCH") == 1){
			removeAllParticles(p);
			Main.witch.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "SLIME") == 1){
			removeAllParticles(p);
			Main.slime.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "ENCHANTING") == 1){
			removeAllParticles(p);
			Main.enchant.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "REDSTONE") == 1){
			removeAllParticles(p);
			Main.redstone.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "FLAME") == 1){
			removeAllParticles(p);
			Main.flame.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "CLOUD") == 1){
			removeAllParticles(p);
			Main.cloud.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "SPLASH") == 1){
			removeAllParticles(p);
			Main.bubbel.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "NOTE") == 1){
			removeAllParticles(p);
			Main.note.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "HAPPY") == 1){
			removeAllParticles(p);
			Main.happy.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "SNOW") == 1){
			removeAllParticles(p);
			Main.snow.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "SMOKE") == 1){
			removeAllParticles(p);
			Main.smoke.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "HEART") == 1){
			removeAllParticles(p);
			Main.heart.add(p.getUniqueId());
		}
		if(Main.sql.getVANITY_PARTICLES(p, "RAINBOW") == 1){
			removeAllParticles(p);
			Main.rainbow.add(p.getUniqueId());
		}
	}
	
}
