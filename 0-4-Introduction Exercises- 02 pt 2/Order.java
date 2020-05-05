
public abstract class Order implements OrderInterface{

	protected static String foodOptions[] = {"De Anza Burger","Bacon Cheese","Mushroom Swiss","Western Burger","Don Cali Burger"};

	protected final double price[] = {5.25,5.75,5.95,5.95,5.95};

	protected int quantity[];	// empty quantity array

	
	// Constructor

	public Order(){

		quantity = new int[5];	
		//fill in the quantity with numbers 0-5 

		for(int i = 0; i < quantity.length;i++) {
			quantity[i] = 0;
		}

	}

	//===============================================
	// THIS METHOD DISPLAYS THE MENU TO THE USER
	//===============================================
	public void displayMenu(){

		System.out.println("==========================================");
		
		int i;
		// print options
		for(i = 0; i < foodOptions.length; i++){

			System.out.printf("\n%d. %s $%.2f",(i+1),foodOptions[i],price[i]);

		}
		// print Exit
		System.out.printf("\n%d Exit\n",(i+1));
		
	}


	
	public abstract void getInputs();// get integer from user  //should be overridden in OrderBurger class
	public abstract void calculate();// calculate the bill  //should be overridden in OrderBurger class
	public abstract void printBill(); // print out the bill  //should be overridden in OrderBurger class

	public abstract void saveBillToFile();// saves the bill in a file  //should be overridden in OrderBurger class

}
	


