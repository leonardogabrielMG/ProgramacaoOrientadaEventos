package pacote.dominio;
public class Avaliacao {
    private Integer idAvaliacao;
    private Integer idConsultaRef;
    private String exercicioRealizado;
    private String observacao;
    private String evolucao;
    private Integer minutosExercitando;

    public Avaliacao(Integer idConsultaRef, String exercicioRealizado, String observacao, String evolucao, Integer minutosExercitando) {
        this.idConsultaRef = idConsultaRef;
        this.exercicioRealizado = exercicioRealizado;
        this.observacao = observacao;
        this.evolucao = evolucao;
        this.minutosExercitando = minutosExercitando;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getIdConsultaRef() {
        return idConsultaRef;
    }

    public void setIdConsultaRef(Integer idConsultaRef) {
        this.idConsultaRef = idConsultaRef;
    }

    public String getExercicioRealizado() {
        return exercicioRealizado;
    }

    public void setExercicioRealizado(String exercicioRealizado) {
        this.exercicioRealizado = exercicioRealizado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public Integer getMinutosExercitando() {
        return minutosExercitando;
    }

    public void setMinutosExercitando(Integer minutosExercitando) {
        this.minutosExercitando = minutosExercitando;
    }
    
     
}
