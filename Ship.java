/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE: 27/05/19
PURPOSE: to act as the super class to the subclasses of fighterJet and SubMarine
*******************************************************************************/
public abstract class Ship
{
    //Classs constants

    /*In this programme we only car about numbers to two decimal places, hence
    the tolerance is 0.001 */
    public static final double TOL = 0.001;

    //PRIVATE CLASS FIELDS
    private String serialNum;
    private int year; 
    private Engine engine;

    /***********************************************************************
    DEFUALT Constructor
    IMPORT: none
    EXPORT: none
    ASSERTION: an abstract ship with a serial number of 123.456, commissioned
               in 2000, with an engine object is a valid state.
    ***********************************************************************/
    public Ship()
    {
        serialNum = "123.456";
        year = 2000;
        engine = new Engine();
    }
    /***********************************************************************
    ALTERNATE Constructor
    IMPORT: inSerialNum (String), inYear (Interger), inEngine (Engine object)
    EXPORT: none
    ASSERTION: creates an object of an abstract object of ship, otherwise it 
               fails
    ***********************************************************************/
    public Ship(String inSerialNum, int inYear, Engine inEngine)
    {
        if(validateSerialNum(inSerialNum))
        {
            if(validateYear(inYear))
            {
                serialNum = new String(inSerialNum);
                year = inYear;
                engine = new Engine(inEngine);
            }
        }
    }
    /***********************************************************************
    COPY Constructor
    IMPORT: inShip (Ship)
    EXPORT: none
    ASSERTION: creates a copy of the current object 
    ***********************************************************************/
    public Ship(Ship inShip)
    {
        serialNum = inShip.getSerialNum();
        year = inShip.getYear();
        engine = inShip.getEngine();
    }

    //ACCESSORS

    public String getSerialNum()
    {
        return new String(serialNum);
    }

    public int getYear()
    {
        return year;
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
    public void setSerialNum(String inSerialNum)
    {
       if(validateSerialNum(inSerialNum))
        {
            serialNum = new String(inSerialNum);
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
    }

    /***********************************************************************
    SUBMODULE: setEngine
    IMPORT: inEngine (Engine object)
    EXPORT: none
    ASSERTION: set engine to inEngine if it's valid, otherwise fail
    ***********************************************************************/
    public void  setEngine(Engine inEngine) 
    {
        /* we don't care if the engine constructs are valid as the engine class
           does that by itself. We only care if it's only an engine or not */

        if(!(inEngine instanceof Engine))
        {
            throw new IllegalArgumentException("ERROR: not a valid "+
                                               "engine");
        }
        else
        {
            engine = new Engine(inEngine);
        }
        
    }
    
    //DOING METHODS 
    
    /**********************************************************************
    SUBMODULE: calcTravelTime
    IMPORT: inShip (Submarine Object), distance (Integer)
    EXPORT: timeHours (Real) 
    PUROSE: to allow the subclasses of ship to inherit this method 
    **********************************************************************/
    public abstract double calcTravelTime(int distance);
    
    //PRIVATE METHODS

    /***********************************************************************
    SUBMODULE: validateSerialNum
    IMPORT: inSerialNum (Real)
    EXPORT: isValid (Boolean)
    ASSERTION: validates serial numbers as true whereby its first three
               digits are between 100 to 300 (inclusive), and the last three
               digits are between 001 - 999 (inclusive), otherwise it will
               validate them as false.
    ***********************************************************************/
    private boolean validateSerialNum(String inSerialNum)
    {
        boolean isValid = false;
        /* making a string of 2 elements to support both parts of the number
           (XXX.YYY) after it has been split i.e part[0] = XXX, and part[1] =
           YYY. Although if there's more than one decimal point, the variable
           parts will throw an NullPointerException which will fail the
           programme which is what we want, hence we don't need to catch the
           exception */

        String [] parts = new String[2];
        parts = inSerialNum.split("\\.");
               
        if(validateSerialNumLength(inSerialNum))
        {
            if(validateWholePart(parts[0]))
            {
                if(validateDecimalPart(parts[1]))
                {
                    isValid = true;
                }
            }
        }
    
        return isValid; 
    }
    /***********************************************************************
    SUBMODULE: validateSerialNumLength
    IMPORT: serialNum (String) 
    EXPORT: isValid (Boolean)
    ASSERTION: validates the serialNum as true if it has a length of 7 
               "XXX.YYY"
    **********************************************************************/
    private boolean validateSerialNumLength(String serialNum)
    {
        boolean isValid = false;
        
        /* the serial number is  digits, although we also need to account for
           the decimal point  "." hence it will be 7 elements due to the extra 
           decimal point */

        if(serialNum.length() == 7)
        {
            isValid = true;
        }
        else 
        {
            throw new IllegalArgumentException("\n Invalid serial number "+
                                               "lengt\n");                
        }
    
        return isValid;
        
    }


    /***********************************************************************
    SUBMODULE: validateWholePart
    IMPORT: wholePart (String)
    EXPORT: isValid (Boolean)
    ASSERTION: validates the wholepart of the serial number as true if it's
               between 100 to 300 (inclusive)
    ***********************************************************************/
    private boolean validateWholePart(String wholePart)
    {
        int wholePartInt;
        boolean isValid; 
        
        /* we convert wholePartInt to an integer to allow the algorithm to
           preform appropriate comparsion arithemric to validate if lays in the
           correct range integer range */
        
        wholePartInt = Integer.parseInt(wholePart);
        isValid = false;

        if(wholePartInt >= 100 && wholePartInt <= 300)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid whole part of the "+
                                               "serial number\n");
        }
    
        return isValid; 
    }

