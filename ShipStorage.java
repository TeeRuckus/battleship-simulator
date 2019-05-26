/*******************************************************************************
AUTHOR: Tawana David Kwaramba
STUDENT ID: 19476700
LAST MODIFIED: 27/05/19
PURPOSE: A class which stores a submarine and a fighter jet object
*******************************************************************************/
public class ShipStorage
{
    //PUBLIC CLASS CONSTANTS:

    public static final int MAX_CAP = 30; 

    //CLASS FIELDS:
    private int countShips;
    private Ship storeShips [];
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

    //ACCESSORS

    public int getCount()
    {
        return countShips;
    }

    //DOING METHODS

    /**********************************************************************
    SUBMODULE: addShip
    IMPORT: inSub (subMarine object) 
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
    SUBMODULE: addShip
    IMPORT: inJet (FighterJet object) 
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
    SUBMODULE: getShip (Ship) 
    IMPORT: none
    PURPOSE: get the last ship stored in storeShips
    **********************************************************************/
    public Ship getShip()
    {
        /* I have subtracted one because the other constructors (i.e.
        alternate constructor) will move the index  of the count
        variable to the next available index, hence you have to
        subtract one to get the last stored submarine*/
    
        return storeShips[countShips -1];
    } 

    /**********************************************************************
    SUBMODULE: destinationCheck
    IMPORT: (integer) distance
    EXPORTS: (String) 
    **********************************************************************/
    public String destinationCheck(int distance) 
    {
        Ship fastestShip;
        fastestShip = null;

        for(int ii = 0; ii < countShips; ii++)
        {
            for(int jj = ii + 1; jj < countShips; jj++)
            {
                if((storeShips[ii].calcTravelTime(distance)) < 
                                    (storeShips[jj].calcTravelTime(distance)))
                {
                   fastestShip = storeShips[ii];
                }
            }
        }

        return fastestShip.toString();
    }

    /**********************************************************************
    SUBMODULE: findDuplicateShips
    IMPORTS: none
    EXPORT: dupilicates[] (Object) 
    PURPOSE: finds the duplicates in storeSubs and displays the ship
    **********************************************************************/
    public Ship [] findDuplicateShips() 
    {

        Ship duplicates [] = new Ship[(countShips) * 2];
        
        int found;
        found = 0;
        
        for (int ii = 0 ;ii < countShips; ii++) 
        {
            /*I am adding one to the looping variable at one because I don't
             want the programme to store itself as a dupilcate, hence
             it will search for objects after itself*/

            for(int jj = ii+1 ; jj < countShips;jj++)
            {
                if(storeShips[ii].equals(storeShips[jj])) 
                {
                    /* a seperate counter is used for duplicates to ensure the
                    array is filled from the begginning index onwards */

                    duplicates[found] = storeShips[ii];
                    found++;
                }
            }
         }
        
        return duplicates; 
    }

   //PRIVATE SUBMODULES:
   
    /**********************************************************************
    SUBMODULE: validateShip 
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
    SUBMODULE: validateShip
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

    /**********************************************************************
    SUBODULE: equalsArray
    IMPORT: arrayOne (Object), arrayTwo (object Two)
    EXPORT: isValid (Boolean)
    ASSERTION: if two array objects are the same class type and length, 
               and have the same objects in the array and it's valid.
    **********************************************************************/
    public boolean equalsArr(Object[] arrayOne, Object[] arrayTwo)
    {
        //THIS METHOD IS INCREDIBILY FLAWED 

        /* this code was adapted from worksheet 9 (REFERENCE PROPERLY) */
        boolean equal = false;

        if (arrayOne.length ==  arrayTwo.length) 
        {
             /*searching through both arrays to ensure that they have
             the same contents in the array*/

            int compareElements = 0;

            do
            {
                equal = arrayOne[compareElements].equals(
                                arrayTwo[compareElements]);
                compareElements++;
            }while(compareElements < arrayOne.length);
        }

        return equal;
    }

    /**********************************************************************
    SUBODULE: equals
    IMPORT: inObjct (Object)
    EXPORT: isEqual (Boolean)
    PURPOSE: to check the equality of two shipStorages
    **********************************************************************/
    /*public boolean equals(Object inObjct)
    {
        boolean isSame;
        Ship inShip;
        if(inObjct instanceof Ship)
        {
            /* we need to type cast inObjct to a ship classs because the object
            data type of object is not specific enough, and it won't be
            suitable for booolean operations */
      /*      inShip = (Ship)inObjct;

            isSame = 
        }
    }*/

    
    /**********************************************************************
    SUBMODULE: toStringArr
    IMPORT: none
    EXPORT: strArry [] (String)
    PURPOSE: to create an array of storeShips toString methods
    **********************************************************************/
    public String[] toStringArr() 
    {
        /* I am subtracting one from countShips because the other methods which
        use countShips will move to a null index in the storeShips array, hence
        we want to move back to a non-null index so we don't get a null pointer
        exception */
        String strArr [] = new String [countShips];

        for (int ii= 0 ; ii < countShips; ii++)
        {
            strArr [ii] =  storeShips[ii].toString();
        }

       return strArr;
    }

    /**********************************************************************
    SUBMODULE: toFileStringArr
    IMPORT: none
    EXPORT: strArry [] (String)
    PURPOSE: to create an array of storeShips toFileString method
    **********************************************************************/
    public String[] toFileStringArr()
    {

        /* I am subtracting one from countShips because the other methods which
        use countShips will move to a null index in the storeShips array, hence
        we want to move back to a non-null index so we don't get a null pointer
        exception */

        String strArr [] = new String [countShips - 1];

        for (int ii= 0 ; ii < countShips - 1; ii++)
        {
            strArr [ii] =  storeShips[ii].toFileString();
        }

       return strArr;
    }

}
