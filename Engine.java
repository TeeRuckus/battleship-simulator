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
        ASSERTION: an engine is valid with a fuel of diesel and  6 cylinders
        ***********************************************************************/
        public Engine()
        {
            cylinders = 6;
            fuel = DSL;
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

        }
        /***********************************************************************
        COPY Constructor
        IMPORT: inEngine (Engine)
        EXPORT: none
        ASSERTION: creates an object which is identical to the importred object
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
        ASSERTION: sets the cylinders to inCylinders of it's valid, otherwise
                   it fails
        ***********************************************************************/
        public void setCylinders(int inCylinders)
        {
           if(validateCylinders(inCylinders))
            {
                cylinders = inCylinders;
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
            {
                fuel = inFuel;
            }
        }

        //PRIVATE SUBMODULES:

        /***********************************************************************
        SUBMODULE: validateCylinders
        IMPORT: inCylinders (Real)
        EXPORT: isValid (Boolean)
        ASSERTION: validates cylinders which are between 2 and 20 (inclusive)
        ***********************************************************************/
        private boolean validateCylinders(int inCylinders)
        {
            boolean isValid = false;

            if(inCylinders >= 2 && inCylinders <= 20)
            {
                isValid = true;
            }
            else
            {
                throw new IllegalArgumentException("\nInvalid cylinders\n");
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
            String upperCaseInFuel;
            boolean isValid = false;

            /* converting inFuel to be upper case, to allow any casing for fuel
               to be passed to this method as specified in the specification*/

            upperCaseInFuel = inFuel.toUpperCase();
            if(upperCaseInFuel.equals(BATRY) || upperCaseInFuel.equals(DSL) 
               || upperCaseInFuel.equals(BIO))
            {
                isValid = true;
            }
            else
            {
                throw new IllegalArgumentException("\nInvalid fuel\n");
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
            /*
            Engine cloneEngine;

            cloneEngine = new Engine(this.cylinders, this.fuel);*/

            return new Engine(this);
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

            return(" The engine has " +cylinders+ " cylinders, and it runs on "
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
            return(cylinders+ " ," +fuel+ ".");
        }
    }
