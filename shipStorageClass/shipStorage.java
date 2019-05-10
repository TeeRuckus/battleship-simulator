/*******************************************************************************
AUTHOR: Tawana David Kwaramba
STUDENT ID: 19476700
LAST MODIFIED:
PURPOSE: A class which stores a submarine and a fighter jet object
*******************************************************************************/
public class shipStorage
    {
        //PUBLIC CLASS CONSTANTS:

          /*I have made two maxiumum capcity to make refactoring and
            expandibility of the code easier in the future, and to allow the
            user to have a non 1:1 split of the capacity between submarines an
            jets. */

        public static final int MAXSUBCAP = 15;
        public static final int MAXJETCAP = 15;

        //CLASS FIELDS:

        private int countSubs;
        private int countJets;
        subMarineClass storeSubs [];
        fighterJetClass storeJets [];

        //COSTRUCRS:
        
        /**********************************************************************
        Defualt:
        IMPORT: none
        EXPORT: none
        ASSERTION: count varibales of zero and empty arrays of the maximum capacity
                    variables is valid defualt sate.
        **********************************************************************/
        public shipStorage()
        {
            countSubs = 0;
            countJets = 0;
            storeSubs = new subMarineClass [MAXSUBCAP];
            storeJets = new fighterJetClass [MAXJETCAP];
        }
    
        /**********************************************************************
        Alternate
        IMPORT: (subMarine object) inSub
                (fighterJet object) inJet
        EXPORT: none
        ASSERTIONS: creates an object if the imports are valid in the next array
                    index available, otherwise it will FAIL
        **********************************************************************/
        public shipStorage(subMarineClass inSub, fighterJetClass inJet)
        {
            if(validateSub(inSub))
            {
                if(validateJet(inJet))
                { 
                    storeSubs[countSubs] = inSub;
                    storeJets[countJets] = inJet;
                    countSubs = countSubs + 1; 
                    countJets = countJets + 1;
                } 
                else
                {
                    throw new IllegalArgumentException("\n Invalid Jet \n");
                }
            }
            else
            {
                throw new IllegalArgumentException("\n Invalid Submarine \n");
            }
        }

        /**********************************************************************
        Copy:
        IMPORT: inShipStorage (shipStorage)
        EXPORT: none
        ASSERTION: creates an object which is identical to the imported object
        **********************************************************************/
        public shipStorage(shipStorage inShipStorage)
        {
            //private int ii;
            int ii;
            for(ii = 0 ; ii < inShipStorage.MAXSUBCAP ; ii++)
            {
                storeSubs[ii] = inShipStorage.storeSubs[ii];
            }
            for (ii = 0 ; ii < inShipStorage.MAXJETCAP; ii++)  
            {
                storeJets[ii] = inShipStorage.storeJets[ii];
            }
        }

    //ACCESSORS

        /**********************************************************************
        SUBMODULES: getStoreSubs (subMarineClass Object) 
        IMPORT: none
        EXPORT: storeSubs (address of storeSubs object in memory)
        ASSERTION: returns the elements which were last store storeSubs object
        **********************************************************************/
        public subMarineClass [] getStoreSubs()
        {
            return storeSubs;
        }
        /**********************************************************************
        SUBMODULE: getStoreJets (figherJetClass Object)
        IMPORT: none
        EXPORT: storeJets (address of storeJets object in memory)
        ASSERTION: returns the elemnts which were last sttore in storeSubs object
        **********************************************************************/
        public fighterJetClass [] getStoreJets()
        {
            return storeJets;
        }

        /**********************************************************************
        SUBMODULE: getLastSub (subMarineClass Object) 
        IMPORT: none
        EXOPORT: sub (subMarine Object)
        **********************************************************************/
        public subMarineClass getLastSub()
        {
            /* I have subtracted one because the other constructors (i.e.
            alternate constructor) will move the index  of the count
            variable to the next available index, hence you have to
            subtract one to get the last stored submarine*/
		
            subMarineClass sub; 
            return sub = storeSubs[countSubs - 1]; 
        } 

        /**********************************************************************
        SUBMODULE: getLastjet (fighterJetClass Object)
        IMPORT: none
        EXPORT: jet (fighterJet object)
        **********************************************************************/
        public fighterJetClass getLastJet()
        {

             /*I have subtracted one because the other constructors (i.e.
             alternate constructor) will move the index of the count
             variable to the next available index, hence you have to
             subtract one to get the last stored jet*/
            fighterJetClass jet; 
            return jet = storeJets[countJets - 1];
        }

        //MUTATORS:

        /**********************************************************************
        SUBMODULE: setStoreSubs 
        IMPORT: inStoreSubs (subMarineClass Object) ****recondsider the inStoreSubs
        EXPORT: none
        ASSERTION: if the elements and array found at the specified address is
                   valid. setStoreJets will be valid, otherwise it will fail
        **********************************************************************/
        public void setStoreSubs(subMarineClass[] inStoreSubs)
        {
            if(validateStoreSubs(inStoreSubs))
            {
                storeSubs = inStoreSubs;
            }
            else 
            {
                throw new IllegalArgumentException("\n Invalid submarine "+
                                                    "storage");
            }
        }

        /**********************************************************************
        SUBMODULE: setStoreJets
        IMPORT: inStoreJets (fighterJetClass Object)
        EXPORT: none
        ASSERTION: if the elements and array found at the specified adress is
                   valid. setStoreJets will be valid, otherwise it will fail
        **********************************************************************/
        public void setStoreJets(fighterJetClass[] inStoreJets)
        {
            if(validateStoreJets(inStoreJets))
            {
                storeJets = inStoreJets;
            }
            else
            {
                throw new IllegalArgumentException("\n Invalid fighter Jet "+
                                                    "storage");
            }
        } 
        /**********************************************************************
        SUBMODULE: addSub
        IMPORT: inSub (subMarine object) , countSubs (int)
        EXPORT: none
        ASSERTION: a sub will be added to storeSubs if the inSub is valid, and
                    storeSubs hasn't exceeded the MAXSUBCAP
        **********************************************************************/
        public void addSub(subMarineClass inSub, int countSubs)
        {
            if (validateSub(inSub))
            {
                if (countSubs < MAXSUBCAP) 
                {
                    storeSubs[countSubs] = inSub; 

                    /*I am incrementing countSub by 1, to go to the next
                    vaccant index of the storeSubs*/
                    countSubs++;
                }
                else
                {
                    throw new IllegalArgumentException("ERROR: The storage of"+
                                                   " the submarines is full.");
                }
            }
            else
            {
                throw new IllegalArgumentException( "ERROR: not a submarine");
            }
            
        }
        /**********************************************************************
        SUBMODULE: addJet
        IMPORT: inJet (fighterJetClass object) , countJets (int)
        EXPORT: none
        ASSERTION: a jet will be added to storeJEts if the inJet is valid, and
                   storeSubs hasn't exceeded MAXJETCAP
        **********************************************************************/
        public void addJet(fighterJetClass inJet, int countJets)
        {
            if(validateJet(inJet))
            {
                if (countJets < MAXJETCAP) 
                {
                    storeJets[countJets] = inJet;

                    /*I am incemention countJets by 1, to go to the next
                    vaccant index of the storeJets*/
                    countJets++;
                }
                else
                {
                    throw new IndexOutOfBoundsException("ERROR: storage of "+ 
                                                       "fighter jets is full");
                }
            }
            else
            {
                throw new IllegalArgumentException("ERROR: not a fighter jet");
            }
        }

        //DOING METHODS:

        /**********************************************************************
        SUBMODULE: destinationCheck *** yet to be implemented
        **********************************************************************/
        public String destinationChec()
        {
            return "I  have not been implemented yet"; 
        }

        /**********************************************************************
        SUBMODULE: findDuplicateSubs
        IMPORTS: none
        EXPORT: dupilicates[] (Object) 
        ASSERTION:
        **********************************************************************/
        public subMarineClass [] findDuplicateSubs() 
        {
            /*this following pieces of code is going to differ from my psudo
              code. I need to research and find out if there's such a thing as
              dynamic sizing. So I am just going to set the maxium size of the
              submarines and fighter jets multiplied by two because you're not
              going to get more than that amount of duplicates */ 
             subMarineClass duplicates [] = new subMarineClass 
                                            [(MAXSUBCAP + MAXJETCAP) * 2];
            
            for (int ii = 0 ;ii <  storeSubs.length ; ii++) 
            {
                /*I am starting the looping variable at one because 1 don't
                 want the programme to store itself as a dupilcate, hence
                 it will search for objects after itself*/

                for(int jj = 1 ; jj <  storeSubs.length() ;jj++)
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
        public fighterJetClass[] findDuplicateJets() 
        {
            /*this following pieces of code is going to differ from my psudo
              code. I need to research and find out if there's such a thing as
              dynamic sizing. So I am just going to set the maxium size of the
              submarines and fighter jets multiplied by two because you're not
              going to get more than that amount of duplicates */ 

            fighterJetClass duplicates [] = new fighterJetClass 
                                            [(MAXSUBCAP + MAXJETCAP) * 2]; 
            
            for (int ii = 0 ;ii < storeJets.length() ;ii++) 
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
        SUBMODULE: findDuplicates
        IMPORTS: none
        EXPORT: dupilicates (object)
        ASSERTION
        **********************************************************************/
        /*
        ALGORITHM:

        (object) duplicates [] = SIZE of DYNAMIC SIZING
        */

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
        SUBMODULE: validateStoreSubs
        IMPORT: inStoreSub (subMarineClass) 
        EXPORT: isValid (Boolean)
        ASSERTION: If the address of inStoreSubs is an array of MAXSUBCAP elements,
                   and it's a SubMarine object it's a valid inStoreSubs
        **********************************************************************/
        private boolean validateStoreSubs(subMarineClass inStoreSub)
        {
            boolean isValid = false;
            if (inStoreSub instanceof subMarineClass) 
            {
                if (inStoreObjct.length() == MAXSUBCAP)
                {
                    isValid = true;
                }
                else
                {
                    System.out.println("ERROR: incorrect storage capacity");
                }
            }
            else
            {
                System.out.println("ERROR: not a submarine");
            }
            return isValid; 
        }

        /**********************************************************************
        SUBMODULE: validateStoreJets
        IMPORT: inStoreJets (fighterJetClass)
        EXPORT: isValid (Boolean)
        ASSERTION: if the address of inStoreJets is an array of MAXJETCAP elements,
                   and it's fighteJet object it's a valid inStoreJet
        **********************************************************************/
        private boolean validateStoreJets(fighterJetClass inStoreJets)
        {
            boolean isValid = false;
            if (inStoreJets instanceof fighterJetClass) 
            {
                if (inStoreJets.length() == MAXJETCAP) 
                {
                    isValid = true;
                }
                else
                {
                    System.out.println("ERROR: incorrect storage capacity");
                }
            }
            else
            {
                System.out.println("ERROR: not a fighter jet");
            }
            return isValid;
        }
        /**********************************************************************
        SUBMODULE: validateSub
        IMPORT: inObjct (subMarine object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inObjct is a subMarine object then it's  valid
        **********************************************************************/
        private boolean validateSub(subMarineClass inObjct)
        {
            boolean isValid = false;
            if (inObjct instanceof subMarineClass) 
            {
                isValid = true;
            }
            else
            {
                System.out.println("ERROR: not a submarine");
            }
            return isValid;
        }

        /**********************************************************************
        SUBMODULE: validateJet
        IMPORT: inObjct (fighterJet object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inJet is a fighterJet object then it's valid
        **********************************************************************/
        private boolean validateJet(fighterJetClass inObjct)
        {
            boolean isValid = false;
            if (inObjct instanceof fighterJetClass) 
            {
                isValid = true;
            }
            else
            {
                System.out.println("ERROR: not a fighter jet");
            }
            return isValid;
        }
        //OTHER METHODS:

        /**********************************************************************
        SUBMODULE: clone
        IMPORT: none
        EXPORT: cloneShipStorage (Object)
        ASSERTION: returns a cloned object of the current object
        **********************************************************************/
        public shipStorage clone()
        {
            shipStorage cloneShipStorage;
        
            cloneShipStorage = new shipStorage(this.countSubs, this.countJets,
                                              this.storeSubs, this.storeJets);
            return cloneShipStorage;
        }

        /**********************************************************************
        SUBMODULE: equals
        IMPORT: inObjct (object)
        EXPORT: isSame (boolean)
        ASSERTION: two ship storages are the same if they can store submarines and
                   jets and they have the same storage capacity with the same
                   storage distrubution
        **********************************************************************/
        public boolean equals(Object inObjct)
        {
            boolean isSame = false;
            if (inObjct instanceof shipStorage) 
            {
                shipStorage inShipStorage = (ShipStorage)inObjct;
                isSame = ((storeSubs.length()).equals(
                            inShipStorage.getStoreSubs()) && 
                            (storeJets.length()).equals(
                            inShipStorage.getStoreJets()));
            }
            return isSame;
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

     /************************ I might move this type of code straight
    to the user Intefac ****************************************************/

        /**********************************************************************
        SUBMODULE: toStringSubArr
        IMPORT: none
        EXPORT: str [] (address of str in memory of the data type string)
        ASSERTION:
        **********************************************************************/
        public String [] toStringSubArr()
        {
                String str [] = new String [MAXSUBCAP];

                 /*I am subtracting one, so the for loop deosn't try to search
                 outside the indexs of the str arrays as its index starts at*/

                for (int ii = 0 ; ii < MAXSUBCAP;ii++) 
                {
                    str[ii] = storeSubs[ii].toString();
                }
                return str;
        }
        /**********************************************************************
        SUBMODULE: toStringJet
        IMPORT: none
        EXPORT: str [] (address of str in memory of the data type string)
        ASSERTION:
        **********************************************************************/
        public String [] toStringJet()
        {
            String str [] = new String [MAXJETCAP];

             /*I am subtracting one, so the for loop doesn't try to search
             outside the indexs of the str array as its indes starts at 0*/

            for (int ii = 0 ;ii < MAXJETCAP;ii++) 
            {
                str [ii] = storeSubs[ii].toString();
            }
            return str;
        }
    /*************************end of useless code ****************************/
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

            int tolShipsInfo = MAXSUBCAP + MAXJETCAP + 1;

            String strArr [] = new String [tolShipsInfo];

            shipNum = calcTolShips(); 

            strArr [0] = "The hanger contains " +shipNum+ " ships. There's "+
                        +countSubs+ " submarines, and there's " +countJets+
                        "fighter jets in the hanger";

             /*I am starting the looping condition at 1, becasue the 0 index
             is reserved for the summary of the arrays, and I am subtracting
             one so the for loop doesn't try to look outside the array as
             the index of an array starts at 1*/

            for (int ii= 1 ; ii < MAXSUBCAP; ii++)
            {
                strArr [ii] =  storeSubs[ii].toString();
            }

             /*I used the starting index of (MAXSUBCAP) becasue I want to
             start adding the information of the fighter jets, to the next
             vaccant spot after the information of the submarines and it
             corresponds to MAXSUBCAP*/

            for (int ii = MAXSUBCAP ; ii < tolShipsInfo; ii++)
            {
                strArr [ii] =  storeJets[ii].toString();
            }
            return strArr;
        }
    }