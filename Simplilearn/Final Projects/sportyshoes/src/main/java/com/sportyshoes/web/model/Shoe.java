package com.sportyshoes.web.model;

public class Shoe 
{
	private int shoe_id;
	private String shoe_name;
	private String tag;
	private String thumbnail;
	
	public int getShoe_id() {
		return shoe_id;
	}
	public void setShoe_id(int shoe_id) {
		this.shoe_id = shoe_id;
	}
	public String getShoe_name() {
		return shoe_name;
	}
	public void setShoe_name(String shoe_name) {
		this.shoe_name = shoe_name;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	@Override
	public String toString() {
		return "Shoe [shoe_id=" + shoe_id + ", shoe_name=" + shoe_name + ", tag=" + tag + ", thumbnail=" + thumbnail
				+ "]";
	}
}
