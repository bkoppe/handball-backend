package de.augsburg1871.handball.backend.model;

import java.time.LocalDate;

public class Person {

	private String firstName, LastName;
	private LocalDate birthDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(final String lastName) {
		LastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public static class PersonBuilder {

		private String lastName;
		private String firstName;
		private LocalDate birthDate;

		public static PersonBuilder create() {
			return new PersonBuilder();
		}

		public static Person createWith(final String lastName, final String firstName,
				final LocalDate birthDate) {
			return new PersonBuilder().lastName(lastName).firstName(firstName).birthDate(birthDate).build();
		}

		public PersonBuilder lastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PersonBuilder firstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public PersonBuilder birthDate(final LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Person build() {
			final Person person = new Person();
			person.setLastName(lastName);
			person.setFirstName(firstName);
			person.setBirthDate(birthDate);

			return person;
		}

	}

}
