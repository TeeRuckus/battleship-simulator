public class fighterJetTestHarness
{
    public static void main(String [] args)
    {
        try
        {
            fighterJetClass [] fighterJet = new fighterJetClass[4];

            // creating objects for testing
            fighterJet[0] = new fighterJetClass();
            fighterJet[1] = new fighterJetClass(199.666, 1969,
                                                "turrents", 3);
            fighterJet[2] = new fighterJetClass(fighterJet[1]);
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
            System.out.println("Equals (object) expected TRUE: " + fighterJet[1].equals(fighterJet[3]));
            System.out.println("Equals (object) expected FALSE: " + fighterJet[0].equals(fighterJet[3]));

            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");
            fighterJet[0].setSerialNum(fighterJet[1].getSerialNum());
            System.out.println(fighterJet[0].getSerialNum() + " = " + fighterJet[1].getSerialNum());

            fighterJet[0].setYear(fighterJet[2].getYear());
            System.out.println(fighterJet[0].getYear() + " = " + fighterJet[2].getYear());

            fighterJet[0].setOrdance(fighterJet[1].getOrdance());
            System.out.println(fighterJet[0].getOrdance() + " = " + fighterJet[1].getOrdance());

            fighterJet[0].setWingSpan(fighterJet[1].getWingSpan());
            System.out.println(fighterJet[0].getWingSpan() + " = " + fighterJet[1].getWingSpan());

        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }

    }
}
