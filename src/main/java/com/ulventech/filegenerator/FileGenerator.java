package com.ulventech.filegenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileGenerator {

    public void generateFileAndUniqueStrings(int noOfLine, String filePath) {
        byte[] uniqueCharacters = new byte[100];
        Arrays.fill(uniqueCharacters, (byte) 'a');

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            for (int i = 0; i < noOfLine; i++) {
                outputStream.write(uniqueCharacters);
                outputStream.write(new byte[]{'\r', '\n'});
                for (int k = 0; k < 2; k++) {
                    uniqueCharacters[k] = (byte) (uniqueCharacters[k] + 1);
                    if (uniqueCharacters[k] <= 'z') {
                        break;
                    } else {
                        uniqueCharacters[k] = 'a';
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Exception occurred while generating the unique string: " + e.getMessage());
        }
    }

    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        do {
            System.out.print("Please Enter value between 1 and 229 : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Input not an Integer, please enter valid Integer between 1 and 229 :");
                scanner.next();
            }
            userInput = scanner.nextInt();
        } while (!isValidInput(userInput));
        return userInput;
    }

    boolean isValidInput(int inputValue) {
        if (inputValue > 0 && inputValue < 230) {
            return true;
        } else {
            System.out.println("Input not in the required range 1 and 229!");
            return false;
        }
    }
}
