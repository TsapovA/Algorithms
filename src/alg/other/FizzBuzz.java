package alg.other;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * FizzBuzz is a fun game mostly played in elementary school.
 * The rules are simple: when your turn arrives, you say the next number.
 * However, if that number is a multiple of five, you should say the word “fizz” (preferably with a French accent)
 * instead. If the number is a multiple of seven, you should say “buzz.”
 * And if it is a multiple of both, you should say “fizzbuzz.”
 * If you mess up, you’re out, and the game continues without you.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz(0, 100);
    }

    private static void fizzBuzz(int low, int high) {
        IntStream.rangeClosed(low, high)
                .mapToObj(val -> val % 7 == 0 ? (val % 5 == 0 ? "fizz-buzz" : "fizz") : val % 5 == 0 ? "buzz" : null)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
