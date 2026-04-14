package ListsJ;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
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
    public void insertAfter(E obj1, E obj2) throws OverflowException, IllegalArgumentException {
        // 1. Verificar se há espaço na lista antes de qualquer coisa
        if (isFull()) {
            throw new OverflowException();
        }

        // 2. Procurar o índice da primeira ocorrência de obj1
        int index = -1;
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(obj1)) {
                index = i;
                break;
            }
        }

        // 3. Se obj1 não for encontrado, lança a exceção
        if (index == -1) {
            throw new IllegalArgumentException("O elemento de referência (obj1) não foi encontrado.");
        }

        // 4. Deslocar os elementos para a direita
        // Importante: i deve começar em numElements e ir até index + 2
        for (int i = numElements; i > index + 1; i--) {
            elements[i] = elements[i - 1];
        }

        // 5. Inserir o novo elemento na posição após obj1 (index + 1)
        elements[index + 1] = obj2;

        // 6. Incrementar o total de elementos da classe
        numElements++;
    }
    public void swap(int pos1, int pos2) throws IndexOutOfBoundsException {
        if (pos1 < 0 || pos1 >= numElements || pos2 < 0 || pos2 >= numElements) {
            throw new IndexOutOfBoundsException("Posição inválida para troca.");
        }
        E temp = elements[pos1];
        elements[pos1] = elements[pos2];
        elements[pos2] = temp;
    }
    public void flip() {
        if (numElements <= 1) {
            return;
        }
        // Percorremos apenas até a METADE da lista.
        // Se percorrermos a lista toda, trocaremos os elementos de volta para a posição original!
        for (int i = 0; i < numElements / 2; i++) {
            // Chamamos o método swap que já criamos.
            // Trocamos o elemento do índice 'i' pelo seu correspondente no fim da lista.
            swap(i, numElements - 1 - i);
        }
    }

    public void insert(StaticList<E> otherList, int pos) throws OverflowException, IndexOutOfBoundsException {
        // 1. Validações iniciais
        if (otherList == null || otherList.isEmpty()) {
            return; // Nada a fazer
        }
        int n = otherList.numElements();
        // Verifica se há espaço para TODOS os novos elementos
        if (this.numElements + n > elements.length) {
            throw new OverflowException();
        }
        // Verifica se a posição de inserção é válida
        if (pos < 0 || pos > numElements) {
            throw new IndexOutOfBoundsException();
        }
        // 2. O "Grande Deslocamento" (Shifting)
        // Deslocamos os elementos existentes 'n' posições para a direita
        for (int i = numElements - 1; i >= pos; i--) {
            elements[i + n] = elements[i];
        }
        // 3. Cópia dos novos elementos
        // Percorremos a lista recebida e encaixamos no buraco aberto
        for (int i = 0; i < n; i++) {
            this.elements[pos + i] = otherList.get(i);
        }
        // 4. Atualização do total de elementos da lista corrente
        this.numElements += n;
    }

    public void dedup(){
        for (int i = 0; i < numElements ; i++) {
            E atual = elements[i];
            for (int j = i+1; j < numElements ;) {
                if(atual.equals(elements[j])){
                    try {
                        remove(j);
                    } catch (UnderflowException | IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }else{
                    j++;
                }
            }
        }
    }
}



