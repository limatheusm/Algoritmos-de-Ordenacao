public class HeapSort {
    /*
     * HeapSort
     *
     * Heap = é um vetor que pode ser visto como uma árvore binária incompleta
     * Elementos até o tamanho do heap fazem parte do indice
     *
     * Estrutura do heap
     *  Primeiro elemento do vetor é o nó raiz
     *  O nó pai = i/2
     *  O nó Filho Esquerdo = 2*1 + 1
     *  O nó filho direito = 2*1 + 2
     *
     * Heap Máximo
     *  Para todo elemento diferente da raiz, tem-se:
     *      a[pai[i]] >= a[i]
     *  Ou seja, o valor de um nó é no máximo o valor de seu pai(maior elemento na raiz)
     *
     * Max Heapify
     *  Função que coloca em um estado de heap
     *  Árvores com raizes Esq e Dir são heap Máximo, mas a[i] nao necessariamente
     *  Objetivo: Flutuar a[i] para garantir um heap máximo
     *
     *  É possivel utilizar a função MAX HEAPIFY para construirmos um heap máximo
     *
     * HeapSort
     *  Dado um vetor, é criado um heap máximo
     *  Maior elemento na raiz, troca-se com o ultimo elemento do vetor, diminuindo
     *  o tamanho do heap em 1. Refaz o procedimento
     *
     * Heapsort serve para aplicações que nao podem tolerar eventualmente um caso
     * desfavorável.
     *
     * Comportamento é sempre O(n lg n)
     *
     * Não estável
     */

    private static void maxHeapify(Integer[] a, int i, int n){

        int left = (2 * i) + 1;
        int right = left + 1;

        int largest;

        //faz parte do HEAP e o no esq é o maior numero
        if(left <= n && a[left] > a[i])
            largest = left;
        else
            largest = i;

        if(right <= n && a[right] > a[largest])
            largest = right;

        if(largest != i){
            swap(a, i, largest);
            //verifica se a alteração continua no maxHeap
            maxHeapify(a, largest, n);
        }
    }

    public static void buildHeap(Integer a[]){
        int n = a.length - 1;

        for(int i = (n / 2); i >= 0; i--)
            maxHeapify(a, i, n);
    }

    public static void sort(Integer a[]){
        buildHeap(a);

        int n = a.length - 1;

        for(int i = n ; i > 0; i--){
            swap(a,0,i);
            n--;
            maxHeapify(a, 0, n);
        }
    }

    private static void swap(Integer a[], int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}