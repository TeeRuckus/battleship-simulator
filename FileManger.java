/*****************************************************************************
AUTHOR: Tawana David Kwaramba}
FILENAME: UI.java
STUDENT ID: 19476700
LAST MODifIED: 27/05/19
PURPOSE: A class which is reponsible for all the user input and output.
******************************************************************************/
import java.io.*;
public class FileManger
{
    //STATIC METHODS

    /**************************************************************************
    SUMBODULE: readFile
    IMPORT: fileName (String)
    EXPORT: none
    PURPOSE: to read and prcess the contents of a file
    **************************************************************************/
    public static void readFile(String fileName, ShipStorage shipStorage)
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
            while(line != null && lineNum < ShipStorage.MAX_CAP)
            {
                try
                {
                    lineNum++;
                    processLine(line, shipStorage);
                    line = buffRdr.readLine();
                }
                catch(IllegalArgumentException err)
                {
                    /* I want to catch any badil/incorrectly written lines and
                    keep searching throug the file for correctly written
                    lines */
                }
            }

            strm.close();
        }
        catch(IOException err)
        {
            UI.showError(err.getMessage());
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
    PURPOSE: to create a file whereby the user can write onto it
    **************************************************************************/
    public static void writeFile(String fileName, String line)
    {
        //psudo code adapted from lecture 5 of OOPD     
        FileOutputStream strm = null;
        PrintWriter pw; 
        try
        {
            strm = new FileOutputStream(fileName, true);
            pw = new PrintWriter(strm);

            /*for(int ii = 0; ii < ShipStorage.MAX_CAP; ii++) 
            {
                pw.println(line);
            } */
            pw.println(line);

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
    public static void processLine(String line, ShipStorage shipStorage)
    {
        //this was adapted from OOPD worksheet 8: REFERENCE THIS LATER
        String[] lineContents = new String[7]; 
        //lineContents = line.split("\\,");
        lineContents = line.split(",");

        if(validateLine(lineContents))
        {
            createShipObjcts(lineContents, shipStorage); 
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
                                        shipStorage)
    {   
        char shipType;
        String serialNum;
        double maxDepth, wingSpan;
        int year, cylinders;
        String fuel, hull, ordance; 


        //intiliasing the variables to 0 or nothing, to allow java to compile    

        shipType = '\0'; //is this the correct way to set it to nothing
        serialNum = "";
        maxDepth = 0.0;
        wingSpan = 0.0;
        year = 0;
        cylinders = 0;
        fuel = ""; 
        ordance = "";
        
        /*if(validateYear(Integer.parseInt(lineContents[2])))
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
        }*/
        try
        {
            shipType = lineContents[0].charAt(0);
            serialNum = lineContents[1];
            year = Integer.parseInt(lineContents[2]);
            cylinders = Integer.parseInt(lineContents[3]);
            fuel = lineContents[4];

            switch (Character.toUpperCase(shipType))
            {
                case 'S':
                    hull = lineContents[5];
                    maxDepth = Double.parseDouble(lineContents[6]); 
                    SubMarine sub = new SubMarine(serialNum, year,
                                    new Engine(cylinders, fuel), hull,
                                    maxDepth);
                    shipStorage.addShip(sub); 
                    break; 

                case 'F':

                    wingSpan = Double.parseDouble(lineContents[5]);
                    ordance = lineContents[6];
                    FighterJet jet = new FighterJet(serialNum, year,
                           ordance, wingSpan, new Engine(cylinders, fuel));
                    shipStorage.addShip(jet); 
                    break;
            }
        }
        catch(IllegalArgumentException err)
        {
            /* to cacth any expcetions which may have been thrown by the
            submarine and fighterjet class */

            UI.showError(err.getMessage());

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
            throw new IllegalArgumentException("ERROR: incorrect file format");
        }
         
        if(lineContents[0].length() != 1)
        {
            throw new IllegalArgumentException("ERROR: incorrect ship "+
                                               "identifier length"); 
        }
        
        return isValid; 
    }

}
