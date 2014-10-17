#Java Tic Tac Toe

##Description
This is a simple tic tac toe game written in Java. It is currently configured for human vs human play, where each player alternates claiming indexes on the board until either one player wins or the game concludes in a tie.

##How to Play
To play, either:
- run `Main` in your IDE, or,
- navigate to `javaTTT/out/production/javaTTT` and enter `java com/javaTTT/Main` on the command line.

##How to Test
To run tests, either:
- run the test file you'd like to run in your IDE, or, 
- navigate to the `javaTTT/out/test/javaTTT` and enter `java com/javaTTT/<test file>` on the command line.

##Versions
This program was written using the Java SE Development Kit 8 and the IntelliJ IDEA 13.1 Community Edition IDE.

##Notes
Please note that the game is only configured to receive valid player input. Entering either (a) an integer that is not a valid index for the board or (b) a non-integer will cause an exception to be thrown and will end the game early.
