package br.lehmann.steam.api;

import static org.junit.Assert.*;

import java.util.stream.Collectors;

import org.influxdb.InfluxDBFactory;
import org.influxdb.impl.InfluxDBImpl;
import org.junit.Test;

import com.google.common.base.Functions;

public class SteamInventoryTest {

	@Test
	public void retriveInventory() throws Exception {
		SteamInventory client = new SteamInventory();
		Inventory inventory = client.retriveInventory("76561198009543117");
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
