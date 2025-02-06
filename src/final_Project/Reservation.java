package final_Project;

import java.sql.Connection;

public class Reservation {


	public void reservation(Connection con) {

		Manager man=new Manager();
		     man.managerInfo();
		Customer cus = new Customer();
		     cus.addCustomer(con);
		     man.cardetails();
			 man.car_reservation();
			System.out.println("Processed Succeed.");
			
	}//func

	

}//Class
