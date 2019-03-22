package ListaEncadeada;

public class No {

    public int elemento;
    public No Prox;

    // Construtores fiz uma sobrecarga de construtores para poder fazer a inserção
    public No(int elemento) {
        this.elemento = elemento;
        this.Prox = null;
    }

    public No(No prox, int elemento) {
        this.Prox = prox;
        this.elemento = elemento;
    }

    public No() {
    }

    //Metodos Getters e Setters
    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return Prox;
    }

    public void setProx(No Prox) {
        this.Prox = Prox;
    }



}
