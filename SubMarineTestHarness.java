public class SubMarineTestHarness
{
    public static void main(String [] args)
    {
        try
        {
            SubMarine [] subMarine = new SubMarine[4];

            // creating objects for testing
            subMarine[0] = new SubMarine();
            subMarine[1] = new SubMarine("199.666", 1969,
                                    new Engine(), SubMarine.TTNM, -200.0);
            subMarine[2] = new SubMarine(subMarine[1]);
            subMarine[3] = subMarine[1].clone();

            //printing out created objects
            System.out.println("\n CONSTRUCTOR TESTS: \n");
            for(int ii = 0; ii < subMarine.length; ii++)
            {
                System.out.println("\nsubMarine [" +ii+ "]: \n"
                                   +subMarine[ii].toString());
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

        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }

    }
}
