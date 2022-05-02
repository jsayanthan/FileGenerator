package com.ulventech.filegenerator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FileGeneratorTest {
    FileGenerator fileGenerator;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        fileGenerator = new FileGenerator();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Test unique string")
    void generateFileAndUniqueStrings(@TempDir File temDirectory) {
        assertTrue(temDirectory.isDirectory(), "Should be a directory ");
        File temFile = new File(temDirectory, "testInput.txt");
        File testFile = new File("src/test/resources/test_unique_string.txt");
        fileGenerator.generateFileAndUniqueStrings(28, temFile.getPath());
        assertAll(
                () -> assertTrue(Files.exists(temFile.toPath()), "File should exist"),
                () -> assertTrue(Files.exists(testFile.toPath()), "File should exist"),
                () -> assertEquals(Files.readAllLines(testFile.toPath()),
                        Files.readAllLines(temFile.toPath()), "File content should be identical"),
                () -> assertLinesMatch(Files.readAllLines(testFile.toPath()),
                        Files.readAllLines(temFile.toPath()), "No of line should be equal"));
    }

    @Nested
    class TestUserInput {
        @Test
        @DisplayName("Test valid user input")
        void tetGetUserInputForValidValue() {
            InputStream sysInBackup = System.in;
            ByteArrayInputStream in = new ByteArrayInputStream("10".getBytes());
            System.setIn(in);
            assertEquals(10, fileGenerator.getUserInput(), "Value should be an integer");
            System.setIn(sysInBackup);
        }

        @Test
        @DisplayName("Test invalid user input")
        void tetGetUserInputForInvalidValue() {
            InputStream sysInBackup = System.in;
            ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes());
            System.setIn(in);
            assertThrows(NoSuchElementException.class, () -> {
                fileGenerator.getUserInput();
            }, "Value should be a string");
            System.setIn(sysInBackup);
        }
    }

    @Test
    @DisplayName("validate user input")
    void isValidInput() {
        assertAll(
                () -> assertTrue(fileGenerator.isValidInput(55), "Value should be between 1 and 299"),
                () -> assertFalse(fileGenerator.isValidInput(555), "Value should be greater that 299"),
                () -> assertFalse(fileGenerator.isValidInput(-33), "value should be negative"));
    }
}