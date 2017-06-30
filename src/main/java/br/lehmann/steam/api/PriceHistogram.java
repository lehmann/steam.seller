package br.lehmann.steam.api;

import java.util.List;

public class PriceHistogram {

	private Double graph_max_x;
	private Double graph_max_y;
	private Double graph_min_x;
	private String highest_buy_order;
	private String lowest_sell_order;
	private String price_prefix;
	private String price_suffix;
	private Integer success;
	private List<String[]> sell_order_graph;// 0 - valor(double); 1 - quantidade(int); 2 - Texto(String)
	private List<String[]> buy_order_graph;// 0 - valor(double); 1 - quantidade(int); 2 - Texto(String)
	public Double getGraph_max_x() {
		return graph_max_x;
	}
	public void setGraph_max_x(Double graph_max_x) {
		this.graph_max_x = graph_max_x;
	}
	public Double getGraph_max_y() {
		return graph_max_y;
	}
	public void setGraph_max_y(Double graph_max_y) {
		this.graph_max_y = graph_max_y;
	}
	public Double getGraph_min_x() {
		return graph_min_x;
	}
	public void setGraph_min_x(Double graph_min_x) {
		this.graph_min_x = graph_min_x;
	}
	public String getHighest_buy_order() {
		return highest_buy_order;
	}
	public void setHighest_buy_order(String highest_buy_order) {
		this.highest_buy_order = highest_buy_order;
	}
	public String getLowest_sell_order() {
		return lowest_sell_order;
	}
	public void setLowest_sell_order(String lowest_sell_order) {
		this.lowest_sell_order = lowest_sell_order;
	}
	public String getPrice_prefix() {
		return price_prefix;
	}
	public void setPrice_prefix(String price_prefix) {
		this.price_prefix = price_prefix;
	}
	public String getPrice_suffix() {
		return price_suffix;
	}
	public void setPrice_suffix(String price_suffix) {
		this.price_suffix = price_suffix;
	}
	public Integer getSuccess() {
		return success;
	}
	public void setSuccess(Integer success) {
		this.success = success;
	}
	public List<String[]> getSell_order_graph() {
		return sell_order_graph;
	}
	public void setSell_order_graph(List<String[]> sell_order_graph) {
		this.sell_order_graph = sell_order_graph;
	}
	public List<String[]> getBuy_order_graph() {
		return buy_order_graph;
	}
	public void setBuy_order_graph(List<String[]> buy_order_graph) {
		this.buy_order_graph = buy_order_graph;
	}
}
