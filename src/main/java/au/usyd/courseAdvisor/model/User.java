package au.usyd.courseAdvisor.model;

public class User {

  private String username;
  private String password;
  private String firstname;
  private String lastname;
  private String email;
  private String address;
  private String displayFirstName;
  private String displayLastName;
  private String specialisation;
  private String interest;
  private String careerObjective;
  private String occupation;
  private String faculty;
  
  public User() {
  }
  
  public User(String username, String password, String firstname, String lastname, String email,
			String displayFirstName, String displayLastName, String specialisation, String interest,
			String careerObjective, String occupation, String faculty) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.displayFirstName = displayFirstName;
		this.displayLastName = displayLastName;
		this.specialisation = specialisation;
		this.interest = interest;
		this.careerObjective = careerObjective;
		this.occupation = occupation;
		this.faculty = faculty;
	} 
  
 public String getDisplayFirstName() {
	return displayFirstName;
}

public void setDisplayFirstName(String displayFirstName) {
	this.displayFirstName = displayFirstName;
}

public String getDisplayLastName() {
	return displayLastName;
}

public void setDisplayLastName(String displayLastName) {
	this.displayLastName = displayLastName;
}

public String getSpecialisation() {
	return specialisation;
}

public void setSpecialisation(String specialisation) {
	this.specialisation = specialisation;
}

public String getInterest() {
	return interest;
}

public void setInterest(String interest) {
	this.interest = interest;
}

public String getCareerObjective() {
	return careerObjective;
}

public void setCareerObjective(String careerObjective) {
	this.careerObjective = careerObjective;
}

public String getOccupation() {
	return occupation;
}

public void setOccupation(String occupation) {
	this.occupation = occupation;
}

public String getFaculty() {
	return faculty;
}

public void setFaculty(String faculty) {
	this.faculty = faculty;
}

private int phone;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    System.out.println("username: " + username);
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    System.out.println("firstname: " + firstname);
    this.displayFirstName = firstname;
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    System.out.println("lastname: " + lastname);
    this.displayLastName = lastname;
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }
}
