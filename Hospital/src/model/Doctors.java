package model;

public class Doctors {

	private int doctor_id;
	private String name;
	private String specialization;
	private String contact_info;
	private String schedule;
	
	@Override
	public String toString() {
		return "Doctors [doctor_id=" + doctor_id + ", name=" + name + ", specialization=" + specialization
				+ ", contact_info=" + contact_info + ", schedule=" + schedule + "]";
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Doctors(int doctor_id, String name, String specialization, String contact_info, String schedule) {
		super();
		this.doctor_id = doctor_id;
		this.name = name;
		this.specialization = specialization;
		this.contact_info = contact_info;
		this.schedule = schedule;
	}

	public Doctors() {
		// TODO Auto-generated constructor stub
	}

}
