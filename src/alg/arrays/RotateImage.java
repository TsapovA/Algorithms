package alg.arrays;

public class RotateImage {

    private static final int MATRIX_SIZE = 6;

    public static void main(String[] args) {
        int[][] mass = init();
        System.out.println("Init: ");
        display(mass);

        rotate(mass);
        System.out.println("After transforming: ");
        display(mass);
    }

    private static int[][] init() {
        int[][] res = new int[MATRIX_SIZE][MATRIX_SIZE];
        for(int i = 0; i < MATRIX_SIZE / 2; ++i) {
            for (int j = 0; j < MATRIX_SIZE; ++j) {
                res[i][j] = 0;
            }
        }

        for(int i = MATRIX_SIZE / 2; i < MATRIX_SIZE; ++i) {
            for (int j = 0; j < MATRIX_SIZE; ++j) {
                res[i][j] = 1;
            }
        }
        return res;
    }

    private static void display(int[][] mass) {
        for (int i = 0; i < MATRIX_SIZE; ++i) {
            for (int j = 0; j < MATRIX_SIZE; ++j) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] mass) {
        int topElement;
        int maxIndex = MATRIX_SIZE - 1;
        for (int row = 0; row < MATRIX_SIZE / 2; ++row) {
            for (int col = row; col < MATRIX_SIZE - 1 - row; ++col) {

                // top = left
                topElement = mass[row][col];
                mass[row][col] = mass[maxIndex - col][row];

                // left = down
                mass[maxIndex - col][row] = mass[maxIndex - row][maxIndex - col];

                // down = right
                mass[maxIndex - row][maxIndex - col] = mass[col][maxIndex - row];

                // right = top
                mass[col][maxIndex - row] = topElement;
            }
        }
    }
}
