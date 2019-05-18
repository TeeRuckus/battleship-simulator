/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE:
PURPOSE:
*******************************************************************************/
public abstract class Ship
{
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
    ASSERTION: creates an object if the imports are valid, otherwise it will
               FAIL
    ***********************************************************************/
    public Ship(String inSerialNum, int inYear, Engine inEngine)
    {
        if(validateSerialNum(inSerialNum))
        {
            if(validateYear(inYear))
            {
                serialNum = inSerialNum;
                year = inYear;
                engine = inEngine;
            }
        }
    }
    /***********************************************************************
    COPY Constructor
    IMPORT: inSubmarine (SubMarineClass)
    EXPORT: none
    ASSERTION: creates an objext which is identical to the importred onkect
    ***********************************************************************/
    public Ship(Ship inShip)
    {
        serialNum = inShip.getSerialNum();
        year = inShip.getYear();
        engine = getEngine();
    }

    //ACCESSORS

    public String getSerialNum()
    {
        return serialNum;
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
            serialNum = inSerialNum;
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
    
    //DOING METHODS 
    
    /**********************************************************************
    SUBMODULE: calcTravelTimeSub
    IMPORT: inShip (Submarine Object), distance (Integer)
    EXPORT: timeHours (Real) 
    PUROSE: is to calculate the travel time of submarine in hours 
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
            throw new IllegalArgumentException("\nInvalid whole part of the "+
                                               "decimal number\n");
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
            throw new IllegalArgumentException("\ninvalid decimal part of "+
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
  
    //OTHER METHODS
    
    /********************************************************************
    ABSTRACT SUBMODULE: clone
    IMPORT: none
    EXPORT: an identical object to the current object which has been made
    ASSERTION: returns a cloned object of the current object
    ********************************************************************/
    public abstract Object clone();

    /********************************************************************
    ABSTRACT SUBMODULE: equals
    IMPORT: inObjct (object)
    EXPORT: isSame (boolean)
    ASSERTION: two submarines are interchangable if they have the same hull,
               and max depth
    ********************************************************************/
    public abstract boolean equals(Object inObject, Engine inEngine);
      
    /********************************************************************
    SUBMODULE: toString
    IMPORT: none
    EXPORT: str
    ASSERTION:
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
    EXPORT: str
    ASSERTION:
    ********************************************************************/
    public String toFileString()
    {
        String str;
        str = serialNum+ "," +year;

        return str;
    }
}
    
