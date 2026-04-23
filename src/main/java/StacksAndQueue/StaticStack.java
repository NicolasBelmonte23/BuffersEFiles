package StacksAndQueue;

public class StaticStack<E> implements Stack<E>{
    private int top;

    private E elements[];

    public StaticStack(int maxSize) {
        elements = (E[])new Object[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int numElements() {
        return top + 1;
    }

    public void push(E element) throws OverFlowException{
        if (isFull())
            throw new OverFlowException();
        elements[++top] = element;
    }

    public E pop() throws UnderFlowException {
        if (isEmpty())
            throw new UnderFlowException();
        E element = elements[top];
        elements[top--] = null; // p/ coleta de lixo
        return element;
    }

    public E top() throws UnderFlowException {
        if (isEmpty())
            throw new UnderFlowException();
        return elements[top];
    }

    public String toString() {
        if (isEmpty())
            return "[Empty]";
        else {
            String s = "[";
            for (int i = numElements() - 1; i >= 0; i--) {
                s += "\n" + elements[i];
            }
            s += "\n]";
            return s;
        }
    }

}
