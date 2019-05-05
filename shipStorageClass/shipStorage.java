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
    }
    /*
    Alternate
        IMPORT: (subMarine object) inSub
                (fighterJet object) inJet
        EXPORT: none
        ASSERTIONS: creates an object if the imports are valid in the next array
                    index available, otherwise it will FAIL

        ALGORITHM:

            if (validateSubObjct <- inSub) 
                if (validateJetObjct <- inJet) 
                    storeSub[countSubs] = inSub
                    storeJet[countJets] = inJet
                    countSubs = countSubs + 1
                    countJets = countJets + 1

            ELSE
                FAIL
            END if ELSE

    Copy:
        IMPORT: inShipStorage (shipStorageArrayClass)
        EXPORT: none
        ASSERTION: creates an object which is identical to the imported object

        ALGORITHM:

            FOR ((interger)ii = 0 TO .length of inShipStorage.MAXSUBCAP CHANGEBY 1) 
                
                storeSubs[ii] = inShipStorage.storeSubs[ii]
            END FOR

            FOR ((interger)ii = 0 TO .length of inShipStorage.MAXJETCAP 
                CHANGEBY 1)  
                storejets[ii] = inShipStorage.storeJets[ii]
            END FOR

    ACCESSORS

    SUBMODULES: getStoreSubs
        IMPORT: none
        EXPORT: storeSubs (address of storeSubs object in memory)
        ASSERTION: returns the elements which were last store storeSubs object

    SUBMODULE: getStoreJets
        IMPORT: none
        EXPORT: storeJets (address of storeJets object in memory)
        ASSERTION: returns the elemnts which were last sttore in storeSubs object

    SUBMODULE: getLastSub
        IMPORT: none
        EXOPORT: sub (subMarine Object)

        ALGORITHM:
            COMMENT: I have subtracted one because the other constructors (i.e.
                     alternate constructor) will move the index  of the count
                     variable to the next available index, hence you have to
                     subtract one to get the last stored submarine

            sub = storeSub[countSubs - 1]

    SUBMODULE: getLastjet
        IMPORT: none
        EXPORT: jet (fighterJet object)

        ALGORITHM

            COMMENT: I have subtracted one because the other constructors (i.e.
                     alternate constructor) will move the index of the count
                     variable to the next available index, hence you have to
                     subtract one to get the last stored jet

            jet = storeJet[countJets - 1]

    MUTATORS:

    SUBMODULE: setStoreSubs
        IMPORT: inStoreSubs (address of inStoreSubs in memory) ****recondsider the inStoreSubs
        EXPORT: none
        ASSERTION: if the elements and array found at the specified address is
                   valid. setStoreJets will be valid, otherwise it will fail

        ALGORITHM:
            if (validateStoreSubs <- inStoreSubs) 
                storeSubs = inStoreSubs
            ELSE
                FAIL
            END if ELSE

    SUBMODULE: setStoreJets
        IMPORT: inStoreJets (address of inStoreJers in memorty)
        EXPORT: none
        ASSERTION: if the elements and array found at the specified adress is
                   valid. setStoreJets will be valid, otherwise it will fail

        ALGORITHM:
            if (validateStoreJets <- inStoreJets) 
                storeJets = inStoreJets
            ELSE
                FAIL
            END if ELSE

    SUBMODULE: addSub
        IMPORT: inSub (subMarine object) , countSubs (int)
        EXPORT: none
        ASSERTION: a sub will be added to storeSubs if the inSub is valid, and
                    storeSubs hasn't exceeded the MAXSUBCAP

        ALGORITHM:
            if (validateSub <- inSub) 
                if (countSubs < MAXSUBCAP) 

                    storeSubs[countSubs] = inSub

                    COMMENT: I am incrementing countSub by 1, to go to the next
                             vaccant index of the storeSub

                    countSub = countSubs + 1
                ELSE
                    FAIL "ERROR: The storage of the submarines is full."
            ELSE
                FAIL "ERROR: not a submarine"
            END if ELSE

    SUBMODULE: addJet
        IMPORT: inJet (jetFighter object) , countJets (interger)
        EXPORT: none
        ASSERTION: a jet will be added to storeJEts if the inJet is valid, and
                   storeSubs hasn't exceeded MAXJETCAP

        ALGORITHM:
            if (validateJet <- inJet) 
                if (countJets < MAXJETCAP) 

                    storeJets[countJets] = inJet

                    COMMENT: I am incemention countJets by 1, to go to the next
                             vaccant index of the storeJets

                    countJets = countJets + 1
                ELSE
                    FAIL "ERROR: storage of fighter jets is full"
            ELSE
                FAIL "ERROR: not a fighter jet"
            END if ELSE

    DOING METHODS:

    SUBMODULE: destinationCheck *** yet to be implemented

    SUBMODULE: findDuplicatesSubs
        IMPORTS: none
        EXPORT: dupilicates[] (Object) 
        ASSERTION:

        ALGORITHM:

            (object) duplicates [] = SIZE of DYNAMIC SIZING
            
            FOR ((interger) ii = 0 TO .length of storeSub - 1 CHANGEBY 1) 

                COMMENT: I am starting the looping variable at one because I don't
                         want the programme to store itself as a dupilcate, hence
                         it will search for objects after itself

                FOR((interger) jj = 1 TO .length of storeSub -1 CHANGEBY 1) 
                    if (storeSubs[ii].equals(storeSubs[jj])) 
                        duplicate[ii] = storeSubs
                        duplicate[jj] = storeSubs[jj]
                    END if
                END FOR
            END FOR

    SUBMODULE: findDuplicatesJets
        IMPORTS: none
        EXPORT: dupilicates[] (Object) 
        ASSERTION:

        ALGORITHM:

        (object) duplicates [] = SIZE of DYNAMIC SIZING
            
            FOR ((interger) ii = 0 TO .length of storeJet - 1 CHANGEBY 1) 

                COMMENT: I am starting the looping variable at one because I don't
                         want the programme to store itself as a dupilcate, hence
                         it will search for objects after itself

                FOR((interger) jj = 1 TO .length of storeJet -1 CHANGEBY 1) 
                    if (storeJets[ii].equals(storeJets[jj])) 
                        duplicate[ii] = storeJets
                        duplicate[jj] = storeJets[jj]
                    END if
                END FOR

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
                ELSE
                    System.out.println(: "ERROR: incorrect storage capacity"
            ELSE
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
                ELSE
                    System.out.println(: "ERROR: incorrect storage capacity"
            ELSE
                System.out.println(: "ERROR: not a fighter jet"
            END if ELSE

    SUBMODULE: validateSubObjct
        IMPORT: inObjct (subMarine object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inObjct is a subMarine object then it's  valid

        ALGORITHM:

            isValid = FALSE
            if (inObjct ISA subMarineClass) 
                isValid = TRUE
            ELSE
                System.out.println(: "ERROR: not a submarine"
            END if ELSE

    SUBMODULE: validateJetObjct
        IMPORT: inObjct (fighterJet object)
        EXPORT: isValid (Boolean)
        ASSERTION: if inJet is a fighterJet object then it's valid

        ALGORITHM:

            isValid = FALSE
            if (inObjct ISA fighterJetClass) 
                isValid = TRUE
            ELSE
                System.out.println(: "ERROR: not a fighter jet"
            END if ELSE

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
            if (inObj ISA shipStorageArrayClass) 
                inShipStorage = (Convert to shipStorageArrayClass)inObjct
                isSame = ((.length)storeSubs EQUALS
                          (.length)inShipStorage.getStoreSubs <- none) AND
                          ((.length)storeJets EQUALS
                          (.length)inShipStorage.getStoreJets <- none)
            END if

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
            ELSE
                System.out.println(: "ERROR: the array objects are not the same"
            END if ELSE

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
                END FOR

    SUBMODULE: toStringJet
        IMPORT: none
        EXPORT: str [] (address of str in memory of the data type string)
        ASSERTION:

        ALGORITHM:

            str [] = SIZE of MAXJETCAP

            COMMENT: I am subtracting one, so the for loop doesn't try to search
                     outside the indexs of the str array as its indes starts at 0

            FOR ((int) ii = 0 TO MAXJETCAP - 1 CHANGEBY 1) 
                str [ii] = storeSubs[ii].toString
            END FOR
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
            END FOR

            COMMENT: I used the starting index of (MAXSUBCAP) becasue I want to
                     start adding the information of the fighter jets, to the next
                     vaccant spot after the information of the submarines and it
                     corresponds to MAXSUBCAP

            FOR (MAXSUBCAP TO tolShipsInfo - 1 CHANGEBY 1
                strArry [ii] =  storeJets[ii].toString
            END FOR
*/ 
