public class QuickSort {
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

    private static int partition(Integer v[], int begin, int end){
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

    private static void quickSortHelp(Integer v[], int begin, int end){
        int half;
        if(begin < end){
            half = partition(v, begin, end);
            //É até half-1, pois o pivô já vai está na sua posição ordenado,
            //pois tudo que tá a esquerda dele é menor e a direita é maior.
            quickSortHelp(v, begin, half - 1);
            quickSortHelp(v, half + 1, end);
        }
    }

    public static void sort(Integer[] v){quickSortHelp(v, 0, v.length - 1);}
}