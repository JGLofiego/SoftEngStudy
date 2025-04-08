import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class Cliente {
  private String nome;
  private Collection<Aluguel> fitasAlugadas = new Vector<Aluguel>();
  
  public Cliente(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }
  public void adicionaAluguel(Aluguel aluguel) {
    fitasAlugadas.add(aluguel);
  }

  public String extrato() {
    final String fimDeLinha = System.getProperty("line.separator");
    double valorTotal = 0.0;
    int pontosDeAlugadorFrequente = 0;
    
    String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
    
    Iterator<Aluguel> alugueis = fitasAlugadas.iterator();
    while(alugueis.hasNext()) {
      double valorCorrente = 0.0;
      Aluguel cada = alugueis.next();

      switch(cada.getFita().getCodigoDePreco()) {
      case Fita.NORMAL:
        valorCorrente += 2;
        if(cada.getDiasAlugada() > 2) {
          valorCorrente += (cada.getDiasAlugada() - 2) * 1.5;
        }
        break;
      case Fita.LANCAMENTO:
        valorCorrente += cada.getDiasAlugada() * 3;
      break;
      case Fita.INFANTIL:
        valorCorrente += 1.5;
        if(cada.getDiasAlugada() > 3) {
          valorCorrente += (cada.getDiasAlugada() - 3) * 1.5;
        }
        break;
      } // fim do switch

      pontosDeAlugadorFrequente++;
      if(cada.getFita().getCodigoDePreco() == Fita.LANCAMENTO &&  
         cada.getDiasAlugada() > 1) {
           pontosDeAlugadorFrequente++;
      }

      resultado += cada.getFita().getTitulo() + ":" + valorCorrente + fimDeLinha;
      valorTotal += valorCorrente;
    } // fim do while
    
    resultado += "Valor total devido: " + valorTotal + fimDeLinha;
    resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos" + fimDeLinha;
    return resultado;
  }
}

