package ListsJ;

public class StaticList<E> implements List<E> {
    private E[] elements;
    private int numElements;

    /**
     * ConstrÃ³i uma lista com um tamanho mÃ¡ximo.
     * @param maxSize O tamanho mÃ¡ximo da lista
     */
    public StaticList(int maxSize) {
        elements = (E[])new Object[maxSize];
        numElements = 0;
    }

    public int numElements() {
        return numElements;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean isFull() {
        return numElements == elements.length;
    }

    public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException{
        // verifica se hÃ¡ espaÃ§o na lista
        if (isFull())
            throw new OverflowException();

        // verifica se a posiÃ§Ã£o Ã© vÃ¡lida
        if (pos < 0  ||  pos > numElements)
            throw new IndexOutOfBoundsException();

        // desloca para a direita os elementos necessÃ¡rios,
        // abrindo espaÃ§o para o novo
        for (int i = numElements-1; i >= pos; i--)
            elements[i+1] = elements[i];

        // armazena o novo elemento e ajusta o total
        elements[pos] = element;
        numElements++;
    }

    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException{
        if(isEmpty())
            throw new UnderflowException();

        // verifica se a posiÃ§Ã£o Ã© vÃ¡lida
        if (pos < 0  ||  pos >= numElements)
            throw new IndexOutOfBoundsException();

        // guarda uma referencia temporaria ao elemento removido
        E element = elements[pos];

        // desloca para a esquerda os elementos necessarios,
        // sobrescrevendo a posiÃ§Ã£o do que estÃ¡ sendo removido
        for (int i = pos; i < numElements-1; i++)
            elements[i] = elements[i+1];

        // define para null a posiÃ§Ã£o antes ocupada pelo Ãºltimo,
        // para que a coleta de lixo possa atuar, e ajusta o total
        elements[numElements-1] = null;
        numElements--;

        return element;
    }

    public E get(int pos) throws IndexOutOfBoundsException{
        // verifica se a posiÃ§Ã£o Ã© vÃ¡lida
        if (pos < 0  ||  pos >= numElements)
            throw new IndexOutOfBoundsException();

        return elements[pos];
    }

    public int search(E element) {
        for (int i = 0; i < numElements; i++)
            if (element.equals(elements[i]))
                return i;

        // se chegar atÃ© aqui, Ã© porque nÃ£o encontrou
        return -1;
    }

    /**
     * Retorna uma representaÃ§Ã£o String da lista.
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < numElements; i++)
            s += elements[i] + " ";
        return s;
    }

    public int contaElementos(E el) throws IllegalArgumentException{
        if(el == null)throw new IllegalArgumentException();
        return contaElementos(el,0);
    }
    private int contaElementos(E el,int i){
        if(i == numElements()) {
            return 0;
        }
        int encontrou = elements[i].equals(el) ? 1 : 0;
        return encontrou + contaElementos(el,i+1);
    }
}
