package alg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceWhitespaces {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a string: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] res = transformWhitepsaces(str.toCharArray());
        System.out.println("Result: " + String.valueOf(res));
    }

    private static char[] transformWhitepsaces(char[] str) {
        int whitespaceCounter = 0;
        for (char ch : str) {
            if (ch == ' ') {
                ++whitespaceCounter;
            }
        }

        char[] out = new char[str.length + whitespaceCounter * 2];
        int outLastIndex = out.length - 1;
        int inLastCharIndex = str.length - 1;
        int handledWhitespaces = 0;
        for (int i = inLastCharIndex; i >=0; --i) {
            char ch = str[i];
            int handlingIndex = outLastIndex - (inLastCharIndex - i) - 2 * handledWhitespaces;
            if (ch != ' ') {
                out[handlingIndex] = ch;
            } else {
                fillOutWithSpecialSymbol(out, handlingIndex);
                ++handledWhitespaces;
            }
        }

        return out;
    }

    private static void fillOutWithSpecialSymbol(char[] out, int handlingIndex) {
        out[handlingIndex--] = '0';
        out[handlingIndex--] = '2';
        out[handlingIndex] = '%';
    }
}
