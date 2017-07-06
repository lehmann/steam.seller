package br.lehmann.steam.api;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.lehmann.steam.api.badge.Badge;
import br.lehmann.steam.api.badge.BadgePojo;
import br.lehmann.steam.api.games.Game;
import br.lehmann.steam.api.games.OwnedGames;

public class GamesMatcher {

	public static void main(String[] args) throws IOException {
		SteamInventory steamInventory = new SteamInventory();
		OwnedGames bot = steamInventory.retriveGames("76561198309542212");
		Inventory my = steamInventory.retriveInventory("76561198009543117");
		List<AssetDescription> assets = my.getDescriptions();
		BadgePojo userBadgeInfo = steamInventory.retriveBadges("76561198216279305");
		List<Badge> badges = userBadgeInfo.getResponse().getBadges();
		Set<String> nonBadges = new LinkedHashSet<>();
		Set<Integer> botGames = new LinkedHashSet<>();
		Set<String> incompleteSet = new LinkedHashSet<>();
		for (AssetDescription desc : assets) {
			String appId = desc.market_hash_name.substring(0, desc.market_hash_name.indexOf('-'));
			if(nonBadges.contains(appId)) {
				continue;
			}
			boolean haveBadge = false;
			for (Badge badge : badges) {
				if(badge.getAppid() == null) {
					continue;
				}
				if(badge.getAppid().equals(Integer.parseInt(appId))) {
					haveBadge = true;
					break;
				}
			}
			if(!haveBadge) {
				nonBadges.add(appId);
			}
		}
		for (Game game : bot.getResponse().getGames()) {
			Integer appId = game.getAppid();
			if(nonBadges.contains(String.valueOf(appId)) || botGames.contains(appId)) {
				continue;
			}
			boolean haveBadge = false;
			for (Badge badge : badges) {
				if(badge.getAppid() == null) {
					continue;
				}
				if(badge.getAppid().equals(appId)) {
					haveBadge = true;
					break;
				}
			}
			if(!haveBadge) {
				botGames.add(appId);
			}
		}
		for (String incomplete : incompleteSet) {
			System.out.println("Incomplete set: " + incomplete);
		}
		for (String nonBadge : nonBadges) {
			System.out.println("Non-badge yet: " + nonBadge);
		}
		for (Integer botGame : botGames) {
			System.out.println("Bot game: " + botGame);
		}
	}
}
