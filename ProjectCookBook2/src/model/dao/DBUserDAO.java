package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import model.User;
import model.db.DBManager;

class DBUserDAO implements IUserDAO {
	
	private static DBUserDAO instance;
	private DBManager manager;
	
	private DBUserDAO() {
		manager = DBManager.getInstance();
	}
	
	public static DBUserDAO getInstance(){
		if(instance == null)
			instance = new DBUserDAO();
		return instance;
	}

	public boolean addUser(User newUser) {
		boolean success = true;
		String query = "INSERT INTO season5project_fridge.user (username, password, firstname,lastname, email) VALUES (?, ?, ?, ?, ?);";
		try(PreparedStatement st = manager.getConnection().prepareStatement(query);) {
			st.setString(1, newUser.getUsername());
			st.setString(2, newUser.getPassword());
			st.setString(3, newUser.getFirstname());
			st.setString(4, newUser.getLastname());
			st.setString(5, newUser.getEmail());
			
			st.execute();
			} catch (SQLException e) {
			success = false;
		}
		return success;
	}

	public List<User> getAllUsers() throws SQLException{
		String query = "SELECT username, password, firstname,lastname, email FROM season5project_fridge.user;";
		List<User> users = new ArrayList<>();
		Statement st = manager.getConnection().createStatement();
		ResultSet result = st.executeQuery(query);
		if(result == null){
			st.close();
			return users;
		}
		while(result.next()){
			User u = new User(result.getString(1),
							  result.getString(2),
					          result.getString(3),
					          result.getString(4),
					          result.getString(5));
			users.add(u);
		}
		st.close();
		return users;
	}

	public void updateUser(User loggedUser) {
		String query = "UPDATE user SET firstname=?,lastname=?, password = ?, email = ? WHERE username = ?;";
		try(PreparedStatement st = manager.getConnection().prepareStatement(query);) {
			st.setString(1, loggedUser.getFirstname());
			st.setString(2, loggedUser.getLastname());
			st.setString(3, loggedUser.getPassword());
			st.setString(4, loggedUser.getEmail());
			st.setString(5, loggedUser.getUsername());
			st.executeUpdate();
			} catch (SQLException e) {
				System.out.println("failed update");
		}
	}

}
