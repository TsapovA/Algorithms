package alg.customStack;

public class CharStack {

    private char[] mass;
    private int size;
    private int numOfElements;

    public CharStack(int size) {
        mass = new char[size];
        numOfElements = 0;
    }

    public void push(char ch) {
        mass[numOfElements++] = ch;
    }

    public char pop() {
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
