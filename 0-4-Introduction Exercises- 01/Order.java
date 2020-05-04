import java.util.Scanner;

public class Order {

	private static String foodOptions[] = {"De Anza Burger","Bacon Cheese","Mushroom Swiss","Western Burger","Don Cali Burger"};

	private static double price[] = {5.25,5.75,5.95,5.95,5.95};

	private static Scanner scan = new Scanner(System.in); //create scanner object

	private int quantity[];	// empty quantity array

	private double balance; // the bill 

	private double tax;



	// Constructor

	public Order(){

		quantity = new int[5];	
		//fill in the quantity with numbers 0-5 

		for(int i = 0; i < quantity.length;i++) {
			quantity[i] = 0;
		}

		balance = 0;	//initial value
		tax = 0;

	}

	//===============================================
	// THIS METHOD DISPLAYS THE MENU TO THE USER
	//===============================================
	public void displayMenu(){

		int i;
		// print options
		for(i = 0; i < foodOptions.length; i++){

			System.out.printf("\n%d. %s $%.2f",(i+1),foodOptions[i],price[i]);

		}
		// print Exit
		System.out.printf("\n%d Exit",(i+1));
	}


	//===============================================
	// THIS METHOD TAKES AND STORES AN INPUT FROM THE USER
	//===============================================
	public void getInputs(){

		int userChoice;
		int qty;

		// do-while loop until user exits

		do{

			displayMenu();		//display menu before every order

			System.out.print("\nEnter choice(1-6): ");

			userChoice = scan.nextInt();		//store user's choice

			// check if input is valid
			while(userChoice < 1 || userChoice > 6){

				System.out.println("The number you entered is invalid");

				System.out.print("Please enter any number 1 through 6: ");

				userChoice = scan.nextInt();

			}

			scan.nextLine();

			if(userChoice != 6){

				System.out.print("Enter the quantity: ");

				qty = scan.nextInt();

				// validate the quantity

				while(qty < 1){

					System.out.println("You must enter number larger than 0");
					System.out.print("Enter the quantity : ");
					qty = scan.nextInt();

				}

				scan.nextLine();

				quantity[userChoice-1] += qty;

			}

		}while(userChoice != 6);

	}


	//===============================================
	// THIS METHOD CALCULATES THE INITIAL BALANCE WITHOUT TAX AND WITH TAX
	//===============================================
	public void calculate(){


		// price without tax
		for(int i = 0; i < quantity.length; i++){

			balance = balance + (quantity[i]*price[i]);
		}

		String studentOrStaff;


		System.out.print("Student / staff ? ");

		studentOrStaff = scan.nextLine();

		// validation of input
		while(!studentOrStaff.equalsIgnoreCase("student") && !studentOrStaff.equalsIgnoreCase("staff")){

			System.out.print("Are you a student or a staff : ");

			studentOrStaff = scan.nextLine();

		}

		if(studentOrStaff.equalsIgnoreCase("student")) {

			tax = 0;
		} else {

			tax = .09 * balance;		// 9% tax for staff
		}
	}




	//===============================================
	// THIS METHOD OUTPUTS THE BILL INCLUDING DESCRIPTION OF WHAT THE
	// USER HAS ORDERED
	//===============================================
	public void printBill() {

		System.out.println("\n\t\t Your Bill");
		
		System.out.println("===============================================");

		System.out.printf("\n%20s %10s %15s","Item","Quantity","Price per item");

		for(int i = 0; i<quantity.length; i++){

			if(quantity[i] > 0){

				System.out.printf("\n%20s %10d %15.2f", foodOptions[i], quantity[i], price[i]);

			}
		}

		System.out.printf("\n%20s : $%-10.2f","Total (before tax)",balance);

		System.out.printf("\n%20s : $%-10.2f","Tax",tax);

		System.out.printf("\n%20s : $%-10.2f","Total(after tax)",balance+tax);

	}

}