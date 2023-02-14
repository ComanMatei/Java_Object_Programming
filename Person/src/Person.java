public class Person {
	private String name;
	private String surname;
	private String PNC;
	
	public Person(String n,String s,String p) {
		this.name=n;
		this.surname=s;
		this.PNC=p;
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

	public String getPNC() {
		return PNC;
	}

	public void setPNC(String PNC) {
		PNC = PNC;
	}
	
	public String toString() {
		return name+" "+surname+" "+PNC;
	}
}
