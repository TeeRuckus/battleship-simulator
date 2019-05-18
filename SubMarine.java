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
    public SubMarine(String inSerialNum, int inYear, Engine inEngine,
                     String inHull,double inMaxDepth)
    {
        super(inSerialNum, inYear, inEngine);
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
        {
            hull = inHull;
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

    /**********************************************************************
    SUBMODULE: calcTravelTimeSub
    IMPORT: inShip (Submarine Object), distance (Integer)
    EXPORT: timeHours (Real) 
    PUROSE: is to calculate the travel time of submarine in hours 
    **********************************************************************/
    @Override
    public double calcTravelTime(Object inSubMarine, int distance)
    {
        double ratio, denom, invDenom;
   
        ratio = ( (double) distance / (double) getEngine().getCylinders());
        denom = (10.00 + getMaxDepth() * -1.00);
        invDenom = 1.00 / denom;
    
        return ratio * invDenom;
    }
    

    //PRIVATE SUBMODULES:

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
        else
        {
            throw new IllegalArgumentException("\nInvalid hull\n");
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
        else
        {
            throw new IllegalArgumentException("\nInvalid max  depth\n");
        }

        return isValid;
    }

    //OTHER METHODS

    /********************************************************************
    SUBMODULE: clone
    IMPORT: none
    EXPORT: an identical object to the current object which has been made
    ASSERTION: returns a cloned object of the current object
    ********************************************************************/
    @Override
    public SubMarine clone()
    {
        return new SubMarine(this);
    }

    /********************************************************************
    SUBMODULE: equals
    IMPORT: inObjct (object)
    EXPORT: isSame (boolean)
    ASSERTION: two submarines are interchangable if they have the same hull,
               and max depth
    ********************************************************************/
    @Override
    public boolean equals(Object inObjct, Engine inEngine)
    {
        boolean isSame = false;
        if(inObjct instanceof SubMarine)
        {
            SubMarine inSubmarine = (SubMarine)inObjct;
            isSame = hull.equals(inSubmarine.getHull()) &&
                      maxDepth == (inSubmarine.getMaxDepth()) &&
                      getEngine().equals(inEngine); 
        }

        return isSame;
    }

    /********************************************************************
    SUBMODULE: toString
    IMPORT: none
    EXPORT: str
    ASSERTION:
    ********************************************************************/
    @Override
    public String toString()
    {
        String str;
        str = super.toString() + getEngine().toString()+ 
              "It is a submarine with a " +hull+ " hull and a  max depth of " 
               +maxDepth+ ".";

        return str;
    }

    /********************************************************************
    SUBMODULE: toFileString
    IMPORT: none
    EXPORT: str
    ASSERTION:
    ********************************************************************/
    @Override
    public String toFileString()
    {
        String str;
        str = "S," + super.toFileString() +","+ getEngine().toFileString() + 
              "," + hull + "," +maxDepth;
        return str;
    }
}
