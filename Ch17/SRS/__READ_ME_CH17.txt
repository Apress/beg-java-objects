                CHAPTER 17 SRS NOTES
                ====================


TWO CLASSES HAVE BEEN *ADDED* AS OF CHAPTER 17:

	MainFrame
	PasswordPopup

AND TWO HAVE *CHANGED* SINCE CHAPTER 15:

	Student
	SRS

TOTAL OF FOURTEEN CLASSES *UNCHANGED* SINCE CHAPTER 15:

	Course 
	CourseCatalog
	EnrollmentStatus 
	Faculty
	InvalidStudentException
	Person 
	Professor 
	ScheduleOfClasses 
	Section 
	SRSDataAccess
	SRSInitializationException
	StudentPersistenceException
	Transcript 
	TranscriptEntry

FOR A GRAND TOTAL OF EIGHTEEN CLASSES.

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
output.txt
separator.txt
