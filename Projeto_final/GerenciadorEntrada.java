import java.util.Scanner;

import java.util.AbstractMap.SimpleEntry;

public class GerenciadorEntrada {

    private static Scanner scanner = new Scanner(System.in);

    public static SimpleEntry<String, CarregadorParametros> obterLinha(){

        String comando = scanner.next();

        String[] line = scanner.nextLine().trim().split(" ");

        CarregadorParametros parametros = null;

        if(line.length == 0){
            parametros = new CarregadorParametros();
        } else if(line.length == 1){
            parametros = new CarregadorParametros(line[0]);
        } else if(line.length == 2){
            parametros = new CarregadorParametros(line[0], line[1]);
        }

        return new SimpleEntry<>(comando, parametros);
    }
}
