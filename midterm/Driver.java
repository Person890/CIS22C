/*
 * CIS 22C - Data Structures
 * Spring 2020
 * 
 * Team members:
 * 		@ Victor Diniz
 * 		@ Priyanshi Sharma
 * 		@ Tanisha Khemka
 * 		@ Natalie Stepankevycova
 * 
 *
 * This program is similar to Facebook. It maintains the data in ArrayList for a simple social network. 
 * This program performs following tasks:
 * 		Creates profiles for users containing name, status, profile picture and list of friends 
 * 		Adds created profiles to the network
 * 		Creates friendships between profiles in the network
 * 		Removes friendships between profiles
 * 		Changes status of profiles
 * 		Allows users to upload profile photo
 * 		Removes added profiles from the network 

*/

public class Driver {

    public static void main(String[] args) {
        System.out.println("Welcome to our little network: ");

        ProfileManager m = new ProfileManager();

        
        // create profiles
        
        Profile harry = new Profile();
        harry.setName("Harry", "Potter");
        harry.setStatus("Online");

        Profile steve = new Profile();
        steve.setName("Steve", "Jobs");
        steve.setStatus("Offline");

        Profile bill = new Profile();
        bill.setName(new User("Bill", "Gates"));
        bill.setStatus("Away");

        Profile jack = new Profile();
        jack.setName(new User("Jack", "Sparrow"));
        jack.setStatus("Pirating around");

        m.addProfile(harry);
        m.addProfile(steve);
        m.addProfile(bill);
        m.addProfile(jack);
        m.display();

        System.out.println("-------------------------------------\n");
        System.out.println("Creating friendships...\n");

        
        m.createFriendship(harry, steve);
        m.createFriendship(steve, bill);
        m.createFriendship(harry, jack);
        m.createFriendship(jack, steve);
        m.createFriendship(bill, jack);

        m.display();

        System.out.println("-------------------------------------\n");
        System.out.println("Changing statuses...n");

        harry.setStatus("At Hogwards!");
        steve.setStatus("Eating Apple");
        bill.setStatus("Reading");
        jack.setStatus("Changed name to CAPTAIN Jack Sparrow");
        jack.setName("CAPTAIN", "Sparrow");

        m.display();

        System.out.println("-------------------------------------\n");
        System.out.println("Ending a friendship.\n");

        m.endFriendship(bill, steve);
        m.display();

        System.out.println("-------------------------------------\n");
        System.out.println("Removing Steve");
        m.removeProfile(steve); 
        m.display();
    } // end main
} // end Driver

/* SAMPLE OUTPUT
 * 
Welcome to our little network: 
User: Harry Potter
	 Status: Online
	 Picture: BufferedImage@66480dd7: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 0
Friends:
User: Steve Jobs
	 Status: Offline
	 Picture: BufferedImage@2b9627bc: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 0
Friends:
User: Bill Gates
	 Status: Away
	 Picture: BufferedImage@65e2dbf3: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 0
Friends:
User: Jack Sparrow
	 Status: Pirating around
	 Picture: BufferedImage@4f970963: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 0
Friends:

-------------------------------------

Creating friendships...

User: Harry Potter
	 Status: Online
	 Picture: BufferedImage@66480dd7: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 2
Friends:
Steve Jobs
Jack Sparrow
User: Steve Jobs
	 Status: Offline
	 Picture: BufferedImage@2b9627bc: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 3
Friends:
Harry Potter
Bill Gates
Jack Sparrow
User: Bill Gates
	 Status: Away
	 Picture: BufferedImage@65e2dbf3: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 2
Friends:
Steve Jobs
Jack Sparrow
User: Jack Sparrow
	 Status: Pirating around
	 Picture: BufferedImage@4f970963: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 3
Friends:
Harry Potter
Steve Jobs
Bill Gates

-------------------------------------

Changing statuses...n
User: Harry Potter
	 Status: At Hogwards!
	 Picture: BufferedImage@66480dd7: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 2
Friends:
Steve Jobs
CAPTAIN Sparrow
User: Steve Jobs
	 Status: Eating Apple
	 Picture: BufferedImage@2b9627bc: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 3
Friends:
Harry Potter
Bill Gates
CAPTAIN Sparrow
User: Bill Gates
	 Status: Reading
	 Picture: BufferedImage@65e2dbf3: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 2
Friends:
Steve Jobs
CAPTAIN Sparrow
User: CAPTAIN Sparrow
	 Status: Changed name to CAPTAIN Jack Sparrow
	 Picture: BufferedImage@4f970963: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 3
Friends:
Harry Potter
Steve Jobs
Bill Gates

-------------------------------------

Ending a friendship.

User: Harry Potter
	 Status: At Hogwards!
	 Picture: BufferedImage@66480dd7: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 2
Friends:
Steve Jobs
CAPTAIN Sparrow
User: Steve Jobs
	 Status: Eating Apple
	 Picture: BufferedImage@2b9627bc: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 2
Friends:
Harry Potter
CAPTAIN Sparrow
User: Bill Gates
	 Status: Reading
	 Picture: BufferedImage@65e2dbf3: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 1
Friends:
CAPTAIN Sparrow
User: CAPTAIN Sparrow
	 Status: Changed name to CAPTAIN Jack Sparrow
	 Picture: BufferedImage@4f970963: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 3
Friends:
Harry Potter
Steve Jobs
Bill Gates

-------------------------------------

Removing Steve
User: Harry Potter
	 Status: At Hogwards!
	 Picture: BufferedImage@66480dd7: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 2
Friends:
Steve Jobs
CAPTAIN Sparrow
User: Bill Gates
	 Status: Reading
	 Picture: BufferedImage@65e2dbf3: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 1
Friends:
CAPTAIN Sparrow
User: CAPTAIN Sparrow
	 Status: Changed name to CAPTAIN Jack Sparrow
	 Picture: BufferedImage@4f970963: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 150 height = 150 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0
	 # of friends: 3
Friends:
Harry Potter
Steve Jobs
Bill Gates


 * 
 * */
 