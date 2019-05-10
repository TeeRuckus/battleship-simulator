public class engineClassTestHarness
{
    public static void main(String [] args)
    {
        try
        {
            engineClass [] engine = new engineClass[4];

            // creating objects for testing
            engine[0] = new engineClass();
            engine[1] = new engineClass(4, engineClass.BIO);                                    
            engine[2] = new engineClass(engine[1]);
            engine[3] = engine[1].clone();

            //printing out created objects
            System.out.println("\n CONSTRUCTOR TESTS: \n");
            for(int ii = 0; ii < engine.length; ii++)
            {
                System.out.println("\nengine [" +ii+ "]: \n"
                                   +engine[1].toString());
            }

            //equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + engine[1].equals(engine[3]));
            System.out.println("Equals (object) expected FALSE: " + engine[0].equals(engine[3]));

            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");
            engine[0].setCylinders(engine[1].getCylinders());
            System.out.println(engine[0].getCylinders() + " = " + engine[1].getCylinders());

            engine[0].setFuel(engine[1].getFuel());
            System.out.println(engine[0].getFuel() + " = " + engine[1].getFuel());

        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }

    }
}
