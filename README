Hey All,
 
As with most holiday periods where you're meant to spend time not thinking about work, we're setting another coding challenge!! Today marks the start of the Easter 2016 Coding Challenge, which is based around path finding.
 
Challenge
=======
Participants are asked to calculate some, or all of the following tasks:
Task 1) The least effort route from A to B.
Task 2) The least effort route from A to B to C to ... N
Task 3) The least effort route, which travels to A, B, C, .. N at least once.
 
Deadline
=======
The challenge starts now, March 24th.
All codes need to be submitted by midnight on Sunday the 3rd of April.
Testing will take place during the week of Monday the 4th of April.
Results will be announced, somewhere around then.
 
Setup
=======
The map in which to find routes, will be provided in a text file. An example file is attached. The file contains rows of the numbers 0 to 9, with each number representing a location to travel to, and the effort cost of travelling to that point. Locations are defined in [x, y] coordinates, with [0, 0] being the top left number in the file, for example, [4, 1] is the 9 in the following map.

<pre>
8273648712348712
8753981239901234
8921274192123122
9856685798234192
9287678213123134
</pre>


- All entries will be tested on the same map, and same routes for tasks 1, 2 and 3.
- The map will be larger than the sample maps (somewhere around the 5000 wide, by 5000 long) but will not be exactly that, so codes will have to cope with this.
- You can only travel to points directly above, below, to the left and to the right of a point. Diagonal routes are not allowed.
 
A file will also be provided with a list of points, in a comma delimited fashion. There will be somewhere around 100 points in the file (again this isn't exact on purpose).
- Task 1 will be to travel from the first point to the second point.
- Task 2 will be to travel from the 1st point, to the final point.
- Task 3 will be to travel to all points, in any order.
 
<pre>
id,x,y
1,3,5
2,8,10
3,8,3
4,5,9
5,7,3
</pre>
 
Your code should take two command line arguments, the first for the file containing the map, and the second for the file containing the list of points. For codes which don't compile to an .exe, it should be possible to write a .bat file to run with arguments.
 
 
<pre>
>>TimsCode.exe "textmap.txt" "routemap.txt"
</pre>

 
The code should save out 3 files, each containing the route for each part, with lines in each file representing an x, y location to travel to.
- The route should start at the top of the file, and progress line by line to the end.
- The effort attributed to a route, will be the sum of the efforts of the points visited (including the start and end points).
- Routes will be checked that steps in a route are allowed, and that all required points for that part of the task are visiting.

<pre>
x,y
4,6
4,7
5,7
5,8
</pre>
 
Rules
=======
- You can enter in any language you want.
- Participants who produce a route of equal length on a task, will be ranked based on how quick their code produced such route. (Codes will be timed using an agreed method later on)
- All codes will be tested on the same machine (mine) which is Windows 7. If you plan on writing in an uncommon language, let me know in advance so I can work out how to test your code. We may have to use a virtual machine.
- All codes will be ran through our technical debt analyser Sonar, and prestige will be given to the person with the lowest debt.
- Also, I'll be performing a search of the standard sites, and codes which have a high "ctrl-c ctrl-v" factor, may be disqualified. I'm expecting most codes to be implementations of standard route finding algorithms, however the aim if the challenge is to get you writing!  
 
I think that's everything! All this information will be placed on the Wiki shortly. Good luck, and may the best dev win!
 
Tom


