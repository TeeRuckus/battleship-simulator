/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE:
PURPOSE: to create a class which will model the functionality of a real life
         submarine
*******************************************************************************/
public class SubMarine extends Ship
{
    //Class constants
    public static final String STEEL = "STEEL";
    public static final String ALLY = "ALLOY";
    public static final String TTNM = "TITANIUM";

    //private class fields
    private double maxDepth;
    private String hull;

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
        super();
        hull = TTNM;
        maxDepth = -500.0;
    }

    /***********************************************************************
    ALTERNATE Constructor
    IMPORT: inHull (String), inMaxDepth (Real)
    EXPORT: none
    ASSERTION: creates a submarine object if the imports are valid, otherwise 
               it will FAIL
    ***********************************************************************/
    public SubMarine(String inHull,double inMaxDepth)
    {
        super(inHull, inMaxDepth);
        if(validateHull(inHull))
        {
            if(validateMaxDepth(inMaxDepth))
            {
                hull = inHull;
                maxDepth = inMaxDepth;
            }
        }
    }

    /***********************************************************************
    COPY Constructor
    IMPORT: inSubmarine (SubMarineClass)
    EXPORT: none
    ASSERTION: creates an object which is identical to the alternate
               constructor
    ***********************************************************************/
    public SubMarine(SubMarine inSubMarine)
    {
        super(inSubMarine);
        hull = inSubMarine.getHull();
        maxDepth = inSubMarine.getMaxDepth();
    }

    //ACCESSORS

   
    public String getHull()
    {
        return hull;
    }

    public double getMaxDepth()
    {
        return maxDepth;
    }
    
    

    //MUTATORS

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
    private boolean validateSerialNum(String inSerialNum)
    {
        boolean isValid = false;
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

        if(serialNum.length() == 7)
        {
            isValid = true;
        }
        else 
        {
            throw new IllegalArgumentException("ERROR: The serial number"+
                                               "  must a length of 7");
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

        
        /* we need to convert wholePart into an integer so we can check 
           if it's in the valid range og 100 to 300 */
        wholePartInt = Integer.parseInt(wholePart);
        isValid = false;

        if(wholePartInt >= 100 && wholePartInt <= 300)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("ERROR: invalid whole "+
                                         "part of the decimal number");
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

        /* we need to convert decimalPart to an integer so we can check if 
           it's in the valid range of 001 to 999. However we don't need to
           check if it has 3 numbers places as another method handles 
           that */
        
        decimalPartInt = Integer.parseInt(decimalPart); 
        isValid = false;

        if(decimalPartInt >= 1 && decimalPartInt <= 999)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("ERROR: invalid "+
                                  "decimal part of serial number");
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
                      engine.equals(inEngine); 
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
