
public class Sort {


    private void swap(Integer a[], int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /*
     * SelectionSort
     *     Passar sempre o menor valor do vetor para a primeira
     *     posição, depois o de segundo menor valor para a segunda
     *     posição, e assim é feito sucessivamente com os (n-1) elementos
     *     restantes, até os últimos dois elementos.
     *
     * O algoritmo não é estável.
     *
     * Pior caso: O(n2)
     * Caso medio: O(n2)
     * Melhor caso: O(n2)
     */

    public void selectionSort(Integer v[]){
        int i, j, min;
        int aux;

        for(i = 0; i < v.length - 1; i++){

            min = i;
            //busca o menor valor
            for(j = i; j < v.length; j++){
                if(v[j] < v[min])
                    min = j;
            }

            aux = v[min];
            v[min] = v[i];
            v[i] = aux;
        }
    }

    /*
     * InsertionSort
     *  Ele percorre um vetor de elementos da esquerda
     *  para a direita e à medida que avança vai deixando
     *  os elementos mais à esquerda ordenados.
     *
     *  O número máximo ocorre quando os itens estão
     *  originalmente na ordem reversa.
     *
     *  É o método a ser utilizado quando o arquivo está
     *  quase ordenado.
     *
     * É um bom método quando se deseja adicionar
     * uns poucos itens a um arquivo ordenado, pois o
     * custo é linear.
     *
     * Pior caso: O(n2)
     * Caso medio: O(n2)
     * Melhor caso: O(n2)
     *
     * É estável.
     * Algoritmo dos Jogadores de cartas.
     */

    public void insertionSort(Integer v[]){
        int i, j;
        int aux;

        for(j = 1; j < v.length; j++){

            aux = v[j];

            for(i = j - 1; i >= 0 && v[i] > aux; i--){
                v[i+1] = v[i];
            }

        v[i+1] = aux;
        }
    }

    /*
     * MergeSort sempre divide o problema de forma balanceada
     *(gerando subproblemas de mesmo tamanho)e pode ser representado
     * por uma ávore binária.
     *  cada nó representa uma chamada recursiva do mergeSort
     *  o nó raiz é a chamada inicial
     *  os nós folhas sao vetores de 1 ou 2 numeros (caso base)
     *
     *
     * MergeSort é O(n log n)
     *
     * Mergesort é estável dependendo da implementação.
     *  Na hora de comparar, na recursão é só utilizar <= e não <.
     *
     * Vantagens
     *  Executa sempre em um determinado tempo para n
     * Desvantagens
     *  Utiliza memória auxiliar
     *
     * Estável se na hora de comparar, na recursao, é só utilizar <=.
     */

    private Integer helper[];
    private Integer number[];

    public void mgSort(Integer[] values) {
        this.number = values;
        int numberSize = values.length;
        this.helper = new Integer[numberSize];
        mergeSort(0, numberSize - 1);
        }

    public void mergeSort(int begin, int end){
        //begin < end ?? Se não, o array está ordenado
        if(begin < end){
            //obtem o indice de elemento central
            int meio = begin + (end - begin) / 2;
            //ordena o lado esquerdo recursivamente
            mergeSort(begin, meio);
            //ordena o lado direito recursivamente
            mergeSort(meio + 1, end);
            //combina os lados
            merge(begin, meio, end);
        }
    }

    private void merge(int begin, int meio, int end){

        // Copia 2 partes no array helper
        for (int i = begin; i <= end; i++)
            helper[i] = number[i];


        int i = begin;
        int j = meio + 1;
        int k = begin;

        // Copia os menores valores (esquerda e direita) de volta no vetor original
        while (i <= meio && j <= end) {
            //incrementa o subvetor onde o elemento foi menor
            if (helper[i] <= helper[j]) {
                number[k] = helper[i];
                i++;
            }else{
                number[k] = helper[j];
                j++;
            }
        k++;
        }

        //se um dos vetores terminou, copia o resto do outro (tbm ja esta ordenado)
        // Copia o resto do lado esquerdo do array no vetor original
        while (i <= meio) {
            number[k] = helper[i];
            k++;
            i++;
        }

        // Copia o resto do lado direito do array no vetor original
        while (j <= end) {
            number[k] = helper[j];
            k++;
            j++;
        }
    }



    /*
     * QuickSort
     * A partir de um pivô, rearranjar as chaves de modo que as chaves
     * "menores" precedam as chaves "maiores". Em seguida o Quicksort
     * ordena as duas sublistas de chaves menores e maiores recursivamente
     * até que a lista completa se encontre ordenada.
     *
     * Pior caso: o pivô é escolhido como sendo um dos extremos de um
     * arquivo já ordenado (menor ou maior elemento). Isso gera:
     *  Partições desiguais
     *  QuickSort seja chamado recursivamente n vezes,eliminando apenas um item em cada chamada.
     *
     * Melhor caso: o pivô é escolhido e a partição produz dois subvetores de mesmo tamanho.
     * Altura da arvore = log n
     * Cada nível executa n comparações, portanto o custo de quicksort é C(n) = n(lg n)
     *
     * Método não estável
     */

    private int partition(Integer v[], int begin, int end){
        int pivo, half, i;

        //Processo de Escolha do Pivo
        pivo = v[begin];
        half = begin;
        //recebe tam - 1 como valor de partida
        for(i = begin + 1; i <= end; i++){
            if(v[i] < pivo){
                v[half] = v[i];
                v[i] = v[half + 1];
                half++;
            }
        }

        v[half] = pivo;

        //retorna o indice do pivo
        return half;
    }

    private void quickSortHelp(Integer v[], int begin, int end){
        int half;
        if(begin < end){
            half = partition(v, begin, end);
            //É até half-1, pois o pivô já vai está na sua posição ordenado,
            //pois tudo que tá a esquerda dele é menor e a direita é maior.
            quickSortHelp(v, begin, half - 1);
            quickSortHelp(v, half + 1, end);
        }
    }

    public void quickSort(Integer[] v){quickSortHelp(v, 0, v.length - 1);}

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

    private void maxHeapify(Integer[] a, int i, int n){

        //no slide i=1 é == pos
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

    public void buildHeap(Integer a[]){
        int n = a.length - 1;

        for(int i = (n / 2); i >= 0; i--)
            maxHeapify(a, i, n);
    }

    public void heapSort(Integer a[]){
        buildHeap(a);

        int n = a.length - 1;

        for(int i = n ; i > 0; i--){
            swap(a,0,i);
            n--;
            maxHeapify(a, 0, n);
        }
    }



}
