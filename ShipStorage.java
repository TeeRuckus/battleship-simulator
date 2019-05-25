/*******************************************************************************
AUTHOR: Tawana David Kwaramba
STUDENT ID: 19476700
LAST MODIFIED:
PURPOSE: A class which stores a submarine and a fighter jet object
*******************************************************************************/
public class ShipStorage
{
    //PUBLIC CLASS CONSTANTS:

    public static final int MAX_CAP = 30; 

    //CLASS FIELDS:
    private int countShips;
    Ship storeShips [];
    private Ship ship;

    //COSTRUCRS:
    
    /**********************************************************************
    Defualt:
    IMPORT: none
    EXPORT: none
    ASSERTION: count varibales of zero and empty arrays of the maximum 
               capacity variables is valid defualt sate.
    **********************************************************************/
    public ShipStorage()
    {
        countShips = 0;
        storeShips = new Ship[MAX_CAP];
    }

    //DOING METHODS

    /**********************************************************************
    SUBMODULE: addShipSub
    IMPORT: inSub (subMarine object) , countShips (int)
    EXPORT: none
    ASSERTION: a sub will be added to storeShips if the inSub is valid, and
                storeShips hasn't exceeded the MAX_CAP
    **********************************************************************/
    public void addShip(SubMarine inSub)
    {
        if (validateShip(inSub))
        {
            storeShips[countShips] = inSub.clone();

            /*I am incrementing countSub by 1, to go to the next
            vaccant index of the storeSub*/
            countShips++;
        }      
    }

    /**********************************************************************
    SUBMODULE: addShipJet
    IMPORT: inJet (FighterJet object) , countShips (int)
    EXPORT: none
    ASSERTION: a jet will be added to storeJEts if the inJet is valid, and
               storeShips hasn't exceeded MAX_CAP
    **********************************************************************/
    public void addShip(FighterJet inJet)
    {
        if(validateShip(inJet))
        {
            storeShips[countShips] = inJet.clone();

            /*I am incemention countShips by 1, to go to the next
            vaccant index of the storeShips*/
            countShips++;
        }
   }


   /**********************************************************************
    SUBMODULE: getLastSub (SubMarine Object) 
    IMPORT: none
    EXOPORT: sub (subMarine Object)
    **********************************************************************/
    public Ship getShip()
    {
        /* I have subtracted one because the other constructors (i.e.
        alternate constructor) will move the index  of the count
        variable to the next available index, hence you have to
        subtract one to get the last stored submarine*/
    
        ship = storeShips[countShips - 1]; 
        return ship;
    } 

    /**********************************************************************
    SUBMODULE: destinationCheckSub
    IMPORT: (integer) distance
    EXPORTS: (String) str 
    **********************************************************************/
    /*
    public String destinationCheck(int distance) 
    {
        double compareShips;
        Ship fatestShip;
        
         /* I am setting up the first ship as a reference point of 
            comparison to other ships, and the 0 index is the most convient
            index*/

      //  compareShips = ship.calcTravelTime(distance);
    
        /*I don't want the reference submarine of comparison, to comparew
        by itself, as this is an ineffecient use of the machine's 
        resouces.*/
    /*
        for(int ii = 1; ii < MAX_CAP; ii++)
        {
            compareShips = Ship.calcTravelTime(storeShips[ii],distance);
            if(compareShips < fastestShipTime)
            {
                fastestShip = storeShips[ii].toString();
            } 
        }
        
        return fastestShip.toString(); 
    }*/
   
    /**********************************************************************
    SUBMODULE: findDuplicateShips
    IMPORTS: none
    EXPORT: dupilicates[] (Object) 
    ASSERTION:
    **********************************************************************/
    public Ship [] findDuplicateShips() 
    {
        /* I am subtracting one because the other the methods which use 
        counSihps move to a null index of the */
        Ship duplicates [] = new Ship[(countShips -1) * 2];
        
        for (int ii = 0 ;ii < countShips - 1; ii++) 
        {
            /*I am starting the looping variable at one because 1 don't
             want the programme to store itself as a dupilcate, hence
             it will search for objects after itself*/

            for(int jj = ii+1 ; jj < countShips -1 ;jj++)
            {
                if(storeShips[ii].equals(storeShips[jj])) 
                {
                    duplicates[ii] = storeShips[ii];
                    duplicates[jj] = storeShips[jj];
                }
            }
         }
        
        return duplicates; 
    }

