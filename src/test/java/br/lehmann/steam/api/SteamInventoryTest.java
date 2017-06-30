package br.lehmann.steam.api;

import org.junit.Test;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

public class SteamInventoryTest {

	@Test
	public void retriveInventory() throws Exception {
		SteamInventory client = new SteamInventory();
		Inventory inventory = client.retriveInventory("76561198009543117");
//		Inventory inventory = client.retriveInventory("76561197996361721");
		Multimap<String, AssetDescription> games = MultimapBuilder.hashKeys().arrayListValues().build();
		for (AssetDescription asset : inventory.descriptions) {
			games.put(asset.market_hash_name.substring(0, asset.market_hash_name.indexOf('-')), asset);
		}
		for (String game : games.keySet()) {
			System.out.println(game);
		}
		System.out.println("total_inventory_count: " + inventory.total_inventory_count);
		System.out.println("inventory.descriptions.size: " + inventory.descriptions.size());
		System.out.println("inventory.assets.size: " + inventory.assets.size());
	}

	@Test
	public void retrivePriceHistogram() throws Exception {
		SteamInventory inventory = new SteamInventory();
		PriceHistogram histogram = inventory.retrivePriceHistogram("449220-Developer");
		System.out.println("Total de preços (venda): " + histogram.getSell_order_graph().size());
	}

	@Test
	public void retrivePriceHistory() throws Exception {
		SteamInventory inventory = new SteamInventory();
		PriceHistory history = inventory.retrivePriceHistory("449220-Developer");
		System.out.println("Histórico de vendas: " + history.getPrices().size());
	}
}
