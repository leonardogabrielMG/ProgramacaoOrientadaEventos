package pacote.dominio;

import java.util.Date;

public class Fisioterapeuta extends Pessoa{
    
    private Integer idFisioterapeuta;
    private String crefito;
    private String especialidade;

    public Fisioterapeuta(String nome, Date nascimento, String genero, String cpf, String telefone, String crefito, String especialidade) {
        super(nome, nascimento, genero, cpf, telefone);
        this.crefito = crefito;
        this.especialidade = especialidade;
    }

    public Integer getIdFisioterapeuta() {
        return idFisioterapeuta;
    }

    public void setIdFisioterapeuta(Integer idFisioterapeuta) {
        this.idFisioterapeuta = idFisioterapeuta;
    }

    public String getCrefito() {
        return crefito;
    }

    public void setCrefito(String crefito) {
        this.crefito = crefito;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    

}
