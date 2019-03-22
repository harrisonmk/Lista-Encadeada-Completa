package ListaEncadeada;

public class Main {

    public static void main(String[] args) {

        Lista lista = new Lista();

        // Testando a Inserção no Começo
        
        lista.inserirPrimeiro(6);
        lista.inserirPrimeiro(4);
        lista.inserirPrimeiro(3);
        lista.inserirPrimeiro(5);
        lista.inserirPrimeiro(7);

        System.out.println("Lista 1");
        lista.imprimirLista();
        
         // Testando a Remoca
        int valor1 = 3;
        System.out.println("\n%%%%%%%%%%");
        lista.removerNo(valor1);
        System.out.println("valor: " + valor1 + " Removido");
        System.out.println("%%%%%%%%%%");
        lista.imprimirLista();

         // Testando a Busca
        
        int valor = 10;

        if (lista.busca(valor) == 0) {
            System.out.println("\nElemento " + valor + " não encontrado na Lista\n");
        } else {
            System.out.println("\nValor encontrado: " + lista.busca(valor));
        }
        
        
        
        // Testando a Inserção no Final

        Lista lista1 = new Lista();

        lista1.inserirNoUltimo(6);
        lista1.inserirNoUltimo(4);
        lista1.inserirNoUltimo(3);
        lista1.inserirNoUltimo(5);
        lista1.inserirNoUltimo(7);
        
        
        
       
        
        System.out.println("Lista 2");
        lista1.imprimirLista();
        System.out.println();

        Lista lista2 = new Lista();

         
        
        // Testando a inserção em qualquer posição
        System.out.println("\nLista 3");

        lista2.inserirPrimeiro(20);
        lista2.inserirPrimeiro(44);
        lista2.adicionaQualquerPosicao(0, 10);
        lista2.adicionaQualquerPosicao(3, 6);
        lista2.adicionaQualquerPosicao(1, 4);
        lista2.adicionaQualquerPosicao(2, 7);

        lista2.imprimirLista();
        System.out.println();
        
        
        
        // Testando a Intercalação
        Lista lista4 = new Lista();
        
        lista4.inserirPrimeiro(1);
        lista4.inserirPrimeiro(3);
        lista4.inserirPrimeiro(5);
        
       
        
         Lista lista5 = new Lista();
         
         lista5.inserirPrimeiro(2);
         lista5.inserirPrimeiro(4);
         lista5.inserirPrimeiro(6);
         
         lista5.intercalaLista(lista4);
         
         System.out.println("\nLista Intercalada");
        lista5.imprimirLista();
        System.out.println();
         
        
        //Testando inserir os elementos já ordenado
        
        System.out.println();
        Lista lista6 = new Lista();
        No noAcesso;
        
        noAcesso = lista6.novoNo(5);
        lista6.inserirOrdenado(noAcesso);
        noAcesso = lista6.novoNo(4);
        lista6.inserirOrdenado(noAcesso);
        noAcesso = lista6.novoNo(6);
        lista6.inserirOrdenado(noAcesso);
        noAcesso = lista6.novoNo(7);
        lista6.inserirOrdenado(noAcesso);
        noAcesso = lista6.novoNo(8);
        lista6.inserirOrdenado(noAcesso);
        
        System.out.println("Lista Inserida já Ordenada");
        lista6.imprimirLista();
        System.out.println();
        
        
        //Testando Metodo para Ordenar a Lista
        System.out.println();
        Lista lista7 = new Lista();
        
        lista7.inserirNoUltimo(4);
        lista7.inserirNoUltimo(5);
        lista7.inserirNoUltimo(7);
        lista7.inserirNoUltimo(9);
        lista7.inserirNoUltimo(8);
        lista7.inserirNoUltimo(1);
        lista7.inserirNoUltimo(10);
        
        
        lista7.primeiro = lista7.mergeSort(lista7.primeiro);
       
        System.out.println("Ordenando a Lista");
        lista7.imprimirLista();
        System.out.println();
        
    }

}
