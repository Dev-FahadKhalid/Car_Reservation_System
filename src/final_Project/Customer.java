package final_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {

	static Scanner sc = new Scanner(System.in);
	 //Connection connection = null;

	
	/*public Customer() {
		try {
			
			String url = "jdbc:sqlserver://DESKTOP-8BL3MIG\\DEFAULTSERVER:1433;databaseName=CarReservationDB;trustServerCertificate=true";
        	String username="Fahad";
        	String password="12345678";
        	
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connection established successfully.");
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database:");
			e.printStackTrace();
		}
	}*/


	public static void addCustomer(Connection con) {
		System.out.println("\nEnter Customer Details:");
		System.out.print("ID (int): ");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.print("CNIC (String): ");
		String cnic = sc.nextLine();
		System.out.print("Name (String): ");
		String name = sc.nextLine();
		System.out.print("Age (int): ");
		int age = sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.print("Address (String): ");
		String address = sc.nextLine();

		String query = "INSERT INTO CustomerDetails (id, cnic, name, age, address) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			ps.setString(2, cnic);
			ps.setString(3, name);
			ps.setInt(4, age);
			ps.setString(5, address);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Customer details added successfully!");
			}
		} catch (SQLException e) {
			System.out.println("Error while adding customer details:");
			e.printStackTrace();
		}
	}

	
	public static void viewAllCustomers(Connection con) {
		String query = "SELECT * FROM CustomerDetails";

		try (Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query)) {

			System.out.println("\nCustomer Details:");
			while (rs.next()) {
				System.out.println(
						"ID: " + rs.getInt("id") + ", CNIC: " + rs.getString("cnic") + ", Name: " + rs.getString("name")
								+ ", Age: " + rs.getInt("age") + ", Address: " + rs.getString("address"));
			}

		} catch (SQLException e) {
			System.out.println("Error while fetching customer details:");
			e.printStackTrace();
		}
	}


	public static void deleteCustomer(Connection con) {
		System.out.print("\nEnter the ID of the customer to delete: ");
		int id = sc.nextInt();

		String query = "DELETE FROM CustomerDetails WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Customer with ID " + id + " deleted successfully.");
			} else {
				System.out.println("No customer found with ID " + id + ".");
			}
		} catch (SQLException e) {
			System.out.println("Error while deleting customer:");
			e.printStackTrace();
		}
	}

	
	/*public void closeConnection(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				System.out.println("Database connection closed successfully.");
			}
		} catch (SQLException e) {
			System.out.println("Error while closing the database connection:");
			e.printStackTrace();
		}
	}*/

	
}
