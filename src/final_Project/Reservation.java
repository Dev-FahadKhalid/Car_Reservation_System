package final_Project;

public class Reservation {

	public void reservation() {

		Manager man=new Manager();
		man.managerInfo();
		Customer cus = new Customer();
		cus.setInfoCustomer();
		cus.getInfoCustomer();

		if (cus.checkLicense()) {
		    man.cardetails();
			man.car_reservation();
			System.out.println("Processed Succeed.");
			} else {
				System.out.println("BadLuck process terminated.");
			}
	}//func

}//Class
