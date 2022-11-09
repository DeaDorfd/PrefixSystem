package de.flugboy.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.flugboy.utils.API;
import de.flugboy.utils.Config;

/**
 * @Author Flugboy
 * @Project PrefixSystem
 * @Package de.flugboy.listener
 * @Date 09.07.2022
 * @Time 00:25:24
 */
public class Chat_Listener implements Listener {

	private static String format(String rankname, String name, String message) {
		return Config.getChatDisplay(rankname) + Config.getString("ChatFormatprefix") + Config.getRankColor(rankname)
				+ name + Config.getString("ChatFormatsuffix") + message;
	}

	public static void setFormat(AsyncPlayerChatEvent event, Player player, String message, String rank) {
		if (API.isInGroup(player, Config.getLuckPermsName("Spieler"))) {
			event.setFormat(format("Spieler", player.getName(), message));
		}
	}

	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		message = message.replaceAll("%", "Prozent");
		if (Config.getBoolean("ChatColor")) {
			if (player.hasPermission(Config.getString("ChatColorPremission"))) {
				message = message.replace("&", "§");
			}
		}
		setFormat(event, player, message, "Spieler");
		setFormat(event, player, message, "Premium");
		setFormat(event, player, message, "Legend");
		setFormat(event, player, message, "PremiumPlus");
		setFormat(event, player, message, "Youtuber");
		setFormat(event, player, message, "YoutuberPlus");
		setFormat(event, player, message, "Supporter");
		setFormat(event, player, message, "Content");
		setFormat(event, player, message, "Moderator");
		setFormat(event, player, message, "Entwickler");
		setFormat(event, player, message, "Admin");
		setFormat(event, player, message, "Inhaber");
	}
}