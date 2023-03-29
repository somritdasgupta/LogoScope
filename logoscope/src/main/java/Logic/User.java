package Logic;

public class User {

	// bas getters and setters h isme. nothing more.
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User(int user_id, String username, String password, String email, int isAdmin) {
		//super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	private int user_id;
	private String username;
	private String password;
	private String email;
	private int isAdmin;
}
