/*****************************************************************************
AUTHOR: Tawana David Kwaramba
FILENAME: UI.java
STUDENT ID: 19476700
LAST MODifIED:
PURPOSE: A class which is reponsible for all the user input and output.
******************************************************************************/
import java.util.*;

public class UI
    {
        //Class constants. COPIED FROM SubMarine NEEDS to be DELETED
        public static final String STEEL = "STEEL";
        public static final String ALLY = "ALLOY";
        public static final String TTNM = "TITANIUM";
        public static final String BATRY = "BATTERY";
        public static final String DSL = "DIESEL";
        public static final String BIO = "BIO";


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
                 in the menu using an int.
        **********************************************************************/
        public int inputIntMenu(String mssg)
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
                    System.out.println("\nPlease input a number which is the "+
                                       "menu below\n");

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
        SUBMODULE: inputStringMenu
        IMPORT: mssg (String)
        EXPORT: userOp (String)
        PURPOSE: to allow the user to select one of the options listed 
                 in the menu using an int.
        **********************************************************************/
        public String inputStringMenu(String mssg)
        {
            Scanner in = new Scanner(System.in);
            boolean isValid = false;
            String userOp = "";
            do
            {
                try 
                {
                    System.out.print(mssg);
                    userOp = in.nextLine();
                    isValid = true;
                }
                catch(InputMismatchException err)
                {
                    System.out.println("\nERROR: please input a valid "+
                                       "string\n");
                }
            }while(!isValid);

            return userOp;
        }
        /**********************************************************************
        SUBMODULE: inputCharMenu
        IMPRORT: mssg (String) 
        EXPORT: userOP (Character)
        PURPOSE: to allow the user to select one of the options listed in the 
                 menu using a single character. 
        **********************************************************************/
        public char inputCharMenu(String mssg)
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
                    System.out.println("\nPlease enter a character in the "+
                                       "menu below\n");
                
                    /*I am inputing nothing to clear the buffer of the 
                    probalmatic problem. and to avoid the catch loop running 
                    an infinte loop*/
                    in.nextLine(); 
                }
            }
            while (!isValid);
    
            return userOp;
        }
        /**********************************************************************
        SUBMODULE: getUserSerialNum
        IMPORT: none
        EXPORT: serialNum (Real)
        PURPOSE: to ask the serial number from the user, and to validate their 
                 input
        **********************************************************************/
        public double getUserSerialNum()
        {
            Scanner in = new Scanner(System.in);
            double serialNum = 000.000; 
            boolean isValid = false;
            do
            {   
                try
                {
                    System.out.print("\nEnter the serial number of "+
                                       "the ship: ");
                    serialNum = in.nextDouble();
                    
                    /*you can use either the submarine or fighterjet classes
                    to validate the serial number as they're excatly the
                    same*/ 
        
                    if (validateSerialNum(serialNum))
                    {
                        isValid = true;
                    }
                    else
                    {
                        System.out.println("\nPlease input a valid serial "+
                                           "number\n-The whole part of the "+
                                           "serial number must be between 100"+
                                           " - 300 (Inclusive)\n-the decimal"+
                                           " part must be between 001 to 999"+
                                           " (inclusive).\n");
                    }
                }
                catch(InputMismatchException err)
                {
                    System.out.println("ERROR: please input a valid "+
                                         "serial number: " +err.getMessage());
                    in.nextLine();
                    isValid = false; 
                }
            }while (!isValid);
            return serialNum;
        }

        /**********************************************************************
        SUBMODULE: getUserShipType
        IMPORT: none 
        EXPORT: shipType (Character)
        PURPOSE: to get the ship type from the user and validate it 
        **********************************************************************/
        public char getUserShipType()
        {
            char shipType = ' '; 
            do
            {
                shipType = inputCharMenu("\nPress the followng to enter "+
                                         "ship type:\nS - Submarine\n"+
                                          "F- - Fighter Jet "); 
                
                if((shipType != 'f') && (shipType != 'F') && (shipType !=  'S') 
                    && (shipType != 's'))
                {
                    System.out.println("\nERROR: please input an option which"+
                                       " is in the menu below\n");
                }
            }
            while ((shipType != 'f') && (shipType != 'F') &&
                     (shipType !=  'S') && (shipType != 's'));
            
            return shipType;
        }

        /**********************************************************************
        SUBMODULE: getUserCylinders
        IMPORT: none
        EXPORT: cylinders (int) 
        PURPOSE: to get the cylinders from the user and to validate it
        **********************************************************************/
        public int getUserCylinders()
        {    
            Scanner in = new Scanner(System.in);
            int cylinders = 0;
            do 
            {
                    System.out.print("\nNumber of cylinders of the ships: ");
                    cylinders = in.nextInt();
            
                    if(!(validateCylinders(cylinders)))
                    {
                        System.out.println("\nERROR:Please ensure cylinders "+
                                           "is between 2 and 20 (inclusive)");
                    }

            }while (!(validateCylinders(cylinders)));
            
            return cylinders;
        }

        /**********************************************************************
        SUBMODULES: getUserHull
        IMPORT: none
        EXPORT: hull (String) 
        PURPOSE: to get the cylinders from the user and validate it
        **********************************************************************/
        public String getUserHull()
        {    
            String hull = "";
            do
            {
                    hull = inputStringMenu("\nEnter hull of the ship: ");
                    if (!(validateHull(hull)))
                    {
                        System.out.println("\nERROR: please enter one of the "+
                                           "following hull's\n-steel\n-alloy"+
                                           "\n-titanium");
                    }
            }while(!(validateHull(hull)));
            
            return hull;
        }
        /**********************************************************************
        SUBMODULES: getUserMaxDepth
        IMPORT: none
        EXPORT: depth (Real)
        PURPOSE: to get the max depth from the user and validate it
        **********************************************************************/
        public double getUserMaxDepth()
        {    
            Scanner in = new Scanner(System.in);
            double depth = 0;
            boolean isValid = false;
            do
            {
                try
                {
                    System.out.print("\nPlease enter the max depth of "+
                                        "the ship: ");
                    depth = in.nextDouble();
                    if (validateMaxDepth(depth))
                    {
                        isValid = true;
                        System.out.println("ERROR: Please entet a max depth "+
                                        "between -500 to 0 meters (inclusive");
                    }
                }
                catch(InputMismatchException err)
                {
                    System.out.print("ERROR: please input a valid max depth: "+
                                        err.getMessage());
                    isValid = false;
                }
            }while(!isValid);
            
            return depth;
        }
        /**********************************************************************
        SUBMODULES: getUserWingSpan
        IMPORT: none 
        EXPORT: wingSpan (Real)
        PURPOSE: to get the max wingspan from the user and validate it 
        **********************************************************************/
        public double getUserWingSpan()
        {
            Scanner in = new Scanner(System.in); 
            double wingSpan = 0; 
            boolean isValid = false;
            do
            {
                try
                {
                    System.out.print("\nPlease enter the wingspan of the "+
                                        "ship: ");
                    wingSpan = in.nextDouble();
                    if (validateWingSpan(wingSpan))
                    {
                        isValid = true;
                    }
                }
                catch(InputMismatchException err)
                {
                    System.out.print("ERROR: please input a valid wingspan: "+
                                        err.getMessage());
                    isValid = false; 
                }
            }while (!isValid);

            return wingSpan; 
        }

        /**********************************************************************
        SUBMODULES: getUserOrdance
        IMPORT: none
        EXPORT: ordance (String)
        PURPOSE: to get the ordance from the user and validate  it
        **********************************************************************/
        public String getUserOrdance()
        {
            Scanner in = new Scanner(System.in);
            String ordance = "";
            boolean isValid = false;
            do
            {
                try
                {
                    System.out.print("\nPlease enter the ordance of the "+
                                       "ship: ");
                    ordance = in.nextLine();
                    if (validateOrdance(ordance))
                    {
                        isValid = true; 
                    }
                }
                catch(InputMismatchException err)
                {
                    System.out.println("ERROR: please enter a valid ordance: "+
                                       err.getMessage()); 
                    isValid = false; 
                }
            }while (!isValid);

            return ordance; 
        }
        /**********************************************************************
        SUBMODULE: getUserYear
        IMPORT: none
        EXPORT: year (Integer)
        
        **********************************************************************/
        public int getUserYear()
        {
            Scanner in = new Scanner(System.in);
            int year = 0;
            boolean isValid = false;
            do
            {
                try
                { 
                    System.out.print("\nPlease enter the manfacture year of "+
                                     "the ship: ");
                    year = in.nextInt();
                    if(validateYear(year))
                    {
                        isValid = true;
                    }
                }
                catch(InputMismatchException err)
                {
                    System.out.print("ERROR: please enter a integer: "+
                                        err.getMessage()+ "\n");
                    isValid = false;
                }
            }while(!isValid);
        
            return year;
        }
        /**********************************************************************
        SUBMODULE: getUserFuel
        IMPORT: none
        EXPORT: fuel
        
        **********************************************************************/
        public String getUserFuel()
        {
            Scanner in = new Scanner(System.in);
            String fuel = "";
            boolean isValid = false;
            do
            {
                try
                {
                    System.out.print("\nPlease enter the fuel of the ship: ");
                    fuel = in.nextLine();
                    if(validateFuel(fuel))
                    {
                        isValid = true;
                    }
                }
                catch(InputMismatchException err)
                {
                    System.out.print("ERROR: please enter a valid string: "+
                                        err.getMessage()+ "\n");
                    isValid = false;
                }
            }while(!isValid);
            
            return fuel;
        }
        /**********************************************************************
        SUBMODULE: addUserShips
        IMPORT: none 
        EXPORT: none
        PURPOSE: to allow the user to add ships manually to the programme, and the
                 appopriate eror handling and validation. 
        **********************************************************************/
        public void addUserShips()
        {
            String[] shipDetails = new String[7];

            shipDetails[0] = Character.toString(getUserShipType());
            shipDetails[1] = Double.toString(getUserSerialNum());
            shipDetails[2] = Integer.toString(getUserYear());
            shipDetails[3] = Integer.toString(getUserCylinders());
            shipDetails[4] = getUserFuel();
            switch(shipDetails[0].charAt(0))
            {
                case 'S': case 's':
                    shipDetails[5] = getUserHull();
                    shipDetails[6] = Double.toString(getUserMaxDepth());
                    FileManger.createShipObjcts(shipDetails, storageUnit); 
                    break;
                case 'F': case'f':
                    shipDetails[5] = Double.toString(getUserWingSpan());
                    shipDetails[6] = getUserOrdance(); 
                    FileManger.createShipObjcts(shipDetails, storageUnit);
                    break;
                default:
                    
                    break;
            }
        }
        /**********************************************************************
        SUBMODULE: addShipsFile
        IMPORT:
        NONE:
        PURPOSE:
        **********************************************************************/
        public void addShipsFile()
        {
            Scanner in = new Scanner(System.in);
            String fileName;
            System.out.print("\nPlease enter file name to read ships from:\n");
            fileName = in.nextLine();
            FileManger.readFile(fileName, storageUnit);
        }

        //OTHER METHODS
        /**********************************************************************
        SUBMODULE: mainMenu
        IMPORT: none
        EXPORT: none
        PURPOSE: to control the structure of the main menu and to invoke the 
                 appropriate methods
        **********************************************************************/
        public void mainMenu()
        {
            int userOp;
            do
            {
                userOp = inputIntMenu("\n 1. Add Ships\n"+
                                      " 2. View Ships\n"+
                                      " 3. find duplicates\n"+
                                      " 4. destination Check\n"+
                                      " 5. Load ships\n"+
                                      " 6. Save Ships\n"+
                                      " 7. Exit");
                switch(userOp)
                {
                    case 1:
                        addShipsMenu();
                        break;
                    case 2: 
                        viewShipsMenu();
                        break;
                    case 3: 
                        findDuplicatesMenu();
                        break;
                    case 4:
                        destinationCheck();
                        break;
                    case 5:
                        loadShips();
                        break;
                    case 6: 
                        saveShips();
                        break;
                    case 7:
                        System.out.println("\nGoodbye friend\n");
                        break;
                    default:
                        System.out.println("\nERROR: Please enter an option "+
                                           "which is in the menu below:\n ");
                        break;
                }

            }while((userOp != 1) && (userOp != 2) && (userOp != 3) && 
                   (userOp != 4) && (userOp != 5) && (userOp != 6) &&
                   (userOp != 7));

        }
        /**********************************************************************
        SUBMODULE: addShipsMenu
        IMPORT: none
        EXPORT: none
        PURPOSE: to invoke the appropriate methods to add ships to the programme
        **********************************************************************/
        public void addShipsMenu()
        {
            int userOp;
            do
            {
                userOp = inputIntMenu("\n1.Add ships manually\n"+
                                          "2. Add ships from file");
                    switch(userOp)
                    {
                       case 1:
                                addUserShips();
                                break;
                       case 2:
                                addShipsFile();
                                break;
                        default:
                            System.out.println("\nPlease enter an option "+
                                            " which is in the menu below:\n");
                            break;
                    }

            }while ((userOp !=  1) && (userOp != 2));

        }
        /**********************************************************************
        SUBMODULE: viewShips
        IMPORT: none
        EXPORT: none
        PURPOSE:
        **********************************************************************/
        public void viewShipsMenu() 
        {
            int userOp;
            do
            {
                userOp = inputIntMenu("1. View all ships\n"+
                                          "2. View submarines only\n"+
                                          "3. View fighter jets only ");
                switch(userOp)
                {
                   case 1: 
                        viewSubs();
                        viewJets();
                        break;
                   case 2: 
                        viewSubs();   
                        break;
                   case 3:
                        viewJets();
                        break;
                    default:
                        System.out.println("\nPleae enter an option which is "+
                                            "in the following menu.\n");
                        break; 
                }
            }while ((userOp != 1) && (userOp != 2) && (userOp != 3));
            
        }

        /**********************************************************************
        SUBMPODULE: viewSubs
        IMPORT: none
        EXPORT: none
        PURPOSE:
        **********************************************************************/
        public void viewSubs()
        {
            String [] shipStrs = new String [storageUnit.MAX_CAP];
            shipStrs = storageUnit.toStringSubArr();

            for(int ii = 0; ii < storageUnit.MAX_CAP; ii++)  
            {
                System.out.println(shipStrs[ii]);
            }
        }
        /**********************************************************************
        SUBMODULE: viewJets
        IMPORT: none
        EXPORT: none
        PURPOSE:
        **********************************************************************/
        public void viewJets()
        {
            String [] shipStrs = new String [storageUnit.MAX_CAP];
            shipStrs = storageUnit.toStringJetArr();
            for(int ii = 0; ii < storageUnit.MAX_CAP; ii++) 
            {
                System.out.println(shipStrs);
            }
        }
        /**********************************************************************
        SUBMODULE: duplicatesMenu 
        IMPORT: none
        EXPROT: none
        PURPOSE
        **********************************************************************/
        public void findDuplicatesMenu()
        {
            int userOp;
            do 
            {
                userOp = inputIntMenu("1. Find all duplicates\n"+
                                      "2. Find submarine duplicates only\n"+
                                      "3. Find fighter Jet duplicates only");
                switch(userOp)
                {
                   case 1:
                        displaySubDuplicates();
                        displayJetDuplicates();              
                        break;
                   case 2:
                        displaySubDuplicates();
                        break;
                   case 3:
                        displayJetDuplicates();
                        break;
                    default:
                        System.out.println("\nplease input what is in the "+
                                           "menu below\n");
                        break; 
                }
            }while((userOp != 1) && (userOp != 2) && (userOp != 3));

        }
        /**********************************************************************
        SUBMODULE: displaySubDuplicates:
        IMPORT: none
        EXPORT: none
        PURPOSE:
        **********************************************************************/
        public void displaySubDuplicates()
        {
            SubMarine[] duplicates = new SubMarine[storageUnit.MAX_CAP * 2];
            duplicates = storageUnit.findDuplicateSubs();
            System.out.println("The duplicates pairs are as follows");

            for(int ii = 0; ii < storageUnit.MAX_CAP * 2; ii++)
            {
                System.out.println("SubMarine["+ii+"]\n" +
                                   duplicates[ii].toString());
                for(int jj = 1; jj < storageUnit.MAX_CAP * 2; jj++) 
                {
                    System.out.println("SubMarine duplicate ["+(jj-1)+"]\n" +
                                        duplicates[jj].toString());
                }
            }
        }
        /**********************************************************************
        SUBMODULE: displayJetDuplicates: 
        IMPORT: none
        EXPORT: none
        PURPOSE:
        **********************************************************************/
        public void displayJetDuplicates()
        {
            FighterJet[] duplicates = new FighterJet[storageUnit.MAX_CAP * 2];
            duplicates = storageUnit.findDuplicateJets();
            System.out.println("The duplicates pairs are as follows: ");

            for(int ii = 0; ii < storageUnit.MAX_CAP * 2; ii++) 
            {
                System.out.println("FighterJet [ii]\n" +
                                   duplicates[ii].toString()); 
                for(int jj = 1; jj < storageUnit.MAX_CAP * 2; jj++) 
                {
                    System.out.println("FighterJet Duplicate [jj-1] "+
                                          duplicates[jj].toString());
                }
            }
        }
        /**********************************************************************
        SUBMODULE: destinationCheck
        IMPORT: none
        EXPORT: none
        PURPOSE:
        **********************************************************************/
        public void destinationCheck()
        {
            System.out.println("not yet implememntededed");
        }
        /**********************************************************************
        SUBMODULE: loadShips
        IMPORT: none
        EXPORT: none
        PURPOSE:
        **********************************************************************/
        public void loadShips()
        {  
            Scanner in = new Scanner(System.in);
            String fileName;

            System.out.print("Please input a file name to load ships: ");
            fileName = in.nextLine();
            FileManger.readFile(fileName, storageUnit); 
        }

        /**********************************************************************
        SUBMODULE: saveShips
        IMPORT: fileName (String)
        EXPORT: none
        **********************************************************************/
        public void saveShips()
        {
            Scanner in = new Scanner(System.in);
            String fileName;

            System.out.print("Please input a file name to save ships: "); 
            fileName = in.nextLine();
            FileManger.writeFile(fileName, storageUnit);
        }
    
        //METHODS COPIED FROM ANOTHER CLASS. THESE NEED; ii BE DELETED
        private boolean validateSerialNum(double inSerialNum)
        {
            int wholePart, decimalPart;
            boolean isValid = false;

            wholePart = (int)inSerialNum;
            decimalPart = (int)(inSerialNum * 1000) % 1000;
            if ((wholePart >= 100) && (wholePart <= 300))
            {
                if((1 <= decimalPart) && (decimalPart <= 999))
                {
                    isValid = true;
                }
            }
            return isValid;

        }
 private boolean validateYear(int inYear)
        {
            boolean isValid = false;

            if (inYear >= 1950 && inYear <= 2022)
            {
                isValid = true;
            }

            return isValid;
        }
