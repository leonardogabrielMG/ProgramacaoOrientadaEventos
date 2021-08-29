package pacote.dominio;

import java.util.Date;

public class Consulta {
    private Integer idConsulta;
    private String nomePaciente;
    private String nomeFisioterapeuta;
    private Date data;
    private String descricao;
    private String status;

    public Consulta(String nomePaciente, String nomeFisioterapeuta, Date data, String descricao, String status) {
        this.nomePaciente = nomePaciente;
        this.nomeFisioterapeuta = nomeFisioterapeuta;
        this.data = data;
        this.descricao = descricao;
        this.status = status;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeFisioterapeuta() {
        return nomeFisioterapeuta;
    }

    public void setNomeFisioterapeuta(String nomeFisioterapeuta) {
        this.nomeFisioterapeuta = nomeFisioterapeuta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
