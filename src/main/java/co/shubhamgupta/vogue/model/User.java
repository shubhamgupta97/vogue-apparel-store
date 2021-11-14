package co.shubhamgupta.vogue.model;


public class User {
	
	private Long id;
	private String name;
	private String password;
	private Character gender;
	
	
	
	public User() {
	}
	
	public User(Long id, String name, String password, Character gender) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Character getGender() {
		return gender;
	}
	
	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + "]";
	}
	
	
}
