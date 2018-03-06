package xyz.grafgeest.puzzlers.model;

public class Palindrome implements Comparable<Palindrome>{
    private long firstFactor;
    private long secondFactor;
    private Long palindrome = new Long(0);

    public Palindrome() {
    }

    public Palindrome(long firstFactor, long secondFactor, Long palindrome) {
        this.firstFactor = firstFactor;
        this.secondFactor = secondFactor;
        this.palindrome = palindrome;
    }

    public long getFirstFactor() {
        return firstFactor;
    }

    public void setFirstFactor(long firstFactor) {
        this.firstFactor = firstFactor;
    }

    public long getSecondFactor() {
        return secondFactor;
    }

    public void setSecondFactor(long secondFactor) {
        this.secondFactor = secondFactor;
    }

    public Long getPalindrome() {
        return palindrome;
    }

    public void setPalindrome(long palindrome) {
        this.palindrome = palindrome;
    }

    public int compareTo(Palindrome o) {
        return palindrome.compareTo(o.getPalindrome());
    }

    @Override
    public String toString() {
        return "Palindrome: " + palindrome + "\n" +
                "firstFactor = " + firstFactor +
                ", secondFactor = " + secondFactor;
    }
}
