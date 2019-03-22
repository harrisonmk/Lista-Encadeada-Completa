package ListaEncadeada;

public class Lista {

    //Atributos
    public No primeiro;
    public No ultimo;
    public int quantNo;

    //construtor sendo inicializado com todos os elementos vazio
    public Lista() {

        this.primeiro = null;
        this.ultimo = null;
        this.quantNo = 0;

    }

    //metodos getters e setters
    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getQuantNo() {
        return quantNo;
    }

    public void setQuantNo(int quantNo) {
        this.quantNo = quantNo;
    }

    //metodo para verificar se a lista está vazia
    public boolean ehVazia() {

        return this.primeiro == null;

    }

    //metodo para inserir um elemento na primeira posição
    public void inserirPrimeiro(int elemento) {

        No novoNo = new No(elemento);
        if (this.ehVazia()) {
            this.ultimo = novoNo;
        }
        novoNo.setProx(this.primeiro);
        this.primeiro = novoNo;
        this.quantNo++;

    }

    //metodo para inserir um elemento na ultima posição
    public void inserirNoUltimo(int elemento) {

        No novoNo = new No(elemento);
        if (this.ehVazia()) {
            this.primeiro = novoNo;
        } else {
            this.ultimo.setProx(novoNo);
        }
        this.ultimo = novoNo;
        this.quantNo++;
    }

    //metodo para remover um valor de qualquer posição
    public boolean removerNo(int valor) {

        No atual = primeiro;
        No anterior = null;
        if (ehVazia()) {
            return false;
        } else {
            while ((atual != null) && (!(atual.getElemento() == valor))) {
                anterior = atual;
                atual = atual.getProx();

            }
            if (atual == this.primeiro) {
                if (this.primeiro == this.ultimo) {
                    this.ultimo = null;
                }
                this.primeiro = this.primeiro.getProx();
            } else {
                if (atual == this.ultimo) {
                    this.ultimo = anterior;
                }
                anterior.setProx(atual.getProx());
            }

        }
        this.quantNo--;
        return true;
    }

    //metodo para fazer a busca de um elemento da lista
    public int busca(int valor) {

        No i = this.primeiro;
        while (i != null) {
            if (i.getElemento() == valor) {
                return i.getElemento();
            }

            i = i.getProx();
        }

        return 0;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.quantNo;
    }

    private No pegaNo(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProx();
        }
        return atual;
    }

    //metodo para adicionar elementos em qualquer posição de uma lista
    public void adicionaQualquerPosicao(int posicao, int elemento) {
        if (posicao == 0) { // No começo.
            this.inserirPrimeiro(elemento);
        } else if (posicao == this.quantNo) { // No fim.
            this.inserirNoUltimo(elemento);
        } else {
            No anterior = this.pegaNo(posicao - 1);
            No nova = new No(anterior.getProx(), elemento);
            anterior.setProx(nova);
            this.quantNo++;
        }
    }

    //Metodo para intercalar duas listas
    public void intercalaLista(Lista lista) {

        if (!ehVazia() && !lista.ehVazia()) {
            Lista t = new Lista();
            No t1 = primeiro;
            No t2 = lista.primeiro;
            while (t1 != null && t2 != null) {
                t.inserirPrimeiro(t1.getElemento());
                t.inserirPrimeiro(t2.getElemento());
                t1 = t1.getProx();
                t2 = t2.getProx();
            }
            while (t1 != null) {
                t.inserirPrimeiro(t1.getElemento());
                t1 = t1.getProx();
            }
            while (t2 != null) {
                t.inserirPrimeiro(t2.getElemento());
                t2 = t2.getProx();
            }
            this.primeiro = t.primeiro;
            lista.primeiro = null;
        }

    }

    //Metodo para inserir a lista já ordenada
    void inserirOrdenado(No novoNo) {
        No atual;

        if (this.primeiro == null || this.primeiro.getElemento() >= novoNo.getElemento()) {
            novoNo.Prox = this.primeiro;
            this.primeiro = novoNo;
        } else {

            atual = this.primeiro;

            while (atual.Prox != null && atual.Prox.elemento < novoNo.elemento) {
                atual = atual.Prox;
            }

            novoNo.Prox = atual.Prox;
            atual.Prox = novoNo;
        }
    }

    //metodo para criar um No
    public No novoNo(int elemento) {
        No x = new No(elemento);
        return x;
    }

    //metodo para imprimir a lista
    public void imprimirLista() {

        String msg;
        if (ehVazia()) {
            System.out.println("Lista Vazia\n");
        } else {
            No atual = this.primeiro;
            while (atual != null) {
                System.out.print(" " + atual.getElemento());
                atual = atual.getProx();
            }
        }

    }

    //Metodos para Ordenar a lista
    No mergeSorte(No a, No b) {
        No resultado = null;
        /* casos base */
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.elemento <= b.elemento) {
            resultado = a;
            resultado.Prox = mergeSorte(a.Prox, b);
        } else {
            resultado = b;
            resultado.Prox = mergeSorte(a, b.Prox);
        }
        return resultado;

    }

    No mergeSort(No h) {
        // caso base : se o primeiro é null 
        if (h == null || h.getProx() == null) {
            return h;
        }

        // obtem o meio da lista 
        No meio = getMiddle(h);
        No proxDoMeio = meio.getProx();

        // define o proximo nó do meio para nulo
        meio.Prox = null;

        // aplica o merge sorte na lista da esquerda
        No esquerda = mergeSort(h);

        // aplica o merge sorte na lista da direita
        No direita = mergeSort(proxDoMeio);

        // junta a lista da esquerda e da direita
        No sortedlist = mergeSorte(esquerda, direita);
        return sortedlist;
    }

    // função para obter o meio da lista 
    No getMiddle(No h) {
        //caso base
        if (h == null) {
            return h;
        }
        No parteRapida = h.getProx();
        No parteLenta = h;

        while (parteRapida != null) {
            parteRapida = parteRapida.getProx();
            if (parteRapida != null) {
                parteLenta = parteLenta.getProx();
                parteRapida = parteRapida.getProx();
            }
        }
        return parteLenta;
    }

}
