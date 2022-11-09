package de.flugboy.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.flugboy.listener.Chat_Listener;
import de.flugboy.listener.Player_Listener;
import de.flugboy.utils.ScoreboardAPI;

/**
 * @Author Flugboy
 * @Project PrefixSystem
 * @Package de.flugboy.main
 * @Date 09.07.2022
 * @Time 00:04:00
 */
public class PrefixSystem extends JavaPlugin {

	private static PrefixSystem instance;
	private static PluginManager plu = Bukkit.getPluginManager();

	@Override
	public void onEnable() {
		instance = this;
		getDataFolder().mkdir();
		saveDefaultConfig();
		plu.registerEvents(new Chat_Listener(), instance);
		plu.registerEvents(new Player_Listener(), instance);
		ScoreboardAPI.startScheduler();
	}

	public static PrefixSystem getInstance() {
		return instance;
	}
}