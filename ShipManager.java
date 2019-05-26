/*****************************************************************************
AUTHOR: Tawana David Kwaramba
FILENAME: UI.java
STUDENT ID: 19476700
LAST MODifIED: 27/05/19
PURPOSE: A class which is reponsible for all the user input and output.
******************************************************************************/
public class ShipManager 
{
    public static void main(String [] args)
    {
        /* placing the try and catch blocks to handle errors which may have 
           crept to this class. This is jsut in case if somethinng terrible
           happens to out programme.*/
        try
        {
            UI userInterface = new UI();
            userInterface.mainMenu();
        }
        catch(IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
        }
    }
}
