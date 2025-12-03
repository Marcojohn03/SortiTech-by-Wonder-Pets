*SortiTech: Smart Waste Sorting and Collection System**

**DESCRIPTION/OVERVIEW**

This Java console-based application should enable users to be more mindful of their surroundings by demonstrating the functionality of a simple waste management system. 
The program enables the user to classify waste into three categories: **biodegradable, non-biodegradable, and recyclable**. This will educate people on the proper separation of 
wastes and the users are taught how each type of waste is to be disposed of.

The system also has the capability of handling the collection schedules, and one can set or change the time at which the waste is supposed to be collected in their household 
or community. It gives users an option of the day or hour of preferred collection and updates it whenever it is necessary. The application maintains a definite record of the 
cumulative amount of waste in each category, and it updates this record whenever new waste is added. It also consolidates the waste it has accumulated such that users can 
easily check the amount of waste they have accumulated over the years.

Besides, the program comes with a simple and easy-to-use menu allowing users to navigate through the menu with ease. It takes the user through the steps and thus the system 
is easy even to the ones who are still learning about waste management. To encourage proper management of waste, the application will also verify whether a waste category is
approaching capacity limit. When a bin is nearly full or full, the system will issue a warning message to inform a user to do something, as either to schedule a collection or 
minimize further production in the form of waste. This will stop overflow and promote good environmental practices.

_**OOP Concepts Applied**_

**Abstraction** - the WasteRecord group conceals hard things. It hides facts of waste types out of view. You are looking at easy stuff, not difficult stuff.It just gives the bare
minimum of any record, i.e.: it gives the date and the amount subtracted over, plus the abstract displayRecord() method. All the individual types of waste are then able to 
determine how to present their respective information without the program having to be aware of the details.

**Inheritance** - WasteRecord is the predecessor of PlasticRecord.  WasteRecord provides it with all of its fields.  It has date & amountReduced.  It gets any base methods too.  
PlasticRecord possesses everything that base class provides...It avoids the repetition of code and simplifies the task of creating new waste-record types in the future.

**Polymorphism **- the displayRecord() method is defined in the abstract class, but implemented in different ways in each of the subclasses. It is a form of runtime polymorphism: 
the program can work with different record types using the WasteRecord reference, but on executing the displayRecord() method, it executes the one that is specific to a subclass 
(such as PlasticRecord).

**Encapsulation** - both the date and the amountReduced are not directly exposed but through getters and setters. This safeguards the inner values of the object and makes sure that 
they can be altered only in a regulated, foreseeable manner.

**PROGRAM STRUCTURED**

**Main Class:** **SortiTechSystem**

* This is the main controller of the entire application. It does the following functions:

    * Shows program introduction and help section.

    * Introduction of a user menu to navigate.

    * Manages the addition, deletion, searching, sorting, and displaying of waste records.

    * Stores store all the plastic wastes in an array of PlasticRecord[].

    * Processes user input and verifies it.

The program flow is done using different menus.

The upper limit is also established to 100 records in the class, and records the number of records saved.


**Abstract Class: WasteRecord**

This is the type of category that this class provides the model of any kind of waste records. 

* It contains:

  * The date of the record
   
  * The amount of waste reduced

  * Something to set values.

  * Manipulators and lockers to regulate data entry.

  * A displayRecord() method that would be subclassed and would implement formatting.

  This makes them consistent throughout all the records of waste data regardless of the type of waste being used.


**Subclass: PlasticRecord**

* Boasts of a particular form of waste-plastic waste.

* It will expand WasteRecord and will offer the practical implementation of the displayRecord() procedure.

* It enables the program to store a lot of information, including the number of plastic that has been reduced on any specific date.
The system can be repeated to accommodate biodegradable and recyclable waste when the system is extended.

**Data Handling and Storage**

   * The data about the waste is held in an array of the fixed-size objects of PlasticRecord.

   * RecordCount is a variable that is used in keeping a count of the number of entries.

   * Only, there are possibilities to add records, to search them by date, delete them, sort them, and make them listed.

   * Sorting One simple bubble sort algorithm sorts by descending plastic reduction amount.

This system enables this structure to have a clean and organized history of waste reduction.

_**Menu Navigation Flow**_

* The show takes the user through various strata of menus:

**1. Introduction Screen**

Shows the title and the description of the display and developer credits.

**2.	Main Menu**

  * Begin

  * Help

  * Exit

