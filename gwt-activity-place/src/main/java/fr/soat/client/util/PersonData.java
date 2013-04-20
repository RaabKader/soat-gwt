package fr.soat.client.util;

import fr.soat.shared.Person;

public class PersonData {
	
	private Person person;
	/**
	 * Liste civilités 
	 */
	private String[] civilites;
	
	/**
	 * Constructeur pour civilités 
	 */
	public PersonData() {
		civilites = new String[]{"Mlle", "Mme", "Mr"};
	}

	/**
	 * 
	 * @return String[]
	 */
	public String[] getCivilites() {
		return civilites;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setCivilites(String[] civilites) {
		this.civilites = civilites;
	}
	
}
