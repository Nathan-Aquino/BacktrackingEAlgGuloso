import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BacktrackingEAlgGuloso {
    public static List<List<Integer>> gerarSubconjuntos(List<Integer> S, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        backtrack(S, n, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    private static void backtrack(List<Integer> S, int n, int inicio, List<Integer> atual, List<List<Integer>> resultado) {
        if (atual.size() == n) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        for (int i = inicio; i < S.size(); i++) {
            // Add o elemento atual ao subconjunto
            atual.add(S.get(i));
            // chamada recursiva
            backtrack(S, n, i + 1, atual, resultado);
            // Remove o elemento
            atual.remove(atual.size() - 1);
        }
    }

    public static List<Integer> calcularTroco(int quantia, int[] moedasDisponiveis) {
        Arrays.sort(moedasDisponiveis);
        int[] moedas = new int[moedasDisponiveis.length];
        for (int i = 0; i < moedasDisponiveis.length; i++) {
            moedas[i] = moedasDisponiveis[moedasDisponiveis.length - 1 - i];
        }

        List<Integer> resultado = new ArrayList<>();

        //alg. guloso xD
        for (int moeda : moedas) {
            while (quantia >= moeda) {
                quantia -= moeda;
                resultado.add(moeda);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        /* BackTracking */

        List<Integer> S1 = List.of(1, 2, 3);
        int n1 = 2;
        System.out.println("Saída: " + gerarSubconjuntos(S1, n1));

        List<Integer> S2 = List.of(1, 2, 3, 4);
        int n2 = 1;
        System.out.println("Saída: " + gerarSubconjuntos(S2, n2));

        //---------------------------------------------------------------------

        /* Alg. Guloso */

        int quantia = 18;
        int[] moedasDisponiveis = {5, 2, 1};

        List<Integer> troco = calcularTroco(quantia, moedasDisponiveis);

        System.out.println("moedas: " + troco);
        System.out.println("Total de moedas: " + troco.size());

        //---------------------------------------------------------------------
    }
}
