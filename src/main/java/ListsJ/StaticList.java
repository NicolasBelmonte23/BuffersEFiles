package ListsJ;

public class StaticList<E> implements List<E> {
    private E[] elements;
    private int numElements;

    public StaticList(int maxSize) {
        elements = (E[]) new Object[maxSize];
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StaticList<?> that = (StaticList<?>) o;
        if (this.numElements != that.numElements()) {
            return false;
        }
        // 5. Comparação de Conteúdo: percorre ambas as listas simultaneamente
        for (int i = 0; i < numElements; i++) {
            Object e1 = this.elements[i];
            Object e2 = that.get(i);

            // Verifica a igualdade dos elementos individuais.
            // Usamos java.util.Objects.equals para tratar casos de elementos nulos com segurança.
            if (!java.util.Objects.equals(e1, e2)) {
                return false;
            }
        }
        return true;
    }

    public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException {
        // verifica se hÃ¡ espaÃ§o na lista
        if (isFull())
            throw new OverflowException();

        // verifica se a posiÃ§Ã£o Ã© vÃ¡lida
        if (pos < 0 || pos > numElements)
            throw new IndexOutOfBoundsException();

        // desloca para a direita os elementos necessÃ¡rios,
        // abrindo espaÃ§o para o novo
        for (int i = numElements - 1; i >= pos; i--)
            elements[i + 1] = elements[i];

        // armazena o novo elemento e ajusta o total
        elements[pos] = element;
        numElements++;
    }

    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
        if (isEmpty())
            throw new UnderflowException();

        // verifica se a posiÃ§Ã£o Ã© vÃ¡lida
        if (pos < 0 || pos >= numElements)
            throw new IndexOutOfBoundsException();

        // guarda uma referencia temporaria ao elemento removido
        E element = elements[pos];

        // desloca para a esquerda os elementos necessarios,
        // sobrescrevendo a posiÃ§Ã£o do que estÃ¡ sendo removido
        for (int i = pos; i < numElements - 1; i++)
            elements[i] = elements[i + 1];

        // define para null a posiÃ§Ã£o antes ocupada pelo Ãºltimo,
        // para que a coleta de lixo possa atuar, e ajusta o total
        elements[numElements - 1] = null;
        numElements--;

        return element;
    }

    public E get(int pos) throws IndexOutOfBoundsException {
        // verifica se a posiÃ§Ã£o Ã© vÃ¡lida
        if (pos < 0 || pos >= numElements)
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
    public String toString() {
        String s = "";
        for (int i = 0; i < numElements; i++)
            s += elements[i] + " ";
        return s;
    }

    public int contaElementos(E el) throws IllegalArgumentException {
        if (el == null) throw new IllegalArgumentException();
        return contaElementos(el, 0);
    }

    private int contaElementos(E el, int i) {
        if (i == numElements()) {
            return 0;
        }
        int encontrou = elements[i].equals(el) ? 1 : 0;
        return encontrou + contaElementos(el, i + 1);
    }

    public boolean remove(E element) throws UnderflowException{
        if(this.isEmpty()) throw new UnderflowException();
        int pos = this.search(element);
        if(pos != -1){
            remove(pos);
            return true;
        }
        return false;
    }

    public void insertAfter(E obj1, E obj2) throws OverflowException{
        if(this.isFull()) throw new OverflowException();
        int pos = this.search(obj1);
        if(pos != -1)
            insert(obj2, pos+1);
    }

    public void swap(int pos1, int pos2) throws IndexOutOfBoundsException{
        if(pos1 < 0 || pos1 >= numElements || pos2 < 0 || pos2 >= numElements)
            throw new IndexOutOfBoundsException();
        E aux = elements[pos1];
        elements[pos1] = elements[pos2];
        elements[pos2] = aux;
    }

    public void flip(){
        for(int i=0; i<numElements; i++)
            insert(remove(numElements-1), i);
    }

    public void insert(List<E> novaLista, int pos) throws OverflowException, IndexOutOfBoundsException{
        if(pos < 0 || pos > numElements)
            throw new IndexOutOfBoundsException();
        for(int i=0; i < novaLista.numElements(); i++)
            insert(novaLista.get(i), pos++);
    }

    public void dedup(){
        for(int i=0; i<numElements-1; i++)
            for(int j=i+1; j<numElements; j++)
                if(elements[i].equals(elements[j]))
                    remove(j--);
    }

    @Override
    public StaticList<E> clone() {
        StaticList<E> novaLista = new StaticList<>(this.elements.length);

        for (int i = 0; i < this.numElements; i++) {
            try {
                novaLista.insert(this.elements[i], i);
            } catch (OverflowException | IndexOutOfBoundsException e) {
            }
        }
        return novaLista;
    }
}
