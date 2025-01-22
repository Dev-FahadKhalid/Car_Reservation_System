package final_Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Car {

	Scanner sc = new Scanner(System.in);
	protected int id;
	private String make;
	private String model;
	private int year;
	protected int stockquantity;
	protected int rent;

	public Car() {
		this.id = 1111;
		this.make = "";
		this.model = "";
		this.year = 0;
		this.stockquantity = 0;
		this.rent = 0;
	}

	public Car(int id, String make, String model, int year, int stockquantity, int rent) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.stockquantity = stockquantity;
		this.rent = rent;
	}

	private int setid() {
		System.out.println("\n Enter the ID of Car Integer: ");
		this.id = sc.nextInt();
		sc.nextLine();
		return id;
	}

	private String setmake() {
		System.out.println("\n Enter the Name of Company String: ");
		this.make = sc.nextLine();
		return make;
	}

	private String setmodel() {
		System.out.println("\n Enter the Name of Model String: ");
		this.model = sc.nextLine();
		return model;
	}

	private int setyear() {
		System.out.println("\n Enter the Year of Manufactured Integer: ");
		this.year = sc.nextInt();
		sc.nextLine();
		return year;
	}

	private int setstockquantity() {
		System.out.println("\n Enter the Stock Quantity Integer: ");
		this.stockquantity = sc.nextInt();
		sc.nextLine();
		return stockquantity;
	}

	private int setrent() {
		System.out.println("\n Enter the Per Hour Rent of Car Integer: ");
		this.rent = sc.nextInt();
		sc.nextLine();
		return rent;
	}

	public void getInfoCar() {
		File carfile = new File("C:\\Users\\PMLS\\Desktop\\Cardetails.txt");
		if (!carfile.exists()) {
			System.out.println("The file does not exist. Please add cars first.");
			return;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(carfile))) {
			System.out.println("Displaying car details from the file:\n");
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					String id = parts[0];
					String make = parts[1];
					String model = parts[2];
					String year = parts[3];
					String stockquantity = parts[4];
					String rent = parts[5];
					System.out.println("ID: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + year
							+ ", Stock Quantity: " + stockquantity + ", Rent: " + rent);
				} else {
					System.out.println("Invalid entry found in the file: " + line);
				}
			}
			System.out.println();
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file:");
			e.printStackTrace();
		}
	}

	public void addCar() {
		File carfile = new File("C:\\Users\\PMLS\\Desktop\\Cardetails.txt");
		try {
			if (carfile.createNewFile()) {

				System.out.println("File has been created succesfully." + carfile.getName());
			} else {
				System.out.println("File Already exist.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(carfile, true))) {
			int size;
			System.out.println("\n Enter No # Of Cars you want to add:");
			size = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < size; i++) {

				System.out.println("\nAdding details for car " + (i + 1) + ":");

				int id = this.setid();
				String make = this.setmake();
				String model = this.setmodel();
				int year = this.setyear();
				int stockquantity = this.setstockquantity();
				int rent = this.setrent();

				writer.write(id + "," + make + "," + model + "," + year + "," + stockquantity + "," + rent);
				writer.newLine();
			}
			System.out.println("\nCars added successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reserveCar() {
		File carfile = new File("C:\\Users\\PMLS\\Desktop\\Cardetails.txt");
		if (!carfile.exists()) {
			System.out.println("The file does not exist. Please add cars first.");
			return;
		}
		System.out.print("\nEnter the ID of the car you want to reserve: ");
		int searchId = sc.nextInt();
		sc.nextLine();

		boolean carFound = false;
		boolean stockUpdated = false;

		StringBuilder updatedContent = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(carfile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					int id = Integer.parseInt(parts[0]);
					String make = parts[1];
					String model = parts[2];
					int year = Integer.parseInt(parts[3]);
					int stockquantity = Integer.parseInt(parts[4]);
					int rent = Integer.parseInt(parts[5]);

					if (id == searchId) {
						carFound = true;
						int stock;
						System.out.println("Enter your stock requirement.");
						stock = sc.nextInt();
						if (stock > 0 && stockquantity >= stock) {
							stockquantity = stock - stockquantity;
							stockUpdated = true;

							System.out.print("Enter the number of hours you want to rent the car: ");
							int hours = sc.nextInt();
							int totalCost = rent * hours * stock;
							System.out.println("\n Car reserved successfully!");
							System.out.println("Total rental cost: " + totalCost);
						} else {
							System.out.println("\n Sorry, this car is out of stock.");
						}
					}
					updatedContent.append(id).append(",").append(make).append(",").append(model).append(",")
							.append(year).append(",").append(stockquantity).append(",").append(rent).append("\n");
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file:");
			e.printStackTrace();
			return;
		}

		if (!carFound) {
			System.out.println("\nCar with ID " + searchId + " not found.");
		}

		if (stockUpdated) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(carfile))) {
				writer.write(updatedContent.toString());
			} catch (IOException e) {
				System.out.println("An error occurred while updating the file:");
				e.printStackTrace();
			}
		}
	}

}
