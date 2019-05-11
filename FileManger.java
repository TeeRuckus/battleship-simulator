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


    //STATIC METHODS

    /**************************************************************************
    SUMBODULE: readFile
    IMPORT: fileName (String)
    EXPORT: none
    PURPOSE: to read and prcess the contents of a file
    **************************************************************************/
    public static void readFile(String fileName)
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
                //processLine(line);
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
    public static void writeFile(String fileName, String line)
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
                pw.println(line);
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
    public static void processLine() 
    {
        //`this was adapted from OOPD worksheet 8: REFERENCE THIS LATER
        String[] lineContents = new String[7]; 
        lineContents = line.split(",");
        //lineContents [] = line.split(",") ;

        if(validateLine(lineContents))
        {
            createShipObjcts(lineContents);
        }
    }
         
    /**************************************************************************
    SUBMODULE: createShipObjcts 
    IMPORT: lineContents [] (Strings) 
    EXPORT: none
    PURPOSE: to create the ship objects from the file information once it has
             been all validated 
    **************************************************************************/
    public static void createShipObjcts(String[] lineContents)

        
        shipType = first character of fileContents[0] 
        serialNum = validateSerialNum(fileContents[1])
        COMMENT: this is not an integer anymore, it's a string which you're 
                 parsing to a double number
        year = validateYear(fileContents[2] CONVERT to interger)
        cylinders = validateCylinders(fileContents[3] CONVERT to integers)
        fuel = validateFuel(fileContents[4])

        CONSTRUCT engine USING cylinders, fuel (ALTERNATE CONSTRUC;R)

        CASE (UPPERCASE)shipType
            S:
                hull = subMarineClass.validateHull(line[5]) 
                maxDepth = subMarineClass.validateMaxDepth(line[6])

                CONSTRUCT submarine (object) USING serialNum, year, hull, 
                maxDepth
                
                add the construced object into ShipStorage
            F:
                wingSpan = fighterJetClass.validateWingSpan(line[5])
                ordance = fighterJetClass.validateOrdance(line[6])
        
                CONSTRUCT fighterJet (Object) USING serialNum, year, wingSpan,
                ordance

                add the constructed object into ShipStorage 

            defualt:
                FAIL "Invalid ship type" (IllegalArgumentException) 

SUBMODULE: searchDir
    IMPORT: none 
    EXPORT: directoryContents []
    ASSERTION:

    :

    COMMENT: code adapted from:
     https://www.mkyong.com/java/java-how-to-list-all-files-in-a-directory/

SUBMODULE 

PRIVATE  SUBMODULES:

SUBMODULE: validateLine
    IMPORT: lineContents [] (String)
    EXPORT: none 
    ASSERTION: if the line is invalid the programme will fail.

    : 

    if((lineContents LENGTH is not 7) 
        FAIL (IllegalArgumentException)
     

    if((lineContents[0] LENGTH is NOT 1)    
        FAIL (IllegalArguementException
     if(

