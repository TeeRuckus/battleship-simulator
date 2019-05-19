public class EngineTestHarness
{
    public static void main(String [] args)
    {
        /*please refer to TestDesign.ods to get break down of the test cases 
          and the test designs */ 
        try
        {
            Engine [] engine = new Engine[4];

            // creating objects for testing
            engine[0] = new Engine();
            engine[1] = new Engine(20, Engine.BIO);                                    
            engine[2] = new Engine(engine[1]);
            engine[3] = engine[1].clone();

            //printing out created objects
            System.out.println("\n CONSTRUCTOR TESTS: \n");
            for(int ii = 0; ii < engine.length; ii++)
            {
                System.out.println("\nengine [" +ii+ "]: \n"
                                   +engine[ii].toString());
            }

            //equals method
            System.out.println("\nEQUALS METHOD TESTS:\n");
            System.out.println("Equals (object) expected TRUE: " 
                                + engine[1].equals(engine[3]));
            System.out.println("Equals (object) expected FALSE: " 
                                + engine[0].equals(engine[3]));

            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:\n");
            engine[0].setCylinders(engine[1].getCylinders());
            System.out.println(engine[0].getCylinders() + " = " 
                               + engine[1].getCylinders());

            engine[0].setFuel(engine[1].getFuel());
            System.out.println(engine[0].getFuel() + " = " 
                                         + engine[1].getFuel());

        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }

    }
}
