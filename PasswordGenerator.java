package PasswordGenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

import PasswordGenerator.Generator.GeneratorLibs;

public class PasswordGenerator {
    public static void main(String[] args) {
        initGenerator();
    }

    static void initGenerator() {
        /*
        * Declaring the variables
        * input as Scanner
        * length as int
        * selectedCharacters as String
        * password as String
        */
        Scanner input = new Scanner(System.in);
        int length = 0;
        String selectedCharacters = "";
        String password = "";
        String[] selectedOptions = new String[4];
        // * End of declaration
        displayMessage("Please enter your desired password length: ");
        length = getLengthOfNewPassword(input);
        int iterator = 0;
        while (true) {
            displayMessage("Choose the list of characters to be used in generation");
            displayMessage("[0] = Uppercase Letters");
            displayMessage("[1] = Lowercase Letters");
            displayMessage("[2] = Numerals");
            displayMessage("[3] = Special Characters (May not be supported in some websites!)");
            displayMessage("[-1] = Continue with the current selection");
            String showSelection = iterator > 0 ? String.join(", ", selectedOptions) : "none";
            displayMessage("Currently Selected: " + showSelection);
            if (iterator >= selectedOptions.length) {
                break;
            }
            selectedOptions[iterator] = getSelectedOption(input, iterator);
            if (selectedOptions[iterator].equals("SKIP")) {
                break;
            }
            iterator++;
        }
        input.close();
        selectedCharacters = GeneratorLibs.getCharacters(selectedOptions);
        GeneratorLibs generator = new GeneratorLibs(length, selectedCharacters);
        password = generator.generatePassword();
        System.out.println(password);
    }

    static int getLengthOfNewPassword(Scanner inputLength) {
        int length = 0;
        while (true) {
            try {
                length = inputLength.nextInt();
                if (length <= 0) {
                    throw new ShortLengthException("Length must not be less than or equals to 0!");
                }
                break;
            } catch (InputMismatchException inputException) {
                displayMessage("Inserted input is not a valid integer!");
                displayMessage("Please enter your desired password length: ");
                inputLength.nextLine();
            } 
            catch (ShortLengthException lengthException) {
                displayMessage(lengthException.getMessage());
                displayMessage("Please enter your desired password length: ");
                inputLength.nextLine();
            }
            catch (Exception generalException) {
                displayMessage("Unhandled exception occurred!");
                displayMessage(generalException.toString());
                inputLength.nextLine();
                break;
            }
        }
        return length;
    }

    static String getSelectedOption(Scanner selectedOption, int iteratorCount) {
        int index = 0;
        String[] selectedCharacter = {"upperCase", "lowerCase", "numerals", "specialCharacters", "SKIP"};
        while (true) {
            try {
                index = selectedOption.nextInt();
                if (index == -1 && iteratorCount > 0) {
                    break;
                }
                if (index < 0) {
                    throw new CharacterOutOfBoundException("Selection must not be less than 0!");
                }
                if (index > 3) {
                    throw new CharacterOutOfBoundException("Selection must not be more than 3!");
                }
                break;
            } catch (InputMismatchException inputException) {
                displayMessage("Inserted input is not a valid integer!");
                displayMessage("Choose the list of characters to be used in generation");
                displayMessage("[0] = Uppercase Letters");
                displayMessage("[1] = Lowercase Letters");
                displayMessage("[2] = Numerals");
                displayMessage("[3] = Special Characters (May not be supported in some websites!)");
                selectedOption.nextLine();
            } 
            catch (CharacterOutOfBoundException outOfBoundException) {
                displayMessage(outOfBoundException.getMessage());
                displayMessage("Choose the list of characters to be used in generation");
                displayMessage("[0] = Uppercase Letters");
                displayMessage("[1] = Lowercase Letters");
                displayMessage("[2] = Numerals");
                displayMessage("[3] = Special Characters (May not be supported in some websites!)");
                selectedOption.nextLine();
            }
            catch (Exception generalException) {
                displayMessage("Unhandled exception occurred!");
                displayMessage(generalException.toString());
                selectedOption.nextLine();
                break;
            }
        }
        return index >= 0 ? selectedCharacter[index] : selectedCharacter[4];
    }
    static void displayMessage(String message) {
        System.out.println(message);
    }
}
