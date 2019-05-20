public class FighterJetTestHarness
{
    public static final double TOL = 0.0001;

    public static void main(String [] args)
    {
        try
        {
            FighterJet [] fighterJet = new FighterJet[4];

            // creating objects for testing
            fighterJet[0] = new FighterJet();
            fighterJet[1] = new FighterJet("199.666", 1969,"turrents", 
                             3, new Engine());
            fighterJet[2] = new FighterJet(fighterJet[1]);
            fighterJet[3] = fighterJet[1].clone();

            //printing out created objects
            System.out.println("\n CONSTRUCTOR TESTS: \n");
            for(int ii = 0; ii < fighterJet.length; ii++)
            {
                System.out.println("\nfighterJet [" +ii+ "]: \n"
                                   +fighterJet[1].toString());
            }

            //equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " 
                                + fighterJet[1].equals(fighterJet[3]));
            System.out.println("Equals (object) expected FALSE: " 
                                + fighterJet[0].equals(fighterJet[3]));

            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");
            fighterJet[0].setSerialNum(fighterJet[1].getSerialNum());
            System.out.println(fighterJet[0].getSerialNum() + " = " 
                                            + fighterJet[1].getSerialNum());

            fighterJet[0].setYear(fighterJet[2].getYear());
            System.out.println(fighterJet[0].getYear() + " = " 
                              + fighterJet[2].getYear());

            fighterJet[0].setOrdance(fighterJet[1].getOrdance());
            System.out.println(fighterJet[0].getOrdance() + " = " 
                              + fighterJet[1].getOrdance());

            fighterJet[0].setWingSpan(fighterJet[1].getWingSpan());
            System.out.println(fighterJet[0].getWingSpan() + " = " 
                               + fighterJet[1].getWingSpan());

            //testing the contained in fighterJet
            double actual, expected;
            System.out.println("\ncalcTravelTimeJet\n");
            fighterJet[0] = new FighterJet("199.666", 1969, "turrents", 4.0,
                                            new Engine(12, "BIO"));
            
            actual = fighterJet[0].calcTravelTime(1000);
            assert Math.abs(0.14 - actual) < TOL: "Valid case";
            

            /*int testCases = 15;
            int[] distance = new int [testCases];
            double[] wingSpan = new double [testCases];
            int[] cylinders = new int[testCases];
            boolean[] expected = new boolean[testCases];

            distance = {10, -5, 5, 1000, 3000, 9000, 8000, -2, 50, -5, -1, -4,
                        -1, 50, -50};
            wingSpan = {};
            cylinders = {};
            expected = {};
            
            //creating the
            for(int ii = 0; ii < testCases; ii++)
            {
            }*/



        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }

    }
}
