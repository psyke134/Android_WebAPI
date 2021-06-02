package Model;

public class Account {
	private String username;
	private String password;
	private String email;
	private String phone_number;
	private String address;
	private String name;
	
	public Account(String username, String password, String email, String phone_number, String address, String name)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.name = name;
	}

	public String GetUsername() {
		return username;
	}

	public void SetUsername(String username) {
		this.username = username;
	}

	public String GetPassword() {
		return password;
	}

	public void SetPassword(String password) {
		this.password = password;
	}

	public String GetEmail() {
		return email;
	}

	public void SetEmail(String email) {
		this.email = email;
	}

	public String GetPhone_number() {
		return phone_number;
	}

	public void SetPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String GetAddress() {
		return address;
	}

	public void SetAddress(String address) {
		this.address = address;
	}

	public String GetName() {
		return name;
	}

	public void SetName(String name) {
		this.name = name;
	}
}
