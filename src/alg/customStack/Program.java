package alg.customStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    public static void main(String[] args) throws IOException {

        //Infix to postfix
/*        System.out.println("Enter an infix: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();

        FromInToPost fromInToPost = new FromInToPost(in);
        fromInToPost.doTransfer();
        fromInToPost.showRes();*/

        //Calc postfix val
        System.out.println("Enter a postfix: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();

        CalcPost calcPost = new CalcPost(in);
        calcPost.calc();
        calcPost.showRes();
    }
}
