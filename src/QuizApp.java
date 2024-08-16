package com.example.quizapp;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("Questions.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Use the first sheet
            Scanner scanner = new Scanner(System.in);
            int score = 0;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                String question = row.getCell(0).getStringCellValue();
                String optionA = row.getCell(1).getStringCellValue();
                String optionB = row.getCell(2).getStringCellValue();
                String optionC = row.getCell(3).getStringCellValue();
                String optionD = row.getCell(4).getStringCellValue();
                String correctAnswer = row.getCell(5).getStringCellValue().trim().toUpperCase();

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
            }

            System.out.println("Quiz complete! Your score: " + score + " out of " + sheet.getLastRowNum());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
