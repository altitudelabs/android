package com.genxium.loginapplication.test;

import android.test.InstrumentationTestCase;

import com.genxium.loginapplication.utility.RegexChecker;

public class RegexTest extends InstrumentationTestCase {

    public void test() {
        assertFalse(RegexChecker.validateName("lalala"));
        assertFalse(RegexChecker.validateName("5555888la"));
        assertFalse(RegexChecker.validateName("55558888"));

        assertTrue(RegexChecker.validateName("lalalala"));
        assertTrue(RegexChecker.validateName("lalalahaha"));
        assertTrue(RegexChecker.validateName("lalalahahagugu"));

        assertFalse(RegexChecker.validatePassword("lalala"));
        assertFalse(RegexChecker.validatePassword("lalal5"));
        assertFalse(RegexChecker.validatePassword("la44la3"));

        assertTrue(RegexChecker.validatePassword("........"));
        assertTrue(RegexChecker.validatePassword("..xx...."));
        assertTrue(RegexChecker.validatePassword(".....xx.x"));
        assertTrue(RegexChecker.validatePassword(".....xx.yy??//"));
    }

}
