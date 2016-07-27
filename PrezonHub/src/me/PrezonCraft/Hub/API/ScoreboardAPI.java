package me.PrezonCraft.Hub.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.PrezonCraft.Hub.Main;
import me.PrezonCraft.Hub.Managers.ConfigManager;

public class ScoreboardAPI {
	
	static ConfigManager settings = ConfigManager.getInstance();
	
	public static void Scoreboard(Player p)
	  {
	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    Scoreboard board = manager.getNewScoreboard();
	    Objective objective = board.registerNewObjective("test", "dummy");
	    
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    objective.setDisplayName(
	    ChatColor.translateAlternateColorCodes('&', "      " + "&2&lPrezonCraft" + "      "));

	      Score score3 = objective.getScore(ChatColor.translateAlternateColorCodes('&', " "));
	      score3.setScore(7);

	      Score score2 = objective.getScore("&fPunten:".replace("&", "§"));
	      score2.setScore(6);
	    
	      Score score000 = objective.getScore(" &a&l".replace("&", "§") + String.valueOf(Main.sql.getPUNTEN(p)));
	      score000.setScore(5);

	      Score score4 = objective.getScore("&9&l ".replace("&", "§"));
	      score4.setScore(4);
	      
	      Score score5 = objective.getScore("&fAchievements:".replace("&", "§"));
	      score5.setScore(3);
	    
	      Score score00000 = objective.getScore(" &a&l".replace("&", "§") + String.valueOf(Main.sql.getTOTAAL_ACHIEVEMENTS(p)) + "/4".replace("&", "§"));
	      score00000.setScore(2);

	      Score score6 = objective.getScore(
	      ChatColor.translateAlternateColorCodes('&', "&c&l "));
	      score6.setScore(1);
	      
	      Score score60 = objective.getScore(
	    	      ChatColor.translateAlternateColorCodes('&', "&fplay.prezoncraft.nl"));
	    	      score60.setScore(0);
	    
	    p.setScoreboard(board);
	  }

}
