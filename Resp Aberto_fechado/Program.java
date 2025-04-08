package console;

import java.util.*;
import modelo.*;

public class Program {

	public static void main(String[] args) {
		List<ICandidato> candidatos = new ArrayList<ICandidato>();
	    candidatos.add(new CandidatoGeral("Carlos", "Silva"));
	    candidatos.add(new CandidatoGerente("Maria", "Souza"));
	    candidatos.add(new CandidatoGeral("Ana", "Lopes"));

	    List<Empregado> empregados = new ArrayList<Empregado>();
	    ICriadorContas criadorContas;

	    for (ICandidato candidato: candidatos)
	    {
	    	criadorContas = candidato.obterCriadorContas();
	        empregados.add(criadorContas.criar(candidato));
	    }

	    for (Empregado empregado: empregados)
	    {
	        System.out.println(empregado.getNome() + " " + empregado.getSobrenome() + " " + empregado.getEmail());
	    }

	}

}
