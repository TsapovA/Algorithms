package alg.bits;

public class FromDoubleToBinary {

    private static final String ERROR = "ERROR";

    public static void main(String[] args) {
        double d = 0.25;
        System.out.println(printBinary(d));
    }

    static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return ERROR;
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            // ограничение длины в 32 символа
            if (binary.length() >= 32) {
                return ERROR;
            }

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
}
