package Linkedlis;

public class DNode<E> {
    protected E element;
    protected DNode<E> next;
    protected DNode<E> previous;

    public DNode(E element) {
        this.element = element;
        next = previous = null;
    }

    public E getElement() {
        return element;
    }
    public DNode<E> getNext(){
        return next;
    }
    public DNode<E> getPrevious(){
        return previous;
    }
    public void setElement(E e) {
        element = e;
    }
    public void setNext(DNode<E> n) {
        next = n;
    }
    public void setPrevious(DNode<E> p) {
        previous = p;
    }

}
