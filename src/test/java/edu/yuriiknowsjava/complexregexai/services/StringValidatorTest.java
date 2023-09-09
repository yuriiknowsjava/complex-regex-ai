package edu.yuriiknowsjava.complexregexai.services;

import static edu.yuriiknowsjava.complexregexai.services.StringValidator.validateString;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StringValidatorTest {
    private final List<String> allowedSpecialChars = Arrays.stream("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".split(""))
            .collect(Collectors.toList());

    @Test
    void stringWithSpaceCharactersIsNotValid() {
        Stream<Executable> assertions = Stream.of(" ", "\t", " \t", "\n", "\r", "\n\r", " \r\n", "Why7? ")
                .map(str -> () ->
                        assertFalse(validateString(str, 10), "String should not contain any white space characters: " + str));
        assertAll(assertions);
    }

    @Test
    void testValidateString_withValidStrings() {
        assertTrue(validateString("Aa1!", 10));
        assertTrue(validateString("AbC2#", 10));
        assertTrue(validateString("Xyz3@abc", 10));
    }

    @Test
    void testValidateString_withInvalidStrings() {
        assertFalse(validateString("aa1!", 10), "String missing an uppercase char is not valid");
        assertFalse(validateString("AA1!", 10), "String missing a lowercase char is not valid");
        assertFalse(validateString("Aaa!", 10), "String missing a digit char is not valid");
        assertFalse(validateString("Aaa1", 10), "String missing a special character is not valid");
    }

    @Test
    void testValidateString_withBoundaryCases() {
        assertTrue(validateString("Aa1!", 4), "String containing all the necessary chars and has exactly max length should be valid");
        assertFalse(validateString("Aa1!abc", 6), "String that exceeds max length is not valid");
        assertFalse(validateString("", 10), "Empty string cannot be valid");
    }

    @Test
    void testValidateString_withSpecialCharacters() {
        Stream<Executable> assertions = allowedSpecialChars.stream()
                .map(specialChar -> "Why7" + specialChar)
                .map(str -> () -> assertTrue(validateString(str, 10), String.format("String %s should be valid", str)));
        assertAll(assertions);
    }

    @Test
    void testValidateString_withNotAllowedChar() {
        var notAllowedChar = "©";
        assertFalse(validateString("Why7" + notAllowedChar, 10), "String cannot contain " + notAllowedChar);
    }
}
