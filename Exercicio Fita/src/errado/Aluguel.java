package errado;
public class Aluguel {
  private Fita fita;
  private int diasAlugada;

  public Aluguel(Fita fita, int diasAlugada) {
    this.fita = fita;
    this.diasAlugada = diasAlugada;
  }

  public Fita getFita() {
    return fita;
  }

  public int getCodigoDePrecoDaFita() {
    return this.fita.getCodigoDePreco();
  }

  public String getTituloDaFita(){
    return this.fita.getTitulo();
  }

  public int getDiasAlugada() {
    return diasAlugada;
  }
}