    /***********************************************************************
    SUBMODULE: validaDecimalPart
    IMPORT: decimalPart (string)
    EXPORT: isValid (Boolean)
    ASSERTION: validates the decimal part of the serial number if it's
               it's between 001 to 999 (inclusive)
    ***********************************************************************/
    private boolean validateDecimalPart(String decimalPart)
    {
        int decimalPartInt;
        boolean isValid;

        /* we convert DecialPartInt to an integer to allow the algorithm to
           preform appropriate comparsion arithemric to validate if lays in the
           correct range integer range */
        
        decimalPartInt = Integer.parseInt(decimalPart); 
        isValid = false;

        if(decimalPartInt >= 1 && decimalPartInt <= 999)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid decimal part of "+
                                               "serial number\n");
        }

        return isValid;
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
        else
        {
            throw new IllegalArgumentException("Invalid year");
        }

        return isValid;
    }

    //Protected methods

    /* I want only the subclassses of Ship.java to access theses following
    methods, hence I am making protected methods */

    /***********************************************************************
    SUBMODULE: isSame
    IMPORT: realNumOne (Real), realNumTwo (Real)
    EXPORT: isSame (Boolean)
    PURPOSE: to check the equality of two real numbers, given a specific
    tolerance.
    **********************************************************************/
    protected boolean isSame(double realNumOne, double realNumTwo)
    {
        //I adopted this code from the object oriented lectuter
        boolean isSame;
        isSame = false;
        if(Math.abs(realNumOne - realNumTwo) < TOL)
        {
            isSame = true;
        }

        return isSame;
    }
    /***********************************************************************
    SUBMODULE: isSame
    IMPORT: stringOne (String), stringTwo (String)
    EXPORT: isSame (Boolean)
    PURPOSE: To check the equality of two strings whereby the casing doesn't
    matter
    **********************************************************************/
    protected boolean isSame(String stringOne, String  stringTwo)
    {
        //this is not my idea, it's adopted from the association lecture slides
        String stringOneLower, stringTwoLower;
        boolean isSame;

        stringOneLower = stringOne.toLowerCase();
        stringTwoLower = stringTwo.toLowerCase();
        isSame = false;

        if(stringOneLower.equals(stringTwoLower))
        {
            isSame = true;
        }

        return isSame;
    }
        

    //OTHER METHODS
    
    /********************************************************************
    ABSTRACT SUBMODULE: clone
    IMPORT: none
    EXPORT: an identical object to the current object which has been made
    PURPOSE: to create an abstract class to force the subclasses to use 
             this submodule
    ********************************************************************/

    //creating an abstract class to force the subclasses to use the submodule
    public abstract Object clone();

    /********************************************************************
    ABSTRACT SUBMODULE: equals
    IMPORT: inObjct (object)
    EXPORT: isSame (boolean)
    PURPOSE: to compare the equality of two ships, given the classfields
             of serial number, year and engine
    ********************************************************************/
    public boolean equals(Object inObjct)
    {
        //I am pretty sure this is from amy's example, reference this properly
        boolean isEqual = false;
        if(inObjct instanceof Ship)
        {
            /* we need to type cast inObjct to a Ship class because the object
            class is not specific enough, and it won't be suitable for 
            any boolean operations */

            Ship inShip = (Ship)inObjct;

            if(year == inShip.getYear())
            {
                if(serialNum.equals(inShip.getSerialNum()))
                {
                    if(engine.equals(inShip.getEngine()))
                    {
                        isEqual = true;
                    }
                }
            }
        }
            
        return isEqual;
    }
      
    /********************************************************************
    SUBMODULE: toString
    IMPORT: none
    EXPORT: str
    PURPOSE: display the ships class fields to the user in a readable
             format
    ********************************************************************/
    public String toString()
    {
        String str;
        str = "The ship " +serialNum+ " was comissioned in " +year;
        
        return str;
    }

    /********************************************************************
    SUBMODULE: toFileString
    IMPORT: none
    PURPOSE: a method which writes a string in a file format thus another
             class is able to create objects from the string
    ********************************************************************/
    public String toFileString()
    {
        String str;
        str = serialNum+ "," +year;

        return str;
    }
}
    
