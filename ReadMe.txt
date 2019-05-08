---------------------------------------------------------
Author: Segopotso Makhutja                              
Due Date: 09 May 2019                                 
CSC3002F: OS Assignment 2 (Part III)                      
---------------------------------------------------------

### Instructions
    - extract the zip file
    - navigate to the project root directory

### Contents
    - molecule package contains all source files:
    		- Carbon.java
    	 	- Hydrogen.java
  		 	- Methane.java
 			- ReusableBarrier.java
            - RunSimulation.java
		- bin folder for all the compiled files
    - Makefile : to compile and run the default Test
    - READMe.txt : READMe file containing instructions
    - .git : regularly updated local git repo

### Compile
    - to compile, make sure you are in the root directory then on the terminal type `make`
    - `make` will build or compile all the required files

### Run
    - make sure you are in the root directory of the project
    - type `make def`
    - `make def` will run the default test which is to test with the default case provided in the brief
    - the default case is 12 3 <# Hydrogen Atoms> <# Carbon Atoms>

### Test
    - to test the program with different values
    - type `make run ARGS="<# Hydrogen Atoms> <# Carbon Atoms>" in the command line
    - remove the angle brackets. but keep the inverted commas. 
    - e.g make run ARGS ="120 30" [note the space between the values]

### Additional Notes
	- sometimes the files may be clock skewed when trying to compile.
	- to fix this, run this command on terminal. `touch *` while you in root folder.
    - to clean the working environment run `make clean`
    - `make clean` will remove all the .class files in the project
    - no assumptions have been made, the program runs as the assignment brief requires. 
