/*
 * CIS 22C - Data Structures 
 * 
 * May 27, 2020
 * 
 * Author: @Natalie Stepankevycova
 * 
 * 
 * Hydra is a program that uses bag ADT: 
 * 		prompts user to enter a number of Hydra's (Greek mythical creature) heads
 * 		simulates chopping off Hydra's heads
 * 		in every round only one head can be chopped
 * 		if a head is chopped, it will be replaced with two heads with smaller number 
 * 		the program outputs the number of chops necessary to cut off all the heads
 * 		or outputs that the program ended early with bag overflow if the workBag is too full
 *  */

import java.util.*;

public class Hydra {
    public static void main(String args[]) {
    	
// Create a new ArrayBag<Integer> and assign it to headBag.
        ArrayBag<Integer> headBag = null;
        
        ArrayBag<String> workBag = null;
 
        
        int size;
        
        System.out.println("Please enter initial size of heads:");
        
        size = getInt("(It should be an integer value greater than or equal to 1)");

        
        // initializing two bags 
        headBag= new ArrayBag<Integer>();
        
        // take input from user
        headBag.add(size);
        
        workBag= new ArrayBag<String>(); 

        
        
        System.out.println("The head bag is Bag " + headBag);
        
        boolean notOverflow = true;
        
        //run simulationStep if there is no overflow 
        while(headBag.getCurrentSize()!=0 && notOverflow == true){
        	
            notOverflow= simulationStep(headBag, workBag);
            
        // print out how many heads are left    
            System.out.println("The head bag is " + headBag); 
        }
      
        if (notOverflow == true) {
            System.out.println("The number of chops required is " + workBag.getCurrentSize());
        }
        // end early if there is overflow
        else {
            System.out.println("Computation ended early with a bag overflow");
        }
    }
    /**
     * This method takes a head from the Bag and chops it.
     * If the head was the only one, the simulation will be done.
     * If the head wasn't the only one, the simulation will take the last head and chop it 
     * into two smaller and put them in workBag
     *
     * @param a bag with heads
     * @param a bag with chops
     *
     * @return boolean if the chop ended with overflow
     */
    public static boolean simulationStep(BagInterface<Integer> heads, BagInterface<String> work) {

    	//flag if overflow
        boolean notOverflow = true;  
       
        int remove= heads.remove();
        
        if(remove!=1){
        
        	remove= remove-1;
            
        	// add two ints that have lesser value than removed head
        	
        	heads.add(remove);
            
        	heads.add(remove);
            
        	notOverflow= true;
        }
        
        notOverflow= work.add("chopp");
        
        return notOverflow;
    }

    /**
     * Get an integer value.
     *
     * @return     An integer.
     */
    private static int getInt(String prompt) {
    	
        Scanner input;
        
        int result = 10; // default if there's no input
        
        
        try {
            
        	input = new Scanner(System.in);
            
            System.out.println(prompt);
        
            result = input.nextInt(); //take input
            
            //in case user enters something else than int
        } catch (NumberFormatException e) {
            System.out.println("Could not convert to int");
            System.out.println(e.getMessage());
            System.out.println("Value has been set to default (10)");
            
            //other error exception
        } catch (Exception e) {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage()); 
            System.out.println("Value has been set to default (10)");
        }
        return result;
    }
}



/*=================SAMPLE OUTPUT=======================
 * Please enter initial size of heads:
(It should be an integer value greater than or equal to 1)
3
The head bag is Bag Bag[ 3 ]
The head bag is Bag[ 2 2 ]
The head bag is Bag[ 2 1 1 ]
The head bag is Bag[ 2 1 ]
The head bag is Bag[ 2 ]
The head bag is Bag[ 1 1 ]
The head bag is Bag[ 1 ]
The head bag is Bag[ ]
The number of chops required is 7
*/




