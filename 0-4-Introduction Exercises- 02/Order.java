
public abstract class Order implements OrderInterface{

	
		private static String foodOptions[] = {"De Anza Burger","Bacon Cheese","Mushroom Swiss","Western Burger","Don Cali Burger"};

	   // display the menu
	   // final prices so that it won't be overwritten  
	   final float priceArray[] = {5.25f,5.75f,5.95f,5.95f,5.95f};
	  

	   
	   String itemName[]={"De Anza Burger","Bacon Cheese","Mushroom Swiss","Western Burger","Don Cali Burger"};
	   
	   //===============================================
		// THIS METHOD DISPLAYS THE MENU TO THE USER
		//===============================================
		public void displayMenu(){

			int i;
			// print options
			for(i = 0; i < foodOptions.length; i++){

				System.out.printf("\n%d. %s $%.2f",(i+1),foodOptions[i],priceArray[i]);

			}
			// print Exit
			System.out.printf("\n%d Exit",(i+1));
		}



	   public abstract void getInputs();// get integer from user //should be overridden in OrderBurger class
	   public abstract void calculate();// calculate the bill //should be overridden in OrderBurger class
	   public abstract void printBill(); // print out the bill //should be overridden in OrderBurger class

	   public abstract void saveBillToFile();// saves the bill in a file //should be overridden in OrderBurger class
	}