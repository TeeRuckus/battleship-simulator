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
            subs[2] = new SubMarine();
            subs[3] = new SubMarine(200.600, 1955, SubMarine.ALLY, -1);

            jets[0] = new FighterJet();
            jets[1] = new FighterJet(101.302, 2000, "teddy bears", 20);
            jets[2] = new FighterJet(199.666, 1969, "ninjas", 4);
            jets[3] = new FighterJet(100.300, 1955, "OOPD is insane", 5);

            System.out.println("\n ADD SHIPS TEST \n");
            System.out.println("\n SUBMARINE OBJECTS \n");
            for(int = 0; ii < 4; ii++)
            {
                shipStorage.addShipSub(subs[ii]);
            }
            System.out.println("\n FIGHTERJET OBJECTS \n");
            for(int = 0; ii < 4; ii++)
            {
                shipStorage.addShipJet(jets[ii]);
            }
        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }
    } 
}
