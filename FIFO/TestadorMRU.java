public class TestadorMRU {
    
    public static void main(String[] args) {
        
        final int NUMERO_QUADROS = 8;
        
        int[] sequencia1 = {4, 3, 25, 8, 19, 6, 25, 8, 16, 35, 45, 22, 8, 3, 16, 25, 7};
        int[] sequencia2 = {4, 5, 7, 9, 46, 45, 14, 4, 64, 7, 65, 2, 1, 6, 8, 45, 14, 11};
        int[] sequencia3 = {4, 6, 7, 8, 1, 6, 10, 15, 16, 4, 2, 1, 4, 6, 12, 15, 16, 11};
        
        System.out.println("  TESTE DO ALGORITMO MRU                                       ");
        System.out.println("  Número de quadros: " + NUMERO_QUADROS + "                                         ");
        System.out.println("\n");
        
        System.out.println("\n");
        System.out.println("  SEQUÊNCIA 1: Qual quadro possui a página 7?                 ");
        
        System.out.println("Sequência: ");
        System.out.println("Página buscada no final: 7\n");
        
        AlgoritmoMRU mru1 = new AlgoritmoMRU(NUMERO_QUADROS);
        mru1.processarSequencia(sequencia1);
        int quadro1 = mru1.encontrarQuadroDaPagina(7);
        
        System.out.println("RESULTADO - MRU");
        System.out.println("Total de falhas de página: " + mru1.getFalhasPagina());
        System.out.println("Página 7 encontrada no: " + (quadro1 >= 0 ? "Quadro " + quadro1 : "Não encontrada"));
        
        System.out.println("  SEQUÊNCIA 2: Qual quadro possui a página 11?                ");
        
        System.out.println("Sequência: ");
        System.out.println("Página buscada no final: 11\n");
        
        AlgoritmoMRU mru2 = new AlgoritmoMRU(NUMERO_QUADROS);
        mru2.processarSequencia(sequencia2);
        int quadro2 = mru2.encontrarQuadroDaPagina(11);
        
        System.out.println("RESULTADO - MRU");
        System.out.println("Total de falhas de página: " + mru2.getFalhasPagina());
        System.out.println("Página 11 encontrada no: " + (quadro2 >= 0 ? "Quadro " + quadro2 : "Não encontrada"));
        
        System.out.println("\n\n");
        System.out.println("SEQUÊNCIA 3: Qual quadro possui a página 11?                ");

        
        System.out.println("Sequência: ");
        System.out.println("Página buscada no final: 11\n");
        
        AlgoritmoMRU mru3 = new AlgoritmoMRU(NUMERO_QUADROS);
        mru3.processarSequencia(sequencia3);
        int quadro3 = mru3.encontrarQuadroDaPagina(11);
        
        System.out.println("\n");
        System.out.println("RESULTADO - MRU");
        System.out.println("Total de falhas de página: " + mru3.getFalhasPagina());
        System.out.println("Página 11 encontrada no: " + (quadro3 >= 0 ? "Quadro " + quadro3 : "Não encontrada"));
    }
}

