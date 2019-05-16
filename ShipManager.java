/*****************************************************************************
AUTHOR: Tawana David Kwaramba
FILENAME: UI.java
STUDENT ID: 19476700
LAST MODifIED:
PURPOSE: A class which is reponsible for all the user input and output.
******************************************************************************/
public class ShipManager 
{
    public static void main(String [] args)
    {
        /* placing the try and catch blocks to handle errors which may have 
           crept to the class. This is error handling, just in case if
           something goes horribily wrong */
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
/*
    create a new UI object with the name userInterface
    userInterface.mainMenu
    
END MAIN:*/
