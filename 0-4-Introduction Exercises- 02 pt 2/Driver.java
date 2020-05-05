//@Natalie Stepankevycova
//CIS 22C - 0-4 Introduction Exercise - 02

/* This program is an implementation of exercise 01
 * The program 
 * - shows user a menu, lets user enter choice of a meal and quantity. 
 * - stores inputs and prompts user to enter if they are staff or student.
 * - calculates and displays user's bill and depending if the user is 
 * staff it will add 9% tax to the final price.
 * */



public class Driver {

          public static void main(String[] args) {
                  OrderBurger order = new OrderBurger();

                  // Order ord = new Order(); <= Cannot instantiate the type Order
                  //because Order is an abstract class                  

                  order.displayMenu();       //displays the men                   
                  order.getInputs();          //gets inputs                   
                  order.calculate();          //calculates cost                  
                  order.printBill();           //prints bill

                  order.saveBillToFile();          //saves the bill in a text file
          }

}


//===============================================
// SAMPLE OUTPUT
/*==========================================


1. De Anza Burger $5.25
2. Bacon Cheese $5.75
3. Mushroom Swiss $5.95
4. Western Burger $5.95
5. Don Cali Burger $5.95
6 Exit
==========================================

1. De Anza Burger $5.25
2. Bacon Cheese $5.75
3. Mushroom Swiss $5.95
4. Western Burger $5.95
5. Don Cali Burger $5.95
6 Exit

Enter choice(1-6): 1
Enter the quantity: 2
==========================================

1. De Anza Burger $5.25
2. Bacon Cheese $5.75
3. Mushroom Swiss $5.95
4. Western Burger $5.95
5. Don Cali Burger $5.95
6 Exit

Enter choice(1-6): 3
Enter the quantity: 4
==========================================

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
      De Anza Burger          2            5.25
      Mushroom Swiss          4            5.95
  Total (before tax) : $34.30     
                 Tax : $3.09      
    Total(after tax) : $37.39        
    
*/

