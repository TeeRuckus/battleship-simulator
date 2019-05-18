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
