package practica1;

public class Student {

	private String lastname;
	private String firstname;
	private Integer number;
		
	public void setLastname(String newLastname) {
		lastname = newLastname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String newFirstname) {
		firstname = newFirstname;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setNumber(Integer newNumber) {
		number = newNumber;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public String toString() {
		return new StringBuffer(firstname)
			.append(", ")
			.append(lastname)
			.append(" : ")
			.append(number)
			.toString();
	}
	public Boolean equals(Student anotherStudent) {
		return toString().equals(anotherStudent.toString());
	}
}
