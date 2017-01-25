
public class InsertionSort {
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

    public static void sort(Integer v[]){
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
}