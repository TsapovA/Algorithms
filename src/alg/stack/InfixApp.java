package alg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }

            CustomInToPost trans = new CustomInToPost(input);
            output = trans.doTrans();
            System.out.println("Postix: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufReader = new BufferedReader(isr);
        return bufReader.readLine();

    }
}
