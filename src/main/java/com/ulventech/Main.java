package com.ulventech;

import com.ulventech.filegenerator.FileGenerator;
import com.ulventech.util.Constants;

public class Main {
    public static void main(String[] args) {
        FileGenerator fileGenerator = new FileGenerator();
        int userInput = fileGenerator.getUserInput();
        fileGenerator.generateFileAndUniqueStrings(userInput, Constants.FILE_PATH);
    }
}
