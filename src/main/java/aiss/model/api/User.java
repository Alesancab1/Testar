package aiss.model.api;



public class User {
	
	private String id;
	private Double edad;
	private String nickname;
	
	public User() {}
	
	public User(String id, Double edad, String nickname) {
		super();
		this.id = id;
		this.edad = edad;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}