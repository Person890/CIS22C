import java.util.Scanner;

import java.io.FileWriter;



public class OrderBurger extends Order {

   int purchase[];
   int quantity[];
   int total;
   float totalBill;
   String stud;
   float tax;
   private Scanner in;
   public OrderBurger(){
       total=0;
       purchase = new int[100];
       quantity = new int[100];
   }
 //===============================================
 	// THIS METHOD TAKES AND STORES AN INPUT FROM THE USER
 	//===============================================
 	public void getInputs(){

 		Scanner in=new Scanner(System.in);
 		int userChoice;
 		int qty;

 		// do-while loop until user exits

 		do{

 			displayMenu();		//display menu before every order

 			System.out.print("\nEnter choice(1-6): ");

 			userChoice = in.nextInt();		//store user's choice

 			// check if input is valid
 			while(userChoice < 1 || userChoice > 6){

 				System.out.println("The number you entered is invalid");

 				System.out.print("Please enter any number 1 through 6: ");

 				userChoice = in.nextInt();

 			}

 			in.nextLine();

 			if(userChoice != 6){

 				System.out.print("Enter the quantity: ");

 				qty = in.nextInt();

 				// validate the quantity

 				while(qty < 1){

 					System.out.println("You must enter number larger than 0");
 					System.out.print("Enter the quantity : ");
 					qty = in.nextInt();

 				}

 				in.nextLine();

 				quantity[userChoice-1] += qty;

 			}

 		}while(userChoice != 6);

 	}

   // calculate the bill
   public void calculate() {
       for(int i=0;i<total;i++){
           if(quantity[i]<=quantity[purchase[i]]){
               totalBill += quantity[i] * priceArray[purchase[i]];
               quantity[purchase[i]]-=quantity[i];
           }
       }
       if(stud.equals("n")||stud.equals("N")){
           tax=totalBill*TAX;
       }
       else
           tax=0;
      
   }
   // print out the bill
   public void printBill() {
       System.out.println("____________________________________________________");
       System.out.println("\t\t\tBILL");
       System.out.println("___________________________________________________");
       System.out.println("Slno\t"+"Item Name\t"+"Qty\t"+"Price/Qty\t"+"Total Price");
       System.out.println("___________________________________________________");
       for(int i=0;i<total;i++){
           System.out.println((i+1)+"\t"+itemName[purchase[i]]+"\t"+quantity[i]+"\t"+priceArray[purchase[i]]+"\t\t"+quantity[i] * priceArray[purchase[i]]);
       }
       System.out.println("___________________________________________________");
       System.out.println("Total: "+totalBill);
       System.out.println("Tax: "+tax);
       System.out.println("___________________________________________________");
       System.out.println("Grand Total: "+(totalBill+tax));
       System.out.println("___________________________________________________");
      
   }

   // save the bill in a file
   public void saveBillToFile() {
       try{
FileWriter fw=new FileWriter("Bill.txt");

fw.write("____________________________________________________\n");
           fw.write("\t\t\tBILL\n");
           fw.write("___________________________________________________\n");
           fw.write("Slno\t"+"Item Name\t"+"Qty\t"+"Price/Qty\t"+"Total Price\n");
           fw.write("___________________________________________________\n");
           for(int i=0;i<total;i++){
               fw.write((i+1)+"\t"+itemName[purchase[i]]+"\t"+quantity[i]+"\t"+priceArray[purchase[i]]+"\t\t"+quantity[i] * priceArray[purchase[i]]+"\n");
           }
           fw.write("___________________________________________________\n");
           fw.write("Total: "+totalBill+"\n");
           fw.write("Tax: "+tax+"\n");
           fw.write("___________________________________________________\n");
           fw.write("Grand Total: "+(totalBill+tax)+"\n");
           fw.write("___________________________________________________\n");
         


fw.close();
}catch(Exception e){System.out.println(e);}
  
}   
  
}