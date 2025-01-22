package model;

public class Bills {

	private int bill_id;
	private int patient_id;
	private double amount; 
	private String date; 
	private String payment_status; 
	
	public Bills() {
		// TODO Auto-generated constructor stub
	}

	public Bills(int bill_id, int patient_id, double amount, String date, String payment_status) {
		super();
		this.bill_id = bill_id;
		this.patient_id = patient_id;
		this.amount = amount;
		this.date = date;
		this.payment_status = payment_status;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	@Override
	public String toString() {
		return "Bills [bill_id=" + bill_id + ", patient_id=" + patient_id + ", amount=" + amount + ", date=" + date
				+ ", payment_status=" + payment_status + "]";
	}
	
}
