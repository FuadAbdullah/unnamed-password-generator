package PasswordGenerator.Generator;

import java.util.HashMap;
import org.apache.commons.lang3.RandomStringUtils;

public class GeneratorLibs {
    private int passwordLength;
    private String selectedCharacters;

    public GeneratorLibs() {
        passwordLength = 8;
        selectedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    }

    public GeneratorLibs(int passwordLength, String selectedCharacters) {
        this.passwordLength = passwordLength;
        this.selectedCharacters = selectedCharacters;
    }

    public String getSelectedCharacters() {
        return selectedCharacters;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setSelectedCharacters(String selectedCharacters) {
        this.selectedCharacters = selectedCharacters;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public String generatePassword() {
        String filteredSelectedCharacters = filterUsingRegex();
        return RandomStringUtils.random(getPasswordLength(), filteredSelectedCharacters);
    }

    private String filterUsingRegex() {
        return getSelectedCharacters().replaceAll("(\s)|(null)", "");
    }

    private static HashMap<String, String> initOptions() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("upperCase", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        options.put("lowerCase", "abcdefghijklmnopqrstuvwxyz");
        options.put("numerals", "0123456789");
        options.put("specialCharacters", "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?");
        options.put("SKIP", " ");
        return options;
    }

    public static String getCharacters(String[] selectedOption) {
        HashMap<String, String> options = initOptions();
        StringBuilder selectedCharacters = new StringBuilder();
        for (String option : selectedOption) {
            selectedCharacters.append(options.get(option));
        }
        return selectedCharacters.toString();
    }

}