   //PRIVATE SUBMODULES:
   
    /**********************************************************************
    SUBMODULE: validateSub
    IMPORT: inObjct (subMarine object)
    EXPORT: isValid (Boolean)
    ASSERTION: if inObjct is a subMarine object then it's  valid
    **********************************************************************/
    private boolean validateShip(SubMarine inObjct)
    {
        boolean isValid = false;

        if (inObjct instanceof SubMarine) 
        {
            if(validateShipFields(inObjct))
            {
                if(validateShipCap())
                {
                    isValid = true;
                }
            }
        }
                
        return isValid;
    }

    /**********************************************************************
    SUBMODULE: validateJet
    IMPORT: inObjct (fighterJet object)
    EXPORT: isValid (Boolean)
    ASSERTION: if inJet is a fighterJet object then it's valid
    **********************************************************************/
    private boolean validateShip(FighterJet inObjct)
    {
        boolean isValid = false;
        if (inObjct instanceof FighterJet) 
        {
            if(validateShipFields(inObjct))
            {
                if(validateShipCap())
                {
                    isValid = true;
                }
            }
        }
               return isValid;
    }

    /**********************************************************************
    SUBMODULE: validateShipFields 
    IMPORT: inObjct (Object)
    EXPORT: isValid (Boolean)
    ASSERTION: if an objects class fields are not null, it's a valid object
    **********************************************************************/
    private boolean validateShipFields(Object inObjct)
    {
        boolean isValid = false;
        if(inObjct != null)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("ERROR: classfields are empty");
        }
        return isValid;
    }

    /**********************************************************************
    SUBMODULE: validateShipCap
    IMPORT: none
    EXPORT: isValid (Boolean)
    ASSERTION: checks if the MAX CAP of the shipstorage has been reached
    **********************************************************************/
    private boolean validateShipCap()
    {
        boolean isValid = false;
        if(countShips < MAX_CAP)
        {
            isValid = true;
        }
        else
        {
            throw new IllegalArgumentException("ERROR: shipstorage maxium "+
                                               "capacity has been reached");
        }
        
        return isValid;
    }
    
    //OTHER METHODS:
    
    //MAKE A CLONE METHOD
    /**********************************************************************
    SUBODULE: equalsArray
    IMPORT: arrayOne (Object), arrayTwo (object Two)
    EXPORT: isValid (Boolean)
    ASSERTION: if two array objects are the same class type and length, 
               and have the same objects in the array and it's valid.
    **********************************************************************/
    public boolean equalsArr(Object[] arrayOne, Object[] arrayTwo)
    {

        /* this code was adapted from worksheet 9 (REFERENCE PROPERLY) */
        boolean isSame = false;

        if (arrayOne.length ==  arrayTwo.length) 
        {
             /*searching through both arrays to ensure that they have
             the same contents in the array*/

            int compareElements = 0;

            do
            {
                isSame = arrayOne[compareElements].equals(
                                arrayTwo[compareElements]);
                compareElements++;
            }while(compareElements < arrayOne.length);
        }
        return isSame; 
    }
    
    /**********************************************************************
    SUBMODULE: toStringArr
    IMPORT: none
    EXPORT: strArry [] (String)
    ASSERTION:
    **********************************************************************/
    public String[] toStringArr() 
    {
        int tolShipsInfo;

         /*I am adding an extra 1 to tolShipsInfo. Because, I want an
         extra index to store the summary of the ship storage units
         (i.e. how many ships they're in total. How many jets they're,
         and how many submarines they're)*/

        tolShipsInfo = MAX_CAP + 1;

        String strArr [] = new String [tolShipsInfo];

        strArr [0] = "The ship storage contains " +(countShips-1)+ " ships. "+
                     "There's " +countShips+ " submarines, and there's " +
                      countShips+ "fighter jets in the hanger";

         /*I am starting the looping condition at 1, becasue the 0 index
         is reserved for the summary of the arrays, and I am subtracting
         one so the for loop doesn't try to look outside the array as
         the index of an array starts at 1*/

        for (int ii= 1 ; ii < MAX_CAP; ii++)
        {
            strArr [ii] =  storeShips[ii].toString();
        }

       return strArr;
    }
}
