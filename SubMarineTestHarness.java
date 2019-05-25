public class SubMarineTestHarness
{
    public static void main(String [] args)
    {
        //we only care up to decimal places
        public static final double TOL = 0.001;
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
            assert Math.abs(2.778 - actual) < TOL;
            System.out.println("test 7 passed[x]");
            

            try
            {
                actual = subMarine[0].calcTravelTime(-100);
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
}
