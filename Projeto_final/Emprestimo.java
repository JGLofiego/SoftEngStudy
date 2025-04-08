import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private boolean emAndamento;
    private LocalDate dataEmprestimo;
    private LocalDate dataMaximaDevolucao;
    private LocalDate dataDevolucao = null;

    public Emprestimo(Usuario usuario, Exemplar exemplar, EmprestimoStrategy estrategia){
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.emAndamento = true;
        this.dataEmprestimo = LocalDate.now();
        this.dataMaximaDevolucao = dataEmprestimo.plusDays(estrategia.getPrazoDias());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Livro getLivroDoExemplar(){
        return this.exemplar.getLivro();
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataMaximaDevolucao() {
        return dataMaximaDevolucao;
    }

    public boolean estaEmAndamento(){
        return this.emAndamento;
    }

    public void setFinalizado(){
        this.emAndamento = false;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate data){
        this.dataDevolucao = data;
    }

    public boolean estaAtrasado(){
        return this.emAndamento && this.dataMaximaDevolucao.isBefore(LocalDate.now());
    }
}
