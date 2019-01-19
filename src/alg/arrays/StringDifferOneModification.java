package alg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringDifferOneModification {

    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter a first string: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in1 = reader.readLine();
        System.out.println("Please, enter a second string: ");
        String in2 = reader.readLine();
        boolean isOneModificaton = isOneModBetweenTwoStrings(in1, in2);
        System.out.println("Strings: " + in1 + " " + in2 + " differ at one modification: " + isOneModificaton);

    }

    private static boolean isOneModBetweenTwoStrings(String in1, String in2) {
        int length1 = in1.length();
        int length2 = in2.length();
        if (length1 == length2) {
            return IsOneReplace(in1, in2);
        } else if (length1 == length2 - 1) {
            return isOneAdd(in1, in2);
        } else if (length1 == length2 + 1) {
            return isOneRemove(in1, in2);
        } else {
            return false;
        }
    }

    private static boolean IsOneReplace(String in1, String in2) {
        boolean flagOneDifferFound = false;
        for (int i = 0; i < in1.length(); ++i) {
            if (in1.charAt(i) != in2.charAt(i)) {
                if (flagOneDifferFound) {
                    return false;
                }
                flagOneDifferFound = true;
            }
        }
        return true;
    }

    private static boolean isOneAdd(String in1, String in2) {
        boolean flagOneAddFound = false;
        for (int i = 0, j = 0; i < in1.length(); ++i, ++j) {
            if (in1.charAt(i) != in2.charAt(j)) {
                if (flagOneAddFound) {
                    return false;
                }
                ++j;
                flagOneAddFound = true;
            }
        }
        return true;
    }

    private static boolean isOneRemove(String in1, String in2) {
        return isOneAdd(in2, in1);
    }
}
