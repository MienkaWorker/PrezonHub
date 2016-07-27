package me.PrezonCraft.Hub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.PrezonCraft.Hub.API.ScoreboardAPI;
import me.PrezonCraft.Hub.Achievements.EnderEgg;
import me.PrezonCraft.Hub.Dropper.DropperHit;
import me.PrezonCraft.Hub.Dropper.DropperTP;
import me.PrezonCraft.Hub.Listener.AntiShit;
import me.PrezonCraft.Hub.Listener.CommandBlock;
import me.PrezonCraft.Hub.Listener.Join;
import me.PrezonCraft.Hub.Listener.JoinItems;
import me.PrezonCraft.Hub.Listener.Move;
import me.PrezonCraft.Hub.Listener.No_Weather;
import me.PrezonCraft.Hub.Listener.UseJoinItems;
import me.PrezonCraft.Hub.Listener.Vanisher;
import me.PrezonCraft.Hub.Managers.ConfigManager;
import me.PrezonCraft.Hub.Menus.KledingKastInteract.Boots;
import me.PrezonCraft.Hub.Menus.KledingKastInteract.Chestplate;
import me.PrezonCraft.Hub.Menus.KledingKastInteract.Heads;
import me.PrezonCraft.Hub.Menus.KledingKastInteract.Leggings;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Barrier;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Bubbel;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Cloud;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Enchant;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Flame;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Happy;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Heart;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Note;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Slime;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Smoke;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Snow;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.Witch;
import me.PrezonCraft.Hub.Menus.ParticlesInteract.rainBow;
import me.PrezonCraft.Hub.MySQL.SQLSettings;
import me.PrezonCraft.Hub.Parkour.END;
import me.PrezonCraft.Hub.Parkour.Start;
import me.PrezonCraft.Hub.Utils.PacketUtils;
import me.PrezonCraft.Hub.pARTICLES.Redstone;

public class Main extends JavaPlugin{
	
	ConfigManager settings = ConfigManager.getInstance();
	public static SQLSettings sql;
	public static HashMap<Player,Entity> pets = new HashMap<Player,Entity>();
	public static HashMap<Player, Integer> playerHashMap = new HashMap<Player, Integer>();
	public static Plugin plugin;
	public static HashMap<Player, Integer> cooldownTime;
	public static HashMap<Player, BukkitRunnable> cooldownTask;
	private static int instance;
	
