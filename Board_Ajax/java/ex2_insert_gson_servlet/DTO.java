package ex2_insert_gson_servlet;

import com.google.gson.JsonArray;

public class DTO {
	private String name;
	private int price;
	private String maker;
	private int id;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getMaker() {
		return maker;
	}


	public void setMaker(String maker) {
		this.maker = maker;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public JsonArray getList() {
		
		return null;
	}

}
