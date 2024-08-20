import openpyxl
import random

def run_quiz():
    # Load the Excel file
    workbook = openpyxl.load_workbook('Questions.xlsx')
    sheet = workbook.active  # Use the first sheet

    # Read all rows into a list (skipping the header row)
    questions = []
    for row in sheet.iter_rows(min_row=2, values_only=True):
        questions.append(row)

    # Ask the user how many questions they want to attempt
    total_questions = len(questions)
    num_questions = int(input(f"How many questions would you like to answer? (Max {total_questions}): "))

    if num_questions > total_questions or num_questions <= 0:
        print(f"Invalid input. Please choose a number between 1 and {total_questions}.")
        return

    # Randomly select the specified number of questions
    selected_questions = random.sample(questions, num_questions)

    score = 0

    # Loop through each selected question
    for i, question_data in enumerate(selected_questions, start=1):
        question, optionA, optionB, optionC, optionD, correct_answer = question_data

        # Display the question and options
        print(f"\nQuestion {i}: {question}")
        print(f"A: {optionA}")
        print(f"B: {optionB}")
        print(f"C: {optionC}")
        print(f"D: {optionD}")

        # Get the user's answer
        user_answer = input("Enter your answer (A/B/C/D): ").strip().upper()

        # Check if the answer is correct
        if user_answer == correct_answer.strip().upper():
            score += 1

    # Display the final score
    print(f"\nQuiz complete! Your score: {score} out of {num_questions}")

if __name__ == "__main__":
    run_quiz()
