public class FighterJetTestHarness
{
    //we only care up to two decimal places
    public static final double TOL = 0.001;

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
                                   +fighterJet[ii].toString());
            }
            // testing toFileString method
            System.out.println("\ntesting the toFile method\n\nExpecteded to "+
                               "file string:\nF, <serialNumber>, <commission "+
                               "year, <cylinders>, <fuel>, <wingspan>, "+
                               "<ordance>");
            for(int ii = 0; ii < fighterJet.length; ii++)
            {
                System.out.println("\nFighterJet [" +ii+ "]: \n" 
                                    +fighterJet[ii].toFileString());
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
            //testing private submodules
            FighterJetTestHarness test = new FighterJetTestHarness();
            System.out.println("\nTesting private submodules\n");
            
            System.out.println("\nTesting validate ordance\n");
            //I am expecting an exception to be thrown here
            try
            {
                assert false == test.validateOrdance(""): "empty String";
            }
            catch(IllegalArgumentException err)
            {
                System.out.println("Expecteded error: " +err);
            }
            System.out.println("test 1 passed[x]");

            assert true == test.validateOrdance("machine guns"): "non-empty "+
                                                                  "String";
            System.out.println("test 2 passed[x]"); 
            System.out.println("\nvalidate ordance all tests passed\n");
            
            //testing validate wingspan 
            System.out.println("\ntesting validate wingspan\n");
            try
            {
                assert false == test.validateWingSpan(1.0): "in wingSpan < "+
                                                             "2.20";
            }
            catch(IllegalArgumentException err)
            {
                System.out.println("Expecteded exception: " +err);
            }

            try
            {
                assert false == test.validateWingSpan(30.0): "in wingSpan > "+
                                                             "25.6";
            }
            catch(IllegalArgumentException err)
            {
                System.out.println("Expecteded exception: " +err);
            }
            System.out.println("test 3 passed[x]");

            assert true == test.validateWingSpan(2.20): "in wingspan = 2.20";
            System.out.println("test 4 passed[x]");
            assert true == test.validateWingSpan(25.6): "in wingspan = 25.6";
            System.out.println("test 5 passed[x]");
            assert true == test.validateWingSpan(14.0): "2.20 <= in wingspan "+
                                                        "<= 25.6";
            System.out.println("test 6 passed[x]");
            System.out.println("\nall validateWingSpan tests passed\n");
            
            //testing calc Travel 
            double actual, expected;
            System.out.println("\ncalcTravelTime\n");

            fighterJet[0] = new FighterJet("199.666", 1969, "turrents", 4.0,
                                            new Engine(12, "BIO"));
            
            actual = fighterJet[0].calcTravelTime(20000);
            assert Math.abs(2.778 - actual) < TOL;
            System.out.println("test 7 passed[x]");
            

            try
            {
                actual = fighterJet[0].calcTravelTime(-100);
                assert false == test.validateWingSpan(30.0);
                System.out.println("test 8 failed[]");
            }
            catch(IllegalArgumentException err)
            {
                System.out.println("\nExpecteded exception: " +err);
                System.out.println("test 8 passed[x]");
            }
            System.out.println("test 3 passed[x]");
            
            System.out.println("\nCalcTravel all tests passed\n");
        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }

    }

    /* you cannot access private submodules outside of its class. Hence, I 
    have copied and pasted them here */

    /**********************************************************************
    SUBMODULE: validateOrdance
    IMPORT: inOrdance (String)
    EXPORT: isValid (boolean)
    ASSERTION: it will only validate inOrdance if it has a string describing
               the ordance of the fighter jet
    ********************************************************************/
    private boolean validateOrdance(String inOrdance)
    {
        boolean isValid = false;
        if (inOrdance.length() != 0)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid ordance\n");
        }

        return isValid;
    }
    /*******************************************************************
    SUBMODULE: validateWingSpan
    IMPORT: inWingSpan (Real)
    EXPORT: isValid (Boolean)
    ASSERTION: a wingSpan of between 2.20 and 25.6 will be validate 
               otherwise, error will be thrown to the user
    ********************************************************************/
    private boolean validateWingSpan(double inWingSpan)
    {
        
        boolean isValid = false;
        if(inWingSpan >= 2.2 && inWingSpan <= 25.6)
        {
            isValid = true;            
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid wingspan\n");
        }

        return isValid;

    }

}
