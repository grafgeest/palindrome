package xyz.grafgeest.puzzlers.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import xyz.grafgeest.puzzlers.service.PalindromeService;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeServiceTest {

    private PalindromeService palindromeService;

    @Before
    public void setUp() {
        palindromeService = new PalindromeService();
    }

    @Test
    public void testIsPrime() {
        Instant start = Instant.now();
        boolean isPrime = palindromeService.isPrime(9L);
        assertFalse(isPrime);
        System.out.println("Duration time is - " + Duration.between(start, Instant.now()));
    }

    @Test @Ignore
    public void testIsProbablePrime() {
        Instant start = Instant.now();
        boolean isPrime = palindromeService.isProbablePrime(9L);
        assertFalse(isPrime);
        System.out.println("Duration time is - " + Duration.between(start, Instant.now()));
    }

    @Test
    public void testIsPalindrome() {
        Instant start = Instant.now();
        boolean isPalindrome = palindromeService.isPalindrome(999949999L);
        assertTrue(isPalindrome);
        System.out.println("Duration time is - " + Duration.between(start, Instant.now()));
    }

    @Test
    public void testIsPalindromeReflection() {
        Instant start = Instant.now();
        String arg = "999949999";
        boolean isPalindrome = palindromeService.isPalindrome(arg);
        assertTrue(isPalindrome);
        System.out.println("Duration time is - " + Duration.between(start, Instant.now()));
    }

    @Test
    public void testIsProbablePalindrome() {
        Instant start = Instant.now();
        boolean isPalindrome = palindromeService.isProbablePalindrome(999949999L);
        assertTrue(isPalindrome);
        System.out.println("Duration time is - " + Duration.between(start, Instant.now()));
    }

    @Test()
    public void testGetAllPrimes() {
        for (int i = 0; i < 5000; i++) {
            List<Long> primes = palindromeService.getAllPrimes(9);
            assertEquals(5, primes.size());
        }
    }

    @Test
    @Ignore
    public void testGetAllPrimes8() {
        Instant start = Instant.now();
        List<Long> primes = palindromeService.getAllPrimes8(9);
        System.out.println("Duration time is - " + Duration.between(start, Instant.now()));

        assertEquals(5, primes.size());
    }


    @Test
    public void testGetMaxPalindrome(){
        String maxPalindrome = palindromeService.getMaxPalindrome(9);
        assertTrue(maxPalindrome.contains("Palindrome: 9"));
    }
}