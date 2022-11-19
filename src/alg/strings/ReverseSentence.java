package alg.strings;

/**
 * You have a sentence (simple string). What you need to do:
 * 1. Reverse a string that all the words change their position and keep letters in it (ex "I am good -> good am I")
 * 2. Reverse all letters in words keep current position of the words (ex "I am good -> I ma doog")
 */
public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println(reverserFirstCase("I am really very very good my dear"));
        System.out.println(secondCase("I am really very very good my dear"));
    }

    private static String reverserFirstCase(String str) {
        String[] splitted = str.split(" ");

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = splitted.length - 1; i >= 0; --i) {
            resultBuilder.append(splitted[i]).append(" ");
        }
        return resultBuilder.toString().trim();
    }

    private static String secondCase(String initStr) {
        String[] splitted = initStr.split(" ");
        StringBuilder resultBuilder = new StringBuilder();
        for (String str: splitted) {
            for (int i = str.length() - 1; i >= 0; --i) {
                resultBuilder.append(str.charAt(i));
            }
            resultBuilder.append(" ");
        }
        return resultBuilder.toString().trim();
    }
}
