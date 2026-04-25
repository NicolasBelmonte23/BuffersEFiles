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

    public void flip() {
        E array[] = (E[]) new Object[numElements()];
        int cont = numElements();
        int j = 0;

        for (int i = 0; i < cont; i++) {
            array[i] = pop();
        }

        while (j < array.length) {
            push(array[j]);
            j++;
        }
    }


        public void InverteElementos(Stack<E> stack) {
        if (stack.isEmpty())
            return;
        E last = popLast(stack);
        InverteElementos(stack);
        stack.push(last);
    }

    private <E> E popLast(Stack <E> stack)	{
        E top = stack.pop();

        if (stack.isEmpty()){
            return top;
        }
        else {
            E last= popLast(stack);
            stack.push(top);
            return last;
        }
    }

    public Integer[] itemsExcept(int number, Stack<Integer> p) {
        // 1. Criamos uma pilha auxiliar para não perder os dados
        Stack<Integer> auxiliar = new StaticStack<>(p.numElements());
        int contValidos = 0;

        // 2. Desempilhamos p para auxiliar, contando quantos elementos
        // são diferentes do 'number' (para saber o tamanho do array)
        while (!p.isEmpty()) {
            Integer elemento = p.pop();
            if (elemento != number) {
                contValidos++;
            }
            auxiliar.push(elemento);
        }

        // 3. Criamos o array de retorno com o tamanho exato dos itens válidos
        Integer[] retorno = new Integer[contValidos];
        int index = 0;

        // 4. Restauramos a pilha original 'p' e preenchemos o array
        // Importante: ao voltar de 'auxiliar' para 'p', a ordem original é restaurada
        while (!auxiliar.isEmpty()) {
            Integer elemento = auxiliar.pop();

            // Se não for o número excluído, adicionamos no array
            // Nota: a ordem no array será do fundo para o topo da pilha
            if (elemento != number) {
                retorno[index++] = elemento;
            }

            p.push(elemento); // Devolve para a pilha original
        }

        return retorno;
    }

    public void transferElements(Stack<E> s1, Stack<E> s2){
        Stack<E> s3 = new StaticStack<>(s1.numElements());
        while(!s1.isEmpty()){
            s3.push(s1.pop());
        }
        while(!s3.isEmpty()){
            s2.push(s3.pop());
        }


    }

    public void prependStack(Stack<Integer> p1, Stack<Integer> p2){
        Stack<Integer> p3 = new StaticStack<>(p1.numElements());
        Stack<Integer> p4 = new StaticStack<>(p2.numElements());
        while(!p1.isEmpty()){
            p3.push(p1.pop());
        }
        while(!p2.isEmpty()){
            p4.push(p2.pop());
        }
        while(!p4.isEmpty()){
            p1.push(p4.pop());
        }

        while(!p3.isEmpty()){
            p1.push(p3.pop());
        }
    }

    public void invertStack(Stack<E>p1){
        Stack<E>p2 = new StaticStack<>(p1.numElements());
        Stack<E>p3 = new StaticStack<>(p1.numElements());
        while(!p1.isEmpty()){
            p2.push(p1.pop());
        }
        while(!p2.isEmpty()){
            p3.push(p2.pop());
        }
        while(!p3.isEmpty()){
            p1.push(p3.pop());
        }
    }

    public boolean contains(E element) {

        Stack<E> aux = new StaticStack<>(this.numElements());
        boolean encontrado = false;

        while (!this.isEmpty()) {
            E atual = this.pop();
            if (atual.equals(element)) {
                encontrado = true;
                aux.push(atual);
                break;
            }
            aux.push(atual);
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }

        return encontrado;
    }

    public void push(Stack<E>e) throws OverFlowException{

        Stack<E>p2 = new StaticStack<>(e.numElements());
        while(!e.isEmpty()){
            p2.push(e.pop());
        }
        while(!p2.isEmpty()){
            this.push(p2.pop());
        }

    }

    public boolean equals(Stack<E> p1, Stack<E> p2) {
        if (p1.numElements() != p2.numElements()) {
            return false;
        }

        Stack<E> aux1 = new StaticStack<>(p1.numElements());
        Stack<E> aux2 = new StaticStack<>(p2.numElements());
        boolean saoIguais = true;

        while (!p1.isEmpty()) {
            E el1 = p1.pop();
            E el2 = p2.pop();

            aux1.push(el1);
            aux2.push(el2);

            // Se um único elemento for diferente, a pilha toda é diferente
            if (!el1.equals(el2)) {
                saoIguais = false;
                break;
            }
        }

        // AGORA O PULO DO GATO: Restaurar as pilhas originais
        while (!aux1.isEmpty()) {
            p1.push(aux1.pop());
            p2.push(aux2.pop());
        }

        return saoIguais;
    }

    public Stack<E> clone(Stack<E> e) {
        Stack<E> p1 = new StaticStack<>(e.numElements());
        Stack<E> aux = new StaticStack<>(e.numElements());

        while (!e.isEmpty()) {
            aux.push(e.pop());
        }

        while (!aux.isEmpty()) {
            E elemento = aux.pop();
            e.push(elemento);
            p1.push(elemento);
        }

        return p1;
    }

    public static void main(String[] args) {
            StaticStack<Integer>p1 = new StaticStack<>(4);
            StaticStack<Integer>p2 = new StaticStack<>(4);
            StaticStack<Integer>p3 = new StaticStack<>(4);
            try{
                p1.push(10);
                p1.push(20);
                p1.push(30);
                p1.push(40);

                p2.push(p1.pop()); // p2: [40]
                p2.push(p1.pop()); // p2: [40, 30]
                p2.push(p1.pop()); // p2: [40, 30, 20]
                p2.push(p1.pop()); // p2: [40, 30, 20, 10] -> topo é 10

                p1.push(p2.pop());
                p1.push(p2.pop());


                p3.push(p1.pop());
                p3.push(p1.pop());
                p1.push(p2.pop());
                p3.push(p2.pop());
                p3.push(p1.pop());

                System.out.println("Pilha 1: " + p1);
                System.out.println("Pilha 2: " + p2);
                System.out.println("Pilha 3: " + p3 + p3.top());
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }



