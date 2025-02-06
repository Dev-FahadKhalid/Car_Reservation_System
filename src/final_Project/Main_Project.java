package final_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main_Project {

	public static void main(String args[]) {
		
		Scanner sc =new Scanner (System.in);
		
		Connection con=null;
     try {
			
			String url = "jdbc:sqlserver://DESKTOP-8BL3MIG\\DEFAULTSERVER:1433;databaseName=CarReservationDB;trustServerCertificate=true";
        	String username="Fahad";
        	String password="12345678";
        	
		    con = DriverManager.getConnection(url, username, password);
			System.out.println("Database connection established successfully.");
			
			
			Manager manager=new Manager();
			Reservation res=new Reservation();
			Customer cus=new Customer();
			int choice;
			
			
			System.out.println("-----		 Awan Rent A Car's 		-------");
			System.out.println("----------   Menu displayer   -------------");
			do {
			System.out.println("-------		 Press 1 For Adding New Car.");
			System.out.println("-------		 Press 2 For Deleting A Car.");
			System.out.println("-------		 Press 3 For Reserving A Car.");
			System.out.println("-------		 Press 4 For Veiwing Customer Details.");
			System.out.println("-------		 Press 5 Deleting Customer.");
			System.out.println("-------		 Press 6 For Terminating A Program.");
			
			System.out.println("Enter your choice :");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println(" Want to add a Car.(Manager)");
				manager.managerInfo();
				manager.cardetails();
				manager.addcar();
				break;
			case 2:
				System.out.println(" Want to delete a Car.(Manager)");
				manager.managerInfo();
				manager.cardetails();
				manager.delcar();
				break;
				
			case 3:
				System.out.println(" Want to reserve  a Car.(Customer)");
				res.reservation(con);
				break;
			case 4:
				System.out.println(" Want to veiw Customer details.");
				cus.viewAllCustomers(con);
			    break;
		    case 5:
		    	System.out.println(" Want to veiw Customer details.");
				cus.deleteCustomer(con);
				    break;
			case 6:
				System.out.println(" Wants to terminate program.");
				System.out.println(" Terminate program.");
			    break;
			default :
				System.out.println(" OOps! Invalid Input.");
					
			      }
			}while(choice != 6);
			
			
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database:");
			e.printStackTrace();
		}
              finally {
        
        if (con != null) {
            try {
                con.close();
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                System.out.println("Error while closing the database connection:");
                e.printStackTrace();
            }
        }
        sc.close(); // Close the scanner
    }

		}
}
