package de.flugboy.utils;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @Author Flugboy
 * @Project PrefixSystem
 * @Package de.flugboy.utils
 * @Date 09.07.2022
 * @Time 01:07:05
 */
public class Config {

	private static File file = new File("plugins//PrefixSystem//config.yml");
	private static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static String getString(String path) {
		return cfg.getString(path).replaceAll("&", "§");
	}

	public static boolean getBoolean(String path) {
		return cfg.getBoolean(path);
	}

	public static String getLuckPermsName(String rankname) {
		return getString(rankname + ".LuckPermsName");
	}

	public static String getTabDisplay(String rankname) {
		return getString(rankname + ".TabAnzeige");
	}

	public static String getChatDisplay(String rankname) {
		return getString(rankname + ".ChatAnzeige");
	}

	public static String getRankColor(String rankname) {
		if (getBoolean("Color")) {
			return getChatDisplay(rankname).substring(0, 2);
		}
		return "§7";
	}
}