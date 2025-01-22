package model;

public class Medicines {

	private int medicine_id;
	private String name;
	private int stock_quantity;
	private double price;
	private String expirey_date;
	
	public Medicines() {
		// TODO Auto-generated constructor stub
	}

	public Medicines(int medicine_id, String name, int stock_quantity, double price, String expirey_date) {
		super();
		this.medicine_id = medicine_id;
		this.name = name;
		this.stock_quantity = stock_quantity;
		this.price = price;
		this.expirey_date = expirey_date;
	}

	public int getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getExpirey_date() {
		return expirey_date;
	}

	public void setExpirey_date(String expirey_date) {
		this.expirey_date = expirey_date;
	}

	@Override
	public String toString() {
		return "Medicines [medicine_id=" + medicine_id + ", name=" + name + ", stock_quantity=" + stock_quantity
				+ ", price=" + price + ", expirey_date=" + expirey_date + "]";
	}
	

}
