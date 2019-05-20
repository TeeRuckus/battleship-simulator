/*****************************************************************************
AUTHOR: Tawana David Kwaramba
FILENAME: UI.java
STUDENT ID: 19476700
LAST MODifIED:
PURPOSE: A class which is reponsible for all the user input and output.
******************************************************************************/
import java.io.*;
public class FileManger
{

    //public constants, these needs to be deleted later
    public static final String BATRY = "BATTERY";
    public static final String DSL = "DIESEL";
    public static final String BIO = "BIO";
    public static final String STEEL = "STEEL";
    public static final String ALLY = "ALLOY";
    public static final String TTNM = "TITANIUM";
    //STATIC METHODS

    /**************************************************************************
    SUMBODULE: readFile
    IMPORT: fileName (String)
    EXPORT: none
    PURPOSE: to read and prcess the contents of a file
    **************************************************************************/
    public static void readFile(String fileName, ShipStorage storageUnit)
    {
        //Psudo code adapted from lecture 5 of OOPD 
    
        String line;
        int lineNum = 1;
        FileInputStream strm = null;
        InputStreamReader  rdr;
        BufferedReader buffRdr;
        try 
        {
            strm = new FileInputStream(fileName);
            rdr = new InputStreamReader(strm); 
            buffRdr = new BufferedReader(rdr);

            lineNum = 1;
            line = buffRdr.readLine();
            
            /*I am miultiplying MAX_CAP by 2 because there's 2 storage 
            units of for submarines and jets.*/

            while(line != null && lineNum < ShipStorage.MAX_CAP * 2) 
            {
                lineNum++;
                line = buffRdr.readLine();
                processLine(line, storageUnit);
            } 
            strm.close();
        }
        catch(IOException err)
        {
            System.out.println("File not found");
            if(strm != null)  
            {
                try
                {
                    strm.close();
                }
                catch(IOException err2) 
                { }        
            }
        }
    }
    /**************************************************************************
    SUBMODULE: writeFile
    IMPORT: fileName (String)
    EXPORT: none
    PURPOSE: to write the contents in the submarine object to a file
    **************************************************************************/
    public static void writeFile(String fileName, ShipStorage storageUnit) 
    {
        //psudo code adapted from lecture 5 of OOPD     
        FileOutputStream strm = null;
        PrintWriter pw; 
        try
        {
            strm = new FileOutputStream(fileName);
            pw = new PrintWriter(strm);
            for(int ii = 0; ii < ShipStorage.MAX_CAP; ii++) 
            {
                pw.println(storageUnit.storeSubs[ii].toFileString());
            } 
            for(int ii = 0; ii < ShipStorage.MAX_CAP; ii++) 
            {
                pw.println(storageUnit.storeJets[ii].toFileString());
            } 
            pw.close();           
        }
        catch( IOException err)
        {
            if(strm != null) 
            {
                try
                {
                    strm.close();
                }
                catch(IOException err2)
                {} //nothing we can do about it
            }
        }
    }
    /**************************************************************************
    SUBMODULE: processLine
    IMPORT: line (String)
    EXPORT: none 
    **************************************************************************/
    public static void processLine(String line, ShipStorage storageUnit)
    {
        //this was adapted from OOPD worksheet 8: REFERENCE THIS LATER
        String[] lineContents = new String[7]; 
        lineContents = line.split(",");
        //lineContents [] = line.split(",") ;

        if(validateLine(lineContents))
        {
            createShipObjcts(lineContents, storageUnit); 
        }
    }
         
    /**************************************************************************
    SUBMODULE: createShipObjcts 
    IMPORT: lineContents [] (Strings) 
    EXPORT: none
    PURPOSE: to create the ship objects from the file information once it has
             been all validated 
    **************************************************************************/
    public static void createShipObjcts(String[] lineContents, ShipStorage 
                                        storageUnit)
    {   
        char shipType;
        String serialNum;
        double maxDepth, wingSpan;
        int year, cylinders;
        String fuel, hull, ordance; 
        shipType = lineContents[0].charAt(0);
        //intiliasing the variables to 0 or nothing, to allow java to compile    
        shipType = '\0'; //is this the correct way to set it to nothing
        serialNum = "";
        maxDepth = 0.0;
        wingSpan = 0.0;
        year = 0;
        cylinders = 0;
        fuel = ""; 
        ordance = "";
        
        /*this is not an integer anymore, it's a string which you're 
        parsing to a double number*/
        
        if(validateYear(Integer.parseInt(lineContents[2])))
        {
            if(validateCylinders(Integer.parseInt(lineContents[3])))
            {
                if(validateFuel(lineContents[4]))
                {
                    year = Integer.parseInt(lineContents[2]);
                    cylinders = Integer.parseInt(lineContents[3]);
                    fuel = lineContents[4];
                }
            }
        }       
        Engine egine = new Engine(cylinders, fuel);
        switch (Character.toUpperCase(shipType))
        {
            case 'S':
                if(validateHull(lineContents[5]))
                {
                    if(validateMaxDepth(Double.parseDouble(lineContents[6])))
                    {
                        hull = lineContents[5];
                        maxDepth = Double.parseDouble(lineContents[6]); 
                        SubMarine sub = new SubMarine(serialNum, year, hull, 
                                        maxDepth, new Engine(cylinders, fuel));
                        storageUnit.addShip(sub); 
                    }
                }
                
                break; 
            case 'F':
                if(validateWingSpan(Double.parseDouble(lineContents[5])))
                {
                    if(validateOrdance(lineContents[6]))
                    {
                        wingSpan = Double.parseDouble(lineContents[5]);
                        ordance = lineContents[6];
                        FighterJet jet = new FighterJet(serialNum, year,
                               ordance, wingSpan, new Engine(cylinders, fuel));
                        storageUnit.addShip(jet); 
                    }
                }
        
                break;
            default:
                throw new IllegalArgumentException ("Invalid ship Type");
        }
    }
/*
SUBMODULE: searchDir
    IMPORT: none 
    EXPORT: directoryContents []
    ASSERTION:

    :

    COMMENT: code adapted from:
     https://www.mkyong.com/java/java-how-to-list-all-files-in-a-directory/
*/

