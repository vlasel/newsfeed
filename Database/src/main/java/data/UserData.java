package data;

import java.io.Serializable;

public class UserData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public UserData() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	//######### fields ##############
	private String email;
	transient private String pass;
	private String name;
	private String surname;
	//#####################################
	
	
	@Override
	public int hashCode() {
		return ((email == null) ? 0 : email.hashCode());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserData) {

			UserData ud = (UserData) obj;
			
			if (email == null && ud.email != null) {
				return false;
			}
			else if (!email.equals(ud.email)) {
				return false;
			}
			
			else if (name == null && ud.name != null) {
				return false;
			}
			else if (!name.equals(ud.name)) {
				return false;
			}
			
			else if (pass == null && ud.pass != null) {
				return false;
			}
			else if (!pass.equals(ud.pass)) {
				return false;
			}
			
			else if (surname == null && ud.surname != null) { 
				return false;
			}
			else if (!surname.equals(ud.surname)) { 
				return false;
			}
			else return true;
		}
		else return false;
	}
	
	@Override
	public String toString() {
		return "UserData [email=" + email + "; "
				+ "pass=" + pass + "; "
				+ "name=" + name + "; "
				+ "surname=" + surname + "]";
	}
	
	
	
	
}
