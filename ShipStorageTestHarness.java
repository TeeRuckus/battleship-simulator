public class ShipStorageTestHarness 
{
    public static void main(String [] args)
    {
        try
        {
            ShipStorage shipStorage;
            //creating objects for testing
            SubMarine [] subs = new SubMarine[4];
            FighterJet [] jets = new FighterJet[4];
            shipStorage = new ShipStorage();

            subs[0] = new SubMarine();
            subs[1] = new SubMarine("200.500", 1969, new Engine(4,"BIO"),
                                    SubMarine.TTNM, -200.0);
            subs[2] = subs[0].clone();
            subs[3] = new SubMarine(subs[1]);

            jets[0] = new FighterJet();
            jets[1] = jets[0].clone();
            jets[2] = new FighterJet("199.666", 1969, "ninjas", 4.0, new Engine());
            jets[3] = new FighterJet(jets[2]);

            //ADD SHIPS TESTING
            for(int ii = 0; ii < 4; ii++)
            {
                shipStorage.addShip(subs[ii]);
                shipStorage.addShip(jets[ii]);
            }
            /*for(int ii = 0; ii < 4; ii++)
            {
                shipStorage.addShip(jets[ii]);
            }*/

            System.out.println("\n GET LAST SHIP STORED TEST \n");

            System.out.println("\nlast ship stored: \n\n" 
                                +jets[3].toString()+"\n");
            System.out.println("\nget last ship method: \n"+
                               "\n"+shipStorage.getShip().toString()+"\n");

            System.out.println("\nFIND DUPLICATES TEST\n");

            /* the duplicates method returns an array of ships, hence I am
            instantiating an array which can store the duplicates returned by
            the duplicates method */
            Ship[] shipDuplicates = new Ship[ShipStorage.MAX_CAP * 2];
            shipDuplicates = shipStorage.findDuplicateShips();

            System.out.println("\nShip duplicates:\n"); 
            for(int ii = 0; ii < 3; ii++)
            {
                System.out.println("Ship["+ii+"]\n"+
                                    shipDuplicates[ii].toString()+"\n");//+ 
                                    //"\nduplicate Ship[" +ii+ "]\n"
                                    //+shipDuplicates[ii+1].toString()+"\n");
            }
            System.out.println("\n THERE'S MEANT TO BE FOUR DUPLICATES \n");

            //testing destination check
            String str;
            System.out.println("\n DESTINATION CHECKER \n");
            System.out.println("expecteded fastest ship:\n "
                                +jets[3].toString()+"\n");
            str = shipStorage.destinationCheck(20000);
            System.out.println("\nfastest ship:\n"+str+"\n");

            //TEST THE PRIVATE METHODS
        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }
    } 
}
