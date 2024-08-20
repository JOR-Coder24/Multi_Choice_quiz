# Overview
QuizApp is a simple console-based quiz application written in Java. It reads questions and answers from an Excel file and quizzes the user interactively. The application tracks the user's score and displays it at the end of the quiz.

Prerequisites
Java Development Kit (JDK): Ensure that you have JDK 8 or later installed on your system.
Apache POI Library: This application uses Apache POI to read Excel files. Make sure to include the necessary Apache POI libraries in your project.

Usage
Ensure that Questions.xlsx is in the same directory as QuizApp.java.

Compile the QuizApp.java file:
javac -cp .;path/to/poi.jar;path/to/poi-ooxml.jar QuizApp.java
(Replace path/to/poi.jar and path/to/poi-ooxml.jar with the actual paths to the Apache POI jars.)

Run the compiled QuizApp:
java -cp .;path/to/poi.jar;path/to/poi-ooxml.jar QuizApp


Have also made a python translation which also allows the user to choose number of questions and has random selection of questions
