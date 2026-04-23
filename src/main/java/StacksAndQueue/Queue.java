package StacksAndQueue;

public interface Queue<E>{
    /**
     * Informa se a fila est‡ vazia.
     * @return Verdadeiro se a fila estiver vazia, falso caso contr‡rio.
     */
    public boolean isEmpty();

    /**
     * Informa se a fila est‡ cheia.
     * @return Verdadeiro se a fila estiver cheia, falso caso contr‡rio.
     */
    public boolean isFull();

    /**
     * Informa a quantidade de elementos armazenados na fila.
     * @return A quantidade de elementos armazenados na fila.
     */
    public int numElements();

    /**
     * Insere um novo elemento na fila.
     * @param element O elemento a ser inserido
     */
    public void enqueue(E element) throws OverFlowException;

    /**
     * Retira um elemento da fila.
     * @return O elemento retirado
     */
    public E dequeue() throws UnderFlowException;

    /**
     * Informa qual o primeiro elemento da fila.
     * @return O primeiro elemento da fila
     */
    public E front() throws UnderFlowException;

    /**
     * Informa qual o śltimo elemento da fila.
     * @return O śltimo elemento da fila
     */
    public E back() throws UnderFlowException;
}
