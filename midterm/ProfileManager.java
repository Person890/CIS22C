
public class ProfileManager {

    private final AList<Profile> allProfiles;

    // constructor
    public ProfileManager() {
    	
        allProfiles = new AList<>();
    }

    // add profile to the network
    public void addProfile(Profile p) {
    	
        allProfiles.add(p);
    }

    // remove profile from the network
    public void removeProfile(Profile p) {
    	
        int len = allProfiles.getLength();

        // remove profile at index 
        for (int i = 1; i <= len; i++){
        	
            Profile p2 = allProfiles.getEntry(i);
            
            if(p2.getName().equals(p.getName())) {
            	
                allProfiles.remove(i);
                
                return;
            }
        }
    }

    // create friendship between two profiles 
    public void createFriendship(Profile a, Profile b) {
    	
        a.addFriend(b);
        
        b.addFriend(a);
    }

    // end friendship between TWO profiles
    public void endFriendship(Profile a, Profile b) {
    	
        a.removeFriend(b);
        
        b.removeFriend(a);
    }

    //display info about profiles
    public void display() {
    	
        int len = allProfiles.getLength();
        
        String str = "";
        
        for (int i = 1; i <= len; i++) {
        	
            Profile p = allProfiles.getEntry(i);
            
            str += p.toString();
        }
        System.out.println(str);
    }
}