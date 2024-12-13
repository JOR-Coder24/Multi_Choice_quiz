# Quiz App README

## Overview

This project contains two versions of a simple quiz application that reads questions from an Excel file and allows the user to answer them. The app is implemented in both **Python** and **Java**, and the core functionality is the same in both versions:

1. The quiz app loads questions from a `Questions.xlsx` Excel file.
2. The user is prompted to select how many questions they want to answer.
3. The app displays each question with four options (A, B, C, D).
4. The user selects an answer, and the app checks if it's correct.
5. The app calculates and displays the final score.

### Requirements

1. **Python version**:
   - Python 3.x
   - `openpyxl` library for reading Excel files
   - Install with: `pip install openpyxl`

2. **Java version**:
   - Java 8 or higher
   - Apache POI library for reading Excel files
   - Add the following dependencies to your `pom.xml` (if using Maven):
     ```xml
     <dependency>
         <groupId>org.apache.poi</groupId>
         <artifactId>poi-ooxml</artifactId>
         <version>5.2.3</version>
     </dependency>
     ```

3. **Excel file format**:
   - The quiz questions must be stored in a file named `Questions.xlsx` in the following format:
     - Column 1: Question
     - Column 2: Option A
     - Column 3: Option B
     - Column 4: Option C
     - Column 5: Option D
     - Column 6: Correct Answer (A, B, C, or D)

## How to Run the Python Version

1. Ensure that you have Python installed on your machine.
2. Install the `openpyxl` library using pip:
   ```bash
   pip install openpyxl
   ```
3. Place the `Questions.xlsx` file in the same directory as the Python script.
4. Run the script:
   ```bash
   python quiz_app.py
   ```
5. The app will prompt you to enter the number of questions you want to answer and guide you through the quiz.

## How to Run the Java Version

1. Ensure that you have Java installed on your machine.
2. Add the Apache POI dependencies to your project (for example, via Maven or manually).
3. Place the `Questions.xlsx` file in the same directory as the Java source code.
4. Compile and run the Java program:
   ```bash
   javac QuizApp.java
   java QuizApp
   ```
5. The app will prompt you to enter the number of questions you want to answer and guide you through the quiz.

## Excel File Format

The `Questions.xlsx` file must have the following columns:
1. **Question**: The text of the question.
2. **Option A**: The first answer option.
3. **Option B**: The second answer option.
4. **Option C**: The third answer option.
5. **Option D**: The fourth answer option.
6. **Correct Answer**: The correct answer (either A, B, C, or D).

Example `Questions.xlsx`:

| Question                             | Option A   | Option B   | Option C   | Option D   | Correct Answer |
|--------------------------------------|------------|------------|------------|------------|----------------|
| What is the capital of France?       | Paris      | London     | Rome       | Berlin     | A              |
| Which is the largest planet?         | Earth      | Mars       | Jupiter    | Venus      | C              |
| Who wrote "To Kill a Mockingbird"?   | Harper Lee | J.K. Rowling| Mark Twain | F. Scott Fitzgerald | A        |

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Troubleshooting

- **Excel File Format**: Make sure that the `Questions.xlsx` file follows the correct format.
- **Missing Library**: Ensure that you've installed the necessary libraries (`openpyxl` for Python or Apache POI for Java).
- **File Not Found**: Ensure the `Questions.xlsx` file is located in the correct directory.
