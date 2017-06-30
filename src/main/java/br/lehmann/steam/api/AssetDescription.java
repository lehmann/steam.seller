package br.lehmann.steam.api;

class AssetDescription {

	Integer appid;
	String classid;
	String instanceid;
	String market_hash_name;
	Integer marketable;
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getMarket_hash_name() {
		return market_hash_name;
	}
	public void setMarket_hash_name(String market_hash_name) {
		this.market_hash_name = market_hash_name;
	}
	public Integer getMarketable() {
		return marketable;
	}
	public void setMarketable(Integer marketable) {
		this.marketable = marketable;
	}
	public String getInstanceid() {
		return instanceid;
	}
	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}
}
