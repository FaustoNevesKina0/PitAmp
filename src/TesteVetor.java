import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class JOptionPaneInitialize {

    //Criar um vetor de tamanho e valores baseado nas escolhas do usuário
    //Ordenar o array de forma mais simples o possível (bubble sort, no caso)
    //Como o array foi ordenado por bubble sort, o primeiro valor é o MENOR valor no array e o último valor, o maior
    //Realizar as operações de maior soma

    public static int arraySize = 8;//Olá! Por favor, insira AQUI o tamanho desejado do vetor
    static int i = 0;
    private static List<JTextField> textfields = new ArrayList<>(arraySize);
    private JPanel panel;
    static int[] queridoVetor = new int[arraySize];
    public static int menorSomaPossivel = 0;
    public static int maiorSomaPossivel = 0;

    public JOptionPaneInitialize() {
        panel = new JPanel();

        for (int i = 0; i < arraySize; i++) {
            JTextField textfield = new JTextField(5);
            textfields.add(textfield);
            panel.add(new JLabel(Integer.toString(i + 1) + ": "));
            panel.add(textfield);
        }

    }

    private static void createAndShowGUI() {
        JOptionPaneInitialize telaDeOpcoes = new JOptionPaneInitialize();
        int result = JOptionPane.showConfirmDialog(null, telaDeOpcoes.panel,
                "Insira os valores do array", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            for (JTextField textfield : telaDeOpcoes.textfields) {
                queridoVetor[i] = Integer.parseInt(textfield.getText());
                System.out.println(queridoVetor[i] + "");
                i++;
            }

            Arrays.sort(queridoVetor); //Agora que o vetor está ordenado de forma crescente, podemos realizar as operações sem muitas dificuldades

            for (int elementoDaVez : queridoVetor) {
                if (elementoDaVez != queridoVetor[0]) {
                    //Eliminamos o primeiro valor, pois este é o MENOR valor do vetor
                    maiorSomaPossivel += elementoDaVez;
                }
            }

            for (int elementoDaVez : queridoVetor) {
                if (elementoDaVez != queridoVetor[arraySize - 1]) {
                    //Eliminamos o último valor, pois este é o MAIOR valor do vator
                    menorSomaPossivel += elementoDaVez;
                }
            }
            String resultados = "Maior soma possível: " + maiorSomaPossivel + "\n" +
                    "Menor soma possível: " + menorSomaPossivel;
            JOptionPane.showMessageDialog(null, resultados);
            System.out.println("Maior soma possível: " + maiorSomaPossivel);
            System.out.println("Menor soma possível: " + menorSomaPossivel);
        }
    }

    public static void main(String[] args) {
        //Esta operação é realizada fora da Thread principal (para não travá-la) e serve apenas executar a parada toda
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}