package de.flugboy.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;

/**
 * @Author Flugboy
 * @Project PrefixSystem
 * @Package de.flugboy.utils
 * @Date 09.07.2022
 * @Time 00:27:29
 */
public class API {

	public static boolean isInGroup(Player player, String group) {
		User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
		return user.getPrimaryGroup().equalsIgnoreCase(group);
	}

	public static ChatColor transformColor(String color) {
		if (color.equals("§a")) return ChatColor.GREEN;
		if (color.equals("§b")) return ChatColor.AQUA;
		if (color.equals("§c")) return ChatColor.RED;
		if (color.equals("§d")) return ChatColor.LIGHT_PURPLE;
		if (color.equals("§e")) return ChatColor.YELLOW;
		if (color.equals("§f")) return ChatColor.WHITE;
		if (color.equals("§0")) return ChatColor.BLACK;
		if (color.equals("§1")) return ChatColor.DARK_BLUE;
		if (color.equals("§2")) return ChatColor.DARK_GREEN;
		if (color.equals("§3")) return ChatColor.DARK_AQUA;
		if (color.equals("§4")) return ChatColor.DARK_RED;
		if (color.equals("§5")) return ChatColor.DARK_PURPLE;
		if (color.equals("§6")) return ChatColor.GOLD;
		if (color.equals("§7")) return ChatColor.GRAY;
		if (color.equals("§8")) return ChatColor.DARK_GRAY;
		if (color.equals("§9")) return ChatColor.BLUE;
		return ChatColor.BLACK;
	}
}