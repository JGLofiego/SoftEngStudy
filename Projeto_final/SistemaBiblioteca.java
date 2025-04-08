import java.util.AbstractMap.SimpleEntry;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        System.out.println("\nBem-vindo ao Sistema da Biblioteca!\n");

        while (true) {
            SimpleEntry<String, CarregadorParametros> entrada = GerenciadorEntrada.obterLinha();

            interfaceUsuario.executarComando(entrada.getKey(), entrada.getValue());
        }
    }
}