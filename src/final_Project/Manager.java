package final_Project;

public class Manager  {

	String name;
	String email;
	String phone_No;
	 Car c=new Car();

	public Manager() {
		this.name = " Fahad Khalid";
		this.email = " demo@gmail.com";
		this.phone_No = " 0314-7714714";
	}	
	public void managerInfo() {
		System.out.println("\n Manager Details : ");
		System.out.println("\n Name : " + this.name);
		System.out.println("\n Email : " + this.email);
		System.out.println("\n Phone_No : " + this.phone_No);
	}	
   public void cardetails() {
	   //Composition
	   c.getInfoCar();
   }
   public void car_reservation() {
	   //Composition
	   c.reserveCar();
   }
   public void addcar() {
	 //Composition
	   c.addCar();
   }
}
