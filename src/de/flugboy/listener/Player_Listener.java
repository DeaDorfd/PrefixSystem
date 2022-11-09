package de.flugboy.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.flugboy.utils.ScoreboardAPI;

/**
 * @Author Flugboy
 * @Project PrefixSystem
 * @Package de.flugboy.listener
 * @Date 09.07.2022
 * @Time 00:33:32
 */
public class Player_Listener implements Listener {

	@EventHandler
	private static void onPlayerJoinEvent(PlayerJoinEvent event) {
		ScoreboardAPI.setScoreboard(event.getPlayer());
	}
}