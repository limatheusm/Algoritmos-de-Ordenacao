# Trabalho Ordenação 1

## Algoritmos
- 1 - Selection Sort
- 2 - Insertion Sort
- 3 - Merge Sort
- 4 - Quick Sort
- 5 - Heap Sort

## Instruções
### Utilizando MakeFile
- Execute o makefile e passe como parâmetros:
<br/>
Algoritmo desejado, o arquivo de entrada(vetor a ser ordenado) e a saída(vetor ordenado).
```sh
    $ make ALG="1" IN="example.in" OUT="saida.out"
```

- Caso queira a saída direta no prompt, faça:
```sh
    $ make IN="example.in" ALG="1" run
```
### Utilizando Script
- Também é possível compilar/executar pelo script, tomando como exemplo o algoritmo merge sort, arquivo entrada (example.in) e arquivo saída (saida.out), basta fazer:
<br/>
```sh
    $ bash script.sh 3 < example.in > saida.out
```

### Utilizando javac
```sh
    $ javac Main.java
    $ java Main 3 < example.in > saida.out
```
## Padrões para teste
Seguem o padrão do arquivo "example.in" no dir "src", ou seja, o primeiro valor determina a quantidade de elementos do vetor e cada valor do vetor está apos uma quebra de linha.
