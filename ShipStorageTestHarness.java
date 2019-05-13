public class ShipStorageTestHarness 
{
    public static void main(String [] args)
    {
        try
        {
            ShipStorage shipStorage;
            SubMarine [] subs = new SubMarine[4];
            FighterJet [] jets = new FighterJet[4];
            
            //creating objects for testing
            shipStorage = new ShipStorage();
            subs[0] = new SubMarine(101.301, 2000, SubMarine.STEEL, -300);
            subs[1] = new SubMarine(200.500, 1969, SubMarine.TTNM, -250);
            subs[2] = subs[0].clone();
            subs[3] = new SubMarine(200.600, 1955, SubMarine.ALLY, -1);

            jets[0] = new FighterJet(101.302, 2000, "teddy bears", 20);
            jets[1] = jets[0].clone();
            jets[2] = new FighterJet(199.666, 1969, "ninjas", 4);
            jets[3] = new FighterJet(100.300, 1955, "OOPD is insane", 5);

            //ADD SHIPS TESTING
            for(int ii = 0; ii < 4; ii++)
            {
                shipStorage.addShipSub(subs[ii]);
            }
            for(int ii = 0; ii < 4; ii++)
            {
                shipStorage.addShipJet(jets[ii]);
            }

            System.out.println("\n GET LAST SHIP STORED TEST \n");

            System.out.println("\nlast sub stored: \n\n" 
                                +subs[3].toString()+"\n");
            System.out.println("\nget sub method: \n"+
                               "\n"+shipStorage.getSub().toString()+"\n");
            System.out.println("\nlast jet stored: \n\n" 
                                +jets[3].toString()+"\n");
            System.out.println("\nget jet method: \n"+
                               "\n" +shipStorage.getLastJet().toString()+"\n");

            System.out.println("\n FIND DUPLICATES TEST \n");

            
            
            
        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }
    } 
}
