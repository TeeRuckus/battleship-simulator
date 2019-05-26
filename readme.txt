Tawana Kwaramba 

Date created: 27/09/19

Date last modified: 27/09/19

Purpose: A programme which vacilates the ship managment of a ship simulator

Files in project: Engine.java, EnginePsuedo.txt, FighterJet.java, FighterJetPsuedo.txt, FileManger.java,FileMangerPsuedo.txt, Ship.java, ShipManager.java, ShipManagerPsuedo.txt, ShipManager_TestResults.ods, ShipPsuedo.txt, ShipStorage.java, shipStorage_Psuedo.txt, SubMarine.java, SubMarinePsued.txt, TestDesign.ods, UI.java, UI_PsudoCode.txt

Test Files: EngineTestHarness.java, FighterJetTestHarness.java, FileMangerTestHarness.java, ShipStorageTestHarness.java,SubMarineTestHarness.java,

Functionality: loops through various menus and asks the user to input various information

TODO: add graphical interfaces
      

Known bugs
	bug#_<1>: shipDuplicates throws null pointer exceptions, and it doesn't store the first and 
		  last duplicate ships next to each other
    How to replicate: an exception has been used to catch the error. But without the exception. You simply just try to use the findDuplicates method.
    [suspected] cause: the use of the constant MAX_CAP to loop through the for loops of thr method
    how to fix: use the getCount() methd in ShipStorage to loop through the for loops
    
  
