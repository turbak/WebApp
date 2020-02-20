package ru.test.webapp.db;

import ru.test.webapp.entity.Person;

import java.sql.*;

public class Login {
	static final String DB_URL = "jdbc:postgresql://localhost:5432/webapp";
	static final String USER = "turbak";
	static final String PASS = "3361406";

	private static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static boolean login(String login, String password) {
		Connection connection = connect();
		if (connection != null) {
			System.out.println("Connection successul");
			String sel = "SELECT * FROM users WHERE login = ? AND password = ?";
			PreparedStatement passchk = null;
			try {
				passchk = connection.prepareStatement(sel);

			passchk.setString(1, login);
			passchk.setString(2, password);
			return passchk.executeQuery().next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static Person getPerson(String login) {
		Connection connection = connect();
		if (connection != null) {
			String str = "SELECT name, surname FROM users WHERE login = ?";
			try {
				PreparedStatement statement = connection.prepareStatement(str);
				statement.setString(1, login);
				ResultSet set = statement.executeQuery();
				Person person = new Person();
				set.next();
				person.setName(set.getString("name"));
				person.setSurname(set.getString("surname"));
				return person;
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}

	public static boolean register(String login, String password, String name, String surname) {
		Connection connection = connect();
		if (connection != null) {
			String str = "INSERT INTO users (login, password, name, surname) VALUES (?, ?, ?, ?)";
			try {
				PreparedStatement statement = connection.prepareStatement(str);
				statement.setString(1, login);
				statement.setString(2, password);
				statement.setString(3, name);
				statement.setString(4, surname);
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
}
