import java.util.*;
import java.io.FileWriter;

public class OrderBurger extends Order {

	// ... The body of your code based on your design
	Scanner in = new Scanner(System.in);

	int item[];
	int qty[];
	int total;
	double balance;
	double finalTax;

	public OrderBurger() {
		total = 0;
		item = new int[100];
	}

	// ===============================================
	// THIS METHOD TAKES AND STORES AN INPUT FROM THE USER
	// ===============================================
	public void getInputs() {

		int userChoice;
		int qty;

		// do-while loop until user exits

		do {

			displayMenu(); // display menu before every order

			System.out.print("\nEnter choice(1-6): ");

			userChoice = in.nextInt(); // store user's choice

			// check if input is valid
			while (userChoice < 1 || userChoice > 6) {

				System.out.println("The number you entered is invalid");

				System.out.print("Please enter any number 1 through 6: ");

				userChoice = in.nextInt();

			}

			in.nextLine();

			if (userChoice != 6) {

				System.out.print("Enter the quantity: ");

				qty = in.nextInt();

				// validate the quantity

				while (qty < 1) {

					System.out.println("You must enter number larger than 0");
					System.out.print("Enter the quantity : ");
					qty = in.nextInt();

				}

				in.nextLine();

				quantity[userChoice - 1] += qty;

			}

		} while (userChoice != 6);

	}

	// ===============================================
	// THIS METHOD CALCULATES THE INITIAL BALANCE WITHOUT TAX AND WITH TAX
	// ===============================================
	public void calculate() {

		// price without tax
		for (int i = 0; i < quantity.length; i++) {

			balance = balance + (quantity[i] * super.price[i]);
		}

		String studentOrStaff;

		System.out.print("Student / staff ? ");

		studentOrStaff = in.nextLine();

		// validation of input
		while (!studentOrStaff.equalsIgnoreCase("student") && 
				!studentOrStaff.equalsIgnoreCase("staff")) {

			System.out.print("Are you a student or a staff : ");

			studentOrStaff = in.nextLine();

		}

		if (studentOrStaff.equalsIgnoreCase("student")) {

			finalTax = 0;
		} else {

			finalTax = TAX * balance; // 9% tax for staff
		}
	}

	// ===============================================
	// THIS METHOD OUTPUTS THE BILL INCLUDING DESCRIPTION OF WHAT THE
	// USER HAS ORDERED
	// ===============================================
	public void printBill() {

		System.out.println("\n\t\t Your Bill");

		System.out.println("===============================================");

		System.out.printf("\n%20s %10s %15s", "Item", "Quantity", "Price per item");

		for (int i = 0; i < quantity.length; i++) {

			if (quantity[i] > 0) {

				System.out.printf("\n%20s %10d %15.2f", foodOptions[i], quantity[i], price[i]);

			}
		}

		System.out.printf("\n%20s : $%-10.2f", "Total (before tax)", balance);

		System.out.printf("\n%20s : $%-10.2f", "Tax", finalTax);

		System.out.printf("\n%20s : $%-10.2f", "Total(after tax)", balance + finalTax);

	}

	// save the bill in a file
	public void saveBillToFile() {
		try {
			FileWriter fw = new FileWriter("Bill.txt");

			fw.write("===================================================\n");
			fw.write("\t\t\tBILL\n");
			fw.write("===================================================\n");
			fw.write("Slno\t" + "Item Name\t" + "Qty\t" + "Price/Qty\t" + "Total Price\n");
			fw.write("===================================================\n");
			for (int i = 0; i < total; i++) {
				fw.write((i + 1) + "\t" + foodOptions[item[i]] + "\t" + quantity[i] + "\t" 
						+ price[item[i]] + "\t\t"
						+ quantity[i] * price[item[i]] + "\n");
			}
			fw.write("===================================================\n");
			fw.write("Total: " + balance + "\n");
			fw.write("Tax: " + finalTax + "\n");
			fw.write("===================================================\n");
			fw.write("Grand Total: " + (balance + finalTax) + "\n");
			fw.write("===================================================\n");

			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

/*
 * int purchase[]; int quantityPurchase[]; int total; float totalBill; String
 * stud; float tax; public OrderBurger(){ total=0; purchase=new int[100];
 * quantityPurchase=new int[100]; } // get inputs from user public void
 * getInputs() { total=0; int i; int q; totalBill=0; Scanner in=new
 * Scanner(System.in); while(true){ System.out.print("Enter your choice: ");
 * i=in.nextInt(); if(i==6) break; purchase[total]=i;
 * System.out.print("Enter number of quantity: "); q=in.nextInt();
 * quantityPurchase[total]=q; total++; }
 * System.out.print("Are you a student?(y/n)"); stud=in.next(); }
 * 
 * // calculate the bill public void calculate() { for(int i=0;i<total;i++){
 * if(quantityPurchase[i]<=quantity[purchase[i]]){ totalBill +=
 * quantityPurchase[i] * priceArray[purchase[i]];
 * quantity[purchase[i]]-=quantityPurchase[i]; } }
 * if(stud.equals("n")||stud.equals("N")){ tax=totalBill*TAX; } else tax=0;
 * 
 * } // print out the bill public void printBill() {
 * System.out.println("____________________________________________________");
 * System.out.println("\t\t\tBILL");
 * System.out.println("___________________________________________________");
 * System.out.println("Slno\t"+"Item Name\t"+"Qty\t"+"Price/Qty\t"+"Total Price"
 * ); System.out.println("___________________________________________________");
 * for(int i=0;i<total;i++){
 * System.out.println((i+1)+"\t"+itemName[purchase[i]]+"\t"+quantityPurchase[i]+
 * "\t"+priceArray[purchase[i]]+"\t\t"+quantityPurchase[i] *
 * priceArray[purchase[i]]); }
 * System.out.println("___________________________________________________");
 * System.out.println("Total: "+totalBill); System.out.println("Tax: "+tax);
 * System.out.println("___________________________________________________");
 * System.out.println("Grand Total: "+(totalBill+tax));
 * System.out.println("___________________________________________________");
 * 
 * }
 * 
 * // save the bill in a file public void saveBillToFile() { try{ FileWriter
 * fw=new FileWriter("Bill.txt");
 * 
 * fw.write("____________________________________________________\n");
 * fw.write("\t\t\tBILL\n");
 * fw.write("___________________________________________________\n");
 * fw.write("Slno\t"+"Item Name\t"+"Qty\t"+"Price/Qty\t"+"Total Price\n");
 * fw.write("___________________________________________________\n"); for(int
 * i=0;i<total;i++){
 * fw.write((i+1)+"\t"+itemName[purchase[i]]+"\t"+quantityPurchase[i]+"\t"+
 * priceArray[purchase[i]]+"\t\t"+quantityPurchase[i] *
 * priceArray[purchase[i]]+"\n"); }
 * fw.write("___________________________________________________\n");
 * fw.write("Total: "+totalBill+"\n"); fw.write("Tax: "+tax+"\n");
 * fw.write("___________________________________________________\n");
 * fw.write("Grand Total: "+(totalBill+tax)+"\n");
 * fw.write("___________________________________________________\n");
 * 
 * 
 * 
 * fw.close(); }catch(Exception e){System.out.println(e);}
 * 
 * }
 * 
 * }
 */
