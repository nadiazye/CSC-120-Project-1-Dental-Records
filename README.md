# CSC 120 Project 1 Dental Records
This specific git repository was done by Nadia Z. Rodriguez in Fall 2025.
The midterm project for University of Miami's CSC 120 Fall 2025. Students are meant to make a fool proof project that tracks patient's dental records.

Instruction for students by professor:


The Florida Dental Association needs a program to record what teeth the members of Florida families have. Different Floridians have different numbers of different types of teeth (the program must use this simplified categorization of types of teeth):

    Incisors (the 'I' teeth)
    Bicuspids (the 'B' teeth)
    Missing teeth (the 'M' teeth) 

The program must record the teeth for one Florida family. When it starts the program asks how many people there are in the family (maximally 6), then for each family member gets their name, a string of tooth types (each character in the string represents one tooth) for the uppers (maximally 8 teeth including missing teeth), and a string a tooth types for the lowers (maximally 8 teeth including missing teeth), e.g., the string "BMIIBBM" would represent 7 teeth (of which two are missing). The names are recorded in an array of strings. The tooth information is recorded in a three dimensional array of characters, where each plane corresponds to a person, there are two rows (uppers and lowers), and each row has a column for each tooth. Once the information is recorded the program must offer a menu of four options:

    Print the family's teeth record.
    Extract a tooth (with a check that there is something there to remove).
    Report the family's root canal indices, which are the roots of the quadratic equation Ix2 + Bx - M, where I, B, and M are the family's numbers of those types of teeth.
    Exit (with a smile) 

The program must be reasonably idiot proof:

    Menu options must be accepted in upper and lower case.
    Tooth letters must be accepted in upper and lower case.
    All input must be checked to be in range, and if not the user must be asked to input again.
    You may assume that numeric input will be syntactically correct. 

Here's what a sample run should look like (with the keyboard input shown in italics) ...

Welcome to the Floridian Tooth Records
--------------------------------------
Please enter number of people in the family : -3
Invalid number of people, try again         : 7
Invalid number of people, try again         : 3
Please enter the name for family member 1   : Henrietta
Please enter the uppers for Henrietta       : ABCDEFGH
Invalid teeth types, try again              : IIIBMBIIIMBBMIII
Too many teeth, try again                   : BMBIMBM
Please enter the lowers for Henrietta       : BBMIIMBB
Please enter the name for family member 2   : Stanley
Please enter the uppers for Stanley         : miim
Please enter the lowers for Stanley         : bbMMbb
Please enter the name for family member 3   : Raul
Please enter the uppers for Raul            : BBIbbbB
Please enter the lowers for Raul            : bbiIIBB

(P)rint, (E)xtract, (R)oot, e(X)it          : T
Invalid menu option, try again              : p

Henrietta
  Uppers:  1:B  2:M  3:B  4:I  5:M  7:B  7:M
  Lowers:  1:B  2:B  3:M  4:I  5:I  6:M  7:B  8:B
Stanley
  Uppers:  1:M  2:I  3:I  4:M
  Lowers:  1:B  2:B  3:M  4:M  5:B  6:B
Raul
  Uppers:  1:B  2:B  3:I  4:B  5:B  6:B  7:B
  Lowers:  1:B  2:B  3:I  4:I  5:I  6:B  7:B

(P)rint, (E)xtract, (R)oot, e(X)it          : E
Which family member                         : Melanie
Invalid family member, try again            : stanley
Which tooth layer (U)pper or (L)ower        : M
Invalid layer, try again                    : u
Which tooth number                          : 27
Invalid tooth number, try again             : 4
Missing tooth, try again                    : 2

(P)rint, (E)xtract, (R)oot, e(X)it          : P

Henrietta
  Uppers:  1:B  2:M  3:B  4:I  5:M  7:B  7:M
  Lowers:  1:B  2:B  3:M  4:I  5:I  6:M  7:B  8:B
Stanley
  Uppers:  1:M  2:M  3:I  4:M
  Lowers:  1:B  2:B  3:M  4:M  5:B  6:B
Raul
  Uppers:  1:B  2:B  3:I  4:B  5:B  6:B  7:B
  Lowers:  1:B  2:B  3:I  4:I  5:I  6:B  7:B

(P)rint, (E)xtract, (R)oot, e(X)it          : R
One root canal at     0.41
Another root canal at -3.04

(P)rint, (E)xtract, (R)oot, e(X)it          : X

Exiting the Floridian Tooth Records :-)

You must ...

    Do a top down design for this problem, producing a structure chart (it's OK to draw it by hand, but it must be neat, readable, and understandable - if you can't draw or write neatly, use a graphics package, e.g., draw.io).
    Do a design algorithm for the program (typed, not handwritten).
    After you have completed your analysis and design, implement the program in stylish Java (including JavaDoc documentation). You program must reflect your structure chart and design. You must use a three dimensional array to store the teeth data.
    Keep everything in a GitHub repository. 

The project is due at the start of your lab session in the week starting 27th October. You must: submit in Blackboard:

    Submit your structure chart (as a JPG) and design (text file) in Blackboard
    Submit you Java code and JavaDoc web pages (.zip of your project folder) in Blackboard
    Sit with a TA when (s)he runs your program in the lab session so you can see together how well it works.
    Show the TA your GitHub repository. 

