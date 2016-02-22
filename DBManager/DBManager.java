
import java.sql.*;


public class DBManager {
	private static DBManager instance=null;
	//database url
	private static final String url="jdbc:mysql://127.0.0.1:3306/fridge?useSSL=false";
	//database credentials
    private static final String user="root";
	private static final String pass="root";
	private static final String query=      "CREATE TABLE User ("
											+"user_ID INTEGER PRIMARY KEY,"
											+"username VARCHAR(20) NOT NULL UNIQUE,"
											+"password VARCHAR(20) NOT NULL,"
											+"firstname VARCHAR(25) NOT NULL,"
											+"lastname VARCHAR(25) NOT NULL,"
											+"email VARCHAR(30) NOT NULL UNIQUE );"

											+"CREATE TABLE ProductType ("
											+"product_type_ID INTEGER PRIMARY KEY,"
											+"product_type_name VARCHAR(30) NOT NULL UNIQUE,"
											+"product_description VARCHAR(1300) );"

											+"CREATE TABLE Products ("
											+"product_ID INTEGER PRIMARY KEY,"
											+"product_name VARCHAR(20) NOT NULL UNIQUE,"
											+"product_type INTEGER,"
											+"purchase_date DATE,"
											+"expiration_date DATE );"

											+"ALTER TABLE Products"
											+"ADD CONSTRAINT product_type_FK"
											+"FOREIGN KEY (product_type)"
											+"REFERENCES ProductType(product_type_ID);"


											+"CREATE TABLE Fridge ("
											+"fridge_ID INTEGER PRIMARY KEY,"
											+"fridge_user_ID INTEGER );"

											+"ALTER TABLE Fridge "
											+"ADD CONSTRAINT fridge_user_ID_FK"
											+"FOREIGN KEY (fridge_user_ID)"
											+"REFERENCES User(user_ID) ;"

											+"CREATE TABLE ProductsOnStock ("
											+"on_stock_id INTEGER PRIMARY KEY,"
											+"product_id_FK INTEGER ,"
											+"fridge_id_FK INTEGER,"
											+"quontity INTEGER );"

											+"ALTER TABLE ProductsOnstock"
											+"ADD CONSTRAINT products_on_stock_product_id_FK"
											+"FOREIGN KEY(product_id_FK)"
											+"REFERENCES Products(product_ID);"

											+"ALTER TABLE ProductsOnstock"
											+"ADD CONSTRAINT products_on_stock_fridge_id_FK"
											+"FOREIGN KEY(fridge_id_FK)"
											+"REFERENCES Products(fridge_id_FK);"


											+"CREATE TABLE RecepieType ("
											+"rec_type_ID INTEGER PRIMARY KEY,"
											+"rec_type VARCHAR(30) NOT NULL UNIQUE,"
											+"rec_type_description VARCHAR(1300) );"

											+"CREATE TABLE Recepie ("
											+"rec_ID INTEGER PRIMARY KEY,"
											+"rec_name VARCHAR(30) NOT NULL UNIQUE,"
											+"rec_description VARCHAR(1300),"
											+"preperation_time INTEGER,"
											+"rec_type_ID INTEGER );"

											+"ALTER TABLE Recepie"
											+"ADD CONSTRAINT rec_type_ID_FK"
											+"FOREIGN KEY(rec_type_ID)"
											+"REFERENCES RecepieType(rec_type_ID);"

											+"CREATE TABLE CookBook ("
											+"rec_ID INTEGER,"
											+"product_ID INTEGER, "
											+"quontity INTEGER NOT NULL,"
											+"recepie_ID INTEGER NOT NULL);"

											+"ALTER TABLE CookBook "
											+"ADD CONSTRAINT book_rec_ID_FK"
											+"FOREIGN KEY (rec_ID)"
											+"REFERENCES Recepie(rec_ID) ;"
											+"ALTER TABLE CookBook"
											+"ADD CONSTRAINT book_product_ID_FK"
											+"FOREIGN KEY(product_id)"
											+"REFERENCES Products(product_ID);";


	private DBManager(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("Connection created successfully");
			Statement stm=con.createStatement();
			int rowsAffected=stm.executeUpdate(query);
			System.out.println(rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static DBManager getInstance(){
		if(instance==null){
			instance=new DBManager();
			return instance;
		}
		else{
			return null;
		}
	}


}