private boolean validateHull(String inHull)
        {
            boolean isValid = false;

            if(inHull.equals(STEEL) || inHull.equals(ALLY) ||
               inHull.equals(TTNM))
            {
                isValid = true;
            }

            return isValid;
        }
private boolean validateMaxDepth(double inMaxDepth)
        {
            boolean isValid = false;

            if(inMaxDepth >= -500 && inMaxDepth <= 0)
            {
                isValid = true;
            }

            return isValid;
        }
private boolean validateOrdance(String inOrdance)
        {
            boolean isValid = false;
            if (inOrdance.length() != 0)
            {
                isValid = true;
            }

            return isValid;
        }
 private boolean validateWingSpan(double inWingSpan)
        {
            /*
            boolean isValid = false;
            if(inWingSpan >= 2.2 && inWingSpan <= 25.6)
            {
                isValid = true;            
            }
            return isValid;
            */
            return ((inWingSpan >= 2.2) && (inWingSpan <= 25.6));
        }
  private boolean validateCylinders(int inCylinders)
        {
            boolean isValid = false;

            if(inCylinders >= 2 && inCylinders <= 20)
            {
                isValid = true;
            }
            return isValid;
        }
private boolean validateFuel(String inFuel)
{
    boolean isValid = false;
    if (inFuel.equals(BATRY) || inFuel.equals(DSL) || inFuel.equals(BIO))
    {
        isValid = true;
    }

    return isValid;
}
    }