	private ItemStack setName(ItemStack is, String name){
		ItemMeta im = is.getItemMeta();
	if(name != null)
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name).replace("_", " "));
	
	    is.setItemMeta(im);
	
		return is;
	}
	
	public static List<Player> parkour = new ArrayList<Player>();
	public static ArrayList<UUID> flame = new ArrayList<UUID>();
	public static ArrayList<UUID> build = new ArrayList<UUID>();
	public static ArrayList<UUID> smoke = new ArrayList<UUID>();
	public static ArrayList<UUID> rainbow = new ArrayList<UUID>();
	public static ArrayList<UUID> redstone = new ArrayList<UUID>();
	public static ArrayList<UUID> heart = new ArrayList<UUID>();
	public static ArrayList<UUID> snow = new ArrayList<UUID>();
	public static ArrayList<UUID> witch = new ArrayList<UUID>();
	public static ArrayList<UUID> slime = new ArrayList<UUID>();
	public static ArrayList<UUID> enchant = new ArrayList<UUID>();
	public static ArrayList<UUID> cloud = new ArrayList<UUID>();
	public static ArrayList<UUID> happy = new ArrayList<UUID>();
	public static ArrayList<UUID> bubbel = new ArrayList<UUID>();
	public static ArrayList<UUID> note = new ArrayList<UUID>();
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmds, String cmd, String[] args)
	  {
		if (cmd.equalsIgnoreCase("rename"))
	    {
	      Player p = (Player)sender;
	     if(args.length == 0){
	    	 p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGebruik: /rename <name>"));
	     }else{
	   if(args.length == 1){
		   p.getInventory().addItem(setName(new ItemStack(p.getInventory().getItemInMainHand().getType(), p.getInventory().getItemInMainHand().getAmount(), (short) p.getInventory().getItemInHand().getDurability()), args[0]));
		   p.getInventory().remove(p.getInventory().getItemInMainHand());
	   }else{
		   p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGebruik: /rename <name>"));
	   }
	   }
	    }
		if (cmd.equalsIgnoreCase("setdropper"))
	    {
	      Player p = (Player)sender;
	      if (!p.hasPermission("prezon.hub.setdropper"))
	      {
		        p.sendMessage("§c§lDropper §f>> Je hebt de dropper gezet :O. Oh nee wacht je hebt geen perms :/");
	      }
	      else
	      {
	        p.sendMessage("§c§lDropper §f>> Je hebt de dropper gezet :O");
	        
	        String world = p.getWorld().getName();
	        double x = p.getLocation().getX();
	        double y = p.getLocation().getY();
	        double z = p.getLocation().getZ();
	        double yaw = p.getLocation().getYaw();
	        double pitch = p.getLocation().getPitch();
	        getConfig().set("Dropper.world", world);
	        getConfig().set("Dropper.x", Double.valueOf(x));
	        getConfig().set("Dropper.y", Double.valueOf(y));
	        getConfig().set("Dropper.z", Double.valueOf(z));
	        getConfig().set("Dropper.yaw", Double.valueOf(yaw));
	        getConfig().set("Dropper.pitch", Double.valueOf(pitch));
	        saveConfig();
	      }
	    }
		
		if (cmd.equalsIgnoreCase("setdisco"))
	    {
	      Player p = (Player)sender;
	      if (!p.hasPermission("prezon.hub.setdisco"))
	      {
		        p.sendMessage("§4§lDisco §f>> Je hebt de disco gezet :O. Oh nee wacht je hebt geen perms :/");
	      }
	      else
	      {
	        p.sendMessage("§4§lDisco §f>> Je hebt de disco gezet :O");
	        
	        String world = p.getWorld().getName();
	        double x = p.getLocation().getX();
	        double y = p.getLocation().getY();
	        double z = p.getLocation().getZ();
	        double yaw = p.getLocation().getYaw();
	        double pitch = p.getLocation().getPitch();
	        getConfig().set("Disco.world", world);
	        getConfig().set("Disco.x", Double.valueOf(x));
	        getConfig().set("Disco.y", Double.valueOf(y));
	        getConfig().set("Disco.z", Double.valueOf(z));
	        getConfig().set("Disco.yaw", Double.valueOf(yaw));
	        getConfig().set("Disco.pitch", Double.valueOf(pitch));
	        saveConfig();
	      }
	    }
		
		if (cmd.equalsIgnoreCase("setspawn"))
	    {
	      Player p = (Player)sender;
	      if (!p.hasPermission("prezon.hub.setspawn"))
	      {
		        p.sendMessage("§b§lSpawn §f>> Je hebt de spwan gezet :O. Oh nee wacht je hebt geen perms :/");
	      }
	      else
	      {
	        p.sendMessage("§b§lSpawn §f>> Je hebt de span gezet :O");
	        
	        String world = p.getWorld().getName();
	        double x = p.getLocation().getX();
	        double y = p.getLocation().getY();
	        double z = p.getLocation().getZ();
	        double yaw = p.getLocation().getYaw();
	        double pitch = p.getLocation().getPitch();
	        getConfig().set("Spawn.world", world);
	        getConfig().set("Spawn.x", Double.valueOf(x));
	        getConfig().set("Spawn.y", Double.valueOf(y));
	        getConfig().set("Spawn.z", Double.valueOf(z));
	        getConfig().set("Spawn.yaw", Double.valueOf(yaw));
	        getConfig().set("Spawn.pitch", Double.valueOf(pitch));
	        saveConfig();
	      }
	    }
	    if (cmd.equalsIgnoreCase("spawn"))
	    {
	      String stringYaw = getConfig().getString("Spawn.yaw");
	      String stringPitch = getConfig().getString("Spawn.pitch");
	      
	      String stringX = getConfig().getString("Spawn.x");
	      String stringY = getConfig().getString("Spawn.y");
	      String stringZ = getConfig().getString("Spawn.z");
	      
	      float yaw = Float.parseFloat(stringYaw);
	      float pitch = Float.parseFloat(stringPitch);
	      
	      double X = Double.parseDouble(stringX);
	      double Y = Double.parseDouble(stringY);
	      double Z = Double.parseDouble(stringZ);
	      
	      String world = getConfig().getString("Spawn.world");
	      
	      Location spawn = new Location(Bukkit.getWorld(world), X, Y, Z, yaw, pitch);
	      Player p = (Player)sender;
	      p.teleport(spawn);
	    }
	    
	    if (cmd.equalsIgnoreCase("bouwmode")){
	    	Player p = (Player)sender;
			 if(p.hasPermission("prezon.build")){
				 if(build.contains(p.getUniqueId())){
					 p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lBouwMode uitgeschakeld!"));
					 build.remove(p.getUniqueId());
				 }else{
					 p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lBouwMode ingeschakeld!"));
					 build.add(p.getUniqueId());
				 }
			 }
		   }
		
		 if (cmd.equalsIgnoreCase("punten")){
			 sender.sendMessage("&2&lPunten&f >> Je hebt &2".replace("&", "§") + sql.getPUNTEN((Player)sender) + "&f punten!".replace("&", "§"));
		   }
		 if (cmd.equalsIgnoreCase("setparkour")){
			      Player p = (Player)sender;
			      if (!p.isOp())
			      {
			        p.sendMessage("§6§lParkour §f>> §cJe hebt geen toegang tot dit commando!");
			      }
			      else
			      {
			    	  p.sendMessage("§6§lParkour §f>> §aJe hebt de parkour spawn gezet!");
			        
			        String world = p.getWorld().getName();
			        double x = p.getLocation().getX();
			        double y = p.getLocation().getY();
			        double z = p.getLocation().getZ();
			        double yaw = p.getLocation().getYaw();
			        double pitch = p.getLocation().getPitch();
			        settings.getConfig().set("ParkourSpawn.Spawn.world", world);
			        settings.getConfig().set("ParkourSpawn.Spawn.x", Double.valueOf(x));
			        settings.getConfig().set("ParkourSpawn.Spawn.y", Double.valueOf(y));
			        settings.getConfig().set("ParkourSpawn.Spawn.z", Double.valueOf(z));
			        settings.getConfig().set("ParkourSpawn.Spawn.yaw", Double.valueOf(yaw));
			        settings.getConfig().set("ParkourSpawn.Spawn.pitch", Double.valueOf(pitch));
			        settings.saveConfig();
			      }
		   }
		return false;
	  }
	
	public int getPlayerCount(String server, Player p) {
    	ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);
		p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
		return instance;
    }
	
	public void onEnable(){
		cooldownTime = new HashMap<Player, Integer>();
        cooldownTask = new HashMap<Player, BukkitRunnable>();
        
        plugin = this;
        
        sql = new SQLSettings(this, "37.187.147.202", "mc_1815", "mc_1815", "33400f5d69");
        
        settings.setup(plugin);
		
        for(Player all : Bukkit.getOnlinePlayers()){
        	ScoreboardAPI.Scoreboard(all);
        	PacketUtils.sendTabHF(all, "     &2&lPrezonCraft     ".replace("&", "§"), "     &f&lplay.prezoncraft.nl     ".replace("&", "§"));
        }
        
        saveDefaultConfig();
        
        getServer().getPluginManager().registerEvents(new Move(), this);
		getServer().getPluginManager().registerEvents(new JoinItems(), this);
        getServer().getPluginManager().registerEvents(new UseJoinItems(), this);
        getServer().getPluginManager().registerEvents(new EnderEgg(), this);
		getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getPluginManager().registerEvents(new Vanisher(), this);
		getServer().getPluginManager().registerEvents(new No_Weather(), this);
		getServer().getPluginManager().registerEvents(new AntiShit(), this);
		getServer().getPluginManager().registerEvents(new Start(), this);
		getServer().getPluginManager().registerEvents(new END(), this);
		getServer().getPluginManager().registerEvents(new DropperTP(), this);
		getServer().getPluginManager().registerEvents(new DropperHit(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Flame(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CommandBlock(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Flame(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Rainbow(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new rainBow(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Redstone(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.Menus.ParticlesInteract.Redstone(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Heart(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Heart(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Smoke(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Smoke(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.SNOW(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Snow(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Witch(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Witch(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Slime(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Slime(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Enchant(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Enchant(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Cloud(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Cloud(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Happy(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Happy(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Bubbel(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Bubbel(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.PrezonCraft.Hub.pARTICLES.Note(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Note(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Barrier(), this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new Heads(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Chestplate(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Leggings(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Boots(), this);
	}
  }
