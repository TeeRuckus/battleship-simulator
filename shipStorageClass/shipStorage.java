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

        //COSTRUCTORS:
        
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
            if(validateSubObjct(inSub))
            {
                if(validateJetObjct(inJet))
                { 
                    storeSub[countSubs] = inSub;
                    storeJet[countJets] = inJet;
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
            private int ii;

            for(ii = 0 ; .length of inShipStorage.MAXSUBCAP ; ii++)
            {
                storeSubs[ii] = inShipStorage.storeSubs[ii];
            }
            for (ii = 0 ; .length of inShipStorage.MAXJETCAP 
                ; ii++)  
            {
                storejets[ii] = inShipStorage.storeJets[ii];
            }
        }

    //ACCESSORS

        /**********************************************************************
        SUBMODULES: getStoreSubs (subMarineClass Object) 
        IMPORT: none
        EXPORT: storeSubs (address of storeSubs object in memory)
        ASSERTION: returns the elements which were last store storeSubs object
        **********************************************************************/
        public subMarineClass getStoreSubs()
        {
            return storeSubs;
        }
        /**********************************************************************
        SUBMODULE: getStoreJets (figherJetClass Object)
        IMPORT: none
        EXPORT: storeJets (address of storeJets object in memory)
        ASSERTION: returns the elemnts which were last sttore in storeSubs object
        **********************************************************************/
        public fighterJetClass getStoreJets()
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

            return sub = storeSub[countSubs - 1]; 
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

            return jet = storeJet[countJets - 1];
        }

        //MUTATORS:

        /**********************************************************************
        SUBMODULE: setStoreSubs 
        IMPORT: inStoreSubs (subMarineClass Object) ****recondsider the inStoreSubs
        EXPORT: none
        ASSERTION: if the elements and array found at the specified address is
                   valid. setStoreJets will be valid, otherwise it will fail
        **********************************************************************/
        public void setStoreSubs(subMarineClas  inStoreSubs)
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
        public void setStoreJets(fighterJetClass inStoreJets)
        {
            if(validateStoreJets(inStoreJets))
            {
                storeJets = inStoreJets;
            }
            else
            {
                throw new IllegalArgumentExveption("\n Invalid fighter Jet "+
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
                    vaccant index of the storeSub*/
                    countSub++;
                }
                else
                {
                    throw new IllegalArgumentException("ERROR: The storage of"+
                                                   " the submarines is full.");
                }
            }
            else
            {
                throw new IllegalArgumentExeption( "ERROR: not a submarine");
            }
            
        }
        /**********************************************************************
        SUBMODULE: addJet
        IMPORT: inJet (fighterJetClass object) , countJets (interger)
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
                    throw new IndexOutOfBoundException("ERROR: storage of "+ 
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
    SUBMODULE: findDuplicatesSubs
        IMPORTS: none
        EXPORT: dupilicates[] (Object) 
        ASSERTION:

        ALGORITHM:

            (object) duplicates [] = SIZE of DYNAMIC SIZING
            
            FOR ((interger) ii = 0 TO .length of storeSub - 1 ; 1) 

                COMMENT: I am starting the looping variable at one because I don't
                         want the programme to store itself as a dupilcate, hence
                         it will search for objects after itself

                FOR((interger) jj = 1 TO .length of storeSub -1 ; 1) 
                    if (storeSubs[ii].equals(storeSubs[jj])) 
                        duplicate[ii] = storeSubs
                        duplicate[jj] = storeSubs[jj]
                     if
                 FOR
             FOR

    SUBMODULE: findDuplicatesJets
        IMPORTS: none
        EXPORT: dupilicates[] (Object) 
        ASSERTION:

        ALGORITHM:

        (object) duplicates [] = SIZE of DYNAMIC SIZING
            
            FOR ((interger) ii = 0 TO .length of storeJet - 1 ; 1) 

                COMMENT: I am starting the looping variable at one because I don't
                         want the programme to store itself as a dupilcate, hence
                         it will search for objects after itself

                FOR((interger) jj = 1 TO .length of storeJet -1 ; 1) 
                    if (storeJets[ii].equals(storeJets[jj])) 
                        duplicate[ii] = storeJets
                        duplicate[jj] = storeJets[jj]
                     if
                 FOR

    SUBMODULE: findDuplicates
        IMPORTS: none
        EXPORT: dupilicates (object)
        ASSERTION

        ALGORITHM:

        (object) duplicates [] = SIZE of DYNAMIC SIZING
       
        
        

    SUBMODULE: calcTolShips
        IMPORT: countSubs (interger), countJets (integer)
        EXPORT: tolShips

        ALGORITHM:

            tolShips = countSubs + countJets 

    PRIVATE SUBMODULES:

    SUBMODULE: validateStoreSubs
        IMPORT: inStoreObect (address of inStoreSubs in memory)
        EXPORT: isValid (Boolean)
        ASSERTION: If the address of inStoreSubs is an array of MAXSUBCAP elements,
                   and it's a SubMarine object it's a valid inStoreSubs

        ALGORITHM:

            isValid = FALSE
            if (inStoreObjct ISA subMarineClass) 
                if (inStoreObjct .length EQUALS to MAXSUBCAP)
                    isValid = TRUE
                else
                    System.out.println(: "ERROR: incorrect storage capacity"
            else
                System.out.println(: "ERROR: not a submarine"

    SUBMODULE: validateStoreJets
        IMPORT: inStoreObjct (address of inStoreJets in memory)
        EXPORT: isValid (Boolean)
        ASSERTION: if the address of inStoreJets is an array of MAXJETCAP elements,
                   and it's fighteJet object it's a valid inStoreJet

        ALGORITHM:

            isValid = FALSE
            if (inStoreObjct  ISA fighterJetClass) 
                if (inStoreObjct .length EQUALS to MAXJETCAP) 
                    isValid = TRUE
                else
                    System.out.println(: "ERROR: incorrect storage capacity"
            else
                System.out.println(: "ERROR: not a fighter jet"
             if else

    SUBMODULE: validateSubObjct
        IMPORT: inObjct (subMarine object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inObjct is a subMarine object then it's  valid

        ALGORITHM:

            isValid = FALSE
            if (inObjct ISA subMarineClass) 
                isValid = TRUE
            else
                System.out.println(: "ERROR: not a submarine"
             if else

    SUBMODULE: validateJetObjct
        IMPORT: inObjct (fighterJet object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inJet is a fighterJet object then it's valid

        ALGORITHM:

            isValid = FALSE
            if (inObjct ISA fighterJetClass) 
                isValid = TRUE
            else
                System.out.println(: "ERROR: not a fighter jet"
             if else

    OTHER METHODS:

    SUBMODULE: clone
        IMPORT: none
        EXPORT: cloneShipStorage (Object)
        ASSERTION: returns a cloned object of the current object

        ALGORITHM:
            CONSTRUCT cloneShipStorage USING ALTERNATE CONSTRUCTOR withS
                -(int) countSubs
                -(int) countJets
                -(ARRAY OF subMarine object) storeSubs []
                -(ARRAY OF fighterJet object) storeJets []

    SUBMODULE: equals
        IMPORT: inObjct (object)
        EXPORT: isSame (boolean)
        ASSERTION: two ship storages are the same if they can store submarines and
                   jets and they have the same storage capacity with the same
                   storage distrubution

        ALGORITHM:
            isSame = FALSE
            if (inObj ISA shipStorage) 
                inShipStorage = (Convert to shipStorage)inObjct
                isSame = ((.length)storeSubs EQUALS
                          (.length)inShipStorage.getStoreSubs <- none) AND
                          ((.length)storeJets EQUALS
                          (.length)inShipStorage.getStoreJets <- none)
             if

    SUBODULE: equalsArray
        IMPORT: arrayOne (Object), arrayTwo (object Two)
        EXPORT: isValid (Boolean)
        ASSERTION: if two array objects are the same class type and length, and have
                   the same objects in the array and it's valid

        ALGORITHM:

            isValid = FALSE

            if (length of arrayOne is EQUAL to length of arrayTwo) 
                isValid =   TRUE

                COMMENT: searching through both arrays to ensure that they have
                         the same contents in the array

                (int) compareElements = 0

                DO
                    isSame = arrayOne[compareElements].equals
                                                       (arrayTwo[compareElements])
                    compareElements = compareElements + 1
                WHILE isSame < .length of arrayOne
            else
                System.out.println(: "ERROR: the array objects are not the same"
             if else

     *********************** I might move this type of code straight
    to the user Intefac ***********************************************************

    SUBMODULE: toStringSubArray
        IMPORT: none
        EXPORT: str [] (address of str in memory of the data type string)
        ASSERTION:

        ALGORITHM:

                str [] = SIZE of MAXSUBCAP

                COMMENT: I am subtracting one, so the for loop deosn't try to search
                         outside the indexs of the str arrays as its index starts at
                         0

                FOR ((int) ii = 0 TO MAXSUBCAP -1 CHNAGEBY 1) 
                    st[ii] = storeSubs[ii].toString
                 FOR

    SUBMODULE: toStringJet
        IMPORT: none
        EXPORT: str [] (address of str in memory of the data type string)
        ASSERTION:

        ALGORITHM:

            str [] = SIZE of MAXJETCAP

            COMMENT: I am subtracting one, so the for loop doesn't try to search
                     outside the indexs of the str array as its indes starts at 0

            FOR ((int) ii = 0 TO MAXJETCAP - 1 ; 1) 
                str [ii] = storeSubs[ii].toString
             FOR
    *************************end of useless code ***********************************
    SUBMODULE: toStringArry
        IMPORT: none
        EXPORT: strArry [] (String)
        ASSERTION:

        ALGORITHM:

            COMMENT: I am adding an extra 1 to tolShipsInfo. Because, I want an
                     extra index to store the summary of the ship storage units
                     (i.e. how many ships they're in total. How many jets they're,
                     and how many submarines they're)

            (int) tolShipsInfo = MAXSUBCAP + MAXSUBJET + 1

            (String) strArry [] = SIZE of tolShipInfo

            str [0] = "The hanger contains " +calcTolShips+ " ships. There's "
                        +calcTolSubs+ " submarines, and there's " +calcTolJets+
                        "fighter jets in the hanger"

            COMMENT: I am starting the looping condition at 1, becasue the 0 index
                     is reserved for the summary of the arrays, and I am subtracting
                     one so the for loop doesn't try to look outside the array as
                     the index of an array starts at 1

            FOR ((int)ii= 1 TO MAXSUBCAP -1 CHNAGEBY 1
                strArry [ii] =  storeSubs[ii].toString
             FOR

            COMMENT: I used the starting index of (MAXSUBCAP) becasue I want to
                     start adding the information of the fighter jets, to the next
                     vaccant spot after the information of the submarines and it
                     corresponds to MAXSUBCAP

            FOR (MAXSUBCAP TO tolShipsInfo - 1 ; 1
                strArry [ii] =  storeJets[ii].toString
             FOR

