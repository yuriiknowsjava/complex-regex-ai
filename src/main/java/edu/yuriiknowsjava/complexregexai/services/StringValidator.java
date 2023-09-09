package edu.yuriiknowsjava.complexregexai.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    public static boolean validateString(String s, int maxLength) {
        // The regex pattern explained:
        // ^: start of string
        // (?=.*[A-Z]): positive lookahead, asserts there's at least one uppercase letter
        // (?=.*[a-z]): positive lookahead, asserts there's at least one lowercase letter
        // (?=.*\d): positive lookahead, asserts there's at least one digit
        // (?=.*[!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~]): positive lookahead, asserts there's at least one special character from the list
        // [^\s]: matches any non-whitespace character
        // {1,maxLength}: matches between 1 and maxLength of the preceding token, which is [^\s] in this case
        // $: end of string
        String patternString = String.format(
                // language=RegExp
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!\"#$%%&'()*+,-./:;<=>?@\\[\\]^_`{|}~])[\\S]{1,%d}$",
                maxLength
        );
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
