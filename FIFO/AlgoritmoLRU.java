import java.util.HashMap;
import java.util.Map;

public class AlgoritmoLRU {
    
    private int[] quadros;
    private int numeroQuadros;
    private Map<Integer, Integer> mapaUltimoUso;
    private int contadorTempo;
    private int falhasPagina;
    
    public AlgoritmoLRU(int numeroQuadros) {
        this.numeroQuadros = numeroQuadros;
        this.quadros = new int[numeroQuadros];
        this.mapaUltimoUso = new HashMap<>();
        this.contadorTempo = 0;
        this.falhasPagina = 0;
        
        for (int i = 0; i < numeroQuadros; i++) {
            quadros[i] = -1;
        }
    }

    private int encontrarPaginaNaMemoria(int pagina) {
        for (int i = 0; i < numeroQuadros; i++) {
            if (quadros[i] == pagina) {
                return i;
            }
        }
        return -1;
    }
  
    private int encontrarQuadroVazio() {
        for (int i = 0; i < numeroQuadros; i++) {
            if (quadros[i] == -1) {
                return i;
            }
        }
        return -1;
    }
   
    private int encontrarQuadroLRU() {
        int quadroLRU = 0;
        int menorTempoUso = Integer.MAX_VALUE;
        
        for (int i = 0; i < numeroQuadros; i++) {
            int paginaQuadro = quadros[i];
            if (paginaQuadro != -1) {
                int tempoUso = mapaUltimoUso.get(paginaQuadro);
                if (tempoUso < menorTempoUso) {
                    menorTempoUso = tempoUso;
                    quadroLRU = i;
                }
            }
        }
        
        return quadroLRU;
    }

    public void processarSequencia(int[] sequenciaPaginas) {
        System.out.println("=== ALGORITMO LRU (Least Recently Used) ===");
        System.out.println("Número de quadros: " + numeroQuadros);
        System.out.println("\nSequência de páginas:");
        
        for (int i = 0; i < sequenciaPaginas.length; i++) {
            int paginaAtual = sequenciaPaginas[i];
            contadorTempo++;
            
            System.out.print("\nPágina " + paginaAtual + " (tempo=" + contadorTempo + "): ");
            int quadroExistente = encontrarPaginaNaMemoria(paginaAtual);
            
            if (quadroExistente != -1) {
                System.out.print("(HIT) ");
                mapaUltimoUso.put(paginaAtual, contadorTempo);
            } else {
                falhasPagina++;
                System.out.print("(MISS) ");

                int quadroVazio = encontrarQuadroVazio();
                
                if (quadroVazio != -1) {
                    quadros[quadroVazio] = paginaAtual;
                    mapaUltimoUso.put(paginaAtual, contadorTempo);
                } 
                else {
                    int quadroSubstituir = encontrarQuadroLRU();
                    int paginaSubstituida = quadros[quadroSubstituir];
                    
                    System.out.print("(Substitui página " + paginaSubstituida + 
                                   " (último uso=" + mapaUltimoUso.get(paginaSubstituida) + 
                                   ") no quadro " + quadroSubstituir + ") ");
                    
                    mapaUltimoUso.remove(paginaSubstituida);
                    quadros[quadroSubstituir] = paginaAtual;
                    mapaUltimoUso.put(paginaAtual, contadorTempo);
                }
            }
            
            mostrarEstadoMemoria();
        }
        
        System.out.println("\n\nTotal de falhas de página: " + falhasPagina);
    }
    
    private void mostrarEstadoMemoria() {
        System.out.print("Memória: [");
        for (int i = 0; i < numeroQuadros; i++) {
            if (quadros[i] == -1) {
                System.out.print(" - ");
            } else {
                int tempoUso = mapaUltimoUso.get(quadros[i]);
                System.out.print(" " + quadros[i] + "(" + tempoUso + ") ");
            }
            if (i < numeroQuadros - 1) {
                System.out.print("|");
            }
        }
        System.out.print("]");
    }
    
    public int encontrarQuadroDaPagina(int pagina) {
        for (int i = 0; i < numeroQuadros; i++) {
            if (quadros[i] == pagina) {
                return i;
            }
        }
        return -1;
    }

    public int getFalhasPagina() {
        return falhasPagina;
    }

    public int[] getQuadros() {
        return quadros.clone();
    }
}
