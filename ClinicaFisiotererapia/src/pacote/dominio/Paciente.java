package pacote.dominio;

import java.util.Date;

public class Paciente extends Pessoa{
    private Integer idPaciente;
    private String convenio;

    public Paciente(String nome, Date nascimento, String genero, String cpf, String telefone, String convenio) {
        super(nome, nascimento, genero, cpf, telefone);
        this.convenio = convenio;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    
}