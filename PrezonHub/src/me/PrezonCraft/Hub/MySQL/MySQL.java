package me.PrezonCraft.Hub.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;

public class MySQL {
	
	private String user = "mc_1815";
	private String pass = "33400f5d69";
	private String host = "localhost";
	private String db = "mc_1815";
	private Connection connection;

	public MySQL(String user, String pass, String host, String db) {
		this.connect();
	}

	public void close() {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public void connect() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db + "?autoReconnect=true", user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			Bukkit.broadcastMessage("§c§lKAN DATABASE NIET VINDEN!!! Meld dit aub aan het PrezonCraft DevTeam!");
			Bukkit.broadcastMessage("§c§lTwitter: @ducitymp1 / mail: devteam@prezoncraft.nl");
		}
	}

	public void Update(String qry) {
		try {
			Statement stmt = this.connection.createStatement();
			stmt.executeUpdate(qry);
			stmt.close();
		} catch (Exception ex) {
			this.connect();
			System.err.println(ex);
		}
	}

	public ResultSet Query(String qry) {
		ResultSet rs = null;
		try {
			Statement stmt = this.connection.createStatement();
			rs = stmt.executeQuery(qry);
		} catch (Exception ex) {
			this.connect();
			System.err.println(ex);
		}
		return rs;
	}
}