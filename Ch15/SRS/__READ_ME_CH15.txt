 

 
                CHAPTER 15 SRS NOTES
                ====================


SIX CLASSES HAVE BEEN *ADDED* AS OF CHAPTER 15:

	CourseCatalog
	Faculty
	InvalidStudentException
	SRSDataAccess
	SRSInitializationException
	StudentPersistenceException

AND ONE HAS *CHANGED*:

	SRS

TOTAL OF NINE CLASSES *UNCHANGED* SINCE CHAPTER 14:

	Course 
	EnrollmentStatus 
	Person 
	Professor 
	ScheduleOfClasses 
	Section 
	Student 
	Transcript 
	TranscriptEntry

FOR A GRAND TOTAL OF SIXTEEN CLASSES.

===

OTHER FILES IN THIS DIRECTORY ARE AS FOLLOWS:

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
separator.txt
