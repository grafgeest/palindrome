package xyz.grafgeest.puzzlers.service;

import xyz.grafgeest.puzzlers.model.Palindrome;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PalindromeService {

    protected boolean isPrime(long arg){
        for (long i = 2; i <= arg / 2; i++) {
            if (arg % i == 0) {
                return false;
            }
        }
        return true;
    }

    protected boolean isProbablePrime(long arg){
        BigInteger bigInteger = BigInteger.valueOf(arg);
        return bigInteger.isProbablePrime((int) Math.log(arg));
    }

    protected boolean isPalindrome(long arg){
        String str = Long.toString(arg);
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            if (str.charAt(i) != str.charAt(n-i-1)) return false;
        }
        return true;
    }

    protected boolean isPalindrome(String arg){
        int length = arg.length();
        // If the string only has 1 char or is empty
        if (length < 2)
            return true;
        else {
            // Check opposite ends of the string for equality
            if (arg.charAt(0) != arg.charAt(length - 1)) {
                return false;
            }
            // Function call for string with the two ends snipped off
            else {
                return isPalindrome(arg.substring(1, length - 1));
            }
        }
    }

    protected boolean isProbablePalindrome(long arg) {
        String str = Long.toString(arg);
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }

    protected List<Long> getAllPrimes(long arg){
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= arg; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }

    protected List<Long> getAllPrimes8(long arg){
        return LongStream.range(1, arg).filter(this::isPrime).boxed().collect(Collectors.toList());
    }

    public String getMaxPalindrome(long arg) {
        List<Long> primes = getAllPrimes(arg);
        TreeSet<Palindrome> palindromes = new TreeSet<>();

        primes.forEach(i-> {
            primes.forEach(j -> {
                long result = i * j;
                if (isPalindrome(Long.toString(result))) {
                    palindromes.add(new Palindrome(i, j, result));
                }
            });
        });

        if(palindromes.isEmpty()){
            return "Palindrome not found";
        }

        return palindromes.last().toString();
    }
}
