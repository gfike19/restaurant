import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private String username;
	private String hashed_pwd;
	
	public User (String username, String hashed_pwd) {
		this.setUsername(username);
		this.hashed_pwd = hashed_pwd;
	}
	
	private static String hashPassword(String pwd) {
		String hashed_pwd =  pwd;
		return hashed_pwd;
	}
	
	public boolean isValidPassword(String password) {
		if (!password.equals(hashed_pwd)) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidUsername (String username) {
		Pattern p = Pattern.compile(username);
		Matcher m = p.matcher("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
		boolean b = m.matches();
		return b;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	static ArrayList <User> usr_lst = new ArrayList <User>();
}
