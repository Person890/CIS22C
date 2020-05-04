//@Natalie Stepankevycova
//CIS 22C - 0-4 Introduction Exercise - 01

/* This program shows user a menu, lets user enter choice of a meal and quantity. 
 * The program stores inputs and prompts user to enter if they are staff or student.
 * The program calculates and displays user's bill and depending if the user is 
 * staff it will add 9% tax to the final price.
 * */



public class Driver {
     
       public static void main(String[] args){
    	   
    	   //calling each method individually
             Order order = new Order();
             order.getInputs();
             order.calculate();
             order.printBill();
       }
}


/*	SAMPLE RUN
  
  
1. De Anza Burger $5.25
2. Bacon Cheese $5.75
3. Mushroom Swiss $5.95
4. Western Burger $5.95
5. Don Cali Burger $5.95
6 Exit
Enter choice(1-6): 2
Enter the quantity: 4

1. De Anza Burger $5.25
2. Bacon Cheese $5.75
3. Mushroom Swiss $5.95
4. Western Burger $5.95
5. Don Cali Burger $5.95
6 Exit
Enter choice(1-6): 5
Enter the quantity: 3

1. De Anza Burger $5.25
2. Bacon Cheese $5.75
3. Mushroom Swiss $5.95
4. Western Burger $5.95
5. Don Cali Burger $5.95
6 Exit
Enter choice(1-6): 6
Student / staff ? staff

		 Your Bill
===============================================

                Item   Quantity  Price per item
        Bacon Cheese          4            5.75
     Don Cali Burger          3            5.95
  Total (before tax) : $40.85     
                 Tax : $3.68      
    Total(after tax) : $44.53  
    
    
    
    */
