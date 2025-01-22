package final_Project;

import java.util.Scanner;

public class Main_Project {

	public static void main(String args[]) {
		
		Scanner sc =new Scanner (System.in);
		
		int choice;
		
		System.out.println("------------ Awan Rent A Car's ------------");
		System.out.println("------------ Menu displayer ---------------");
		do {
		System.out.println("------------ Press 1 For Adding New Car.");
		System.out.println("------------ Press 2 For Reserving a Car.");
		System.out.println("------------ Press 3 For Terminating A Program.");
		
		System.out.println("Enter your choice :");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println(" Want to add a Car.(Manager)");

			Manager manager=new Manager();
			manager.managerInfo();
			manager.cardetails();
			manager.addcar();
			break;
			
		case 2:
			System.out.println(" Want to reserve  a Car.(Customer)");
			Reservation res=new Reservation();
			res.reservation();
			break;
		
		case 3:
			System.out.println(" Wants to terminate program.");
			System.out.println(" Terminate program.");
		    break;
		default :
			System.out.println(" OOps! Invalid Input.");
				
		      }
		}while(choice != 3);
		
		}
}
