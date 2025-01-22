package model;

public class Staffs {

	private int staff_id;
	private String name;
	private String role;
	private String contact_info;
	
	public Staffs() {
		// TODO Auto-generated constructor stub
	}

	public Staffs(int staff_id, String name, String role, String contact_info) {
		super();
		this.staff_id = staff_id;
		this.name = name;
		this.role = role;
		this.contact_info = contact_info;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	@Override
	public String toString() {
		return "Staffs [staff_id=" + staff_id + ", name=" + name + ", role=" + role + ", contact_info=" + contact_info
				+ "]";
	}
	
}
