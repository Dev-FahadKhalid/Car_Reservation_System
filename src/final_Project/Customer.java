package final_Project;

import java.util.Scanner;

public class Customer {

	Scanner sc=new Scanner(System.in);
	
	private int id;
	private String cnic;
	private String name;
	private int age;
	private String address;
	
	public void setInfoCustomer() {
		this.setid();
		this.setcnic();
		this.setname();
		this.setage();
		this.setaddress();
	}
	private  void setid() {
		System.out.println("\n Enter Your ID integer: ");
		this.id = sc.nextInt();
		sc.nextLine();
	}
	private  void setcnic() {
		System.out.println("\n Enter Your Cnic: String");
		this.cnic = sc.nextLine();
	}
	private  void setname() {
		System.out.println("\n Enter Your Name  String: ");
		this.name = sc.nextLine();
	}
	private  void setage() {
		System.out.println("\n Enter Your Age Integer: ");
		this.age = sc.nextInt();
		sc.nextLine();
	}
	private  void setaddress() {
		System.out.println("\n Enter the Address String: ");
		this.address = sc.nextLine();
	}


	public void getInfoCustomer() {
	
		System.out.println("\n Customer ID : " + this.id);
		System.out.println("\n Customer Cnic : " + this.cnic);
		System.out.println("\n Customer Name : " + this.name);
		System.out.println("\n Customer Age : " + this.age);
		System.out.println("\n Customer Address : " + this.address);
	}
	
	
	public boolean checkLicense() {
		System.out.println("\n Do you have License for Car:");
		System.out.println("Press T for Yes.");
		System.out.println("Press Any key for No.");
		char choice;
			System.out.println("\n Enter Your Choice Character :");
			choice = sc.next().charAt(0);
		if (choice == 't' || choice == 'T') {
			System.out.println("\n Good to know that  ");
			return true;
		} else {
			System.out.println("\n BadLuck You are not able to succeed this process.");
			return false;
		}
	}
}
