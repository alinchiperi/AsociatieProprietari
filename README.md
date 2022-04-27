# AsociatieProprietari
Project Data Structures and Algorithms
I had to write an apartment management program of an Association of owners.  This association wants to expand its expenditure management activity related to the use of apartments and other activities such as real estate advertising
on properties. The program I wrote had to be designed according to the concepts object-oriented programming

# Options
1. **add** - Add an apartment in the persistent storage medium (save). The parameters are specific to each type of apartment and are given exactly in the order in which they are presented by toString () method of the apartment class.
2. **list [id]**- The command displays all the data regarding the apartment with the specified id (if there is). If the parameter is missing, all the apartments in the storage environment are displayed.
3. **clear** -Remove all apartments from persistent storage.
4. **delete[id]**-Remove the apartment with the ID id .
5. **file nameFile** -Set the name of the file in which the data will be stored.
6. **rem** - represents a commnent(remark). Only the current line is displayed and go to the next command without executing anything else.
7. **stop**- stops program execution.
8. **count[type]**- The type parameter can be L and then the residence or SF are counted and then the number of company offices is displayed. If the standard parameter is missing then the total number of apartments (homes + company offices) is returned.
9. **newer nrYears**- Displays the ID(s) of the apartments that were built no more than years ago.
10. **street str** - Displays the ID / IDs of the apartments located on the street with the name specified in the parameter str.
11. **countsurf X smin** -counts how many apartments of type X (L or SF) have a surface greater than or equal to smin
12. **select smin fmax** - Dispalys the apartments that have an area greater than or equal to smin and are located on a floor less than equal to the fmax.
13. **expenses  id** -Displays in the form of an integer the value of the expenses with the apartment whose id is specified; the expenses are calculated with the formula 10 * S + a, where S is the surface of the apartment, and a can be 10 if it is a house, or 50 if it is a company headquarters.
