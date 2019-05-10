/*******************************************************************************
AUTHOR: Tawana David Kwaramba
STUDENT ID: 19476700
LAST MODIFIED:
PURPOSE: A class which stores a submarine and a fighter jet object
*******************************************************************************/
public class ShipStorage
    {
        //PUBLIC CLASS CONSTANTS:

          /*I have made two maxiumum capcity to make refactoring and
            expandibility of the code easier in the future, and to allow the
            user to have a non 1:1 split of the capacity between submarines an
            jets. */
        
        public static final int MAX_CAP = 15; 

        //CLASS FIELDS:

        private int countSubs;
        private int countJets;
        SubMarine storeSubs [];
        FighterJet storeJets [];

        //COSTRUCRS:
        
        /**********************************************************************
        Defualt:
        IMPORT: none
        EXPORT: none
        ASSERTION: count varibales of zero and empty arrays of the maximum capacity
                    variables is valid defualt sate.
        **********************************************************************/
        public ShipStorage()
        {
            countSubs = 0;
            countJets = 0;
            storeSubs = new SubMarine [MAX_CAP];
            storeJets = new FighterJet [MAX_CAP];
        }
    
       //ACCESSORS

       /**********************************************************************
        SUBMODULE: getLastSub (SubMarine Object) 
        IMPORT: none
        EXOPORT: sub (subMarine Object)
        **********************************************************************/
        public SubMarine getSub()
        {
            /* I have subtracted one because the other constructors (i.e.
            alternate constructor) will move the index  of the count
            variable to the next available index, hence you have to
            subtract one to get the last stored submarine*/
		
            SubMarine sub; 
            return sub = storeSubs[countSubs - 1]; 
        } 

        /**********************************************************************
        SUBMODULE: getLastjet (FighterJet Object)
        IMPORT: none
        EXPORT: jet (fighterJet object)
        **********************************************************************/
        public FighterJet getLastJet()
        {

             /*I have subtracted one because the other constructors (i.e.
             alternate constructor) will move the index of the count
             variable to the next available index, hence you have to
             subtract one to get the last stored jet*/
            FighterJet jet; 
            return jet = storeJets[countJets - 1];
        }

        //MUTATORS:

       /**********************************************************************
        SUBMODULE: addShipSub
        IMPORT: inSub (subMarine object) , countSubs (int)
        EXPORT: none
        ASSERTION: a sub will be added to storeSubs if the inSub is valid, and
                    storeSubs hasn't exceeded the MAX_CAP
        **********************************************************************/
        public void addShipSub(SubMarine inSub, int countSubs)
        {
            if (validateSub(inSub))
            {
                storeSubs[countSubs] = inSub; 

                /*I am incrementing countSub by 1, to go to the next
                vaccant index of the storeSub*/
        
                countSubs++;
            }
            else
            {
                throw new IllegalArgumentException("ERROR: The storage of"+
                                               " the submarines is full.");
            }
            
        }
        /**********************************************************************
        SUBMODULE: addShipJet
        IMPORT: inJet (FighterJet object) , countJets (int)
        EXPORT: none
        ASSERTION: a jet will be added to storeJEts if the inJet is valid, and
                   storeSubs hasn't exceeded MAX_CAP
        **********************************************************************/
        public void addJet(FighterJet inJet, int countJets)
        {
            if(validateJet(inJet))
            {

                /*I am incemention countJets by 1, to go to the next
                vaccant index of the storeJets*/
                countJets++;
            }
            else
            {
                throw new IllegalArgumentException("ERROR: not a fighter jet");
            }
        }

        //DOING METHODS:

        /**********************************************************************
        SUBMODULE: destinationCheckSub
        IMPORT: (integer) distance
        EXPORTS: (String) str 
        **********************************************************************/
        
        public String destinationCheckSub(int distance) 
        {
            
             /*I am setting up a submarine object to set up a reference point
             of comparison to other submarine objects withing the storeSubs
                     array. The 0 index sub is the most convient*/
    
            double fastestSubTime = calcTravelTimeSub(storeSubs[0]);
            SubMarine fastestSub; 
        
            /*I don't want the reference submarine of comparison, to comparew
            by itself, as this is an ineffecient use of the machine's 
            resouces.*/
        
            for(int ii = 1; ii < MAX_CAP; ii++)
            {
                if(calcTravelTimeSub(storeSubs[ii],distance) < fastestSub)
                {
                    fastesSub = storeSubs[ii];
                } 
            }
            
            return fastestSub.toString;
        }
        /**********************************************************************
        SUBMODULE: calcTravelTimeSub
        IMPORT: inShip (Submarine Object), distance (Integer)
        EXPORT: timeHours (Real) 
        PUROSE: is to calculate the travel time of submarine in hours 
        **********************************************************************/
        public double calcTravelTimeSub(SubMarine inShip, int distance)
        {
            double ratio, denom, invDenom;
       
            ratio = ((double)distance / (double)(inShip.getCylinders()));
            denom = (10.00 + (inShip.getMaxDepth() * -1.00));
            invDenom = 1.00 / denom;
        
            return ratio * invDenom;
        }
        
        /**********************************************************************
        SUBMODULE: destinationCheckJet
        IMPORT: (Integer) distance
        EXPORTS: (String) str 
        PURPOSE:
        **********************************************************************/
        public int destinationCheckJet(int distance)
        {
        
            /*I am setting up a submarine object to set up a reference point
            of comparison to other jet objects withing the storeJets
            array. The 0 index sub is the most convient*/

            FighterJet fastestJet = calcTravelTimeJet(storeJets[0]);
            
            /*I don't want the reference jet of comparison, to comparew
            by itself, as this is an ineffecient use of the machine's 
            resouces.*/
            
            for (int ii = 1; ii < MAX_CAP; ii++)                 
            {
                    if (calcTravelTimeJet(storeJets[ii],distance) < fastestJet) 
                    {
                        fastestJet = storeJets[ii];
                    }
            }
            return fastestJet.toString; 
        }

        /**********************************************************************
        SUBMODULE: calcTravelTimeJets
        IMPORT:inShip (fighterJet object), (Integer) distance
        EXPORT: timeHours (Real) 
        PURPOSE: is to calculate the tracel time of the fighter jet in hours
        **********************************************************************/
        public double calcTracvelTimeJets(FighterJet inShip, 
                                                  int distance)
        {
            double denom, timeHours;
            denom = inShip.getWingSpan * (double)inShip.getCylinders * 150.00;
            timeHours = (double)distance / denom;
        }

        /**********************************************************************
        SUBMODULE: findDuplicateSubs
        IMPORTS: none
        EXPORT: dupilicates[] (Object) 
        ASSERTION:
        **********************************************************************/
        public SubMarine [] findDuplicateSubs() 
        {
            /*The multipilcation by 2 is done because it allows the 
            duplicates array store the actual ship and it's dupilcate in 
            the indexes next to each other and the programme only to
            allowed to have 15 ships at time hence the maximum number of
            duplicates you can have is 15. Therefore, double the orginal
            amount is the maxiumum amount you can have. */

            SubMarine duplicates [] = new SubMarine[MAX_CAP * 2];
            
            for (int ii = 0 ;ii < MAX_CAP; ii++) 
            {
                /*I am starting the looping variable at one because 1 don't
                 want the programme to store itself as a dupilcate, hence
                 it will search for objects after itself*/

                for(int jj = 1 ; jj < MAX_CAP ;jj++)
                {
                    if(storeSubs[ii].equals(storeSubs[jj])) 
                    {
                        duplicates[ii] = storeSubs;
                        duplicates[jj] = storeSubs[jj];
                    }
                }
             }
            
            return duplicate; 
        }

        /**********************************************************************
        SUBMODULE: findDuplicateJets
        IMPORTS: none
        EXPORT: dupilicates[] (Object) 
        ASSERTION:
        **********************************************************************/
        public FighterJet[] findDuplicateJets() 
        {

            FighterJet duplicates [] = new FighterJet[MAX_CAP * 2]; 
            
            for (int ii = 0 ;ii < MAX_CAP; ii++) 
            {
                 /*I am starting the looping variable at one because I don't
                 want the programme to store itself as a dupilcate, hence
                 it will search for objects after itself*/

                for(int jj = 1 ; jj < storeJets.length(); jj++) 
                {
                    if (storeJets[ii].equals(storeJets[jj])) 
                    { 
                        duplicates[ii] = storeJets;
                        duplicates[jj] = storeJets[jj];
                    }
                }
                
                return duplicates;
            }
        }
        /**********************************************************************
        SUBMODULE: calcTolShips
        IMPORT: countSubs (integer), countJets (integer)
        EXPORT: tolShips (integer) 
        **********************************************************************/
        public int calcTolShips(int countSubs, int countJets)
        {
            int tolShips; 
            return tolShips = countSubs + countJets; 
        }

        //PRIVATE SUBMODULES:

        
        /**********************************************************************
        SUBMODULE: validateSub
        IMPORT: inObjct (subMarine object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inObjct is a subMarine object then it's  valid
        **********************************************************************/
        private boolean validateSub(SubMarine inObjct)
        {
            boolean isValid = false;
            if (inObjct instanceof SubMarine) 
            {
                if (inObjct != null) 
                {
                    if (checkStoreSubCapactity())
                    {
                        isValid = true;
                    }
                    else 
                    {
                        throw new IllegalArgumentException("ERROR: not "+
                                   "enough storage in the submarine storage.");
                    }
                }
                else
                {
                    throw new IllegalArgumentException("ERROR: the fields of "+
                                             "the submarine object are empty");
                } 
            }
            else
            {
                throw new IllegalArgumentException("ERROR: not a submarine");
            }
            return isValid;
        }

        /**********************************************************************
        SUBMODULE: validateJet
        IMPORT: inObjct (fighterJet object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inJet is a fighterJet object then it's valid
        **********************************************************************/
        private boolean validateJet(FighterJet inObjct)
        {
            boolean isValid = false;
            if (inObjct instanceof FighterJet) 
            {
                if (inObjct != null)
                {
                    if(checkStoreJetCapacity())
                    {
                        isValid = true;
                    }
                    else
                    {
                        throw new IllegalArgumentException ("ERROR: not " +
                                                            "enough storage "); 
                    }
                }
                else
                {
                    throw new IllegalArgumentException("ERROR: the "+
                                   "the classfields of the objects are empty"); 
                }
            }
            else 
            {
                throw new IllegalArgumentException("ERROR: not a fighterJet "+
                                                    "object");
            }
            return isValid;
        }
        /**********************************************************************
        SUBMODULE: checkStoreSubsCapacity
        IMPORT: none
        EXPORT: spaceAvail (Boolean)
        PURPOSE: to check if there's available space in the storeSub array so 
                 another ship can be added to the array
        **********************************************************************/
        public boolean checkStoreSubCapacity()
        {
            // I don't think this part of the code is correct.
            boolean spaceAvail = false;
            try 
            {
                if (storeSubs[countSubs] == null)
                    spaceAvail = true; 
                    countSubs++;
            }
            catch(IndexOutOfBoundsException err)
            {
            }
        }

        /**********************************************************************
        SUBMODULE: checkStoreJetsCapacity
        IMPORT: none 
        EXPORT: spaceAvail  (Boolean) 
        PURPOS: to check if there's available sapce in the storeJets array so 
            another ship can be added to the array 
        **********************************************************************/
        public boolean checkStoreJetsCapacity()
        {         
            boolean spaceAvail = true;
            try
            {
                if (storeJets[countJets] == null) 
                {
                    spaceAvail = true; 
                    countJets++;
                }
            }
            catch(IndexOutOfBoundsException err)
            {
            }

        }
        //OTHER METHODS:

        /**********************************************************************
        SUBMODULE: clone
        IMPORT: none
        EXPORT: cloneShipStorage (Object)
        ASSERTION: returns a cloned object of the current object
        **********************************************************************/
        public ShipStorage clone()
        {
            ShipStorage cloneShipStorage;
        
            cloneShipStorage = new ShipStorage(this.countSubs, this.countJets,
                                              this.storeSubs, this.storeJets);
            return cloneShipStorage;
        }
        /**********************************************************************
        SUBODULE: equalsArray
        IMPORT: arrayOne (Object), arrayTwo (object Two)
        EXPORT: isValid (Boolean)
        ASSERTION: if two array objects are the same class type and length, and have
                   the same objects in the array and it's valid
        **********************************************************************/
        public boolean equalsArr(Object[] arrayOne, Object[] arrayTwo)
        {
            boolean isValid = false;

            if (arrayOne.length() ==  arrayTwo.length()) 
            {
                isValid =   true;

                 /*searching through both arrays to ensure that they have
                 the same contents in the array*/

                int compareElements = 0;

                do
                {
                    isSame = arrayOne[compareElements].equals(
                                    arrayTwo[compareElements]);
                    compareElements++;
                }while(compareElements < arrayOne.length());
            }
            else
            {
                System.out.println("ERROR: the array objects are not the same");
            }
        }
        /**********************************************************************
        SUBMODULE: toStringSubArr
        IMPORT: none
        EXPORT: str [] (address of str in memory of the data type string)
        ASSERTION:
        **********************************************************************/
        public String [] toStringSubArr()
        {
                String str [] = new String [MAX_CAP];

                 /*I am subtracting one, so the for loop deosn't try to search
                 outside the indexs of the str arrays as its index starts at*/

                for (int ii = 0 ; ii < MAX_CAP;ii++) 
                {
                    str[ii] = storeSubs[ii].toString();
                }
                return str;
        }
        /**********************************************************************
        SUBMODULE: toStringJetArr
        IMPORT: none
        EXPORT: str [] (address of str in memory of the data type string)
        ASSERTION:
        **********************************************************************/
        public String [] toStringJetArr()
        {
            String str [] = new String [MAX_CAP];

             /*I am subtracting one, so the for loop doesn't try to search
             outside the indexs of the str array as its indes starts at 0*/

            for (int ii = 0 ;ii < MAX_CAP;ii++) 
            {
                str [ii] = storeSubs[ii].toString();
            }
            return str;
        }
        /**********************************************************************
        SUBMODULE: toStringArr
        IMPORT: none
        EXPORT: strArry [] (String)
        ASSERTION:
        **********************************************************************/
        public String[] toStringArr() 
        {
             /*I am adding an extra 1 to tolShipsInfo. Because, I want an
             extra index to store the summary of the ship storage units
             (i.e. how many ships they're in total. How many jets they're,
             and how many submarines they're)*/

            int tolShipsInfo = MAX_CAP * 2 + 1;

            String strArr [] = new String [tolShipsInfo];

            shipNum = calcTolShips(); 

            strArr [0] = "The hanger contains " +shipNum+ " ships. There's "+
                        +countSubs+ " submarines, and there's " +countJets+
                        "fighter jets in the hanger";

             /*I am starting the looping condition at 1, becasue the 0 index
             is reserved for the summary of the arrays, and I am subtracting
             one so the for loop doesn't try to look outside the array as
             the index of an array starts at 1*/

            for (int ii= 1 ; ii < MAX_CAP; ii++)
            {
                strArr [ii] =  storeSubs[ii].toString();
            }

             /*I used the starting index of (MAX_CAP) becasue I want to
             start adding the information of the fighter jets, to the next
             vaccant spot after the information of the submarines and it
             corresponds to MAX_CAP*/

            for (int ii = MAX_CAP ; ii < tolShipsInfo; ii++)
            {
                strArr [ii] =  storeJets[ii].toString();
            }
            return strArr;
        }
    }
