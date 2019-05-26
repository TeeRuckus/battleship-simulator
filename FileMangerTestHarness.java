public class FileMangerTestHarness
{
    public static void main(String []args)
    {
            SubMarine [] subs = new SubMarine[4];
            FighterJet [] jets = new FighterJet[4];
            ShipStorage shipStorage = new ShipStorage();

            subs[0] = new SubMarine();
            subs[1] = new SubMarine("200.500", 1969, new Engine(4,"BIO"),
                                    SubMarine.TTNM, -200.0);
            subs[2] = subs[0].clone();
            subs[3] = new SubMarine(subs[1]);

            jets[0] = new FighterJet();
            jets[1] = jets[0].clone();
            jets[2] = new FighterJet("199.666", 1969, "ninjas", 4.0, new Engine());
            jets[3] = new FighterJet(jets[2]);

            //Adding all the ships to shipStorage
            for(int ii = 0; ii < 4; ii++)
            {
                shipStorage.addShip(subs[ii]);
                shipStorage.addShip(jets[ii]);
            }

            //writing ships to a file
            String[] storageFileInfo = new String [ShipStorage.MAX_CAP];
            storageFileInfo = shipStorage.toFileStringArr();

            for(int ii = 0; ii < 7; ii++)
            {
                FileManger.writeFile("testData.txt", storageFileInfo[ii]);
            }
            System.out.println("\nwriting to a file test passed[x]\n");

            //Reading the writing files and creating objects fro itS
            FileManger.readFile("testData.txt", shipStorage);
            System.out.println("\nreading a file test passed[x]\n");

            //appending bad data onto testData.txt.
            FileManger.writeFile("testData.txt", "I like to troll");
            System.out.println("\nappended bad data onto file\n");

            //trying to read the file again with the bad data
            FileManger.readFile("testData.txt", shipStorage); 
            System.out.println("\nreading the file with bad data, passed\n");
    }
}
