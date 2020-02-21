package ru.test.models;

public class User {
	private String name;
	private String password;
	private String firstName;
	private String lastName;

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}

	public User(String name, String password, String firstName, String lastName) {
		this.name = name;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
