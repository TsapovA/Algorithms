package alg.customStack;

public class IntStack {

    private int[] mass;
    private int size;
    private int numOfElements;

    public IntStack(int size) {
        mass = new int[size];
        numOfElements = 0;
    }

    public void push(int ch) {
        mass[numOfElements++] = ch;
    }

    public int pop() {
        return mass[--numOfElements];
    }

    public boolean isFull(){
        return mass.length == size;
    }

    public boolean isEmpty(){
        return numOfElements == 0;
    }

    public void displayStack(){
        for (int i = 0; i < numOfElements; ++i) {
            System.out.print(mass[i]);
        }
        System.out.println();
    }

    public int size(){
        return numOfElements;
    }
}
