//@Natalie Stepankevycova
//CIS 22C - 0-4 Introduction Exercise - 01

/* This program shows user a menu, lets user enter choice of a meal and quantity. 
 * The program stores inputs and prompts user to enter if they are staff or student.
 * The program calculates and displays user's bill and depending if the user is 
 * staff it will add 9% tax to the final price.
 * */


public class Driver {
   public static void main(String[] args) {
       OrderBurger order = new OrderBurger();
       // Order ord = new Order(); <= Cannot instantiate the type Order because Order is an abstract class   
       order.displayMenu(); //displays the men
       order.getInputs(); //gets inputs
       order.calculate(); //calculates cost   
       order.printBill(); //prints bill
       order.saveBillToFile(); //saves the bill in a text file
   }

}