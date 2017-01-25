public class MergeSort {
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

    private static Integer helper[];
    private static Integer number[];

    public static void sort(Integer[] values) {
        number = values;
        int numberSize = values.length;
        helper = new Integer[numberSize];
        mergeSort(0, numberSize - 1);
        }

    private static void mergeSort(int begin, int end){
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

    private static void merge(int begin, int meio, int end){

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
}