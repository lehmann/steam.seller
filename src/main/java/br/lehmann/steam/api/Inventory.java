package br.lehmann.steam.api;

import java.util.List;

class Inventory {

	List<Asset> assets;
	List<AssetDescription> descriptions;
	String last_assetid;
	Integer more_itens;
	Integer sucess;
	Integer total_inventory_count;
	public List<Asset> getAssets() {
		return assets;
	}
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	public List<AssetDescription> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<AssetDescription> descriptions) {
		this.descriptions = descriptions;
	}
	public String getLast_assetid() {
		return last_assetid;
	}
	public void setLast_assetid(String last_assetid) {
		this.last_assetid = last_assetid;
	}
	public Integer getMore_itens() {
		return more_itens;
	}
	public void setMore_itens(Integer more_itens) {
		this.more_itens = more_itens;
	}
	public Integer getSucess() {
		return sucess;
	}
	public void setSucess(Integer sucess) {
		this.sucess = sucess;
	}
	public Integer getTotal_inventory_count() {
		return total_inventory_count;
	}
	public void setTotal_inventory_count(Integer total_inventory_count) {
		this.total_inventory_count = total_inventory_count;
	}
}
