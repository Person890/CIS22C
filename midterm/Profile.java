// library for buffered image
import java.awt.image.*;

/**
 * A UserProfile for the social network.
 */
public class Profile {

    private BufferedImage profilePicture;
    
    private User profileName;
    
    private String status;
    
    private AList<Profile> friends;

    /**
     * Constructor of UserProfile.
     */
    public Profile() {

        profilePicture = new BufferedImage

        		(150, 150, BufferedImage.TYPE_INT_RGB);
       
        profileName = new User("", "");
        
        status = "";
        
        friends = new AList<>();
    }

    public BufferedImage getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(BufferedImage newPicture) {
        profilePicture = newPicture;
    }

    public User getName() {
        return profileName;
    }

    // set first and last name to the user
    public void setName(String first, String last) {
    	
        profileName.setName(first, last);
    }

    // sets user to the UserProfile
    public void setName(User User) {
        profileName = User;
    }

    
    //Sets the current status of the UserProfile
    public void setStatus(String stat) {
    	
        status = stat;
    }


    //get the status associated with the UserProfile.
    public String getStatus() {
    	
        return status;
    }

    //gets the list of all friends of UserProfile
    public AList<Profile> getFriends() {
    
        return friends;
    }


    //Adds a friend to the UserProfile's list of friends
    public void addFriend(Profile p) {
    	
        friends.add(p);
    }


    //Removes a friend from the UserProfile's list of friends.
    public void removeFriend(Profile p) {
    	
        int len = friends.getLength();

        // search through the list and remove at friend at index 
        for (int i = 1; i <= len; i++) {
        	
            Profile p2 = friends.getEntry(i);
            
            if (p2.getName().equals(p.getName())) {
            	
                friends.remove(i);
                
                return;
            }
        }
    }

    public String toString() {
    	
        String out = "";
        
        out += "User: " + profileName.toString() + "\n";
        
        out += "\t Status: " + status + "\n";
        
        out += "\t Picture: " + profilePicture.toString() + "\n";
        
        out += "\t # of friends: " + friends.getLength() + "\n";

        int len = friends.getLength();
        
        out += "Friends:" + "\n";
        
        for (int i = 1; i <= len; i++) {
        
        	out += friends.getEntry(i).getName() + "\n";
        	
        }
       
        return out;
    }

}