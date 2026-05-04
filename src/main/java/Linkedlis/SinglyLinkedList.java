package Linkedlis;

import ListsJ.List;
import ListsJ.UnderflowException;

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int numElements;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.numElements = 0;
    }

    public int numElements() {
        return numElements;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }

    public void insertFirst(E element) throws NullPointerException{
        if (element == null) throw new NullPointerException();

        Node<E> newNode = new Node<>(element);
        if (isEmpty())
            head = tail = newNode;
        else {
            newNode.setNext(head);
            head = newNode;
        }
        numElements++;
    }

    public void insertLast(E element) throws NullPointerException{
        if (element == null) throw new NullPointerException();

        Node<E> newNode = new Node<>(element);
        if (isEmpty())
            head = tail = newNode;
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        numElements++;
    }

    public E removeFirst() throws UnderflowException{
        if (isEmpty()) throw new UnderflowException();

        E element = head.getElement();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();

        numElements--;
        return element;
    }

    public E removeLast() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();

        E element = tail.getElement();

        if (head == tail)
            head = tail = null;
        else {
            Node<E> current = head;
            while (current.getNext() != tail)
                current = current.getNext();
            tail = current;
            current.setNext(null);
        }

        numElements--;
        return element;
    }

    public void insert(E element, int pos) throws NullPointerException, IndexOutOfBoundsException {
        if (element == null) throw new NullPointerException();
        if (pos < 0  ||  pos > numElements) throw new IndexOutOfBoundsException();

        if (pos == 0)
            insertFirst(element);
        else if (pos == numElements)
            insertLast(element);
        else {
            Node<E> current = head;
            for (int i = 0; i < pos-1; i++)
                current = current.getNext();

            Node<E> newNode = new Node<>(element);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            numElements++;
        }
    }

    public E remove(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= numElements) throw new IndexOutOfBoundsException();
        if (pos == 0) {
            return removeFirst();
        } else if (pos == numElements - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }
            Node<E> alvo = current.getNext();
            E elementoRemovido = alvo.getElement();

            current.setNext(alvo.getNext());

            numElements--;
            return elementoRemovido;
        }
    }

    public E get(int pos) throws IndexOutOfBoundsException{
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public int search(E element) throws NullPointerException {
        if (element == null) throw new NullPointerException();
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.getElement().equals(element)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public String toString() {
        //TODO
        return null; //apenas para compilar
    }

    public int convertToInt(SinglyLinkedList<Integer>nums){
        if(nums.isEmpty()){
            return 0;
        }
        int resultado = 0;

        for (int i = 0; i < nums.numElements(); i++) {
            int dif = nums.get(i);
            resultado = (resultado * 10) + dif;
        }
        return resultado;
    }

    public int somarLista(SinglyLinkedList<Integer> lista) {
        return somarRecursivo(lista.head);
    }

    private int somarRecursivo(Node<Integer> noAtual) {
        if (noAtual == null) {
            return 0;
        }
        return noAtual.getElement() + somarRecursivo(noAtual.getNext());
    }

    public SinglyLinkedList<E> split(E element) {
        // 1. Criamos a lista que será retornada (a primeira parte)
        SinglyLinkedList<E> primeiraParte = new SinglyLinkedList<>();

        if (isEmpty()) return primeiraParte;

        Node<E> current = head;
        int count = 1;

        while (current != null && !current.getElement().equals(element)) {
            current = current.getNext();
            count++;
        }

        if (current == null) return primeiraParte;

        primeiraParte.head = this.head;
        primeiraParte.numElements = count;

        this.head = current.getNext();
        this.numElements = this.numElements - count;

        current.setNext(null);

        return primeiraParte;
    }
}