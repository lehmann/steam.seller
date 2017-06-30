package br.lehmann.steam.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SteamInventory {

	private static final Pattern MARKET_PAGE = Pattern.compile("Market_LoadOrderSpread\\( (\\d+) \\)");
	private static final Pattern PRICE_HISTORY = Pattern.compile("var line1=(.+);");
	private final Map<String, String> marketHashName_to_nameids = new HashMap<>();

	public Inventory retriveInventory(String userId) {
		AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
		Response r;
		try {
			Future<Response> f = asyncHttpClient.prepareGet("http://steamcommunity.com/inventory/" + userId + "/753/6?count=1")
					.execute();
			r = f.get();
		} catch (InterruptedException | ExecutionException e) {
			return null;
		} finally {
			try {
				asyncHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String json = r.getResponseBody();
		Inventory ret = new Gson().fromJson(json, Inventory.class);
		asyncHttpClient = new DefaultAsyncHttpClient();
		try {
			Future<Response> f = asyncHttpClient.prepareGet("http://steamcommunity.com/inventory/" + userId + "/753/6?count=" + ret.getTotal_inventory_count())
					.execute();
			r = f.get();
		} catch (InterruptedException | ExecutionException e) {
			return null;
		} finally {
			try {
				asyncHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		json = r.getResponseBody();
		ret = new Gson().fromJson(json, Inventory.class);
		return ret;
	}

	public PriceHistogram retrivePriceHistogram(String marketHashName) {
		// http://steamcommunity.com/market/listings/753/<AssetDescription#market_hash_name>
		String item_nameid = marketHashName_to_nameids.get(marketHashName);
		if (item_nameid == null) {
			AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
			Response r;
			try {
				BoundRequestBuilder get = asyncHttpClient
						.prepareGet("http://steamcommunity.com/market/listings/753/" + marketHashName);
				Future<Response> f = get.execute();
				r = f.get();
			} catch (InterruptedException | ExecutionException e) {
				return null;
			} finally {
				try {
					asyncHttpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			String marketPage = r.getResponseBody();
			Matcher matcher = MARKET_PAGE.matcher(marketPage);
			if (matcher.find()) {
				item_nameid = matcher.group(1);
				marketHashName_to_nameids.put(marketHashName, item_nameid);
			}
		}
		AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
		Response r;
		try {
			Future<Response> f = asyncHttpClient.prepareGet(
					"http://steamcommunity.com/market/itemordershistogram?country=RU&language=brazilian&currency=5&item_nameid="
							+ item_nameid + "&two_factor=0")
					.execute();
			r = f.get();
		} catch (InterruptedException | ExecutionException e) {
			return null;
		} finally {
			try {
				asyncHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String json = r.getResponseBody();
		return new Gson().fromJson(json, PriceHistogram.class);
	}

	public PriceHistory retrivePriceHistory(String marketHashName) {
		AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
		Response r;
		try {
			Future<Response> f = asyncHttpClient
					.prepareGet("http://steamcommunity.com/market/listings/753/" + marketHashName).execute();
			r = f.get();
		} catch (InterruptedException | ExecutionException e) {
			return null;
		} finally {
			try {
				asyncHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String marketPage = r.getResponseBody();
		Matcher matcher = PRICE_HISTORY.matcher(marketPage);
		if (matcher.find()) {
			String json = matcher.group(1);
			Type listType = new TypeToken<List<String[]>>() {
			}.getType();
			List<String[]> prices = new Gson().fromJson(json, listType);
			return new PriceHistory(prices);
		}
		return null;
	}
	
	public void sell() {
		//https://steamcommunity.com/market/sellitem/

	}
}
