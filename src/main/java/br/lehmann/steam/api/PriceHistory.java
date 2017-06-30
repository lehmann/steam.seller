package br.lehmann.steam.api;

import java.util.List;

public class PriceHistory {
	private List<String[]> prices;// 0 - data-hora(String/"Jan 23 2017 03: +0"); 1 - valor(double); 2 - quantidade(String)
	public PriceHistory(List<String[]> prices) {
		this.prices = prices;
	}
	public List<String[]> getPrices() {
		return prices;
	}
	public void setPrices(List<String[]> prices) {
		this.prices = prices;
	}
}
