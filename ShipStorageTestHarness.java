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
            subs[0] = new SubMarine("101.301", 2000, new Engine(),
                                    SubMarine.ALLY, -300);
            subs[1] = new SubMarine("200.500", 1969, new Engine(4,"BIO"),
                                    SubMarine.TTNM, -200);
            subs[2] = subs[0].clone();
            subs[3] = new SubMarine("200.600", 1955, new Engine(16, "DIESEL"),
                                     SubMarine.ALLY, -1);

            jets[0] = new FighterJet("101.302", 2000, "teddy bears", 20, new
                                     Engine(18,"BATTERY"));
            jets[1] = jets[0].clone();
            jets[2] = new FighterJet("199.666", 1969, "ninjas", 4, new Engine());
            jets[3] = new FighterJet("100.300", 1955, "OOPD is insane", 5, new
                                     Engine(4,"BIO"));
            SubMarine[] duplicatesSubs = new 
                                         SubMarine[shipStorage.MAX_CAP * 2];
            FighterJet[] duplicatesJets = new 
                                          FighterJet[shipStorage.MAX_CAP * 2];

            //ADD SHIPS TESTING
            for(int ii = 0; ii < 4; ii++)
            {
                shipStorage.addShip(subs[ii]);
            }
            for(int ii = 0; ii < 4; ii++)
            {
                shipStorage.addShip(jets[ii]);
            }

            System.out.println("\n GET LAST SHIP STORED TEST \n");

            System.out.println("\nlast sub stored: \n\n" 
                                +subs[3].toString()+"\n");
            System.out.println("\nget sub method: \n"+
                               "\n"+shipStorage.getShip().toString()+"\n");
            System.out.println("\nlast jet stored: \n\n" 
                                +jets[3].toString()+"\n");
            System.out.println("\nget jet method: \n"+
                               "\n" +shipStorage.getShip().toString()+"\n");

            System.out.println("\n FIND DUPLICATES TEST \n");
            
            shipStorage.findDuplicateShips();
            System.out.println("\n Submarine duplicates \n"); 
            for(int ii = 0; ii < 4; ii++)
            {
                System.out.println("Submarine["+ii+"]\n"+ 
                                    duplicatesSubs[ii].toString());
                for(int jj = 1; jj < 4; ii++)
                {
                    System.out.println("Submarine duplicate ["+(jj-1)+"]\n"+
                                        duplicatesSubs[jj].toString());
                }
            }

            System.out.println("\n FighterJet duplicates \n");
            
            

            
            
            
        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }
    } 
}
