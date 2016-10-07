================================================================
This directory contains a version of the SRS source code
as presented in Chapter 17 of BJO, 2nd Edition that will compile 
under a pre-5.0 version of Java.  That is, any references to 
language features newly introduced as of version 5.0 have been 
changed to accommodate older Java compilers.

Jacquie Barker
================================================================

FILES IN THIS DIRECTORY ARE AS FOLLOWS:

*.java - Java source code for the SRS application

*.dat - miscellaneous data files read by the SRS application

*.dat.orig - original versions of selected data files, to be used in 
"resetting" file contents if the programs are to be rerun multiple times

reset.bat - a DOS script for reinstating the contents of various *.dat
files to their original state if the programs are to be rerun multiple times 

FileNames.properties - a Java properties file that maps symbolic file names
to physical file names so that the latter needn't be hardcoded into the 
SRS application

===

THE REMAINING FOUR FILES, IF PRESENT, ARE TO BE *DELETED*:

code.bat 
copyCode.bat
diffCode.bat
output.txt
separator.txt
