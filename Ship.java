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
    
    //PRIVATE METHODS
    
