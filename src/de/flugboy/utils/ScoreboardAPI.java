package de.flugboy.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.flugboy.main.PrefixSystem;

/**
 * @Author Flugboy
 * @Project PrefixSystem
 * @Package de.flugboy.utils
 * @Date 09.07.2022
 * @Time 00:05:49
 */
public class ScoreboardAPI {

	public static void setScoreboard(Player player) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		getTeams(sb);
		player.setScoreboard(sb);
	}

	public static void updateScoreboard(Player player) {
		if (player.getScoreboard() == null && player != null) setScoreboard(player);
		Scoreboard sb = player.getScoreboard();
		getTeams(sb);
	}

	private static Team getTeam(Scoreboard sb, String Team, String rankname) {
		Team team = sb.getTeam(Team + rankname);
		if (team == null) team = sb.registerNewTeam(Team + rankname);
		team.setPrefix(Config.getTabDisplay(rankname) + Config.getString("TabFormat") + Config.getRankColor(rankname));
		team.setSuffix("§8");
		team.setAllowFriendlyFire(true);
		team.setCanSeeFriendlyInvisibles(true);
		return team;
	}

	public static void getTeams(Scoreboard sb) {
		Team inhaber = getTeam(sb, "0000", "Inhaber");
		Team manager = getTeam(sb, "0001", "Manager");
		Team admin = getTeam(sb, "0002", "Admin");
		Team entwickler = getTeam(sb, "0003", "Entwickler");
		Team moderator = getTeam(sb, "0004", "Moderator");
		Team content = getTeam(sb, "0005", "Content");
		Team supporter = getTeam(sb, "0006", "Supporter");
		Team youtuberplus = getTeam(sb, "0007", "YoutuberPlus");
		Team youtuber = getTeam(sb, "0008", "Youtuber");
		Team premiumplus = getTeam(sb, "0009", "PremiumPlus");
		Team legend = getTeam(sb, "0010", "Legend");
		Team premium = getTeam(sb, "0011", "Premium");
		Team spieler = getTeam(sb, "0130", "Spieler");

		for (Player on : Bukkit.getOnlinePlayers()) {
			if (API.isInGroup(on, Config.getLuckPermsName("Inhaber"))) {
				inhaber.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Manager"))) {
				manager.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Admin"))) {
				admin.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Entwickler"))) {
				entwickler.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Moderator"))) {
				moderator.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Content"))) {
				content.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Supporter"))) {
				supporter.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("YoutuberPlus"))) {
				youtuberplus.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Youtuber"))) {
				youtuber.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("PremiumPlus"))) {
				premiumplus.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Legend"))) {
				legend.addPlayer(on);
			} else if (API.isInGroup(on, Config.getLuckPermsName("Premium"))) {
				premium.addPlayer(on);
			} else {
				spieler.addPlayer(on);
			}
		}
	}

	public static void startScheduler() {
		Bukkit.getScheduler().runTaskTimer(PrefixSystem.getInstance(), () -> {
			Bukkit.getOnlinePlayers().forEach(player -> updateScoreboard(player));
		}, 20, 20);
	}
}