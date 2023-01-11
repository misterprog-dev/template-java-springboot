package com.dsoumaila.core;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {
    @Test
    public void whenEmptyString_thanAccept() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome(""));
    }

    @Test
    public void whenPalindrome_thanAccept() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome("noon"));
    }

    @Test
    public void whenNotPalindrom_thanReject(){
        Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome("box"));
    }

    @Test
    public void whenNearPalindrom_thanReject(){
        Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome("neon"));
    }
}