**3. Tracker Menu**

* House the house of all important system functions, viz.,

  * Add Record

  * Record Delete Search Record

  * Records sorting
  
  * Display All Records
  
  * Back to Main Menu 

  This design makes this system very simple to use and run even by users who are not very experienced.

**HOW TO RUN THE PROGRAM**

**1. Accessing the Main Menu**

* When the program launches, the first screen you will encounter is the Main Menu, which serves as the central navigation hub of the system. It contains three options:

    * Start – Selecting this will take you directly to the SortiTech Tracker Menu, where you can add new entries, search for specific records, sort data, or display all existing records.

    * Help – Best for new users, this section provides a brief overview of the system, explains its features, and clarifies how each function works.

    * Exit – Choosing this option will close the program entirely.

The Main Menu functions as your decision point. Your chosen option determines which part of the system you will enter next.

**2. Entering the SortiTech Tracker Menu**

* After selecting Start, you will be directed to the SortiTech Tracker Menu, the main workspace of the program. Here, you can manage your plastic waste reduction records through the following options:

   * Add Record

   * Delete Record

   * Search Record

   * Sort Records

   * Display All Records

   * Back to Main Menu

These options represent the core features of the SortiTech System.

**3. Adding a New Record**

* Choosing Add Record prompts you to enter two details:

   * Date of waste reduction

   * Amount of plastic reduced (grams)

Once entered, the system saves your input and stores it in its records.

This feature is essential for documenting your daily plastic waste reduction progress.

**4. Deleting an Existing Record**

* When you select Delete Record, the system asks for a specific date.

* It will then search through all stored records to find an exact match. If found, the entire record for that date is removed.

   * This is useful when:

       * Incorrect information was entered

       * You want to clean or update stored data

       * Outdated entries need to be removed

**5. Searching for a Specific Record**

* The Search Record option allows you to look up an entry by entering its date.

* The system scans all saved records for a matching date, and if one exists, it displays:

     * The date of the record

     * The amount of plastic reduced on that day

This is helpful when you need information from a specific entry without checking the entire list.

**6. Sorting All Saved Records**

* Selecting Sort Records arranges all stored entries in order—typically from the highest amount of plastic reduced to the lowest.

     * This feature is useful when:

          * Identifying which day had the greatest reduction

          * Observing patterns or trends in your progress

          * Preparing organized data for reports

Sorting helps make your records more readable and meaningful.

**7. Displaying All Saved Records**

* Choosing Display All Records will show the complete list of all entries stored in the system. Each record includes:

    * The recorded date

    * The amount of plastic reduced (in grams)

This option is ideal for reviewing your overall data or confirming that your entries were saved correctly.

**8. Returning to the Main Menu**

To exit the tracker and return to the program’s primary navigation screen, select Back to Main Menu.

* This will redirect you to the screen where you can again choose Start, Help, or Exit.

     * This is helpful when:

         * You want to modify program settings

         * You need to revisit the Help section

         * You’re finished working and want to exit the system properly

**9. Exiting the Program**

To fully close the SortiTech System, return to the Main Menu and select Exit.

   * This option safely terminates the program, ensuring:

       * No processes are left running

       * No functions remain unfinished

       * You return to your desktop or command prompt smoothly

**SAMPLE OUTPUT**

<img width="1600" height="1294" alt="image" src="https://github.com/user-attachments/assets/2cc373c7-5165-467a-9fe7-06379075e9de" />

<img width="1600" height="1365" alt="image" src="https://github.com/user-attachments/assets/824aae91-a43a-434a-a413-34628427dace" />

<img width="1600" height="1365" alt="image" src="https://github.com/user-attachments/assets/53e03d29-0414-4923-9e97-9def0bada79f" />

<img width="1600" height="1363" alt="image" src="https://github.com/user-attachments/assets/aba3d37c-85da-470d-bc25-612d61d16322" />

**AUTHORS**

The members of the group who established and developed this project are **Jeremy B. Alea**, **John Marco H. Anotnio**, and 
**Craig Michael A. Esleta**. All members participated in the research, design, and development of the Java console application.

**ACKNOWLEDGEMENT**

On behalf of our project team, we would like to express our warmest gratitude to our professor, **Mr. Juriel Comia**, for providing guidance and
support throughout this project. We also appreciate our classmates who shared their ideas and offered helpful suggestions. Lastly, we are
grateful to our families for their continuous encouragement and support during the completion of this work.



