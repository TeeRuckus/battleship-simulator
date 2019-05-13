/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE:
PURPOSE: to create a class which will model the functionality of a real life
         fighter jet
*******************************************************************************/
public class Engine
    {
        //public constants
        public static final String BATRY = "BATTERY";
        public static final String DSL = "DIESEL";
        public static final String BIO = "BIO";

        //private class fields
        private int cylinders;
        private String fuel;

        /***********************************************************************
        DEFUALT Constructor
        IMPORT: none
        EXPORT: none
        ASSERTION: a fighter jet with a serial number of 123.250, commissioned
                   in 1950, with an engine fuel of titanium with a maximum
                   depth of 500.0 is a valid defualt state
        ***********************************************************************/
        public Engine()
        {
            fuel = DSL;
            cylinders = 6;
        }
        /***********************************************************************
        ALTERNATE Constructor
        IMPORT: inCylinders (Real), inYear (Interger), inFuel (String),
                inWingSpan (Real)
        EXPORT: none
        ASSERTION: creates an object if the imports are valid, otherwise it will
                   FAIL
        ***********************************************************************/
        public Engine(int inCylinders, String inFuel)
        {
            if(validateCylinders(inCylinders))
            {
                if(validateFuel(inFuel))
                {
                    cylinders = inCylinders;
                    fuel = inFuel;

                }
            }

            else
            {
                throw new IllegalArgumentException("\nInvalid object import" +
                                                   "values\n");
            }
        }
        /***********************************************************************
        COPY Constructor
        IMPORT: inEngine (Engine)
        EXPORT: none
        ASSERTION: creates an objext which is identical to the importred object
        ***********************************************************************/
        public Engine(Engine inEngine)
        {
            cylinders = inEngine.getCylinders();
            fuel = inEngine.getFuel();
        }

        //ACCESSORS

        public int getCylinders()
        {
            return cylinders;
        }
        public String getFuel()
        {
            return fuel;
        }

        //MUTATORS

        /***********************************************************************
        SUBMODULE: setCylinders
        IMPORT: inCylinders (Real)
        EXPORT: none
        ASSERTION: sets the serial number to inCylinders if it's valid,
                   otherwise it fails
        ***********************************************************************/
        public void setCylinders(int inCylinders)
        {
           if(validateCylinders(inCylinders))
            {
                cylinders = inCylinders;
            }
            else
            {
                throw new IllegalArgumentException("Invalid serial number");
            }
        }
        /***********************************************************************
        SUBMODULE: setFuel
        IMPORT: inFuel (String)
        EXPORT: none
        ASSERTION: set fuel to to inFuel if it's valid, otherwise it will fail
        ***********************************************************************/
        public void setFuel(String inFuel)
        {
            if(validateFuel(inFuel))
                fuel = inFuel;
            else
            {
                throw new IllegalArgumentException("Invalid fuel");
            }
        }
       /* SUBMODULE: calcTravel (*** I cannot impliment this yet, as my knowledge on
                            how to is limited ***) */

        //PRIVATE SUBMODULES:

        /***********************************************************************
        SUBMODULE: validateCylinders
        IMPORT: inCylinders (Real)
        EXPORT: isValid (Boolean)
        ASSERTION: validates serial numbers as true whereby its first three
                   digits are between 100 to 200 (inclusive), and the last three
                   digits are between 001 - 999 (inclusive), otherwise it will
                   validate them as false.
        ***********************************************************************/
        private boolean validateCylinders(int inCylinders)
        {
            boolean isValid = false;

            if(inCylinders >= 2 && inCylinders <= 20)
            {
                isValid = true;
            }
            return isValid;
        }
        /**********************************************************************
        SUBMODULE: validateFuel
        IMPORT: inFuel (String)
        EXPORT: isValid (boolean)
        ASSERTION: it will only validate inFuel if it has a string describing
                   the fuel of the fighter jet
        ********************************************************************/
        private boolean validateFuel(String inFuel)
        {
            boolean isValid = false;
            if (inFuel.equals(BATRY) || inFuel.equals(DSL) || inFuel.equals(BIO))
            {
                isValid = true;
            }

            return isValid;
        }

        //OTHER METHODS

        /********************************************************************
        SUBMODULE: clone
        IMPORT: none
        EXPORT: cloneEngine (Object)
        ASSERTION: returns a cloned object of the current object
        ********************************************************************/
        public Engine clone()
        {
            Engine cloneEngine;

            cloneEngine = new Engine(this.cylinders, this.fuel);

            return cloneEngine;
        }
        /********************************************************************
        SUBMODULE: equals
        IMPORT: inObjct (object)
        EXPORT: isSame (boolean)
        ASSERTION: two engines  are interchangable if they have the same fuel
                   and cylinders
        ********************************************************************/
        public boolean equals(Object inObjct)
        {
            boolean isSame = false;
            if(inObjct instanceof Engine)
            {
                Engine inEngine = (Engine)inObjct;
                isSame = fuel.equals(inEngine.getFuel()) &&
                          cylinders == (inEngine.getCylinders());
            }

            return isSame;
        }
        /********************************************************************
        SUBMODULE: toString
        IMPORT: none
        EXPORT: str (String)
        ASSERTION:
        ********************************************************************/
        public String toString()
        {

            return("The engine has " +cylinders+ " cylinders, and it runs on "
                  +fuel+ " fuel.");
        }
        /********************************************************************
        SUBMODULE: toFileString
        IMPORT: none
        EXPORT: str (String)
        ASSERTION:
        ********************************************************************/
        public String toFileString()
        {
            return("E, " +cylinders+ " ," +fuel+ ".");
        }
    }
