/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE:
PURPOSE: to create a class which will model the functionality of a real life 
         fighter jet
*******************************************************************************/
public class FighterJet extends Ship
{
    //private class fields
    private double wingSpan; 
    private String ordance;

    /***********************************************************************
    DEFUALT Constructor
    IMPORT: none
    EXPORT: none
    ASSERTION: a fighter jet with a serial number of 123.250, commissioned 
               in 1950, with an engine ordance of titanium with a maximum 
               depth of 500.0 is a valid defualt state
    ***********************************************************************/
    public FighterJet()
    {
        super();
        ordance = "machine guns";
        wingSpan = 3.0;
    }
    /***********************************************************************
    ALTERNATE Constructor
    IMPORT: inSerialNum (Real), inYear (Interger), inOrdance (String), 
            inWingSpan (Real)        
    EXPORT: none
    ASSERTION: creates an object if the imports are valid, otherwise it will
               FAIL
    ***********************************************************************/
    public FighterJet(String inSerialNum, int inYear, String inOrdance, 
                 double inWingSpan, Engine inEngine)
    {
        super(inSerialNum, inYear, inEngine);

        if(validateOrdance(inOrdance))
        {
            if(validateWingSpan(inWingSpan))
            {      
                ordance = inOrdance; 
                wingSpan = inWingSpan;  
            }
        }
    }
    /***********************************************************************
    COPY Constructor
    IMPORT: inFighterJet (FighterJet)
    EXPORT: none
    ASSERTION: creates an objext which is identical to the importred object
    ***********************************************************************/
    public FighterJet(FighterJet inFighterJet)
    {
        super(inFighterJet);
        ordance = inFighterJet.getOrdance();
        wingSpan = inFighterJet.getWingSpan();
    }
    
    //ACCESSORS

    public String getOrdance()
    {
        return ordance;
    }

    public double getWingSpan()
    {
        return wingSpan;
    }
    
    //MUTATORS

   /***********************************************************************        
    SUBMODULE: setOrdance 
    IMPORT: inOrdance (String)
    EXPORT: none
    ASSERTION: set ordance to to inOrdance if it's valid, otherwise it will fail
    ***********************************************************************/
    public void setOrdance(String inOrdance)
    {
        if(validateOrdance(inOrdance)) 
            ordance = inOrdance;
        else
        {
            throw new IllegalArgumentException("\nInvalid ordance\n");
        }
    }
    /***********************************************************************
    SUBMODULE: setWingSpan 
    IMPORT: inWingSpan (Real)
    EXPORT: none
    ASSERTION: set wingspan to inWingSpan if it's valid, otherwise fail
    ***********************************************************************/
    public void setWingSpan(double inWingSpan)
    {
        if(validateWingSpan(inWingSpan))
        {
            wingSpan =  inWingSpan; 
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid wingspan\n");
        }
    }
    
    //DOING METHODS:

    /**********************************************************************
    SUBMODULE: calcTravelTimeJet
    IMPORT:inShip (fighterJet object), (Integer) distance
    EXPORT: timeHours (Real) 
    PURPOSE: is to calculate the tracel time of the fighter jet in hours
    **********************************************************************/
    @Override
    public double calcTravelTime(int distance)
    {
        double denom, timeHours;
        denom = getWingSpan() * (double)getEngine().getCylinders() 
                * 150.00;
        timeHours = (double)distance / denom;
        
        return timeHours;
    }

    //PRIVATE SUBMODULES:

   /**********************************************************************
    SUBMODULE: validateOrdance
    IMPORT: inOrdance (String)
    EXPORT: isValid (boolean)
    ASSERTION: it will only validate inOrdance if it has a string describing
               the ordance of the fighter jet
    ********************************************************************/
    private boolean validateOrdance(String inOrdance)
    {
        boolean isValid = false;
        if (inOrdance.length() != 0)
        {
            isValid = true;
        }

        return isValid;
    }
    /*******************************************************************
    SUBMODULE: validateWingSpan
    IMPORT: inWingSpan (Real)
    EXPORT: isValid (Boolean)
    ASSERTION: a wingSpan of between 2.20 and 25.6 will be validate 
               otherwise, error will be thrown to the user
    ********************************************************************/
    private boolean validateWingSpan(double inWingSpan)
    {
        
        boolean isValid = false;
        if(inWingSpan >= 2.2 && inWingSpan <= 25.6)
        {
            isValid = true;            
        }

        return isValid;
        

       // return ((inWingSpan >= 2.2) && (inWingSpan <= 25.6));
    }

    //OTHER METHODS

    /********************************************************************
    SUBMODULE: clone
    IMPORT: none
    EXPORT: cloneFighterJet (Object)
    ASSERTION: returns a cloned object of the current object
    ********************************************************************/
    @Override
    public FighterJet clone()
    {
        /*FighterJet cloneFighterJet;

        cloneFighterJet = new FighterJet(this.serialNum, this.year, 
                                this.ordance, this.wingSpan, this.engine);
        return cloneFighterJet; */

        return new FighterJet(this);
    }

    /********************************************************************
    SUBMODULE: equals
    IMPORT: inObjct (object)
    EXPORT: isSame (boolean)
    ASSERTION: two fighter jets are interchangable if they have the same 
               ordance and wingspan
    ********************************************************************/
    @Override
    public boolean equals(Object inObjct, Engine inEngine)
    {
        boolean isSame = false;
        if(inObjct instanceof FighterJet) 
        {
            FighterJet inFighterJet = (FighterJet)inObjct;
            isSame = ordance.equals(inFighterJet.getOrdance()) &&
                      wingSpan == (inFighterJet.getWingSpan()) &&
                      getEngine().equals(inEngine);
        }

        return isSame;
    }
    /********************************************************************
    SUBMODULE: toString
    IMPORT: none
    EXPORT: str (String)
    ASSERTION:
    ********************************************************************/
    @Override 
    public String toString()
    {
        String str;
        str = super.toString() +getEngine().toString()+ " It is a fighter jet"+
                    " with a wing span of " +wingSpan+ " metres and equiped "+
                    "with " +ordance+ ".";
        return str;
    }
    /********************************************************************
    SUBMODULE: toFileString
    IMPORT: none
    EXPORT: str (String)
    ASSERTION: 
    ********************************************************************/
    @Override
    public String toFileString()
    {
        String str;
        str = "F," + super.toFileString() + "," + getEngine().toFileString() +
              "," + wingSpan + "," + ordance;
    
        return str;
    }
} 
