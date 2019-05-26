/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE: 27/05/19
PURPOSE: to create a class which will model the functionality of a real life
         submarine
*******************************************************************************/
public class SubMarine extends Ship
{
    //Class constants
    public static final String STEEL = "STEEL";
    public static final String ALLY = "ALLOY";
    public static final String TTNM = "TITANIUM";
    public static final double MIN_DEPTH = 0.0; 
    public static final double MAX_DEPTH = -500.0;

    //private class fields
    private double maxDepth;
    private String hull;

    /***********************************************************************
    DEFUALT Constructor
    IMPORT: none
    EXPORT: none
    ASSERTION: a submarine which inherits its defualt constructor with a max
               depth of -500 and a hull of titanium is a valid defualt state
    ***********************************************************************/
    public SubMarine()
    {
        super();
        hull = TTNM;
        maxDepth = -500.0;
    }

    /***********************************************************************
    ALTERNATE Constructor
    IMPORT: inSerialNum (Real), inYear (Interger), inHull (String),
        inMaxDepth (Real)
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
                hull = new String(inHull);
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
        return new String(hull);
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
            hull = new String (inHull); 
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
    SUBMODULE: calcTravelTime
    IMPORT: inShip (Submarine Object), distance (Integer)
    EXPORT: timeHours (Real) 
    PUROSE: is to calculate the travel time of submarine in hours 
    **********************************************************************/
    @Override
    public double calcTravelTime(int distance)
    {
        double ratio, denom, invDenom, timeHours;

        if(distance >= 0)
        {
            /*splitting up the calculations in the assignemnt specification to
            make it more comphredable and to make it easier to type cast values 
            and debug */

            ratio = ( (double) distance / (double) getEngine().getCylinders());
            denom = (10.00 + getMaxDepth() * -1.00);
            invDenom = 1.00 / denom;
            timeHours = ratio * invDenom;
        }
        else
        {
            throw new IllegalArgumentException("\nERROR: negative distance\n");
        }
    
        return timeHours;
    }
    

    //PRIVATE SUBMODULES:

   /**********************************************************************
    SUBMODULE: validateHull
    IMPORT: inHull (String)
    EXPORT: isValid (boolean)
    ASSERTION: it will only validate inHull if it's one of the following
               three; steel, alloy and titanium.
    ********************************************************************/
    private boolean validateHull(String inHull)
    {
        String upperCaseInHull;
        boolean isValid = false;

        /* converting inHull to be upper case, to allow any casing for fuel 
           to be passed to the method as reuired in the specification */

        upperCaseInHull = inHull.toUpperCase();
        if(upperCaseInHull.equals(STEEL) || upperCaseInHull.equals(ALLY) ||
           upperCaseInHull.equals(TTNM))
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
    PURPOSE: To ensure the inputed max depth is between the range of -500 t0
             0 metres.
    ASSERTION: a maxdepth of between -500 - 0 will be validate otherwise, an
               error will be thrown to the user
    ********************************************************************/
    private boolean validateMaxDepth(double inMaxDepth)
    {
        boolean isValid = false;

        if(inMaxDepth >= MAX_DEPTH && inMaxDepth <= MIN_DEPTH)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("\nInvalid max depth\n");
        }

        return isValid;
    }

    //OTHER METHODS

    /********************************************************************
    SUBMODULE: clone
    IMPORT: none
    EXPORT: an identical object to the current object which has been made
    PURPOSE: To creaete a copy/cone of the current object.
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
    ASSERTION: two submarines are equal if they have the same hull, and
                max depth
    ********************************************************************/
    @Override
    public boolean equals(Object inObjct)
    {
        super.equals(inObjct);
        boolean isEqual = false;
        if(inObjct instanceof SubMarine)
        {
            /* we need to type cast inObjct to a submarine class because 
            the object data type is not sepcific enough, and it won't be 
            suitable for boolean operations */
            SubMarine inSubMarine = (SubMarine)inObjct;

            if(isSame(hull, inSubMarine.getHull()))
            {
                if(isSame(maxDepth, inSubMarine.getMaxDepth()))
                {
                    isEqual = true;
                }
            }
        }
            
        return isEqual;
    }

    /********************************************************************
    SUBMODULE: toString
    IMPORT: none
    EXPORT: str
    PURPOSE: to display submarines classfields in a readable format format 
             for the user
    ********************************************************************/
    @Override
    public String toString()
    {
        /* hull is formatteded in upper cases and this is not user friendly,
        hence it needs to be formatted to lower case. Thus a creation of a
        lower case variable*/
        String str, hullLowerCase;
        hullLowerCase = hull.toLowerCase();

        str = super.toString() + getEngine().toString()+ 
              " It is a submarine with a " +hullLowerCase+ " and a  max depth"+
              " of " +maxDepth+ ".";

        return str;
    }

    /********************************************************************
    SUBMODULE: toFileString
    IMPORT: none
    EXPORT: str
    PURPOSE: It's to return a string which will be written to a file, to allow
             another class to create ship objects from the written string
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
