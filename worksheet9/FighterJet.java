/*******************************************************************************
AUTHOR: Tawana David Kwaramaba
STUDENT ID: 19476700
DATE:
PURPOSE: to create a class which will model the functionality of a real life 
         fighter jet
*******************************************************************************/
public class FighterJet
    {
        //private class fields
        private double serialNum, wingSpan; 
        private int year;
        private String ordance;
        private Engine engine;

        /***********************************************************************
        DEFUALT Constructor
        IMPORT: none
        EXPORT: none
        ASSERTION: a fighter jet with a serial number of 123.250, commissioned 
                   in 1950, with an engine ordance of titanium with a maximum 
                   depth of 500.0 is a valid defualt state
        ***********************************************************************/
        public FighterJet()
        {
            serialNum = 123.250;
            year = 1950;
            ordance = "machine guns";
            wingSpan = 3.0;
            engine = new Engine();
        }
        /***********************************************************************
        ALTERNATE Constructor
        IMPORT: inSerialNum (Real), inYear (Interger), inOrdance (String), 
                inWingSpan (Real)        
        EXPORT: none
        ASSERTION: creates an object if the imports are valid, otherwise it will
                   FAIL
        ***********************************************************************/
        public FighterJet(double inSerialNum, int inYear, String inOrdance, 
                     double inWingSpan, Engine inEngine)
        {
            if(validateSerialNum(inSerialNum))
            {
                if(validateYear(inYear))
                {
                    if(validateOrdance(inOrdance))
                    {
                        if(validateWingSpan(inWingSpan))
                        {      
                            serialNum = inSerialNum;
                            year = inYear;
                            ordance = inOrdance; 
                            wingSpan = inWingSpan;  
                            engine = inEngine;
                        }
                    }
                }
            }
            else
            {
                throw new IllegalArgumentException("\nInvalid object import" +
                                                   "values\n");  
            }
        }
        /***********************************************************************
        COPY Constructor
        IMPORT: inFighterJet (FighterJet)
        EXPORT: none
        ASSERTION: creates an objext which is identical to the importred object
        ***********************************************************************/
        public FighterJet(FighterJet inFighterJet)
        {
            serialNum = inFighterJet.getSerialNum();
            year = inFighterJet.getYear();
            ordance = inFighterJet.getOrdance();
            wingSpan = inFighterJet.getWingSpan();
            engine = getEngine(); 
        }
        
        //ACCESSORS

        public double getSerialNum()
        {
            return serialNum; 
        }

        public int getYear()
        {
            return year;
        }

        public String getOrdance()
        {
            return ordance;
        }

        public double getWingSpan()
        {
            return wingSpan;
        }
        public Engine getEngine()
        {
            return new Engine(engine);
        }
        

        //MUTATORS

        /***********************************************************************
        SUBMODULE: setSerialNum
        IMPORT: inSerialNum (Real)
        EXPORT: none
        ASSERTION: sets the serial number to inSerialNum if it's valid, 
                   otherwise it fails
        ***********************************************************************/
        public void setSerialNum(double inSerialNum)
        {
           if(validateSerialNum(inSerialNum))
            {
                serialNum = inSerialNum;
            } 
            else
            {
                throw new IllegalArgumentException("Invalid serial number");
            }
        }        
        /***********************************************************************
        SUBMODULE: setYear
        IMPORT: inYear (Interger)
        EXPORT: none
        ASSERTION: set year to inYear if it'  valid, otherwise it will fail
        ***********************************************************************/
        public void setYear(int inYear)
        {
            if(validateYear(inYear))
            {
                year = inYear;
            }
            else
            {
                throw new IllegalArgumentException("Invalid year");
            }
        }
        /***********************************************************************        
        SUBMODULE: setOrdance 
        IMPORT: inOrdance (String)
        EXPORT: none
        ASSERTION: set ordance to to inOrdance if it's valid, otherwise it will fail
        ***********************************************************************/
        public void setOrdance(String inOrdance)
        {
            if(validateOrdance(inOrdance)) 
                ordance = inOrdance;
            else
            {
                throw new IllegalArgumentException("Invalid ordance");
            }
        }
        /***********************************************************************
        SUBMODULE: setWingSpan 
        IMPORT: inWingSpan (Real)
        EXPORT: none
        ASSERTION: set wingspan to inWingSpan if it's valid, otherwise fail
        ***********************************************************************/
        public void setWingSpan(double inWingSpan)
        {
            if(validateWingSpan(inWingSpan))
            {
                wingSpan =  inWingSpan; 
            }
            else
            {
                throw new IllegalArgumentException("\nInvalid wingspan," +
                                                    "input a wingspan between"+ 
                                                    " ranges of 2.20 and 25.6"+
                                                    " (inclusive)");
            }
        }
        /***********************************************************************
        SUBMODULE: setEngine
        IMPORT: inEngine (Engine object)
        EXPORT: none
        ASSERTION: set engine to inEngine if it's valid, otherwise fail
        ***********************************************************************/
        public void setEngine(Engine inEngine) 
        {
            if(!(inEngine instanceof Engine))
            {
                throw new IllegalArgumentException("ERROR: not a valid "+
                                                   "engine");
            }
            else
            {
                engine = inEngine;
            }
            
        }
    
        //DOING METHODS:

       /* SUBMODULE: calcTravel (*** I cannot impliment this yet, as my knowledge on
                            how to is limited ***) */

        //PRIVATE SUBMODULES:

        /***********************************************************************
        SUBMODULE: validateSerialNum
        IMPORT: inSerialNum (Real)
        EXPORT: isValid (Boolean)
        ASSERTION: validates serial numbers as true whereby its first three 
                   digits are between 100 to 200 (inclusive), and the last three 
                   digits are between 001 - 999 (inclusive), otherwise it will
                   validate them as false.
        ***********************************************************************/
        private boolean validateSerialNum(double inSerialNum)
        {
            int wholePart, decimalPart;
            boolean isValid = false; 

            wholePart = (int)inSerialNum;
            decimalPart = (int)(inSerialNum * 1000) % 1000;
            if(wholePart >= 100 && wholePart <= 300)
            {
                if(decimalPart >= 1 && decimalPart <= 999)
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
        private boolean validateYear(int inYear)
        {  
            boolean isValid = false;
        
            if (inYear >= 1950 && inYear <= 2022)
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
        private boolean validateOrdance(String inOrdance)
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

        //OTHER METHODS

        /********************************************************************
        SUBMODULE: clone
        IMPORT: none
        EXPORT: cloneFighterJet (Object)
        ASSERTION: returns a cloned object of the current object
        ********************************************************************/
        public FighterJet clone()
        {
            FighterJet cloneFighterJet;

            cloneFighterJet = new FighterJet(this.serialNum, this.year, 
                                    this.ordance, this.wingSpan, this.engine);
            return cloneFighterJet; 
        }
        /********************************************************************
        SUBMODULE: equals
        IMPORT: inObjct (object)
        EXPORT: isSame (boolean)
        ASSERTION: two fighter jets are interchangable if they have the same 
                   ordance and wingspan
        ********************************************************************/
        public boolean equals(Object inObjct)
        {
            boolean isSame = false;
            if(inObjct instanceof FighterJet) 
            {
                FighterJet inFighterJet = (FighterJet)inObjct;
                isSame = ordance.equals(inFighterJet.getOrdance()) &&
                          wingSpan == (inFighterJet.getWingSpan()) &&
                          engine.equals(getEngine());
            }

            return isSame;
        }
        /********************************************************************
        SUBMODULE: toString
        IMPORT: none
        EXPORT: str (String)
        ASSERTION:
        ********************************************************************/
        public String toString()
        {
            int cylinders = engine.getCylinders();
            String fuel = engine.getFuel();
            return("The ship " +serialNum+ " was comissioned in " +year+ 
                   " , its engine has " +cylinders+ " cylinders and runs on "
                    +fuel+ "fuel. It is a fighter jet with a wing span of "
                    +wingSpan+ " metres and equiped wit " +ordance+ ".");
        }
        /********************************************************************
        SUBMODULE: toFileString
        IMPORT: none
        EXPORT: str (String)
        ASSERTION: 
        ********************************************************************/
        public String toFileString()
        {
            int cylinders = engine.getCylinders();
            String fuel = engine.getFuel();
            return("F," +serialNum+ "," +year+ "," +cylinders+ "," +fuel+ "," 
                  +ordance+"," +wingSpan+ ".");
        }
    } 
