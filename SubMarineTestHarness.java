public class SubMarineTestHarness
{
    public static final double TOL = 0.001;

    /*copied class constants from SubMarine.java so we can test the private 
    submodules appropriately */

    public static final String STEEL = "STEEL";
    public static final String ALLY = "ALLOY";
    public static final String TTNM = "TITANIUM";

    public static void main(String [] args)
    {
        //we only care up to decimal places
        try
        {
            SubMarine [] subMarine = new SubMarine[4];
            Engine engine = new Engine(12, "bio"); 

            // creating objects for testing
            subMarine[0] = new SubMarine();
            subMarine[1] = new SubMarine("199.666", 1969, engine, 
                                        SubMarine.TTNM, -200.0);
            subMarine[2] = new SubMarine(subMarine[1]);
            subMarine[3] = subMarine[1].clone();

            //printing out created objects
            System.out.println("\n CONSTRUCTOR TESTS: \n");
            for(int ii = 0; ii < subMarine.length; ii++)
            {
                System.out.println("\nsubMarine [" +ii+ "]: \n"
                                   +subMarine[ii].toString());
            }
            // testing toFileString method
            System.out.println("\ntesting the toFile method\n\nExpecteded to "+
                               "file string:\nS, <serialNumber>, <commission "+
                               "year, <cylinders>, <fuel>, <hull>, "+
                               "<max depth>");
            for(int ii = 0; ii < subMarine.length; ii++)
            {
                System.out.println("\nSubMarine [" +ii+ "]: \n" 
                                    +subMarine[ii].toFileString());
            }

            //equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " 
                               + subMarine[1].equals(subMarine[3]));
            System.out.println("Equals (object) expected FALSE: " 
                               + subMarine[0].equals(subMarine[3]));

            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");
            subMarine[0].setSerialNum(subMarine[1].getSerialNum());
            System.out.println(subMarine[0].getSerialNum() + " = " 
                               + subMarine[1].getSerialNum());

            subMarine[0].setYear(subMarine[2].getYear());
            System.out.println(subMarine[0].getYear() + " = " 
                               + subMarine[2].getYear());

            subMarine[0].setHull(subMarine[1].getHull());
            System.out.println(subMarine[0].getHull() 
                               + " = " + subMarine[1].getHull());

            subMarine[0].setMaxDepth(subMarine[1].getMaxDepth());
            System.out.println(subMarine[0].getMaxDepth() 
                               + " = " + subMarine[1].getMaxDepth());

             //testing calc Travel 
            double actual, expected;
            System.out.println("\ncalcTravelTime\n");

            subMarine[0] = new SubMarine("199.666", 1969, 
                               new Engine(12, "bio"), SubMarine.TTNM, -300.0);
            
            actual = subMarine[0].calcTravelTime(20000);
            assert Math.abs(5.376 - actual) < TOL;
            System.out.println("test 7 passed[x]");
            

            try
            {
                actual = subMarine[0].calcTravelTime(-100);
                System.out.println("test 8 failed[]");
            }
            catch(IllegalArgumentException err)
            {
                System.out.println("\nExpecteded exception: " +err);
                System.out.println("test 8 passed[x]");
            }
            
            System.out.println("\nCalcTravel all tests passed\n");

        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }

        //testing private submodules
        SubMarineTestHarness test = new SubMarineTestHarness();
        System.out.println("\nTesting private submodules\n");

        System.out.println("\ntesting validateHull\n"); 

        assert true == test.validateHull("STeeL");
        assert true == test.validateHull("TiTaniUM");
        assert true == test.validateHull("allOY");

            assert false == test.validateHull(" ");
            System.out.println("test passed");

            assert false == test.validateHull("sakhdjl");
            System.out.println("test passed");

    }
    /*private submodules cannot be invoked from outside its class, hence
    I have copied and pasted submaries private submodules here to test them*/
    /**********************************************************************
    SUBMODULE: validateHull
    IMPORT: inHull (String)
    EXPORT: isValid (boolean)
    ASSERTION: it will only validate inHull if it's one of the following
               three; steel, alloy and titanium.
    ********************************************************************/
    private boolean validateHull(String inHull)
    {
        String upperCaseInHull;
        boolean isValid = false;

        /* converting inHull to be upper case, to allow any casing for fuel 
           to be passed to the method as reuired in the specification */

        upperCaseInHull = inHull.toUpperCase();
        if(upperCaseInHull.equals(STEEL) || upperCaseInHull.equals(ALLY) ||
           upperCaseInHull.equals(TTNM))
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid hull\n");
        }

        return isValid;
    }
    /*******************************************************************
    SUBMODULE: validateMaxDepth
    IMPORT: inMaxDepth (Real)
    EXPORT: isValid (Boolean)
    PURPOSE: To ensure the inputed max depth is between the range of -500 t0
             0 metres.
    ASSERTION: a maxdepth of between -500 - 0 will be validate otherwise, an
               error will be thrown to the user
    ********************************************************************/
    private boolean validateMaxDepth(double inMaxDepth)
    {
        boolean isValid = false;

        if(inMaxDepth >= -500 && inMaxDepth <= 0)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid max depth\n");
        }

        return isValid;
    }
}
