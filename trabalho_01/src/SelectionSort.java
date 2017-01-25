
public class SelectionSort {
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

    public static void sort(Integer v[]){
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
}