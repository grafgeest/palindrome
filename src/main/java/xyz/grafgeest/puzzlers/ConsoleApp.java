package xyz.grafgeest.puzzlers;

import xyz.grafgeest.puzzlers.service.PalindromeService;
import xyz.grafgeest.puzzlers.util.ProgressBarRotating;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class ConsoleApp {

private static final String Q = "q";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService palindromeService = new PalindromeService();

        System.out.println("Enter \"q\" to exit");

        while (true) {
            //print header
            System.out.println("Enter the maximum number in the range of 1 - 99999");
            System.out.println("to search for the palindrome: ");

            //read line from console
            String input = scanner.nextLine();

            if (Q.equals(input)) {
                System.out.println("Exit!");
                break;
            }

            try {
                long inputNumber = Long.parseLong(input);

                if (inputNumber < 1 || inputNumber > 99999L) {
                    System.out.println("Please, try again and enter a valid number!");
                    continue;
                }

                //get start time
                Instant start = Instant.now();

                //start ProgressBar rotating
                ProgressBarRotating pb = new ProgressBarRotating();
                pb.start();

                String result = palindromeService.getMaxPalindrome(inputNumber);

                //stop ProgressBar rotating
                pb.interrupt();

                //print footer
                System.out.println("\n");
                System.out.println(result);
                System.out.println("Duration time is - " + Duration.between(start, Instant.now()));
                System.out.println("-----------\n");
            } catch (NumberFormatException e) {
                System.out.println("Please, try again and enter a valid number!");
            } catch (Exception e) {
                System.out.println("Oops! :-(");
            }
        }
        scanner.close();
    }
}
