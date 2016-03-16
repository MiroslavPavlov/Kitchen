package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.dao.DBUserDAO;

import model.User;

public interface IUserDAO {

	enum DataSource {
		DB, JSON, XML, CSV, PLC
	}

	boolean addUser(User newUser);

	List<User> getAllUsers() throws SQLException;

	static IUserDAO getDAO(DataSource ds) {
		switch (ds) {
		case DB:
			return DBUserDAO.getInstance();
		default:
			throw new IllegalArgumentException();
		}
	}

	void updateUser(User loggedUser);
}
