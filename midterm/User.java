/**
 * A User part for the social network.
 */

public class User
{
    private String first; // first Name
    
    private String last;  // last Name

    public User(){
        first = "";
        
        last = "";
    } 

    public User(String firstName, String lastName) {
    	
        setName(firstName, lastName);
    }

    public void setName(String firstName, String lastName){
    	
        first = firstName;
        
        last = lastName;
    }

    public String getName(){
    	
        return first + " " + last;
    }
    
    public String getFirst(){
        return first;
    }
    
    public String getLast()
    {
        return last;
    }

    public void setFirst(String firstName){
        first = firstName;
    }

    public void setLast(String lastName)
    {
        last = lastName;
    }


    public void setLastNameTo(User aName)
    {
        aName.setLast(last);
    }

    public String toString() {
        return getName();
    }
}