    //PRIVATE  SUBMODULES:

    /**************************************************************************
    SUBMODULE: validateLine
    IMPORT: lineContents [] (String)
    EXPORT: none 
    ASSERTION: if the line is invalid the programme will fail.
    **************************************************************************/
    public static boolean validateLine(String[] lineContents)
    {
        boolean isValid = true;

        if(lineContents.length != 7)
        {
            throw new IllegalArgumentException("ERROR: incorrect file format "+
                                               "the line must contain 7 "+
                                               "elements");
        }
         
        if(lineContents[0].length() != 1)
        {
            throw new IllegalArgumentException("ERROR: incorrect ship "+
                                               "identifier length"); 
        }
        
        return isValid; 
    }


    // coopy and pasted, theese methods needs to be deleted
    /***********************************************************************
    SUBMODULE: validateSerialNum
    IMPORT: inSerialNum (Real)
    EXPORT: isValid (Boolean)
    ASSERTION: validates serial numbers as true whereby its first three
               digits are between 100 to 300 (inclusive), and the last three
               digits are between 001 - 999 (inclusive), otherwise it will
               validate them as false.
    ***********************************************************************/
    private static boolean validateSerialNum(double inSerialNum)
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
    /***********************************************************************
    SUBMODULE: validateYear
    IMPORT: inYear (intergers)
    EXPORT: isValid (Boolean)
    ASSERTION: A commission year between 1950 to 2022 (interger) will be
                   valid, otherwise an error will be thrown to the user
    **********************************************************************/
    private static boolean validateYear(int inYear)
    {
        boolean isValid = false;

        if (inYear >= 1950 && inYear <= 2022)
        {
            isValid = true;
        }

        return isValid;
    }
    /**********************************************************************
    SUBMODULE: validateHull
    IMPORT: inHull (String)
    EXPORT: isValid (boolean)
    ASSERTION: it will only validate inHull if it's one of the following
               three; steel, alloym and titanium.
    ********************************************************************/
    private static boolean validateHull(String inHull)
    {
        boolean isValid = false;

        if(inHull.equals(STEEL) || inHull.equals(ALLY) ||
           inHull.equals(TTNM))
        {
            isValid = true;
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
    private static boolean validateMaxDepth(double inMaxDepth)
    {
        boolean isValid = false;

        if(inMaxDepth >= -500 && inMaxDepth <= 0)
        {
            isValid = true;
        }

        return isValid;
    }
    /***********************************************************************
        SUBMODULE: validateCylinders
        IMPORT: inCylinders (Real)
        EXPORT: isValid (Boolean)
        ASSERTION: validates serial numbers as true whereby its first three
                   digits are between 100 to 200 (inclusive), and the last three
                   digits are between 001 - 999 (inclusive), otherwise it will
                   validate them as false.
        ***********************************************************************/
        private static boolean validateCylinders(int inCylinders)
        {
            boolean isValid = false;

            if(inCylinders >= 2 && inCylinders <= 20)
            {
                isValid = true;
            }
            return isValid;
        }
        /**********************************************************************
        SUBMODULE: validateFuel
        IMPORT: inFuel (String)
        EXPORT: isValid (boolean)
        ASSERTION: it will only validate inFuel if it has a string describing
                   the fuel of the fighter jet
        ********************************************************************/
        private static boolean validateFuel(String inFuel)
        {
            boolean isValid = false;
            if (inFuel.equals(BATRY) || inFuel.equals(DSL) || inFuel.equals(BIO))
            {
                isValid = true;
            }

            return isValid;
        }
       /**********************************************************************
    SUBMODULE: validateOrdance
    IMPORT: inOrdance (String)
    EXPORT: isValid (boolean)
    ASSERTION: it will only validate inOrdance if it has a string describing
               the ordance of the fighter jet
    ********************************************************************/
    private static boolean validateOrdance(String inOrdance)
    {
        boolean isValid = false;
        if (inOrdance.length() != 0)
        {
            isValid = true;
        }

        return isValid;
    }
      /*******************************************************************
        SUBMODULE: validateWingSpan
        IMPORT: inWingSpan (Real)
        EXPORT: isValid (Boolean)
        ASSERTION: a wingSpan of between 2.20 and 25.6 will be validate 
                   otherwise, error will be thrown to the user
        ********************************************************************/
        private static boolean validateWingSpan(double inWingSpan)
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
}
