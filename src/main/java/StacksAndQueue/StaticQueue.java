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

    public void flip(){
        E aux[] = (E[])new Object[numElements()] ;
        for(int i=0; i<aux.length; i++) {
            aux[i] = dequeue();
        }
        for(int i=aux.length-1; i>=0; i--) {
            enqueue(aux[i]);
        }
    }
    public void prependQueue(Queue<Integer> q1, Queue<Integer> q2){
        Queue<Integer>q3 = new StaticQueue<>(q1.numElements());
        while(!q1.isEmpty()){
            q3.enqueue(q1.dequeue());
        }
        while(!q2.isEmpty()){
            q1.enqueue(q2.dequeue());
        }
        while(!q3.isEmpty()){
            q1.enqueue(q3.dequeue());
        }
    }
    public void exterminateFromQueue(Queue<Character> q, char element){
        Queue<Character> aux = new StaticQueue<>(q.numElements());
        while(!q.isEmpty()){
            char atual = q.dequeue();
            if(atual != element){
                aux.enqueue(atual);
            }
        }
        while(!aux.isEmpty()){
            q.enqueue(aux.dequeue());
        }
    }
    public boolean contains(E element){
        Queue<E> q1 = new StaticQueue<>(this.numElements());
        boolean encontrou = false;

        while(!this.isEmpty()){
            E e1 = this.dequeue();
            if(e1.equals(element)) {
                encontrou = true;
            }
            q1.enqueue(e1);
        }
        while(!q1.isEmpty()){
            this.enqueue(q1.dequeue());
        }
        return encontrou;
    }

    public void enqueue(Queue<E> q2) {
        Queue<E> aux = new StaticQueue<>(q2.numElements());

        while (!q2.isEmpty()) {
            E elemento = q2.dequeue();

            this.enqueue(elemento);

            aux.enqueue(elemento);
        }
        while (!aux.isEmpty()) {
            q2.enqueue(aux.dequeue());
        }
    }

    public void enqueueWithPriority(E element){
        Queue<E> aux = new StaticQueue<>(this.numElements());
        while(!this.isEmpty()){
            aux.enqueue(this.dequeue());
        }

        this.enqueue(element);

        while(!aux.isEmpty()){
            this.enqueue(aux.dequeue());
        }

    }

    public boolean equals(Queue<E>q1,Queue<E>q2){
        if(q1.numElements() != q2.numElements()){
            return false;
        }
        Queue<E> q3 = new StaticQueue<>(q1.numElements());
        Queue<E> q4 = new StaticQueue<>(q2.numElements());
        boolean iguais = true;

        while(!q1.isEmpty()){
            E e1 = q1.dequeue();
            E e2 = q2.dequeue();

            q3.enqueue(e1);
            q4.enqueue(e2);
            if(!e1.equals(e2)){
                iguais = false;
            }
        }
        while(!q3.isEmpty()){
            q1.enqueue(q3.dequeue());
            q2.enqueue(q4.dequeue());
        }
        return iguais;
    }

    public Queue<E> clone(Queue<E>q){
        Queue<E>q1 = new StaticQueue<>(q.numElements());
        Queue<E>aux = new StaticQueue<>(q.numElements());

        while(!q.isEmpty()){
            aux.enqueue(q.dequeue());
        }

        while(!aux.isEmpty()){
            E ele = aux.dequeue();
            q.enqueue(ele);
            q1.enqueue(ele);
        }
        return q1;
    }

    public Queue<E> split(E element){
        Queue<E> inicio = new StaticQueue<>(this.numElements());
        Queue<E> fim = new StaticQueue<>(this.numElements());
        boolean encontrou = false;
        while(!this.isEmpty()){
            E el = this.dequeue();
            if(!encontrou){
                inicio.enqueue(el);
                if(el.equals(element)){
                    encontrou = true;
                }else{
                    fim.enqueue(el);
                }
            }
        }
        while (!inicio.isEmpty()) {
            this.enqueue(inicio.dequeue());
        }
        return fim;
    }
    public void moveToBackAllOccurrencesOf(E element){
        Queue<E> fila = new StaticQueue<>(this.numElements());
        Queue<E> vag = new StaticQueue<>(this.numElements());
        while(!this.isEmpty()){
            E el = this.dequeue();
            if(el.equals(element)){
                fila.enqueue(el);
            }else{
                vag.enqueue(el);
            }
        }
        while(!vag.isEmpty()){
            this.enqueue(vag.dequeue());
        }

        while(!fila.isEmpty()){
            this.enqueue(fila.dequeue());
        }
    }

    public void ensureCapacity(int capacity){
        if (capacity <= elements.length) return;

        E[] novoArray = (E[]) new Object[capacity];
        int atualSize = numElements();

        for (int i = 0; i < atualSize; i++) {
            novoArray[i] = elements[(first + i) % elements.length];
        }

        this.elements = novoArray;
        this.first = 0;
        this.last = atualSize;
    }

}
