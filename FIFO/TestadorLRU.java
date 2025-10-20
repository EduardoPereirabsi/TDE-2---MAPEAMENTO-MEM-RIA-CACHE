import java.util.Arrays;

public class TestadorLRU {

    public static void main(String[] args) {
        final int NUMERO_QUADROS = 8;

        int[] sequencia1 = {4, 3, 25, 8, 19, 6, 25, 8, 16, 35, 45, 22, 8, 3, 16, 25, 7};
        int[] sequencia2 = {4, 5, 7, 9, 46, 45, 14, 4, 64, 7, 65, 2, 1, 6, 8, 45, 14, 11};
        int[] sequencia3 = {4, 6, 7, 8, 1, 6, 10, 15, 16, 4, 2, 1, 4, 6, 12, 15, 16, 11};

        System.out.println("=== TESTE DO ALGORITMO LRU ===");
        System.out.println("Número de quadros: " + NUMERO_QUADROS);

        testarSequencia(sequencia1, NUMERO_QUADROS, 7);
        testarSequencia(sequencia2, NUMERO_QUADROS, 11);
        testarSequencia(sequencia3, NUMERO_QUADROS, 11);
    }

    private static void testarSequencia(int[] sequencia, int quadros, int paginaBuscada) {
        System.out.println("\nSequência: " + Arrays.toString(sequencia));
        System.out.println("Página buscada no final: " + paginaBuscada);

        AlgoritmoLRU lru = new AlgoritmoLRU(quadros);
        lru.processarSequencia(sequencia);

        int quadro = lru.encontrarQuadroDaPagina(paginaBuscada);
        System.out.println("\nResultado:");
        System.out.println("Total de falhas de página: " + lru.getFalhasPagina());
        System.out.println("Página " + paginaBuscada + " encontrada em: " + (quadro >= 0 ? "Quadro " + quadro : "Não encontrada"));
    }
}