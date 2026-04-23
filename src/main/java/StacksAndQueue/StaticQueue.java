package StacksAndQueue;

public class StaticQueue<E> implements Queue<E>{
    private int first;

    private int last;

    private E elements[];

    public StaticQueue(int maxSize) {
        elements = (E[])new Object[maxSize];
        first = last = -1;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return first == ((last + 1) % elements.length);
    }

    public int numElements() {
        if (isEmpty())
            return 0;
        else {
            int n = elements.length; // p/ legibilidade da expressÃ£o abaixo
            return ((n + last - first) % n) + 1;
        }
    }

    public void enqueue(E element) throws OverFlowException {
        if (isFull())
            throw new OverFlowException();
        else {
            if (last == -1)
                first = last = 0;
            else
                last = (last + 1) % elements.length;
            elements[last] = element;
        }

    }

    public E dequeue() throws UnderFlowException {
        if (isEmpty())
            throw new UnderFlowException();
        E element = elements[first];
        elements[first] = null; // p/ coleta de lixo
        if (first == last)
            first = last = -1;
        else
            first = (first + 1) % elements.length;

        return element;
    }

    public E front() throws UnderFlowException {
        if (isEmpty())
            throw new UnderFlowException();
        return elements[first];
    }

    public E back() throws UnderFlowException {
        if (isEmpty())
            throw new UnderFlowException();
        return elements[last];
    }

    public String toString() {
        if (isEmpty())
            return "[Empty]";
        else {
            String s = "[" + elements[first];
            int n = numElements();
            for (int i = 1; i < n; i++) {
                int k = (first + i) % elements.length;
                s += ", " + elements[k];
            }
            s += "]";
            return s;
        }
    }

    public boolean contains(E element) {
        while (!isEmpty()) {
            if (front() == element)
                return true;
            dequeue();
        }
        return false;
    }

    public void flip(){
        E aux[] = (E[])new Object[numElements()] ;
        for(int i=0; i<aux.length; i++) {
            aux[i] = dequeue();
        }
        for(int i=aux.length-1; i>=0; i--) {
            enqueue(aux[i]);
        }
    }
}
