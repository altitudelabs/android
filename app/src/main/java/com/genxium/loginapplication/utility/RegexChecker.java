package com.genxium.loginapplication.utility;

public class RegexChecker {
    public static boolean validateName(String str) {
        try {
            String regex = "^[a-zA-Z]{8,}$";
            return str.matches(regex);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validatePassword(String str) {
        try {
            String regex = "^.{8,}$"; // matches any character (except line-break) for 8+ times
            return str.matches(regex);
        } catch (Exception e) {
            return false;
        }
    }
}
