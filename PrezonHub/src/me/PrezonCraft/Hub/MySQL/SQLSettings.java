package me.PrezonCraft.Hub.MySQL;

import java.sql.ResultSet;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SQLSettings {
	
	private JavaPlugin instance;
	private MySQL mysql;

	public SQLSettings(JavaPlugin plugin, String Host, String User, String DB, String Pass) {
		this.instance = plugin;
		this.mysql = new MySQL(User, Pass, Host, DB);
		this.mysql.Update(
		"CREATE TABLE IF NOT EXISTS Lobby_Achievements(username varchar(100) PRIMARY KEY, LOBBY_PARKOUR int NOT NULL, LOBBY_EGG int NOT NULL, LOBBY_DROPPER int NOT NULL)");
		this.mysql.Update(
		"CREATE TABLE IF NOT EXISTS Skywars_Achievements(username varchar(100) PRIMARY KEY, SW_KILLS int NOT NULL, SW_ARROWS_SHOOT int NOT NULL, SW_ENDERPEARLS int NOT NULL, SW_BLOCKS_BROKEN int NOT NULL, SW_PREZON_KILLS int NOT NULL)");

		this.mysql.Update(
		"CREATE TABLE IF NOT EXISTS Settings(username varchar(100) PRIMARY KEY, LEVEL int NOT NULL, TOTAAL_ACHIEVEMENTS int NOT NULL , PUNTEN int NOT NULL, EXP int NOT NULL, HIDE_ALL int NOT NULL, PLAYER_STACKER int NOT NULL, BOOSTER_SKYWARS int NOT NULL, BOOSTER_FACTIONS int NOT NULL)");

		
	    this.mysql.Update(
		"CREATE TABLE IF NOT EXISTS Vanity_Hats(username varchar(100) PRIMARY KEY, HAT_CHICKEN int NOT NULL, HAT_PIG int NOT NULL, HAT_COW int NOT NULL, HAT_RABBIT int NOT NULL, HAT_BAT int NOT NULL, HAT_VILLAGER int NOT NULL)");
	    this.mysql.Update(
			"CREATE TABLE IF NOT EXISTS Vanity_Wardrobe(username varchar(100) PRIMARY KEY,"
			+ " CHESTPLATE_WHITE int NOT NULL, CHESTPLATE_ROSE int NOT NULL, CHESTPLATE_BRUNE int NOT NULL, CHESTPLATE_GRAY int NOT NULL, CHESTPLATE_BLACK int NOT NULL, CHESTPLATE_GREEN int NOT NULL,"
			+ " LEGGINGS_WHITE int NOT NULL, LEGGINGS_ROSE int NOT NULL, LEGGINGS_BRUNE int NOT NULL, LEGGINGS_GRAY int NOT NULL, LEGGINGS_BLACK int NOT NULL, LEGGINGS_GREEN int NOT NULL,"
			+ " BOOTS_WHITE int NOT NULL, BOOTS_ROSE int NOT NULL, BOOTS_BRUNE int NOT NULL, BOOTS_GRAY int NOT NULL, BOOTS_BLACK int NOT NULL, BOOTS_GREEN int NOT NULL)");
	    this.mysql.Update(
	    		"CREATE TABLE IF NOT EXISTS Vanity_Particles(username varchar(100) PRIMARY KEY, PARTCILE_WITCH int NOT NULL, PARTCILE_SLIME int NOT NULL, PARTCILE_ENCHANTING int NOT NULL, PARTCILE_REDSTONE int NOT NULL, PARTCILE_FLAME int NOT NULL, PARTCILE_CLOUD int NOT NULL, PARTCILE_SPLASH int NOT NULL, PARTCILE_NOTE int NOT NULL, PARTCILE_HAPPY int NOT NULL, PARTCILE_SNOW int NOT NULL, PARTCILE_SMOKE int NOT NULL, PARTCILE_HEART int NOT NULL, PARTCILE_RAINBOW int NOT NULL)");    
	}

	public void createAccount(Player p) {
		boolean Lobby_AchievementsExist = false;
		boolean SettingsExist = false;
		boolean Skywars_AchievementsExist = false;
		boolean Vanity_HatsExist = false;
		boolean Vanity_WardrobeExist = false;
		boolean Vanity_ParticlesExist = false;
		
		try {
			ResultSet rs = this.mysql
					.Query("SELECT username FROM Settings WHERE username='" + p.getName() + "' LIMIT 1");
			if (rs.next()) {
				SettingsExist = true;
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		if (!SettingsExist) {
			this.mysql
					.Update("INSERT INTO Settings(username,LEVEL,TOTAAL_ACHIEVEMENTS,PUNTEN,EXP,HIDE_ALL,PLAYER_STACKER) values ('"
							+ p.getName() + "','" + 1 + "','" + 1 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + 0 + "','" + 0 + "')");
		}
		
		try {
			ResultSet rs = this.mysql
					.Query("SELECT username FROM Vanity_Particles WHERE username='" + p.getName() + "' LIMIT 1");
			if (rs.next()) {
			Vanity_ParticlesExist = true;
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		if (!Vanity_ParticlesExist) {
			this.mysql
					.Update("INSERT INTO Vanity_Particles(username,PARTCILE_WITCH,PARTCILE_SLIME,PARTCILE_ENCHANTING,PARTCILE_REDSTONE,PARTCILE_FLAME,PARTCILE_CLOUD,PARTCILE_SPLASH,PARTCILE_NOTE,PARTCILE_HAPPY,PARTCILE_SNOW,PARTCILE_SMOKE,PARTCILE_HEART, PARTCILE_RAINBOW) values ('"
							+ p.getName() + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "')");
		}
		
		try {
			ResultSet rs = this.mysql
					.Query("SELECT username FROM Vanity_Wardrobe WHERE username='" + p.getName() + "' LIMIT 1");
			if (rs.next()) {
			Vanity_WardrobeExist = true;
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		if (!Vanity_WardrobeExist) {
			this.mysql
					.Update("INSERT INTO Vanity_Wardrobe(username,CHESTPLATE_WHITE, CHESTPLATE_ROSE, CHESTPLATE_BRUNE, CHESTPLATE_GRAY, CHESTPLATE_BLACK, CHESTPLATE_GREEN,"
			+ " LEGGINGS_WHITE, LEGGINGS_ROSE, LEGGINGS_BRUNE, LEGGINGS_GRAY, LEGGINGS_BLACK, LEGGINGS_GREEN,"
			+ " BOOTS_WHITE, BOOTS_ROSE, BOOTS_BRUNE, BOOTS_GRAY, BOOTS_BLACK, BOOTS_GREEN) values ('"
							+ p.getName() + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "')");
		}
		
		
		
		
		try {
			ResultSet rs = this.mysql
					.Query("SELECT username FROM Vanity_Hats WHERE username='" + p.getName() + "' LIMIT 1");
			if (rs.next()) {
			Vanity_HatsExist = true;
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		if (!Vanity_HatsExist) {
			this.mysql
					.Update("INSERT INTO Vanity_Hats(username,HAT_CHICKEN, HAT_PIG, HAT_COW,HAT_RABBIT,HAT_BAT,HAT_VILLAGER) values ('"
							+ p.getName() + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0+ "','" + 0 + "','" + 0 + "')");
		}
		
		
		
		
		try {
			ResultSet rs = this.mysql
					.Query("SELECT username FROM Lobby_Achievements WHERE username='" + p.getName() + "' LIMIT 1");
			if (rs.next()) {
			Lobby_AchievementsExist = true;
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		if (!Lobby_AchievementsExist) {
			this.mysql
					.Update("INSERT INTO Lobby_Achievements(username,LOBBY_PARKOUR, LOBBY_EGG, LOBBY_DROPPER) values ('"
							+ p.getName() + "','" + 0 + "','" + 0 + "','" + 0 + "')");
		}
		
		
		
		
		try {
			ResultSet rs = this.mysql
					.Query("SELECT username FROM Skywars_Achievements WHERE username='" + p.getName() + "' LIMIT 1");
			if (rs.next()) {
			Skywars_AchievementsExist = true;
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		if (!Skywars_AchievementsExist) {
			this.mysql
					.Update("INSERT INTO Skywars_Achievements(username,SW_KILLS, SW_ARROWS_SHOOT, SW_ENDERPEARLS,SW_BLOCKS_BROKEN,SW_PREZON_KILLS) values ('"
							+ p.getName() + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "')");
		}
		
	}

	public String Security(String name) {
		name = name.replaceAll(";", " ");
		name = name.replaceAll(",", " ");
		name = name.replaceAll("'", " ");
		name = name.replaceAll("", " ");
		return name;
	}

	public int getLOBBY_PARKOUR(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT LOBBY_PARKOUR FROM Lobby_Achievements WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getBOOSTER(Player p, String SERVER) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT BOOSTER_" + SERVER + " FROM Settings WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getVANITY_PARTICLES(Player p, String PARTICLETYPE) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT PARTCILE_" + PARTICLETYPE + " FROM Vanity_Particles WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getVANITY_WARDROBE(Player p, String TYPE, String COLOR) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT " + TYPE + "_" + COLOR + " FROM Vanity_Wardrobe WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getVANITY_HAT(Player p,String HAT) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT HAT_" + HAT + " FROM Vanity_Hats WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getLOBBY_EGG(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT LOBBY_EGG FROM Lobby_Achievements WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getLOBBY_DROPPER(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT LOBBY_DROPPER FROM Lobby_Achievements WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}

	public int getTOTAAL_ACHIEVEMENTS(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT TOTAAL_ACHIEVEMENTS FROM Settings WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getPUNTEN(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT PUNTEN FROM Settings WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getLEVEL(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT LEVEL FROM Settings WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getEXP(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT EXP FROM Settings WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getHIDE_ALL(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT HIDE_ALL FROM Settings WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public int getPLAYER_STACKER(Player p) {
		int c = 0;
		try {
			ResultSet rs = this.mysql.Query("SELECT PLAYER_STACKER FROM Settings WHERE username='" + p.getName() + "'");
			while (rs.next()) {
				c = rs.getInt(1);
			}
		} catch (Exception err) {
			System.err.println(err);
		}
		return c;
	}
	
	public void setLEVEL(Player p, int amount) {
		this.mysql.Update("UPDATE Settings SET LEVEL='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setEXP(Player p, int amount) {
		this.mysql.Update("UPDATE Settings SET EXP='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setHIDE_ALL(Player p, int amount) {
		this.mysql.Update("UPDATE Settings SET HIDE_ALL='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setPLAYER_STACKER(Player p, int amount) {
		this.mysql.Update("UPDATE Settings SET PLAYER_STACKER='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setLOBBY_PARKOUR(Player p, int amount) {
		this.mysql.Update("UPDATE Lobby_Achievements SET LOBBY_PARKOUR='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setLOBBY_EGG(Player p, int amount) {
		this.mysql.Update("UPDATE Lobby_Achievements SET LOBBY_EGG='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setLOBBY_DROPPER(Player p, int amount) {
		this.mysql.Update("UPDATE Lobby_Achievements SET LOBBY_DROPPER='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setVANITY_HAT(Player p, int amount, String HAT) {
		this.mysql.Update("UPDATE Vanity_Hats SET HAT_" + HAT + "='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setVANITY_PARTICLES(Player p, int amount, String PARTICLETYPE) {
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_" + PARTICLETYPE + "='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setTOTAAL_ACHIEVEMENTS(Player p, int amount) {
		this.mysql.Update("UPDATE Settings SET TOTAAL_ACHIEVEMENTS='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setBOOSTER(Player p, int amount, String SERVER) {
		this.mysql.Update("UPDATE Settings SET BOOSTER_" + SERVER + "='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setVANITY_HAT_ALL(Player p) {
		this.mysql.Update("UPDATE Vanity_Hats SET HAT_CHICKEN='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Hats SET HAT_COW='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Hats SET HAT_PIG='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Hats SET HAT_RABBIT='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Hats SET HAT_BAT='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Hats SET HAT_VILLAGER='" + 0 + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setVANITY_PARTICLES_ALL(Player p) {
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_WITCH ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_SLIME ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_ENCHANTING ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_REDSTONE ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_FLAME ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_CLOUD ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_SPLASH ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_NOTE ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_HAPPY ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_SNOW ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_SMOKE ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_HEART ='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Particles SET PARTCILE_RAINBOW ='" + 0 + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setVANITY_WARDROBE_ALL(Player p, String TYPE) {
		this.mysql.Update("UPDATE Vanity_Wardrobe SET " + TYPE + "_WHITE" + "='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Wardrobe SET " + TYPE + "_ROSE" + "='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Wardrobe SET " + TYPE + "_BRUNE" + "='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Wardrobe SET " + TYPE + "_GRAY" + "='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Wardrobe SET " + TYPE + "_BLACK" + "='" + 0 + "' WHERE username='" + p.getName() + "'");
		this.mysql.Update("UPDATE Vanity_Wardrobe SET " + TYPE + "_GREEN" + "='" + 0 + "' WHERE username='" + p.getName() + "'");
	}
	
	public void setPUNTEN(Player p, int amount) {
		this.mysql.Update("UPDATE Settings SET PUNTEN='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
	public void setVANITY_WARDROBE(Player p, int amount, String TYPE, String COLOR) {
		this.mysql.Update("UPDATE Vanity_Wardrobe SET " + TYPE + "_" + COLOR + "='" + (amount) + "' WHERE username='" + p.getName() + "'");
	}
}