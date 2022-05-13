package david.elias.model;

public class Author {
	
	static int authorQuantity;
	int authorID;
	String name;
	String surname;
	String surname2;
	String country;
	
	public Author() {
		
	}
	
	public Author(String name, String surname, String surname2, String country) {
		
		this.name = name;
		this.surname = surname;
		this.surname2 = surname2;
		this.country = country;
		authorID = authorQuantity;
		authorQuantity++;
		
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

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String toString() {
		return name + "." + surname + "." + surname2 + "." + country + ".";
	}

}
