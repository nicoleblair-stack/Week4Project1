import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        final int MAX_VALUE = 999;
        boolean[] isPrime = new boolean[MAX_VALUE + 1]; // Array of 1000 elements (indices 0-999)

        // a) Create a Boolean array with all elements initialized to true.
        // Ignore array elements 0 and 1.
        for (int i = 2; i <= MAX_VALUE; i++) {
            isPrime[i] = true;
        }

        // b) Starting with array index 2, determine whether a given element is true.
        for (int p = 2; p * p <= MAX_VALUE; p++) {
            // If isPrime[p] is true, then it is a prime number
            if (isPrime[p]) {
                // Set to false every element whose index is a multiple of p
                for (int i = p * p; i <= MAX_VALUE; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int primeCount = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter("primes.txt"))) {
            // Write prime numbers to the file
            for (int i = 2; i <= MAX_VALUE; i++) {
                if (isPrime[i]) {
                    writer.println(i);
                    primeCount++;
                }
            }
            // Add an empty line before the total count
            writer.println();
            writer.println("Total prime numbers: " + primeCount);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}