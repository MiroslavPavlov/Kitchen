package model.db;

import java.io.PrintWriter;
import java.sql.*;


public class DBManager {

	private static DBManager instance;
	
	public static final String DB_NAME = "season5project_fridge";
	
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/season5project_fridge?useSSL=false";
	private static final String DB_USER = "ittalents";
	private static final String DB_PASS = "ittstudent123";
	
	private Connection con;
	
	private DBManager(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("ok");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			System.out.println("Connection created successfully");
			createDB();
		
		}
		catch(SQLException | ClassNotFoundException e){
			System.out.println("Problem with the driver" + e.getMessage());
		}
	}
	
	private void createDB() {
		Statement stm;
		try {
			stm = con.createStatement();
		    String sql=         "CREATE DATABASE IF NOT EXIST " + DB_NAME+";"+
					            "USE " + DB_NAME+ ";"+
					            "CREATE TABLE User ("+
			            		"user_ID INTEGER PRIMARY KEY, "+
			            		"username VARCHAR(20) NOT NULL UNIQUE,"+
			            		"password VARCHAR(20) NOT NULL,"+
			            		"firstname VARCHAR(25) NOT NULL,"+
			            		"lastname VARCHAR(25) NOT NULL,"+
			            		"email VARCHAR(30) NOT NULL UNIQUE );"+

			            		"CREATE TABLE ProductType ("+
			            		"product_type_ID INTEGER PRIMARY KEY,"+
			            		"product_type_name VARCHAR(30) NOT NULL UNIQUE,"+
			            		"product_description VARCHAR(1300) );"+

			            		"CREATE TABLE Products ("+
			            		"product_ID INTEGER PRIMARY KEY,"+
			            		"product_name VARCHAR(20) NOT NULL UNIQUE,"+
			            		"product_type INTEGER,"+
			            		"purchase_date DATE,"+
			            		"expiration_date DATE );"+

			            		"ALTER TABLE Products"+
			            		"ADD CONSTRAINT product_type_FK"+
			            		"FOREIGN KEY (product_type)"+
			            		"REFERENCES ProductType(product_type_ID);"+


			            		"CREATE TABLE Fridge ("+
			            		"fridge_ID INTEGER PRIMARY KEY,"+
			            		"fridge_user_ID INTEGER );"+
			          
			            		"ALTER TABLE Fridge "+
			            		"ADD CONSTRAINT fridge_user_ID_FK"+
			            		"FOREIGN KEY (fridge_user_ID)"+
			            		"REFERENCES User(user_ID) ;"+

			            		"CREATE TABLE ProductsOnStock ("+
			            		"on_stock_id INTEGER PRIMARY KEY,"+
			            		"product_id_FK INTEGER ,"+
			            		"fridge_id_FK INTEGER,"+
			            		"quontity INTEGER );"+

			            		"ALTER TABLE ProductsOnstock"+
			            		"ADD CONSTRAINT products_on_stock_product_id_FK"+
			            		"FOREIGN KEY(product_id_FK)"+
			            		"REFERENCES Products(product_ID);"+

			            		"ALTER TABLE ProductsOnstock"+
			            		"ADD CONSTRAINT products_on_stock_fridge_id_FK"+
			            		"FOREIGN KEY(fridge_id_FK)"+
			            		"REFERENCES Fridge(fridge_ID);"+


			            		"CREATE TABLE RecepieType ("+
			            		"rec_type_ID INTEGER PRIMARY KEY,"+
			            		"rec_type VARCHAR(30) NOT NULL UNIQUE,"+
			            		"rec_type_description VARCHAR(1300) );"+

			            		"CREATE TABLE Recepie ("+
			            		"rec_ID INTEGER PRIMARY KEY,"+
			            		"rec_name VARCHAR(30) NOT NULL UNIQUE,"+
			            		"rec_description VARCHAR(1300),"+
			            		"preperation_time INTEGER,"+
			            		"rec_type_ID INTEGER );"+
			            		
			            		"ALTER TABLE Recepie"+
			            		"ADD CONSTRAINT rec_type_ID_FK"+
			            		"FOREIGN KEY(rec_type_ID)"+
			            		"REFERENCES RecepieType(rec_type_ID);"+

			            		"CREATE TABLE CookBook ("+
			            		"rec_ID INTEGER,"+
			            		"product_ID INTEGER, "+
			            		"quontity INTEGER NOT NULL,"+
			            		"recepie_ID INTEGER NOT NULL);"+

			            		"ALTER TABLE CookBook "+
			            		"ADD CONSTRAINT book_rec_ID_FK"+
			            		"FOREIGN KEY (rec_ID)"+
			            		"REFERENCES Recepie(rec_ID) ;"+
			            		"ALTER TABLE CookBook"+
			            		"ADD CONSTRAINT book_product_ID_FK"+
			            		"FOREIGN KEY(product_id)"+
			            		"REFERENCES Products(product_ID);";

			//stm.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
	}

	public static synchronized DBManager getInstance(){
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
