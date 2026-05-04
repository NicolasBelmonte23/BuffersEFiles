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
}