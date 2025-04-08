import java.util.ArrayList;

public class GerenciadorExemplares {
    private ArrayList<Exemplar> exemplares;

    public GerenciadorExemplares(){
        this.exemplares = new ArrayList<>();
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public void adicionarExemplar(String idExemplar, boolean status, Livro livro){
        Exemplar e = new Exemplar(idExemplar, status, livro);

        this.exemplares.add(e);
    }

    public int exemplaresDisponiveis(){
        int count = 0;

        for(Exemplar e : this.exemplares){
            if(e.estaDisponivel()){
                count++;
            }
        }

        return count;
    }

    public boolean temExemplarDisponivel(){
        for(Exemplar e : this.exemplares){
            if(e.estaDisponivel()){
                return true;
            }
        }
        return false;
    }

    public Exemplar getExemplarDisponivel(){
        for(Exemplar e : this.exemplares){
            if(e.estaDisponivel()){
                return e;
            }
        }
        return null;
    }
}
