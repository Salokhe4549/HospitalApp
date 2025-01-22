package model;

public class Patients {

	private int patient_id;
	private String name;
	private int age;
	private String gender;
	private String contact_info;
	private String medical_history;
	
	public Patients() {
		// TODO Auto-generated constructor stub
	}

	public Patients(int patient_id, String name, int age, String gender, String contact_info, String medical_history) {
		super();
		this.patient_id = patient_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contact_info = contact_info;
		this.medical_history = medical_history;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public String getMedical_history() {
		return medical_history;
	}

	public void setMedical_history(String medical_history) {
		this.medical_history = medical_history;
	}

	@Override
	public String toString() {
		return "Patients [patient_id=" + patient_id + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", contact_info=" + contact_info + ", medical_history=" + medical_history + "]";
	}
	

}
