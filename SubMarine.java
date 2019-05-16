/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE:
PURPOSE: to create a class which will model the functionality of a real life
         submarine
*******************************************************************************/
public class SubMarine
    {
        //Class constants
        public static final String STEEL = "STEEL";
        public static final String ALLY = "ALLOY";
        public static final String TTNM = "TITANIUM";

        //private class fields
        private double serialNum, maxDepth;
        private int year;
        private String hull;
        private Engine engine;

        /***********************************************************************
        DEFUALT Constructor
        IMPORT: none
        EXPORT: none
        ASSERTION: a submarine with a serial number of 123.456, commissioned in
                   1950, with an engine hull of titanium with a maximum depth of
                  500.0 is a valid defualt state
        ***********************************************************************/
        public SubMarine()
        {
            serialNum = 123.250;
            year = 1950;
            hull = TTNM;
            maxDepth = -500.0;
            engine = new Engine();
        }
        /***********************************************************************
        ALTERNATE Constructor
        IMPORT: inSerialNum (Real), inYear (Interger), inHull (String),
                inMaxDepth (Real)
        EXPORT: none
        ASSERTION: creates an object if the imports are valid, otherwise it will
                   FAIL
        ***********************************************************************/
        public SubMarine(double inSerialNum, int inYear, String inHull,
                     double inMaxDepth, Engine inEngine)
        {
            if(validateSerialNum(inSerialNum))
            {
                if(validateYear(inYear))
                {
                    if(validateHull(inHull))
                    {
                        if(validateMaxDepth(inMaxDepth))
                        {
                            serialNum = inSerialNum;
                            year = inYear;
                            hull = inHull;
                            maxDepth = inMaxDepth;
                            engine = inEngine;
                        }
                    }
                }
            }
            else
            {
                //get rid of this and make the validate modules care for this
                throw new IllegalArgumentException("\nInvalid object import" +
                                                   "values\n");
            }
        }
        /***********************************************************************
        COPY Constructor
        IMPORT: inSubmarine (SubMarineClass)
        EXPORT: none
        ASSERTION: creates an objext which is identical to the importred onkect
        ***********************************************************************/
        public SubMarine(SubMarine inSubMarine, Engine inEngine)
        {
            serialNum = inSubMarine.getSerialNum();
            year = inSubMarine.getYear();
            hull = inSubMarine.getHull();
            maxDepth = inSubMarine.getMaxDepth();
            engine = getEngine();
        }

        //ACCESSORS

        public double getSerialNum()
        {
            return serialNum;
        }

        public int getYear()
        {
            return year;
        }

        public String getHull()
        {
            return hull;
        }

        public double getMaxDepth()
        {
            return maxDepth;
        }
        public Engine getEngine()
        {
            return new Engine(engine);
        }
        

        //MUTATORS

        /***********************************************************************
        SUBMODULE: setSerialNum
        IMPORT: inSerialNum (Real)
        EXPORT: none
        ASSERTION: sets the serial number to inSerialNum if it's valid,
                   otherwise it fails
        ***********************************************************************/
        public void setSerialNum(double inSerialNum)
        {
           if(validateSerialNum(inSerialNum))
            {
                serialNum = inSerialNum;
            }
            else
            {
                throw new IllegalArgumentException("\nInvalid serial number\n");
            }
        }
        /***********************************************************************
        SUBMODULE: setYear
        IMPORT: inYear (Interger)
        EXPORT: none
        ASSERTION: set year to inYear if it'  valid, otherwise it will fail
        ***********************************************************************/
        public void setYear(int inYear)
        {
            if(validateYear(inYear))
            {
                year = inYear;
            }
            else
            {
                throw new IllegalArgumentException("Invalid year");
            }
        }
        /***********************************************************************
        SUBMODULE: setHull
        IMPORT: inHull (String)
        EXPORT: none
        ASSERTION: set hull to to inHull if it's valid, otherwise it will fail
        ***********************************************************************/
        public void setHull(String inHull)
        {
            if(validateHull(inHull))
                hull = inHull;
            else
            {
                throw new IllegalArgumentException("Invalid hull");
            }
        }
        /***********************************************************************
        SUBMODULE: setMaxDepth
        IMPORT: inMaxDepth (Real)
        EXPORT: none
        ASSERTION: set max depth to inMaxDepth if it's valid, otherwise fail
        ***********************************************************************/
        public void setMaxDepth(double inMaxDepth)
        {
            if(validateMaxDepth(inMaxDepth))
            {
                maxDepth =  inMaxDepth;
            }
            else
            {
                throw new IllegalArgumentException("Invalid max depth," +
                                                    "input a depth between the"+
                                                    " ranges of -500.0 to 0");
            }
        }
        /***********************************************************************
        SUBMODULE: setEngine
        IMPORT: inEngine (Engine object)
        EXPORT: none
        ASSERTION: set engine to inEngine if it's valid, otherwise fail
        ***********************************************************************/
        public void  setEngine(Engine inEngine) 
        {
            if(!(inEngine instanceof Engine))
            {
                throw new IllegalArgumentException("ERROR: not a valid "+
                                                   "engine");
            }
            else
            {
                engine = inEngine;
            }
            
        }

        //DOING METHODS:

       /* SUBMODULE: calcTravel (*** I cannot impliment this yet, as my knowledge on
                            how to is limited ***) */

        //PRIVATE SUBMODULES:

        /***********************************************************************
        SUBMODULE: validateSerialNum
        IMPORT: inSerialNum (Real)
        EXPORT: isValid (Boolean)
        ASSERTION: validates serial numbers as true whereby its first three
                   digits are between 100 to 300 (inclusive), and the last three
                   digits are between 001 - 999 (inclusive), otherwise it will
                   validate them as false.
        ***********************************************************************/
        /*private boolean validateSerialNum(double inSerialNum)
        {
            int wholePart, decimalPart;
            boolean isValid = false;

            wholePart = (int)inSerialNum;
            decimalPart = (int)(inSerialNum * 1000) % 1000;
            if ((wholePart >= 100) && (wholePart <= 300))
            {
                if((1 <= decimalPart) && (decimalPart <= 999))
                {
                    isValid = true;
                }
            }
            return isValid;

        }*/
        private boolean validateSerialNum(String inSerialNum)
        {
            
        }
        /***********************************************************************
        SUBMODULE: validateYear
        IMPORT: inYear (intergers)
        EXPORT: isValid (Boolean)
        ASSERTION: A commission year between 1950 to 2022 (interger) will be
                       valid, otherwise an error will be thrown to the user
        **********************************************************************/
        private boolean validateYear(int inYear)
        {
            boolean isValid = false;

            if (inYear >= 1950 && inYear <= 2022)
            {
                isValid = true;
            }

            return isValid;
        }
        /**********************************************************************
        SUBMODULE: validateHull
        IMPORT: inHull (String)
        EXPORT: isValid (boolean)
        ASSERTION: it will only validate inHull if it's one of the following
                   three; steel, alloym and titanium.
        ********************************************************************/
        private boolean validateHull(String inHull)
        {
            boolean isValid = false;

            if(inHull.equals(STEEL) || inHull.equals(ALLY) ||
               inHull.equals(TTNM))
            {
                isValid = true;
            }

            return isValid;
        }
        /*******************************************************************
        SUBMODULE: validateMaxDepth
        IMPORT: inMaxDepth (Real)
        EXPORT: isValid (Boolean)
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

            return isValid;
        }

        //OTHER METHODS

        /********************************************************************
        SUBMODULE: clone
        IMPORT: none
        EXPORT: cloneSubmarine (Object)
        ASSERTION: returns a cloned object of the current object
        ********************************************************************/
        public SubMarine clone()
        {
            SubMarine cloneSubMarine;

            cloneSubMarine = new SubMarine(this.serialNum, this.year,
                                        this.hull, this.maxDepth, this.engine);
            return cloneSubMarine;
        }
        /********************************************************************
        SUBMODULE: equals
        IMPORT: inObjct (object)
        EXPORT: isSame (boolean)
        ASSERTION: two submarines are interchangable if they have the same hull,
                   and max depth
        ********************************************************************/
        public boolean equals(Object inObjct, Engine inEngine)
        {
            boolean isSame = false;
            if(inObjct instanceof SubMarine)
            {
                SubMarine inSubmarine = (SubMarine)inObjct;
                isSame = hull.equals(inSubmarine.getHull()) &&
                          maxDepth == (inSubmarine.getMaxDepth()) &&
                          engine.equals(getEngine()); 
            }

            return isSame;
        }
        /********************************************************************
        SUBMODULE: toString
        IMPORT: none
        EXPORT: str
        ASSERTION:
        ********************************************************************/
        public String toString()
        {
            int cylinders = engine.getCylinders();
            String fuel = engine.getFuel();
            return("The ship " +serialNum+ " was comissioned in " +year+
                   " , its engine has " +cylinders+ " cylinders and runs on "
                    +fuel+ ". It is a submarine with a " +hull+ " hull and a" +
                    " max depth of " +maxDepth+ ".");
        }
        /********************************************************************
        SUBMODULE: toFileString
        IMPORT: none
        EXPORT: str
        ASSERTION:
        ********************************************************************/
        public String toFileString()
        {
            int cylinders = engine.getCylinders();
            String fuel = engine.getFuel(); 
            return("S," +serialNum+ "," +year+ "," +cylinders+ "," +fuel+ ","
                  +hull+"," +maxDepth);
            /* make this method just return the engine toString method,
               so it's a little bit easier to do everything */
        }
    }
