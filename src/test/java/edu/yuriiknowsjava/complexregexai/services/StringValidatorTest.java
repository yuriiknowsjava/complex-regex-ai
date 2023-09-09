package edu.yuriiknowsjava.complexregexai.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StringValidatorTest {

    @Test
    void stringWithSpaceCharactersIsNotValid() {
        Stream<Executable> assertions = Stream.of(" ", "\t", " \t", "\n", "\r", "\n\r", " \r\n")
                .map(str -> () ->
                        assertFalse(
                                StringValidator.validateString(str, 10),
                                "String should not contain any white space characters")
                );
        assertAll(assertions);
    }
}
