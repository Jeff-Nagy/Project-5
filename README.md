Project 5: Exception Handling (Hangman)

Due Friday by 11:59pm  Points 100  Submitting a file upload  File Types zip Available until Nov 6 at 11:59pm
Write a text-based program to play a game of Hangman. (If you’re not familiar with the game, check out the Wikipedia page here (Links to an external site.)Links to an external site..) Your program will read in a dictionary file (words.txtPreview the documentView in a new window) and randomly choose a word. The user will then guess letters until they either guess the word or run out of guesses. 

Here is a sample program you can run: Hangman.jarView in a new window

To run the program, download the JAR file and the words.txtPreview the documentView in a new window file to the same directory.
Navigate to that directory using "cd" (change directory) in either a terminal window (on a MAC) or a command window (on a PC- type "cmd" into the start box).
Use this command: java -jar Hangman.jar
There are two parts to this project. The first is writing the game and getting it working properly. The second is adding exception handling. I strongly recommend you complete Part I before moving on to Part II.

Part I: The Game (50 points)

Your game must follow these rules:

The user gets a pre-defined maximum number of wrong guesses. (My program uses 7.)
If a user guesses the same wrong letter twice, this letter should only count once towards the maximum wrong guesses.
The game should ignore the capitalization (upper or lower case) of guesses.
If the user guesses a correct letter, all instance of that letter should be revealed.
Here are some notes to help:

Below is pseudocode for the game. You are not required to use this approach. but you might find it helpful.
read in the list of words in the dictionary file 

randomly choose a word from this list

while the user still has guesses left and they have not guessed the word

print the word (displaying guessed letters and blanks for non-guessed letters)

read the user’s guess

          if the user hasn’t already guessed that letter

          check if the guess is right or wrong

   if the user didn’t guess the word, update the guesses remaining

Break your code up into methods. Do not have the entire game in the main method.
You will likely need several instance data variables to keep track of things. Below are some recommendations. You are not required to use these.
counters: numLetters (size of the selected word), numIncorrectGuesses, numLettersGuessedCorrectly,
char[] selectedWordArray- you might find it helpful to keep the characters of the selected word in a char[]. This will allow you to loop through the array and compare each letter to the user’s guess.
boolean[] guessedLetter- you might find it helpful to use a boolean[] that represents whether the letter at each position has been guessed. This will be useful when printing the word to the user (as letters and blanks).
ArrayList<Character> lettersGuessed- keep track of which letters have been guessed
Hint for testing: Print out the randomly selected word you are trying to guess. This makes for much easier testing!
Again, I strongly recommend getting the game working before moving on to Part II.
Part II: Exception Handling (50 points)

Add exception handling to cover three erroneous occurrences.
Note: I realize you could write a working game that accounts for these situations without using exception handling. But, for this project, you are required to use exception handling.
Situation One: The dictionary file does not exist.
Use an existing Java exception class to deal with this.
Your program should end in this situation because the game cannot be played with a dictionary.
The program should end gracefully with a nice message- not crash with an error.
Situation Two: The user enters a guess that is not a letter (like + or $)
Create your own exception type to represent this situation.
When the situation occurs, throw an object of the type you just created. Catch the exception and print a message to the user about what went wrong.
The user continues on and enters a new guess. The invalid guess does not count against the user.
Hint: check out the Character class for help with detecting this situation!
Situation Three: The user enters a guess that is longer than one character (like aa or zb)
Create your own exception type to represent this situation.
When the situation occurs, throw an object of the type you just created. Catch the exception and print a message to the user about what went wrong.
The user continues on and enters a new guess. The invalid guess does not count against the user.
Your main method should not terminate because of any of these thrown exceptions. All thrown exceptions should be caught and handled and the game should continue.
Extra Credit: 15 points

Allow the user to play multiple games. Keep track of the number of wins, losses, and the win percentage. Print this information at the end of each game.

Submission

Submit a zip file containing your java files and the dictionary file (submit the dictionary file even if you use the one that I provided). If you are working in a group, submit only one assignment. Put the names of all group members in the comments of each java file.
