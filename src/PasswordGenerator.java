// this class works as the backed and will generate the password

import java.util.Random;

public class PasswordGenerator {
    //character polls
    //these Strings will hold the characters/numbers/symbols that are going to randomly pick to generate our password
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%*&+(){}[]:;.,<>/?";

    // the random class allows us to generate a random number witch will be used to randomly choose the characters
    private final Random random;

    //constructor 
    public PasswordGenerator(){random = new Random();}

    // length - length of the password to be generated (taken from the user);
    // includeUpperCase and etc... considers if the password should include uppercase, lowercase, etc... (taken from the user)
    public String generatePassword(int length, boolean includeUpperCase, boolean includeLowerCase, boolean includeNumbers,boolean includeSpecialSymbous){
    // we will sting builder over string for better efficiency
    StringBuilder passwordBuilder = new StringBuilder ();
    
    //store valid characters (toggle states)
    String validCharacters = "";
    if (includeUpperCase) validCharacters += UPPERCASE_CHARACTERS;
    if (includeLowerCase) validCharacters += LOWERCASE_CHARACTERS;
    if (includeNumbers) validCharacters += NUMBERS;
    if (includeSpecialSymbous) validCharacters += SPECIAL_SYMBOLS;

    // build password 
    for(int i = 0; i < length; i++){
        //generate a random index
        int randomIndex = random.nextInt(validCharacters.length());

        //get the char based on the random index
        char randomChar = validCharacters.charAt(randomIndex);
        
        // store char into password builder
        passwordBuilder. append(randomChar);
        
        // do this until we reached the length that the user has provided to us
    }
        //return the result
        return passwordBuilder.toString();
    }
}
