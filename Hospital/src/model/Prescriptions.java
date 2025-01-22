package model;

public class Prescriptions {

	private int prescription_id;
	private int appointment_id;
	private int medicine_id;
	private String dosage;
	private int duration;
	
	public Prescriptions() {
		// TODO Auto-generated constructor stub
	}

	public Prescriptions(int prescription_id, int appointment_id, int medicine_id, String dosage, int duration) {
		super();
		this.prescription_id = prescription_id;
		this.appointment_id = appointment_id;
		this.medicine_id = medicine_id;
		this.dosage = dosage;
		this.duration = duration;
	}

	public int getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public int getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Prescriptions [prescription_id=" + prescription_id + ", appointment_id=" + appointment_id
				+ ", medicine_id=" + medicine_id + ", dosage=" + dosage + ", duration=" + duration + "]";
	}
	

}
