/*****************************************************************************
AUTHOR: Tawana David Kwaramba
FILENAME: UI.java
STUDENT ID: 19476700
LAST MODIFIED:
PURPOSE: A class which is reponsible for all the user input and output.
******************************************************************************/
import java.util.*;

public class UI
    {
        //CLASS FIELDS: 
        ShipStorage storageUnit; 

        //COSTRUCTORS:

        /**********************************************************************
        Defualt:
        IMPORT: none
        EXPORT: none
        ASSERTION: creaetes a shipStorage object 
        **********************************************************************/
        public UI()
        {
            storageUnit = new ShipStorage(); 
        }

        //METHODS 
        /**********************************************************************
        SUBMODULE: inputIntMenu
        IMPORT: mssg (String)
        EXPORT: userOp (int)
        PURPOSE: to allow the user to select one of the options listed 
                 in the menu using an integer.
        **********************************************************************/
        public int InputIntMenu(String mssg)
        {
            int userOp = 0;
            boolean isValid = false;
            Scanner in = new Scanner(System.in); 
            do
            {
                try
                {
                    System.out.println(mssg); 
                    userOp = in.nextInt();
                    isValid = true;
                }
                catch(InputMismatchException err) 
                {
                    System.out.println("Please input an integer");

                    /*I am inputing nothing to clear the buffer of the
                    probalmatic problem, and to avoid the catch loop 
                    running an infinite loop.*/
                    in.nextLine();
                }
            }
            while (!isValid);

            return userOp; 
        }
        /**********************************************************************
        SUBMODULE: inputCharMenu
        IMPRORT: mssg (String) 
        EXPORT: userOP (Character)
        PURPOSE: to allow the user to select one of the options listed in the 
                 menu using a single character. 
        **********************************************************************/
        public char InputCharMenu(String mssg)
        {    
            Scanner in = new Scanner(System.in);
            char userOp = ' ';
            boolean isValid = false;
            do
            {
                try
                {
                    System.out.println(mssg);
                    userOp = in.next().charAt(0);
                    isValid = true;
                }
                catch(InputMismatchException err)
                {
                    System.out.println("Please enter a single character");
                
                    /*I am inputing nothing yo clear the buffer of the 
                    probalmatic problem. and to avoid the catch loop running 
                    an infinte loop*/
                    in.nextLine(); 
                }
            }
            while (!isValid);
    
            return userOp;
        }
SUBMODULE: getUserSerialNum
    IMPORT: none
    EXPORT: serialNum
    PURPOSE: to ask the serial number from the user, and to validate their 
             input

    ALGORITHM

        (boolean) isValid
        do
            try
                System.out.println(: "Please enter the serial number of the ship:"
                INPUT: serialNum (String)
                
                COMMENT: you can use either the submarine or fighterjet classes
                         to validate the serial number as they're excatly the
                         same
    
                IF (validateSerialNum <- serialNum) THEN
                    isValid = true
                END IF 

            catch InputMismatchException 
                System.out.println(: "ERROR: please input a valid serial numbe" 
                +error message
                isValid = false
        while ((is not equal to isValid)

SUBMODULE: getUserShipType
    IMPORT: none 
    EXPORT: shipType 
    PURPOSE: to get the ship type from the user and validate it 
    
    
        (boolean) isValid 
        do
            try       
                isValid = true
                System.out.println(: "Press the followng to enter ship type:
                         S - Submarine
                         F- - Fighter Jet "
                INPUT: shipType (character)
            catch InputMismatchException
                System.out.println( "ERROR: please input a single character 
                        +complier message
                isValid = false 
            END try catch
        while ((shipType doesn't equal to 'f' or 'F' or 'S' or 's') AND (
                not equal to isValid)

SUBMODULE: getUserCylinders
    IMPORT: none
    EXPORT: cylinders (integer) 
    PURPOSE: to get the cylinders from the user and to validate it

    
        (boolean) isValid
        do 
            try
                System.out.println(: "Number of cylinders of the ships: "
                INPUT: cylnders (integer)

                COMMENT: You can use either the submarine or fighterejet class
                         to validate the number of cylinders 

                IF (validateCylinders <- cylinders) THEN
                    isValid = true
                END IF 

            catch InputMismatchException
                System.out.println(: "ERROR: please input an interger" +complier message
                isValid = false 
            END try catch
        while (not equal to isValid)

SUBMODULES: getUserHull
    IMPORT: none
    EXPORT: hull (String) 
    PURPOSE: to get the cylinders from the user and validate it
    
    
        (boolean) isValid
        do
            try
                System.out.println(: "Enter hull of the ship: "
                INPUT: hull (Stirng)

                IF (ValidateHull <- hull) THEN
                    isValid = true
                END IF

            catch InputMismatchException
                System.out.println(: "ERROR: please input a string" +complier message
                isValid = false
            END try catch
        while(not equal to isValid)

SUBMODULES: getUserMaxDepth
    IMPORT: none
    EXPORT: depth (Real)
    PURPOSE: to get the max depth from the user and validate it

    
        (boolean) isValid
        do
            try
                System.out.println(: "Please enter the max depth of the ship"
                INPUT: depth (real)

                IF (validateMaxDepth <- depth) THEN
                    isValid = true 
                END IF
    
            catch InputMismatchException
                System.out.println(: "ERROR: please input a real number: "  
                        +complier message
                isValid = false
            END try catch
        while(not equal to isValid) 

SUBMODULES: getUserWingSpan
    IMPORT: none 
    EXPORT: wingSpan (Real)
    PURPOSE: to get the max wingspan from the user and validate it 

    
        (boolean) isValid
        do
            try
                System.out.println(: "Please enter the wingspan of the ship"
                INPUT: wingSpan (Real)
                
                IF (validateWingSpan <- wingSpan) THEN 
                    isValid = true
                END IF
            
            catch InputMismatchException
                System.out.println(: "ERROR: please input a real number: " +complier message
                isValid = false 
            END try catch 
        while (not equal to isValid)

SUBMODULES: getUserOrdance
    IMPORT: none
    EXPORT: ordance
    PURPOSE: to get the ordance from the user and validate  it

     
        (boolean) isValid
        do
            try
                System.out.println(: "Please enter the ordance of the ship: "
                INPUT: ordance (String)

                IF (validateOrdance <- ordance) THEN
                    isValid = true
                END IF

            catch InputMismatchException
                System.out.println(: "ERROR:"  +complier message
                isValid = false
            END try catch
        while (not equal to isValid)

SUBMODULE: addUserShips
    IMPORT: none 
    EXPORT: none
    PURPOSE: to allow the user to add ships manually to the programme, and the
             appopriate eror handling and validation. 

    
        
        shipType = getUserShipType <- none      
        serialNum = getUserSerialNum <- none
        year = getUserYear <- none
        cylinders = getUserCylinders <- none 

        CASE shipType
            'S':'s'
                hull = getUserHull <- none
                maxDepth = getUserMaxDepth <- none
                FileManger.createShipObjcts <- shipType, year, cylinders, fuel
                                                hull, maxDepth
            'F':'f'
                wingSpan = getUserWingSpan <- none
                ordance = getUserOrdance <- none 
                FileManger.createUserObjcts <- shipType, year, cylinders, fuel
                                                wingSpan, ordance
        END CASE 

SUBMODULE: addShipsFile
    IMPORT:
    NONE:
    PURPOSE:

     
        System.out.println(: "Please enter file name to read ships from"
        INPUT: fileName (String)
        FileManger.readFile <- fileName

OTHER METHODS

SUBMODULE: mainMenu
    IMPORT: none
    EXPORT: none
    PURPOSE: to control the structure of the main menu and to invoke the 
             appropriate methods

    
        
        do
            userOp = inputIntMenu <- (" 1. Add Ships
                                         2. View Ships
                                         3. find duplicates
                                         4. destination Check
                                         5. Load ships
                                         6. Save Ships
                                         7. Exit")
    
            IF (userOP doesn't equal to 1 or 2 or 3 or 4 or 5 or 6 or 7) THEN
                System.out.println(: "Please enter an option which is in the menu below: "
            END IF 

        while userOP doesn't equal to 1 or 2 or 3 or 4 or 5 or 6 or 7

        CASE userOP
            1:
                addShipsMenu <- none
            2: 
                viewShipsMenu <- none
            3: 
                findDuplicatesMenu <- none 
            4:
                destinationCheck <- none
            5:
                loadShips <- none
            6: 
                saveShips <- exit
            7:
                System.out.println(: "Goodbye friend"
            DEFUALT: System.out.println(: "Invalid option" 
        END CASE       

SUBMODULE: addShipsMenu
    IMPORT: none
    EXPORT: none
    PURPOSE: to invoke the appropriate methods to add ships to the programme

    
        
        do
            (int) userOp = inputIntMenu <- ("1. Add ships manually
                                                  2. Add ships from file"

            IF (userOp doesn't equal to 1 or 2) THEN
                System.out.println(: "Please enter an option which is in the menu below: "
            END IF 
        while (userOp doesn't equal 1 or 2)

        CASE userOp
            1:
                addUserShips <- none
            2:
                addShipFile <- none
            DEFUALT:
                System.out.println(: "Invalid option"

SUBMODULE: viewShips
    IMPORT: none
    EXPORT: none
    PURPOSE:

    
        do
            (int) userOp = inputIntMenu <- ("1. View all ships
                                                  2. View submarines only
                                                  3. View fighter jets 
                                                    only ")
            IF (userOp doesn't equal to 1 or 2 or 3 ) THEN
                System.out.println( "Pleae enter an option which is in the following meanu:
            END  IF
        while (userOp doesn't equal 1 or 2 or 3)
        
        CASE userOp
            1: 
                viewSubs <- none
                viewJets <-none
            2: 
                viewSubs <- none    
            3:
                viewJets <- none

SUBMPODULE: viewSubs
    IMPORT: none
    EXPORT: none
    PURPOSE:

    

        FOR ((int)ii TO shipStorage.MAXCAP (exclusive) CHANGEBY 1) THEN 
            System.out.println(: shipStorage.toStringSubArr[ii]
        END FOR

SUBMODULE: viewJets
    IMPORT: none
    EXPORT: none
    PURPOSE:

    ALGOTITHM:
        
        FOR ((int) ii TO shipStorage.MAXCAP (exclusive) CHANGEBY 1) THEN
            System.out.println(: shipStorage.toStringJetArr[ii]
        END FOR

SUBMODULE: duplicatesMenu 
    IMPORT: none
    EXPROT: none
    PURPOSE

    
        do 
            (int) userOp = inputIntMenu <- ("1. Find all duplicates
                                                  2. Find submarine 
                                                     duplicates only
                                                  3. Find fighter Jet
                                                     duplicates only")
            IF (userOp doesn't equal to 1 or 2 or 3) THEN
                System.out.println(: "please input what is in the menu below: "
            END IF
        while (userOp doesn't equal to 1 or 2 or 3 ) 

        case userOp
            1:
                displaySubDuplicates <- none
                displayJetDuplicates <- none              
            2:
                displaySubDuplicates <- none
            3:
                displayJetDuplicates <- none

SUBMODULE: displaySubDuplicates:
    IMPORT: none
    EXPORT: none
    PURPOSE:

    

        System.out.println(: "The duplicates pairs are as follows"

        FOR ((integer) ii = 0 TO shipStorage.MAXCAP * 2 CHANGEBY 1) THEN
            System.out.println(: "SubMarine [ii] " 
                    +shipStorage.findDUplcateSub[ii].toString
            FOR((integer)ii = 1 TO shipStorage.MAXCAP * 2 CHANGEBY 1) THEN
                System.out.println(: "SubMarine duplicate [ii-1] "
                        +shipStorage.findDuplicateSub[ii+1]
        END FOR

SUBMODULE: displayJetDuplicates: 
    IMPORT: none
    EXPORT: none
    PURPOSE:

    

        System.out.println(: "The duplicates pairs are as follows: "

        FOR ((integer) ii = 0 TO shipStorage.MAXCAP * 2 CHANGEBY 1) THEN
            System.out.println(: "FighterJet[ii] "
                     +shipStorage.findDuplicateJet[ii].toStringJet+ 
            FOR((integer)ii = 1 TO shipStorage.MAXCAP * 2 CHANGEBY 1) THEN
                System.out.println(: "FighterJet Duplicate [ii-1] "
                         +shipStorage.findDuplicateJet[ii+1]
        END FOR

SUBMODULE: destinationCheck
    IMPORT: none
    EXPORT: none
    PURPOSE:

    
        
        System.out.println(: "not yet implememntededed"

SUBMODULE: loadShips
    IMPORT: none
    EXPORT: none
    PURPOSE:

    
        
        System.out.println(: "Please input a fileName to load ships: "
        INPUT: fileName (String)
        FileManger.readFile(fileName) 

SUBMODULE: saveShips
    IMPORT: fileName (String)
    EXPORT: none

    
        
        System.out.println(: "Please inpu  a file

SUBMODULE: errorMssg
    IMPORT: mssg(String)
    EXPORT: errMssg (String)
    ASSERTION: returns the error message of the specific methods been called
