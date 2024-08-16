package com.example.quizapp;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        int score = 0;
        int totalQuestions = 0;

        try (FileInputStream fis = new FileInputStream(new File("Questions.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Use the first sheet
            Scanner scanner = new Scanner(System.in);

            // Iterate over each row in the sheet
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue; // Skip empty rows

                String question = getStringCellValue(row.getCell(0));
                String optionA = getStringCellValue(row.getCell(1));
                String optionB = getStringCellValue(row.getCell(2));
                String optionC = getStringCellValue(row.getCell(3));
                String optionD = getStringCellValue(row.getCell(4));
                String correctAnswer = getStringCellValue(row.getCell(5)).trim().toUpperCase();

                System.out.println("Question " + i + ": " + question);
                System.out.println("A: " + optionA);
                System.out.println("B: " + optionB);
                System.out.println("C: " + optionC);
                System.out.println("D: " + optionD);

                System.out.print("Enter your answer (A/B/C/D): ");
                String userAnswer = scanner.nextLine().trim().toUpperCase();

                if (userAnswer.equals(correctAnswer)) {
                    score++;
                }

                totalQuestions++;
            }

            System.out.println("Quiz complete! Your score: " + score + " out of " + totalQuestions);

        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getStringCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }
}
