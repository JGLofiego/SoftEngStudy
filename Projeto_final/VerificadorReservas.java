import java.util.ArrayList;

public class VerificadorReservas {
    public static boolean usuarioPodeReservar(Usuario usuario, ArrayList<Reserva> reservas){
        return reservas.size() < 3;
    }

    public static boolean precisaNotificar(int numReservas){
        return numReservas > 2;
    }
}
